package karate;

import com.intuit.karate.junit5.Karate;

public class KarateRunner {
    @Karate.Test
    Karate testActuatorHealth() {
        return Karate.run("classpath:features/ActuatorHealth.feature");
    }

    @Karate.Test
    Karate testGetUsers() { return Karate.run("classpath:features/GetUsers.feature"); }
    }
