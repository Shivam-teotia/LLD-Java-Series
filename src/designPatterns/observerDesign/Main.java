package designPatterns.observerDesign;

public class Main {
    public static void main(String[] args){
        WeatherStation station= new WeatherStation();
        Observer mobile =new MobileDisplay();
        Observer led = new LEDDisplay();
        station.addObserver(mobile);
        station.addObserver(led);

        station.setTemperature(33);
        station.setTemperature(35);
    }
}
