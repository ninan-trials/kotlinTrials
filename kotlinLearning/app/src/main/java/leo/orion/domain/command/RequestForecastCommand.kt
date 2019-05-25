package leo.orion.domain.command

import leo.orion.domain.model.ForecastList
import leo.orion.domain.mappers.ForecastDataMapper
import leo.orion.domain.interfaces.Command
import leo.orion.network.ForecastRequest

class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }


}