package ru.mrlargha.feature.mobile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.mobile.R;
/* loaded from: classes6.dex */
public final class PhoneApplicationBinding implements ViewBinding {
    public final AppCompatImageView mobilePhoneIcon;
    public final TextView mobilePhoneTittle;
    public final ConstraintLayout phoneApplicationContainer;
    private final ConstraintLayout rootView;
    public final TextView tvMessageCount;
    public final FrameLayout unreadMeassageContainer;

    private PhoneApplicationBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, TextView textView, ConstraintLayout constraintLayout2, TextView textView2, FrameLayout frameLayout) {
        this.rootView = constraintLayout;
        this.mobilePhoneIcon = appCompatImageView;
        this.mobilePhoneTittle = textView;
        this.phoneApplicationContainer = constraintLayout2;
        this.tvMessageCount = textView2;
        this.unreadMeassageContainer = frameLayout;
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
                i = R.id.tv_message_count;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.unread_meassage_container;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null) {
                        return new PhoneApplicationBinding(constraintLayout, appCompatImageView, textView, constraintLayout, textView2, frameLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
