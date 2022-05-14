package com.example.phnx168;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int clickNum = 0;
    private Handler handler = new Handler();
    private Button btnGebEnte,btnGebHänchen,btnGebackeneHühnerFilet,btnGebNudel,btnGebReis,btnGebGemüse,btnGebKartoffeln,btnChampignons,btnGebackeneAnanas;
    private Button btnBohnen,btnHühnerfiletSpargel,btnGarnelenScharf,btnChickenWings,btnRindFleischZwiebel,btnBroccoli;
    private Button btnHühnerfilietKnoblauch,btnAchtKostbarkeiten,btnHühnerfleischKungbo,btnomelett,btnCurryHuhn,btnGebKäse;
    private Button btnGebackeneGarnelen, btnChickenNuggets, btnGebBanane, btnpommes,btnTintenfischRing;
    private Button btnGebackenesfischfilet,btnMiniFrühlingsrolle, btnGebackeneWantan, btnGebackeneSesambällchen;
    private Button btnSoß_Pikante, btnSoß_Süßsauer,btnSoße_Erdnuss, btnReis, btnSuppe, btnSchoko,btnSchalenklein, btnSchalenGroß, btnUnterlage;
    private TextView txtSesam,txtCurry,txtRind,txtMongolisch,txtSchaleGroß,txtErdnuss, txtUnterlage, btnSchalen_shao,btnOption,txtEnte, txtHähchen, txtHühnerfilet,txtOption,txtBroccoli, txtSchoko;
    private SeekBar sb_Sesam,sb_Curry,sb_Rind, sb_GebEnte, sb_GebHänchen, sb_GebHänchenFilet,sb_Broccoli, sb_SchaleGroß,sb_Unterlage,sb_Schaleklein,sb_Schoko;
    private Context txt_sb_GebEnte, txt_sb_GebHänchen, txt_sb_GebHänchenFilet,txt_sb_Broccoli;// for the Toast when SeekBar move
    private Vibrator vibrator;
//------------------------------------------------------------------------------------------------------------------------------------//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//取消状态栏

        //----------------- home键: 后台运行-----------------------------------------------------
        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            finish();
            return;
        }
        //-------------------------------------------------------------------------------------
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null){getSupportActionBar().hide();} //取消标题栏
        vibrator=(Vibrator)getSystemService(Service.VIBRATOR_SERVICE); //获取系统的Vibrator服务
        // 按键抖动
        final Animation animation = new AlphaAnimation(1, 0); // Change alpha from fully visible to invisible
                animation.setDuration(500); // duration - half a second
                animation.setInterpolator(new LinearInterpolator()); // do not alter animation rate
                animation.setRepeatCount(Animation.INFINITE); // Repeat animation infinitely
                animation.setRepeatMode(Animation.REVERSE); // Reverse animation at the end so the button will fade back in


        // --------------- home键: 后台运行--2----------避免从桌面启动程序后，会重新实例化入口类的activity
        if (!this.isTaskRoot()) { // 判断当前activity是不是所在任务栈的根
            Intent intent = getIntent();
            if (intent != null) {
                String action = intent.getAction();
                if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && Intent.ACTION_MAIN.equals(action)) {
                    finish();
                    return;
                }
            }
        }

//----------------------------------------Test Button-----------------------------------------------------------------------------------------//
        btnOption= (Button) findViewById(R.id.btnOption);
/*        btnOption.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                //vibrator.vibrate(100);// 震动开
                if (btnOption.isActivated()==true){
                    btnOption.setActivated(false);
                    btnOption.setSelected(true);
                }
                else if (btnOption.isSelected()==true){
                    btnOption.setSelected(false);
                }
                else if(btnOption.isHovered()==true)
                { btnOption.setHovered(false);}
                else {
                    btnOption.setActivated(true);
                }
            }
        });*/

/*        btnOption.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
                    btnOption.setActivated(false);
                    btnOption.setSelected(false);
                    btnOption.setHovered(true);
                    vibrator.vibrate(100);
                    //Toast.makeText(MainActivity.this,"长按点击",Toast.LENGTH_SHORT).show();
                    return true;
            }
        });*/

//----------------------------------------Test Button-----------------------------------------------------------------------------------------//
        btnOption= (Button) findViewById(R.id.btnOption);
        /**/txtOption = (TextView) findViewById(R.id.txtOption);
/*        btnOption.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                //vibrator.vibrate(100);// 震动开
                if (btnOption.isActivated()==true){
                    btnOption.setActivated(false);
                    btnOption.setSelected(true);
                }
                else if (btnOption.isSelected()==true){
                    btnOption.setSelected(false);
                }
                else if(btnOption.isHovered()==true)
                { btnOption.setHovered(false);}
                else {
                    btnOption.setActivated(true);
                }
            }
        });*/

/*        btnOption.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
                    btnOption.setActivated(false);
                    btnOption.setSelected(false);
                    btnOption.setHovered(true);
                    vibrator.vibrate(100);
                    //Toast.makeText(MainActivity.this,"长按点击",Toast.LENGTH_SHORT).show();
                    return true;
            }
        });*/

        //-----------------------------长按复原-----------------------------------------------------------------
        btnOption.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
                if   (btnOption.isHovered()==true){
                    btnOption.setHovered(false);}
                else{
                    vibrator.vibrate(500);
                    btnOption.setActivated(false);
                    btnOption.setSelected(false);
                    btnOption.setHovered(true);}
                //;// 震动开
                //Toast.makeText(MainActivity.this,"长按点击",Toast.LENGTH_SHORT).show();
                return true;
            }
        });

// ---------------------------------------双击---------------------------------------------------------------
        btnOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickNum++;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (clickNum == 1) {
                            Log.d("btn listener:", "btn is clicked!");
                            if (btnOption.isActivated()==true){
                                btnOption.setText("剁椒");
                                txtOption.setText("Chili");
                                btnOption.setActivated(false);
                                btnOption.setSelected(true);
                            }
                            else if (btnOption.isSelected()==true){
                                btnOption.setText("待定");
                                txtOption.setText("Option");
                                btnOption.setSelected(false);
                            }
                            else if(btnOption.isHovered()==true)
                            {btnOption.setHovered(false);
                                btnOption.setText("待定");
                                txtOption.setText("Option");

                            }
                            else {
                                btnOption.setActivated(true);
                            }
                        }else if(clickNum==2){       //双击
                            Log.d("btn listener:", "btn is doubleClicked!");
                            btnOption.setHovered(false);
                            btnOption.setActivated(false);
                            btnOption.setSelected(false);

                            btnCurryHuhn.setHovered(true);
                            btnCurryHuhn.startAnimation(animation);
                            btnAchtKostbarkeiten.setHovered(true);
                            btnAchtKostbarkeiten.startAnimation(animation);
                            btnRindFleischZwiebel.setHovered(true);
                            btnRindFleischZwiebel.startAnimation(animation);
                            btnBroccoli.setHovered(true);
                            btnBroccoli.startAnimation(animation);
                            btnGebBanane.setHovered(true);
                            btnGebBanane.startAnimation(animation);
                            btnGebackeneAnanas.setHovered(true);
                            btnGebackeneAnanas.startAnimation(animation);
                            btnSuppe.setHovered(true);
                            btnSuppe.startAnimation(animation);
                            btnSchoko.setHovered(true);
                            btnSchoko.startAnimation(animation);
                            btnOption.setHovered(true);
                            btnOption.startAnimation(animation);

                            btnBohnen.setHovered(true);
                            btnBohnen.startAnimation(animation);
                            btnGebKartoffeln.setHovered(true);
                            btnGebKartoffeln.startAnimation(animation);
                            btnGebReis.setHovered(true);
                            btnGebReis.startAnimation(animation);
                            btnGebNudel.setHovered(true);
                            btnGebNudel.startAnimation(animation);
                            btnGebEnte.setHovered(true);
                            btnGebEnte.startAnimation(animation);
                            btnGebackeneHühnerFilet.setHovered(true);
                            btnGebackeneHühnerFilet.startAnimation(animation);
                            btnSchalen_shao.setHovered(true);
                            btnSchalen_shao.startAnimation(animation);
                            btnUnterlage.setHovered(true);
                            btnUnterlage.startAnimation(animation);
                            btnSchalenklein.setHovered(true);
                            btnSchalenklein.startAnimation(animation);
                            btnSchalen_shao.setHovered(true);
                            btnSchalen_shao.startAnimation(animation);
                            btnSchalenGroß.setHovered(true);
                            btnSchalenGroß.startAnimation(animation);

                        }
