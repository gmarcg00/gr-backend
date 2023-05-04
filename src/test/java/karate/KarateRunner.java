package karate;

import com.intuit.karate.junit5.Karate;

public class KarateRunner {
    @Karate.Test
    Karate testActuatorHealth() {return Karate.run("src/test/java/karate/features/ActuatorHealth.feature");}

    @Karate.Test
    Karate testGetUsers() { return Karate.run("src/test/java/karate/features/GetUsers.feature"); }

    @Karate.Test
    Karate testGetGames() { return Karate.run("src/test/java/karate/features/TestGames.feature"); }
}
