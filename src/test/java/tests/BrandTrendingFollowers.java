package tests;

import Common.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class BrandTrendingFollowers {
    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void setup(){
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void BabySam_TrendingFollowers() throws InterruptedException {
        // Navigate to the website
        driver.get(TestData.Website_Url);
        WebElement managecookies = driver.findElement(By.id("declineButton"));
        if (managecookies != null) {
            managecookies.click();
        }
        // Click on login tab
        login();
        // Navigate to Inspiration
        WebElement inspirationTab = driver.findElement(By.xpath("//a[@data-testid='navbarForYou']"));
        inspirationTab.click();
        //Select Inspiration type Brands
        selectInspirationType("BRANDS");
        // Navigate to Børn & child
        selectcategory("Child & Baby");
        // Click Brand - BabySam
        selectSpecificBrandByName("BabySam");
        // Open the Populært trending list
        selectFirstElementFromTrendingList();
        // Assert the number of trending list followers
        Thread.sleep(1000);
        WebElement followersElement = driver.findElement(By.xpath("//p[contains(text(), 'followers')]"));
        String followersCount = followersElement.getText();
        Assert.assertNotNull(followersCount,"Followers count should not be null");
        System.out.println("NUmber of followers "+ followersCount );
    }
    private void login() {
        WebElement loginTab = driver.findElement(By.xpath("//button[contains(text(), 'Log ind')]"));
        loginTab.click();
        // Click Continue with Email
        WebElement continueWithEmailButton = driver.findElement(By.xpath("//button[@data-cy='registerNameNextButton']"));
        continueWithEmailButton.click();
        // Enter Email ID and password
        WebElement userName = driver.findElement(By.xpath("//input[@data-cy='signupEmailInput']"));
        userName.sendKeys(TestData.USERNAME);
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys(TestData.PASSWORD);
        WebElement loginButton = driver.findElement(By.xpath("//button[@data-cy='registerNameNextButton']"));
        loginButton.click();
    }

    private void selectInspirationType(String inspirationTypeName) {
        WebElement inspirationType = driver.findElement(By.xpath("//button[@data-testid='FOR_YOU-"+inspirationTypeName+"_TITLE']"));
        inspirationType.click();
    }
    private void selectcategory(String category) {
        WebElement cateogryTab = driver.findElement(By.xpath("//button[.//span[text()='" + category + "']]"));
        cateogryTab.click();
    }

    private void selectSpecificBrandByName(String brand) {
        WebElement chooseBrand = driver.findElement(By.xpath("//h2[text()='"+brand+"']/parent::div"));
        chooseBrand.click();
    }

    private void selectFirstElementFromTrendingList() {
        WebElement trendingList = driver.findElement(By.xpath("//div[@data-cy='trendingListCard-0']"));
        trendingList.click();
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }



}
