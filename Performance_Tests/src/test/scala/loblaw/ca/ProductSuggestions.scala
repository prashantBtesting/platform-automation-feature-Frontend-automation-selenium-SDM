package loblaw.ca

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import utils.Helpers

class ProductSuggestions extends Simulation with Helpers {

  val httpProtocol: HttpProtocolBuilder = http.baseUrl(baseURL)
  val scenarioBuilder = createScenarioBuilder("Product Suggestions", "ProductSuggestions", "$..suggestions", 1, baseURL + "/suggestions", "term", "shirt")
  injectionProfile(scenarioBuilder, httpProtocol)
}
