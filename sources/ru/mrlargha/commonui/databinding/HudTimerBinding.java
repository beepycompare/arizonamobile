package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class HudTimerBinding implements ViewBinding {
    public final ImageView ivTimeIcon;
    private final LinearLayout rootView;
    public final LinearLayout timerContainer;
    public final TextView tvTime;
    public final TextView tvTitle;

    private HudTimerBinding(LinearLayout rootView, ImageView ivTimeIcon, LinearLayout timerContainer, TextView tvTime, TextView tvTitle) {
        this.rootView = rootView;
        this.ivTimeIcon = ivTimeIcon;
        this.timerContainer = timerContainer;
        this.tvTime = tvTime;
        this.tvTitle = tvTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static HudTimerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudTimerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_timer, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudTimerBinding bind(View rootView) {
        int i = R.id.iv_time_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.timer_container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                i = R.id.tv_time;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.tv_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        return new HudTimerBinding((LinearLayout) rootView, imageView, linearLayout, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
