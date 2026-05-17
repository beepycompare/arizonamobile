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
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class HudElementPiratesBinding implements ViewBinding {
    public final ImageView ivBg;
    public final ImageView ivImage;
    public final FrameLayout pirates;
    public final CustomCardView progressBar;
    public final CustomCardView progressBarBg;
    public final TextView progressText;
    private final FrameLayout rootView;
    public final TextView tvTitle;

    private HudElementPiratesBinding(FrameLayout rootView, ImageView ivBg, ImageView ivImage, FrameLayout pirates, CustomCardView progressBar, CustomCardView progressBarBg, TextView progressText, TextView tvTitle) {
        this.rootView = rootView;
        this.ivBg = ivBg;
        this.ivImage = ivImage;
        this.pirates = pirates;
        this.progressBar = progressBar;
        this.progressBarBg = progressBarBg;
        this.progressText = progressText;
        this.tvTitle = tvTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudElementPiratesBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudElementPiratesBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_element_pirates, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudElementPiratesBinding bind(View rootView) {
        int i = R.id.iv_bg;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.iv_image;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView2 != null) {
                FrameLayout frameLayout = (FrameLayout) rootView;
                i = R.id.progress_bar;
                CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                if (customCardView != null) {
                    i = R.id.progress_bar_bg;
                    CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                    if (customCardView2 != null) {
                        i = R.id.progressText;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView != null) {
                            i = R.id.tv_title;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView2 != null) {
                                return new HudElementPiratesBinding(frameLayout, imageView, imageView2, frameLayout, customCardView, customCardView2, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
