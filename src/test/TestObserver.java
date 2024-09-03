import org.example.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestObserver {

    private TemperatureSensor sensor;
    private TemperatureDisplay display;
    private TemperatureLogger logger;

    @BeforeEach
    public void setUp() {
        sensor = new TemperatureSensor();
        display = new TemperatureDisplay(sensor);
        logger = new TemperatureLogger(sensor);
    }

    @Test
    public void testTemperatureDisplay() {

        sensor.setTemperature(25.0);

    }

    @Test
    public void testTemperatureLogger() {

        sensor.setTemperature(30.0);

    }

    @Test
    public void testMultipleObservers() {

        sensor.setTemperature(18.0);

    }

    @Test
    public void testRemoveObserver() {

        sensor.removeObserver(display);
        sensor.setTemperature(27.0);

    }
}
