package com.example.papaly.Barath;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.core.math.MathUtils;
import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.papaly.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FirstFragment extends Fragment {

    public FirstFragment() {
        // Required empty public constructor
    }

    ScrollView mScrollView;
    ImageView mPhotoIV, img_coin;
    Button btn;
    boolean scaled = true;
    RelativeLayout relative_layout, relative_container, relative_main, relative_count;
    TextView coin_count, coin_count_2;

    ImageView contactPic;

    FloatingActionButton btn_coin_add, btn_add_marbles, btn_options;
    boolean isVisible = false;

    ExtraConstructor extraConstructor = new ExtraConstructor();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_first, container, false);

        mScrollView = (ScrollView) v.findViewById(R.id.scrollView);
        mPhotoIV = (ImageView) v.findViewById(R.id.coin_container);
        img_coin = v.findViewById(R.id.img_coin);

        relative_layout = v.findViewById(R.id.relative_layout);
        relative_container = v.findViewById(R.id.relative_container);
        relative_main = v.findViewById(R.id.relative_main);
        relative_count = v.findViewById(R.id.relative_count);
        coin_count = v.findViewById(R.id.coin_count);
        coin_count_2 = v.findViewById(R.id.coin_count_2);

        btn_coin_add = v.findViewById(R.id.btn_coin_add);
        btn_add_marbles = v.findViewById(R.id.btn_add_marbles);
        btn_options = v.findViewById(R.id.btn_options);

        btn_options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isVisible)
                {
                    reveal();
                }
                else
                {
                    hide();
                }
            }
        });

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        float width = displayMetrics.widthPixels;

        int numberOfTanks = 1;

        Log.d("TAG", "Pixel " + convertDpToPx(getContext(), 140f));

        relative_main.getLayoutParams().height = (int) ((height) + (numberOfTanks * 330));

        if(numberOfTanks == 1)
        {
            relative_main.getLayoutParams().height = (int) ((height) + (numberOfTanks * 500));
        }

        mPhotoIV.measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        int photoHeight = mPhotoIV.getMeasuredHeight();
        int count = 0;
        int coinHeight = 0;
        int amount = 20;

        int extraHeight = 200;

        View[] arrayView = new View[numberOfTanks];

        for(int i = 0; i < numberOfTanks; i++)
        {
            View extraView = getLayoutInflater().inflate(R.layout.fragment_extra, null, false);
            arrayView[i] = extraView;
            extraConstructor.setView(arrayView);
            relative_main.addView(extraView);
            extraView.setVisibility(View.INVISIBLE);
            extraView.setTranslationY(mPhotoIV.getMeasuredHeight() + (320 * (i + 0.75f)));
//            extraView.setTranslationY(mPhotoIV.getMeasuredHeight() + (320));
            extraView.setTranslationX(width/5 + 7.5f);
            extraView.setTranslationZ(-10);

            RelativeLayout.LayoutParams params= new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.BELOW, R.id.relative_main);
            params.setMargins(180, -900,0,0);
            if(numberOfTanks == 1)
            {
                params.setMargins((int) (width-910), (int) (height-(height*1.438f)),0,0);
            }
            btn_coin_add .setLayoutParams(params);
        }

