data class CurrentWeather(
    val coord: Coordinate,
    val weather: List<Weather>,
    val base: String,
    val main: Main,
    val visibility: String,
    val wind: Wind,
    val clouds: Clouds,
    val dt: Int,
    val sys: Sys,
    val timezone: Int,
    val id: Int,
    val name: String,
    val code: Int
)

data class Coordinate(
    val lon: Double,
    val lat: Double
)

data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

data class Main(
    val temp: Double,
    val feelsLike: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Double,
    val humidity: Double
)

data class Wind(
    val speed: Double,
    val deg: Double
)

data class Clouds(
    val all: Double
)

data class Sys(
    val type: Int,
    val id: Int,
    val country: String,
    val sunrise: String,
    val sunset: String
)