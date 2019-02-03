package edu.ucsd.cse110.listener;

import java.util.Observable;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class TemperatureService extends Observable {

    private Timer t;
    private TimerTask updateTemperature;

    public TemperatureService() {
        updateTemperature = new TimerTask() {
            Random r = new Random();
            int maxTemp = 50;
            int minTemp = -50;

            @Override
            public void run() {
                int newTemp = r.nextInt(maxTemp + 1 - minTemp) + minTemp;
                System.out.println("Updating temp to: " + newTemp);
                setChanged();
                notifyObservers(newTemp);
            }
        };
        t = new Timer();
        t.schedule(updateTemperature, 0, 2000);
    }
}
