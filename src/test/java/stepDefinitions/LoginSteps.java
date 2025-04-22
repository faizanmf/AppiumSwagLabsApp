//package stepDefinitions;
//
//import io.cucumber.java.en.*;
//import Pages.LoginPage;
//import Utils.DriverFactory;
//
//public class LoginSteps {
//    LoginPage loginPage;
//
//    @Given("the app is launched")
//    public void the_app_is_launched() throws Exception {
//        DriverFactory.initDriver();
//        loginPage = new LoginPage(DriverFactory.getDriver());
//    }
//
//    @When("user enters username {string}")
//    public void user_enters_username(String username) {
//        loginPage.enterUsername(username);
//    }
//
//    @When("user enters password {string}")
//    public void user_enters_password(String password) {
//        loginPage.enterPassword(password);
//    }
//
//    @When("user clicks login")
//    public void user_clicks_login() throws InterruptedException {
//        loginPage.tapLogin();
//        Thread.sleep(3000);
//    }
//
//    @Then("user should be navigated to the home screen")
//    public void user_should_be_navigated_to_the_home_screen() {
//        // Add validation for home screen
//        System.out.println("User successfully logged in.");
//        DriverFactory.quitDriver();
//    }
//}
