import org.killbill.billing.client.actor.KillBillClient
import spray.http.{MediaType, ContentType, BasicHttpCredentials, HttpHeaders}

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
    * Get Catalog as JSON
    */
//  println("Get JSON Catalog: " + client.getJSONCatalog())

  /**
    * Get Catalog as XML
    */
//  println("Get XML Catalog: " + client.getXMLCatalog())

  /**
    * Upload XML Catalog
    */
//  val xmlCatalog = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<!--\n  ~ Copyright 2010-2013 Ning, Inc.\n  ~\n  ~ Ning licenses this file to you under the Apache License, version 2.0\n  ~ (the \"License\"); you may not use this file except in compliance with the\n  ~ License.  You may obtain a copy of the License at:\n  ~\n  ~    http://www.apache.org/licenses/LICENSE-2.0\n  ~\n  ~ Unless required by applicable law or agreed to in writing, software\n  ~ distributed under the License is distributed on an \"AS IS\" BASIS, WITHOUT\n  ~ WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the\n  ~ License for the specific language governing permissions and limitations\n  ~ under the License.\n  --><!-- Use cases covered so far: Tiered Product (Pistol/Shotgun/Assault-Rifle) \n\tMultiple changeEvent plan policies Multiple PlanAlignment (see below, trial \n\tadd-on alignments and rescue discount package) Product transition rules Add \n\ton (Scopes, Hoster) Multi-pack addon (Extra-Ammo) Addon Trial aligned to \n\tbase plan (holster-monthly-regular) Addon Trial aligned to creation (holster-monthly-special) \n\tRescue discount package (assault-rifle-annual-rescue) Plan phase with a reccurring \n\tand a one off (refurbish-maintenance) Phan with more than 2 phase (gunclub \n\tdiscount plans) Use Cases to do: Tiered Add On Riskfree period --><catalog xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"CatalogSchema.xsd \"><effectiveDate>2011-01-01T00:00:00+00:00</effectiveDate><catalogName>Firearms</catalogName><recurringBillingMode>IN_ADVANCE</recurringBillingMode><currencies><currency>USD</currency><currency>EUR</currency><currency>GBP</currency></currencies><units><unit name=\"bullets\" /></units><products><product name=\"Blowdart\"><category>BASE</category></product><product name=\"Pistol\"><category>BASE</category><available><addonProduct>Cleaning</addonProduct><addonProduct>Bullets</addonProduct></available></product><product name=\"Shotgun\"><category>BASE</category><included><addonProduct>Cleaning</addonProduct></included><available><addonProduct>Telescopic-Scope</addonProduct><addonProduct>Laser-Scope</addonProduct><addonProduct>Holster</addonProduct><addonProduct>Bullets</addonProduct></available></product><product name=\"Assault-Rifle\"><category>BASE</category><included><addonProduct>Telescopic-Scope</addonProduct><addonProduct>Cleaning</addonProduct></included><available><addonProduct>Laser-Scope</addonProduct><addonProduct>Bullets</addonProduct></available></product><product name=\"Cleaning\"><category>ADD_ON</category></product><product name=\"Telescopic-Scope\"><category>ADD_ON</category></product><product name=\"Laser-Scope\"><category>ADD_ON</category></product><product name=\"Holster\"><category>ADD_ON</category></product><product name=\"Extra-Ammo\"><category>ADD_ON</category></product><product name=\"Refurbish-Maintenance\"><category>ADD_ON</category></product><product name=\"Bullets\"><category>ADD_ON</category></product></products><rules><changePolicy><changePolicyCase><phaseType>TRIAL</phaseType><policy>IMMEDIATE</policy></changePolicyCase><changePolicyCase><toPriceList>rescue</toPriceList><policy>END_OF_TERM</policy></changePolicyCase><changePolicyCase><toProduct>Assault-Rifle</toProduct><policy>IMMEDIATE</policy></changePolicyCase><changePolicyCase><fromProduct>Pistol</fromProduct><toProduct>Shotgun</toProduct><policy>IMMEDIATE</policy></changePolicyCase><changePolicyCase><toPriceList>rescue</toPriceList><policy>END_OF_TERM</policy></changePolicyCase><changePolicyCase><fromBillingPeriod>MONTHLY</fromBillingPeriod><toBillingPeriod>ANNUAL</toBillingPeriod><policy>IMMEDIATE</policy></changePolicyCase><changePolicyCase><fromBillingPeriod>ANNUAL</fromBillingPeriod><toBillingPeriod>MONTHLY</toBillingPeriod><policy>END_OF_TERM</policy></changePolicyCase><changePolicyCase><policy>END_OF_TERM</policy></changePolicyCase></changePolicy><changeAlignment><changeAlignmentCase><toPriceList>rescue</toPriceList><alignment>CHANGE_OF_PLAN</alignment></changeAlignmentCase><changeAlignmentCase><fromPriceList>rescue</fromPriceList><toPriceList>rescue</toPriceList><alignment>CHANGE_OF_PRICELIST</alignment></changeAlignmentCase><changeAlignmentCase><alignment>START_OF_SUBSCRIPTION</alignment></changeAlignmentCase></changeAlignment><cancelPolicy><cancelPolicyCase><phaseType>TRIAL</phaseType><policy>IMMEDIATE</policy></cancelPolicyCase><cancelPolicyCase><policy>END_OF_TERM</policy></cancelPolicyCase></cancelPolicy><createAlignment><createAlignmentCase><product>Laser-Scope</product><alignment>START_OF_SUBSCRIPTION</alignment></createAlignmentCase><createAlignmentCase><alignment>START_OF_BUNDLE</alignment></createAlignmentCase></createAlignment><billingAlignment><billingAlignmentCase><productCategory>ADD_ON</productCategory><alignment>BUNDLE</alignment></billingAlignmentCase><billingAlignmentCase><billingPeriod>ANNUAL</billingPeriod><alignment>SUBSCRIPTION</alignment></billingAlignmentCase><billingAlignmentCase><alignment>ACCOUNT</alignment></billingAlignmentCase></billingAlignment><priceList><priceListCase><fromPriceList>rescue</fromPriceList><toPriceList>DEFAULT</toPriceList></priceListCase></priceList></rules><plans><plan name=\"blowdart-monthly\"><product>Blowdart</product><initialPhases><phase type=\"TRIAL\"><duration><unit>DAYS</unit><number>30</number></duration><fixed><fixedPrice /></fixed></phase><phase type=\"DISCOUNT\"><duration><unit>MONTHS</unit><number>6</number></duration><recurring><billingPeriod>MONTHLY</billingPeriod><recurringPrice><price><currency>USD</currency><value>9.95</value></price><price><currency>EUR</currency><value>9.95</value></price><price><currency>GBP</currency><value>9.95</value></price></recurringPrice></recurring></phase></initialPhases><finalPhase type=\"EVERGREEN\"><duration><unit>UNLIMITED</unit></duration><recurring><billingPeriod>MONTHLY</billingPeriod><recurringPrice><price><currency>USD</currency><value>29.95</value></price><price><currency>EUR</currency><value>29.95</value></price><price><currency>GBP</currency><value>29.95</value></price></recurringPrice></recurring></finalPhase></plan><plan name=\"pistol-monthly\"><product>Pistol</product><initialPhases><phase type=\"TRIAL\"><duration><unit>DAYS</unit><number>30</number></duration><fixed><fixedPrice /></fixed></phase></initialPhases><finalPhase type=\"EVERGREEN\"><duration><unit>UNLIMITED</unit></duration><recurring><billingPeriod>MONTHLY</billingPeriod><recurringPrice><price><currency>GBP</currency><value>29.95</value></price><price><currency>EUR</currency><value>29.95</value></price><price><currency>USD</currency><value>29.95</value></price></recurringPrice></recurring></finalPhase></plan><plan name=\"shotgun-monthly\"><product>Shotgun</product><initialPhases><phase type=\"TRIAL\"><duration><unit>DAYS</unit><number>30</number></duration><fixed><fixedPrice /></fixed></phase></initialPhases><finalPhase type=\"EVERGREEN\"><duration><unit>UNLIMITED</unit><number>-1</number></duration><recurring><billingPeriod>MONTHLY</billingPeriod><recurringPrice><price><currency>USD</currency><value>249.95</value></price><price><currency>EUR</currency><value>149.95</value></price><price><currency>GBP</currency><value>169.95</value></price></recurringPrice></recurring></finalPhase></plan><plan name=\"assault-rifle-monthly\"><product>Assault-Rifle</product><initialPhases><phase type=\"TRIAL\"><duration><unit>DAYS</unit><number>30</number></duration><fixed><fixedPrice /></fixed></phase></initialPhases><finalPhase type=\"EVERGREEN\"><duration><unit>UNLIMITED</unit></duration><recurring><billingPeriod>MONTHLY</billingPeriod><recurringPrice><price><currency>USD</currency><value>599.95</value></price><price><currency>EUR</currency><value>349.95</value></price><price><currency>GBP</currency><value>399.95</value></price></recurringPrice></recurring></finalPhase></plan><plan name=\"pistol-quarterly\"><product>Pistol</product><initialPhases><phase type=\"TRIAL\"><duration><unit>DAYS</unit><number>30</number></duration><fixed><fixedPrice /></fixed></phase></initialPhases><finalPhase type=\"EVERGREEN\"><duration><unit>UNLIMITED</unit></duration><recurring><billingPeriod>QUARTERLY</billingPeriod><recurringPrice><price><currency>GBP</currency><value>69.95</value></price><price><currency>EUR</currency><value>69.95</value></price><price><currency>USD</currency><value>69.95</value></price></recurringPrice></recurring></finalPhase></plan><plan name=\"pistol-annual\"><product>Pistol</product><initialPhases><phase type=\"TRIAL\"><duration><unit>DAYS</unit><number>30</number></duration><fixed><fixedPrice /></fixed></phase></initialPhases><finalPhase type=\"EVERGREEN\"><duration><unit>UNLIMITED</unit></duration><recurring><billingPeriod>ANNUAL</billingPeriod><recurringPrice><price><currency>USD</currency><value>199.95</value></price><price><currency>EUR</currency><value>199.95</value></price><price><currency>GBP</currency><value>199.95</value></price></recurringPrice></recurring></finalPhase></plan><plan name=\"shotgun-annual\"><product>Shotgun</product><initialPhases><phase type=\"TRIAL\"><duration><unit>DAYS</unit><number>30</number></duration><fixed><fixedPrice /></fixed></phase></initialPhases><finalPhase type=\"EVERGREEN\"><duration><unit>UNLIMITED</unit></duration><recurring><billingPeriod>ANNUAL</billingPeriod><recurringPrice><price><currency>USD</currency><value>2399.95</value></price><price><currency>EUR</currency><value>1499.95</value></price><price><currency>GBP</currency><value>1699.95</value></price></recurringPrice></recurring></finalPhase></plan><plan name=\"assault-rifle-annual\"><product>Assault-Rifle</product><initialPhases><phase type=\"TRIAL\"><duration><unit>DAYS</unit><number>30</number></duration><fixed><fixedPrice /></fixed></phase></initialPhases><finalPhase type=\"EVERGREEN\"><duration><unit>UNLIMITED</unit></duration><recurring><billingPeriod>ANNUAL</billingPeriod><recurringPrice><price><currency>USD</currency><value>5999.95</value></price><price><currency>EUR</currency><value>3499.95</value></price><price><currency>GBP</currency><value>3999.95</value></price></recurringPrice></recurring></finalPhase></plan><plan name=\"pistol-annual-gunclub-discount\"><product>Pistol</product><initialPhases><phase type=\"TRIAL\"><duration><unit>DAYS</unit><number>30</number></duration><fixed><fixedPrice /></fixed></phase><phase type=\"DISCOUNT\"><duration><unit>MONTHS</unit><number>6</number></duration><recurring><billingPeriod>MONTHLY</billingPeriod><recurringPrice><price><currency>USD</currency><value>9.95</value></price><price><currency>EUR</currency><value>9.95</value></price><price><currency>GBP</currency><value>9.95</value></price></recurringPrice></recurring></phase></initialPhases><finalPhase type=\"EVERGREEN\"><duration><unit>UNLIMITED</unit></duration><recurring><billingPeriod>ANNUAL</billingPeriod><recurringPrice><price><currency>USD</currency><value>199.95</value></price><price><currency>EUR</currency><value>199.95</value></price><price><currency>GBP</currency><value>199.95</value></price></recurringPrice></recurring></finalPhase></plan><plan name=\"shotgun-annual-gunclub-discount\"><product>Shotgun</product><initialPhases><phase type=\"TRIAL\"><duration><unit>DAYS</unit><number>30</number></duration><fixed><fixedPrice /></fixed></phase><phase type=\"DISCOUNT\"><duration><unit>MONTHS</unit><number>6</number></duration><recurring><billingPeriod>MONTHLY</billingPeriod><recurringPrice><price><currency>USD</currency><value>19.95</value></price><price><currency>EUR</currency><value>49.95</value></price><price><currency>GBP</currency><value>69.95</value></price></recurringPrice></recurring></phase></initialPhases><finalPhase type=\"EVERGREEN\"><duration><unit>UNLIMITED</unit></duration><recurring><billingPeriod>ANNUAL</billingPeriod><recurringPrice><price><currency>USD</currency><value>2399.95</value></price><price><currency>EUR</currency><value>1499.95</value></price><price><currency>GBP</currency><value>1699.95</value></price></recurringPrice></recurring></finalPhase></plan><plan name=\"assault-rifle-annual-gunclub-discount\"><product>Assault-Rifle</product><initialPhases><phase type=\"TRIAL\"><duration><unit>DAYS</unit><number>30</number></duration><fixed><fixedPrice /></fixed></phase><phase type=\"DISCOUNT\"><duration><unit>MONTHS</unit><number>6</number></duration><recurring><billingPeriod>MONTHLY</billingPeriod><recurringPrice><price><currency>USD</currency><value>99.95</value></price><price><currency>EUR</currency><value>99.95</value></price><price><currency>GBP</currency><value>99.95</value></price></recurringPrice></recurring></phase></initialPhases><finalPhase type=\"EVERGREEN\"><duration><unit>UNLIMITED</unit></duration><recurring><billingPeriod>ANNUAL</billingPeriod><recurringPrice><price><currency>USD</currency><value>5999.95</value></price><price><currency>EUR</currency><value>3499.95</value></price><price><currency>GBP</currency><value>3999.95</value></price></recurringPrice></recurring></finalPhase></plan><plan name=\"laser-scope-monthly\"><product>Laser-Scope</product><initialPhases><phase type=\"DISCOUNT\"><duration><unit>MONTHS</unit><number>1</number></duration><recurring><billingPeriod>MONTHLY</billingPeriod><recurringPrice><price><currency>USD</currency><value>999.95</value></price><price><currency>EUR</currency><value>499.95</value></price><price><currency>GBP</currency><value>999.95</value></price></recurringPrice></recurring></phase></initialPhases><finalPhase type=\"EVERGREEN\"><duration><unit>UNLIMITED</unit></duration><recurring><billingPeriod>MONTHLY</billingPeriod><recurringPrice><price><currency>USD</currency><value>1999.95</value></price><price><currency>EUR</currency><value>1499.95</value></price><price><currency>GBP</currency><value>1999.95</value></price></recurringPrice></recurring></finalPhase></plan><plan name=\"cleaning-monthly\"><product>Cleaning</product><finalPhase type=\"EVERGREEN\"><duration><unit>UNLIMITED</unit></duration><recurring><billingPeriod>MONTHLY</billingPeriod><recurringPrice><price><currency>USD</currency><value>2.95</value></price><price><currency>EUR</currency><value>1.95</value></price><price><currency>GBP</currency><value>0.95</value></price></recurringPrice></recurring></finalPhase></plan><plan name=\"telescopic-scope-monthly\"><product>Telescopic-Scope</product><initialPhases><phase type=\"DISCOUNT\"><duration><unit>MONTHS</unit><number>1</number></duration><recurring><billingPeriod>MONTHLY</billingPeriod><recurringPrice><price><currency>USD</currency><value>399.95</value></price><price><currency>EUR</currency><value>299.95</value></price><price><currency>GBP</currency><value>399.95</value></price></recurringPrice></recurring></phase></initialPhases><finalPhase type=\"EVERGREEN\"><duration><unit>UNLIMITED</unit></duration><recurring><billingPeriod>MONTHLY</billingPeriod><recurringPrice><price><currency>USD</currency><value>999.95</value></price><price><currency>EUR</currency><value>499.95</value></price><price><currency>GBP</currency><value>999.95</value></price></recurringPrice></recurring></finalPhase></plan><plan name=\"extra-ammo-monthly\"><product>Extra-Ammo</product><finalPhase type=\"EVERGREEN\"><duration><unit>UNLIMITED</unit></duration><recurring><billingPeriod>MONTHLY</billingPeriod><recurringPrice><price><currency>USD</currency><value>999.95</value></price><price><currency>EUR</currency><value>499.95</value></price><price><currency>GBP</currency><value>999.95</value></price></recurringPrice></recurring></finalPhase><plansAllowedInBundle>-1</plansAllowedInBundle><!-- arbitrary number of these (multipack) --></plan><plan name=\"holster-monthly-regular\"><product>Holster</product><initialPhases><phase type=\"TRIAL\"><duration><unit>DAYS</unit><number>30</number></duration><fixed><fixedPrice /></fixed></phase></initialPhases><finalPhase type=\"EVERGREEN\"><duration><unit>UNLIMITED</unit></duration><recurring><billingPeriod>MONTHLY</billingPeriod><recurringPrice><price><currency>USD</currency><value>199.95</value></price><price><currency>EUR</currency><value>199.95</value></price><price><currency>GBP</currency><value>199.95</value></price></recurringPrice></recurring></finalPhase></plan><plan name=\"holster-monthly-special\"><product>Holster</product><initialPhases><phase type=\"TRIAL\"><duration><unit>DAYS</unit><number>30</number></duration><fixed><fixedPrice /></fixed></phase></initialPhases><finalPhase type=\"EVERGREEN\"><duration><unit>UNLIMITED</unit></duration><recurring><billingPeriod>ANNUAL</billingPeriod><recurringPrice><price><currency>USD</currency><value>199.95</value></price><price><currency>EUR</currency><value>199.95</value></price><price><currency>GBP</currency><value>199.95</value></price></recurringPrice></recurring></finalPhase></plan><plan name=\"assault-rifle-annual-rescue\"><product>Assault-Rifle</product><initialPhases><phase type=\"DISCOUNT\"><duration><unit>YEARS</unit><number>1</number></duration><recurring><billingPeriod>ANNUAL</billingPeriod><recurringPrice><price><currency>USD</currency><value>5999.95</value></price><price><currency>EUR</currency><value>3499.95</value></price><price><currency>GBP</currency><value>3999.95</value></price></recurringPrice></recurring></phase></initialPhases><finalPhase type=\"EVERGREEN\"><duration><unit>UNLIMITED</unit></duration><recurring><billingPeriod>ANNUAL</billingPeriod><recurringPrice><price><currency>USD</currency><value>5999.95</value></price><price><currency>EUR</currency><value>3499.95</value></price><price><currency>GBP</currency><value>3999.95</value></price></recurringPrice></recurring></finalPhase></plan><plan name=\"refurbish-maintenance\"><product>Refurbish-Maintenance</product><finalPhase type=\"FIXEDTERM\"><duration><unit>MONTHS</unit><number>12</number></duration><fixed><fixedPrice><price><currency>USD</currency><value>599.95</value></price><price><currency>EUR</currency><value>599.95</value></price><price><currency>GBP</currency><value>599.95</value></price></fixedPrice></fixed><recurring><billingPeriod>MONTHLY</billingPeriod><recurringPrice><price><currency>USD</currency><value>199.95</value></price><price><currency>EUR</currency><value>199.95</value></price><price><currency>GBP</currency><value>199.95</value></price></recurringPrice></recurring></finalPhase></plan><plan name=\"bullets-usage-in-arrear\"><product>Bullets</product><finalPhase type=\"EVERGREEN\"><duration><unit>UNLIMITED</unit></duration><usages><usage name=\"bullets-usage-in-arrear-usage\" billingMode=\"IN_ARREAR\" usageType=\"CONSUMABLE\"><billingPeriod>MONTHLY</billingPeriod><tiers><tier><blocks><tieredBlock><unit>bullets</unit><size>100</size><prices><price><currency>USD</currency><value>2.95</value></price><price><currency>EUR</currency><value>1.95</value></price><price><currency>GBP</currency><value>0.95</value></price></prices><max>10</max></tieredBlock></blocks></tier><tier><blocks><tieredBlock><unit>bullets</unit><size>1000</size><prices><price><currency>USD</currency><value>5.95</value></price><price><currency>EUR</currency><value>4.95</value></price><price><currency>GBP</currency><value>3.95</value></price></prices><max>100</max></tieredBlock></blocks></tier></tiers></usage></usages></finalPhase><plansAllowedInBundle>-1</plansAllowedInBundle><!-- arbitrary number of these (multipack) --></plan></plans><priceLists><defaultPriceList name=\"DEFAULT\"><plans><plan>blowdart-monthly</plan><plan>pistol-monthly</plan><plan>shotgun-monthly</plan><plan>assault-rifle-monthly</plan><plan>pistol-annual</plan><plan>pistol-quarterly</plan><plan>shotgun-annual</plan><plan>assault-rifle-annual</plan><plan>laser-scope-monthly</plan><plan>telescopic-scope-monthly</plan><plan>cleaning-monthly</plan><plan>extra-ammo-monthly</plan><plan>holster-monthly-regular</plan><plan>refurbish-maintenance</plan><plan>bullets-usage-in-arrear</plan></plans></defaultPriceList><childPriceList name=\"gunclubDiscount\"><plans><plan>pistol-monthly</plan><plan>shotgun-monthly</plan><plan>assault-rifle-monthly</plan><plan>pistol-annual-gunclub-discount</plan><plan>shotgun-annual-gunclub-discount</plan><plan>assault-rifle-annual-gunclub-discount</plan><plan>holster-monthly-special</plan></plans></childPriceList><childPriceList name=\"rescue\"><plans><plan>assault-rifle-annual-rescue</plan></plans></childPriceList></priceLists></catalog>"
//  println("Upload XML Catalog: " + client.uploadXMLCatalog(xmlCatalog))

  /**
    * Get Available Base Plans
    */
