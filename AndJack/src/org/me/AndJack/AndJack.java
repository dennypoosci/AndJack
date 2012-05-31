package org.me.AndJack;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.InputStream;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.AbsoluteLayout.LayoutParams;
import android.graphics.drawable.*;
import android.graphics.*;


/**
 *
 * @author Dennis
 */
public class AndJack extends Activity {
        TextView  moneyfield;
/*        TextView  moneylabel; */
        TextView  thishand;
        TextView  nowthishand;
        TextView  playersscore;
        TextView  dealersscore;
        TextView  splitscore;
        TextView  splitfield;
        TextView  dealershand;
        Spinner  Bet;
        Canvas canvas;
        AnimationDrawable AniFrame;
        android.widget.ListView  denview;
        Button deal;
        Button hit;
        Button stand;
        Button split;
        Button dble;
        ImageView arr;
        ImageView denimage;
        ImageView dimage[];
        ImageView pimage[];
        ImageView simage[];
        ImageView cardgif[];
        int glWidth;
        int glHeight;
        int cardDur = 250;
        Integer[] Imgid = {
           R.drawable.c1,  R.drawable.c2,  R.drawable.c3,  R.drawable.c4,  R.drawable.c5,  R.drawable.c6,  R.drawable.c7,  R.drawable.c8,  R.drawable.c9,  R.drawable.c10,
           R.drawable.c11, R.drawable.c12, R.drawable.c13, R.drawable.c14, R.drawable.c15, R.drawable.c16, R.drawable.c17, R.drawable.c18, R.drawable.c19, R.drawable.c20,
           R.drawable.c21, R.drawable.c22, R.drawable.c23, R.drawable.c24, R.drawable.c25, R.drawable.c26, R.drawable.c27, R.drawable.c28, R.drawable.c29, R.drawable.c30,
           R.drawable.c31, R.drawable.c32, R.drawable.c33, R.drawable.c34, R.drawable.c35, R.drawable.c36, R.drawable.c37, R.drawable.c38, R.drawable.c39, R.drawable.c40,
           R.drawable.c41, R.drawable.c42, R.drawable.c43, R.drawable.c44, R.drawable.c45, R.drawable.c46, R.drawable.c47, R.drawable.c48, R.drawable.c49, R.drawable.c50,
           R.drawable.c51, R.drawable.c52, R.drawable.back
        };
        int ii;
        
        /* 
        Called automatically when the view's orientation changes or gets resized etc. 
    */
        /* ###########  Nested MyCustomView class which extends View  ########## */
        class MyCustomView extends View{

                   /* 
                       these viewWidth and viewHeight class variables 
                       will be used to store this CustomView's 
                       width and height dimensions as obtained from the automatic
                       onSizeChanged method
                     */

        		  int viewWidth = 0;
                  int viewHeight = 0;
                  /** public constructor */
                  public MyCustomView(Context context) {
                      super(context);
                  }
              
    /* 
       this protected void onSizeChanged(int , int, int, int) method is the one that does 
       the trick. In this method, you get your view's current dimensions, then you should store those
       dimension values into the global int variables. Later you can use these global variable values
       to manipulate your layout arrangements etc
    */


