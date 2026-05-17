package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class HudCounterBinding implements ViewBinding {
    public final HudCounterItemBinding firstItem;
    public final ImageView ivBg;
    private final FrameLayout rootView;
    public final HudCounterItemBinding secondItem;

    private HudCounterBinding(FrameLayout rootView, HudCounterItemBinding firstItem, ImageView ivBg, HudCounterItemBinding secondItem) {
        this.rootView = rootView;
        this.firstItem = firstItem;
        this.ivBg = ivBg;
        this.secondItem = secondItem;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudCounterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudCounterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_counter, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudCounterBinding bind(View rootView) {
        View findChildViewById;
        int i = R.id.first_item;
        View findChildViewById2 = ViewBindings.findChildViewById(rootView, i);
        if (findChildViewById2 != null) {
            HudCounterItemBinding bind = HudCounterItemBinding.bind(findChildViewById2);
            int i2 = R.id.iv_bg;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i2);
            if (imageView != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i2 = R.id.second_item))) != null) {
                return new HudCounterBinding((FrameLayout) rootView, bind, imageView, HudCounterItemBinding.bind(findChildViewById));
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
