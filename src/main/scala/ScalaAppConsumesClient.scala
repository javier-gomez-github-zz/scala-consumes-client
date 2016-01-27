import com.aria.client.AriaClient

import scala.concurrent.{Await, Future}

/**
 * Created by jgomez on 26/10/2015.
 */
object ScalaAppConsumesClient extends App {

  // Aria API URL (if not specified in the constructor)
  val ariaUrl = "https://habanera.hootsuite.com/api/ws/api_ws_class_dispatcher.php"
  val client_no = 4615000L
  val auth_key = "HrK4AB56bWxX9tCyGydrQevF7tveFTPK"

  val client: AriaClient = new AriaClient(ariaUrl, client_no, auth_key)

  /**
    * Get Virtual Datetime
    */
//  println("Get Virtual Datetime: "
//    + client.getVirtualDatetime())

  /**
    * Advance Virtual Datetime
    */
//  println("Advance Virtual Datetime: "
//    + client.advanceVirtualDatetime(1L))

  /**
    * Assign Account to a Collections Account group
    */
//  val options = Map("group_no" -> 2L)
//  println("Assign Account to a Collections Account group: "
//    + client.assignCollectionsAccountGroup(21752452L, options))

  /**
    * Get Account Details
    */
//  println("Get Account Details: "
//    + client.getAccountDetails(21752452L))

  /**
    * Get Account Plans
    */
//  println("Get Account Plans: "
//    + client.getAccountPlans(21752452L, false))

  /**
    * Get Account Plan History
    */
//  println("Get Account Plan History: "
//    + client.getAccountPlanHistory(21752452L))

  /**
    * Get Rate Schedules for Plan
    */
//  val options = Map("plan_no" -> 10122064L)
//  println("Get Rate Schedules for Plan: "
//    + client.getRateSchedulesForPlan(options))

  /**
    * Get Client Plan Services
    */
//  val options = Map("plan_no" -> 10122064L)
//  println("Get Client Plan Services: "
//    + client.getClientPlanServices(options))

  /**
    * Get Client Plan Service Rates
    */
//  val options = Map("plan_no" -> 10122064L,
//  "service_no" -> 10011883L)
//
//  println("Get Client Plan Service Rates: "
//    + client.getClientPlanServiceRates(options))

  /**
    * Get Account Groups By Account Number
    */
//  println("Get Account Groups By Account Number: "
//    + client.getAccountGroupsByAcctNo(21752452L))

  /**
    * Get Account Groups By User Id
    */
//  println("Get Account Groups By User Id: "
//    + client.getAccountGroupsByUserId("1.trunkd2147559698"))

  /**
    * Set Session Id By Account Number
    */
//  println("Set Session Id By Account Number: "
//    + client.setSessionByAcctNo(21752452L))

  /**
    * Set Session Id By User Id
    */
//  println("Set Session Id By User Id: "
//    + client.setSessionByUserId("1.trunkd2147559698"))

  /**
    * Validate Session Id By Session Id
    */
//  println("Validate Session Id By Session Id: "
//    + client.validateSessionBySessionId("UXQPR8HQGBJYV7776FWK"))

  /**
    * Update Master Plan
    */
//  val options = Map("master_plan_no" -> 10726068L)
//  println("Update Master Plan: "
//    + client.updateMasterPlan(21752452L, options, Map()))

  /**
    * Update Account Status
    */
//  println("Update Account Status: "
//      + client.updateAccountStatus(21752452L, 10L, Map()))

  /**
    * Create Account
    */
//  val options = Map("master_plan_no" -> 10726068L)
//  val params = Map("password" -> "Password")
//  println("Create Account: " + client.createAccount("maguero", 31L, options, params))

  /**
    * Update Account
    */
//    val params = Map("first_name" -> "Javier", "last_name" -> "Gomez")
//    println("Update Account: " + client.updateAccount(22533826L, params))

  /**
    * Update Account Contact
    */
//    val params = Map("company_name" -> "Hootsuite Inc.")
//    println("Update Account Contact: " + client.updateAccountContact(22533826L, params))
}
