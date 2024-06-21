package com.example.mynewapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.mynewapp.dk.ResideMenu;
import com.example.mynewapp.dk.ResideMenuItem;

public class india extends FragmentActivity implements View.OnClickListener {
    int i=0;
    private ResideMenu resideMenu;
    private ResideMenuItem itemHome;
    //private ResideMenuItem itemAccount;
    private ResideMenuItem itemAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_india);
        setUpMenu();

        if (savedInstanceState == null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();
    }

    private void setUpMenu() {

        // attach to current activity;
        resideMenu = new ResideMenu(this);
        resideMenu.attachToActivity(this);
        resideMenu.setMenuListener(menuListener);
//        resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);
        //valid scale factor is between 0.0f and 1.0f. leftmenu'width is 150dip.
        resideMenu.setScaleValue(0.6f);

        // create menu items;
        itemHome = new ResideMenuItem(this, R.drawable.ghum, "Tours");
      //  itemAccount=new ResideMenuItem(this,R.drawable.ghum,"Account");
        itemAbout=new ResideMenuItem(this,R.drawable.ghum,"About");
        itemHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(india.this,DrawerActivity.class);
                startActivity(intent);
            }
        });
        //itemAccount.setOnClickListener(new View.OnClickListener() {
            //@Override
          //  public void onClick(View v) {
          //      Intent intent=new Intent(india.this,ShowDataActivity.class);
            //    startActivity(intent);
            //}
        //});

        itemAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(india.this,about.class);
                startActivity(intent);
            }
        });
        resideMenu.addMenuItem(itemHome, ResideMenu.DIRECTION_LEFT);
       // resideMenu.addMenuItem(itemAccount,ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(itemAbout,ResideMenu.DIRECTION_RIGHT);


        findViewById(R.id.titlebarleftmenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });
        findViewById(R.id.titlebarrightmenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_RIGHT);
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent(ev);
    }

    @Override
    public void onClick(View view) {

        if (view == itemHome) {
            //changeFragment(new Fragment_City());
        }

        resideMenu.closeMenu();
    }

    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {
//            Toast.makeText(mContext, "Menu is opened!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void closeMenu() {
//            Toast.makeText(mContext, "Menu is closed!", Toast.LENGTH_SHORT).show();
        }
    };

    private void changeFragment(final Fragment_City targetFragment) {
        resideMenu.clearIgnoredViewList();
        if (resideMenu.isOpened())
            resideMenu.closeMenu();

        new Handler() {
        }.postDelayed(new Runnable() {
            @Override
            public void run() {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_fragment, targetFragment, "fragment")
                        .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit();
            }
        }, 1000);
    }

    // What good method is to access resideMenu？
    public ResideMenu getResideMenu() {
        return resideMenu;
    }

    @Override
    public void onBackPressed() {
        i++;
        if (i == 2)
            System.exit(0);
        else {
            Toast.makeText(this, "press one more time to exit", Toast.LENGTH_SHORT).show();
        }
    }
}