package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class SearchPage {

    @FindBy(className = "default")
    WebElement searchBox;

    @FindBy(className = "title")
    public List<WebElement> gameName;

    @FindBy(className = "search_released")
    public List<WebElement> releaseDate;

    @FindBy(className = "search_price")
    public List<WebElement> price;

    @FindBy(className = "searchtag")
    public List<WebElement> searchAssertion;


    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void doSearch(String searchResult) throws InterruptedException {
        searchBox.sendKeys(searchResult + Keys.ENTER);
        Thread.sleep(3000);
    }

}



