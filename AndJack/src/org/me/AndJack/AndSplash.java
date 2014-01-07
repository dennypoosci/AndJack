package org.me.AndJack;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class AndSplash  extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {

final boolean _active = true;
final int _splashTime = 3000; // time to display the splash screen in ms

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splmain);
        int rcnt=10;
        int x = 0;
        int dwait = 250;
        Button denbutton = (Button) findViewById(R.id.button1);
        ImageView leftImage= (ImageView) findViewById(R.id.imageView6);
        ImageView rightImage = (ImageView) findViewById(R.id.imageView1);
        ImageView lleftImage= (ImageView) findViewById(R.id.imageView5);
        ImageView rrightImage = (ImageView) findViewById(R.id.imageView2);
        ImageView llleftImage= (ImageView) findViewById(R.id.imageView4);
        ImageView rrrightImage = (ImageView) findViewById(R.id.imageView3);
        TextView dentext = (TextView) findViewById(R.id.Text1);
        dentext.setText("Shuffling the Deck");
        denbutton.setVisibility(View.GONE);
        denbutton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {  // onClick Method

          // denbutton Button
            	try {
					wait(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	finish();
            }});
        
        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while(_active && (waited < _splashTime)) {
                        sleep(100);
                        if(_active) {
                            waited += 100;
                        }
                    }
                } catch(InterruptedException e) {
                    // do nothing
                } finally {
                    finish();

 //                   stop();
                }
            }
        };      
        

while (x < rcnt) {

        TranslateAnimation leftAnim = new TranslateAnimation(0f, -130f, 0f, 0f);  

        leftAnim.setDuration(dwait);  

         leftAnim.setRepeatCount(rcnt);  

         leftImage.startAnimation(leftAnim);  

                   

       TranslateAnimation rightAnim = new TranslateAnimation(0f, 130f, 0f, 0f);  

        rightAnim.setRepeatCount(rcnt);  

         rightAnim.setDuration(dwait);  

        rightImage.startAnimation(rightAnim); 
        TranslateAnimation lleftAnim = new TranslateAnimation(0f, -100f, 0f, 0f);  

        lleftAnim.setDuration(dwait);  

         lleftAnim.setRepeatCount(rcnt);  

         lleftImage.startAnimation(lleftAnim);  

                   

       TranslateAnimation rrightAnim = new TranslateAnimation(0f, 100f, 0f, 0f);  

        rrightAnim.setRepeatCount(rcnt);  

         rrightAnim.setDuration(dwait);  

        rrightImage.startAnimation(rrightAnim); 

        TranslateAnimation llleftAnim = new TranslateAnimation(0f, -70f, 0f, 0f);  

        llleftAnim.setDuration(dwait);  

         llleftAnim.setRepeatCount(rcnt);  

         llleftImage.startAnimation(llleftAnim);  

                   

       TranslateAnimation rrrightAnim = new TranslateAnimation(0f, 70f, 0f, 0f);  

        rrrightAnim.setRepeatCount(rcnt);  

         rrrightAnim.setDuration(dwait);  

        rrrightImage.startAnimation(rrrightAnim); 
        final Handler handler = new Handler(); 
/*        Timer t = new Timer(); 
        t.schedule(new TimerTask() { 
                public void run() { 
                        handler.post(new Runnable() { 
                                public void run() { 
                                 int x = 1;
   //
                                 x = x + 1;
                                 x = x - 1;
                                } 
                                // }
                        }); 
                } 
        }, 500 * 2); 
        */
        x = x + 1;

    } 

splashTread.start();
//     denbutton.performClick();
    }
    
}