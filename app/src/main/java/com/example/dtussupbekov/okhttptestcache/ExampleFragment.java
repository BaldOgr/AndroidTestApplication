package com.example.dtussupbekov.okhttptestcache;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class ExampleFragment extends Fragment {


    public static ExampleFragment getInstance() {
        return new ExampleFragment();
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);

        Button button = view.findViewById(R.id.button);
        final ConstraintLayout constraintLayout = view.findViewById(R.id.data);

        final View overlay = getLayoutInflater().inflate(R.layout.overlay, null);
        overlay.measure(View.MeasureSpec.makeMeasureSpec(100, View.MeasureSpec.EXACTLY), View.MeasureSpec.makeMeasureSpec(100, View.MeasureSpec.EXACTLY));
        constraintLayout.getOverlay().add(overlay);

        LinearLayout llBottomSheet = view.findViewById(R.id.bottom_sheet);
        final BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(llBottomSheet);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        final View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        };

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        overlay.layout(0, 0, 0, 0);
                        setClickable(constraintLayout, true);
                        constraintLayout.setOnClickListener(null);
                        break;

                    case BottomSheetBehavior.STATE_COLLAPSED:

                    case BottomSheetBehavior.STATE_EXPANDED:

                    default:
                        overlay.layout(0, 0, constraintLayout.getWidth(), constraintLayout.getHeight());
                        setClickable(constraintLayout, false);
                        constraintLayout.setEnabled(true);
                        constraintLayout.setClickable(true);
                        constraintLayout.setOnClickListener(clickListener);
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                float alpha;
                if (0 <= slideOffset && slideOffset <= 1) {
                    alpha = 1f;
                } else {
                    alpha = 1 + slideOffset;
                }
                Log.d("Slide", String.valueOf(slideOffset));
                Log.d("Alpha", String.valueOf(alpha));
                overlay.setAlpha(alpha);
//                constraintLayout.animate()
//                        .alphaBy()
//                        .setDuration(0)
//                        .start();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

            }
        });

        return view;
    }

    private void setClickable(View view, boolean enabled) {
        view.setEnabled(enabled);
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;

            for (int idx = 0; idx < group.getChildCount(); idx++) {
                setClickable(group.getChildAt(idx), enabled);
            }
        }
    }
}
