package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class AnimationCategoryItemBinding implements ViewBinding {
    public final LinearLayout aciBackground;
    public final TextView aciTittle;
    private final LinearLayout rootView;

    private AnimationCategoryItemBinding(LinearLayout rootView, LinearLayout aciBackground, TextView aciTittle) {
        this.rootView = rootView;
        this.aciBackground = aciBackground;
        this.aciTittle = aciTittle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AnimationCategoryItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AnimationCategoryItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.animation_category_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static AnimationCategoryItemBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = R.id.aci_tittle;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            return new AnimationCategoryItemBinding(linearLayout, linearLayout, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
