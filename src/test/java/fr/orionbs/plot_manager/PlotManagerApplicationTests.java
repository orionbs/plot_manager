package fr.orionbs.plot_manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = PlotManagerApplicationTests.class
)
@TestPropertySource(
        locations = "classpath:application-test.yml"
)
class PlotManagerApplicationTests {

    @Test
    void contextLoads() {
    }

}
