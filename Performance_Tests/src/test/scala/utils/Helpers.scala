package utils

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

trait Helpers extends Simulation {

  val baseURL: String = "https://jf-bff-api-dev.loblaw.digital/webapi/v2/joefresh.loblaw.ca/products";

  def createScenarioBuilder(scenarioName: String, requestName: String, path: String, pauseDuration: Int, url: String, queryParamName: String, queryParamValue: String): ScenarioBuilder = {
    /**
     * generic method for creating a scenario
     */
    val scene: ScenarioBuilder = scenario(scenarioName) // creating the scenario on which simulation will happen.
      .exec(http(requestName)
        .get(url)
        .header("accept", "application/json")
        .queryParam(queryParamName, queryParamValue)
        .check(status.is(200)) // status code assertion
        .check(jsonPath(path).findAll)) // asserting JSON
      .pause(pauseDuration)
    scene
  }

  def injectionProfile(scenarioBuilder: ScenarioBuilder, httpProtocol: HttpProtocolBuilder): Unit = {
    setUp(scenarioBuilder.inject(atOnceUsers(10)).protocols(httpProtocol))
  }
}
