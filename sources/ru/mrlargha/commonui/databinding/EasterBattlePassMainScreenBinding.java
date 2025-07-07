package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class EasterBattlePassMainScreenBinding implements ViewBinding {
    public final ImageView ivVideo;
    public final LinearLayout levelContainer;
    public final TextView levelPassText;
    public final ImageView logo;
    public final TextView mainExperienceText;
    public final LinearProgressIndicator progressExperience;
    public final LinearLayout remainingTime;
    public final TextView remainingTimeTextMain;
    private final ConstraintLayout rootView;
    public final RecyclerView rvPrice;

    private EasterBattlePassMainScreenBinding(ConstraintLayout rootView, ImageView ivVideo, LinearLayout levelContainer, TextView levelPassText, ImageView logo, TextView mainExperienceText, LinearProgressIndicator progressExperience, LinearLayout remainingTime, TextView remainingTimeTextMain, RecyclerView rvPrice) {
        this.rootView = rootView;
        this.ivVideo = ivVideo;
        this.levelContainer = levelContainer;
        this.levelPassText = levelPassText;
        this.logo = logo;
        this.mainExperienceText = mainExperienceText;
        this.progressExperience = progressExperience;
        this.remainingTime = remainingTime;
        this.remainingTimeTextMain = remainingTimeTextMain;
        this.rvPrice = rvPrice;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static EasterBattlePassMainScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EasterBattlePassMainScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.easter_battle_pass_main_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static EasterBattlePassMainScreenBinding bind(View rootView) {
        int i = R.id.iv_video;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.level_container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                i = R.id.level_pass_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.logo;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView2 != null) {
                        i = R.id.main_experience_text;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            i = R.id.progress_experience;
                            LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) ViewBindings.findChildViewById(rootView, i);
                            if (linearProgressIndicator != null) {
                                i = R.id.remaining_time;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                if (linearLayout2 != null) {
                                    i = R.id.remaining_time_text_main;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView3 != null) {
                                        i = R.id.rv_price;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                        if (recyclerView != null) {
                                            return new EasterBattlePassMainScreenBinding((ConstraintLayout) rootView, imageView, linearLayout, textView, imageView2, textView2, linearProgressIndicator, linearLayout2, textView3, recyclerView);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