//---------------------------------Love--cc----------三连击------------------------------------
                        else if (clickNum==3){
                            btnOption.setHovered(false);
                            btnOption.setActivated(false);
                            btnOption.setSelected(false);
                            btnOption.setEnabled(false);

                            btnCurryHuhn.setHovered(false);
                            btnAchtKostbarkeiten.setHovered(false);
                            btnRindFleischZwiebel.setHovered(false);
                            btnBroccoli.setHovered(false);
                            btnGebBanane.setHovered(false);
                            btnGebackeneAnanas.setHovered(false);
                            btnSuppe.setHovered(false);
                            btnSchoko.setHovered(false);
                            btnOption.setHovered(false);


                            btnBohnen.setHovered(false);
                            btnGebKartoffeln.setHovered(false);
                            btnGebReis.setHovered(false);
                            btnGebNudel.setHovered(false);
                            btnGebEnte.setHovered(false);
                            btnGebackeneHühnerFilet.setHovered(false);
                            btnSchalen_shao.setHovered(false);
                            btnUnterlage.setHovered(false);
                            btnSchalenklein.setHovered(false);
                            btnSchalen_shao.setHovered(false);
                            btnSchalenGroß.setHovered(false);

                            btnGebackeneAnanas.clearAnimation();
                            btnAchtKostbarkeiten.clearAnimation();
                            btnCurryHuhn.clearAnimation();
                            btnGebKartoffeln.clearAnimation();
                            btnGebEnte.clearAnimation();
                            btnCurryHuhn.clearAnimation();
                            btnSuppe.clearAnimation();
                            btnOption.clearAnimation();

                            //btnGebackeneHühnerFilet.clearAnimation();

                            btnBroccoli.setBackground(getDrawable(R.drawable.love_button));
                            btnBroccoli.startAnimation(animation);
                            btnRindFleischZwiebel.setBackground(getDrawable(R.drawable.love_button));
                            btnRindFleischZwiebel.startAnimation(animation);
                            btnomelett.setBackground(getDrawable(R.drawable.love_button));
                            btnomelett.startAnimation(animation);
                            btnHühnerfleischKungbo.setBackground(getDrawable(R.drawable.love_button));
                            btnHühnerfleischKungbo.startAnimation(animation);
                            btnHühnerfiletSpargel.setBackground(getDrawable(R.drawable.love_button));
                            btnHühnerfiletSpargel.startAnimation(animation);
                            btnGebKäse.setBackground(getDrawable(R.drawable.love_button));
                            btnGebKäse.startAnimation(animation);
                            btnGebBanane.setBackground(getDrawable(R.drawable.love_button));
                            btnGebBanane.startAnimation(animation);
                            btnGebackeneSesambällchen.setBackground(getDrawable(R.drawable.love_button));
                            btnGebackeneSesambällchen.startAnimation(animation);
                            btnGebackenesfischfilet.setBackground(getDrawable(R.drawable.love_button));
                            btnGebackenesfischfilet.startAnimation(animation);
                            btnSchoko.setBackground(getDrawable(R.drawable.love_button));
                            btnSchoko.startAnimation(animation);

                            btnBohnen.setActivated(true);
                            btnChampignons.setActivated(true);
                            btnChampignons.startAnimation(animation);
                            btnChickenNuggets.setActivated(true);
                            btnChickenNuggets.startAnimation(animation);
                            btnGebackeneHühnerFilet.setActivated(true);
                            btnGebHänchen.setActivated(true);
                            btnGebHänchen.startAnimation(animation);
                            btnGebReis.setActivated(true);
                            btnGebNudel.setActivated(true);
                            btnSoße_Erdnuss.setActivated(true);
                            btnSoße_Erdnuss.startAnimation(animation);
                            btnSoß_Süßsauer.setActivated(true);
                            btnSoß_Süßsauer.startAnimation(animation);
                            btnSoß_Pikante.setActivated(true);
                            btnSoß_Pikante.startAnimation(animation);

                            btnSchalen_shao.setHovered(true);
                            btnSchalenGroß.setHovered(true);
                            btnSchalenklein.setHovered(true);
                            btnUnterlage.setHovered(true);
                        }
                        //防止handler引起的内存泄漏
                        handler.removeCallbacksAndMessages(null);
                        clickNum = 0;}
                },300);
            }
        });
 //----------------------------------------------------炸鸭---fertig-------------------------------------------------------//
    txt_sb_GebEnte = this;
    sb_GebEnte = (SeekBar) findViewById(R.id.sb_GebEnte);
    txtEnte = (TextView) findViewById(R.id.txtEnte);

    sb_GebEnte.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
        @Override
        public void onProgressChanged (SeekBar seekBar,int progress, boolean fromUser){

            if(sb_GebEnte.getProgress()==0){
                txtEnte.setText("Ente");
                btnGebEnte.setText("炸 鸭");
                btnGebEnte.setHovered(false);
                btnGebEnte.setActivated(false);
                btnGebEnte.setSelected(false);
                btnGebEnte.setBackground(getDrawable(R.drawable.btn_press_switch_berate)); //---------------
            }

            else{btnGebEnte.setText("炸鸭 " + progress);
                //txtEnte.setText("Enten: " + progress);
                btnGebEnte.setHovered(true);
                btnGebEnte.setActivated(false);
                btnGebEnte.setSelected(false);
                btnGebEnte.setBackground(getDrawable(R.drawable.blue_press_berate));   //---------------

            }
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar){
            //Toast.makeText(txt_sb_GebEnte,"Achtung!  Gebackene Ente ...Gebackene Ente ...Ente", Toast.LENGTH_LONG).show();
        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    });

    btnGebEnte = (Button) findViewById(R.id.Gebackene_Ente);
    btnGebEnte.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick (View v) {
        if (btnGebEnte.isActivated()==true){
            btnGebEnte.setActivated(false);
/*            btnGebEnte.setHovered(false);
            btnGebEnte.setBackground(getDrawable(R.drawable.btn_press_switch)); //---------------*/
            btnGebEnte.setSelected(true);
        }
        else if (btnGebEnte.isSelected()==true||btnGebEnte.isHovered()==true){
            btnGebEnte.setSelected(false);
            btnGebEnte.setHovered(false);
            btnGebEnte.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
            sb_GebEnte.setProgress(0);
        }
        else if (sb_GebEnte.getBackground()==getDrawable(R.drawable.blue_press_berate))
        {sb_GebEnte.setBackground(getDrawable(R.drawable.btn_press_switch_berate));}
        else { btnGebEnte.setActivated(true);
        }
    }
    });

    btnGebEnte.setOnLongClickListener(new View.OnLongClickListener(){
        public boolean onLongClick(View v){
            vibrator.vibrate(100);
            btnGebEnte.setHovered(true);
            btnGebEnte.setBackground(getDrawable(R.drawable.blue_press_berate));
            btnGebEnte.setSelected(false);
            btnGebEnte.setActivated(false);
            sb_GebEnte.setProgress(3);     // one click by Default Number is 2
            return true;
        }
    });
//------------------------------------------------------炸鸡---fertig-------------------------------------------------------//
        txt_sb_GebHänchen = this;
        sb_GebHänchen = (SeekBar) findViewById(R.id.sb_GebHächen);
        txtHähchen = (TextView) findViewById(R.id.txtHähchen);
        sb_GebHänchen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged (SeekBar seekBar,int progress, boolean fromUser){

                if(sb_GebHänchen.getProgress()==0){
                    btnGebHänchen.setText("炸 鸡");
                    txtHähchen.setText("Hähnchen");
                    btnGebHänchen.setHovered(false);
                    btnGebHänchen.setActivated(false);
                    btnGebHänchen.setSelected(false);
                    btnGebHänchen.setBackground(getDrawable(R.drawable.btn_press_switch_berate));

                }
/*                else if(sb_GebHänchen.getProgress()==5){
                    btnGebHänchen.setHovered(true);
                    btnGebHänchen.setText("炸鸡底");
                    txtHähchen.setText("Geb. Hähchen mit Unterlage");
                }*/
                    else{btnGebHänchen.setText("炸鸡 " + progress);
                    btnGebHänchen.setHovered(true);
                    btnGebHänchen.setActivated(false);
                    btnGebHänchen.setSelected(false);
                    btnGebHänchen.setBackground(getDrawable(R.drawable.blue_press_berate));
                    //txtHähchen.setText("Hähnchen: " + progress);
                    }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        btnGebHänchen = (Button) findViewById(R.id.Gebackenes_Hähnchen);
        btnGebHänchen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                if (btnGebHänchen.isActivated()==true ){
                    btnGebHänchen.setActivated(false);
                    btnGebHänchen.setHovered(false);
                    btnGebHänchen.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
                    btnGebHänchen.setSelected(true);
                }
                else if (btnGebHänchen.isSelected()==true || btnGebHänchen.isHovered()==true){
                    btnGebHänchen.setSelected(false);
                    btnGebHänchen.setHovered(false);
                    btnGebHänchen.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
                    sb_GebHänchen.setProgress(0);
                }
                else if (sb_GebHänchen.getBackground()==getDrawable(R.drawable.blue_press_berate))
                {
                    sb_GebHänchen.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
                }
                else { btnGebHänchen.setActivated(true);}
            }
        });

        btnGebHänchen.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
                vibrator.vibrate(100);
                btnGebHänchen.setHovered(true);
                btnGebHänchen.setBackground(getDrawable(R.drawable.blue_press_berate));
                btnGebHänchen.setActivated(false);
                btnGebHänchen.setSelected(false);
                sb_GebHänchen.setProgress(3);
                return true;
            }
        });
        //---------------------------------------- 鸡胸 fertig----------------------------------------------//
        txt_sb_GebHänchenFilet = this;
        sb_GebHänchenFilet = (SeekBar) findViewById(R.id.sb_GebHächenFilet);
        txtHühnerfilet = (TextView) findViewById(R.id.txtHühnerFilet);


        sb_GebHänchenFilet.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged (SeekBar seekBar,int progress, boolean fromUser){


                if(sb_GebHänchenFilet.getProgress()==0) {
                    btnGebackeneHühnerFilet.setText("鸡 胸");
                    txtHühnerfilet.setText("Hühnerfilet");
                    btnGebackeneHühnerFilet.setHovered(false);
                    btnGebackeneHühnerFilet.setSelected(false);
                    btnGebackeneHühnerFilet.setActivated(false);
                    btnGebackeneHühnerFilet.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
                }
                else{btnGebackeneHühnerFilet.setText("鸡胸 " + progress);
                    // txtHühnerfilet.setText("Hühnerfilet: " + progress);
                     btnGebackeneHühnerFilet.setHovered(true);
                    btnGebackeneHühnerFilet.setActivated(false);
                    btnGebackeneHühnerFilet.setSelected(false);
                     btnGebackeneHühnerFilet.setBackground(getDrawable(R.drawable.blue_press_berate));
                    }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        btnGebackeneHühnerFilet = (Button) findViewById(R.id.GebackeneHühnerFilet);
        btnGebackeneHühnerFilet.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                if (btnGebackeneHühnerFilet.isActivated()==true ){
                    btnGebackeneHühnerFilet.setActivated(false);
                    btnGebackeneHühnerFilet.setSelected(true);
/*                  btnGebackeneHühnerFilet.setHovered(false);
                    btnGebackeneHühnerFilet.setBackground(getDrawable(R.drawable.btn_press_switch));*/

                }
                else if (btnGebackeneHühnerFilet.isSelected()==true|| btnGebackeneHühnerFilet.isHovered()==true){
                    sb_GebHänchenFilet.setProgress(0);
                    btnGebackeneHühnerFilet.setSelected(false);
                    btnGebackeneHühnerFilet.setHovered(false);
                    btnGebackeneHühnerFilet.setBackground(getDrawable(R.drawable.btn_press_switch_berate));


                }
                else if (sb_GebHänchenFilet.getBackground()==getDrawable(R.drawable.blue_press_berate)){
                    sb_GebHänchenFilet.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
                }
                else { btnGebackeneHühnerFilet.setActivated(true);}
            }
        });

        btnGebackeneHühnerFilet.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
                vibrator.vibrate(100);
                btnGebackeneHühnerFilet.setHovered(true);
                btnGebackeneHühnerFilet.setBackground(getDrawable(R.drawable.blue_press_berate));
                btnGebackeneHühnerFilet.setActivated(false);
                btnGebackeneHühnerFilet.setSelected(false);
                sb_GebHänchenFilet.setProgress(3);
                return true;
            }
        });
