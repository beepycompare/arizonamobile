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
public final class MobilePhoneUberChoseTaxiPageBinding implements ViewBinding {
    public final ConstraintLayout mpUberActionButton;
    public final TextView mpUberActionButtonText;
    public final ConstraintLayout mpUberChosePriority;
    public final RecyclerView mpUberChosePriorityList;
    public final TextView mpUberChosePriorityText;
    public final ConstraintLayout mpUberChoseTaxiPage;
    public final TextView mpUberFinalLocation;
    public final ConstraintLayout mpUberFinalLocationContainer;
    public final ConstraintLayout mpUberHeader;
    public final AppCompatImageView mpUberHeaderBack;
    public final TextView mpUberHeaderTitle;
    public final ConstraintLayout mpUberLocationContainer;
    public final TextView mpUberMyLocation;
    public final ConstraintLayout mpUberMyLocationContainer;
    private final ConstraintLayout rootView;

    private MobilePhoneUberChoseTaxiPageBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, ConstraintLayout constraintLayout3, RecyclerView recyclerView, TextView textView2, ConstraintLayout constraintLayout4, TextView textView3, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, AppCompatImageView appCompatImageView, TextView textView4, ConstraintLayout constraintLayout7, TextView textView5, ConstraintLayout constraintLayout8) {
        this.rootView = constraintLayout;
        this.mpUberActionButton = constraintLayout2;
        this.mpUberActionButtonText = textView;
        this.mpUberChosePriority = constraintLayout3;
        this.mpUberChosePriorityList = recyclerView;
        this.mpUberChosePriorityText = textView2;
        this.mpUberChoseTaxiPage = constraintLayout4;
        this.mpUberFinalLocation = textView3;
        this.mpUberFinalLocationContainer = constraintLayout5;
        this.mpUberHeader = constraintLayout6;
        this.mpUberHeaderBack = appCompatImageView;
        this.mpUberHeaderTitle = textView4;
        this.mpUberLocationContainer = constraintLayout7;
        this.mpUberMyLocation = textView5;
        this.mpUberMyLocationContainer = constraintLayout8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MobilePhoneUberChoseTaxiPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobilePhoneUberChoseTaxiPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_phone_uber_chose_taxi_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobilePhoneUberChoseTaxiPageBinding bind(View view) {
        int i = R.id.mp_uber_action_button;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.mp_uber_action_button_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.mp_uber_chose_priority;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout2 != null) {
                    i = R.id.mp_uber_chose_priority_list;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                    if (recyclerView != null) {
                        i = R.id.mp_uber_chose_priority_text;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            ConstraintLayout constraintLayout3 = (ConstraintLayout) view;
                            i = R.id.mp_uber_final_location;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.mp_uber_final_location_container;
                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout4 != null) {
                                    i = R.id.mp_uber_header;
                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout5 != null) {
                                        i = R.id.mp_uber_header_back;
                                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                        if (appCompatImageView != null) {
                                            i = R.id.mp_uber_header_title;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView4 != null) {
                                                i = R.id.mp_uber_location_container;
                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                if (constraintLayout6 != null) {
                                                    i = R.id.mp_uber_my_location;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView5 != null) {
                                                        i = R.id.mp_uber_my_location_container;
                                                        ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                        if (constraintLayout7 != null) {
                                                            return new MobilePhoneUberChoseTaxiPageBinding(constraintLayout3, constraintLayout, textView, constraintLayout2, recyclerView, textView2, constraintLayout3, textView3, constraintLayout4, constraintLayout5, appCompatImageView, textView4, constraintLayout6, textView5, constraintLayout7);
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