             /* 
                 Called automatically when the view's orientation changes or gets resized etc. 
             */
             @Override
       protected void onSizeChanged(int xNew, int yNew, int xOld, int yOld){
           super.onSizeChanged(xNew, yNew, xOld, yOld);
           viewWidth  = xNew;
           viewHeight = yNew;
           glWidth    = viewWidth;
           glHeight   = viewHeight;

           /*
             the onSizeChanged() method will be called automatically before the View gets 
              layed out, or drawn the first time. Also, whenever the orientation changes, 
              this view's onSizeChanged() method is automatically called again and, hence, 
              this view's new dimensions are obtained. 
              */
              /*
              The very first time this method gets called, the xOld and yOld values are 
              ZERO. Once it gets called, then the most recent or latest dimensions for this 
              view are obtained from the xNew and yNew values in this method. 
              These NEW dimensions of the view should be stored into class variables
              (the viewWidth and viewHeight integers mentioned earlier) 
              of this MyCustomView class. 
              These dimension values can THEN be used from other methods or from
              this method. As needed
             --------- thanks to kgiannakakis May 25 '10 at 9:18 - http://ow.ly/44hzw  
            */
       }
             protected void onDraw(Canvas canvas){
                 super.onDraw(canvas);

                 /*
                     finally, when the view gets drawn on to the screen using the onDraw() method, 
                     we display a Toast message using the viewWidth and viewHeight integers
                 */
 //                String msg = "width: " + viewWidth + "\n" + "height: " + viewHeight;
  //               Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
     
        }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
    	super.onConfigurationChanged(newConfig);
    		positionCards();
//    	setContentView(R.layout.main);
    }
    public void positionCards() {
        Display display = ((android.view.WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        /* Now we can retrieve all display-related infos */
       int width = display.getWidth();
       int height = display.getHeight();
       
       int orientation = display.getOrientation();
//       width = glWidth;
       for (int i = 0; i < dimage.length; i++){
        	int xd = (((width / 3) - (dimage[0].getWidth())) / 3);
         	int yd = 66 + (i * 20);
         LayoutParams	 layoutdParams = new LayoutParams(-2,-2, xd, yd);
          dimage[i].setLayoutParams(layoutdParams);
        	int xp = (((width / 3) - (dimage[0].getWidth())) / 3) + (width / 3);
         	int yp = 66 + (i * 20);
         LayoutParams	 layoutpParams = new LayoutParams(-2,-2, xp, yp);
          pimage[i].setLayoutParams(layoutpParams);
        	int xs = (((width / 3) - (dimage[0].getWidth())) / 3) + ((width / 3)*2);
         	int ys = 66 + (i * 20);
         LayoutParams	 layoutsParams = new LayoutParams(-2,-2, xs, ys);
          simage[i].setLayoutParams(layoutsParams);
            
       }
/*this.moneylabel.setText("width = "+ width); */
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (hit.isEnabled() == true && keyCode == KeyEvent.KEYCODE_H)  { // KeyEvent.* lists all the key codes u pressed
            // do something on Hit.
        	hit.performClick();
       }
        if (deal.isEnabled() == true && keyCode == KeyEvent.KEYCODE_D) { // KeyEvent.* lists all the key codes u pressed
            // do something on Deal.
        	deal.performClick();
       }
        if (dble.isEnabled() == true && keyCode == KeyEvent.KEYCODE_B) { // KeyEvent.* lists all the key codes u pressed
            // do something on Double.
        	dble.performClick();
       }
        if (stand.isEnabled() == true && keyCode == KeyEvent.KEYCODE_S) { // KeyEvent.* lists all the key codes u pressed
            // do something on Stand.
        	stand.performClick();
       }
        if (split.isEnabled() == true && keyCode == KeyEvent.KEYCODE_P) { // KeyEvent.* lists all the key codes u pressed
            // do something on Split.
        	split.performClick();
       }

            return super.onKeyDown(keyCode, event);
        }

    /** Called when the activity is first created. */
    @SuppressWarnings("deprecation")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       
        android.widget.AbsoluteLayout fL1 = (android.widget.AbsoluteLayout) findViewById(R.id.widget0);
        fL1.addView(new MyCustomView(getApplicationContext()));
        moneyfield = (TextView) this.findViewById(R.id.moneyfield);
/*        moneylabel = (TextView) this.findViewById(R.id.moneylabel); */
        thishand = (TextView) this.findViewById(R.id.thishand);
        nowthishand = (TextView) this.findViewById(R.id.nowthishand);
        playersscore = (TextView) this.findViewById(R.id.players);
        dealersscore = (TextView) this.findViewById(R.id.dealers);
        splitscore = (TextView) this.findViewById(R.id.splits);
        splitfield = (TextView ) this.findViewById(R.id.splitfield);
        dble = (Button) this.findViewById(R.id.dble);
        hit = (Button) this.findViewById(R.id.hit);
        stand = (Button) this.findViewById(R.id.stand);
        split = (Button) this.findViewById(R.id.split);
        deal = (Button) this.findViewById(R.id.deal);
        denimage = (ImageView) this.findViewById(R.id.image1);
        dealershand = (TextView) this.findViewById(R.id.dealershand);
        this.Bet = (Spinner) this.findViewById(R.id.Bet);
      ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
             this, R.array.denint, R.layout.spinner);
//       ArrayAdapter(string) adapterd = new ArrayAdapter(string)(this, R.layout.spinner_item, R.id.textview, R.array.denint);      

        //       adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.spinner);
        Bet.setAdapter(adapter);
        Bet.setSelection(12);
        
        dimage = new ImageView [7];
        dimage[0]= (ImageView) this.findViewById(R.id.image1);
        dimage[1]= (ImageView) this.findViewById(R.id.image2);
        dimage[2]= (ImageView) this.findViewById(R.id.image3);
        dimage[3]= (ImageView) this.findViewById(R.id.image4);
        dimage[4]= (ImageView) this.findViewById(R.id.image5);
        dimage[5]= (ImageView) this.findViewById(R.id.image6);
        dimage[6]= (ImageView) this.findViewById(R.id.image7);
        pimage = new ImageView [7];
        pimage[0]= (ImageView) this.findViewById(R.id.image11);
        pimage[1]= (ImageView) this.findViewById(R.id.image12);
        pimage[2]= (ImageView) this.findViewById(R.id.image13);
        pimage[3]= (ImageView) this.findViewById(R.id.image14);
        pimage[4]= (ImageView) this.findViewById(R.id.image15);
        pimage[5]= (ImageView) this.findViewById(R.id.image16);
        pimage[6]= (ImageView) this.findViewById(R.id.image17);
        simage = new ImageView [7];
        simage[0]= (ImageView) this.findViewById(R.id.image21);
        simage[1]= (ImageView) this.findViewById(R.id.image22);
        simage[2]= (ImageView) this.findViewById(R.id.image23);
        simage[3]= (ImageView) this.findViewById(R.id.image24);
        simage[4]= (ImageView) this.findViewById(R.id.image25);
        simage[5]= (ImageView) this.findViewById(R.id.image26);
        simage[6]= (ImageView) this.findViewById(R.id.image27);
        positionCards();
        this.arr = (ImageView) this.findViewById(R.id.myarr);
        this.arr.setImageResource(R.drawable.back);
        arr.setVisibility(View.INVISIBLE);
        initd=false;
 //       cardgif = new BufferedImage [53];
        money = 1000;
        hand1=true;
        deck = new Deck();
            Bet.setEnabled(true);
         
            deal.setEnabled(true);
            Bet.setVisibility(View.VISIBLE);
            splitfield.setVisibility(View.GONE);
            hit.setEnabled(false);
            stand.setEnabled(false);
            dble.setEnabled(false);
            split.setEnabled(false);
            this.nowthishand.setText("Players Hand");
            this.nowthishand.setVisibility(View.VISIBLE);
//                  this.nowthishand.setVisibility(View.INVISIBLE);
            this.thishand.setText("");
            this.thishand.setVisibility(View.VISIBLE);
            deal.requestFocus();
            canvas = new Canvas();

   // //    canvas.drawColor(Color.BLUE);
       // denimage =  android.graphics.BitmapFactory.decodeResource(getResources(),R.drawable.c1);
        denimage.setImageResource(Imgid[1]);
      //  Bitmap _scratch = BitmapFactory.decodeResource(getResources(), Imgid[1]);

        //canvas.drawBitmap(_scratch,10,10, null);
//        setListAdapter(new ArrayAdapter<String>(this,        android.R.layout.simple_list_item_1, Bett));
        cardgif = new ImageView [53];
        for (int ii = 1;ii < 54;ii++){
            if (ii < 54){

 //               File file = new File (denstr);
 //               BufferedImage input = ImageIO.read(file);
 //             Image input = Image.createImage(denstr);
 //             InputStream is = getClass().getResourceAsStream(denstr);
 //             Image input = new Image(is);
 //InputStream imageIn = this.getClass().getResourceAsStream(denstr);
 // buffer for speed
 //BufferedInputStream in = new BufferedInputStream(imageIn);

// check the cache, start with no image
//BufferedImage bi = ImageIO.read(in);


              denimage.setImageResource(Imgid[ii-1]);
               cardgif[ii-1] = denimage;
                }

//            cardgif[ii-1] = java.awt.getImage( getCodeBase(), ii + ".gif");
//            mt.addImage(cardgif[ii-1], ii);
     //       showStatus( "Loading " + ii + " of 53 gif files for cards");

        else{
//            cardgif[ii-1] = java.awt.getImage( getCodeBase(), "back.gif");
//                   try {
 //              File file = new File ("back.gif");
//                BufferedImage input = ImageIO.read(file);
//                InputStream imageIn = this.getClass().getResourceAsStream("/back.gif");
		// buffer for speed
//		BufferedInputStream in = new BufferedInputStream(imageIn);

		// check the cache, start with no image
//		BufferedImage bi = ImageIO.read(in);
              denimage.setImageResource(Imgid[ii-1]);
              cardgif[ii-1] = denimage;


                   }

     //      mt.addImage(cardgif[ii-1], ii);
        }

      //  android.graphics.Canvas.class.

  //      Drawable drawable = LoadImageFromWebOperations("http://www.androidpeople.com/wp-content/uploads/2010/03/android.png");

  //     denimage.setImageDrawable(drawable);

    //    denimage.


        deal.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {  // onClick Method

          // Deal Button

           nowthishand.setText("Players Hand");
           thishand.setText("");
           checkforshuffle();
           if (deck.shuffled == false){
                   initialDeal();
                   playersHand.showhand(false,false,playersscore);
                   dealersHand.showhand(true,true,dealersscore);
                   RestOfInitDeal();
           }

           deck.shuffled = false;


        nowthishand.setVisibility(View.VISIBLE);
        nowthishand.setText("Players Hand");
//      this.nowthishand.setVisibility(View.INVISIBLE);
        thishand.setText("");
        thishand.setVisibility(View.VISIBLE);
   //     this.thishand.repaint();
   //     this.thishand.validate();
   //     this.nowthishand.repaint();
   //     this.nowthishand.validate();

        moneyfield.setText("$" + money);
    //    repaint();
            paint (canvas);
            }});
        stand.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {  // onClick Method
                 // Stand button
            if (hand1) {
                if (splitting){
                	nowthishand.setText("");
                    nowthishand.setVisibility(View.VISIBLE);
                    thishand.setText("This Hand");
                    thishand.setVisibility(View.VISIBLE);
//                    thishand.validate();
//                    nowthishand.validate();
                    split.setEnabled(false);
                    playouthand (Integer.parseInt(Bet.getItemAtPosition(Bet.getSelectedItemPosition()).toString() ),splitHand);
                    splitHand.showsplithand(splitscore);}
                playouthand (Integer.parseInt(Bet.getItemAtPosition(Bet.getSelectedItemPosition()).toString()),playersHand);
                }
            else {
               if (splitting){
                   nowthishand.setVisibility(View.VISIBLE);
                   nowthishand.setText("Now This Hand");
                   thishand.setVisibility(View.VISIBLE);
                   thishand.setText("");
                   split.setEnabled(false);

               }
                 hand1=true;}

           moneyfield.setText("$" + money);
//            repaint();
              paint (canvas);
//            moneyfield.setText("mfield clicked");
            }});
        dble.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {  // onClick Method
 //           moneylabel.setText("mlabel clicked");
               
                
                 playersHand.addaCard(deck.DealaCard());
                 rdealacard(pimage[playersHand.numberofCards-1],arr,0);
                 playouthand (Integer.parseInt(Bet.getItemAtPosition(Bet.getSelectedItemPosition()).toString()) * 2,playersHand);
          moneyfield.setText("$" + money);
   //         repaint();
              paint (canvas);
            }});
       split.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {  // onClick Method
     //       splitscore.setText("split clicked");
                  splitting = true;
                 splitHand = new Hand();
                 splitHand.sethandType (3);
                 splitHand.addaCard(playersHand.Cards[1]);
                 playersHand.deleteaCard();
                 dealersHand.showhand(true,true,dealersscore);
                 playersHand.showhand(false,false,playersscore);
                 splitHand.showsplithand(splitscore);
                 dble.setEnabled(false);
                 split.setEnabled(false);
                 nowthishand.setVisibility(View.VISIBLE);
                 nowthishand.setText("");
                 thishand.setVisibility(View.VISIBLE);
                 thishand.setText("This Hand");
             //    thishand.repaint();
            //     thishand.validate();
            //     nowthishand.repaint();
            //     nowthishand.validate();

                 hand1=false;
        //         repaint();
        //         validate();


           moneyfield.setText("$" + money);
       //     repaint();
            paint (canvas);
            }});
        hit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {  // onClick Method
           if (hand1) {                // If splitting hand 1
              
                 playersHand.addaCard(deck.DealaCard()) ;
                 rdealacard(pimage[playersHand.numberofCards-1],arr,0);

            if (playersHand.handbusted()) {
                    dealershand.setText("Bust- $" + Bet.getItemAtPosition(Bet.getSelectedItemPosition()).toString());
                    denbet = Integer.parseInt(Bet.getItemAtPosition(Bet.getSelectedItemPosition()).toString());
                    money -=  denbet;
              //      integer.parseInt(denstr)
              //      money -= 50;
                    deal.setEnabled(true);
                    Bet.setVisibility(View.VISIBLE);
                    splitfield.setVisibility(View.GONE);
                    Bet.setEnabled(true);
                    hit.setEnabled(false);
                    dble.setEnabled(false);
                    split.setEnabled(false);
                    stand.setEnabled(false);
                    deal.requestFocus();
            if (splitting){
                    playouthand (java.lang.Integer.parseInt(Bet.getItemAtPosition(Bet.getSelectedItemPosition()).toString()),splitHand);
                    }
            playoutbool = true;
            dealersHand.showhand(true,false,dealersscore);}
            playersHand.showhand(false,false,playersscore); }
            else{
            	 
                    splitHand.addaCard(deck.DealaCard()) ;
                    rdealacard(simage[splitHand.numberofCards-1],arr,0);
                    if (splitHand.handbusted()) {
                            splitfield.setText("Bust- $" + Bet.getItemAtPosition(Bet.getSelectedItemPosition()).toString());
                            money -= Integer.parseInt(Bet.getItemAtPosition(Bet.getSelectedItemPosition()).toString());
                            hand1=true;
                            dealersHand.showhand(true,false,dealersscore);
                            nowthishand.setVisibility(View.VISIBLE);
                            nowthishand.setText("Now This Hand");
                            thishand.setVisibility(View.VISIBLE);
                            thishand.setText("");
                    			}
                    splitHand.showsplithand(splitscore); }

           moneyfield.setText("$" + money);
//            repaint();
//        thishand.setVisibility(View.VISIBLE);
//        nowthishand.setVisibility(View.VISIBLE);
        playersscore.setVisibility(View.VISIBLE);
        dealersscore.setVisibility(View.VISIBLE);
        splitscore.setVisibility(View.VISIBLE);
        dble.setEnabled(false);

            paint (canvas);
            }});

  //      moneyfield.setVisibility(1);
  //      moneylabel.setVisibility(1);
  //      thishand.setVisibility(View.VISIBLE);
  //      nowthishand.setVisibility(View.VISIBLE);
        playersscore.setVisibility(View.VISIBLE);
        dealersscore.setVisibility(View.VISIBLE);
        splitscore.setVisibility(View.VISIBLE);
        dble.setEnabled(false);
        paint (canvas);
                
 //       TextView tv = new TextView(this);
  //      tv.setText("Hello World");
  //      tv.setText(â€œHello Androidâ€);
 //      Button bt = new Button(this);
 //       bt.setText("go");
