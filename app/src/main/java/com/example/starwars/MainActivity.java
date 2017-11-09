//Ukrit Wattanakulchart 5931391721

package com.example.starwars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.Color;

/**
 * Created by pepukrit on 11/8/2017.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button)findViewById(R.id.slow);
        button1.setBackgroundColor(Color.CYAN);
        Button button2 = (Button)findViewById(R.id.fast);
        button2.setBackgroundColor(Color.GREEN);
        button3 = (Button)findViewById(R.id.pause);
        button3.setBackgroundColor(Color.MAGENTA);
        Button button4 = (Button)findViewById(R.id.restart);
        button4.setBackgroundColor(Color.RED);
        Button button5 = (Button) findViewById(R.id.myName);
        button5.setBackgroundColor(Color.DKGRAY);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StarWars.sp*=2;
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StarWars.sp=StarWars.sp/2;
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(StarWars.r==true){
                    button3.setText("RESUME");
                    StarWars.r=false;
                }
                else{
                    button3.setText("PAUSE");
                    StarWars.r=true;
                }
            }

        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StarWars.s=false;
                StarWars.t1 = 0;
                StarWars.t2 = 0;
                StarWars.dt2 = 0;
                StarWars.sp = 25;
            }
        });
        button5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch(view.getId()) {
            case R.id.myName:
                Intent i = new Intent(this, MyNameIs.class);
                startActivity(i);
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        StarWars.r=false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        StarWars.r=true;
    }
}
