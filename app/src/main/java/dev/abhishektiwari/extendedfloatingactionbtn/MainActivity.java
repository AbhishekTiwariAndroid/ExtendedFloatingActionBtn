package dev.abhishektiwari.extendedfloatingactionbtn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab, fab1, fab2;
    Animation fabOpen, fabClose, rotateForward, rotateBackward;

    boolean isOpen = false; // by default it is false

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fab = findViewById(R.id.fab);
        fab1 = findViewById(R.id.fab1);
        fab2 = findViewById(R.id.fab2);

        //animations
        fabOpen = AnimationUtils.loadAnimation(this, R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(this, R.anim.fab_close);
        rotateForward = AnimationUtils.loadAnimation(this, R.anim.rotate_forward);
        rotateBackward = AnimationUtils.loadAnimation(this, R.anim.rotate_backward);


        //setting click listener on Main Fab

        fab.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View view) {

                animateFab();
            }
        });

        fab1.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View view) {
                animateFab();
                Toast.makeText(MainActivity.this, "Camera clicked", Toast.LENGTH_SHORT).show( );
            }
        });

        fab2.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View view) {
                animateFab();
                Toast.makeText(MainActivity.this, "Gallery clicked", Toast.LENGTH_SHORT).show( );
            }
        });


    }

    private void animateFab(){
        if (isOpen){

            fab.startAnimation(rotateForward);
            fab1.startAnimation(fabClose);
            fab2.startAnimation(fabClose);
            fab1.setClickable(false);
            fab2.setClickable(false);
            isOpen=false;
        }else {
            fab.startAnimation(rotateBackward);
            fab1.startAnimation(fabOpen);
            fab2.startAnimation(fabOpen);
            fab1.setClickable(true);
            fab2.setClickable(true);
            isOpen=true;
        }
    }
}