//        setContentView(tv);
 //      android.widget.
 //       setContentView(bt);
        // ToDo add your GUI initialization code here        
    }

       private void paint (Canvas g){             // Use paint for showing hands
//        String holdscore =   dealersscore.getText();
//        dealersscore.setText("");
       //          g.clearRect(1,1,400,500);
        //         this.jPanel1.repaint();
        //         this.jPanel1.revalidate();
     //     repaint();
      //    validate();
Paint paint = new Paint();
//RelativeLayout relativeView;

if (reallyShuffled) {
   //      arr.setBackgroundResource(R.drawable.card_animation);
   //      arr.setVisibility(View.VISIBLE);
   //       AniFrame = (AnimationDrawable) arr.getBackground();

   //       AniFrame.start();
   //         try {
   //             Thread.currentThread().sleep(4000);}
   //           catch ( java.lang.InterruptedException e) {
    //                 }
   //       AniFrame.stop();
       //   AniFrame.setLevel(500);
       //  g.drawText("Shuffling the Deck",70,105,null);
         for (int ii = 0;ii<10;ii++){
          for (int i=0;i<5;i++){
 //           try {
 //               Thread.currentThread().sleep(100);}
 //             catch ( java.lang.InterruptedException e) {
 //                    }
    //      Bitmap _scratch = BitmapFactory.decodeResource(getResources(), Imgid[52]);
       //   Bitmap _scratch1 = BitmapFactory.decodeResource(getResources(), this.cardgif[52]);

     //     Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, R.anim.denjackanim);
   //       denimage.startAnimation(hyperspaceJumpAnimation);
      //      g.drawBitmap(_scratch, 30 + (i * 15) , 110, null);

  //          relativeView.addView(_scratch);
  //          relativeView.draw(canvas);

 //           g.drawImage(cardgif[52], 30 + (i * 15) , 110, this);
  //           validate();
      //      g.drawBitmap(_scratch, 115 - (i * 15) , 110, null);
 //            validate();
        //   g.restore();

          }}
          playersHand.showhand(false,false,playersscore);
          dealersHand.showhand(true,true,dealersscore);
 //           AniFrame.stop();
  //          AniFrame.start();
          RestOfInitDeal();

          reallyShuffled = false;
       //  g.clearRect(1,1,400,500);
 //         repaint();
 //         validate();
    //      this.update(g);
    //      this.jPanel1.updateUI();
    //     this.jPanel1.repaint();
        //  this.jPanel1.validate();



//          deck.shuffled = false;
          reallyShuffled = false;
          }

//          g.clearRect(1,1,400,500);
        //  this.jPanel1.repaint();
       //   repaint();
         // validate();

//        hit.repaint();
//          deal.repaint();
//          stand.repaint();
//          split.repaint();
//          doubledown.repaint();
//          this.Bet.repaint();
//          this.dealershand.repaint();
//          this.splitfield.repaint();
//          this.splitscore.repaint();
//          this.dealersscore.repaint();
//          this.moneyfield.repaint();
//          this.moneylabel.repaint();
//          this.playersscore.repaint();
//          this.thishand.repaint();
//          this.nowthishand.repaint();



        //  this.jPanel1.repaint();
         // this.jPanel1.validate();

        if (initd){
        for (int i=0;i<7;i++)
        {
            pimage[i].setVisibility(View.INVISIBLE);
            dimage[i].setVisibility(View.INVISIBLE);
            simage[i].setVisibility(View.INVISIBLE);

        }
        for (int i=0;i<playersHand.numberofCards;i++){
          pimage[i].setVisibility(View.VISIBLE);
          pimage[i].setImageBitmap(BitmapFactory.decodeResource(getResources(), Imgid[playersHand.Cards[i].orgcardvalue]));
          Bitmap  _scratch = BitmapFactory.decodeResource(getResources(), Imgid[playersHand.Cards[i].orgcardvalue]);
            g.drawBitmap(_scratch, 90, 110 + (i * 25), paint);}
        for (int i=0;i<dealersHand.numberofCards;i++){
            if (i>1  && playoutbool) {
//            try {
//                Thread.currentThread().sleep(500);}
//              catch ( java.lang.InterruptedException e) {
//                     }

                     }
             if (i==0 ){
                if (!playoutbool){
                    dimage[i].setVisibility(View.VISIBLE);
                    dimage[i].setImageBitmap(BitmapFactory.decodeResource(getResources(), Imgid[52]));

                 Bitmap  _scratch = BitmapFactory.decodeResource(getResources(), Imgid[52]);
                 g.drawBitmap(_scratch, 10, 110 + (i * 25), paint);
                }
                else
                {
                 dimage[i].setVisibility(View.VISIBLE);
                 dimage[i].setImageBitmap(BitmapFactory.decodeResource(getResources(), Imgid[dealersHand.Cards[i].orgcardvalue]));
                  Bitmap  _scratch = BitmapFactory.decodeResource(getResources(), Imgid[dealersHand.Cards[i].orgcardvalue]);
                    g.drawBitmap(_scratch, 10, 110 + (i * 25), paint);}
                }
            else
             {
                 dimage[i].setVisibility(View.VISIBLE);
                 dimage[i].setImageBitmap(BitmapFactory.decodeResource(getResources(), Imgid[dealersHand.Cards[i].orgcardvalue]));
                Bitmap  _scratch = BitmapFactory.decodeResource(getResources(), Imgid[dealersHand.Cards[i].orgcardvalue]);
              g.drawBitmap(_scratch, 10, 110 + (i * 25), paint);}

             }
//            dealersscore.setText("" + holdscore);
        if (splitting){
           for (int i=0;i<splitHand.numberofCards;i++){
               simage[i].setVisibility(View.VISIBLE);
               simage[i].setImageBitmap(BitmapFactory.decodeResource(getResources(), Imgid[splitHand.Cards[i].orgcardvalue]));
               Bitmap  _scratch = BitmapFactory.decodeResource(getResources(), Imgid[splitHand.Cards[i].orgcardvalue]);
               g.drawBitmap(_scratch, 170, 110 + (i * 25), paint);}
               }
//            if (playoutbool){
       
//            try {
//                Thread.currentThread().sleep(500);}
//              catch ( java.lang.InterruptedException e) {
//                     }
//
//              }

            }
    }
     private Drawable LoadImageFromWebOperations(String url)
   {
        try
         {
             InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
             return d;
        }catch (Exception e) {
             System.out.println("Exc="+e);
            return null;
        }
    }

