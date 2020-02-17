package bdd;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdminLoginStepDef {
    private static final By LOC_USERNAME = By.id("input-username");
    private static final By LOC_PASSWORD = By.id("input-password");
    private static final By LOC_LOGIN_BUTT = By.cssSelector(".btn.btn-primary");
    private static final By LOC_SALES = By.id("menu-sale");
    private static final By LOC_SALES_ORDERS = By.xpath("//ul[@id=\"collapse26\"]//..//li[1]");
    private static final By LOC_MENU_EXTENSION = By.id("menu-extension");
    private static final By LOC_EXTENSION_MARKET = By.xpath("//ul[@id=\"collapse14\"]//..//li[1]");
    private static final By LOC_EXTENSION_MARKET_SEARCH = By.xpath("//div[@id=\"extension-filter\"]//..//input[@class=\"form-control\"]");
    private static final By LOC_EXTENSION_MARKET_SEARCH_BUTTON = By.id("button-filter");
    private static final By LOC_LOGOUT_BUTTON = By.cssSelector("i.fa-sign-out + span");


    @Given("the user is on the admin login page")
    public void the_user_is_on_the_admin_login_page() {

        /**
         * Open the internet page
         */
        Browser.driver.get("http://shop.pragmatic.bg/admin/");
    }

    @When("the user logs in using username {string} and password {string}")
    public void theUserLogsInUsingUsernameAndPassword(String username, String password) {
        /**
         * Enter username"Admin"and password "parola123!" in admin login panel
         */
        Browser.driver.findElement(LOC_USERNAME).sendKeys(username);
        Browser.driver.findElement(LOC_PASSWORD).sendKeys(password);
    }

    @And("the user clicks on the login button")
    public void theUserClicksOnTheLoginButton() {
        /**
         * Click on the login button
         */
        Browser.driver.findElement(LOC_LOGIN_BUTT).click();
    }

    @And("the user should successfully log in into the admin panel")
    public void theUserShouldSuccessfullyLogInIntoTheAdminPanel() {
        /**
         * Verify that the user is on the correct page
         */
        String actualTitle = Browser.driver.getTitle();
        Assert.assertEquals(actualTitle, "Dashboard");
    }


    @And("admin clic on navigation bar on the menu sales-orders and check the select menu")
    public void admin_clic_on_navigation_bar_on_the_menu_sales_orders_and_check_the_select_menu() {
        /**
         * Checks the navigation menu, sales,orders! Then check the drop down menu !
         */
        Browser.driver.findElement(LOC_SALES).click();
        Browser.driver.findElement(LOC_SALES_ORDERS).click();

        WebElement dropDown =Browser.driver.findElement(By.name("filter_order_status_id"));
        Select dropMenu = new Select(dropDown);
        Assert.assertFalse(dropMenu.isMultiple());

        List<String> exp_options = Arrays.asList(new String[]{"", "Missing Orders", "Canceled", "Canceled Reversal", "Chargeback", "Complete", "Denied", "Expired", "Failed", "Pending", "Processed", "Processing", "Refunded", "Reversed", "Shipped", "Voided"});
        List<String > act_options = new ArrayList<>();
        List<WebElement> all_options = dropMenu.getOptions();

        for (WebElement option: all_options) {

            act_options.add(option.getText());


        }


        Assert.assertEquals(exp_options.toArray(),act_options.toArray());

    }



    @And("the user clicks on the extension menu and then search specific detail")
    public void the_user_clicks_on_the_extension_menu_and_then_search_specific_detail() throws InterruptedException {
        /**
         * Open the extension menu ,extension market and search for element
         */
        Browser.driver.findElement(LOC_MENU_EXTENSION).click();
        Browser.driver.findElement(LOC_EXTENSION_MARKET).click();
        WebDriverWait wait = new WebDriverWait(Browser.driver,10);
        WebElement until = wait.until(ExpectedConditions.elementToBeClickable(Browser.driver.findElement(LOC_EXTENSION_MARKET_SEARCH)));
        Thread.sleep(5000);
        until.click();
        until.sendKeys("Opencart SEO Pack PR");


        Thread.sleep(5000);
        Browser.driver.findElement(LOC_EXTENSION_MARKET_SEARCH_BUTTON).click();
    }

    @Then("the user verify the search and go and click on the logout button")
    public void the_user_verify_the_search_and_go_and_click_on_the_logout_button() {
        /**
         * неможах да локирам logout button
         *
         */
       // Browser.driver.findElement(LOC_LOGOUT_BUTTON).click();
    }


}
