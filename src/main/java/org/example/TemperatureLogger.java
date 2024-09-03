package org.example;

public class TemperatureLogger implements TemperatureObserver {

    private TemperatureSensor sensor;

    public TemperatureLogger(TemperatureSensor sensor) {
        this.sensor = sensor;
        sensor.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Temperature Logger: Temperatura registrada em " + sensor.getTemperature() + "°C");
    }
}
