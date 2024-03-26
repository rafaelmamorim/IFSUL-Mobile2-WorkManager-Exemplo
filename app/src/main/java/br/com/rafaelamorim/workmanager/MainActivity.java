package br.com.rafaelamorim.workmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PeriodicWorkRequest periodicWork = new PeriodicWorkRequest.Builder(MyWorker.class, 30, TimeUnit.SECONDS)
                .build();
        WorkManager.getInstance().enqueue(periodicWork);
        Log.i("MainActv","Periodic Work foi chamado. Cuidar para ver se está executando");

    }
}
