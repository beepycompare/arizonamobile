package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class AnimationItemBinding implements ViewBinding {
    public final LinearLayout aiBackground;
    public final AppCompatImageView aiFavorite;
    public final AppCompatImageView aiImage;
    public final TextView aiTittle;
    private final LinearLayout rootView;

    private AnimationItemBinding(LinearLayout rootView, LinearLayout aiBackground, AppCompatImageView aiFavorite, AppCompatImageView aiImage, TextView aiTittle) {
        this.rootView = rootView;
        this.aiBackground = aiBackground;
        this.aiFavorite = aiFavorite;
        this.aiImage = aiImage;
        this.aiTittle = aiTittle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AnimationItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AnimationItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.animation_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static AnimationItemBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = R.id.ai_favorite;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
        if (appCompatImageView != null) {
            i = R.id.ai_image;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
            if (appCompatImageView2 != null) {
                i = R.id.ai_tittle;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    return new AnimationItemBinding(linearLayout, linearLayout, appCompatImageView, appCompatImageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
