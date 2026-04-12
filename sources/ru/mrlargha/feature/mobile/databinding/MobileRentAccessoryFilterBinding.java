package ru.mrlargha.feature.mobile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.mobile.R;
/* loaded from: classes6.dex */
public final class MobileRentAccessoryFilterBinding implements ViewBinding {
    public final CustomCardView btnClearFilter;
    public final ImageView btnClose;
    public final CustomCardView btnCost;
    public final CustomCardView btnFind;
    public final CustomCardView btnRating;
    public final CustomCardView categoryContainer;
    public final EditText etBizId;
    public final EditText etSearchByNumber;
    public final CustomCardView filterContainer;
    public final ImageView ivCategoryArrow;
    public final ImageView ivCategoryIcon;
    public final ImageView ivCost;
    public final ImageView ivOnlySetFilter;
    public final ImageView ivOnlySharpingTenPlus;
    public final ImageView ivRating;
    public final CustomCardView onlySetFilter;
    public final CustomCardView onlySharpingTenPlus;
    private final FrameLayout rootView;
    public final TextView tvCategoryName;
    public final TextView tvCost;
    public final TextView tvRating;

    private MobileRentAccessoryFilterBinding(FrameLayout frameLayout, CustomCardView customCardView, ImageView imageView, CustomCardView customCardView2, CustomCardView customCardView3, CustomCardView customCardView4, CustomCardView customCardView5, EditText editText, EditText editText2, CustomCardView customCardView6, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, CustomCardView customCardView7, CustomCardView customCardView8, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = frameLayout;
        this.btnClearFilter = customCardView;
        this.btnClose = imageView;
        this.btnCost = customCardView2;
        this.btnFind = customCardView3;
        this.btnRating = customCardView4;
        this.categoryContainer = customCardView5;
        this.etBizId = editText;
        this.etSearchByNumber = editText2;
        this.filterContainer = customCardView6;
        this.ivCategoryArrow = imageView2;
        this.ivCategoryIcon = imageView3;
        this.ivCost = imageView4;
        this.ivOnlySetFilter = imageView5;
        this.ivOnlySharpingTenPlus = imageView6;
        this.ivRating = imageView7;
        this.onlySetFilter = customCardView7;
        this.onlySharpingTenPlus = customCardView8;
        this.tvCategoryName = textView;
        this.tvCost = textView2;
        this.tvRating = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MobileRentAccessoryFilterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobileRentAccessoryFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_rent_accessory_filter, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobileRentAccessoryFilterBinding bind(View view) {
        int i = R.id.btn_clear_filter;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
        if (customCardView != null) {
            i = R.id.btn_close;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.btn_cost;
                CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView2 != null) {
                    i = R.id.btn_find;
                    CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                    if (customCardView3 != null) {
                        i = R.id.btn_rating;
                        CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                        if (customCardView4 != null) {
                            i = R.id.category_container;
                            CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                            if (customCardView5 != null) {
                                i = R.id.et_biz_id;
                                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                if (editText != null) {
                                    i = R.id.et_search_by_number;
                                    EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                                    if (editText2 != null) {
                                        i = R.id.filter_container;
                                        CustomCardView customCardView6 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                        if (customCardView6 != null) {
                                            i = R.id.iv_category_arrow;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView2 != null) {
                                                i = R.id.iv_category_icon;
                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView3 != null) {
                                                    i = R.id.iv_cost;
                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView4 != null) {
                                                        i = R.id.iv_only_set_filter;
                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView5 != null) {
                                                            i = R.id.iv_only_sharping_ten_plus;
                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                            if (imageView6 != null) {
                                                                i = R.id.iv_rating;
                                                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                if (imageView7 != null) {
                                                                    i = R.id.only_set_filter;
                                                                    CustomCardView customCardView7 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                    if (customCardView7 != null) {
                                                                        i = R.id.only_sharping_ten_plus;
                                                                        CustomCardView customCardView8 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                        if (customCardView8 != null) {
                                                                            i = R.id.tv_category_name;
                                                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView != null) {
                                                                                i = R.id.tv_cost;
                                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView2 != null) {
                                                                                    i = R.id.tv_rating;
                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView3 != null) {
                                                                                        return new MobileRentAccessoryFilterBinding((FrameLayout) view, customCardView, imageView, customCardView2, customCardView3, customCardView4, customCardView5, editText, editText2, customCardView6, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, customCardView7, customCardView8, textView, textView2, textView3);
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
