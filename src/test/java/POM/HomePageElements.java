package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageElements {

    public HomePageElements(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//nav[@id='navigation']//img[@src='https://useinsider.com/assets/img/logo-old.png']")
    public WebElement insiderLogo;
    @FindBy(xpath="//a[text()='Accept All']")
    public WebElement acceptAllButton;

    @FindBy(xpath = "//span[text()='More']")
    public WebElement moreButton;

    @FindBy(xpath = "//h5[text()='Careers']")
    public WebElement careersButton;


}