//  println("Get Available Base Plans: " + client.getAvailableBasePlans())

  /**
    * Get Available Addons
    */
//  println("Get Available Addons: " + client.getAvailableAddons("Sports"))

  /**
    * Get Simple Catalog
    */
//  println("Get Simple Catalog: " + client.getSimpleCatalog())

  /**
    * Delete Payment Method Custom Fields
    */
//  println("Delete Payment Method Custom Fields: " + client.deletePaymentMethodCustomFields(UUID.fromString("b17298d2-37fc-4701-8b9d-92ab1d15f01c")))

  /**
    * Create Payment Method Custom Fields
    */
//  val customFields: List[CustomField] = List[CustomField](CustomField.apply(None, None, None, Option.apply("name"), Option.apply("value")))
//  println("Create Payment Method Custom Fields: " + client.createPaymentMethodCustomFields(UUID.fromString("b17298d2-37fc-4701-8b9d-92ab1d15f01c"), customFields))

  /**
    * Get Payment Method Custom Fields
    */
//  println("Get Payment Method Custom Fields: " + client.getPaymentMethodCustomFields(UUID.fromString("b17298d2-37fc-4701-8b9d-92ab1d15f01c")))

  /**
    * Delete Account Custom Fields
    */
//  println("Delete Account Custom Fields: " + client.deleteAccountCustomFields(UUID.fromString("c0c2b350-6bad-4d5d-86fd-743aae692f06")))

  /**
    * Create Account Custom Fields
    */
