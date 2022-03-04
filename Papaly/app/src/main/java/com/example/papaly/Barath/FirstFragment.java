package com.example.papaly.Barath;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.core.math.MathUtils;
import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
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

    FloatingActionButton btn_coin_add;

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

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        float width = displayMetrics.widthPixels;

        int numberOfTanks = 4;

        Log.d("TAG", "Pixel " + convertDpToPx(getContext(), 140f));

        relative_main.getLayoutParams().height = (int) ((height - 200) + ((height - 200) * (numberOfTanks/5f)));

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
            extraView.setTranslationY(mPhotoIV.getMeasuredHeight() + (320 * (i + 1)));
//            extraView.setTranslationY(mPhotoIV.getMeasuredHeight() + (320));
            extraView.setTranslationX(width/5 + 7.5f);

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

                ScaleAnimation fade_in = new ScaleAnimation(1f, y - 0.3f, 1f, y - 0.3f, Animation.RELATIVE_TO_SELF, -0.4f, Animation.RELATIVE_TO_SELF, 0.5f);
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

                if(scrollY > 700 && scaled)
                {
                    mScrollView.smoothScrollTo(700, 900);
                    scaled = false;
                    relative_container.startAnimation(fade_in);
                    relative_count.startAnimation(move_left);
                    for(View v : extraConstructor.getView())
                    {
                        v.setVisibility(View.VISIBLE);
                        v.startAnimation(animationOpen);
                    }
                }
                if(scrollY < 550 && !scaled)
                {
                    //mScrollView.smoothScrollTo(550, 0);
                    scaled = true;
                    relative_container.startAnimation(fade_out);
                    relative_count.startAnimation(move_right);
                    for(View v : extraConstructor.getView())
                    {
                        v.startAnimation(animationClose);
                        v.setVisibility(View.INVISIBLE);
                    }
//                    extraConstructor.getView().startAnimation(animationClose);
//                    extraConstructor.getView().setVisibility(View.INVISIBLE);

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

    /*public void addView()
    {
        View coinView = getLayoutInflater().inflate(R.layout.fragment_coins, null , false);
        relative_container.addView(coinView);
    }*/
}