package edu.ucsd.cse110.listener;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    TextView temperatureView;
    int temperature = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temperatureView = findViewById(R.id.temperature);

        TemperatureService tempService = new TemperatureService();
        tempService.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        temperature = (int) arg;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                temperatureView.setText(String.valueOf(temperature));
            }
        });

    }
}