//----------------------------------------西兰花 fertig-----------------------------------------------//
        txt_sb_Broccoli = this;
        sb_Broccoli = (SeekBar) findViewById(R.id.sb_Broccoli);
        txtBroccoli = (TextView) findViewById(R.id.textBroccoli);
        sb_Broccoli.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged (SeekBar seekBar,int progress, boolean fromUser){
                if(btnBroccoli.isSelected()!=true &&btnBroccoli.isHovered()!=true) {
                    btnBroccoli.setActivated(true);
                }

                if (sb_Broccoli.getProgress()==1){
                    txtBroccoli.setText("Broccoli");
                    btnBroccoli.setText("绿菜花");
                    btnBroccoli.setTextSize(28);
                    btnBroccoli.setHovered(true);
                    btnBroccoli.setActivated(false);
                    btnBroccoli.setSelected(false);

                }

                if(sb_Broccoli.getProgress()==2)
                {
                    btnBroccoli.setText("白菜花");
                    txtBroccoli.setText("Blumenkohl");
                    btnBroccoli.setTextSize(28);
                    btnBroccoli.setHovered(true);
                    btnBroccoli.setActivated(false);
                    btnBroccoli.setSelected(false);
                }
                if(sb_Broccoli.getProgress()==0){
                    txtBroccoli.setText("Broccoli");
                    btnBroccoli.setText("西兰花");
                    btnBroccoli.setHovered(false);
                    btnBroccoli.setBackground(getDrawable(R.drawable.btn_press_switch));
                    btnBroccoli.setActivated(false);
                    btnBroccoli.setSelected(false);
                    btnBroccoli.setTextSize(36);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        btnBroccoli= (Button) findViewById(R.id.Broccoli);
        btnBroccoli.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                if (btnBroccoli.isActivated()==true){
                    btnBroccoli.setActivated(false);
                    btnBroccoli.setSelected(true);
                }
                else if (btnBroccoli.isSelected()==true||btnBroccoli.isHovered()==true){
                    btnBroccoli.setSelected(false);
                    btnBroccoli.setHovered(false);
                    btnBroccoli.setBackground(getDrawable(R.drawable.btn_press_switch));
                    sb_Broccoli.setProgress(0);
                }
                else if (btnBroccoli.getBackground()==getDrawable(R.drawable.blue_press))
                {
                    btnBroccoli.setBackground(getDrawable(R.drawable.btn_press_switch));
                }
                else {btnBroccoli.setActivated(true);}
            }
        });

        btnBroccoli.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
                vibrator.vibrate(100);
                btnBroccoli.setActivated(false);
                btnBroccoli.setSelected(false);
                btnBroccoli.setHovered(true);
                btnBroccoli.setBackground(getDrawable(R.drawable.blue_press));
                return true;
            }
        });
//----------------------------------------------炒面  fertig------------------------------------------//
        btnGebNudel = (Button) findViewById(R.id.Gebratene_Nudeln);
        btnGebNudel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                if (btnGebNudel.isActivated()==true){
                    btnGebNudel.setActivated(false);
                    btnGebNudel.setSelected(true);
                }
                else if (btnGebNudel.isSelected()==true){
                    btnGebNudel.setSelected(false);
                }
                else if(btnGebNudel.isHovered()==true)
                {  btnGebNudel.setHovered(false);
                   btnGebNudel.setBackground(getDrawable(R.drawable.btn_press_switch));
                    }
                else if (btnGebNudel.getBackground()==getDrawable(R.drawable.blue_press))
                {
                    btnGebNudel.setBackground(getDrawable(R.drawable.btn_press_switch));
                }
                else {
                    btnGebNudel.setActivated(true);
                }
            }
        });

        btnGebNudel.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
        btnGebNudel.setBackground(getDrawable(R.drawable.blue_press));
        btnGebNudel.setHovered(true);
        btnGebNudel.setActivated(false);
        btnGebNudel.setSelected(false);
        vibrator.vibrate(100);
        return true;
            }
        });

//----------------------------------------------炒饭  fertig------------------------------------------//
        btnGebReis = (Button) findViewById(R.id.Gebratener_Reis);
        btnGebReis.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
            if (btnGebReis.isActivated()==true){
                btnGebReis.setActivated(false);
                btnGebReis.setSelected(true);
            }
            else if (btnGebReis.isSelected()==true || btnGebReis.isHovered()==true){
                btnGebReis.setSelected(false);
                btnGebReis.setHovered(false);
                btnGebReis.setBackground(getDrawable(R.drawable.btn_press_switch));
            }
            else if (btnGebReis.getBackground()==getDrawable(R.drawable.blue_press))
            {
                btnGebReis.setBackground(getDrawable(R.drawable.btn_press_switch));
            }
            else {
                btnGebReis.setActivated(true);
            }
            }
        });

        btnGebReis.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
            vibrator.vibrate(100);
            btnGebReis.setActivated(false);
            btnGebReis.setSelected(false);
            btnGebReis.setHovered(true);
            btnGebReis.setBackground(getDrawable(R.drawable.blue_press));
            return true;
            }
        });
//----------------------------------------------炒素菜 fertig------------------------------------------//
        btnGebGemüse = (Button) findViewById(R.id.Geb_Gemüse);
        btnGebGemüse.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                if (btnGebGemüse.isActivated()==true){
                    btnGebGemüse.setActivated(false);
                    btnGebGemüse.setSelected(true);
                }
                else if(btnGebGemüse.isSelected()==true){
                    btnGebGemüse.setSelected(false);
                }
                else if(btnGebGemüse.isHovered()==true)
                {  btnGebGemüse.setHovered(false);
                    btnGebGemüse.setBackground(getDrawable(R.drawable.btn_press_switch));
                }
                else if (btnGebGemüse.getBackground()==getDrawable(R.drawable.blue_press))
                {
                    btnGebGemüse.setBackground(getDrawable(R.drawable.btn_press_switch));
                }
                else {
                    btnGebGemüse.setActivated(true);
                }
            }
        });

        btnGebGemüse.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
                vibrator.vibrate(100);
                btnGebGemüse.setActivated(false);
                btnGebGemüse.setSelected(false);
                btnGebGemüse.setHovered(true);
                btnGebGemüse.setBackground(getDrawable(R.drawable.blue_press));

                return true;
            }
        });
//---------------------------------------------炒土豆  fertig-----------------------------------------//
        btnGebKartoffeln = (Button) findViewById(R.id.bratkartoffeln);
        btnGebKartoffeln.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                if (btnGebKartoffeln.isActivated()==true){
                    btnGebKartoffeln.setActivated(false);
                    btnGebKartoffeln.setSelected(true);
                }
                else if (btnGebKartoffeln.isSelected()==true){
                    btnGebKartoffeln.setSelected(false);
                }
                else if(btnGebKartoffeln.isHovered()==true)
                {  btnGebKartoffeln.setHovered(false);
                    btnGebKartoffeln.setBackground(getDrawable(R.drawable.btn_press_switch));
                }
                else if (btnGebKartoffeln.getBackground()==getDrawable(R.drawable.blue_press))
                {
                    btnGebKartoffeln.setBackground(getDrawable(R.drawable.btn_press_switch));
                }
                else {
                    btnGebKartoffeln.setActivated(true);
                }
            }
        });

        btnGebKartoffeln.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
            vibrator.vibrate(100);
            btnGebKartoffeln.setActivated(false);
            btnGebKartoffeln.setSelected(false);
            btnGebKartoffeln.setHovered(true);
            btnGebKartoffeln.setBackground(getDrawable(R.drawable.blue_press));
            return true;
            }
        });
