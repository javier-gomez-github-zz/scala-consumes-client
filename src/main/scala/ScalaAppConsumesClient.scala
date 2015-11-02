import org.killbill.billing.client.actor.KillBillClient
import spray.http.{BasicHttpCredentials, HttpHeaders}

/**
 * Created by jgomez on 26/10/2015.
 */
object ScalaAppConsumesClient extends App {

  // KillBill API URL (if not specified in the constructor)
  val killBillUrl = "http://localhost:8080/1.0/kb"

  // KillBill API Headers (if not specified in the constructor)
  val headers = List(
    HttpHeaders.Authorization.apply(BasicHttpCredentials.apply("admin", "password")),
    HttpHeaders.RawHeader.apply("X-Killbill-CreatedBy", "admin"),
    HttpHeaders.RawHeader.apply("X-Killbill-ApiKey", "hootsuite"),
    HttpHeaders.RawHeader.apply("X-Killbill-ApiSecret", "hootsuite")
  )

  val client: KillBillClient = new KillBillClient(killBillUrl, headers)

  /**
   * Un-Cancel Subscription
   */
//  val response: String = client.unCancelSubscription(UUID.fromString("81585fed-ea4d-40f8-810d-9cc0f6a23c17"))
//  if (response.contains("200")) {
//    println(s"Subscription uncancelled succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
   * Cancel Subscription
   */
//  val response: String = client.cancelSubscription(UUID.fromString("81585fed-ea4d-40f8-810d-9cc0f6a23c17"))
//  if (response.contains("200")) {
//    println(s"Subscription cancelled succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
   * Update Subscription
   */
//  val subscription = Subscription.apply(Option.apply("e6f1a070-21d9-44b6-b4d6-b006f1c762ab"), None, Option.apply("312df6b3-452e-460d-ab76-2efc37a3f498"),
//    Option.apply("sub-kbanman"), None, Option.apply("Sports"), Option.apply(ProductCategory.BASE), Option.apply(BillingPeriod.MONTHLY), None,
//    Option.apply("DEFAULT"), None, None, None, None, None, None, List[EventSubscription](), List[PhasePriceOverride]())
//  val response: String = client.updateSubscription(subscription.asInstanceOf[Subscription], UUID.fromString("312df6b3-452e-460d-ab76-2efc37a3f498"))
//  if (response.contains("200")) {
//    println(s"Subscription updated succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
   * Create Subscription
   */
//  val subscription = Subscription.apply(Option.apply("e6f1a070-21d9-44b6-b4d6-b006f1c762ab"), None, None, Option.apply("sub-kbanman"), None,
//    Option.apply("Standard"), Option.apply(ProductCategory.BASE), Option.apply(BillingPeriod.ANNUAL), None, Option.apply("DEFAULT"), None,
//    None, None, None, None, None, List[EventSubscription](), List[PhasePriceOverride]())
//  val response: String = client.createSubscription(subscription.asInstanceOf[Subscription])
//  if (response.contains("201")) {
//    println(s"Subscription created succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
   * Get Subscription by Id
   */
//  println(s"Got Subscription: " + client.getSubscriptionById(UUID.fromString("312df6b3-452e-460d-ab76-2efc37a3f498")).asInstanceOf[Subscription])
  
  /**
   * Transfer Bundle to Account
   */
//  val bundle = Bundle.apply(Option.apply("65b148ea-a42b-4155-87df-42cfb8394d12"), None, None, None, None)
//  val response: String = client.transferBundleToAccount(bundle.asInstanceOf[Bundle], UUID.fromString("f6358626-e87b-4201-be29-b0d3c461ae3d"))
//  if (response.contains("201")) {
//    println(s"Bundle transferred succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
   * Get Account Bundles
   */
//  println("Account Bundles: " + client.getAccountBundles(UUID.fromString("df795e04-ca64-448b-ac01-ab58e8c85d0b"), "sub-jgomez"))

  /**
   * Search Bundles
   */
//  println("Bundles found with SearchKey 'sub-jgomez': " + client.searchBundles("sub-jgomez"))

  /**
   * Get Bundle by External Key
   */
//  val bundle: Bundle = client.getBundleByExternalKey("sub-jgomez").asInstanceOf[Bundle];
//  println(s"Got Bundle: " + bundle)

  /**
   * Get Bundle by Id
   */
//  val bundle: Bundle = client.getBundleById(UUID.fromString("90bdf03e-287d-4551-b168-5eb303cce151")).asInstanceOf[Bundle];
//  println(s"Got Bundle: " + bundle)

  /**
   * Get Bundles
   */
//  println(s"Bundles: " + client.getBundles(0, 3))

