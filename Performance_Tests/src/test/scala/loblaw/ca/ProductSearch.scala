package loblaw.ca

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import utils.Helpers

class ProductSearch extends Simulation with Helpers {

  val httpProtocol: HttpProtocolBuilder = http.baseUrl(baseURL)
  val scenarioBuilder = createScenarioBuilder("Product Search", "ProductSearch", "$..facets", 1, baseURL + "/search", "fields", "DEFAULT")
  injectionProfile(scenarioBuilder, httpProtocol)

}
