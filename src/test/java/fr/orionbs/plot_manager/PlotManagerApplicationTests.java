package fr.orionbs.plot_manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@ActiveProfiles(profiles = "application-test.yml")
class PlotManagerApplicationTests {

    @Test
    void contextLoads() {
    }

}