//  val customFields: List[CustomField] = List[CustomField](CustomField.apply(None, None, None, Option.apply("name"), Option.apply("value")))
//  println("Create Account Custom Fields: " + client.createAccountCustomFields(UUID.fromString("c0c2b350-6bad-4d5d-86fd-743aae692f06"), customFields))

  /**
    * Get Account Custom Fields
    */
//  println("Get Account Custom Fields: " + client.getAccountCustomFields(UUID.fromString("c0c2b350-6bad-4d5d-86fd-743aae692f06")))

  /**
    * Search Custom Fields
    */
//  println("Custom Fields found with SearchKey 'anyKey': " + client.searchCustomFields("anyKey"))

  /**
    * Get Custom Fields
    */
//    println(s"Custom Fields: " + client.getCustomFields())

  /**
    * Delete Payment Method
    */
//  println("Delete Payment Method: " + client.deletePaymentMethod(UUID.fromString("b17298d2-37fc-4701-8b9d-92ab1d15f01c")))

  /**
    * Update Payment Method
    */
//  println("Update Payment Method: " + client.updatePaymentMethod(UUID.fromString("25d94f0a-3275-463c-9456-1a7c97f115f8"),
//    UUID.fromString("0edc8c31-0d2e-48a8-a746-c37c099e467e")))

  /**
    * Create Payment Method
    */
