package com.example.user.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button bs;
    private TextView rt;
    private BroadcastReceiver mbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bs = (Button)findViewById(R.id.send);
        rt = (TextView)findViewById(R.id.message);

        bs.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.setClass(MainActivity.this,MyService.class);
                startService(i);
                Toast.makeText(MainActivity.this,"Service啟動成功",Toast.LENGTH_SHORT).show();

            }

    });
        mbr = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                Bundle myBundle = intent.getExtras();
                int myInt = myBundle.getInt("bs");
                rt.setText("後台的Service執行了"+myInt+"秒");
            }
        };
        IntentFilter intentFilter = new IntentFilter("MyMessage");
        registerReceiver(mbr,intentFilter);
    }
}
