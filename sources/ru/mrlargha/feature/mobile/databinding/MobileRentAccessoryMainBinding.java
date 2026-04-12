package ru.mrlargha.feature.mobile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.mobile.R;
/* loaded from: classes6.dex */
public final class MobileRentAccessoryMainBinding implements ViewBinding {
    public final CustomCardView btnAll;
    public final CustomCardView btnFilter;
    public final CustomCardView btnMy;
    public final CustomCardView btnUpdate;
    public final CustomCardView btnWarehouse;
    public final ImageView ivFilter;
    public final LinearLayout mainContainer;
    public final MobileRentAccessoryNothingFoundBinding notFoundContainer;
    public final CustomCardView notification;
    public final ProgressBar progressBar;
    private final FrameLayout rootView;
    public final RecyclerView rvItems;
    public final TextView tvAll;
    public final TextView tvMy;
    public final TextView tvNotificationCount;
    public final TextView tvWarehouse;

    private MobileRentAccessoryMainBinding(FrameLayout frameLayout, CustomCardView customCardView, CustomCardView customCardView2, CustomCardView customCardView3, CustomCardView customCardView4, CustomCardView customCardView5, ImageView imageView, LinearLayout linearLayout, MobileRentAccessoryNothingFoundBinding mobileRentAccessoryNothingFoundBinding, CustomCardView customCardView6, ProgressBar progressBar, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = frameLayout;
        this.btnAll = customCardView;
        this.btnFilter = customCardView2;
        this.btnMy = customCardView3;
        this.btnUpdate = customCardView4;
        this.btnWarehouse = customCardView5;
        this.ivFilter = imageView;
        this.mainContainer = linearLayout;
        this.notFoundContainer = mobileRentAccessoryNothingFoundBinding;
        this.notification = customCardView6;
        this.progressBar = progressBar;
        this.rvItems = recyclerView;
        this.tvAll = textView;
        this.tvMy = textView2;
        this.tvNotificationCount = textView3;
        this.tvWarehouse = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MobileRentAccessoryMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobileRentAccessoryMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_rent_accessory_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobileRentAccessoryMainBinding bind(View view) {
        View findChildViewById;
        int i = R.id.btn_all;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
        if (customCardView != null) {
            i = R.id.btn_filter;
            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
            if (customCardView2 != null) {
                i = R.id.btn_my;
                CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView3 != null) {
                    i = R.id.btn_update;
                    CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                    if (customCardView4 != null) {
                        i = R.id.btn_warehouse;
                        CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                        if (customCardView5 != null) {
                            i = R.id.iv_filter;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView != null) {
                                i = R.id.main_container;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.not_found_container))) != null) {
                                    MobileRentAccessoryNothingFoundBinding bind = MobileRentAccessoryNothingFoundBinding.bind(findChildViewById);
                                    i = R.id.notification;
                                    CustomCardView customCardView6 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                    if (customCardView6 != null) {
                                        i = R.id.progress_bar;
                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                        if (progressBar != null) {
                                            i = R.id.rv_items;
                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                            if (recyclerView != null) {
                                                i = R.id.tv_all;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView != null) {
                                                    i = R.id.tv_my;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView2 != null) {
                                                        i = R.id.tv_notification_count;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView3 != null) {
                                                            i = R.id.tv_warehouse;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null) {
                                                                return new MobileRentAccessoryMainBinding((FrameLayout) view, customCardView, customCardView2, customCardView3, customCardView4, customCardView5, imageView, linearLayout, bind, customCardView6, progressBar, recyclerView, textView, textView2, textView3, textView4);
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
