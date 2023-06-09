package fr.orionbs.plot_manager.adapter.worker;

import fr.orionbs.plot_manager.application.port.input.UpdatePlotUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class PlotWorkerAdapter {

    private final UpdatePlotUseCase updatePlotUseCase;

    @Scheduled(initialDelay = 1, fixedDelay = 3600, timeUnit = TimeUnit.MINUTES)
    public void scheduledPlotUpdate() {
        updatePlotUseCase.updatePlot();
    }

}
