package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class MobilePhoneUberCompletePageBinding implements ViewBinding {
    public final ConstraintLayout mpUberActionButton;
    public final TextView mpUberActionButtonText;
    public final TextView mpUberCompleteDescription;
    public final ConstraintLayout mpUberCompletePage;
    public final TextView mpUberCompleteTitle;
    public final ConstraintLayout mpUberDriverContainer;
    public final AppCompatImageView mpUberDriverImage;
    public final TextView mpUberDriverName;
    public final ConstraintLayout mpUberHeader;
    public final AppCompatImageView mpUberHeaderBack;
    public final TextView mpUberHeaderTitle;
    public final RecyclerView mpUberRates;
    private final ConstraintLayout rootView;

    private MobilePhoneUberCompletePageBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, ConstraintLayout constraintLayout3, TextView textView3, ConstraintLayout constraintLayout4, AppCompatImageView appCompatImageView, TextView textView4, ConstraintLayout constraintLayout5, AppCompatImageView appCompatImageView2, TextView textView5, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.mpUberActionButton = constraintLayout2;
        this.mpUberActionButtonText = textView;
        this.mpUberCompleteDescription = textView2;
        this.mpUberCompletePage = constraintLayout3;
        this.mpUberCompleteTitle = textView3;
        this.mpUberDriverContainer = constraintLayout4;
        this.mpUberDriverImage = appCompatImageView;
        this.mpUberDriverName = textView4;
        this.mpUberHeader = constraintLayout5;
        this.mpUberHeaderBack = appCompatImageView2;
        this.mpUberHeaderTitle = textView5;
        this.mpUberRates = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MobilePhoneUberCompletePageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobilePhoneUberCompletePageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_phone_uber_complete_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobilePhoneUberCompletePageBinding bind(View view) {
        int i = R.id.mp_uber_action_button;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.mp_uber_action_button_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.mp_uber_complete_description;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                    i = R.id.mp_uber_complete_title;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.mp_uber_driver_container;
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout3 != null) {
                            i = R.id.mp_uber_driver_image;
                            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                            if (appCompatImageView != null) {
                                i = R.id.mp_uber_driver_name;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = R.id.mp_uber_header;
                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout4 != null) {
                                        i = R.id.mp_uber_header_back;
                                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                        if (appCompatImageView2 != null) {
                                            i = R.id.mp_uber_header_title;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView5 != null) {
                                                i = R.id.mp_uber_rates;
                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                if (recyclerView != null) {
                                                    return new MobilePhoneUberCompletePageBinding(constraintLayout2, constraintLayout, textView, textView2, constraintLayout2, textView3, constraintLayout3, appCompatImageView, textView4, constraintLayout4, appCompatImageView2, textView5, recyclerView);
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
