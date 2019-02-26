package jmiller.connect3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public int turnCount;
    public int[] position = new int[9];
    public int c0Counter, c1Counter, c2Counter;

    //public ImageView redChip = (ImageView) findViewById(R.id.redChip);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initial click count, verify turnCount=0
        Log.i("Click count Init:", Integer.toString(turnCount));

        c0Counter = 0;
        c1Counter = 1;
        c2Counter = 2;

        ImageView redChip = (ImageView) findViewById(R.id.redChip);
        //ImageView yellowChip = (ImageView) findViewById(R.id.yellowChip);

    }//end onCreate

    public void clickCol0(View view) {

        //only update position on indexes 0,3,6
        if (c0Counter <= 6) {
            turnCount++;


            //debugging information
            Log.i("Click count:", Integer.toString(turnCount));


            //YELLOW's turn
            // on the even turn and as long as long column counter is in range
            if (turnCount % 2 == 0) {
                //despite being a 3x3 matrix, the position is tracked linearly. position = 1 when
                //it is YELLOW's turn.
                position[c0Counter] = 1;

                redChip.animate()
                        .alpha(1f)
                        .translationYBy(0f)
                        .translationXBy(0f)
                        .rotation(36000)
                        .setDuration(1000);

                //debugging information.
                Log.i("C1Counter", Integer.toString(c0Counter));
                Log.i("YELLOW value marker", Integer.toString(position[c0Counter]));
                Log.i("YELLOW position marker", Integer.toString(c0Counter));
                //column counter
                c0Counter += 3;



            }//end if


            //RED's turn
            // on the odd turn and as long as long column counter is in range
            else if (turnCount % 2 != 0) {
                //despite being a 3x3 matrix, the position is tracked linearly. position = 2 when
                //it is RED's turn.
                position[c0Counter] = 5;

                //debugging information
                Log.i("C1Counter", Integer.toString(c0Counter));
                Log.i("RED value marker", Integer.toString(position[ c0Counter]));
                Log.i("RED position marker", Integer.toString(c0Counter));

                //column counter
                c0Counter += 3;


            }//end if
        }//end while

        checkWin();
    }//clickCol0

    public void clickCol1(View view) {

        //only update position on indexes 1,4,7
        if (c1Counter <= 7) {
            turnCount++;


            //debugging information
            Log.i("Click count:", Integer.toString(turnCount));


            //YELLOW's turn
            // on the even turn and as long as long column counter is in range
            if (turnCount % 2 == 0) {
                //despite being a 3x3 matrix, the position is tracked linearly. position = 1 when
                //it is YELLOW's turn.
                position[c1Counter] = 1;

                //debugging information.
                Log.i("C1Counter", Integer.toString(c1Counter));
                Log.i("YELLOW value marker", Integer.toString(position[c1Counter]));
                Log.i("Yellow position marker", Integer.toString(c1Counter));
                //column counter
                c1Counter += 3;

            }//end if


            //RED's turn
            // on the odd turn and as long as long column counter is in range
            else if (turnCount % 2 != 0) {
                //despite being a 3x3 matrix, the position is tracked linearly. position = 2 when
                //it is RED's turn.
                position[c1Counter] = 5;

                //debugging information
                Log.i("C1Counter", Integer.toString(c1Counter));
                Log.i("RED value marker", Integer.toString(position[c1Counter]));
                Log.i("RED position marker", Integer.toString(c1Counter));
                //column counter
                c1Counter += 3;

            }//end if
        }//end while
        checkWin();
    } //end clickCol1

    public void clickCol2(View view) {

        //only update position on indexes 2,5,8
        if (c2Counter <= 8) {
            turnCount++;


            //debugging information
            Log.i("Click count:", Integer.toString(turnCount));


            //YELLOW's turn
            // on the even turn and as long as long column counter is in range
            if (turnCount % 2 == 0) {
                //despite being a 3x3 matrix, the position is tracked linearly. position = 1 when
                //it is YELLOW's turn.
                position[c2Counter] = 1;

                //debugging information.
                Log.i("C1Counter", Integer.toString(c2Counter));
                Log.i("YELLOW value marker", Integer.toString(position[c2Counter]));
                Log.i("Yellow position marker", Integer.toString(c2Counter));
                //column counter
                c2Counter += 3;


            }//end if


            //RED's turn
            // on the odd turn and as long as long column counter is in range
            else if (turnCount % 2 != 0) {
                //despite being a 3x3 matrix, the position is tracked linearly. position = 2 when
                //it is RED's turn.
                position[c2Counter] = 5;

                //debugging information
                Log.i("C1Counter", Integer.toString(c2Counter));
                Log.i("RED value marker", Integer.toString(position[c2Counter]));
                Log.i("RED position marker", Integer.toString(c2Counter));

                //column counter
                c2Counter += 3;

            }//end if
        }//end while

        checkWin();
    }//end clickCol2



    //CHECK WIN
    //since position is an array, the values within the array need to be checked to see if they
    //constitute a win. Since RED = 2, 2+2+2=6.
    //
    //The linear and matrix layout of the position array.
    //
    // position [0, 1, 2, 3, 4, 5, 6, 7, 8]
    // ____________
    // | 6 | 7 | 8 |
    // | 3 | 4 | 5 |
    // | 0 | 1 | 2 |
    // -------------
    public void checkWin(){
        if(
                   position[0] + position[1] + position[2] == 15
                || position[0] + position[3] + position[6] == 15
                || position[0] + position[4] + position[8] == 15
                || position[1] + position[4] + position[7] == 15
                || position[2] + position[5] + position[8] == 15
                || position[3] + position[4] + position[5] == 15
                || position[6] + position[7] + position[8] == 15
                || position[2] + position[4] + position[6] == 15
                ){
            Toast.makeText(MainActivity.this, "RED WON!", Toast.LENGTH_LONG).show();

            //reset values
            reset();
        }//end if
        else if(
                           position[0] + position[1] + position[2] == 3
                        || position[0] + position[3] + position[6] == 3
                        || position[0] + position[4] + position[8] == 3
                        || position[1] + position[4] + position[7] == 3
                        || position[2] + position[5] + position[8] == 3
                        || position[3] + position[4] + position[5] == 3
                        || position[6] + position[7] + position[8] == 3
                        || position[2] + position[4] + position[6] == 3
                ){
            Toast.makeText(MainActivity.this, "YELLOW WON!", Toast.LENGTH_LONG).show();

            //reset values
            reset();
        }//end if

        fillColors();
    }//end checkWin

    //reset values in order to play again
    private void reset(){
        turnCount = 0;
        Arrays.fill(position, 0);
        c0Counter = 0;
        c1Counter = 1;
        c2Counter = 2;

    } // end reset

    private void fillColors(){
        for( int i=0; i<position.length; i++ ) {
            if (position[i] == 1) {
                //setYellow(i);
            }
            if (position[i] == 3) {
                //setRed(i);
            }
        }

    }// end fillColors

}//end class, wow that was classy
