# flashcard-app

## Lab 3

### App Description

The app displays a flashcard. It can be editted or a new flashcard can be created.

Flashcard:

Displays a question and 3 answer choices below it. 
When the question is tapped, the "back" of the flashcard containing the answer will show. 
When the "back" of the flashcard is tapped, the "front" of the flashcard with the question is shown again.\
When one of the 3 answer choices below the flashcard is tapped:
- If the answer is correct, the box outline will turn green
- If the answer is incorrect, the selected box outline will turn red and the correct answer box will turn green
- If the background is tapped, the boxes outlines change back into their default color

When the visibility icon at the bottom of the screen is tapped, the 
three answer choices will go away. When the icon is tapped again,
the answer choices will reappear.

Creating a new flashcard:

The user can tap the plus sign in the bottom right corner to bring up an interface with editable textfields that allow them to create a new flashcard. 
If the X in the bottom right is tapped, the user will be returned to the previous flashcard.
Once all fields are filled out, the save icon in the bottom left can be tapped to save the new flashcard. 
If not all fields are filled out, an error message will pop up.
If succesfully saved, the new flashcard is displayed and a message will pop up saying the flashcard was succesfully created.

Editting the flashcard:

The user can tap the edit icon in the bottom left to bring up an interface with editable textfields containing the current flashcards contents.
If the X in the bottom right is tapped, the user will be returned to the previous flashcard.
Once all fields are filled out, the save icon in the bottom left can be tapped to save the new flashcard. 
If not all fields are filled out, an error message will pop up.
If succesfully saved, the new flashcard is displayed and a message will pop up saying the flashcard was succesfully created.

Deleting a flashcard:

The user can tap the delete button to delete a flashcard. If no flashcards exist, the flashcard will show the prompt "Create new flashcard".

The cards will be saved even after the app is closed. If there are multiple flashcards saved, the user can tap the right arrow or the shuffle button.
Tapping the right arrow will switch to the next card, and the shuffle button will switch to a random card.

### App Walk-though

<img src="http://g.recordit.co/20wrj3rNia.gif" width=200><br>

## Required
- [x] User can create a card and still see their created card when the app is relaunched.
- [x] User can create muliple cards and browse through all created cards

## Optional
- [x] User can delete a card and no longer see it in their deck anymore
- [x] Flashcards are shown in random order instead of the order they were created in
- [ ] User can edit a card and see the edit saved when they browse through their deck of cards
- [x] User can create flashcards with multiple answers and be able to browse through cards with multiple choice answers shown

## Lab 2

### App Walk-though

<img src="http://g.recordit.co/Nf3Squ9jyR.gif" width=200><br>

## Required
- [x] User can click on a ‘+’ button that takes the user to new ‘Add Card Screen’
- [x] The 'Add Card Screen' has a cancel button to take the user back to the main screen
- [x] User can enter and submit a Question and Answer through the 'Add Card Screen'
- [x] User will see the card they just created on the main screen when they press the 'Save Button'
- [x] Push your progress to GitHub!

## Optional
- [x] User can edit a card
- [x] An error message is shown if the user doesn't enter both a Question and an Answer
- [x] A notification is shown if the card was created successfully
- [x] User can also enter multiple choice answers when creating a card
- [x] App is further styled and customized!

## Lab 1


### App Walk-though

<img src="http://g.recordit.co/cb437tMzUS.gif" width=200><br>


## Required
- [x] Create New Project in Android Studio
- [x] Add a view for the front side of the flashcard to display the question
- [x] Add a view for the back side of the flashcard to display the answer
- [x] Build in logic to show the answer side when the card is tapped
- [x] Push code to GitHub
## Optional
- [x] toggle the flashcard between the question side and the answer side
- [x] Style the question and answer side of the card to better distinguish between the two sides
- [x] Add selectable multiple choice answers beneath the card
- [x] Change the background color of the multiple choice answers when clicked to indicate whether the question was answered correctly
- [x] Further customize and style the card