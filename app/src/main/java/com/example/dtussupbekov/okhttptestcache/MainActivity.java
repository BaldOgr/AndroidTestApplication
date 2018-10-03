package com.example.dtussupbekov.okhttptestcache;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_wallet:
                        if (getSupportFragmentManager().findFragmentByTag("asd") == null)
                            getSupportFragmentManager().beginTransaction()
                                    .add(R.id.contentView, ExampleFragment.getInstance(), "asd")
                                    .commit();
                }
                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.action_wallet);
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

    private void showBottomNavigation() {

    }

    private class Dialog extends BottomSheetDialog {

        public Dialog(@NonNull Context context) {
            super(context);
        }

        void asd() {

        }
    }
}
