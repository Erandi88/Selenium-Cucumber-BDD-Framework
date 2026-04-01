package StepDefinitions;

import Pages.*;
import Utilities.CommonDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class TMFeatureStepDefinitions extends CommonDriver
{
    LoginPage loginPageObj = new LoginPage();
    HomePage homePageObj = new HomePage();
    TMPage tMPageObj = new TMPage();

    @Before
    public void Setup()
    {
        driver = new ChromeDriver();
    }
    @Given("I logged into TurnUp portal successfully")
    public void iLoggedIntoTurnUpPortalSuccessfully() throws InterruptedException
    {
        loginPageObj.LoginActions(driver);
    }

    @When("I navigate to Time and Material page")
    public void iNavigateToTimeAndMaterialPage()
    {
        homePageObj.NavigateToTMPage(driver);
    }

    @When("I create a time record")
    public void iCreateATimeRecord() throws InterruptedException
    {
        tMPageObj.CreateTimeRecord(driver);
    }

    @Then("the record should be created successfully")
    public void theRecordShouldBeCreatedSuccessfully()
    {
        String newCode = tMPageObj.GetCode(driver);
        String newDescription = tMPageObj.GetDescription(driver);
        String newPrice = tMPageObj.GetPrice(driver);

        Assert.assertEquals(newCode,"TA Programme","Actual Code and expected Code do not match.");
        Assert.assertEquals(newDescription,"This is a description", "Actual Description and expected Description do not match.");
        Assert.assertEquals(newPrice, "12", "Actual Price and expected Price do not match.");
    }

    @When("I update the {string} and {string} on an existing Time record")
    public void iUpdateTheCodeAndDescriptionOnAnExistingTimeRecord(String code, String description) throws InterruptedException {

        tMPageObj.EditTimeRecord(driver, code, description);
    }

    @Then("the record should have the updated {string} and {string}")
    public void theRecordShouldHaveTheUpdatedCodeAndDescription(String code, String description) {

        String editedCode = tMPageObj.GetEditedCode(driver);
        String editedDescription = tMPageObj.GetEditedDescription(driver);

        Assert.assertEquals(code, editedCode, "Expected Edited Code and actual edited code do not match.");
        Assert.assertEquals(description, editedDescription, "Expected Edited Description and actual edited description do not match.");
    }

    @After
    public void CloseTestRun()
    {
        driver.quit();
    }
}
