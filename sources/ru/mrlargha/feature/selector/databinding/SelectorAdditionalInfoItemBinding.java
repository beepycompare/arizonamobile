package ru.mrlargha.feature.selector.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.selector.R;
/* loaded from: classes6.dex */
public final class SelectorAdditionalInfoItemBinding implements ViewBinding {
    public final ImageView line;
    private final FrameLayout rootView;
    public final TextView tvName;
    public final TextView tvValue;

    private SelectorAdditionalInfoItemBinding(FrameLayout frameLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.line = imageView;
        this.tvName = textView;
        this.tvValue = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static SelectorAdditionalInfoItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SelectorAdditionalInfoItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.selector_additional_info_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SelectorAdditionalInfoItemBinding bind(View view) {
        int i = R.id.line;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.tv_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tv_value;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new SelectorAdditionalInfoItemBinding((FrameLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
