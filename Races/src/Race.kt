import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

fun main(args: Array<String>) {
    val input = getChallengeInput()

}

private fun getChallengeInput(): String {
    val url = URL("http://10.134.22.189:3000/challenge/input")

    val connection = url.openConnection()
    connection.setRequestProperty("Content-Type", "application/json")
    connection.setRequestProperty("userId", "mN1edz8oUn")
    var response: StringBuffer?;
    with(connection as HttpURLConnection) {
        // optional default is GET
        requestMethod = "GET"

        println("\nSending 'GET' request to URL : $url")
        println("Response Code : $responseCode")

        BufferedReader(InputStreamReader(inputStream)).use {
            response = StringBuffer()

            var inputLine = it.readLine()
            response!!.append(inputLine)
            return response.toString()
        }
    }
}