//	public void onClick(View v) {
//		if (this.deal.) {
//			this.dealersscore.setText("im clicked");
  //                 		}
//			}



void playouthand (int thebet, Hand theHand)
{
	  int iwait = cardDur;
            while(dealersHand.mustHit())
            {

                dealersHand.addaCard(deck.DealaCard());
                rdealacard(dimage[dealersHand.numberofCards-1],arr,iwait);
                iwait = iwait + cardDur;
                }
        if (dealersHand.handbusted()) {
             if (theHand.gethandType() == 3 && !theHand.handbusted())
                    splitfield.setText("Dlr bust+ $" + thebet);
                  else
                    dealershand.setText("Dlr bust+ $" + thebet);
             money += thebet;
        }
        else
         if (dealersHand.currentScore() == theHand.currentScore ())
            if (theHand.gethandType() == 3 && !theHand.handbusted())
                 splitfield.setText("You tie!!");
               else
                 dealershand.setText("You tie!!");
        else
         if (dealersHand.currentScore() < theHand.currentScore ()){
            if (theHand.gethandType() == 3 && !theHand.handbusted())
                  splitfield.setText("Splt w $" + thebet);
               else
                  dealershand.setText("Win $" + thebet);
             money += thebet;

         }
        else
        if (dealersHand.currentScore() > theHand.currentScore ()){
            if (theHand.gethandType() == 3 && !theHand.handbusted())
             splitfield.setText("Splt- $" + thebet);
               else
             dealershand.setText("Lose $" + thebet);
             money -= thebet;
        }
            if (splitting){
                splitHand.showsplithand(splitscore);}
            dealersHand.showhand(true,false,dealersscore);
            theHand.showhand(false,false,playersscore);
            if (hand1){
                deal.setEnabled(true);
                Bet.setVisibility(View.VISIBLE);
                splitfield.setVisibility(View.GONE);
                Bet.setEnabled(true);
                hit.setEnabled(false);
                dble.setEnabled(false);
                split.setEnabled(false);
                stand.setEnabled(false);
                deal.requestFocus();
                }
        playoutbool = true;

}

