package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class ApRatingSpinnerItemBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final AppCompatImageView serverIcon;
    public final TextView severName;
    public final LinearLayout spinnerBaseLayout;

    private ApRatingSpinnerItemBinding(LinearLayout linearLayout, AppCompatImageView appCompatImageView, TextView textView, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.serverIcon = appCompatImageView;
        this.severName = textView;
        this.spinnerBaseLayout = linearLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ApRatingSpinnerItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ApRatingSpinnerItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.ap_rating_spinner_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ApRatingSpinnerItemBinding bind(View view) {
        int i = R.id.server_icon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            i = R.id.sever_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                return new ApRatingSpinnerItemBinding(linearLayout, appCompatImageView, textView, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