//  val paymentMethod: PaymentMethod = PaymentMethod.apply(None, None, None, None, Option.apply("__EXTERNAL_PAYMENT__"), None)
//  println("Create Payment Method: " + client.createPaymentMethod(UUID.fromString("c0c2b350-6bad-4d5d-86fd-743aae692f06"), paymentMethod))

  /**
    * Get Payment Methods For Account
    */
//  println(s"Payment Methods for Account: " + client.getPaymentMethodsForAccount(UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08")))

  /**
    * Search Payment Methods
    */
//  println("Payment Methods found with SearchKey '__EXTERNAL_PAYMENT__': " + client.searchPaymentMethods("__EXTERNAL_PAYMENT__"))

  /**
    * Get Bundle by External Key
    */
//  println(s"Got Payment Method: " + client.getPaymentMethodByExternalKey("0edc8c31-0d2e-48a8-a746-c37c099e467e").asInstanceOf[PaymentMethod])

  /**
    * Get Payment Method by Id
    */
//  println(s"Got Payment Method: " + client.getPaymentMethodById(UUID.fromString("0edc8c31-0d2e-48a8-a746-c37c099e467e")).asInstanceOf[PaymentMethod])

  /**
    * Get Payment Methods
    */
//    println(s"Payment Methods: " + client.getPaymentMethods())

  /**
    * Create Invoice Payment Chargeback
    */
