package POM;

import Utilities.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class CareersPageElements extends BaseDriver {

        public CareersPageElements(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }

        @FindBy(xpath = "//a[text()='Find your dream job']")
        public WebElement findYourDreamJobButton;

        @FindBy(id = "career-our-location")
        public WebElement locationBlock;

        @FindBy(css = "div[class='elementor-widget-wrap e-swiper-container']")
        public WebElement lifeAtInsiderBlock;

        @FindBy(xpath = "(//div[@class='row'])[2]")
        public WebElement teamBlock;

        @FindBy(xpath = "(//h3[@class='text-center mb-4 mb-xl-5'])[2]")
        public WebElement salesButton;

        @FindBy(css = "a[class='btn btn-outline-secondary rounded text-medium mt-5 mx-auto py-3 loadmore']")
        public WebElement seeAllTeamsButton;

        @FindBy(css = "[src='https://useinsider.com/assets/media/2021/03/qa.png']")
        public WebElement qaButton;

        @FindBy(css=".btn-outline-secondary")
        public WebElement seeAllJobsButton;


    }

