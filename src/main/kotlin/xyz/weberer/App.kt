package xyz.weberer

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent

class App : RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    override fun handleRequest(input: APIGatewayProxyRequestEvent?, context: Context?): APIGatewayProxyResponseEvent {
        input?.let {
            return APIGatewayProxyResponseEvent().apply {
                statusCode = 200
                headers = mapOf("Content-type" to "application/json")
                body = getSummaryData()
            }
        }
        return APIGatewayProxyResponseEvent().apply { statusCode = 400 }
    }
}

//Build instructions \PartsPlatformAWS> ./gradlew shadowJar