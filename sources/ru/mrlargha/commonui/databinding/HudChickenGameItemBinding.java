package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class HudChickenGameItemBinding implements ViewBinding {
    public final CustomCardView bg;
    public final AppCompatImageView ivHeartIc;
    private final FrameLayout rootView;
    public final TextView tvGamerName;
    public final TextView tvHeartCount;

    private HudChickenGameItemBinding(FrameLayout rootView, CustomCardView bg, AppCompatImageView ivHeartIc, TextView tvGamerName, TextView tvHeartCount) {
        this.rootView = rootView;
        this.bg = bg;
        this.ivHeartIc = ivHeartIc;
        this.tvGamerName = tvGamerName;
        this.tvHeartCount = tvHeartCount;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudChickenGameItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudChickenGameItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_chicken_game_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudChickenGameItemBinding bind(View rootView) {
        int i = R.id.bg;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
        if (customCardView != null) {
            i = R.id.iv_heart_ic;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
            if (appCompatImageView != null) {
                i = R.id.tv_gamer_name;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.tv_heart_count;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        return new HudChickenGameItemBinding((FrameLayout) rootView, customCardView, appCompatImageView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