void checkforshuffle( )
{
        if (deck.shuffled == true){
           reallyShuffled = true;
   //        repaint();
   //        validate();
//            try {
//                repaint();
//                validate();
//                Thread.currentThread().sleep(1500);}
//              catch ( java.lang.InterruptedException e) {
//           repaint();
//           validate();
//                     }
           initialDeal();

           }

}
void initialDeal() {

        playoutbool = false;
        splitfield.setText("");
        dealershand.setText("");
        splitscore.setText("");
        playersHand = new Hand();
        playersHand.sethandType (2);
        dealersHand = new Hand();
        dealersHand.sethandType (1);
        initd=true;
        splitting = false;
    	int iwait = 0;
        this.denimage = dimage[0];
        for(int i = 0;i<2;++i)
        {
        	/*
            int startOffset = 0;
            int[] arrLocation = { 0, 0 };
            this.arr.getLocationInWindow(arrLocation);
            int[] dealLocation = { 0, 0 };
            this.dimage[i].getLocationInWindow(dealLocation);
            int[] playLocation = { 0, 0 };
            this.pimage[i].getLocationInWindow(playLocation);
            TranslateAnimation dealCardAnim = new TranslateAnimation(
                Animation.ABSOLUTE, arrLocation[0],
                Animation.ABSOLUTE, dealLocation[0],
                Animation.ABSOLUTE, arrLocation[1],
                Animation.ABSOLUTE, dealLocation[1]);
         //   arr = dimage[0];
            dealCardAnim.setDuration(500);
            dealCardAnim.setStartOffset(300 * startOffset++);
         //   arr.startAnimation(dealCardAnim);
         //   arr.startAnimation(dealCardAnim);
 
             dimage[i].startAnimation(dealCardAnim);
      //      dimage[i].startAnimation(dealCardAnim);
            TranslateAnimation playCardAnim = new TranslateAnimation(
                Animation.ABSOLUTE, arrLocation[0],
                Animation.ABSOLUTE, playLocation[0],
                Animation.ABSOLUTE, arrLocation[0],
                Animation.ABSOLUTE, playLocation[0]);

            playCardAnim.setDuration(500);
            playCardAnim.setStartOffset(300 * startOffset++);
       //     denimage.startAnimation(playCardAnim);
        //   pimage[i].startAnimation(playCardAnim);
            pimage[i].startAnimation(dealCardAnim);
            */
            if (iwait > 0){
            	iwait = iwait + cardDur;
            }
            playersHand.addaCard(deck.DealaCard());
            rdealacard(pimage[playersHand.numberofCards-1],arr,iwait);
           	iwait = iwait + cardDur;
            dealersHand.addaCard(deck.DealaCard());
            rdealacard(dimage[dealersHand.numberofCards-1],arr,(iwait));
        }

}
void rdealacard (ImageView incard, ImageView arr,int startOffset) {


 /* final  Thread promoThread = new Thread() {
        

		@Override
        public void run() {
            try {
*/
//  	 int startOffset = 0;
     int[] arrLocation = { 0, 0 };
  //   arr = (ImageView) this.findViewById(R.drawable.back);
    // arr.setVisibility(View.VISIBLE);
     arr.getLocationInWindow(arrLocation);
//     int[] dealLocation = { 0, 0 };
//     this.dimage[0].getLocationInWindow(dealLocation);
     int[] playLocation = { 0, 0 };
     incard.getLocationInWindow(playLocation);
     TranslateAnimation dealCardAnim = new TranslateAnimation(
         Animation.ABSOLUTE, arrLocation[0],
         Animation.ABSOLUTE, playLocation[0],
         Animation.ABSOLUTE, arrLocation[1],
         Animation.ABSOLUTE, playLocation[1]);
     //arr = (ImageView) this.findViewById( R.drawable.back);
     
     dealCardAnim.setDuration(cardDur);
     dealCardAnim.setStartOffset(startOffset + 1);
     
 //    dealCardAnim.start();
     
  //   arr.startAnimation(dealCardAnim);
  //   arr.startAnimation(dealCardAnim);
      
      incard.startAnimation(dealCardAnim);
 //     incard.postInvalidate();
      final Handler handler = new Handler(); 
      Timer t = new Timer(); 
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
      }, cardDur); 
      
