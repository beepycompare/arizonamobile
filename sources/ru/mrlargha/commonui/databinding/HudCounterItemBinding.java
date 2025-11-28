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
public final class HudCounterItemBinding implements ViewBinding {
    public final FrameLayout content;
    public final ImageView ivIc;
    public final ImageView ivItemBg;
    private final FrameLayout rootView;
    public final LinearLayout textWithIcon;
    public final LinearLayout textWithTitle;
    public final TextView tvProgress;
    public final TextView tvSimpleTime;
    public final TextView tvTitleProgress;
    public final TextView tvTitleWithIc;

    private HudCounterItemBinding(FrameLayout rootView, FrameLayout content, ImageView ivIc, ImageView ivItemBg, LinearLayout textWithIcon, LinearLayout textWithTitle, TextView tvProgress, TextView tvSimpleTime, TextView tvTitleProgress, TextView tvTitleWithIc) {
        this.rootView = rootView;
        this.content = content;
        this.ivIc = ivIc;
        this.ivItemBg = ivItemBg;
        this.textWithIcon = textWithIcon;
        this.textWithTitle = textWithTitle;
        this.tvProgress = tvProgress;
        this.tvSimpleTime = tvSimpleTime;
        this.tvTitleProgress = tvTitleProgress;
        this.tvTitleWithIc = tvTitleWithIc;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudCounterItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudCounterItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_counter_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudCounterItemBinding bind(View rootView) {
        int i = R.id.content;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
        if (frameLayout != null) {
            i = R.id.iv_ic;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.iv_item_bg;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView2 != null) {
                    i = R.id.text_with_icon;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout != null) {
                        i = R.id.text_with_title;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                        if (linearLayout2 != null) {
                            i = R.id.tv_progress;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView != null) {
                                i = R.id.tv_simple_time;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView2 != null) {
                                    i = R.id.tv_title_progress;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView3 != null) {
                                        i = R.id.tv_title_with_ic;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView4 != null) {
                                            return new HudCounterItemBinding((FrameLayout) rootView, frameLayout, imageView, imageView2, linearLayout, linearLayout2, textView, textView2, textView3, textView4);
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
