package loblaw.ca

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import utils.Helpers

class ProductCollection extends Simulation with Helpers {

  val httpProtocol: HttpProtocolBuilder = http.baseUrl(baseURL)
  val scenarioBuilder = createScenarioBuilder("Product Collection", "ProductCollection", "$..breadcrumbs", 1, baseURL + "/collection", "categoryCodes", "56025")
  injectionProfile(scenarioBuilder, httpProtocol)

}