package loblaw.ca

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import utils.Helpers

class ProductDetail extends Simulation with Helpers {

  val httpProtocol: HttpProtocolBuilder = http.baseUrl(baseURL)
  val productCode: String = "/WC0I520000019_EA"
  val scenarioBuilder = createScenarioBuilder("Product Detail", "ProductDetail", "$..breadcrumbs", 1, baseURL + productCode, "field", "DEFAULT")
  injectionProfile(scenarioBuilder, httpProtocol)
}