//  val invoiceItems: List[InvoiceItem] = List[InvoiceItem]()
//  val chargebackTransaction: InvoicePaymentTransaction = InvoicePaymentTransaction.apply(Option.apply(false),
//    Option.apply(invoiceItems), None, None, None, None, None, None, None, Option.apply(20), None, None, None, None,
//    None, None)
//  println("Create Invoice Payment Chargeback: " + client.createInvoicePaymentChargeback(UUID.fromString("44c8971d-bd04-490c-919e-53e674851652"), chargebackTransaction))

  /**
    * Create Invoice Payment Refund
    */
//  val invoiceItems: List[InvoiceItem] = List[InvoiceItem]()
//  val refundTransaction: InvoicePaymentTransaction = InvoicePaymentTransaction.apply(Option.apply(false),
//    Option.apply(invoiceItems), None, None, None, None, None, None, None, Option.apply(20), None, None, None, None,
//    None, None)
//  println("Create Invoice Payment Refund: " + client.createInvoicePaymentRefund(UUID.fromString("44c8971d-bd04-490c-919e-53e674851652"), refundTransaction))

  /**
    * Process Notification
    */
//  println("Process Notification: " + client.processNotification("notification", "pluginName"))

  /**
    * Build Combo Form Descriptor
    */
//  val fieldList: List[PluginProperty] = List[PluginProperty](PluginProperty.apply(Option.apply("test"), Option.apply("test"), Option.apply(false)))
//  val hostedPaymentPageFields: HostedPaymentPageFields = HostedPaymentPageFields.apply(Option.apply(fieldList))
//  val account: Account = Account.apply(Option.apply("25d94f0a-3275-463c-9456-1a7c97f115f8"), None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None)
//  val paymentMethod: PaymentMethod = PaymentMethod.apply(Option.apply("0edc8c31-0d2e-48a8-a746-c37c099e467e"), None, None, None, None, None)
//  val comboHostedPaymentPage: ComboHostedPaymentPage = ComboHostedPaymentPage.apply(Option.apply(hostedPaymentPageFields), Option.apply(account),
//    Option.apply(paymentMethod), None)
//  println("Build Combo Form Descriptor: " + client.buildComboFormDescriptor(comboHostedPaymentPage))

  /**
    * Build Form Descriptor
    */
