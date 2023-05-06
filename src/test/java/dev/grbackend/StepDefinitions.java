package dev.grbackend;

import dev.grbackend.models.Game;
import dev.grbackend.services.GameService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
public class StepDefinitions {
    @Autowired
    private GameService gameService;

    private ArrayList<Game> listGames;
    @Given("a game review user")
    public void aGameReviewUser() {
    }

    @When("making click on games section")
    public void makingClickOnGamesSection() {
        listGames = gameService.getGames();
    }

    @Then("all games info will be displayed")
    public void allGamesInfoWillBeDisplayed() {
        Assertions.assertEquals(1,listGames.size());
    }

}