//---------------------------------------------炸菠萝  fertig-----------------------------------------//
btnGebackeneAnanas = (Button) findViewById(R.id.GebackeneAnanas);
        btnGebackeneAnanas.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick (View v) {
        if (btnGebackeneAnanas.isActivated()==true){
            btnGebackeneAnanas.setActivated(false);
            btnGebackeneAnanas.setSelected(true);
        }
        else if (btnGebackeneAnanas.isSelected()==true){
            btnGebackeneAnanas.setSelected(false);
        }
        else if(btnGebackeneAnanas.isHovered()==true)
        {  btnGebackeneAnanas.setHovered(false);
            btnGebackeneAnanas.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
        }
        else if (btnGebackeneAnanas.getBackground()==getDrawable(R.drawable.blue_press_berate))
        {
            btnGebackeneAnanas.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
        }
        else {
            btnGebackeneAnanas.setActivated(true);
        }
    }
        });

        btnGebackeneAnanas.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
            vibrator.vibrate(100);
            btnGebackeneAnanas.setActivated(false);
            btnGebackeneAnanas.setSelected(false);
            btnGebackeneAnanas.setHovered(true);
            btnGebackeneAnanas.setBackground(getDrawable(R.drawable.blue_press_berate));
            return true;
            }
        });

//-----------------------------------------炒蘑菇 fertig-----------------------------------------------//
        btnChampignons= (Button) findViewById(R.id.Champignons);
        btnChampignons.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                if (btnChampignons.isActivated()==true){
                    btnChampignons.setActivated(false);
                    btnChampignons.setSelected(true);
                }
                else if (btnChampignons.isSelected()==true){
                    btnChampignons.setSelected(false);
                }
                else if(btnChampignons.isHovered()==true)
                {  btnChampignons.setHovered(false);
                    btnChampignons.setBackground(getDrawable(R.drawable.btn_press_switch));
                }
                else if (btnChampignons.getBackground()==getDrawable(R.drawable.blue_press))
                {
                    btnChampignons.setBackground(getDrawable(R.drawable.btn_press_switch));
                }
                else {
                    btnChampignons.setActivated(true);
                }
            }
        });

        btnChampignons.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
            vibrator.vibrate(100);
            btnChampignons.setActivated(false);
            btnChampignons.setSelected(false);
            btnChampignons.setHovered(true);
            btnChampignons.setBackground(getDrawable(R.drawable.blue_press));

                return true;
            }
        });
//-----------------------------------------炒绿豆 fertig-----------------------------------------------//
        btnBohnen= (Button) findViewById(R.id.Bohen);
        btnBohnen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                if (btnBohnen.isActivated()==true){
                    btnBohnen.setActivated(false);
                    btnBohnen.setSelected(true);
                }
                else if (btnBohnen.isSelected()==true){
                    btnBohnen.setSelected(false);
                }
                else if(btnBohnen.isHovered()==true)
                {  btnBohnen.setHovered(false);
                    btnBohnen.setBackground(getDrawable(R.drawable.btn_press_switch));
                }
                else if (btnBohnen.getBackground()==getDrawable(R.drawable.blue_press))
                {
                    btnBohnen.setBackground(getDrawable(R.drawable.btn_press_switch));
                }
                else {
                    btnBohnen.setActivated(true);
                }
            }
        });

        btnBohnen.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
                vibrator.vibrate(100);
                btnBohnen.setActivated(false);
                btnBohnen.setSelected(false);
                btnBohnen.setHovered(true);
                btnBohnen.setBackground(getDrawable(R.drawable.blue_press));
                return true;
            }
        });
//-----------------------------------------芦笋鸡 fertig-----------------------------------------------//
        btnHühnerfiletSpargel= (Button) findViewById(R.id.HühnerfiletSpargel);
        btnHühnerfiletSpargel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                if (btnHühnerfiletSpargel.isActivated()==true){
                    btnHühnerfiletSpargel.setActivated(false);
                    btnHühnerfiletSpargel.setSelected(true);
                }
                else if (btnHühnerfiletSpargel.isSelected()==true){
                    btnHühnerfiletSpargel.setSelected(false);
                }
                else if(btnHühnerfiletSpargel.isHovered()==true)
                {  btnHühnerfiletSpargel.setHovered(false);
                    btnHühnerfiletSpargel.setBackground(getDrawable(R.drawable.btn_press_switch));
                }
                else if (btnHühnerfiletSpargel.getBackground()==getDrawable(R.drawable.blue_press))
                {
                    btnHühnerfiletSpargel.setBackground(getDrawable(R.drawable.btn_press_switch));
                }
                else {
                    btnHühnerfiletSpargel.setActivated(true);
                }
            }
        });

        btnHühnerfiletSpargel.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
            vibrator.vibrate(100);
            btnHühnerfiletSpargel.setActivated(false);
            btnHühnerfiletSpargel.setSelected(false);
            btnHühnerfiletSpargel.setHovered(true);
                btnHühnerfiletSpargel.setBackground(getDrawable(R.drawable.blue_press));

                return true;
            }
        });
//-----------------------------------------炒大虾 fertig-----------------------------------------------//
        btnGarnelenScharf= (Button) findViewById(R.id.garnelenScharf);
        btnGarnelenScharf.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
            if (btnGarnelenScharf.isActivated()==true){
                btnGarnelenScharf.setActivated(false);
                btnGarnelenScharf.setSelected(true);
            }
            else if (btnGarnelenScharf.isSelected()==true){
                btnGarnelenScharf.setSelected(false);
            }
            else if(btnGarnelenScharf.isHovered()==true)
            {  btnGarnelenScharf.setHovered(false);
                btnGarnelenScharf.setBackground(getDrawable(R.drawable.btn_press_switch));
            }
            else if (btnGarnelenScharf.getBackground()==getDrawable(R.drawable.blue_press))
            {
                btnGarnelenScharf.setBackground(getDrawable(R.drawable.btn_press_switch));
            }
            else {
                btnGarnelenScharf.setActivated(true);
            }
            }
        });

        btnGarnelenScharf.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
            vibrator.vibrate(100);
            btnGarnelenScharf.setActivated(false);
            btnGarnelenScharf.setSelected(false);
            btnGarnelenScharf.setHovered(true);
                btnGarnelenScharf.setBackground(getDrawable(R.drawable.blue_press));
            return true;
            }
        });
//-----------------------------------------鸡翅膀fertig-----------------------------------------------//
        btnChickenWings= (Button) findViewById(R.id.ChickenWings);
        btnChickenWings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
            if (btnChickenWings.isActivated()==true){
                btnChickenWings.setActivated(false);
                btnChickenWings.setSelected(true);
            }
            else if (btnChickenWings.isSelected()==true){
                btnChickenWings.setSelected(false);
            }
            else if(btnChickenWings.isHovered()==true)
            {  btnChickenWings.setHovered(false);
                btnChickenWings.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
            }
            else if (btnChickenWings.getBackground()==getDrawable(R.drawable.blue_press_berate))
            {
                btnChickenWings.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
            }
            else {
                btnChickenWings.setActivated(true);
            }
            }
        });

        btnChickenWings.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
            vibrator.vibrate(100);
            btnChickenWings.setActivated(false);
            btnChickenWings.setSelected(false);
            btnChickenWings.setHovered(true);
            btnChickenWings.setBackground(getDrawable(R.drawable.blue_press_berate));

                return true;
            }
        });
//----------------------------------------洋葱牛 fertig-----------------------------------------------//
       /* txt_sb_Rind = this;*/
        sb_Rind = (SeekBar) findViewById(R.id.sb_Rind);
        txtRind = (TextView) findViewById(R.id.textRind);
        sb_Rind.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged (SeekBar seekBar,int progress, boolean fromUser){
                if(btnRindFleischZwiebel.isSelected()!=true &&btnRindFleischZwiebel.isHovered()!=true) {
                    btnRindFleischZwiebel.setActivated(true);
                }

                if (sb_Rind.getProgress()==1){
                    txtRind.setText("Zwiebel");
                    btnRindFleischZwiebel.setText("洋 葱");
                    btnRindFleischZwiebel.setTextSize(28);
                    btnRindFleischZwiebel.setActivated(false);
                    btnRindFleischZwiebel.setSelected(false);
                    btnRindFleischZwiebel.setHovered(true);
                }

/*                if(sb_Broccoli.getProgress()==2)
                {
                    btnRindFleischZwiebel.setText("白菜花");
                    txtBroccoli.setText("Blumenkohl");
                }*/
                if(sb_Rind.getProgress()==0){
                    txtRind.setText("Rind Zwiebel");
                    btnRindFleischZwiebel.setText("洋葱牛");
                    btnRindFleischZwiebel.setTextSize(36);
                    btnRindFleischZwiebel.setHovered(false);
                    btnRindFleischZwiebel.setBackground(getDrawable(R.drawable.btn_press_switch));
                    btnRindFleischZwiebel.setActivated(false);
                    btnRindFleischZwiebel.setSelected(false);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        btnRindFleischZwiebel= (Button) findViewById(R.id.RindFleischZwiebel);
        btnRindFleischZwiebel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
            if (btnRindFleischZwiebel.isActivated()==true){
                btnRindFleischZwiebel.setActivated(false);
                btnRindFleischZwiebel.setSelected(true);
            }
            else if (btnRindFleischZwiebel.isSelected()==true||btnRindFleischZwiebel.isHovered()==true){
                btnRindFleischZwiebel.setSelected(false);
                btnRindFleischZwiebel.setHovered(false);
                btnRindFleischZwiebel.setBackground(getDrawable(R.drawable.btn_press_switch));
                sb_Rind.setProgress(0);
            }
            else if (btnRindFleischZwiebel.getBackground()==getDrawable(R.drawable.blue_press))
            {
                btnRindFleischZwiebel.setBackground(getDrawable(R.drawable.btn_press_switch));
            }
            else {
                btnRindFleischZwiebel.setActivated(true);
            }
            }
        });

        btnRindFleischZwiebel.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
            vibrator.vibrate(100);
            btnRindFleischZwiebel.setActivated(false);
            btnRindFleischZwiebel.setSelected(false);
            btnRindFleischZwiebel.setHovered(true);
            btnRindFleischZwiebel.setBackground(getDrawable(R.drawable.blue_press));
            return true;
            }
        });
