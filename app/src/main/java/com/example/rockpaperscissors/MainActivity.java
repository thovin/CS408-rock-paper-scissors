package com.example.rockpaperscissors;
import java.util.concurrent.ThreadLocalRandom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private int playerScore = 0;
    private int aiScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.rockButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                processRound(Weapon.ROCK);
            }
        });
        findViewById(R.id.paperButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                processRound(Weapon.PAPER);
            }
        });
        findViewById(R.id.scissorsButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                processRound(Weapon.SCISSORS);
            }
        });

    }

    public void processRound(Weapon playerWeapon) {
        TextView scoresString = findViewById(R.id.scores);
        TextView playerWeaponString = findViewById(R.id.playerWeapon);
        TextView aiWeaponString = findViewById(R.id.aiWeapon);
        TextView outcomeString = findViewById(R.id.outcome);
        Weapon aiWeapon = null;
        Weapon winningWeapon = null;
        String winnerBlurb = "";


        int aiWeaponSelector = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        if (aiWeaponSelector == 1) {
            aiWeapon = Weapon.ROCK;
        } else if (aiWeaponSelector == 2) {
            aiWeapon = Weapon.PAPER;
        } else if (aiWeaponSelector == 3) {
            aiWeapon = Weapon.SCISSORS;
        }

        String outcome = findOutcome(aiWeapon, playerWeapon);
        if (outcome == "player") {
            playerScore++;
            winningWeapon = playerWeapon;
            winnerBlurb = "Player wins ... ";
        } else if (outcome == "computer") {
            aiScore++;
            winningWeapon = aiWeapon;
            winnerBlurb = "Computer wins ... ";
        } else if (outcome == "draw") {
            winnerBlurb = "Draw!";
        }

        if (winningWeapon == Weapon.ROCK) {
            winnerBlurb += "Rock crushes scissors!";
        } else if (winningWeapon == Weapon.PAPER) {
            winnerBlurb += "Paper covers rock!";
        } else if (winningWeapon == Weapon.SCISSORS) {
            winnerBlurb += "Scissors cuts paper!";
        }

        scoresString.setText("Player: " + String.valueOf(playerScore) + ", Computer: " + String.valueOf(aiScore));
        playerWeaponString.setText("Player's weapon: " + playerWeapon.toString());
        aiWeaponString.setText("Computer's weapon: " + aiWeapon.toString());
        outcomeString.setText(winnerBlurb);

    }

    private String findOutcome (Weapon aiWeapon, Weapon playerWeapon) {
        String winner = null;

        if (playerWeapon == aiWeapon) {
            winner = "draw";
        } else if (aiWeapon == Weapon.ROCK) {
            if (playerWeapon == Weapon.PAPER) {
                winner = "player";
            } else {
                winner = "computer";
            }
        } else if (aiWeapon == Weapon.PAPER) {
            if (playerWeapon == Weapon.ROCK) {
                winner = "computer";
            } else {
                winner = "player";
            }
        } else if (aiWeapon == Weapon.SCISSORS) {
            if (playerWeapon == Weapon.ROCK) {
                winner = "player";
            } else {
                winner = "computer";
            }
        }

        return winner;


    }
}