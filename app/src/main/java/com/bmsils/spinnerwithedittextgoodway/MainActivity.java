package com.bmsils.spinnerwithedittextgoodway;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

      /*
       *       Made by Jarvis
       * */

public class MainActivity extends AppCompatActivity {


    ArrayList<String> topicsNameList = new ArrayList<>();

    @BindView(R.id.mainActivityToolbar)
    Toolbar mToolbar;

    @BindView(R.id.topicSpinner)
    Spinner mTopicSpinner;

    @BindView(R.id.topicNotesEditText)
    EditText mTopicNotesEditText;

    @BindView(R.id.publishTopicStoryButton)
    Button mPublishTopicStoryButton;

    @BindView(R.id.snackBarView)
    View snackBarView;

    private String noteForTopic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initializeViews();

        settingDataInToSpinner();

        publishStory();

    }

    private void publishStory() {

        mPublishTopicStoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noteForTopic = mTopicNotesEditText.getText().toString();
                if (TextUtils.isEmpty(noteForTopic)) {
                    Toast.makeText(MainActivity.this, "Fields cant be empty", Toast.LENGTH_SHORT).show();
                } else {
                    Snackbar.make(snackBarView, " Story Successfully Published ", Snackbar.LENGTH_LONG).show();

                }
            }
        });
    }

    private void initializeViews() {

        setSupportActionBar(mToolbar);


    }

    private void settingDataInToSpinner() {
        topicsNameList.clear();
        for (int j = 0; j < 10; j++) {
            topicsNameList.add("Topic" + j);
        }

        ArrayAdapter<String> tailNameAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, topicsNameList);
        tailNameAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mTopicSpinner.setAdapter(tailNameAdapter);


        hideSoftKeyboardOnClickingOfSpinner();


    }

    private void hideSoftKeyboardOnClickingOfSpinner() {
        mTopicSpinner.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager inputMethodManager = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(mTopicNotesEditText.getWindowToken(), 0);
                return false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

       /*
        *   Function to hide soft keyboard click anywhere on screen
        * */

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.
                INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }
}
