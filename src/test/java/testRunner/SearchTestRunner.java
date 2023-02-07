package testRunner;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;
import setup.Setup;
import utils.Utils;

import java.io.IOException;
import java.util.List;

public class SearchTestRunner extends Setup {

    SearchPage searchPage;
    Utils utils;

    @Test(priority = 1, description = "User can search a game name successfully")
    public void UserCanSearchGameName() throws InterruptedException, IOException, ParseException {

        driver.get("https://store.steampowered.com");

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "steampowered";
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        searchPage = new SearchPage(driver);
        utils = new Utils();
        searchPage.doSearch("Dota 2");

        String firstActualSearch = searchPage.searchAssertion.get(1).getText();
        String firstExpectedSearch = "Dota 2";
        Assert.assertTrue(firstActualSearch.contains(firstExpectedSearch));


//        1st Result Information
        String game1Name = searchPage.gameName.get(0).getText();
        String game1releaseDate = searchPage.releaseDate.get(0).getText();
        String game1price = searchPage.price.get(0).getText();
        System.out.println(game1Name);
        System.out.println(game1releaseDate);
        System.out.println(game1price);

        utils.saveResultList(game1Name, game1releaseDate, game1price);


//        2nd Result Information
        String game2Name = searchPage.gameName.get(1).getText();
        String game2releaseDate = searchPage.releaseDate.get(1).getText();
        String game2price = searchPage.price.get(1).getText();
        System.out.println(game2Name);
        System.out.println(game2releaseDate);
        System.out.println(game2price);

        utils.saveResultList(game2Name, game2releaseDate, game2price);

    }

    @Test(priority = 2, description = "User can search another game name successfully")
    public void UserCanSearchAnotherGameName() throws IOException, ParseException, InterruptedException {

        searchPage = new SearchPage(driver);

        List result = Utils.readResultdata("./src/test/resources/information.json");
        JSONObject userObj = (JSONObject) result.get(result.size() - 1);
        String gameName = (String) userObj.get("GameName");

        searchPage.doSearch(gameName);

        String secondActualSearch = searchPage.searchAssertion.get(1).getText();
        String secondExpectedSearch = "Dota 2 Player Profiles";
        Assert.assertTrue(secondActualSearch.contains(secondExpectedSearch));

    }

}