//----------------------------------------豆豉鸡 fertig----------------------------------------------//
        btnHühnerfilietKnoblauch= (Button) findViewById(R.id.HühnerfilietKnoblauch);
        btnHühnerfilietKnoblauch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
            if (btnHühnerfilietKnoblauch.isActivated()==true){
                btnHühnerfilietKnoblauch.setActivated(false);
                btnHühnerfilietKnoblauch.setSelected(true);
            }
            else if (btnHühnerfilietKnoblauch.isSelected()==true){
                btnHühnerfilietKnoblauch.setSelected(false);
            }
            else if(btnHühnerfilietKnoblauch.isHovered()==true)
            {  btnHühnerfilietKnoblauch.setHovered(false);
                btnHühnerfilietKnoblauch.setBackground(getDrawable(R.drawable.btn_press_switch));
            }
            else if (btnHühnerfilietKnoblauch.getBackground()==getDrawable(R.drawable.blue_press))
            {
                btnHühnerfilietKnoblauch.setBackground(getDrawable(R.drawable.btn_press_switch));
            }
            else {
                btnHühnerfilietKnoblauch.setActivated(true);
            }
            }
        });

        btnHühnerfilietKnoblauch.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
            vibrator.vibrate(100);
            btnHühnerfilietKnoblauch.setActivated(false);
            btnHühnerfilietKnoblauch.setSelected(false);
            btnHühnerfilietKnoblauch.setHovered(true);
            btnHühnerfilietKnoblauch.setBackground(getDrawable(R.drawable.blue_press));

                return true;
            }
        });
//----------------------------------------八宝 fertig-----------------------------------------------//
        btnAchtKostbarkeiten= (Button) findViewById(R.id.AchtKostbarkeiten);
        btnAchtKostbarkeiten.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
            if (btnAchtKostbarkeiten.isActivated()==true){
                btnAchtKostbarkeiten.setActivated(false);
                btnAchtKostbarkeiten.setSelected(true);
            }
            else if (btnAchtKostbarkeiten.isSelected()==true){
                btnAchtKostbarkeiten.setSelected(false);
            }
            else if(btnAchtKostbarkeiten.isHovered()==true)
            {  btnAchtKostbarkeiten.setHovered(false);
                btnAchtKostbarkeiten.setBackground(getDrawable(R.drawable.btn_press_switch));
            }
            else if (btnAchtKostbarkeiten.getBackground()==getDrawable(R.drawable.blue_press))
            {
                btnAchtKostbarkeiten.setBackground(getDrawable(R.drawable.btn_press_switch));
            }
            else {
                btnAchtKostbarkeiten.setActivated(true);
            }
            }
        });

        btnAchtKostbarkeiten.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
            vibrator.vibrate(100);
            btnAchtKostbarkeiten.setActivated(false);
            btnAchtKostbarkeiten.setSelected(false);
            btnAchtKostbarkeiten.setHovered(true);
                btnAchtKostbarkeiten.setBackground(getDrawable(R.drawable.blue_press));

                return true;
            }
        });
//----------------------------------------宫保鸡 fertig-----------------------------------------------//
        btnHühnerfleischKungbo= (Button) findViewById(R.id.HühnerfleischKungbo);
        btnHühnerfleischKungbo.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick (View v) {
        if (btnHühnerfleischKungbo.isActivated()==true){
            btnHühnerfleischKungbo.setActivated(false);
            btnHühnerfleischKungbo.setSelected(true);
        }
        else if (btnHühnerfleischKungbo.isSelected()==true){
            btnHühnerfleischKungbo.setSelected(false);
        }
        else if(btnHühnerfleischKungbo.isHovered()==true)
        {  btnHühnerfleischKungbo.setHovered(false);
            btnHühnerfleischKungbo.setBackground(getDrawable(R.drawable.btn_press_switch));
        }
        else if (btnHühnerfleischKungbo.getBackground()==getDrawable(R.drawable.blue_press))
        {
            btnHühnerfleischKungbo.setBackground(getDrawable(R.drawable.btn_press_switch));
        }
        else {
            btnHühnerfleischKungbo.setActivated(true);
        }
    }
        });

        btnHühnerfleischKungbo.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
            vibrator.vibrate(100);
            btnHühnerfleischKungbo.setActivated(false);
            btnHühnerfleischKungbo.setSelected(false);
            btnHühnerfleischKungbo.setHovered(true);
                btnHühnerfleischKungbo.setBackground(getDrawable(R.drawable.blue_press));
            return true;
            }
        });
//----------------------------------------蛋饺 fertig-----------------------------------------------//
        btnomelett= (Button) findViewById(R.id.omelett);
        btnomelett.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
            if (btnomelett.isActivated()==true){
                btnomelett.setActivated(false);
                btnomelett.setSelected(true);
            }
            else if (btnomelett.isSelected()==true){
                btnomelett.setSelected(false);
            }
            else if(btnomelett.isHovered()==true)
            {  btnomelett.setHovered(false);
                btnomelett.setBackground(getDrawable(R.drawable.btn_press_switch));
            }
            else if (btnomelett.getBackground()==getDrawable(R.drawable.blue_press))
            {
                btnomelett.setBackground(getDrawable(R.drawable.btn_press_switch));
            }
            else {
                btnomelett.setActivated(true);
            }
            }
        });

        btnomelett.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
            vibrator.vibrate(100);
            btnomelett.setActivated(false);
            btnomelett.setSelected(false);
            btnomelett.setHovered(true);
                btnomelett.setBackground(getDrawable(R.drawable.blue_press));
            return true;
            }
        });
//----------------------------------------咖喱鸡 fertig-----------------------------------------------//
        sb_Curry = (SeekBar) findViewById(R.id.sb_Curry);
        txtCurry = (TextView) findViewById(R.id.txtCurry);
        sb_Curry.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged (SeekBar seekBar,int progress, boolean fromUser){
                if(btnCurryHuhn.isSelected()!=true &&btnCurryHuhn.isHovered()!=true) {
                    btnCurryHuhn.setActivated(true);
                }

                if (sb_Curry.getProgress()==1){
                    txtCurry.setText("Curry Soße");
                    btnCurryHuhn.setText("咖喱汁");
                    btnCurryHuhn.setTextSize(28);

                    btnCurryHuhn.setActivated(false);
                    btnCurryHuhn.setSelected(false);
                    btnCurryHuhn.setHovered(true);
                }

/*                if(sb_Broccoli.getProgress()==2)
                {
                    btnRindFleischZwiebel.setText("白菜花");
                    txtBroccoli.setText("Blumenkohl");
                }*/
                if(sb_Curry.getProgress()==0){
                    txtCurry.setText("Curry Huhn");
                    btnCurryHuhn.setText("咖喱鸡");
                    btnCurryHuhn.setTextSize(36);
                    btnCurryHuhn.setBackground(getDrawable(R.drawable.btn_press_switch));
                    btnCurryHuhn.setActivated(false);
                    btnCurryHuhn.setSelected(false);
                    btnCurryHuhn.setHovered(false);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        btnCurryHuhn= (Button) findViewById(R.id.CurryHuhn);
        btnCurryHuhn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
            if (btnCurryHuhn.isActivated()==true){
                btnCurryHuhn.setActivated(false);
                btnCurryHuhn.setSelected(true);
            }
            else if (btnCurryHuhn.isSelected()==true||btnCurryHuhn.isHovered()==true){
                btnCurryHuhn.setSelected(false);
                btnCurryHuhn.setHovered(false);
                btnCurryHuhn.setBackground(getDrawable(R.drawable.btn_press_switch));
                sb_Curry.setProgress(0);

            }
            else if(btnCurryHuhn.isHovered()==true)
            {   btnCurryHuhn.setSelected(false);
                btnCurryHuhn.setHovered(false);
                btnCurryHuhn.setBackground(getDrawable(R.drawable.btn_press_switch));
                sb_Curry.setProgress(0);
            }
            else if (btnCurryHuhn.getBackground()==getDrawable(R.drawable.blue_press))
            {
                btnCurryHuhn.setBackground(getDrawable(R.drawable.btn_press_switch));
            }
            else {
                btnCurryHuhn.setActivated(true);
            }
            }
        });

        btnCurryHuhn.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
            vibrator.vibrate(100);
            btnCurryHuhn.setActivated(false);
            btnCurryHuhn.setSelected(false);
            btnCurryHuhn.setHovered(true);
            btnCurryHuhn.setBackground(getDrawable(R.drawable.blue_press));
            return true;
            }
        });