//      dimage[i].startAnimation(dealCardAnim);
 /*    while (!dealCardAnim.hasEnded())
     {
    	 int qq = 0;
    	 qq++;
    	 
     }
*/
  /*    boolean _active = true;
      int _splashTime = 5000; // time to display the splash screen in ms

      int waited = 0;
      while (_active && (waited < _splashTime)) {
          sleep(100);
          if (_active) {
              waited += 100;
          }
      }
  } catch (InterruptedException ex) {

  } finally {
      finish();
//      startActivity(new Intent("com.mobibob.promo.AboutActivity"));
      stop();
  }

  }
		
		 
};
promoThread.start();
}
//promoThread.start();
//}

//@Override
//public void onAnimationEnd(Animation animation) {
//    Log.d(TAG, "onAnimationEnd");
//    startActivity(new Intent("com.mobibob.promo.AboutActivity"));
*/
            }
            
void RestOfInitDeal () {

    if (dealersHand.isBlackJack() && playersHand.isBlackJack()) {
        dealershand.setText("Tie BJ!!!");
        dealersHand.showhand(true,false,dealersscore);
        playoutbool = true;
        money -= Integer.parseInt( Bet.getItemAtPosition(Bet.getSelectedItemPosition()).toString()) ;
    //    money -=50;
        }
    else
        if (dealersHand.isBlackJack() && !playersHand.isBlackJack()) {
            dealershand.setText("Dealer 21");
            dealersHand.showhand(true,false,dealersscore);
            playoutbool = true;
            money -= Integer.parseInt( Bet.getItemAtPosition(Bet.getSelectedItemPosition()).toString()) ;
        //    money -=50;
            }
        else
           if (playersHand.isBlackJack()) {
          dealershand.setText("BlackJack $" + (Integer.parseInt( Bet.getItemAtPosition(Bet.getSelectedItemPosition()).toString()) * 1.5));
  //         dealershand.setText("BlackJack $" + ( money += 50 * 1.5));
            dealersHand.showhand(true,false,dealersscore);
            playoutbool = true;
          money += (Integer.parseInt( Bet.getItemAtPosition(Bet.getSelectedItemPosition()).toString()) * 1.5) ;
       //     money += 50 * 1.5;
            }

        else{
            Bet.setEnabled(false);
            deal.setEnabled(false);
            Bet.setVisibility(View.GONE);
            splitfield.setVisibility(View.VISIBLE);
            hit.setEnabled(true);
            stand.setEnabled(true);
            dble.setEnabled(false);
            split.setEnabled(false);
//            if (playersHand.currentScore() == 10 || playersHand.currentScore() == 11)
            if (playersHand.currentScore() < 12 || (playersHand.Cards[0].cardvalue == 1 ||
                                                    playersHand.Cards[1].cardvalue == 1))
                {
                dble.setEnabled(true);
                }
            if (playersHand.Cards[0].cardalpha.toString() == playersHand.Cards[1].cardalpha.toString())
            {
                split.setEnabled(true);
            }
            }

    }
    private boolean reallyShuffled = false;
    private boolean hand1;
    private boolean playoutbool;
    private boolean splitting;
    private boolean initd;
