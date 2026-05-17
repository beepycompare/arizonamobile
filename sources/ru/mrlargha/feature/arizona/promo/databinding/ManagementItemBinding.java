package ru.mrlargha.feature.arizona.promo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.arizona.promo.R;
/* loaded from: classes5.dex */
public final class ManagementItemBinding implements ViewBinding {
    public final View colorBottom;
    public final ImageView image;
    private final LinearLayout rootView;
    public final TextView text;

    private ManagementItemBinding(LinearLayout linearLayout, View view, ImageView imageView, TextView textView) {
        this.rootView = linearLayout;
        this.colorBottom = view;
        this.image = imageView;
        this.text = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ManagementItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ManagementItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.management_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ManagementItemBinding bind(View view) {
        int i = R.id.color_bottom;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.image;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new ManagementItemBinding((LinearLayout) view, findChildViewById, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
