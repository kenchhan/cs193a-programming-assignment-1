// Ken Chhan <kchhan@stanford.edu>
// No ties!

package com.example.kenchhan.rockpaperscissors;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private String[] choices = {"Rock", "Paper", "Scissors"};
    private int playerScore = 0;
    private int computerScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean playerWins(String playerChoice) {
        Random rand = new Random();
        String computerChoice = choices[rand.nextInt(choices.length)];
        while (playerChoice.equals(computerChoice)) {
            computerChoice = choices[rand.nextInt(choices.length)];
        }

        ((TextView)findViewById(R.id.computerChoiceLabel)).setText(computerChoice);

        if (playerChoice.equals("Rock")) {
            if (computerChoice.equals("Paper")) return false;
            return true;
        }
        else if (playerChoice.equals("Paper")) {
            if (computerChoice.equals("Scissors")) return false;
            return true;
        }
        else { // Player chose Scissors
            if (computerChoice.equals("Rock")) return false;
            return true;
        }

    }

    public void play(View v) {
        TextView status = (TextView)findViewById(R.id.victoryStatus);
        Button playerChoiceButton = (Button)v;
        String playerChoice = playerChoiceButton.getText().toString();

        if (playerWins(playerChoice)) {
            playerScore++;
            TextView playerScoreLabel = (TextView)findViewById(R.id.playerScoreLabel);
            playerScoreLabel.setText("You: " + playerScore);
            status.setText("You won this round!");
            status.setTextColor(Color.GREEN);
        }
        else {
            computerScore++;
            TextView computerScoreLabel = (TextView)findViewById(R.id.computerScore);
            computerScoreLabel.setText("Nemesis: " + computerScore);
            status.setText("You lost this round!");
            status.setTextColor(Color.RED);
        }
    }

    public void resetScore(View view) {
        playerScore = 0;
        computerScore = 0;
        TextView computerScoreLabel = (TextView)findViewById(R.id.computerScore);
        TextView playerScoreLabel = (TextView)findViewById(R.id.playerScoreLabel);

        computerScoreLabel.setText("Nemesis: " + computerScore);
        playerScoreLabel.setText("You: " + playerScore);
        ((TextView)findViewById(R.id.victoryStatus)).setText("");
        ((TextView)findViewById(R.id.computerChoiceLabel)).setText("");
    }
}
