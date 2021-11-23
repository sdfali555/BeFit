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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class SecondActivity extends AppCompatActivity {


    int[] newArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Toolbar toolbar=findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        newArray=new int[]{
                R.id.mountain_pose,R.id.basic_pose,R.id.chair_pose,R.id.child_pose,R.id.cobler_pose,R.id.cow_pose,R.id.playji_pose,R.id.pauseji_pose,R.id.plankji_pose,R.id.boat_pose,R.id.crunches_pose,R.id.sittup_pose,R.id.rotation_pose,R.id.twist_pose,R.id.windmill_pose,


        };
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

        return true;
    }


    public void Imagebuttonclicked(View view) {
        for (int i=0;i<newArray.length;i++){
            if (view.getId()==newArray[i]){
                int value=i+1;
                Log.i("FIRST",String.valueOf(value));
                Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);


            }
        }
    }
}