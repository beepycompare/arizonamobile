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
public final class MobilePhoneArizonamobilCarInfoPageBinding implements ViewBinding {
    public final AppCompatImageView mpArizonamobilCarImage;
    public final ConstraintLayout mpArizonamobilCarInfo;
    public final ConstraintLayout mpArizonamobilCarInfoHeader;
    public final ConstraintLayout mpArizonamobilCarInfoPage;
    public final ConstraintLayout mpArizonamobilHeaderId;
    public final TextView mpArizonamobilHeaderTitle;
    public final ConstraintLayout mpArizonamobileCarInfoHeader;
    public final ConstraintLayout mpArizonamobileFuel;
    public final TextView mpArizonamobileFuelPercent;
    public final TextView mpArizonamobileFuelText;
    public final AppCompatImageView mpArizonamobileHeaderBack;
    public final TextView mpArizonamobileHeaderIdText;
    public final TextView mpArizonamobileHeaderTitle;
    public final ConstraintLayout mpArizonamobilePayRent;
    public final ConstraintLayout mpArizonamobilePrice;
    public final ConstraintLayout mpArizonamobilePriceBurger;
    public final ConstraintLayout mpArizonamobilePriceContainer;
    public final TextView mpArizonamobilePriceDescription;
    public final TextView mpArizonamobilePriceTitle;
    public final ConstraintLayout mpCarInfoContainer;
    public final ConstraintLayout mpFuelIndicator;
    private final ConstraintLayout rootView;

    private MobilePhoneArizonamobilCarInfoPageBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, TextView textView, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7, TextView textView2, TextView textView3, AppCompatImageView appCompatImageView2, TextView textView4, TextView textView5, ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10, ConstraintLayout constraintLayout11, TextView textView6, TextView textView7, ConstraintLayout constraintLayout12, ConstraintLayout constraintLayout13) {
        this.rootView = constraintLayout;
        this.mpArizonamobilCarImage = appCompatImageView;
        this.mpArizonamobilCarInfo = constraintLayout2;
        this.mpArizonamobilCarInfoHeader = constraintLayout3;
        this.mpArizonamobilCarInfoPage = constraintLayout4;
        this.mpArizonamobilHeaderId = constraintLayout5;
        this.mpArizonamobilHeaderTitle = textView;
        this.mpArizonamobileCarInfoHeader = constraintLayout6;
        this.mpArizonamobileFuel = constraintLayout7;
        this.mpArizonamobileFuelPercent = textView2;
        this.mpArizonamobileFuelText = textView3;
        this.mpArizonamobileHeaderBack = appCompatImageView2;
        this.mpArizonamobileHeaderIdText = textView4;
        this.mpArizonamobileHeaderTitle = textView5;
        this.mpArizonamobilePayRent = constraintLayout8;
        this.mpArizonamobilePrice = constraintLayout9;
        this.mpArizonamobilePriceBurger = constraintLayout10;
        this.mpArizonamobilePriceContainer = constraintLayout11;
        this.mpArizonamobilePriceDescription = textView6;
        this.mpArizonamobilePriceTitle = textView7;
        this.mpCarInfoContainer = constraintLayout12;
        this.mpFuelIndicator = constraintLayout13;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MobilePhoneArizonamobilCarInfoPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobilePhoneArizonamobilCarInfoPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_phone_arizonamobil_car_info_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobilePhoneArizonamobilCarInfoPageBinding bind(View view) {
        int i = R.id.mp_arizonamobil_car_image;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            i = R.id.mp_arizonamobil_car_info;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.mp_arizonamobil_car_info_header;
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
                                i = R.id.mp_arizonamobile_fuel;
                                ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout6 != null) {
                                    i = R.id.mp_arizonamobile_fuel_percent;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = R.id.mp_arizonamobile_fuel_text;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = R.id.mp_arizonamobile_header_back;
                                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                            if (appCompatImageView2 != null) {
                                                i = R.id.mp_arizonamobile_header_id_text;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    i = R.id.mp_arizonamobile_header_title;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView5 != null) {
                                                        i = R.id.mp_arizonamobile_pay_rent;
                                                        ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                        if (constraintLayout7 != null) {
                                                            i = R.id.mp_arizonamobile_price;
                                                            ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                            if (constraintLayout8 != null) {
                                                                i = R.id.mp_arizonamobile_price_burger;
                                                                ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                if (constraintLayout9 != null) {
                                                                    i = R.id.mp_arizonamobile_price_container;
                                                                    ConstraintLayout constraintLayout10 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (constraintLayout10 != null) {
                                                                        i = R.id.mp_arizonamobile_price_description;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView6 != null) {
                                                                            i = R.id.mp_arizonamobile_price_title;
                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView7 != null) {
                                                                                i = R.id.mp_car_info_container;
                                                                                ConstraintLayout constraintLayout11 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (constraintLayout11 != null) {
                                                                                    i = R.id.mp_fuel_indicator;
                                                                                    ConstraintLayout constraintLayout12 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                    if (constraintLayout12 != null) {
                                                                                        return new MobilePhoneArizonamobilCarInfoPageBinding(constraintLayout3, appCompatImageView, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, textView, constraintLayout5, constraintLayout6, textView2, textView3, appCompatImageView2, textView4, textView5, constraintLayout7, constraintLayout8, constraintLayout9, constraintLayout10, textView6, textView7, constraintLayout11, constraintLayout12);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
