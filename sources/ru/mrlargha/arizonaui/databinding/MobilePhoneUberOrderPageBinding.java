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
public final class MobilePhoneUberOrderPageBinding implements ViewBinding {
    public final ConstraintLayout mpUberActionButton;
    public final TextView mpUberActionButtonText;
    public final ConstraintLayout mpUberDriverContainer;
    public final AppCompatImageView mpUberDriverImage;
    public final TextView mpUberDriverName;
    public final TextView mpUberDriverReviewCount;
    public final AppCompatImageView mpUberDriverReviewImage;
    public final ConstraintLayout mpUberHeader;
    public final AppCompatImageView mpUberHeaderBack;
    public final TextView mpUberHeaderTitle;
    public final ConstraintLayout mpUberOrderPage;
    public final TextView mpUberOrderTitle;
    public final ConstraintLayout mpUberPriority;
    public final TextView mpUberPriorityDescription;
    public final AppCompatImageView mpUberPriorityImage;
    public final TextView mpUberPriorityTitle;
    private final ConstraintLayout rootView;

    private MobilePhoneUberOrderPageBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, ConstraintLayout constraintLayout3, AppCompatImageView appCompatImageView, TextView textView2, TextView textView3, AppCompatImageView appCompatImageView2, ConstraintLayout constraintLayout4, AppCompatImageView appCompatImageView3, TextView textView4, ConstraintLayout constraintLayout5, TextView textView5, ConstraintLayout constraintLayout6, TextView textView6, AppCompatImageView appCompatImageView4, TextView textView7) {
        this.rootView = constraintLayout;
        this.mpUberActionButton = constraintLayout2;
        this.mpUberActionButtonText = textView;
        this.mpUberDriverContainer = constraintLayout3;
        this.mpUberDriverImage = appCompatImageView;
        this.mpUberDriverName = textView2;
        this.mpUberDriverReviewCount = textView3;
        this.mpUberDriverReviewImage = appCompatImageView2;
        this.mpUberHeader = constraintLayout4;
        this.mpUberHeaderBack = appCompatImageView3;
        this.mpUberHeaderTitle = textView4;
        this.mpUberOrderPage = constraintLayout5;
        this.mpUberOrderTitle = textView5;
        this.mpUberPriority = constraintLayout6;
        this.mpUberPriorityDescription = textView6;
        this.mpUberPriorityImage = appCompatImageView4;
        this.mpUberPriorityTitle = textView7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MobilePhoneUberOrderPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobilePhoneUberOrderPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_phone_uber_order_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobilePhoneUberOrderPageBinding bind(View view) {
        int i = R.id.mp_uber_action_button;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.mp_uber_action_button_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.mp_uber_driver_container;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout2 != null) {
                    i = R.id.mp_uber_driver_image;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                    if (appCompatImageView != null) {
                        i = R.id.mp_uber_driver_name;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.mp_uber_driver_review_count;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.mp_uber_driver_review_image;
                                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                if (appCompatImageView2 != null) {
                                    i = R.id.mp_uber_header;
                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout3 != null) {
                                        i = R.id.mp_uber_header_back;
                                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                        if (appCompatImageView3 != null) {
                                            i = R.id.mp_uber_header_title;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView4 != null) {
                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) view;
                                                i = R.id.mp_uber_order_title;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    i = R.id.mp_uber_priority;
                                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout5 != null) {
                                                        i = R.id.mp_uber_priority_description;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView6 != null) {
                                                            i = R.id.mp_uber_priority_image;
                                                            AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                                            if (appCompatImageView4 != null) {
                                                                i = R.id.mp_uber_priority_title;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView7 != null) {
                                                                    return new MobilePhoneUberOrderPageBinding(constraintLayout4, constraintLayout, textView, constraintLayout2, appCompatImageView, textView2, textView3, appCompatImageView2, constraintLayout3, appCompatImageView3, textView4, constraintLayout4, textView5, constraintLayout5, textView6, appCompatImageView4, textView7);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