//        RelativeLayout.MarginLayoutParams params = (RelativeLayout.MarginLayoutParams) btn_coin_add.getLayoutParams();
//        params.topMargin = numberOfTanks * extraHeight;


        Animation animationOpen = new AlphaAnimation(0.0f, 1.0f);
        animationOpen.setDuration(2000);
        animationOpen.setFillAfter(true);

        Animation animationClose = new AlphaAnimation(1.0f, 0.0f);
        animationClose.setDuration(1500);
        animationClose.setFillAfter(true);

        for(int i = 0; i < amount; i++)
        {
            if(count >= 30)
            {
                break;
            }

            if(i < 4)
            {
                for(int j = 0; j <= i; j++)
                {
                    if(count >= amount)
                        break;

                    View coinView = getLayoutInflater().inflate(R.layout.fragment_coins, null, false);
                    relative_container.addView(coinView);

                    coinView.measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    coinHeight = coinView.getMeasuredHeight();

                    coinView.setTranslationZ(17);
                    coinView.setTranslationY(photoHeight - 550 - (coinHeight * (i / 1.6f)));
                    coinView.setTranslationX(((width / 2) - 62) + (i * 180) - ((j + i) * 120));

                    count++;
                }
            }
            else
            {
                float temp = 0.02f;
                for(int j = 0; j <= 3; j++)
                {
                    if(count >= amount)
                        break;

                    View coinView = getLayoutInflater().inflate(R.layout.fragment_coins, null, false);
                    relative_container.addView(coinView);

                    coinView.measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    coinHeight = coinView.getMeasuredHeight();

                    float rest = i*temp;

                    coinView.setTranslationZ(17);
                    coinView.setTranslationY(photoHeight - 550 - (coinHeight * (i / (1.60f - rest))));
                    coinView.setTranslationX(((width / 2) - 62) + (3 * 180) - ((j + 3) * 120));

                    count++;
                }
            }
//            Log.d("TAG", "temp " + count);
//            Log.d("TAG", "It is Rendering " + (((width / 2) - 62) + (i * 182) - ((3 + i) * 120)));
        }

        /*ImageView[] images = new ImageView[] { img1, img2, img3, img4, img5, img6, img7, img8, img9, img10 };
        int[] res = new int[] { R.id.img1, R.id.img2, R.id.img3, R.id.img4, R.id.img5, R.id.img6, R.id.img7, R.id.img8, R.id.img9, R.id.img10 };
        //int[] drawables = new int[] { R.drawable.f0sc, R.drawable.f1sc, ... };
        for (int i = 0; i < 9; i++) {

            images[i] = (ImageView) v.findViewById(res[i]);
            images[i].setVisibility(View.VISIBLE);
            for(int j = 0; j <= i; j++)
            {
                images[j].setTranslationX((width / 2f - 60 - (j * 52)));
                images[j].setTranslationY((-height / 3.9f) - (50 * j));
            }
        }*/

        int length_max = mScrollView.getHeight();

        /*mScrollView.getViewTreeObserver().addOnScrollChangedListener(new ScrollPositionObserver());
        Log.d("TAG", "ScaleY " + mPhotoIV.getScaleY());*/
        mScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                float scrollY = mScrollView.getScrollY(); // For ScrollView
                int scrollX = mScrollView.getScrollX(); // For HorizontalScrollView
//                float k = MathUtils.clamp(scrollY, .5f, 1);
                float y = (scrollY / (scrollY + 1)) ;
                Log.d("TAG", "ScaleY " + height);

                /*ScaleAnimation fade_in = new ScaleAnimation(1f, k, 1f, k, Animation.RELATIVE_TO_SELF, 0.2f, Animation.RELATIVE_TO_SELF, 0.5f);
                fade_in.setDuration(1000);
                fade_in.setFillAfter(true);
                v.startAnimation(fade_in);*/

                ScaleAnimation fade_in = new ScaleAnimation(1f, y - 0.3f, 1f, y - 0.3f, Animation.RELATIVE_TO_SELF, -(width * 0.00037f), Animation.RELATIVE_TO_SELF, height * 0.00022f);
                fade_in.setDuration(1500);
                fade_in.setFillAfter(true);

                ScaleAnimation fade_out = new ScaleAnimation(y - 0.3f, 1f, y - 0.3f, 1f, Animation.RELATIVE_TO_SELF, -0.4f, Animation.RELATIVE_TO_SELF, 0.5f);
                fade_out.setDuration(1500);
                fade_out.setFillAfter(true);

                TranslateAnimation move_left = new TranslateAnimation(0, (width/2)-1200,0, 0);
                move_left.setDuration(1500);
                move_left.setFillAfter(true);

                TranslateAnimation move_right = new TranslateAnimation((width/2)-1200, 0,0, 0);
                move_right.setDuration(1500);
                move_right.setFillAfter(true);

                Animation btn_animation_in = new AlphaAnimation(0.0f, 1.0f);
                btn_animation_in.setDuration(2000);
                btn_animation_in.setFillAfter(true);

                Animation btn_animation_out = new AlphaAnimation(1.0f, 0.0f);
                btn_animation_out.setDuration(1500);
                btn_animation_out.setFillAfter(true);

                if(scrollY > 350 && scaled)
                {
                    mScrollView.smoothScrollTo(350, 900);
                    scaled = false;
                    relative_container.startAnimation(fade_in);
//                    btn_coin_add.startAnimation(fade_in);
                    relative_count.startAnimation(move_left);
                    for(View v : extraConstructor.getView())
                    {
                        v.setVisibility(View.VISIBLE);
                        v.startAnimation(animationOpen);
                    }
                    btn_coin_add.startAnimation(btn_animation_in);
                    btn_coin_add.setVisibility(View.VISIBLE);
                }
                if(scrollY < 300 && !scaled)
                {
                    //mScrollView.smoothScrollTo(550, 0);
                    scaled = true;
                    relative_container.startAnimation(fade_out);
//                    btn_coin_add.startAnimation(fade_out);
                    relative_count.startAnimation(move_right);
                    for(View v : extraConstructor.getView())
                    {
                        v.startAnimation(animationClose);
                        v.setVisibility(View.INVISIBLE);
                    }
//                    extraConstructor.getView().startAnimation(animationClose);
//                    extraConstructor.getView().setVisibility(View.INVISIBLE);
//                    btn_coin_add.startAnimation(animationClose);
                    btn_coin_add.startAnimation(btn_animation_out);
                    btn_coin_add.setVisibility(View.GONE);
                }

            }
        });

