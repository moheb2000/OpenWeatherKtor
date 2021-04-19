import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.http.*

suspend fun main() {
    print("Enter City Name: ")
    val cityName = readLine() ?: "London"
    val response = currentWeather(city = cityName, token = "YOUR_TOKEN")
    val result = """
        *****OPEN WEATHER MAP*****
        City         : ${response.name}
        Country      : ${response.sys.country}
        Current temp : ${response.main.temp} C
        Max temp     : ${response.main.temp_max} C
        Min temp     : ${response.main.temp_min} C
        Pressure     : ${response.main.pressure}
    """.trimIndent()

    println(result)
}

private suspend fun currentWeather(city: String, units: String = "metric", token: String): CurrentWeather {
    val client = HttpClient(Apache) {
        engine {
            followRedirects = true
        }
        install(JsonFeature) {
            serializer = GsonSerializer {
                setPrettyPrinting()
            }
        }
    }
    val response: CurrentWeather = client.request {
        url("https://api.openweathermap.org/data/2.5/weather")
        method = HttpMethod.Get
        parameter("q", city)
        parameter("appid", token)
        parameter("units", units)
    }
    client.close()
    return response
}