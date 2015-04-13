package com.kyon.levelup.krnote.ui;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kyon.levelup.krnote.stable.KUIConstants;
import com.kyon.levelup.krnote.utils.KUIHelper;

/**
 * Created by kyon on 15-4-13.
 */
public class KBaseTitleUI extends RelativeLayout {

    protected TextView titleText;
    protected ImageView leftBtn;
    protected ImageView rightBtn;

    public KBaseTitleUI(Context context) {
        super(context);
        initLayout(context);
        initTitle(context);
        initButton(context);
    }

    public KBaseTitleUI(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public KBaseTitleUI(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private void initLayout(Context context){
        setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                KUIHelper.dip2px(context, KUIConstants.TOOBAR_HEIGHT)));
    }

    protected void initTitle(Context context) {

        LayoutParams textLayout = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textLayout.addRule(CENTER_IN_PARENT);

        titleText = new TextView(context);
        titleText.setLayoutParams(textLayout);
        titleText.setTextColor(KUIConstants.TITLE_TEXT_COLOR);
        titleText.setTextSize(KUIConstants.TITLE_TEXT_SIZE);
        titleText.setSingleLine();
        titleText.setBackgroundColor(Color.TRANSPARENT);
        titleText.setEllipsize(TextUtils.TruncateAt.END);

        addView(titleText);
    }


    protected void initButton(Context context) {
        int width = KUIHelper.dip2px(context,KUIConstants.BUTTON_WIDTH);
        int height = KUIHelper.dip2px(context,KUIConstants.BUTTON_HEIGHT);

        LayoutParams leftLayout = new LayoutParams(width,height);
        leftLayout.addRule(ALIGN_PARENT_LEFT);
        leftLayout.addRule(ALIGN_PARENT_BOTTOM);
        leftBtn = new ImageView(context);
        leftBtn.setLayoutParams(leftLayout);

        addView(leftBtn);

        LayoutParams rightLayout = new LayoutParams(width,height);
        rightLayout.addRule(ALIGN_PARENT_RIGHT);
        rightLayout.addRule(ALIGN_PARENT_BOTTOM);
        rightBtn = new ImageView(context);
        rightBtn.setLayoutParams(rightLayout);

        addView(rightBtn);

    }

    public void setLeftBtnRes(int resId){
        leftBtn.setBackgroundResource(resId);
    }

    public void setRightBtnRes(int resId){
        rightBtn.setBackgroundResource(resId);
    }

    public void setTitleText(String text){
        titleText.setText(text);
    }


}
