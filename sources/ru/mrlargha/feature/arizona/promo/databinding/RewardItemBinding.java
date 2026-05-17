package ru.mrlargha.feature.arizona.promo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.arizona.promo.R;
/* loaded from: classes5.dex */
public final class RewardItemBinding implements ViewBinding {
    public final View colorBottom;
    public final ImageView image;
    public final FrameLayout recieved;
    private final LinearLayout rootView;
    public final TextView text;

    private RewardItemBinding(LinearLayout linearLayout, View view, ImageView imageView, FrameLayout frameLayout, TextView textView) {
        this.rootView = linearLayout;
        this.colorBottom = view;
        this.image = imageView;
        this.recieved = frameLayout;
        this.text = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RewardItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static RewardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.reward_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static RewardItemBinding bind(View view) {
        int i = R.id.color_bottom;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.image;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.recieved;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    i = R.id.text;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        return new RewardItemBinding((LinearLayout) view, findChildViewById, imageView, frameLayout, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
