package com.snehpandya.ultimateandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class WidgetsActivity extends AppCompatActivity {

    String message;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.edittext);
                String eText = editText.getText().toString();

                mRelativeLayout = (RelativeLayout) findViewById(R.id.relative);
                Snackbar.make(mRelativeLayout, "Hello " + eText + "!", Snackbar.LENGTH_SHORT).show();
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WidgetsActivity.this, ImageActivity.class);
                startActivity(i);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This is FloatingActionButton", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void submit(View view) {

        EditText editText = (EditText) findViewById(R.id.edittext);
        String eText = editText.getText().toString();

        RadioButton male = (RadioButton) findViewById(R.id.male);
        boolean gender1 = male.isChecked();

        RadioButton female = (RadioButton) findViewById(R.id.female);
        boolean gender2 = female.isChecked();

        CheckBox checkBox = (CheckBox) findViewById(R.id.coffeecheckbox);
        boolean coffeeCheckBox = checkBox.isChecked();

        int calculate = calculateAnswer(gender1, gender2);
        String calculateSummary = createSummary(eText, calculate, coffeeCheckBox);
        displayMessage(calculateSummary);
    }

    public int calculateAnswer(boolean gender1, boolean gender2) {
        int gender = 0;

        if (gender1) {
            gender = 1;
        } else if (gender2) {
            gender = 2;
        }

        return gender;
    }

    public String createSummary(String name, int calculate, boolean checkbox) {
        String messageIn = "Hello " + name + "!";
        if (calculate == 1) {
            messageIn += "\nYour gender is male.";
        } else if (calculate == 2) {
            messageIn += "\nYour gender is female.";
        }

        if (checkbox) {
            messageIn += "\nYou like coffee!";
        }

        return messageIn;
    }

    public void displayMessage(String message) {
        this.message = message;
        TextView t = (TextView) findViewById(R.id.showTextView);
        if (t != null) {
            t.setText(message);
        } else {
            mRelativeLayout = (RelativeLayout) findViewById(R.id.relative);
            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
        }
    }
}