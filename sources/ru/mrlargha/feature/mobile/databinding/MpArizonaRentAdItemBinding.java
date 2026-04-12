package ru.mrlargha.feature.mobile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.mobile.R;
/* loaded from: classes6.dex */
public final class MpArizonaRentAdItemBinding implements ViewBinding {
    public final CustomCardView basementContainer;
    public final CustomCardView btnDeleteAd;
    public final CustomCardView btnRaiseList;
    public final CustomCardView btnRent;
    public final CustomCardView garageContainer;
    public final ImageView ivHome;
    public final CustomCardView myAdContainer;
    public final CustomCardView online;
    public final LinearLayout raiseListContainer;
    private final CustomCardView rootView;
    public final TextView tvAdNumber;
    public final TextView tvDesc;
    public final TextView tvHomeNumber;
    public final TextView tvMoney;
    public final TextView tvRealEstate;
    public final TextView tvTime;
    public final TextView tvUserName;
    public final TextView tvX;
    public final CustomCardView xContainer;

    private MpArizonaRentAdItemBinding(CustomCardView customCardView, CustomCardView customCardView2, CustomCardView customCardView3, CustomCardView customCardView4, CustomCardView customCardView5, CustomCardView customCardView6, ImageView imageView, CustomCardView customCardView7, CustomCardView customCardView8, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, CustomCardView customCardView9) {
        this.rootView = customCardView;
        this.basementContainer = customCardView2;
        this.btnDeleteAd = customCardView3;
        this.btnRaiseList = customCardView4;
        this.btnRent = customCardView5;
        this.garageContainer = customCardView6;
        this.ivHome = imageView;
        this.myAdContainer = customCardView7;
        this.online = customCardView8;
        this.raiseListContainer = linearLayout;
        this.tvAdNumber = textView;
        this.tvDesc = textView2;
        this.tvHomeNumber = textView3;
        this.tvMoney = textView4;
        this.tvRealEstate = textView5;
        this.tvTime = textView6;
        this.tvUserName = textView7;
        this.tvX = textView8;
        this.xContainer = customCardView9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static MpArizonaRentAdItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MpArizonaRentAdItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mp_arizona_rent_ad_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MpArizonaRentAdItemBinding bind(View view) {
        int i = R.id.basement_container;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
        if (customCardView != null) {
            i = R.id.btn_delete_ad;
            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
            if (customCardView2 != null) {
                i = R.id.btn_raise_list;
                CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView3 != null) {
                    i = R.id.btn_rent;
                    CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                    if (customCardView4 != null) {
                        i = R.id.garage_container;
                        CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                        if (customCardView5 != null) {
                            i = R.id.iv_home;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView != null) {
                                i = R.id.my_ad_container;
                                CustomCardView customCardView6 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                if (customCardView6 != null) {
                                    i = R.id.online;
                                    CustomCardView customCardView7 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                    if (customCardView7 != null) {
                                        i = R.id.raise_list_container;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout != null) {
                                            i = R.id.tv_ad_number;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView != null) {
                                                i = R.id.tv_desc;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView2 != null) {
                                                    i = R.id.tv_home_number;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null) {
                                                        i = R.id.tv_money;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView4 != null) {
                                                            i = R.id.tv_real_estate;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView5 != null) {
                                                                i = R.id.tv_time;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView6 != null) {
                                                                    i = R.id.tv_user_name;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView7 != null) {
                                                                        i = R.id.tv_x;
                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView8 != null) {
                                                                            i = R.id.x_container;
                                                                            CustomCardView customCardView8 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                            if (customCardView8 != null) {
                                                                                return new MpArizonaRentAdItemBinding((CustomCardView) view, customCardView, customCardView2, customCardView3, customCardView4, customCardView5, imageView, customCardView6, customCardView7, linearLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, customCardView8);
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
