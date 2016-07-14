package org.mliuframework.java.designpattern.behavior.observer;

/**
 * Created by Michael on 7/4/16.
 */
public class WeatherStationApp {

    public static void main(String[] args) {
        WeatherForcast weatherForcast = new WeatherForcast();
        weatherForcast.setCondition(25, 0.66f, 3);
        WeatherConditionDisplay weatherConditionDisplay1 = new WeatherConditionDisplay(
                weatherForcast);
        WeatherConditionDisplay weatherConditionDisplay2 = new WeatherConditionDisplay(
                weatherForcast);
        weatherForcast.notifyObservers();
        System.out.println(weatherConditionDisplay1);
        System.out.println(weatherConditionDisplay2);

        weatherForcast.removeObserver(weatherConditionDisplay2);
        weatherForcast.setCondition(33, 0.78f, 2.8f);
        weatherForcast.notifyObservers();
        System.out.println(weatherConditionDisplay1);
        System.out.println(weatherConditionDisplay2);
    }

}
