package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TMPage {

    public void CreateTimeRecord(WebDriver driver) throws InterruptedException {

        try
        {
            WebElement createNewButton = driver.findElement(By.xpath("//*[@id=\"container\"]/p/a"));
            createNewButton.click();
        }
        catch (Exception ex)
        {
            Assert.fail("Create New button hasn't been found.");
        }

        // Select Time from dropdown
        WebElement typeCodeDropdown = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[1]/div/span[1]/span/span[2]/span"));
        typeCodeDropdown.click();

        Thread.sleep(2000);
        WebElement timeOption = driver.findElement(By.xpath("//*[@id=\"TypeCode_listbox\"]/li[2]"));
        timeOption.click();

        // Type code into Code textbox
        WebElement codeTextbox = driver.findElement(By.id("Code"));
        codeTextbox.sendKeys("TA Programme");

        //Type description into Description textbox
        WebElement descriptionTextbox = driver.findElement(By.id("Description"));
        descriptionTextbox.sendKeys("This is a description");

        // Type price into Price textbox
        WebElement priceTagOverlap = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[4]/div/span[1]/span/input[1]"));
        priceTagOverlap.click();

        WebElement priceTextbox = driver.findElement(By.id("Price"));
        priceTextbox.sendKeys("12");

        // Click on Save button
        WebElement saveButton = driver.findElement(By.id("SaveButton"));
        saveButton.click();
        Thread.sleep(3000);

        // Check if Time record has been created successfully
        WebElement goToLastPageButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
        goToLastPageButton.click();
    }

    public String GetCode(WebDriver driver)
    {
        WebElement newCode = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        return newCode.getText();
    }

    public String GetDescription(WebDriver driver)
    {
        WebElement newDescription = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[3]"));
        return newDescription.getText();
    }

    public String GetPrice(WebDriver driver)
    {
        WebElement newPrice = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[4]"));
        return newPrice.getText();
    }

    public void EditTimeRecord(WebDriver driver, String code, String description) throws InterruptedException {
        Thread.sleep(4000);
        //Select a record and click edit button
        WebElement lastPageButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
        lastPageButton.click();
        Thread.sleep(2000);

        WebElement editButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[5]/a[1]"));
        editButton.click();

        WebElement codeTextbox = driver.findElement(By.id("Code"));
        codeTextbox.clear();
        codeTextbox.sendKeys(code);
        Thread.sleep(2000);

        WebElement descriptionTextbox = driver.findElement(By.id("Description"));
        descriptionTextbox.clear();
        descriptionTextbox.sendKeys(description);
        Thread.sleep(2000);


        //Click save
        WebElement saveButton = driver.findElement(By.id("SaveButton"));
        saveButton.click();
        Thread.sleep(1500);

        WebElement llastPageButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
        llastPageButton.click();
        Thread.sleep(1500);

    }

    public String GetEditedCode(WebDriver driver)
    {
        WebElement editedCode = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        return editedCode.getText();
    }

    public String GetEditedDescription(WebDriver driver)
    {
        WebElement editedDescription = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[3]"));
        return editedDescription.getText();
    }
}
