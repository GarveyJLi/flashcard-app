package com.example.garveysflashcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        // User can tap the screen to make the question invisible
        findViewById(R.id.flashcard_question_textview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // change question from visible to invisible
                ((TextView) findViewById(R.id.flashcard_question_textview)).setVisibility
                        (View.INVISIBLE);
                // change answer form invisible to visible
                ((TextView) findViewById(R.id.flashcard_answer_textview)).setVisibility
                        (View.VISIBLE);

            }
        });

        findViewById(R.id.correct_flashcard_answer_textview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // change question from invisible to visible
                ((TextView) findViewById(R.id.flashcard_question_textview)).setVisibility
                        (View.VISIBLE);
                // change answer form visible to invisible
                ((TextView) findViewById(R.id.flashcard_answer_textview)).setVisibility
                        (View.INVISIBLE);

            }
        });

         */

        // User can tap the visibility icon to toggle invisibility for the answers
        findViewById(R.id.toggle_choices_visibility_visible_imageview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // change answers from visible to invisible
                ((TextView) findViewById(R.id.correct_flashcard_answer_textview)).setVisibility
                        (View.INVISIBLE);
                ((TextView) findViewById(R.id.incorrect_flashcard_answer_1_textview)).setVisibility
                        (View.INVISIBLE);
                ((TextView) findViewById(R.id.incorrect_flashcard_answer_2_textview)).setVisibility
                        (View.INVISIBLE);
                // change "visible" icon from visible to invisible
                ((ImageView) findViewById(R.id.toggle_choices_visibility_visible_imageview)).setVisibility
                        (View.INVISIBLE);
                // change "invisible" icon from invisible to visible
                ((ImageView) findViewById(R.id.toggle_choices_visibility_invisible_imageview)).setVisibility
                        (View.VISIBLE);


            }
        });
        findViewById(R.id.toggle_choices_visibility_invisible_imageview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // change answers from visible to invisible
                ((TextView) findViewById(R.id.correct_flashcard_answer_textview)).setVisibility
                        (View.VISIBLE);
                ((TextView) findViewById(R.id.incorrect_flashcard_answer_1_textview)).setVisibility
                        (View.VISIBLE);
                ((TextView) findViewById(R.id.incorrect_flashcard_answer_2_textview)).setVisibility
                        (View.VISIBLE);
                // change "invisible" icon from visible to invisible and "visible" icon from
                // invisible to visible
                ((ImageView) findViewById(R.id.toggle_choices_visibility_invisible_imageview)).setVisibility
                        (View.INVISIBLE);
                ((ImageView) findViewById(R.id.toggle_choices_visibility_visible_imageview)).setVisibility
                        (View.VISIBLE);

            }
        });
        // When user taps the incorrect answer, the tapped answer box color changes to red and
        // the correct box color turns green
        findViewById(R.id.incorrect_flashcard_answer_1_textview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // change textbox color for tapped answer to red
                ((TextView) findViewById(R.id.incorrect_flashcard_answer_1_textview)).setBackgroundColor
                        (getResources().getColor(R.color.wrong_red));
                // change textbox color for correct answer to green
                ((TextView) findViewById(R.id.correct_flashcard_answer_textview)).setBackgroundColor
                        (getResources().getColor(R.color.right_green));
            }
        });
        findViewById(R.id.incorrect_flashcard_answer_2_textview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // change textbox color for tapped answer to red
                ((TextView) findViewById(R.id.incorrect_flashcard_answer_2_textview)).setBackgroundColor
                        (getResources().getColor(R.color.wrong_red, null));
                // change textbox color for correct answer to green
                ((TextView) findViewById(R.id.correct_flashcard_answer_textview)).setBackgroundColor
                        (getResources().getColor(R.color.right_green, null));
            }
        });

        // When user taps correct answer, tapped answer box color will change to green
        findViewById(R.id.correct_flashcard_answer_textview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // change textbox color for tapped answer to green
                ((TextView) findViewById(R.id.correct_flashcard_answer_textview)).setBackgroundColor
                        (getResources().getColor(R.color.right_green, null));
            }
        });

        // When the user taps the background, the answer textbox colors reset to their default colors
        findViewById(R.id.parent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Change all answer textbox colors to #d1d
                ((TextView) findViewById(R.id.correct_flashcard_answer_textview)).setBackgroundColor
                        (getResources().getColor(R.color.default_box_pink, null));
                ((TextView) findViewById(R.id.incorrect_flashcard_answer_1_textview)).setBackgroundColor
                        (getResources().getColor(R.color.default_box_pink, null));
                ((TextView) findViewById(R.id.incorrect_flashcard_answer_2_textview)).setBackgroundColor
                        (getResources().getColor(R.color.default_box_pink, null));
            }
        });
    }
}