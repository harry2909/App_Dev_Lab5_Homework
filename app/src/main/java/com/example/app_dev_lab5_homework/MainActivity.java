package com.example.app_dev_lab5_homework;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // defining variables
    private int mCount = 0;
    private TextView mShowCount;
    private EditText textEdit;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static String savedStateValue;
    public static String getCount;

    /**
     * OnCreate method is called when the activity starts.
     *
     * @param savedInstanceState is used to save the most recently supplied data to the app.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.count_view);
        textEdit = (EditText) findViewById(R.id.edit_text);

         /*
        Check if savedInstanceState is not null. Then, set the textEdit to the
        editText_text text and mShowCount to count_text
         */
        if (savedInstanceState != null) {
            textEdit.setText(savedInstanceState.getString("editText_text"));
            mShowCount.setText(savedInstanceState.getString("count_text"));
        }


    }

    /**
     * A method to increment counter on button press.
     *
     * @param view
     */
    public void countUp(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    /**
     * Saved instance method saves the current data when the app is recreated.
     * Getting the data textedit and showcount. Put those strings into the outstate.
     *
     * @param outState keyvaluepairs from the app's current state.
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        savedStateValue = textEdit.getText().toString();
        getCount = mShowCount.getText().toString();
        outState.putString("editText_text", savedStateValue);
        outState.putString("count_text", getCount);
    }

}