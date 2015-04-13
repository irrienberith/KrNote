package com.kyon.levelup.krnote.test;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.kyon.levelup.krnote.stable.KUIConstants;
import com.kyon.levelup.krnote.ui.KBaseTitleUI;
import com.kyon.levelup.krnote.utils.KUIHelper;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
    }

    private void initUI() {
        LinearLayout root = new LinearLayout(this);
        root.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        root.setOrientation(LinearLayout.VERTICAL);

        KBaseTitleUI titleUI = new KBaseTitleUI(this);
        titleUI.setBackgroundColor(Color.CYAN);
        titleUI.setTitleText("DEMO");


        root.addView(titleUI);

        setContentView(root);
    }
}
