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
public final class MobileRentAccessoryItemBinding implements ViewBinding {
    public final CustomCardView bizPercentContainer;
    public final CustomCardView btnDeleteThree;
    public final CustomCardView btnDeleteTwo;
    public final CustomCardView btnPass;
    public final CustomCardView btnRent;
    public final CustomCardView categoryContainer;
    public final MobileRentAccessoryElementItemBinding fifthItem;
    public final MobileRentAccessoryElementItemBinding firstItem;
    public final MobileRentAccessoryElementItemBinding fourthItem;
    public final ImageView ivCategory;
    public final CustomCardView locationContainer;
    public final CustomCardView onlineContainer;
    public final LinearLayout passContainer;
    private final CustomCardView rootView;
    public final MobileRentAccessoryElementItemBinding secondItem;
    public final MobileRentAccessoryElementItemBinding sixthItem;
    public final MobileRentAccessoryElementItemBinding thirdItem;
    public final CustomCardView timeContainer;
    public final TextView tvBizPercent;
    public final TextView tvCategory;
    public final TextView tvCost;
    public final TextView tvDesc;
    public final TextView tvLocation;
    public final TextView tvNickName;
    public final TextView tvNumber;
    public final TextView tvPass;
    public final TextView tvRent;
    public final TextView tvTime;

    private MobileRentAccessoryItemBinding(CustomCardView customCardView, CustomCardView customCardView2, CustomCardView customCardView3, CustomCardView customCardView4, CustomCardView customCardView5, CustomCardView customCardView6, CustomCardView customCardView7, MobileRentAccessoryElementItemBinding mobileRentAccessoryElementItemBinding, MobileRentAccessoryElementItemBinding mobileRentAccessoryElementItemBinding2, MobileRentAccessoryElementItemBinding mobileRentAccessoryElementItemBinding3, ImageView imageView, CustomCardView customCardView8, CustomCardView customCardView9, LinearLayout linearLayout, MobileRentAccessoryElementItemBinding mobileRentAccessoryElementItemBinding4, MobileRentAccessoryElementItemBinding mobileRentAccessoryElementItemBinding5, MobileRentAccessoryElementItemBinding mobileRentAccessoryElementItemBinding6, CustomCardView customCardView10, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10) {
        this.rootView = customCardView;
        this.bizPercentContainer = customCardView2;
        this.btnDeleteThree = customCardView3;
        this.btnDeleteTwo = customCardView4;
        this.btnPass = customCardView5;
        this.btnRent = customCardView6;
        this.categoryContainer = customCardView7;
        this.fifthItem = mobileRentAccessoryElementItemBinding;
        this.firstItem = mobileRentAccessoryElementItemBinding2;
        this.fourthItem = mobileRentAccessoryElementItemBinding3;
        this.ivCategory = imageView;
        this.locationContainer = customCardView8;
        this.onlineContainer = customCardView9;
        this.passContainer = linearLayout;
        this.secondItem = mobileRentAccessoryElementItemBinding4;
        this.sixthItem = mobileRentAccessoryElementItemBinding5;
        this.thirdItem = mobileRentAccessoryElementItemBinding6;
        this.timeContainer = customCardView10;
        this.tvBizPercent = textView;
        this.tvCategory = textView2;
        this.tvCost = textView3;
        this.tvDesc = textView4;
        this.tvLocation = textView5;
        this.tvNickName = textView6;
        this.tvNumber = textView7;
        this.tvPass = textView8;
        this.tvRent = textView9;
        this.tvTime = textView10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static MobileRentAccessoryItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobileRentAccessoryItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_rent_accessory_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobileRentAccessoryItemBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        int i = R.id.biz_percent_container;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
        if (customCardView != null) {
            i = R.id.btn_delete_three;
            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
            if (customCardView2 != null) {
                i = R.id.btn_delete_two;
                CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView3 != null) {
                    i = R.id.btn_pass;
                    CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                    if (customCardView4 != null) {
                        i = R.id.btn_rent;
                        CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                        if (customCardView5 != null) {
                            i = R.id.category_container;
                            CustomCardView customCardView6 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                            if (customCardView6 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.fifth_item))) != null) {
                                MobileRentAccessoryElementItemBinding bind = MobileRentAccessoryElementItemBinding.bind(findChildViewById);
                                i = R.id.first_item;
                                View findChildViewById3 = ViewBindings.findChildViewById(view, i);
                                if (findChildViewById3 != null) {
                                    MobileRentAccessoryElementItemBinding bind2 = MobileRentAccessoryElementItemBinding.bind(findChildViewById3);
                                    i = R.id.fourth_item;
                                    View findChildViewById4 = ViewBindings.findChildViewById(view, i);
                                    if (findChildViewById4 != null) {
                                        MobileRentAccessoryElementItemBinding bind3 = MobileRentAccessoryElementItemBinding.bind(findChildViewById4);
                                        i = R.id.iv_category;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView != null) {
                                            i = R.id.location_container;
                                            CustomCardView customCardView7 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                            if (customCardView7 != null) {
                                                i = R.id.online_container;
                                                CustomCardView customCardView8 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                if (customCardView8 != null) {
                                                    i = R.id.pass_container;
                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.second_item))) != null) {
                                                        MobileRentAccessoryElementItemBinding bind4 = MobileRentAccessoryElementItemBinding.bind(findChildViewById2);
                                                        i = R.id.sixth_item;
                                                        View findChildViewById5 = ViewBindings.findChildViewById(view, i);
                                                        if (findChildViewById5 != null) {
                                                            MobileRentAccessoryElementItemBinding bind5 = MobileRentAccessoryElementItemBinding.bind(findChildViewById5);
                                                            i = R.id.third_item;
                                                            View findChildViewById6 = ViewBindings.findChildViewById(view, i);
                                                            if (findChildViewById6 != null) {
                                                                MobileRentAccessoryElementItemBinding bind6 = MobileRentAccessoryElementItemBinding.bind(findChildViewById6);
                                                                i = R.id.time_container;
                                                                CustomCardView customCardView9 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                if (customCardView9 != null) {
                                                                    i = R.id.tv_biz_percent;
                                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView != null) {
                                                                        i = R.id.tv_category;
                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView2 != null) {
                                                                            i = R.id.tv_cost;
                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView3 != null) {
                                                                                i = R.id.tv_desc;
                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView4 != null) {
                                                                                    i = R.id.tv_location;
                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView5 != null) {
                                                                                        i = R.id.tv_nick_name;
                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView6 != null) {
                                                                                            i = R.id.tv_number;
                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView7 != null) {
                                                                                                i = R.id.tv_pass;
                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView8 != null) {
                                                                                                    i = R.id.tv_rent;
                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView9 != null) {
                                                                                                        i = R.id.tv_time;
                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView10 != null) {
                                                                                                            return new MobileRentAccessoryItemBinding((CustomCardView) view, customCardView, customCardView2, customCardView3, customCardView4, customCardView5, customCardView6, bind, bind2, bind3, imageView, customCardView7, customCardView8, linearLayout, bind4, bind5, bind6, customCardView9, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
