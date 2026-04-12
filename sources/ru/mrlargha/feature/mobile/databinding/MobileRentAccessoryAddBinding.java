package ru.mrlargha.feature.mobile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.commonui.utils.ui.CustomEditText;
import ru.mrlargha.feature.mobile.R;
/* loaded from: classes6.dex */
public final class MobileRentAccessoryAddBinding implements ViewBinding {
    public final CustomCardView btnCreateAdd;
    public final CustomCardView btnItem;
    public final CustomCardView btnSet;
    public final CustomCardView categoryContainer;
    public final CustomCardView descContainer;
    public final CustomEditText etDesc;
    public final EditText etKCost;
    public final EditText etKkCost;
    public final MobileRentAccessoryElementItemBinding fifthContainer;
    public final MobileRentAccessoryElementItemBinding firstContainer;
    public final MobileRentAccessoryElementItemBinding fourthContainer;
    public final ImageView ivCategoryArrow;
    public final ImageView ivCategoryIcon;
    private final ScrollView rootView;
    public final MobileRentAccessoryElementItemBinding secondContainer;
    public final LinearLayout secondPartContainer;
    public final MobileRentAccessoryElementItemBinding sixthContainer;
    public final MobileRentAccessoryElementItemBinding thirdContainer;
    public final TextView tvCategoryName;
    public final TextView tvChooseItem;
    public final TextView tvDescOutOf;
    public final TextView tvItem;
    public final TextView tvItemOutOf;
    public final TextView tvSet;

    private MobileRentAccessoryAddBinding(ScrollView scrollView, CustomCardView customCardView, CustomCardView customCardView2, CustomCardView customCardView3, CustomCardView customCardView4, CustomCardView customCardView5, CustomEditText customEditText, EditText editText, EditText editText2, MobileRentAccessoryElementItemBinding mobileRentAccessoryElementItemBinding, MobileRentAccessoryElementItemBinding mobileRentAccessoryElementItemBinding2, MobileRentAccessoryElementItemBinding mobileRentAccessoryElementItemBinding3, ImageView imageView, ImageView imageView2, MobileRentAccessoryElementItemBinding mobileRentAccessoryElementItemBinding4, LinearLayout linearLayout, MobileRentAccessoryElementItemBinding mobileRentAccessoryElementItemBinding5, MobileRentAccessoryElementItemBinding mobileRentAccessoryElementItemBinding6, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = scrollView;
        this.btnCreateAdd = customCardView;
        this.btnItem = customCardView2;
        this.btnSet = customCardView3;
        this.categoryContainer = customCardView4;
        this.descContainer = customCardView5;
        this.etDesc = customEditText;
        this.etKCost = editText;
        this.etKkCost = editText2;
        this.fifthContainer = mobileRentAccessoryElementItemBinding;
        this.firstContainer = mobileRentAccessoryElementItemBinding2;
        this.fourthContainer = mobileRentAccessoryElementItemBinding3;
        this.ivCategoryArrow = imageView;
        this.ivCategoryIcon = imageView2;
        this.secondContainer = mobileRentAccessoryElementItemBinding4;
        this.secondPartContainer = linearLayout;
        this.sixthContainer = mobileRentAccessoryElementItemBinding5;
        this.thirdContainer = mobileRentAccessoryElementItemBinding6;
        this.tvCategoryName = textView;
        this.tvChooseItem = textView2;
        this.tvDescOutOf = textView3;
        this.tvItem = textView4;
        this.tvItemOutOf = textView5;
        this.tvSet = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static MobileRentAccessoryAddBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobileRentAccessoryAddBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_rent_accessory_add, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobileRentAccessoryAddBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        int i = R.id.btn_create_add;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
        if (customCardView != null) {
            i = R.id.btn_item;
            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
            if (customCardView2 != null) {
                i = R.id.btn_set;
                CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView3 != null) {
                    i = R.id.category_container;
                    CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                    if (customCardView4 != null) {
                        i = R.id.desc_container;
                        CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                        if (customCardView5 != null) {
                            i = R.id.et_desc;
                            CustomEditText customEditText = (CustomEditText) ViewBindings.findChildViewById(view, i);
                            if (customEditText != null) {
                                i = R.id.et_k_cost;
                                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                if (editText != null) {
                                    i = R.id.et_kk_cost;
                                    EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                                    if (editText2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.fifth_container))) != null) {
                                        MobileRentAccessoryElementItemBinding bind = MobileRentAccessoryElementItemBinding.bind(findChildViewById);
                                        i = R.id.first_container;
                                        View findChildViewById4 = ViewBindings.findChildViewById(view, i);
                                        if (findChildViewById4 != null) {
                                            MobileRentAccessoryElementItemBinding bind2 = MobileRentAccessoryElementItemBinding.bind(findChildViewById4);
                                            i = R.id.fourth_container;
                                            View findChildViewById5 = ViewBindings.findChildViewById(view, i);
                                            if (findChildViewById5 != null) {
                                                MobileRentAccessoryElementItemBinding bind3 = MobileRentAccessoryElementItemBinding.bind(findChildViewById5);
                                                i = R.id.iv_category_arrow;
                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView != null) {
                                                    i = R.id.iv_category_icon;
                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView2 != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.second_container))) != null) {
                                                        MobileRentAccessoryElementItemBinding bind4 = MobileRentAccessoryElementItemBinding.bind(findChildViewById2);
                                                        i = R.id.second_part_container;
                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout != null && (findChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.sixth_container))) != null) {
                                                            MobileRentAccessoryElementItemBinding bind5 = MobileRentAccessoryElementItemBinding.bind(findChildViewById3);
                                                            i = R.id.third_container;
                                                            View findChildViewById6 = ViewBindings.findChildViewById(view, i);
                                                            if (findChildViewById6 != null) {
                                                                MobileRentAccessoryElementItemBinding bind6 = MobileRentAccessoryElementItemBinding.bind(findChildViewById6);
                                                                i = R.id.tv_category_name;
                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView != null) {
                                                                    i = R.id.tv_choose_item;
                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView2 != null) {
                                                                        i = R.id.tv_desc_out_of;
                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView3 != null) {
                                                                            i = R.id.tv_item;
                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView4 != null) {
                                                                                i = R.id.tv_item_out_of;
                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView5 != null) {
                                                                                    i = R.id.tv_set;
                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView6 != null) {
                                                                                        return new MobileRentAccessoryAddBinding((ScrollView) view, customCardView, customCardView2, customCardView3, customCardView4, customCardView5, customEditText, editText, editText2, bind, bind2, bind3, imageView, imageView2, bind4, linearLayout, bind5, bind6, textView, textView2, textView3, textView4, textView5, textView6);
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
