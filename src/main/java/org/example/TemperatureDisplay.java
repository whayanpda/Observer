package org.example;

public class TemperatureDisplay implements TemperatureObserver {

    private TemperatureSensor sensor;

    public TemperatureDisplay(TemperatureSensor sensor) {
        this.sensor = sensor;
        sensor.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Temperature Display: Temperatura atual " + sensor.getTemperature() + "°C");
    }
}

