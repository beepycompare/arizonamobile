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
public final class MobilePhoneArizonamobilCarRentedPageBinding implements ViewBinding {
    public final AppCompatImageView mpArizonamobilCarImage;
    public final ConstraintLayout mpArizonamobilCarInfo;
    public final ConstraintLayout mpArizonamobilCarRentedInfoHeader;
    public final ConstraintLayout mpArizonamobilCarRentedPage;
    public final ConstraintLayout mpArizonamobilHeaderId;
    public final TextView mpArizonamobilHeaderTitle;
    public final ConstraintLayout mpArizonamobileCarInfoHeader;
    public final TextView mpArizonamobileDateTill;
    public final AppCompatImageView mpArizonamobileHeaderBack;
    public final TextView mpArizonamobileHeaderIdText;
    public final TextView mpArizonamobileHeaderTitle;
    public final TextView mpArizonamobileTextTill;
    public final ConstraintLayout mpCarInfoContainer;
    private final ConstraintLayout rootView;

    private MobilePhoneArizonamobilCarRentedPageBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, TextView textView, ConstraintLayout constraintLayout6, TextView textView2, AppCompatImageView appCompatImageView2, TextView textView3, TextView textView4, TextView textView5, ConstraintLayout constraintLayout7) {
        this.rootView = constraintLayout;
        this.mpArizonamobilCarImage = appCompatImageView;
        this.mpArizonamobilCarInfo = constraintLayout2;
        this.mpArizonamobilCarRentedInfoHeader = constraintLayout3;
        this.mpArizonamobilCarRentedPage = constraintLayout4;
        this.mpArizonamobilHeaderId = constraintLayout5;
        this.mpArizonamobilHeaderTitle = textView;
        this.mpArizonamobileCarInfoHeader = constraintLayout6;
        this.mpArizonamobileDateTill = textView2;
        this.mpArizonamobileHeaderBack = appCompatImageView2;
        this.mpArizonamobileHeaderIdText = textView3;
        this.mpArizonamobileHeaderTitle = textView4;
        this.mpArizonamobileTextTill = textView5;
        this.mpCarInfoContainer = constraintLayout7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MobilePhoneArizonamobilCarRentedPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobilePhoneArizonamobilCarRentedPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_phone_arizonamobil_car_rented_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobilePhoneArizonamobilCarRentedPageBinding bind(View view) {
        int i = R.id.mp_arizonamobil_car_image;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            i = R.id.mp_arizonamobil_car_info;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.mp_arizonamobil_car_rented_info_header;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout2 != null) {
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) view;
                    i = R.id.mp_arizonamobil_header_id;
                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout4 != null) {
                        i = R.id.mp_arizonamobil_header_title;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.mp_arizonamobile_car_info_header;
                            ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout5 != null) {
                                i = R.id.mp_arizonamobile_date_till;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.mp_arizonamobile_header_back;
                                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                    if (appCompatImageView2 != null) {
                                        i = R.id.mp_arizonamobile_header_id_text;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = R.id.mp_arizonamobile_header_title;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView4 != null) {
                                                i = R.id.mp_arizonamobile_text_till;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    i = R.id.mp_car_info_container;
                                                    ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout6 != null) {
                                                        return new MobilePhoneArizonamobilCarRentedPageBinding(constraintLayout3, appCompatImageView, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, textView, constraintLayout5, textView2, appCompatImageView2, textView3, textView4, textView5, constraintLayout6);
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
