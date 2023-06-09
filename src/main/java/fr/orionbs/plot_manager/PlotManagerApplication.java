package fr.orionbs.plot_manager;

import fr.orionbs.plot_manager.application.port.input.UpdatePlotUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@RequiredArgsConstructor
@EnableFeignClients
public class PlotManagerApplication implements CommandLineRunner {

    private final UpdatePlotUseCase updatePlotUseCase;

    public static void main(String[] args) {
        SpringApplication.run(PlotManagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        updatePlotUseCase.updatePlot();
    }
}
