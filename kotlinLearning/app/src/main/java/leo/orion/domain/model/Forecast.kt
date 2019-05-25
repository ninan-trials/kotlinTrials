package leo.orion.domain.model

data class Forecast(
        val date: String,
        val description: String,
        val high: Int,
        val low: Int
        )