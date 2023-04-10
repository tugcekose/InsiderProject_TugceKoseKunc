package POM;

import Utilities.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterPageElements extends BaseDriver {

    public FilterPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//span[@class='select2-selection__rendered'])[1]")
    public WebElement locationDropDown;

    @FindBy(xpath = "//li[.='Istanbul, Turkey']")
    public WebElement cityCountryElement;

    @FindBy(xpath = "(//span[@class='select2-selection__rendered'])[2]")
    public WebElement departmentDropDown;

    @FindBy(xpath = "//li[text()='Quality Assurance']")
    public WebElement departmentElementDropDown;

    @FindBy(id = "jobs-list")
    public WebElement jobList;

    @FindBy(css = "p[class='position-title font-weight-bold']")
    public WebElement jobPosition;

    @FindBy(css = "span[class='position-department text-large font-weight-600 text-primary']")
    public WebElement jobDepartment;

    @FindBy(css = "div[class='position-location text-large']")
    public WebElement jobLocation;

    @FindBy(xpath = "//a[text()='Apply Now']")
    public WebElement applyNowButton;


    @FindBy(xpath = "//p[@id='resultCounter']")
    public WebElement openPositionNumber;









}
