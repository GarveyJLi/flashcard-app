package com.example.garveysflashcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        String current_question = getIntent().getStringExtra("current_question");
        String current_correct_answer = getIntent().getStringExtra("current_correct_answer");
        String current_wrong_answer_1 = getIntent().getStringExtra("current_wrong_answer_1");
        String current_wrong_answer_2 = getIntent().getStringExtra("current_wrong_answer_2");

        EditText question = ((EditText) findViewById(R.id.enter_question_edittext));
        EditText correct_answer = ((EditText) findViewById(R.id.correct_answer_edittext));
        EditText incorrect_answer_1 = ((EditText) findViewById(R.id.incorrect_answer_1_edittext));
        EditText incorrect_answer_2 = ((EditText) findViewById(R.id.incorrect_answer_2_edittext));

        question.setText(current_question);
        correct_answer.setText(current_correct_answer);
        incorrect_answer_1.setText(current_wrong_answer_1);
        incorrect_answer_2.setText(current_wrong_answer_2);

        // User can tap the x icon to switch from AddCardActivity to the MainActivity
        findViewById(R.id.cancel_new_flashcard_imageview).setOnClickListener(view -> {
            finish();
            overridePendingTransition(R.anim.right_out, R.anim.left_in);

        });

        // User can tap the save icon to switch activities and save the inputted text into the flashcard
        findViewById(R.id.save_new_flascard_imageview).setOnClickListener(view -> {
            if (question.getText().toString().equals("") | incorrect_answer_1.getText().toString().equals("") |
                    incorrect_answer_2.getText().toString().equals("") | correct_answer.getText().toString().equals("")) {
                Toast.makeText(getApplicationContext(), "Must fill out all fields", Toast.LENGTH_SHORT).show();
            }
            else {
                Intent save_card = new Intent();
                save_card.putExtra("new_question", question.getText().toString());
                save_card.putExtra("wrong_answer_1", incorrect_answer_1.getText().toString());
                save_card.putExtra("wrong_answer_2", incorrect_answer_2.getText().toString());
                save_card.putExtra("correct_answer", correct_answer.getText().toString());
                setResult(RESULT_OK, save_card);
                finish();
                overridePendingTransition(R.anim.right_out, R.anim.left_in);
            }
        });

    }
}