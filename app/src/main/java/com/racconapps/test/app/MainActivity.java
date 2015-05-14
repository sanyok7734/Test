package com.racconapps.test.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.rey.material.widget.RadioButton;

import java.io.FileWriter;
import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    private RadioButton radioButtonOneOne;
    private RadioButton radioButtonOneTwo;
    private RadioButton radioButtonOneThree;

    private RadioButton radioButtonTwoOne;
    private RadioButton radioButtonTwoTwo;
    private RadioButton radioButtonTwoThree;

    private RadioButton radioButtonSevenOne;
    private RadioButton radioButtonSevenTwo;
    private RadioButton radioButtonSevenThree;
    private RadioButton radioButtonSevenFour;
    private RadioButton radioButtonSevenFive;

    private MaterialEditText questionTree;
    private MaterialEditText questionFour;
    private MaterialEditText questionFive;
    private MaterialEditText questionSix;

    private MaterialEditText textName;
    private MaterialEditText textMail;
    private MaterialEditText textPhone;

    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButtonOneOne = (RadioButton) findViewById(R.id.responseOneOne);
        radioButtonOneTwo = (RadioButton) findViewById(R.id.responseOneTwo);
        radioButtonOneThree = (RadioButton) findViewById(R.id.responseOneThree);

        radioButtonTwoOne = (RadioButton) findViewById(R.id.responseTwoOne);
        radioButtonTwoTwo = (RadioButton) findViewById(R.id.responseTwoTwo);
        radioButtonTwoThree = (RadioButton) findViewById(R.id.responseTwoThree);

        radioButtonSevenOne = (RadioButton) findViewById(R.id.responseSevenOne);
        radioButtonSevenTwo = (RadioButton) findViewById(R.id.responseSevenTwo);
        radioButtonSevenThree = (RadioButton) findViewById(R.id.responseSevenThree);
        radioButtonSevenFour = (RadioButton) findViewById(R.id.responseSevenFour);
        radioButtonSevenFive = (RadioButton) findViewById(R.id.responseSevenFive);

        radioButtonOneOne.setOnClickListener(onClickListener);
        radioButtonOneTwo.setOnClickListener(onClickListener);
        radioButtonOneThree.setOnClickListener(onClickListener);

        radioButtonTwoOne.setOnClickListener(onClickListener);
        radioButtonTwoTwo.setOnClickListener(onClickListener);
        radioButtonTwoThree.setOnClickListener(onClickListener);

        radioButtonSevenOne.setOnClickListener(onClickListener);
        radioButtonSevenTwo.setOnClickListener(onClickListener);
        radioButtonSevenThree.setOnClickListener(onClickListener);
        radioButtonSevenFour.setOnClickListener(onClickListener);
        radioButtonSevenFive.setOnClickListener(onClickListener);


        questionTree = (MaterialEditText) findViewById(R.id.questionTree);
        questionFour = (MaterialEditText) findViewById(R.id.questionFour);
        questionFive = (MaterialEditText) findViewById(R.id.questionFive);
        questionSix = (MaterialEditText) findViewById(R.id.questionSix);

        textName = (MaterialEditText) findViewById(R.id.textName);
        textPhone = (MaterialEditText) findViewById(R.id.textPhone);
        textMail = (MaterialEditText) findViewById(R.id.textMail);

        buttonSend = (Button) findViewById(R.id.buttonSend);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Uloženo", Toast.LENGTH_SHORT).show();
                generateCsvFile("/test.csv");
            }
        });
    }

    private void generateCsvFile(String sFileName) {
        try {
            FileWriter writer = new FileWriter(sFileName, true);

            if (radioButtonOneOne.isChecked()) {
                writer.append("A");
            } else if (radioButtonOneTwo.isChecked()) {
                writer.append("B");
            }else if (radioButtonOneThree.isChecked()) {
                writer.append("C");
            }
            writer.append(';');

            if (radioButtonTwoOne.isChecked()) {
                writer.append("A");
            } else if (radioButtonTwoTwo.isChecked()) {
                writer.append("B");
            }else if (radioButtonTwoThree.isChecked()) {
                writer.append("C");
            }
            writer.append(';');
            writer.append(questionTree.getText().toString());
            writer.append(';');
            writer.append(questionFour.getText().toString());
            writer.append(';');
            writer.append(questionFive.getText().toString());
            writer.append(';');
            writer.append(questionSix.getText().toString());
            writer.append(';');
            if (radioButtonSevenOne.isChecked()) {
                writer.append("1");
            } else if (radioButtonSevenTwo.isChecked()) {
                writer.append("2");
            }else if (radioButtonSevenThree.isChecked()) {
                writer.append("3");
            }else if (radioButtonSevenFour.isChecked()) {
                writer.append("4");
            }else if (radioButtonSevenFive.isChecked()) {
                writer.append("5");
            }
            writer.append(';');
            writer.append(textName.getText().toString());
            writer.append(';');
            writer.append(textMail.getText().toString());
            writer.append(';');
            writer.append(textPhone.getText().toString());
            writer.append('\n');

            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.responseOneOne:
                    radioButtonOneTwo.setChecked(false);
                    radioButtonOneThree.setChecked(false);
                    break;
                case R.id.responseOneTwo:
                    radioButtonOneOne.setChecked(false);
                    radioButtonOneThree.setChecked(false);
                    break;
                case R.id.responseOneThree:
                    radioButtonOneTwo.setChecked(false);
                    radioButtonOneOne.setChecked(false);
                    break;
                case R.id.responseTwoOne:
                    radioButtonTwoTwo.setChecked(false);
                    radioButtonTwoThree.setChecked(false);
                    break;
                case R.id.responseTwoTwo:
                    radioButtonTwoThree.setChecked(false);
                    radioButtonTwoOne.setChecked(false);
                    break;
                case R.id.responseTwoThree:
                    radioButtonTwoTwo.setChecked(false);
                    radioButtonTwoOne.setChecked(false);
                    break;
                case R.id.responseSevenOne:
                    radioButtonSevenTwo.setChecked(false);
                    radioButtonSevenThree.setChecked(false);
                    radioButtonSevenFour.setChecked(false);
                    radioButtonSevenFive.setChecked(false);
                    break;
                case R.id.responseSevenTwo:
                    radioButtonSevenOne.setChecked(false);
                    radioButtonSevenThree.setChecked(false);
                    radioButtonSevenFour.setChecked(false);
                    radioButtonSevenFive.setChecked(false);
                    break;
                case R.id.responseSevenThree:
                    radioButtonSevenOne.setChecked(false);
                    radioButtonSevenTwo.setChecked(false);
                    radioButtonSevenFour.setChecked(false);
                    radioButtonSevenFive.setChecked(false);
                    break;
                case R.id.responseSevenFour:
                    radioButtonSevenOne.setChecked(false);
                    radioButtonSevenTwo.setChecked(false);
                    radioButtonSevenThree.setChecked(false);
                    radioButtonSevenFive.setChecked(false);
                    break;
                case R.id.responseSevenFive:
                    radioButtonSevenOne.setChecked(false);
                    radioButtonSevenTwo.setChecked(false);
                    radioButtonSevenFour.setChecked(false);
                    radioButtonSevenThree.setChecked(false);
                    break;
                default:
                    break;
            }
        }
    };

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
}
