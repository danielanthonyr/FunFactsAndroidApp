package site.danielio.funfacts;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class FunFactsActivity extends AppCompatActivity {

    //Declaring View Variables
    //Non public, non static fields name start with m
    //Static field names start with s
    //All other variables start with lowercase
    //Public Static Constants ALL_UPPERCASE_LETTERS
    private TextView mFactTextView;
    private Button mShowFactButton;
    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();
    private RelativeLayout mRelativeLayout;
    private static final String TAG = FunFactsActivity.class.getSimpleName();



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        //Assign views from layout file to corresponding variable

        mFactTextView = (TextView) findViewById(R.id.factTV);
        mShowFactButton = (Button) findViewById(R.id.factButton);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        mShowFactButton.setOnClickListener(mShowFactListener);
        //Toast.makeText(this, "Ayyyy" , Toast.LENGTH_SHORT).show();
        Log.d(TAG, "We're Logging from the onCreateMethod");

    }

        private View.OnClickListener mShowFactListener = new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //Button was clicked, so we need a new fact
                String fact = mFactBook.getFact();
                int color = mColorWheel.getColor();

                //Update the screen with our dynamic fact
                mFactTextView.setText(fact);
                mRelativeLayout.setBackgroundColor(color);
                mShowFactButton.setTextColor(color);
            }
        };

    }

