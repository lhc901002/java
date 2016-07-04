package org.mliuframework.demo.designpattern.behavior.observer;

/**
 * Created by Michael on 7/4/16.
 */
public class WeatherConditionDisplay implements Observer {

    private Subject subject;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherConditionDisplay(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    @Override
    public String toString() {
        return "WeatherConditionDisplay{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                '}';
    }

}
