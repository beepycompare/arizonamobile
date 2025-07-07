package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class HudTaximeterStopwatchBinding implements ViewBinding {
    public final ImageView armySecondTitle;
    public final ImageView ivBgBigger;
    public final ImageView ivBgSmaller;
    public final ImageView ivGoalsIcon;
    private final FrameLayout rootView;
    public final FrameLayout secondContainer;
    public final TextView tvArmySecondTimer;

    private HudTaximeterStopwatchBinding(FrameLayout rootView, ImageView armySecondTitle, ImageView ivBgBigger, ImageView ivBgSmaller, ImageView ivGoalsIcon, FrameLayout secondContainer, TextView tvArmySecondTimer) {
        this.rootView = rootView;
        this.armySecondTitle = armySecondTitle;
        this.ivBgBigger = ivBgBigger;
        this.ivBgSmaller = ivBgSmaller;
        this.ivGoalsIcon = ivGoalsIcon;
        this.secondContainer = secondContainer;
        this.tvArmySecondTimer = tvArmySecondTimer;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudTaximeterStopwatchBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudTaximeterStopwatchBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_taximeter_stopwatch, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudTaximeterStopwatchBinding bind(View rootView) {
        int i = R.id.army_second_title;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.iv_bg_bigger;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView2 != null) {
                i = R.id.iv_bg_smaller;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView3 != null) {
                    i = R.id.iv_goals_icon;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView4 != null) {
                        i = R.id.second_container;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                        if (frameLayout != null) {
                            i = R.id.tv_army_second_timer;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView != null) {
                                return new HudTaximeterStopwatchBinding((FrameLayout) rootView, imageView, imageView2, imageView3, imageView4, frameLayout, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
