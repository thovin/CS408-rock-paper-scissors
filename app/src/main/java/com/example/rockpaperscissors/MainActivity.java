package com.example.rockpaperscissors;
import java.util.concurrent.ThreadLocalRandom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private String findOutcome (Weapon playerWeapon) {
        int aiWeaponSelector = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        Weapon aiWeapon = null;
        String winner = null;

        if (aiWeaponSelector == 1) {
            aiWeapon = Weapon.ROCK;
        } else if (aiWeaponSelector == 2) {
            aiWeapon = Weapon.PAPER;
        } else if (aiWeaponSelector == 3) {
            aiWeapon = Weapon.SCISSORS;
        }

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