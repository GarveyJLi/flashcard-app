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

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // returns a random number between minNumber and maxNumber, inclusive.
    // for example, if i called getRandomNumber(1, 3), there's an equal chance of it returning either 1, 2, or 3.
    public int getRandomNumber(int minNumber, int maxNumber) {
        Random rand = new Random();
        return rand.nextInt((maxNumber - minNumber) + 1) + minNumber;
    }

    FlashcardDatabase flashcardDatabase;
    List<Flashcard> allFlashcards;
    int currentCardDisplayedIndex = 0;

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

        flashcardDatabase = new FlashcardDatabase(this);
        allFlashcards = flashcardDatabase.getAllCards();


        if (allFlashcards.size() == 0) {
            flashcardDatabase.insertCard(new Flashcard(flashcard_question.getText().toString(),
                    correct_answer_1.getText().toString(), incorrect_answer_1.getText().toString(),
                    incorrect_answer_2.getText().toString()));
            allFlashcards = flashcardDatabase.getAllCards();
            currentCardDisplayedIndex = 0;
        }
        if (allFlashcards != null && allFlashcards.size() > 0) {
            flashcard_question.setText(allFlashcards.get(0).getQuestion());
            correct_answer_1.setText(allFlashcards.get(0).getAnswer());
            correct_answer_2.setText(allFlashcards.get(0).getAnswer());
            incorrect_answer_1.setText(allFlashcards.get(0).getWrongAnswer1());
            incorrect_answer_2.setText(allFlashcards.get(0).getWrongAnswer2());
        }


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

        // When user taps the right arrow button, switch to the next card
        findViewById(R.id.right_button_imageview).setOnClickListener(view -> {
            if (allFlashcards.size() <= 1) {
                return;
            }
            currentCardDisplayedIndex += 1;
            if (currentCardDisplayedIndex >= allFlashcards.size()) {
                currentCardDisplayedIndex = 0;
            }
            allFlashcards = flashcardDatabase.getAllCards();
            Flashcard flashcard = allFlashcards.get(currentCardDisplayedIndex);

            flashcard_question.setText(flashcard.getQuestion());
            correct_answer_1.setText(flashcard.getAnswer());
            correct_answer_2.setText(flashcard.getAnswer());
            incorrect_answer_1.setText(flashcard.getWrongAnswer1());
            incorrect_answer_2.setText(flashcard.getWrongAnswer2());

        });

        // When user taps the shuffle button, the view switches to a random card
        findViewById(R.id.random_card_imageview).setOnClickListener(view -> {
            if (allFlashcards.size() <= 1){
                return;
            }
            currentCardDisplayedIndex = getRandomNumber(0, allFlashcards.size() - 1);
            Flashcard flashcard = allFlashcards.get(currentCardDisplayedIndex);

            flashcard_question.setText(flashcard.getQuestion());
            correct_answer_1.setText(flashcard.getAnswer());
            correct_answer_2.setText(flashcard.getAnswer());
            incorrect_answer_1.setText(flashcard.getWrongAnswer1());
            incorrect_answer_2.setText(flashcard.getWrongAnswer2());

        });

        //User can tap the delete button to delete a flashcard

        findViewById(R.id.delete_imageview).setOnClickListener(view -> {
            if (allFlashcards.size() == 0) {
                return;
            }
            if (allFlashcards.size() == 1) {
                flashcardDatabase.deleteCard(flashcard_question.getText().toString());
                allFlashcards.remove(currentCardDisplayedIndex);

                currentCardDisplayedIndex = 0;

                allFlashcards = flashcardDatabase.getAllCards();
                flashcard_question.setText("Create new flashcard");
                correct_answer_1.setText("Create new flashcard");
                correct_answer_2.setText("Create new flashcard");
                incorrect_answer_1.setText("Create new flashcard");
                incorrect_answer_2.setText("Create new flashcard");
            } else {
                flashcardDatabase.deleteCard(flashcard_question.getText().toString());
                allFlashcards.remove(currentCardDisplayedIndex);

                currentCardDisplayedIndex -= 1;
                if (currentCardDisplayedIndex < 0) {
                    currentCardDisplayedIndex = allFlashcards.size() - 1;
                }

                allFlashcards = flashcardDatabase.getAllCards();
                Flashcard flashcard = allFlashcards.get(currentCardDisplayedIndex);

                flashcard_question.setText(flashcard.getQuestion());
                correct_answer_1.setText(flashcard.getAnswer());
                correct_answer_2.setText(flashcard.getAnswer());
                incorrect_answer_1.setText(flashcard.getWrongAnswer1());
                incorrect_answer_2.setText(flashcard.getWrongAnswer2());
            }

        });


        // User can tap the plus icon to switch from MainActivity to the AddCardActivity
        findViewById(R.id.add_flashcard_button_imageview).setOnClickListener(view -> {
            Intent add_card = new Intent(MainActivity.this, AddCardActivity.class);
            MainActivity.this.startActivityForResult(add_card, 100);
        });

        //User can tap the edit icon to switch to AddCardActivity with text in the edit fields.
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

                flashcardDatabase.insertCard(new Flashcard(new_question, correct_answer, wrong_answer_1, wrong_answer_2));
                allFlashcards = flashcardDatabase.getAllCards();
                currentCardDisplayedIndex = allFlashcards.size() + 1;

                Snackbar.make(findViewById(R.id.flashcard_question_textview),
                        "Flashcard successfully created",
                        Snackbar.LENGTH_SHORT)
                        .show();
            } else {
                Snackbar.make(findViewById(R.id.flashcard_question_textview),
                        "New flashcard cancelled",
                        Snackbar.LENGTH_SHORT)
                        .show();
            }
        }

    }
}