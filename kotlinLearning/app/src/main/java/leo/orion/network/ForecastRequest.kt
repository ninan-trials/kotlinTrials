package leo.orion.network

import com.google.gson.Gson
import leo.orion.data.ForecastResult
import java.net.URL

class ForecastRequest(val zipCode: String) {
    /*
    "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7" +
            "APPID=2afad0c08fba13710457596c4f75921f&q=94043&mode=json&units=metric&cnt=7"
    * */
    companion object {
        private val APP_ID = "2afad0c08fba13710457596c4f75921f"
        private val BASE_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "${BASE_URL}&APP_ID=$APP_ID&q="
    }

    fun execute(): ForecastResult {
        val url = COMPLETE_URL + zipCode
        val jsonString = URL(url).readText()
        return Gson().fromJson(jsonString, ForecastResult::class.java)
    }

}