//        mPhotoIV.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ScaleAnimation fade_in = new ScaleAnimation(1f, 0.5f, 1f, 0.5f, Animation.RELATIVE_TO_SELF, 0.2f, Animation.RELATIVE_TO_SELF, 0.5f);
//                fade_in.setDuration(1000);
//                fade_in.setFillAfter(true);
//                v.startAnimation(fade_in);
//            }
//        });

        return v;
    }

    private class ScrollPositionObserver implements ViewTreeObserver.OnScrollChangedListener {

        private int mImageViewHeight;

        public ScrollPositionObserver() {
            mImageViewHeight = getResources().getDimensionPixelSize(R.dimen.contact_photo_height);
        }

        @Override
        public void onScrollChanged() {
            int scrollY = Math.min(Math.max(mScrollView.getScrollY(), 10), mImageViewHeight);

            int value = Math.max(0, Math.min(1, scrollY));
            Log.d("TAG", "ScaleY " + mPhotoIV.getScaleY());
            // changing position of ImageView
//            mPhotoIV.setScaleY(value / 2f);
//            mPhotoIV.setScaleX(value / 2f);

            // alpha you could set to ActionBar background
            float alpha = scrollY / (float) mImageViewHeight;
        }
    }

    public float convertDpToPx(Context context, float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }

    private void reveal()
    {
        int addX = btn_add_marbles.getWidth() / 2;
        int addY = btn_add_marbles.getHeight() / 2;

        float finalRadiusLogout = (float) Math.hypot(addX,addY);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
        {
            Animator animLogout = ViewAnimationUtils.createCircularReveal(btn_add_marbles,addX,addY,0,finalRadiusLogout);

            btn_add_marbles.setVisibility(View.VISIBLE);

            animLogout.start();
        }
        else
        {
            btn_add_marbles.setVisibility(View.VISIBLE);
        }
        isVisible = true;
    }

    private void hide()
    {
        int addX = btn_add_marbles.getWidth() / 2;
        int addY = btn_add_marbles.getHeight() / 2;

        float initialRadiusLogout = (float) Math.hypot(addX,addY);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
        {
            Animator animLogout = ViewAnimationUtils.createCircularReveal(btn_add_marbles,addX,addY,initialRadiusLogout,0);

            animLogout.addListener(new AnimatorListenerAdapter()
            {
                @Override
                public void onAnimationEnd(Animator animation)
                {
                    super.onAnimationEnd(animation);
                    btn_add_marbles.setVisibility(View.GONE);
                }
            });

            animLogout.start();
        }
        else
        {
            btn_add_marbles.setVisibility(View.GONE);
        }
        isVisible = false;
    }

    /*public void addView()
    {
        View coinView = getLayoutInflater().inflate(R.layout.fragment_coins, null , false);
        relative_container.addView(coinView);
    }*/
}