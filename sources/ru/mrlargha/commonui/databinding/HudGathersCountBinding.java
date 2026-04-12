package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes3.dex */
public final class HudGathersCountBinding implements ViewBinding {
    public final FrameLayout debuffContainer;
    public final ImageView ivDebuffBg;
    public final ImageView ivDebuffIc;
    private final FrameLayout rootView;
    public final RecyclerView rvBonus;
    public final TextView tvDebuff;
    public final TextView tvDebuffTimer;
    public final TextView tvTimer;

    private HudGathersCountBinding(FrameLayout rootView, FrameLayout debuffContainer, ImageView ivDebuffBg, ImageView ivDebuffIc, RecyclerView rvBonus, TextView tvDebuff, TextView tvDebuffTimer, TextView tvTimer) {
        this.rootView = rootView;
        this.debuffContainer = debuffContainer;
        this.ivDebuffBg = ivDebuffBg;
        this.ivDebuffIc = ivDebuffIc;
        this.rvBonus = rvBonus;
        this.tvDebuff = tvDebuff;
        this.tvDebuffTimer = tvDebuffTimer;
        this.tvTimer = tvTimer;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudGathersCountBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudGathersCountBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_gathers_count, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudGathersCountBinding bind(View rootView) {
        int i = R.id.debuff_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
        if (frameLayout != null) {
            i = R.id.iv_debuff_bg;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.iv_debuff_ic;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView2 != null) {
                    i = R.id.rv_bonus;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                    if (recyclerView != null) {
                        i = R.id.tv_debuff;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView != null) {
                            i = R.id.tv_debuff_timer;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView2 != null) {
                                i = R.id.tv_timer;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView3 != null) {
                                    return new HudGathersCountBinding((FrameLayout) rootView, frameLayout, imageView, imageView2, recyclerView, textView, textView2, textView3);
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