//  val fieldList: List[PluginProperty] = List[PluginProperty](PluginProperty.apply(Option.apply("test"), Option.apply("test"), Option.apply(false)))
//  val fields: HostedPaymentPageFields = HostedPaymentPageFields.apply(Option.apply(fieldList))
//  println("Build Form Descriptor: " + client.buildFormDescriptor(fields, UUID.fromString("25d94f0a-3275-463c-9456-1a7c97f115f8"),
//    UUID.fromString("0edc8c31-0d2e-48a8-a746-c37c099e467e")))

  /**
    * Void Payment
    */
//  val paymentTransaction: PaymentTransaction = PaymentTransaction.apply(None, Option.apply("6ca658fa-ec45-403d-99e8-586a857f5a2b"),
//    Option.apply("77e0baf3-81dd-4a4a-be19-dd31a9ed7d51"), Option.apply("77e0baf3-81dd-4a4a-be19-dd31a9ed7d51"), Option.apply("CREDIT"),
//    None, None, Option.apply(30), None, None, None, None, None, None)
//  println("Void Payment: " + client.voidPayment(paymentTransaction.asInstanceOf[PaymentTransaction]))

  /**
    * Chargeback Payment
    */
//  val paymentTransaction: PaymentTransaction = PaymentTransaction.apply(None, Option.apply("6ca658fa-ec45-403d-99e8-586a857f5a2b"),
//    Option.apply("77e0baf3-81dd-4a4a-be19-dd31a9ed7d51"), Option.apply("77e0baf3-81dd-4a4a-be19-dd31a9ed7d51"), Option.apply("CREDIT"),
//    None, None, Option.apply(30), None, None, None, None, None, None)
//  println("Chargeback Payment: " + client.chargebackPayment(paymentTransaction.asInstanceOf[PaymentTransaction]))

  /**
    * Refund Payment
    */
//  val paymentTransaction: PaymentTransaction = PaymentTransaction.apply(None, Option.apply("6ca658fa-ec45-403d-99e8-586a857f5a2b"),
//    Option.apply("77e0baf3-81dd-4a4a-be19-dd31a9ed7d51"), Option.apply("77e0baf3-81dd-4a4a-be19-dd31a9ed7d51"), Option.apply("CREDIT"),
//    None, None, Option.apply(30), None, None, None, None, None, None)
//  println("Refund Payment: " + client.refundPayment(paymentTransaction.asInstanceOf[PaymentTransaction]))

  /**
    * Capture Authorization
    */
//  val paymentTransaction: PaymentTransaction = PaymentTransaction.apply(None, Option.apply("6ca658fa-ec45-403d-99e8-586a857f5a2b"),
//    Option.apply("77e0baf3-81dd-4a4a-be19-dd31a9ed7d51"), Option.apply("77e0baf3-81dd-4a4a-be19-dd31a9ed7d51"), Option.apply("CREDIT"),
//    None, None, Option.apply(30), None, None, None, None, None, None)
//  println("Capture Authorization: " + client.captureAuthorization(paymentTransaction.asInstanceOf[PaymentTransaction]))

  /**
   * Complete Payment
   */
//  val paymentTransaction: PaymentTransaction = PaymentTransaction.apply(None, Option.apply("6ca658fa-ec45-403d-99e8-586a857f5a2b"),
//    Option.apply("77e0baf3-81dd-4a4a-be19-dd31a9ed7d51"), Option.apply("77e0baf3-81dd-4a4a-be19-dd31a9ed7d51"), Option.apply("CREDIT"),
//    None, None, None, None, None, None, None, None, None)
//  println("Complete Payment: " + client.completePayment(paymentTransaction.asInstanceOf[PaymentTransaction]))

  /**
   * Create Payment
   */
