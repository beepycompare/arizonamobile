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
public final class MobilePhoneArizonamobilMainPageBinding implements ViewBinding {
    public final ConstraintLayout mpArizonaMobileMyRent;
    public final ConstraintLayout mpArizonamobilAddBalance;
    public final TextView mpArizonamobilAddBalanceTitle;
    public final ConstraintLayout mpArizonamobilMainPage;
    public final ConstraintLayout mpArizonamobileBalance;
    public final TextView mpArizonamobileBalanceCount;
    public final TextView mpArizonamobileBalanceTitle;
    public final AppCompatImageView mpArizonamobileBanner;
    public final ConstraintLayout mpArizonamobileHeader;
    public final AppCompatImageView mpArizonamobileHeaderBack;
    public final TextView mpArizonamobileHeaderTitle;
    private final ConstraintLayout rootView;

    private MobilePhoneArizonamobilMainPageBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TextView textView, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, TextView textView2, TextView textView3, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout6, AppCompatImageView appCompatImageView2, TextView textView4) {
        this.rootView = constraintLayout;
        this.mpArizonaMobileMyRent = constraintLayout2;
        this.mpArizonamobilAddBalance = constraintLayout3;
        this.mpArizonamobilAddBalanceTitle = textView;
        this.mpArizonamobilMainPage = constraintLayout4;
        this.mpArizonamobileBalance = constraintLayout5;
        this.mpArizonamobileBalanceCount = textView2;
        this.mpArizonamobileBalanceTitle = textView3;
        this.mpArizonamobileBanner = appCompatImageView;
        this.mpArizonamobileHeader = constraintLayout6;
        this.mpArizonamobileHeaderBack = appCompatImageView2;
        this.mpArizonamobileHeaderTitle = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MobilePhoneArizonamobilMainPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobilePhoneArizonamobilMainPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_phone_arizonamobil_main_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobilePhoneArizonamobilMainPageBinding bind(View view) {
        int i = R.id.mp_arizona_mobile_my_rent;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.mp_arizonamobil_add_balance;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout2 != null) {
                i = R.id.mp_arizonamobil_add_balance_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) view;
                    i = R.id.mp_arizonamobile_balance;
                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout4 != null) {
                        i = R.id.mp_arizonamobile_balance_count;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.mp_arizonamobile_balance_title;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.mp_arizonamobile_banner;
                                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                if (appCompatImageView != null) {
                                    i = R.id.mp_arizonamobile_header;
                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout5 != null) {
                                        i = R.id.mp_arizonamobile_header_back;
                                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                        if (appCompatImageView2 != null) {
                                            i = R.id.mp_arizonamobile_header_title;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView4 != null) {
                                                return new MobilePhoneArizonamobilMainPageBinding(constraintLayout3, constraintLayout, constraintLayout2, textView, constraintLayout3, constraintLayout4, textView2, textView3, appCompatImageView, constraintLayout5, appCompatImageView2, textView4);
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
