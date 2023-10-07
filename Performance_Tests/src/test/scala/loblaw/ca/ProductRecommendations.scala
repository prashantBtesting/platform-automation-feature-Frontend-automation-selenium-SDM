package loblaw.ca

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import utils.Helpers

class ProductRecommendations extends Simulation with Helpers {

  val httpProtocol: HttpProtocolBuilder = http.baseUrl(baseURL)
  val scenarioBuilder = createScenarioBuilder("Product Recommendations", "ProductRecommendations", "$..recommendations", 1, baseURL + "/recommendations", "fields", "DEFAULT")
  injectionProfile(scenarioBuilder, httpProtocol)

}
