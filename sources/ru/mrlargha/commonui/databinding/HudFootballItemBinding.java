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
/* loaded from: classes6.dex */
public final class HudFootballItemBinding implements ViewBinding {
    public final ImageView ivBg;
    private final FrameLayout rootView;
    public final TextView tvName;
    public final TextView tvScore;

    private HudFootballItemBinding(FrameLayout rootView, ImageView ivBg, TextView tvName, TextView tvScore) {
        this.rootView = rootView;
        this.ivBg = ivBg;
        this.tvName = tvName;
        this.tvScore = tvScore;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudFootballItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudFootballItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_football_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudFootballItemBinding bind(View rootView) {
        int i = R.id.iv_bg;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.tv_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.tv_score;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    return new HudFootballItemBinding((FrameLayout) rootView, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
