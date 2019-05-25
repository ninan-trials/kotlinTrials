package leo.orion.domain.mappers

import leo.orion.data.Forecast
import leo.orion.data.ForecastResult
import leo.orion.domain.model.ForecastList
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import leo.orion.domain.model.Forecast as ModelForecast

class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult) : ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country, convertListToDomain(forecast.list))
    }

    private fun convertListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed { index, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(index.toLong())
            convertItemToDomain(forecast, dt)
        }
    }

    private fun convertItemToDomain(forecast: Forecast, dt: Long): ModelForecast {
        return ModelForecast(convertDate(dt), forecast.weather[0].description, forecast.temp.max.toInt(), forecast.temp.min.toInt())
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date)
    }
}