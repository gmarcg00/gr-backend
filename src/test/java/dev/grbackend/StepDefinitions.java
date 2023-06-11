package dev.grbackend;

import dev.grbackend.models.Game;
import dev.grbackend.models.Reaction;
import dev.grbackend.services.GameService;
import dev.grbackend.services.ReactionService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class StepDefinitions {
    @Autowired
    private GameService gameService;
    @Autowired
    private ReactionService reactionService;

    private Reaction reaction;

    private List<Game> listGames;

    @Given("a game review user")
    public void aGameReviewUser() {
    }

    @When("making click on games section")
    public void makingClickOnGamesSection() {
        listGames = gameService.getAllGames();
    }

    @When("filtering by genre {string}, platform {string}")
    public void filteringByGenrePlatformStore(String genre, String platform) {
        if(genre == "") genre = "null";
        if(platform == "") platform = "null";
        listGames = gameService.findGames(genre, platform, "null");
    }

    @When("searching by name {string} on the search bar")
    public void filteringSearchBar(String prefix) {
        listGames = gameService.searchByPrefix(prefix);
    }

    @When("user {string} checks his liked games")
    public void userAccessesIntoGameSectionInUserAccount(String userName) {
        listGames = gameService.getUserLikedGames(userName);
    }

    @Then("game {string} will be displayed")
    public void infoFromGameWillBeDisplayed(String game) {
        Assertions.assertEquals(100,listGames.size());
        Assertions.assertEquals(game,listGames.get(0).getName());
    }

    @Then("the number of games returned will be {int}")
    public void numberOfGamesReturnedWillBe(int sizeList) {
        Assertions.assertEquals(sizeList,listGames.size());
    }

    @Then("{int} games that {string} has liked appears on user games section")
    public void gamesAppearInGamesSectionUser(int sizeList,String userName) {
        Assertions.assertEquals(sizeList,listGames.size());
    }

    @And("first game {string} will be displayed")
    public void firstGameWillBeDisplayed(String game){
        if(listGames.size() == 0){
            Assertions.assertEquals("",game);
        }else{
            Assertions.assertEquals(game,listGames.get(0).getName());
        }
    }

    @And("game {string} will be displayed in first position")
    public void gameWillBeDisplayedInFirstPosition(String game){
        Assertions.assertEquals(game,listGames.get(0).getName());
    }
}
