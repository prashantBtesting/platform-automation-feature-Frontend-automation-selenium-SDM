package loblaw.ca

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import utils.Helpers

class ProductListing extends Simulation with Helpers {

  val httpProtocol: HttpProtocolBuilder = http.baseUrl(baseURL)
  val scenarioBuilder = createScenarioBuilder("Product Listing", "Product Listing", "$..collection", 1, baseURL, "categoryCodes", "56025")
  injectionProfile(scenarioBuilder, httpProtocol)

}
