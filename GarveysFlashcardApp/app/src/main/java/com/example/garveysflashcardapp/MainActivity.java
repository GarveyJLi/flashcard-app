package com.example.garveysflashcardapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView flashcard_question = ((TextView) findViewById(R.id.flashcard_question_textview));
        TextView correct_answer_1 = ((TextView) findViewById(R.id.correct_flashcard_answer_1_textview));
        TextView correct_answer_2 = ((TextView) findViewById(R.id.correct_flashcard_answer_2_textview));
        TextView incorrect_answer_1 = ((TextView) findViewById(R.id.incorrect_flashcard_answer_1_textview));
        TextView incorrect_answer_2 = ((TextView) findViewById(R.id.incorrect_flashcard_answer_2_textview));


        // User can tap the screen to make the question invisible
        flashcard_question.setOnClickListener(view -> {
            // change question from visible to invisible
            flashcard_question.setVisibility(View.INVISIBLE);
            // change answer from invisible to visible
            correct_answer_2.setVisibility(View.VISIBLE);

        });

        findViewById(R.id.correct_flashcard_answer_2_textview).setOnClickListener(view -> {
            // change question from invisible to visible
            flashcard_question.setVisibility(View.VISIBLE);
            // change answer from visible to invisible
            correct_answer_2.setVisibility(View.INVISIBLE);

        });


        // User can tap the visibility icon to toggle invisibility for the three answer choices
        findViewById(R.id.toggle_choices_visibility_visible_imageview).setOnClickListener(view -> {
            // change answers from visible to invisible
            correct_answer_1.setVisibility
                    (View.INVISIBLE);
            incorrect_answer_1.setVisibility
                    (View.INVISIBLE);
            incorrect_answer_2.setVisibility
                    (View.INVISIBLE);
            // change "visible" icon from visible to invisible
            ((ImageView) findViewById(R.id.toggle_choices_visibility_visible_imageview)).setVisibility
                    (View.INVISIBLE);
            // change "invisible" icon from invisible to visible
            ((ImageView) findViewById(R.id.toggle_choices_visibility_invisible_imageview)).setVisibility
                    (View.VISIBLE);


        });
        findViewById(R.id.toggle_choices_visibility_invisible_imageview).setOnClickListener(view -> {
            // change answers from visible to invisible
            correct_answer_1.setVisibility
                    (View.VISIBLE);
            incorrect_answer_1.setVisibility
                    (View.VISIBLE);
            incorrect_answer_2.setVisibility
                    (View.VISIBLE);
            // change "invisible" icon from visible to invisible and "visible" icon from
            // invisible to visible
            ((ImageView) findViewById(R.id.toggle_choices_visibility_invisible_imageview)).setVisibility
                    (View.INVISIBLE);
            ((ImageView) findViewById(R.id.toggle_choices_visibility_visible_imageview)).setVisibility
                    (View.VISIBLE);

        });

        // When user taps the incorrect answer, the tapped answer box color changes to red and
        // the correct box color turns green
        findViewById(R.id.incorrect_flashcard_answer_1_textview).setOnClickListener(view -> {
            // change textbox color for tapped answer to red
            incorrect_answer_1.setBackground(getResources().getDrawable(R.drawable.wrong_card_background));
            // change textbox color for correct answer to green
            correct_answer_1.setBackground(getResources().getDrawable(R.drawable.right_card_background));
        });
        findViewById(R.id.incorrect_flashcard_answer_2_textview).setOnClickListener(view -> {
            // change textbox color for tapped answer to red
            incorrect_answer_2.setBackground(getResources().getDrawable(R.drawable.wrong_card_background));
            // change textbox color for correct answer to green
            correct_answer_1.setBackground(getResources().getDrawable(R.drawable.right_card_background));
        });

        // When user taps correct answer, tapped answer box color will change to green
        findViewById(R.id.correct_flashcard_answer_1_textview).setOnClickListener(view -> {
            // change textbox color for tapped answer to green
            correct_answer_1.setBackground(getResources().getDrawable(R.drawable.right_card_background));
        });

        // When the user taps the background, the answer textbox colors reset to their default colors
        findViewById(R.id.parent).setOnClickListener(view -> {
            // Change all answer textbox colors to #d1d
            correct_answer_1.setBackground(getResources().getDrawable(R.drawable.card_background));
            incorrect_answer_1.setBackground(getResources().getDrawable(R.drawable.card_background));
            incorrect_answer_2.setBackground(getResources().getDrawable(R.drawable.card_background));
        });


        // User can tap the plus icon to switch from MainActivity to the AddCardActivity
        findViewById(R.id.add_flashcard_button_imageview).setOnClickListener(view -> {
            Intent add_card = new Intent(MainActivity.this, AddCardActivity.class);
            MainActivity.this.startActivityForResult(add_card, 100);
        });

        findViewById(R.id.edit_current_flashcard_imageview).setOnClickListener(view -> {
            Intent edit_card = new Intent(MainActivity.this, AddCardActivity.class);
            edit_card.putExtra("current_question", flashcard_question.getText().toString());
            edit_card.putExtra("current_correct_answer", correct_answer_1.getText().toString());
            edit_card.putExtra("current_wrong_answer_1", incorrect_answer_1.getText().toString());
            edit_card.putExtra("current_wrong_answer_2", incorrect_answer_2.getText().toString());
            MainActivity.this.startActivityForResult(edit_card, 100);
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent save_card) {
        super.onActivityResult(requestCode, resultCode, save_card);
        if (requestCode == 100) {
            if (save_card != null) { // check if there's an Intent
                String new_question = save_card.getExtras().getString("new_question");
                String wrong_answer_1 = save_card.getExtras().getString("wrong_answer_1");
                String wrong_answer_2 = save_card.getExtras().getString("wrong_answer_2");
                String correct_answer = save_card.getExtras().getString("correct_answer");

                ((TextView) findViewById(R.id.flashcard_question_textview)).setText(new_question);
                ((TextView) findViewById(R.id.correct_flashcard_answer_1_textview)).setText(correct_answer);
                ((TextView) findViewById(R.id.correct_flashcard_answer_2_textview)).setText(correct_answer);
                ((TextView) findViewById(R.id.incorrect_flashcard_answer_1_textview)).setText(wrong_answer_1);
                ((TextView) findViewById(R.id.incorrect_flashcard_answer_2_textview)).setText(wrong_answer_2);

                Snackbar.make(findViewById(R.id.flashcard_question_textview),
                        "Flashcard successfully created",
                        Snackbar.LENGTH_SHORT)
                        .show();
            }
            else{
                Snackbar.make(findViewById(R.id.flashcard_question_textview),
                        "New flashcard cancelled",
                        Snackbar.LENGTH_SHORT)
                        .show();
            }
        }
    }
}