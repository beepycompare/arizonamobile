package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class ItemGuardViewBinding implements ViewBinding {
    public final ImageView ivGuardSkin;
    public final ConstraintLayout layoutGuardInfo;
    private final ConstraintLayout rootView;
    public final TextView tvGuardHealth;
    public final TextView tvGuardLevel;
    public final TextView tvGuardType;

    private ItemGuardViewBinding(ConstraintLayout rootView, ImageView ivGuardSkin, ConstraintLayout layoutGuardInfo, TextView tvGuardHealth, TextView tvGuardLevel, TextView tvGuardType) {
        this.rootView = rootView;
        this.ivGuardSkin = ivGuardSkin;
        this.layoutGuardInfo = layoutGuardInfo;
        this.tvGuardHealth = tvGuardHealth;
        this.tvGuardLevel = tvGuardLevel;
        this.tvGuardType = tvGuardType;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemGuardViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemGuardViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.item_guard_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemGuardViewBinding bind(View rootView) {
        int i = R.id.ivGuardSkin;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
            i = R.id.tvGuardHealth;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.tvGuardLevel;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.tvGuardType;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        return new ItemGuardViewBinding(constraintLayout, imageView, constraintLayout, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
