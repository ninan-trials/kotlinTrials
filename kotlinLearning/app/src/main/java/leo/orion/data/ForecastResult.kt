package leo.orion.data

data class ForecastResult(
        val city: City,
        val list: List<Forecast>)