//  val paymentTransaction: PaymentTransaction = PaymentTransaction.apply(None, None, None, None, Option.apply("CREDIT"),
//    None, None, Option.apply(10), None, None, None, None, None, None)
//  println("Create Payment: " + client.createPayment(UUID.fromString("25d94f0a-3275-463c-9456-1a7c97f115f8"), null, paymentTransaction.asInstanceOf[PaymentTransaction]))

  /**
   * Create Invoice Payment
   */
//  val invoicePayment: InvoicePayment = InvoicePayment.apply(Option.apply("1d763276-458f-4e7d-a1f7-699a43798522"),
//      Option.apply("25d94f0a-3275-463c-9456-1a7c97f115f8"), None, None, None, None, None, Option.apply(35), None, None, None, None, None)
//  val response: String = client.createInvoicePayment(UUID.fromString("1d763276-458f-4e7d-a1f7-699a43798522"), invoicePayment.asInstanceOf[InvoicePayment])
//  if (response.contains("201")) {
//    println(s"Invoice Payment created succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
   * Pay All Invoices for Account
   */
//  val response: String = client.payAllInvoices(UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08"))
//  if (response.contains("200")) {
//    println(s"All Invoices paid succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
   * Get Invoice Payment by Invoice Id
   */
//  println("Invoice Payments: " + client.getInvoicePayment(UUID.fromString("d79dc8ed-bb9c-4b2b-8b1c-92a11a0f6dad")))

  /**
   * Get Invoice Payments for Account
   */
//  println("Invoice Payments for Account: " + client.getInvoicePaymentsForAccount(UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08")))

  /**
    * Create Combo Payment
    */
//  val paymentTransaction: PaymentTransaction = PaymentTransaction.apply(None, None, None, None, None, None, None, None, None, None, None, None, None, None)
//  val comboPaymentTransaction: ComboPaymentTransaction = ComboPaymentTransaction.apply(Option.apply(paymentTransaction), None)
//  println("Create Combo Payment: " + client.createComboPayment(comboPaymentTransaction))

  /**
    * Get Payments For Account
   */
//  println(s"Payments: " + client.getPaymentsForAccount(UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08")))

  /**
    * Search Payments
    */
//  println("Payments found with SearchKey 'e52b4246-a62d-4236-a2ad-e074029932af': " + client.searchPayments("e52b4246-a62d-4236-a2ad-e074029932af"))

  /**
    * Get Payment by Id
    */
//  println("Payment: " + client.getPaymentById(UUID.fromString("717128d2-84e3-4036-b8d3-da06fb37f48b")))

  /**
    * Get Payments
    */
//  println("List Payments: " + client.getPayments())

  /**
    * Create Credit
    */
//  val credit: Credit = Credit.apply(Option.apply(300), None, None, None, Option.apply("570f2248-d85b-4235-975b-23607b2b37db"))
//  val response: String = client.createCredit(credit)
//  if (response.contains("201")) {
//    println(s"Credit created succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
    * Get Credit
    */
//  println("Get Credit: " + client.getCredit(UUID.fromString("b954dc3b-3d2b-4e80-8329-b3e89934d9bc")))

  /**
    * Delete Payment Tag
    */
//  val response: String = client.deletePaymentTag(UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08"), UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08"))
//  if (response.contains("204")) {
//    println(s"Payment Tag deleted succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
    * Create Payment Tag
    */
//  val response: String = client.createPaymentTag(UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08"), UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08"))
//  if (response.contains("201")) {
//    println(s"Payment Tag added succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
    * Get Payment Tags
    */
//  println("Get Payment Tags: " + client.getPaymentTags(UUID.fromString("488f3897-7117-4fdc-8c93-32233a449ed6")))

  /**
    * Delete Invoice Tag
    */
//  val response: String = client.deleteInvoiceTag(UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08"), UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08"))
//  if (response.contains("204")) {
//    println(s"Invoice Tag deleted succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
    * Create Invoice Tag
    */
//  val response: String = client.createInvoiceTag(UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08"), UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08"))
//  if (response.contains("201")) {
//    println(s"Invoice Tag added succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
    * Get Invoice Tags
    */
//  println("Get Invoice Tags: " + client.getInvoiceTags(UUID.fromString("488f3897-7117-4fdc-8c93-32233a449ed6")))

  /**
    * Delete Subscription Tag
    */
//  val response: String = client.deleteSubscriptionTag(UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08"), UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08"))
//  if (response.contains("204")) {
//    println(s"Subscription Tag deleted succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
    * Create Subscription Tag
    */
//  val response: String = client.createSubscriptionTag(UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08"), UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08"))
//  if (response.contains("201")) {
//    println(s"Subscription Tag added succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
    * Get Subscription Tags
    */
//  println("Get Subscription Tags: " + client.getSubscriptionTags(UUID.fromString("488f3897-7117-4fdc-8c93-32233a449ed6")))

  /**
    * Delete Bundle Tag
    */
//  val response: String = client.deleteBundleTag(UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08"), UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08"))
//  if (response.contains("204")) {
//    println(s"Bundle Tag deleted succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
    * Create Bundle Tag
    */
//  val response: String = client.createBundleTag(UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08"), UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08"))
//  if (response.contains("201")) {
//    println(s"Bundle Tag added succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
    * Get Bundle Tags
    */