//----------------------------------------炸奶酪 fertig-----------------------------------------------//
        btnGebKäse= (Button) findViewById(R.id.GebKäse);
        btnGebKäse.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick (View v) {
        if (btnGebKäse.isActivated()==true){
            btnGebKäse.setActivated(false);
            btnGebKäse.setSelected(true);
        }
        else if (btnGebKäse.isSelected()==true){
            btnGebKäse.setSelected(false);
        }
        else if(btnGebKäse.isHovered()==true)
        {  btnGebKäse.setHovered(false);
            btnGebKäse.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
        }
        else if (btnGebKäse.getBackground()==getDrawable(R.drawable.blue_press_berate))
        {
            btnGebKäse.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
        }
        else {
            btnGebKäse.setActivated(true);
        }
    }
        });

        btnGebKäse.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
            vibrator.vibrate(100);
            btnGebKäse.setActivated(false);
            btnGebKäse.setSelected(false);
            btnGebKäse.setHovered(true);
            btnGebKäse.setBackground(getDrawable(R.drawable.blue_press_berate));
            return true;
            }
        });
//----------------------------------------炸大虾 fertig-----------------------------------------------//
        btnGebackeneGarnelen= (Button) findViewById(R.id.GebackeneGarnelen);
        btnGebackeneGarnelen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
            if (btnGebackeneGarnelen.isActivated()==true){
                btnGebackeneGarnelen.setActivated(false);
                btnGebackeneGarnelen.setSelected(true);
            }
            else if (btnGebackeneGarnelen.isSelected()==true){
                btnGebackeneGarnelen.setSelected(false);
            }
            else if(btnGebackeneGarnelen.isHovered()==true)
            {  btnGebackeneGarnelen.setHovered(false);
                btnGebackeneGarnelen.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
            }
            else if (btnGebackeneGarnelen.getBackground()==getDrawable(R.drawable.blue_press_berate))
            {
                btnGebackeneGarnelen.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
            }
            else {
                btnGebackeneGarnelen.setActivated(true);
            }
            }
        });

        btnGebackeneGarnelen.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
            vibrator.vibrate(100);
            btnGebackeneGarnelen.setActivated(false);
            btnGebackeneGarnelen.setSelected(false);
            btnGebackeneGarnelen.setHovered(true);
                btnGebackeneGarnelen.setBackground(getDrawable(R.drawable.blue_press_berate));
            return true;
            }
        });
//----------------------------------------鸡块 ok-----------------------------------------------//
        btnChickenNuggets= (Button) findViewById(R.id.ChickenNuggets);
        btnChickenNuggets.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
            if (btnChickenNuggets.isActivated()==true){
                btnChickenNuggets.setActivated(false);
                btnChickenNuggets.setSelected(true);
            }
            else if (btnChickenNuggets.isSelected()==true){
                btnChickenNuggets.setSelected(false);
            }
            else if(btnChickenNuggets.isHovered()==true)
            {  btnChickenNuggets.setHovered(false);
                btnChickenNuggets.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
            }
            else if (btnChickenNuggets.getBackground()==getDrawable(R.drawable.blue_press_berate))
            {
                btnChickenNuggets.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
            }
            else {
                btnChickenNuggets.setActivated(true);
            }
            }
        });

        btnChickenNuggets.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
            vibrator.vibrate(100);
            btnChickenNuggets.setActivated(false);
            btnChickenNuggets.setSelected(false);
            btnChickenNuggets.setHovered(true);
            btnChickenNuggets.setBackground(getDrawable(R.drawable.blue_press_berate));
            return true;
            }
        });
//----------------------------------------炸香蕉 fertig-----------------------------------------------//
        btnGebBanane= (Button) findViewById(R.id.GebBanane);
        btnGebBanane.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
            if (btnGebBanane.isActivated()==true){
                btnGebBanane.setActivated(false);
                btnGebBanane.setSelected(true);
            }
            else if (btnGebBanane.isSelected()==true){
                btnGebBanane.setSelected(false);
            }
            else if(btnGebBanane.isHovered()==true)
            {  btnGebBanane.setHovered(false);
                btnGebBanane.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
            }
            else if (btnGebBanane.getBackground()==getDrawable(R.drawable.blue_press_berate))
            {
                btnGebBanane.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
            }
            else {
                btnGebBanane.setActivated(true);
            }
            }
        });

        btnGebBanane.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
            vibrator.vibrate(100);
            btnGebBanane.setActivated(false);
            btnGebBanane.setSelected(false);
            btnGebBanane.setHovered(true);
            btnGebBanane.setBackground(getDrawable(R.drawable.blue_press_berate));
            return true;
            }
        });
//----------------------------------------炸薯条 fertig-----------------------------------------------//

        btnpommes= (Button) findViewById(R.id.pommes);
        btnpommes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
            if (btnpommes.isActivated()==true){
                btnpommes.setActivated(false);
                btnpommes.setSelected(true);
            }
            else if (btnpommes.isSelected()==true){
                btnpommes.setSelected(false);
            }
            else if(btnpommes.isHovered()==true)
            {  btnpommes.setHovered(false);
                btnpommes.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
            }
            else if (btnpommes.getBackground()==getDrawable(R.drawable.blue_press_berate))
            {
                btnpommes.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
            }
            else {
                btnpommes.setActivated(true);
            }
            }
        });

        btnpommes.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
            vibrator.vibrate(100);
            btnpommes.setActivated(false);
            btnpommes.setSelected(false);
            btnpommes.setHovered(true);
                btnpommes.setBackground(getDrawable(R.drawable.blue_press_berate));
            return true;
            }
        });

//---------------------------------------- 鱿鱼圈 fertig-----------------------------------------------//

        btnTintenfischRing= (Button) findViewById(R.id.TintenfischRing);
        btnTintenfischRing.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
            if (btnTintenfischRing.isActivated()==true){
                btnTintenfischRing.setActivated(false);
                btnTintenfischRing.setSelected(true);
            }
            else if (btnTintenfischRing.isSelected()==true){
                btnTintenfischRing.setSelected(false);
            }
            else if(btnTintenfischRing.isHovered()==true)
            {  btnTintenfischRing.setHovered(false);
                btnTintenfischRing.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
            }
            else if (btnTintenfischRing.getBackground()==getDrawable(R.drawable.blue_press_berate))
            {
                btnTintenfischRing.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
            }
            else {
                btnTintenfischRing.setActivated(true);
            }
            }
        });

        btnTintenfischRing.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
            vibrator.vibrate(100);
            btnTintenfischRing.setActivated(false);
            btnTintenfischRing.setSelected(false);
            btnTintenfischRing.setHovered(true);
            btnTintenfischRing.setBackground(getDrawable(R.drawable.blue_press_berate));

            return true;
            }
        });
//---------------------------------------- 炸鱼- fertig----------------------------------------------//
        btnGebackenesfischfilet= (Button) findViewById(R.id.Gebackenesfischfilet);
        btnGebackenesfischfilet.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
            if (btnGebackenesfischfilet.isActivated()==true){
                btnGebackenesfischfilet.setActivated(false);
                btnGebackenesfischfilet.setSelected(true);
            }
            else if (btnGebackenesfischfilet.isSelected()==true){
                btnGebackenesfischfilet.setSelected(false);
            }
            else if(btnGebackenesfischfilet.isHovered()==true)
            {  btnGebackenesfischfilet.setHovered(false);
                btnGebackenesfischfilet.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
            }
            else if (btnGebackenesfischfilet.getBackground()==getDrawable(R.drawable.blue_press_berate))
            {
                btnGebackenesfischfilet.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
            }
            else {
                btnGebackenesfischfilet.setActivated(true);
            }
            }
        });

        btnGebackenesfischfilet.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
            vibrator.vibrate(100);
            btnGebackenesfischfilet.setActivated(false);
            btnGebackenesfischfilet.setSelected(false);
            btnGebackenesfischfilet.setHovered(true);
            btnGebackenesfischfilet.setBackground(getDrawable(R.drawable.blue_press_berate));
            return true;
            }
        });
//---------------------------------------- 小春卷-fertig----------------------------------------------//

        btnMiniFrühlingsrolle= (Button) findViewById(R.id.MiniFrühlingsrolle);
        btnMiniFrühlingsrolle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
            if (btnMiniFrühlingsrolle.isActivated()==true){
                btnMiniFrühlingsrolle.setActivated(false);
                btnMiniFrühlingsrolle.setSelected(true);
            }
            else if (btnMiniFrühlingsrolle.isSelected()==true){
                btnMiniFrühlingsrolle.setSelected(false);
            }
            else if(btnMiniFrühlingsrolle.isHovered()==true)
            {  btnMiniFrühlingsrolle.setHovered(false);
                btnMiniFrühlingsrolle.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
            }
            else if (btnMiniFrühlingsrolle.getBackground()==getDrawable(R.drawable.blue_press_berate))
            {
                btnMiniFrühlingsrolle.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
            }
            else {
                btnMiniFrühlingsrolle.setActivated(true);
            }
            }
        });

        btnMiniFrühlingsrolle.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
            vibrator.vibrate(100);
            btnMiniFrühlingsrolle.setActivated(false);
            btnMiniFrühlingsrolle.setSelected(false);
            btnMiniFrühlingsrolle.setHovered(true);
            btnMiniFrühlingsrolle.setBackground(getDrawable(R.drawable.blue_press_berate));

            return true;
            }
        });

