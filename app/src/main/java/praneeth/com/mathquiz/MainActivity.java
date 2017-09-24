package praneeth.com.mathquiz;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button mButton;
    TextView mTextView;
    TextView resultText;
    TextView scoreText;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    TextView timer;
    Button playButton;
    ConstraintLayout mConstraintLayout;


    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    int score=0;
    int numberOfQuetions=0;
    int a;
    int b;

    public void playAgain(View view){
        playButton.setVisibility(View.INVISIBLE);

         score=0;
        numberOfQuetions=0;
        scoreText.setText("0/0");
        timer.setText("30s");
        resultText.setText("");
        generateQuetions();
        new CountDownTimer(30100,1000) {
            @Override
            public void onTick(long l) {
                timer.setText(String.valueOf(l/1000)+"s");
            }

            @Override
            public void onFinish() {
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.sound);
                mediaPlayer.start();
                timer.setText("0s");
                resultText.setText("Your Score  " + Integer.toString(score));
                playButton.setVisibility(View.VISIBLE);
                playButton.setText("Play Again");
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resultText.setText("Your Score  " + Integer.toString(score) + "/" + Integer.toString(numberOfQuetions));

                    }
                });
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resultText.setText("Your Score  " + Integer.toString(score));

                    }
                });

                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resultText.setText("Your Score  " + Integer.toString(score));

                    }
                });

                button4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resultText.setText("Your Score  " + Integer.toString(score));

                    }
                });











            }
        }.start();


    }

    public void generateQuetions(){

        Random rand = new Random();
         a = rand.nextInt(101);
         b = rand.nextInt(101);

        mTextView.setText(Integer.toString(a) + "+" + Integer.toString(b));
        locationOfCorrectAnswer = rand.nextInt(4);
        answers.clear();

        for(int i =0 ;i<4;i++){
            if(locationOfCorrectAnswer==i){
                answers.add(a+b);
            }
            else{
                int incorrectAnswer = rand.nextInt(200);

                while(incorrectAnswer==(a+b)){
                    incorrectAnswer = rand.nextInt(200);
                }

                answers.add(incorrectAnswer);
            }
        }

        button1.setText(Integer.toString(answers.get(0)));
        button2.setText(Integer.toString(answers.get(1)));
        button3.setText(Integer.toString(answers.get(2)));
        button4.setText(Integer.toString(answers.get(3)));



    }

    public void chooseAnswer(View view){

        if(view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))){
            resultText.setText("Correct!");
            score++;
        }
        else {
            resultText.setText("Wrong!");
        }
        numberOfQuetions++;
        scoreText.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuetions));
        generateQuetions();


    }


    public void start(View view){

        mButton.setVisibility(View.INVISIBLE);
        mConstraintLayout.setVisibility(View.VISIBLE);
        playAgain(findViewById(R.id.button5));


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.button);
        mTextView = (TextView) findViewById(R.id.SumtextView3);
         button1 = (Button)findViewById(R.id.button1);
         button2 = (Button)findViewById(R.id.button2);
         button3 = (Button)findViewById(R.id.button3);
         button4 = (Button)findViewById(R.id.button4);
        resultText=(TextView)findViewById(R.id.ResulttextView4);
        scoreText = (TextView)findViewById(R.id.ScoretextView);
        timer = (TextView)findViewById(R.id.TimetextView);
        playButton=(Button)findViewById(R.id.button5);
        mConstraintLayout = (ConstraintLayout)findViewById(R.id.ConstraintLayout);





    }
}