//  println("Get Bundle Tags: " + client.getBundleTags(UUID.fromString("488f3897-7117-4fdc-8c93-32233a449ed6")))

  /**
    * Delete Account Tag
    */
//  val response: String = client.deleteAccountTag(UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08"), UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08"))
//  if (response.contains("204")) {
//    println(s"Account Tag deleted succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
    * Create Account Tag
    */
//  val response: String = client.createAccountTag(UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08"), UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08"))
//  if (response.contains("201")) {
//    println(s"Account Tag added succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
    * Get Account Tags
    */
//  println("Get Account Tags: " + client.getAccountTags(UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08")))

  /**
    * Get All Account Tags
    */
//  println("Get All Account Tags: " + client.getAllAccountTags(UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08")))

  /**
    * Search Tags
    */
//  println("Tags found with SearchKey 'any': " + client.searchTags("any"))

  /**
    * Get Tags
    */
  //  println("Tags: " + client.getTags())

  /**
    * Get Overdue State for Account
    */
//  println(s"Overdue State for Account: " + client.getOverdueStateForAccount(UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08")))

  /**
    * Get XML Overdue Config
    */
//  println(s"Getting XML Overdue Config: " + client.getXMLOverdueConfig())

  /**
    * Upload XML Overdue Config
    */
//  val response: String = client.uploadXMLOverdueConfig("overdueConfigPath")
//  if (response.contains("200")) {
//    println(s"XML Overdue uploaded succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
    * Get Catalog Translation
    */
//  println(s"Getting Catalog Translation: " + client.getCatalogTranslation("en_US"))

  /**
    * Upload Catalog Translation
    */
//  val response: String = client.uploadCatalogTranslation("Invoice Template", "en_US")
//  if (response.contains("200")) {
//    println(s"Catalog Translation uploaded succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
    * Get Invoice Translation
    */
//    println(s"Getting Invoice Translation: " + client.getInvoiceTranslation("en_US"))

  /**
    * Upload Invoice Translation
    */
//    val response: String = client.uploadInvoiceTranslation("Invoice Template", "en_US")
//    if (response.contains("200")) {
//      println(s"Invoice Translation uploaded succesfully")
//    }
//    else {
//      println(s"An error occurred. Message: " + response)
//    }

  /**
    * Get Invoice Template
    */
//  println(s"Getting Invoice Template: " + client.getInvoiceTemplate(false))

  /**
    * Upload Invoice Template
    */
//  val response: String = client.uploadInvoiceTemplate("Invoice Template", false)
//  if (response.contains("200")) {
//    println(s"Invoice Template uploaded succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
    * Trigger Email Notification for Invoice
    */
//  val response: String = client.triggerInvoiceNotification(UUID.fromString("c6c7ac0d-cddf-4a31-b326-ddf2c4682e02"))
//  if (response.contains("200")) {
//    println(s"Email Notification triggered succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
    * Create External Charges
    */
//  val invoiceItem: InvoiceItem = InvoiceItem.apply(None, None, None, Option.apply("d09e9b20-31b0-4601-b872-8e9fcab7ce08"),
//    None, None, None, None, None, None, None, None, None, Option.apply(55), Option.apply(Currency.USD))
//  var externalChargesList = List[InvoiceItem]()
//  externalChargesList ::= invoiceItem
//  println("Adding External charge(s): " + client.createExternalCharges(UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08"), "", false, externalChargesList))

  /**
    * Adjust Invoice Item
    */
//  val invoiceItem: InvoiceItem = InvoiceItem.apply(Option.apply("62b91d3e-b2cc-48ff-9644-13b6d635d67e"), None, None,
//    Option.apply("570f2248-d85b-4235-975b-23607b2b37db"), None, None, None, None, None, None, None, None, None,
//    Option.apply(35), Option.apply(Currency.USD))
//  val response: String = client.adjustInvoiceItem(UUID.fromString("ab3ba3cf-c7ae-4f5c-a591-33276fad219d"), "", invoiceItem.asInstanceOf[InvoiceItem])
//  if (response.contains("201")) {
//    println(s"Invoice Item adjusted succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
   * Create Invoice
   */
//  val response: String = client.createInvoice(UUID.fromString("e6f1a070-21d9-44b6-b4d6-b006f1c762ab"))
//  if (response.contains("201")) {
//    println(s"Invoice created succesfully")
//  }
//  else {
//    println(s"An error occurred. Message: " + response)
//  }

  /**
   * Search Invoices
   */
//  println("Invoices found with SearchKey 'f7fb65d0-87d0-4fbf-a5ca-af47969160ad': " + client.searchInvoices("f7fb65d0-87d0-4fbf-a5ca-af47969160ad"))

  /**
   * Get Invoices For Account
   */
//  println(s"Invoices: " + client.getInvoicesForAccount(UUID.fromString("d09e9b20-31b0-4601-b872-8e9fcab7ce08")))

  /**
   * Get Invoice by Id or Number
   */
//  println(s"Invoice: " + client.getInvoiceByIdOrNumber("1e279598-efaa-40b7-a1ea-92c1efa62d6b"))

  /**
   * Get Invoice by Number
   */
//  println(s"Invoice: " + client.getInvoiceByNumber(7))

  /**
   * Get Invoice by Id
   */
//  println(s"Invoice: " + client.getInvoiceById(UUID.fromString("1e279598-efaa-40b7-a1ea-92c1efa62d6b")))

  /**
   * Get Invoices
   */
//  println(s"Invoices: " + client.getInvoices())

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
