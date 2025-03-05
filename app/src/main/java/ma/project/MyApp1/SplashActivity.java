package ma.project.MyApp1;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView logo = findViewById(R.id.logo);
        FrameLayout fr1 = findViewById(R.id.fr1);
        FrameLayout fr2 = findViewById(R.id.fr2);

        // Make logo rounded
        logo.setClipToOutline(true);
        logo.setOutlineProvider(ViewOutlineProvider.BACKGROUND);

        // Rotate animation for logo
        RotateAnimation rotate = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        rotate.setDuration(5000);
        rotate.setRepeatCount(Animation.INFINITE);
        logo.startAnimation(rotate);

        // Start animations for the FrameLayouts
        animateBackground(fr1, "#3F51B5", "#FF9800");  // Blue to Orange
        animateBackground(fr2, "#FF5722", "#4CAF50");  // Red to Green

        animateElevation(fr1);
        animateElevation(fr2);

        // Delay and start MainActivity
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }).start();
    }

    private void animateBackground(View view, String color1, String color2) {
        ObjectAnimator animator = ObjectAnimator.ofObject(
                view,
                "backgroundColor",
                new ArgbEvaluator(),
                Color.parseColor(color1),
                Color.parseColor(color2)
        );
        animator.setDuration(2000);
        animator.setRepeatMode(ObjectAnimator.REVERSE);
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        animator.start();
    }

    private void animateElevation(View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationZ", 0f, 30f);
        animator.setDuration(1000);
        animator.setRepeatMode(ObjectAnimator.REVERSE);
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        animator.start();
    }
}