//---------------------------------------- 馄饨-fertig---------------------------------------------//

        btnGebackeneWantan= (Button) findViewById(R.id.GebackeneWantan);
        btnGebackeneWantan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
            if (btnGebackeneWantan.isActivated()==true){
                btnGebackeneWantan.setActivated(false);
                btnGebackeneWantan.setSelected(true);
            }
            else if (btnGebackeneWantan.isSelected()==true){
                btnGebackeneWantan.setSelected(false);
            }
            else if(btnGebackeneWantan.isHovered()==true)
            {  btnGebackeneWantan.setHovered(false);
                btnGebackeneWantan.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
            }
            else if (btnGebackeneWantan.getBackground()==getDrawable(R.drawable.blue_press_berate))
            {
                btnGebackeneWantan.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
            }
            else {
                btnGebackeneWantan.setActivated(true);
            }
            }
        });

        btnGebackeneWantan.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
            vibrator.vibrate(100);
            btnGebackeneWantan.setBackground(getDrawable(R.drawable.blue_press_berate));
            btnGebackeneWantan.setActivated(false);
            btnGebackeneWantan.setSelected(false);
            btnGebackeneWantan.setHovered(true);
            return true;
            }
        });

//---------------------------------------- 芝麻球-fertig--------------------------------------------//
        sb_Sesam = (SeekBar) findViewById(R.id.sb_Sesam);
        txtSesam = (TextView) findViewById(R.id.txtSesam);
        sb_Sesam.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged (SeekBar seekBar,int progress, boolean fromUser){
                if(btnGebackeneSesambällchen.isSelected()!=true &&btnGebackeneSesambällchen.isHovered()!=true) {
                    btnGebackeneSesambällchen.setActivated(true);
                }

                if (sb_Sesam.getProgress()==1){
                    txtSesam.setText("10 bällchen");
                    btnGebackeneSesambällchen.setText("10个球");
                    btnGebackeneSesambällchen.setHovered(true);
                    btnGebackeneSesambällchen.setActivated(false);
                    btnGebackeneSesambällchen.setSelected(false);
                    btnGebackeneSesambällchen.setBackground(getDrawable(R.drawable.blue_press_berate));
                }
                if(sb_Sesam.getProgress()==0){
                    txtSesam.setText("Sesambällchen");
                    btnGebackeneSesambällchen.setText("芝麻球");
                    btnGebackeneSesambällchen.setHovered(false);
                    btnGebackeneSesambällchen.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
                    btnGebackeneSesambällchen.setActivated(false);
                    btnGebackeneSesambällchen.setSelected(false);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        btnGebackeneSesambällchen= (Button) findViewById(R.id.GebackeneSesambällchen);
        btnGebackeneSesambällchen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
            if (btnGebackeneSesambällchen.isActivated()==true){
                btnGebackeneSesambällchen.setActivated(false);
                btnGebackeneSesambällchen.setSelected(true);
            }
            else if (btnGebackeneSesambällchen.isSelected()==true){
                btnGebackeneSesambällchen.setSelected(false);
                btnGebackeneSesambällchen.setHovered(false);
                btnGebackeneSesambällchen.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
                sb_Sesam.setProgress(0);
            }
            else if(btnGebackeneSesambällchen.isHovered()==true||btnGebackeneSesambällchen.isHovered()==true)
            {   btnGebackeneSesambällchen.setHovered(false);
                btnGebackeneSesambällchen.setSelected(false);
                btnGebackeneSesambällchen.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
                sb_Sesam.setProgress(0);
            }
            else if (btnGebackeneSesambällchen.getBackground()==getDrawable(R.drawable.blue_press_berate))
            {
                btnGebackeneSesambällchen.setBackground(getDrawable(R.drawable.btn_press_switch_berate));
            }
            else {
                btnGebackeneSesambällchen.setActivated(true);
            }
            }
        });

        btnGebackeneSesambällchen.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
            vibrator.vibrate(100);
            btnGebackeneSesambällchen.setActivated(false);
            btnGebackeneSesambällchen.setSelected(false);
            btnGebackeneSesambällchen.setHovered(true);
            btnGebackeneSesambällchen.setBackground(getDrawable(R.drawable.blue_press_berate));

                return true;
            }
        });
//---------------------------------------- 黑汁水  fertig---------------------------------------------//
        btnSoß_Pikante= (Button) findViewById(R.id.Soß_Pikante);
        btnSoß_Pikante.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
            if (btnSoß_Pikante.isActivated()==true){
                btnSoß_Pikante.setActivated(false);
                btnSoß_Pikante.setSelected(true);
            }
            else if (btnSoß_Pikante.isSelected()==true){
                btnSoß_Pikante.setSelected(false);
            }
            else if(btnSoß_Pikante.isHovered()==true)
            {  btnSoß_Pikante.setHovered(false);
                btnSoß_Pikante.setBackground(getDrawable(R.drawable.btn_extra));
            }
            else if (btnSoß_Pikante.getBackground()==getDrawable(R.drawable.btn_extra_blue))
            {
                btnSoß_Pikante.setBackground(getDrawable(R.drawable.btn_extra_blue));
            }
            else {
                btnSoß_Pikante.setActivated(true);
            }
            }
        });

            btnSoß_Pikante.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
            btnSoß_Pikante.setBackground(getDrawable(R.drawable.btn_extra_blue));
            btnSoß_Pikante.setActivated(false);
            btnSoß_Pikante.setSelected(false);
            btnSoß_Pikante.setHovered(true);
            vibrator.vibrate(100);
            return true;
            }
        });
//---------------------------------------- 酸甜汁  fertig---------------------------------------------//

        btnSoß_Süßsauer= (Button) findViewById(R.id.Soße_Süßsauer);
        btnSoß_Süßsauer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
            if (btnSoß_Süßsauer.isActivated()==true){
                btnSoß_Süßsauer.setActivated(false);
                btnSoß_Süßsauer.setSelected(true);
            }
            else if (btnSoß_Süßsauer.isSelected()==true){
                btnSoß_Süßsauer.setSelected(false);
            }
            else if(btnSoß_Süßsauer.isHovered()==true)
            {  btnSoß_Süßsauer.setHovered(false);
                btnSoß_Süßsauer.setBackground(getDrawable(R.drawable.btn_extra));
            }
            else if (btnSoß_Süßsauer.getBackground()==getDrawable(R.drawable.btn_extra_blue))
            {
                btnSoß_Süßsauer.setBackground(getDrawable(R.drawable.btn_extra_blue));
            }
            else {
                btnSoß_Süßsauer.setActivated(true);
            }
            }
        });

        btnSoß_Süßsauer.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
                btnSoß_Süßsauer.setBackground(getDrawable(R.drawable.btn_extra_blue));
            vibrator.vibrate(100);
            btnSoß_Süßsauer.setActivated(false);
            btnSoß_Süßsauer.setSelected(false);
            btnSoß_Süßsauer.setHovered(true);
                btnSoß_Süßsauer.setBackground(getDrawable(R.drawable.btn_extra_blue));

                return true;
            }
        });
//---------------------------------------- 花生汁 fertig---------------------------------------------//

        btnSoße_Erdnuss= (Button) findViewById(R.id.Soße_Erdnuss);

        txtErdnuss = (TextView) findViewById(R.id.txtErdnuss);
        btnSoße_Erdnuss.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
            if (btnSoße_Erdnuss.isActivated()==true){
                btnSoße_Erdnuss.setActivated(false);
                btnSoße_Erdnuss.setSelected(true);
                txtErdnuss.setText("Schale");
                btnSoße_Erdnuss.setText("换 兜");
            }
            else if (btnSoße_Erdnuss.isSelected()==true){
                btnSoße_Erdnuss.setSelected(false);
                txtErdnuss.setText("Erdnuss");
                btnSoße_Erdnuss.setText("花生汁");

            }
            else if(btnSoße_Erdnuss.isHovered()==true)
            {  btnSoße_Erdnuss.setHovered(false);
                btnSoße_Erdnuss.setBackground(getDrawable(R.drawable.btn_extra2));
            }
            else if (btnSoße_Erdnuss.getBackground()==getDrawable(R.drawable.btn_extra_blue))
            {
                btnSoße_Erdnuss.setBackground(getDrawable(R.drawable.btn_extra_blue));
            }
            else {
                btnSoße_Erdnuss.setActivated(true);
            }
            }
        });

        btnSoße_Erdnuss.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
            vibrator.vibrate(100);
            btnSoße_Erdnuss.setActivated(false);
            btnSoße_Erdnuss.setSelected(false);
            btnSoße_Erdnuss.setHovered(true);
            btnSoße_Erdnuss.setBackground(getDrawable(R.drawable.btn_extra_blue));

                return true;
            }
        });