  /**
   * Get Tag Definitions
   */
//  println(s"Tag Definitions: " + client.getTagDefinitions())

  /**
   * Get Tag Definition by ID
   */
//  println(s"Tag Definition: " + client.getTagDefinition(UUID.fromString("00000000-0000-0000-0000-000000000001")))

  /**
   * Create Tag Definition
   */
//  val objectTypeList: List[ObjectType] = List(ObjectType.ACCOUNT)
//  val tagDefinition = TagDefinition.apply(None, Option.apply(false), Option.apply("name"), Option.apply("description"), Option.apply(objectTypeList))
//  val response: String = client.createTagDefinition(tagDefinition.asInstanceOf[TagDefinition])
//  if (response.contains("201")) {
//    println(s"Tag Definition created succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
   * Delete a Tag Definition
   */
//  val response: String = client.deleteTagDefinition(UUID.fromString("04023d85-51eb-435f-9666-e9896956f40b"))
//    if (response.contains("204")) {
//      println(s"Tag Definition deleted succesfully")
//    }
//    else {
//      println(s"An error occurred. Message: " + response)
//    }

  /**
   * Get Account Timeline
   */
//  println(s"Timeline: " + client.getAccountTimeline(UUID.fromString("df795e04-ca64-448b-ac01-ab58e8c85d0b")))

  /**
   * Update Email Notifications for Account
   */
//  val invoiceEmail = InvoiceEmail.apply(Option.apply("df795e04-ca64-448b-ac01-ab58e8c85d0b"), Option.apply(true))
//  val response: String = client.updateEmailNotificationsForAccount(invoiceEmail, UUID.fromString("df795e04-ca64-448b-ac01-ab58e8c85d0b"))
//  if (response.contains("200")) {
//    println(s"E-mail Notifications updated succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
   * Get Email Notifications for Account
   */
//  println("Email Notifications for Account: " + client.getEmailNotificationsForAccount(UUID.fromString("df795e04-ca64-448b-ac01-ab58e8c85d0b")));

  /**
   * Get Emails for Account
   */
//  println("Emails for Account: " + client.getEmailsForAccount(UUID.fromString("df795e04-ca64-448b-ac01-ab58e8c85d0b")));

  /**
   * Remove Email from Account
   */
//  val response: String = client.removeEmailFromAccount(UUID.fromString("df795e04-ca64-448b-ac01-ab58e8c85d0b"), "test@test2.com")
//  if (response.contains("200")) {
//    println(s"E-mail removed succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
   * Add Email to Account
   */
//  val accountEmail = AccountEmail.apply(Option.apply("df795e04-ca64-448b-ac01-ab58e8c85d0b"), Option.apply("test@test2.com"))
//  val response: String = client.addEmailToAccount(accountEmail, UUID.fromString("df795e04-ca64-448b-ac01-ab58e8c85d0b"))
//  if (response.contains("201")) {
//    println(s"E-mail added succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
   * Search Accounts
   */
//  println("Accounts found with SearchKey 'lalala': " + client.searchAccounts("lalala"))

  /**
    * Get Accounts
   */
//  println("Accounts: " + client.getAccounts())

  /**
   * Get Account By External Key
   */
//  val account: Account = client.getAccountByExternalKey("jgomez").asInstanceOf[Account];
//  println(s"Got Account: " + account)

  /**
   * Get Account by Id
   */
//  val account: Account = client.getAccountById(UUID.fromString("c848cfa4-f4fe-4b1b-906c-3d4e92eb44c3")).asInstanceOf[Account];
//  println(s"Got Account: " + account)

  /**
   * Create Account
   */
//  val account = Account.apply(None, Option.apply("kbanman"), None, None, Option.apply("Kelly Banman"), None, Option.apply("kbanman@velocitypartners.net"), None, Option.apply("USD"), None, Option.apply("UTC"), None, None, None, None, None, None, None, None, None, None, None)
//  val response: String = client.createAccount(account.asInstanceOf[Account])
//  if (response.contains("201")) {
//    println(s"Account created succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
   * Update Account
   */
//  val account = Account.apply(None, Option.apply("kbanman"), None, None, Option.apply("Kelly Banman"), None, Option.apply("kbanman2@velocitypartners.net"), None, Option.apply("USD"), None, Option.apply("UTC"), None, None, None, None, None, None, None, None, None, None, None)
//  val response: String = client.updateAccount(account.asInstanceOf[Account], UUID.fromString("2a68b33c-ce15-4c73-bf79-5df9d6d03042"))
//  if (response.contains("200")) {
//    println(s"Account updated succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }
}