//    private int bet;
    private int money;
    private int denbet;
//    private MediaTracker mt;
    private Deck deck;
 //   private JPanel splithand;
    private Hand playersHand;
    private Hand dealersHand;
    private Hand splitHand;
//    private final int MaxCardsArray = 9;
//    private Image cardgif[];
//    private String denstr;
    static final String [] Bett = new String [] {
        "1", "2", "3", "4", "5", "10", "15", "20", "25", "50", "75", "101"
    };
    }

//

class Deck {
    int cardsindeck = 52;
    int cards [];           // array of the cards in a deck
    int currentcard;        // index for the currentcard
    boolean shuffled = false;
    public Deck() {         // Constructor for the Deck of cards
    cards = new int [cardsindeck];   // Construct 52 int pointers for deck
    for (int i = 0;i < cardsindeck-1;i++)  // increment counter for each card
    {
        cards[i] = i + 1;
    }
    currentcard = 0;        // start at first card
    shufflethedeck();
    }
    public void shufflethedeck() {
        for (int i=0;i<(cardsindeck*2);i++) {
            int tmpcard1 = randomCard();
            int tmpcard2 = randomCard();
            int holdcard = cards[tmpcard1];
            cards[tmpcard1] = cards [tmpcard2];
            cards[tmpcard2] = holdcard;
        }
        shuffled = true;
    }
    int randomCard(){
        return ((int) (Math.random() * cardsindeck));
    }
    Card DealaCard (){
        if (currentcard > 51 ) {
            shufflethedeck();
            currentcard = 0;
        }
        return new Card(cards[currentcard++]);
    }
}
    class Hand {    // Hand Class
        int numberofCards;
        int type;          // type 1 = dealer 2 = player 3 = split
        Card Cards [];
        int MaxCards = 10;
        public Hand (){
            numberofCards = 0;
            Cards = new Card[MaxCards];
        }
        void addaCard(Card acard){
            Cards[numberofCards++] = acard;
        }
        void deleteaCard(){
            numberofCards--;
        }
        void sethandType(int typ){
            type = typ;
        }
        int gethandType(){
            return type;
        }

        boolean isBlackJack (){
            if (numberofCards == 2){
                if (Cards[0].cardvalue == 1 &&
                    Cards[1].cardvalue == 10) return true;
                if (Cards[1].cardvalue == 1 &&
                    Cards[0].cardvalue == 10) return true;
            }
            return false;
        }
        boolean under22 (){
            int twentytwo = 22;
            int handvalue = 0;
            for (int i=0;i<numberofCards;i++){
                handvalue += Cards[i].cardvalue;
            }
            if (handvalue < twentytwo)
                return true;
            else
                return false;
        }
        void showhand (boolean isDealer,boolean hideFirstCard,android.widget.TextView harray ){

            if(isDealer && !hideFirstCard) {
            harray.setText("Dealer " + currentScore());
            }
            else
            {harray.setText("");}

            if (!isDealer){
            harray.setText("Player " + currentScore());}

            }


        void showsplithand (android.widget.TextView harray ){


            harray.setText("Split " + currentScore());


        }

        int currentScore(){
            int handvalue = 0;
            boolean arethereAces = false;
            for (int i=0;i<numberofCards;i++) {
                handvalue += Cards[i].cardvalue;
                if (Cards[i].cardvalue == 1) arethereAces = true;
            }
            if (arethereAces){
                if (handvalue + 10 < 22) handvalue += 10;
            }
            return handvalue;
        }
        boolean mustHit(){
            if (currentScore() < 17)
                return true;
                else
                return false;
    }
        boolean handbusted (){
            if (!under22())
            return true;
            else
            return false;
        }



    }

class Card          // Card Class
{
    int orgcardvalue;
    int cardvalue;          // numeric from 1 to 10
    String cardsuit;        // suit from card value /4 + 1
    String cardalpha;       // Alpha of numeric cardvalue
    String cardcards [] = { "Ace", "Two", "Three", "Four", "Five",
                            "Six", "Seven", "Eight", "Nine", "Ten",
                            "Jack", "Queen", "King"};
   public Card (int i){    // Constructor



        orgcardvalue = i;
        cardvalue = i%13 +1;
        switch (i/13){
        case 0:
            cardsuit = "Spades";
            break;
        case 1:
            cardsuit = "Hearts";
            break;
        case 2:
            cardsuit = "Clubs";
            break;
        default:
            cardsuit = "Diamonds";
            break;
        }

        cardalpha = cardcards[cardvalue-1];
        if (cardvalue >10) cardvalue = 10;
   }
   int getCardValue() {return cardvalue;}
}