//---------------------------------------- 白饭- fertig--------------------------------------------//
        btnReis= (Button) findViewById(R.id.Reis);
        btnReis.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
            if (btnReis.isActivated()==true){
                btnReis.setActivated(false);
                btnReis.setSelected(true);
            }
            else if (btnReis.isSelected()==true){
                btnReis.setSelected(false);
            }
            else if(btnReis.isHovered()==true)
            {  btnReis.setHovered(false);
                btnReis.setBackground(getDrawable(R.drawable.btn_extra));
            }
            else if (btnReis.getBackground()==getDrawable(R.drawable.btn_extra_blue))
            {
                btnReis.setBackground(getDrawable(R.drawable.btn_extra_blue));
            }
            else {
                btnReis.setActivated(true);
            }
            }
        });

        btnReis.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
                vibrator.vibrate(100);
                btnReis.setActivated(false);
                btnReis.setSelected(false);
                btnReis.setHovered(true);
                btnReis.setBackground(getDrawable(R.drawable.btn_extra_blue));

                return true;
            }
        });
//---------------------------------------- 酸辣汤-fertig--------------------------------------------//
        btnSuppe= (Button) findViewById(R.id.Suppe);
        btnSuppe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                if (btnSuppe.isActivated()==true){
                    btnSuppe.setActivated(false);
                    btnSuppe.setSelected(true);
                }
                else if (btnSuppe.isSelected()==true){
                    btnSuppe.setSelected(false);
                }
                else if(btnSuppe.isHovered()==true)
                {  btnSuppe.setHovered(false);
                    btnSuppe.setBackground(getDrawable(R.drawable.btn_extra));
                }
                else if (btnSuppe.getBackground()==getDrawable(R.drawable.btn_extra_blue))
                {
                    btnSuppe.setBackground(getDrawable(R.drawable.btn_extra_blue));
                }
                else {
                    btnSuppe.setActivated(true);
                }
            }
        });

        btnSuppe.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
                vibrator.vibrate(100);
                btnSuppe.setActivated(false);
                btnSuppe.setSelected(false);
                btnSuppe.setHovered(true);
                btnSuppe.setBackground(getDrawable(R.drawable.btn_extra_blue));

                return true;
            }
        });

//---------------------------------------- 巧克力-fertig--------------------------------------------//
        sb_Schoko = (SeekBar) findViewById(R.id.sb_Schoko);
        txtSchoko = (TextView) findViewById(R.id.textVSchoko);
        btnSchoko= (Button) findViewById(R.id.Schoko);
        sb_Schoko.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged (SeekBar seekBar,int progress, boolean fromUser){
                //btnSchalenGroß.setTextSize(32);
                if( sb_Schoko.getProgress()==0){
                    txtSchoko.setText("Schoko");
                    btnSchoko.setText("巧克力");
                    btnSchoko.setHovered(false);
                    btnSchoko.setActivated(false);
                    btnSchoko.setSelected(false);
                    btnSchoko.setBackground(getDrawable(R.drawable.btn_extra2));
                }
                else{
                    btnSchoko.setText("巧克力 " + progress);
                    btnSchoko.setHovered(true);
                    btnSchoko.setActivated(false);
                    btnSchoko.setSelected(false);
                    btnSchoko.setBackground(getDrawable(R.drawable.btn_press_switch));
                    //txtSchoko.setText("Schoko:" + progress);
                }
                    //      btnSchalen_shao.setActivated(true);
                }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar){
/*
                Toast.makeText(txt_sb_GebHänchen,"Achtung!  Gebackene Hähnchen ...Gebackene Hähnchen ...Hähnchen", Toast.LENGTH_LONG).show();
*/
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        btnSchoko.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                if (btnSchoko.isActivated()==true){
                    btnSchoko.setActivated(false);
                    btnSchoko.setSelected(true);

                    btnSchoko.setText("玻璃碗");
                    txtSchoko.setText("Schoko-Glas");

                }
                else if (btnSchoko.isSelected()==true){
                    btnSchoko.setSelected(false);
                    btnSchoko.setText("巧克力");
                    txtSchoko.setText("Schoko");

                }
                else if(btnSchoko.isHovered()==true)
                {   btnSchoko.setHovered(false);
                    sb_Schoko.setProgress(0);
                    btnSchoko.setBackground(getDrawable(R.drawable.btn_extra2));
                }
                else if (btnSchoko.getBackground()==getDrawable(R.drawable.btn_extra_blue))
                {
                    btnSchoko.setBackground(getDrawable(R.drawable.btn_extra_blue));
                }
                else {
                    btnSchoko.setActivated(true);
                }
            }
        });

        btnSchoko.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
                vibrator.vibrate(100);
                btnSchoko.setActivated(false);
                btnSchoko.setSelected(false);
                btnSchoko.setHovered(true);
                sb_Schoko.setProgress(4);
                btnSchoko.setBackground(getDrawable(R.drawable.btn_extra_blue));

                return true;
            }
        });


//----------------------------------------Mongolisch--------------------------------------------//
        txtMongolisch = (TextView) findViewById(R.id.txtMongolisch);
        btnSchalenklein = (Button) findViewById(R.id.btnSchalenklein);
        btnSchalenklein.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                if (btnSchalenklein.isActivated()==true){
                    btnSchalenklein.setActivated(false);
                    btnSchalenklein.setSelected(true);
                    btnSchalenklein.setText("寿 司");
                    txtMongolisch.setText("Suschi");

                }
                else if (btnSchalenklein.isSelected()==true){
                    btnSchalenklein.setSelected(false);
                    btnSchalenklein.setText("蒙古餐");
                    txtMongolisch.setText("Mongolisch");
                    btnSchalenklein.clearAnimation();
                }
                else {
                    btnSchalenklein.setActivated(true);
                    btnSchalenklein.startAnimation(animation);
                }
            }
        });
//----------------------------------------底--------------------------------------------//
        sb_Unterlage = (SeekBar) findViewById(R.id.sb_Unterlage);
        txtUnterlage = (TextView) findViewById(R.id.txtUnterlage);
        sb_Unterlage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged (SeekBar seekBar,int progress, boolean fromUser){
                if(sb_Unterlage.getProgress()==0){
                    //txtUnterlage.setText("Unterlagen");
                    btnUnterlage.setText("换 底");
                    btnUnterlage.setActivated(false);
                }
                else{
                    //btnUnterlage.setText("空 底 " + progress);
                    btnUnterlage.setText("空 底");
                    btnUnterlage.setActivated(true);
                    //txtUnterlage.setText("Unterlagen:"+progress);
                    btnUnterlage.setActivated(true);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){
/*
                Toast.makeText(txt_sb_GebHänchen,"Achtung!  Gebackene Hähnchen ...Gebackene Hähnchen ...Hähnchen", Toast.LENGTH_LONG).show();
*/
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        btnUnterlage = (Button) findViewById(R.id.Unterlage);
        btnUnterlage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                if (btnUnterlage.isActivated()==true){
                    btnUnterlage.setActivated(false);
                    txtUnterlage.setText("Unterlagen");
                    sb_Unterlage.setProgress(0);
                }
                else {btnUnterlage.setActivated(true);
                    sb_Unterlage.setProgress(2);
                }
            }
        });
//----------------------------------------勺-------------------------------------------//
        btnSchalen_shao= (Button) findViewById(R.id.Schalen_shao);
        btnSchalen_shao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                if (btnSchalen_shao.isActivated()==true){
                    btnSchalen_shao.setText("换铲");
                    btnSchalen_shao.setActivated(false);
                }
                else {
                    btnSchalen_shao.setActivated(true);
                    btnSchalen_shao.setText("餐铲");
                }
            }
        });

//----------------------------------------空兜大--------------------------------------------//
        sb_SchaleGroß = (SeekBar) findViewById(R.id.sb_SchaleGroß);
        txtSchaleGroß = (TextView) findViewById(R.id.txtSchaleGroß);
        sb_SchaleGroß.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged (SeekBar seekBar,int progress, boolean fromUser){
                //btnSchalenGroß.setTextSize(32);
                if(sb_SchaleGroß.getProgress()==0){
                    //txtSchaleGroß.setText("Schalen");
                    btnSchalenGroß.setText("换 兜");
                    btnSchalenGroß.setActivated(false);
                }
                else{
                    btnSchalenGroß.setText("餐兜 " + progress);
                    btnSchalenGroß.setActivated(true);
                    //txtSchaleGroß.setText("Schalen: " + progress);
                    //      btnSchalen_shao.setActivated(true);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){
/*
                Toast.makeText(txt_sb_GebHänchen,"Achtung!  Gebackene Hähnchen ...Gebackene Hähnchen ...Hähnchen", Toast.LENGTH_LONG).show();
*/
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        btnSchalenGroß = (Button) findViewById(R.id.SchalenGroß);
        btnSchalenGroß.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                if (btnSchalenGroß.isActivated()==true){
                    btnSchalenGroß.setActivated(false);
                    txtSchaleGroß.setText("Schalen");
                    sb_SchaleGroß.setProgress(0);
                }
                else {btnSchalenGroß.setActivated(true);
                    sb_SchaleGroß.setProgress(4);
                }
            }
        });
        Log.d("正常启动", "onCreate() Called"); // Notification in Log
    }
    //----------------------the solution for the problem after reconnecting----------------------------------------
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig); // ignore orientation/keyboard change
        Log.d("屏幕中断重启", "锁定状态 onConfigurationChanged() Called");
        Log.d("屏幕中断重启", "锁定状态 onConfigurationChanged  " +
                (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE ? "landscape" : "portrait"));
    }
}