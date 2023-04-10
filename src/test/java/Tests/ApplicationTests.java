package Tests;

import POM.CareersPageElements;
import POM.HomePageElements;
import POM.FilterPageElements;
import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ApplicationTests extends BaseDriver {

    CareersPageElements careersPageElements;
    HomePageElements homePageElements;
    FilterPageElements filterPageElements;
    WebDriverWait wait;



    @Test
    public void ApplyJobTest() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePageElements = new HomePageElements(driver);

        String mainURL = driver.getCurrentUrl();
        System.out.println("URL of Home Page is " + mainURL);
        Assert.assertEquals(URL, mainURL);

        //Verify that the home page of insider is opened.
        wait.until(ExpectedConditions.visibilityOf(homePageElements.insiderLogo));
        homePageElements.insiderLogo.isDisplayed();
        Assert.assertTrue(homePageElements.insiderLogo.isDisplayed());

        homePageElements.acceptAllButton.click();
        homePageElements.moreButton.click();
        homePageElements.careersButton.click();

    }
        @Test
        public void careerPageTest() throws InterruptedException {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            careersPageElements = new CareersPageElements(driver);

            System.out.println("Is Find Your Dream Job Button Displayed? " + careersPageElements.findYourDreamJobButton.isDisplayed() +"So Verified that career page is opened");

            //Team Block Verification
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", careersPageElements.teamBlock);
            careersPageElements.teamBlock.isDisplayed();
            Assert.assertTrue(careersPageElements.teamBlock.isDisplayed());

            //Location Block Verification
            js.executeScript("arguments[0].scrollIntoView();", careersPageElements.locationBlock);
            Assert.assertTrue(careersPageElements.locationBlock.isDisplayed());

            //Life At Insider Block Verification
            js.executeScript("arguments[0].scrollIntoView();", careersPageElements.lifeAtInsiderBlock);
            Assert.assertTrue(careersPageElements.lifeAtInsiderBlock.isDisplayed());


            js.executeScript("arguments[0].scrollIntoView();", careersPageElements.seeAllTeamsButton);
            Thread.sleep(2000);
            js.executeScript("window.scrollBy(0,-650)");
            Thread.sleep(2000);
            careersPageElements.seeAllTeamsButton.click();


            js.executeScript("arguments[0].scrollIntoView();", careersPageElements.qaButton);
            wait.until(ExpectedConditions.elementToBeClickable(careersPageElements.qaButton));
            careersPageElements.qaButton.click();

            careersPageElements.seeAllJobsButton.click();


        }
        @Test
        public void jobFilterTest() throws InterruptedException {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            filterPageElements = new FilterPageElements(driver);

            //DropDown is not written with Select tag so Actions class are used to select element from DropDown
            Actions selection = new Actions(driver);
            selection.moveToElement(filterPageElements.locationDropDown);
            selection.perform();
            Thread.sleep(2000);
            filterPageElements.locationDropDown.click();
            filterPageElements.cityCountryElement.click();

            selection.moveToElement(filterPageElements.departmentDropDown);
            selection.perform();
            Thread.sleep(2000);
            filterPageElements.departmentDropDown.click();
            filterPageElements.departmentElementDropDown.click();

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", filterPageElements.jobList);
            filterPageElements.jobList.isDisplayed();
            Assert.assertTrue(filterPageElements.jobList.isDisplayed());

            wait.until(ExpectedConditions.visibilityOf(filterPageElements.openPositionNumber));
            System.out.println("The number of result for this filter is " + filterPageElements.openPositionNumber.getText());
            js.executeScript("arguments[0].scrollIntoView();", filterPageElements.openPositionNumber);



            //To check all elements(all open positions after set the filter), List is used
            List<WebElement> titleList = driver.findElements(By.className("position-title"));
            System.out.println("There are "+titleList.size() + " jobs listed.");


            int i = 0;
            while ( titleList.size() > i ){
                System.out.println("Title of the Job is "+ titleList.get(i).getText());
                Assert.assertTrue((titleList.get(i)).getText().contains("Quality Assurance"));
                i++;
            }

            List<WebElement> departmentList = driver.findElements(By.className("position-department"));


            int j = 0;
            while ( departmentList.size() > j ){
                System.out.println("Department of the Job is "+ departmentList.get(j).getText());
                Assert.assertTrue((departmentList.get(j)).getText().contains("Quality Assurance"));
                j++;
            }

            List<WebElement> locationList = driver.findElements(By.className("position-location"));


            int k = 0;
            while ( locationList.size() > k ){
                System.out.println("location of the Job is "+ locationList.get(k).getText());
                Assert.assertTrue((locationList.get(k)).getText().contains("Istanbul, Turkey"));
                k++;
            }

            List<WebElement> ApplyButtonList = driver.findElements(By.xpath("//a[text()='Apply Now']"));

            int l = 0;
            while ( ApplyButtonList.size() > l ){
                System.out.println("is apply button there on " + ApplyButtonList.get(l).isEnabled());
                Assert.assertTrue((ApplyButtonList.get(l)).isEnabled());
                l++;
            }

            filterPageElements.applyNowButton.click();

            List<String> windows = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(windows .get(1));
            Assert.assertEquals(URLForSecondWindow,driver.getCurrentUrl());
            //driver.switchTo().window(windows.get(0));




        }
}








