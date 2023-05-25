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

    @Then("info from game {string} will be displayed")
    public void infoFromGameWillBeDisplayed(String game) {
        Assertions.assertEquals(1,listGames.size());
        Assertions.assertEquals(game,listGames.get(0).getName());
    }

}
