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
public final class MobilePhoneUberPriorityItemBinding implements ViewBinding {
    public final AppCompatImageView mpUberPriority;
    public final TextView mpUberPriorityDescription;
    public final ConstraintLayout mpUberPriorityItem;
    public final TextView mpUberPriorityTitle;
    private final ConstraintLayout rootView;

    private MobilePhoneUberPriorityItemBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, TextView textView, ConstraintLayout constraintLayout2, TextView textView2) {
        this.rootView = constraintLayout;
        this.mpUberPriority = appCompatImageView;
        this.mpUberPriorityDescription = textView;
        this.mpUberPriorityItem = constraintLayout2;
        this.mpUberPriorityTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MobilePhoneUberPriorityItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobilePhoneUberPriorityItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_phone_uber_priority_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobilePhoneUberPriorityItemBinding bind(View view) {
        int i = R.id.mp_uber_priority;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            i = R.id.mp_uber_priority_description;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.mp_uber_priority_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new MobilePhoneUberPriorityItemBinding(constraintLayout, appCompatImageView, textView, constraintLayout, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
