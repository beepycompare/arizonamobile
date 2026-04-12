package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes3.dex */
public final class HudGathersCountItemBinding implements ViewBinding {
    public final LinearLayout activeContainer;
    public final ImageView ivActiveIc;
    public final ImageView ivBg;
    public final ImageView ivInactiveIc;
    private final FrameLayout rootView;
    public final TextView tvTimer;

    private HudGathersCountItemBinding(FrameLayout rootView, LinearLayout activeContainer, ImageView ivActiveIc, ImageView ivBg, ImageView ivInactiveIc, TextView tvTimer) {
        this.rootView = rootView;
        this.activeContainer = activeContainer;
        this.ivActiveIc = ivActiveIc;
        this.ivBg = ivBg;
        this.ivInactiveIc = ivInactiveIc;
        this.tvTimer = tvTimer;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudGathersCountItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudGathersCountItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_gathers_count_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudGathersCountItemBinding bind(View rootView) {
        int i = R.id.active_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.iv_active_ic;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.iv_bg;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView2 != null) {
                    i = R.id.iv_inactive_ic;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView3 != null) {
                        i = R.id.tv_timer;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView != null) {
                            return new HudGathersCountItemBinding((FrameLayout) rootView, linearLayout, imageView, imageView2, imageView3, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
