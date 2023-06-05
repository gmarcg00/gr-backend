package karate;

import com.intuit.karate.junit5.Karate;

public class KarateRunner {
    @Karate.Test
    Karate testActuatorHealth() {return Karate.run("src/test/java/karate/features/ActuatorHealth.feature");}
    @Karate.Test
    Karate testLoginUser() { return Karate.run("src/test/java/karate/features/LoginUser.feature"); }
    @Karate.Test
    Karate testRegisterUser() { return Karate.run("src/test/java/karate/features/RegisterUser.feature"); }
    @Karate.Test
    Karate testDeleteUser() { return Karate.run("src/test/java/karate/features/DeleteUser.feature"); }
    @Karate.Test
    Karate testSearchGames() { return Karate.run("src/test/java/karate/features/SearchGames.feature"); }
}
