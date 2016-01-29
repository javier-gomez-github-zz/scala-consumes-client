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
//    + client.getAccountGroups(21752452L))

  /**
    * Get Account Groups By User Id
    */
//  println("Get Account Groups By User Id: "
//    + client.getAccountGroupsByUserId("1.trunkd2147559698"))

  /**
    * Set Session Id By Account Number
    */
//  println("Set Session Id By Account Number: "
//    + client.setSession(21752452L))

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
    * Assign Supplemental Plan to Account
    */
//  val options = Map("supp_plan_no" -> 10122070L)
//  println("Assign Supplemental Plan to Account: "
//    + client.assignSupplementalPlan(22533882L, options, Map()))

  /**
    * Modify Supplemental Plan of Account
    */
//  val options = Map("supp_plan_no" -> 10122070L)
//  val params = Map("num_plan_units" -> "2")
//  println("Modify Supplemental Plan of Account: "
//    + client.modifySupplementalPlan(22533882L, options, params))

  /**
    * Modify Supplemental Plan Units of Account
    */
//  val options = Map("supp_plan_no" -> 10122070L)
//  println("Modify Supplemental Plan Units of Account: "
//    + client.modifySupplementalPlanUnits(22533882L, options, 3L))

  /**
    * Modify Supplemental Plan Rate Schedule of Account
    */
//  val options = Map("supp_plan_no" -> 10122070L,
//  "alt_rate_schedule_no" -> 2L)
//  println("Modify Supplemental Plan Rate Schedule of Account: "
//    + client.modifySupplementalPlanRateSchedule(22533882L, options))

  /**
    * Replace Supplemental Plan of Account
    */
//  val options = Map("existing_supp_plan_no" -> 10122070L,
//    "new_supp_plan_no" -> 10122068L)
//  println("Replace Supplemental Plan of Account: "
//    + client.replaceSupplementalPlan(22533826L, options, Map()))

  /**
    * Cancel Supplemental Plan of Account
    */
//  val options = Map("supp_plan_no" -> 10122070L)
//  println("Cancel Supplemental Plan of Account: "
//    + client.cancelSupplementalPlan(22533826L, options, Map()))

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
//  val params = Map("first_name" -> "Javier", "last_name" -> "Gomez")
//  println("Update Account: " + client.updateAccount(22533826L, params))

  /**
    * Update Account Contact
    */
//  val params = Map("company_name" -> "Hootsuite Inc.")
//  println("Update Account Contact: " + client.updateAccountContact(22533826L, params))

  /**
    * Update Account Payment Method
    */
//  val params = Map("pay_method" -> "6")
//  println("Update Account Payment Method: " + client.updateAccountPaymentMethod(22533826L, params))

  /**
    * Apply Coupon to Account
    */
//  println("Apply Coupon to Account: " + client.applyCouponToAccount(22533826L, "2mnthprohsu50percent", Map()))

  /**
    * Update Account Supplemental Field
    */
//  println("Update Account Supplemental Field: " + client.updateAccountSupplementalField(22533826L, "enterprise_affiliate_code", "1234"))

  /**
    * Create Service Credit
    */
//  println("Create Service Credit: " + client.createServiceCredit(22533826L, 10, 1L, Map()))

  /**
    * Create Percentage Service Credit
    */
//  println("Create Percentage Service Credit: " + client.createPercentageServiceCredit(22533826L, 10122070L, 100, Map()))

  /**
    * Apply Cash Credit
    */
//  println("Apply Cash Credit: " + client.applyCashCredit(22533826L, 10, 22L, Map()))

  /**
    * Apply Service Credit
    */
//  println("Apply Service Credit: " + client.applyServiceCredit(22533826L, 10, 22L, Map()))

  /**
    * Transfer Account Balance
    */
//  println("Transfer Account Balance: " + client.transferAccountBalance(22533826L, 22533882L, Map()))

  /**
    * Get Account Number For User
    */
//  println("Get Account Number For User: " + client.getAccountNumberForUser("1.trunkd2147559698"))

  /**
    * Get Transaction History
    */
//  println("Get Transaction History: " + client.getTransactionHistory(22533826L, Map()))

  /**
    * Get Transaction History by Date
    */
//  println("Get Transaction History by Date: " + client.getTransactionHistoryByDate(19132946L, "", "", -1L, 1L))

  /**
    * Void Transaction for Account
    */
//  println("Void Transaction for Account: " + client.voidTransaction(22533826L, "130909298", 8L, "Voidedjgomez", Map()))

  /**
    * Get Invoice History
    */
//  val options = Map("acct_no" -> 22533826L)
//  println("Get Invoice History: " + client.getInvoiceHistory(options, Map()))

  /**
    * Get Invoice History By User Id
    */
//    println("Get Invoice History By User Id: " + client.getInvoiceHistoryByUserId("jgomez", Map()))

  /**
    * Generate Statement
    */
//  println("Generate Statement: " + client.generateStatement(19132946L))

  /**
    * Get Statement For Invoice
    */
//  val options = Map("acct_no" -> 19132946L)
//  println("Get Statement For Invoice: " + client.getStatementForInvoice(74321595L, options, Map()))

  /**
    * Get Invoice Details
    */
//  println("Get Invoice Details: " + client.getInvoiceDetails(19132946L, 74321595L))

  /**
    * Get Pending Invoice Number
    */
//  println("Get Pending Invoice Number: " + client.getPendingInvoiceNumber(19132946L))

  /**
    * Collect from Account
    */
//  println("Collect from Account: " + client.collectFromAccount(19132946L, 100, Map()))
}
