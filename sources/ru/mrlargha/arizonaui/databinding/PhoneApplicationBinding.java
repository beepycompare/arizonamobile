package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class PhoneApplicationBinding implements ViewBinding {
    public final AppCompatImageView mobilePhoneIcon;
    public final TextView mobilePhoneTittle;
    public final ConstraintLayout phoneApplicationContainer;
    private final ConstraintLayout rootView;

    private PhoneApplicationBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, TextView textView, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.mobilePhoneIcon = appCompatImageView;
        this.mobilePhoneTittle = textView;
        this.phoneApplicationContainer = constraintLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static PhoneApplicationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PhoneApplicationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.phone_application, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PhoneApplicationBinding bind(View view) {
        int i = R.id.mobile_phone_icon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            i = R.id.mobile_phone_tittle;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                return new PhoneApplicationBinding(constraintLayout, appCompatImageView, textView, constraintLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
