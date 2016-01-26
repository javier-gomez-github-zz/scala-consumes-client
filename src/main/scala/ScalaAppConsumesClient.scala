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
//    + client.getVirtualDatetime(4615000L, "HrK4AB56bWxX9tCyGydrQevF7tveFTPK", "get_virtual_datetime"))

  /**
    * Advance Virtual Datetime
    */
//  println("Advance Virtual Datetime: "
//    + client.advanceVirtualDatetime(1L, 4615000L, "HrK4AB56bWxX9tCyGydrQevF7tveFTPK", "advance_virtual_datetime"))

  /**
    * Assign Account to a Collections Account group
    */
//  println("Assign Account to a Collections Account group: "
//    + client.assignCollectionsAccountGroup(21752452L, "", 2L, 4615000L, "HrK4AB56bWxX9tCyGydrQevF7tveFTPK",
//    "assign_collections_acct_group"))

  /**
    * Get Account Details
    */
//  println("Get Account Details: "
//    + client.getAccountDetails(21752452L, 4615000L, "HrK4AB56bWxX9tCyGydrQevF7tveFTPK", "get_acct_details_all"))

  /**
    * Get Account Plans
    */
//  println("Get Account Plans: "
//    + client.getAccountPlans(21752452L, false, 4615000L, "HrK4AB56bWxX9tCyGydrQevF7tveFTPK"))

  /**
    * Get Account Plan History
    */
//  println("Get Account Plan History: "
//    + client.getAccountPlanHistory(21752452L, 4615000L, "HrK4AB56bWxX9tCyGydrQevF7tveFTPK", "get_acct_plan_history"))

  /**
    * Get Rate Schedules for Plan
    */
//  println("Get Rate Schedules for Plan: "
//    + client.getRateSchedulesForPlan("", 10122064L, 4615000L, "HrK4AB56bWxX9tCyGydrQevF7tveFTPK",
//    "get_rate_schedules_for_plan"))


  /**
    * Get Client Plan Services
    */
//  println("Get Client Plan Services: "
//    + client.getClientPlanServices("", 10122064L, 4615000L, "HrK4AB56bWxX9tCyGydrQevF7tveFTPK",
//    "get_client_plan_services"))

  /**
    * Get Client Plan Service Rates
    */
//  println("Get Client Plan Service Rates: "
//    + client.getClientPlanServiceRates("", 10122064L, "", 10011883L, "", -1L, 4615000L,
//    "HrK4AB56bWxX9tCyGydrQevF7tveFTPK", "get_client_plan_service_rates"))

  /**
    * Get Account Groups By Account Number
    */
//  println("Get Account Groups By Account Number: "
//    + client.getAccountGroupsByAcctNo(21752452L, 4615000L, "HrK4AB56bWxX9tCyGydrQevF7tveFTPK", "get_acct_groups_by_acct"))

  /**
    * Get Account Groups By User Id
    */
//  println("Get Account Groups By User Id: "
//    + client.getAccountGroupsByUserId("1.trunkd2147559698", 4615000L, "HrK4AB56bWxX9tCyGydrQevF7tveFTPK", "get_acct_groups_by_acct"))

  /**
    * Set Session Id By Account Number
    */
//  println("Set Session Id By Account Number: "
//    + client.setSessionByAcctNo(21752452L, 4615000L, "HrK4AB56bWxX9tCyGydrQevF7tveFTPK", "set_session"))

  /**
    * Set Session Id By User Id
    */
//  println("Set Session Id By User Id: "
//    + client.setSessionByUserId("1.trunkd2147559698", 4615000L, "HrK4AB56bWxX9tCyGydrQevF7tveFTPK", "set_session"))

}
