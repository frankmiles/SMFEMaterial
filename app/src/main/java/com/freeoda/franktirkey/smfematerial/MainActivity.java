package com.freeoda.franktirkey.smfematerial;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    LinearLayout llTest,loginLayout;
    CheckBox checkBox;
    TextInputLayout lemail,lpassword;
    Button btnRegister,btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setElevation(24);
        boolean Signin = false;

        llTest = findViewById(R.id.llTest);
        loginLayout = findViewById(R.id.loginLayout);
        checkBox = findViewById(R.id.checkBox);
        lemail = findViewById(R.id.lemail);
        lpassword = findViewById(R.id.lpassword);
        btnRegister = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);

        if(!Signin){
            Signin = MYanimate();
        }
        else {

        }

        myActionBar();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainPage.class));
                MainActivity.this.finish();

            }
        });

    }

    public void myActionBar(){
        String title = "SMFE";
        SpannableString s = new SpannableString(title);
        s.setSpan(new ForegroundColorSpan(Color.WHITE),0,title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        Objects.requireNonNull(getSupportActionBar()).setTitle(s);
        String subtitle = "Material";
        SpannableString s2 = new SpannableString(subtitle);
        s2.setSpan(new ForegroundColorSpan(Color.WHITE),0,subtitle.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setSubtitle(s2);
    }

    public boolean MYanimate(){
        llTest.animate()
                .alpha(0f)
                .setDuration(1000)
                .setStartDelay(2000)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationStart(Animator animation, boolean isReverse) {


                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        DisplayMetrics dm = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(dm);
                        llTest.setVisibility(View.GONE);
                        loginLayout.animate()
                                .alpha(1f)
                                .translationY(0)
                                .setDuration(1000)
                                .setListener(new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        super.onAnimationEnd(animation);

                                        lemail.animate()
                                                .setDuration(500)
                                                .translationX(0)
                                                .alpha(1);
                                        lpassword.animate()
                                                .alpha(1)
                                                .translationX(0)
                                                .setDuration(1000);
                                        checkBox.animate()
                                                .alpha(1)
                                                .translationX(0)
                                                .setDuration(2000)
                                                .setListener(new AnimatorListenerAdapter() {
                                                    @Override
                                                    public void onAnimationEnd(Animator animation) {
                                                        super.onAnimationEnd(animation);
                                                        btnRegister.animate()
                                                                .translationY(0)
                                                                .setDuration(500);
                                                        btnLogin.animate()
                                                                .translationY(0)
                                                                .setDuration(1000)
                                                                .setListener(new AnimatorListenerAdapter() {
                                                                    @Override
                                                                    public void onAnimationEnd(Animator animation) {
                                                                        super.onAnimationEnd(animation);
                                                                    }
                                                                });
                                                    }
                                                });
                                    }
                                });

                    }
                });

        return true;
    }
}
