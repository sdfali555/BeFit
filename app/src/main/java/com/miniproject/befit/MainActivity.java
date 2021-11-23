package com.miniproject.befit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);


        button1 = findViewById(R.id.startfitness1);
        button2 = findViewById(R.id.startfitness2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        for(int i = 0; i< menu.size();i++)
        {
            MenuItem menuItem = menu.getItem(i);
            SpannableString spannable = new SpannableString(menu.getItem(i).getTitle().toString());
            spannable.setSpan(new ForegroundColorSpan(Color.BLACK),0,spannable.length(),0);
            menuItem.setTitle(spannable);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.id_privacy)
        {
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.privacypolicygenerator.info/live.php?token=TlSzTB9BGn8CMYVj7dwp5mAUc8awEUJO "));
            startActivity(intent);
            return true;
        }
        if(id == R.id.term)
        {
            Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.termsandconditionsgenerator.com/download.php?lang=en&token=RX0J4Ya9NPGnIkeG4hUCrJ1kQcII3cba"));
            startActivity(intent);
            return true;
        }
        if(id == R.id.rate)
        {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("market//details?id=" +getPackageName())));
            }catch(Exception ex){
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=" +getPackageName())));


            }
            return true;
        }
        if(id == R.id.more)
        {
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://fitness822761816.wordpress.com"));
            startActivity(intent);


            return true;
        }
        if(id == R.id.share)
        {
            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String sharebody = "This is the best for Fitness \n By this app you stretch your body \n" + "https://play.google.com/store/apps/details?id=com.miniproject.befit&hl=en";
            String sharehub = "BeFit App";
            myIntent.putExtra(Intent.EXTRA_SUBJECT,sharehub);
            myIntent.putExtra(Intent.EXTRA_TEXT,sharebody);
            startActivity(Intent.createChooser(myIntent,"share using"));
        }

       
        return true;
    }

    public void belowage18(View view) {

        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }

    public void aboveage18(View view) {
        Intent intent = new Intent(MainActivity.this,SecondActivity2.class);
        startActivity(intent);

    }

    public void food(View view) {
        Intent intent = new Intent(MainActivity.this,FoodActivity.class);
        startActivity(intent);

    }
}