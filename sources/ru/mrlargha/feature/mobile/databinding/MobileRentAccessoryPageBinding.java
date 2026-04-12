package ru.mrlargha.feature.mobile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.mobile.R;
/* loaded from: classes6.dex */
public final class MobileRentAccessoryPageBinding implements ViewBinding {
    public final ImageView btnAdd;
    public final ImageView btnBack;
    public final MobileRentAccessoryAddBinding createAdd;
    public final MobileRentAccessoryFilterBinding filter;
    public final MobileRentAccessoryMainBinding main;
    public final MobileRentAccessoryNothingFoundBinding notData;
    public final FrameLayout rentAccessory;
    private final FrameLayout rootView;
    public final RecyclerView rvCategories;

    private MobileRentAccessoryPageBinding(FrameLayout frameLayout, ImageView imageView, ImageView imageView2, MobileRentAccessoryAddBinding mobileRentAccessoryAddBinding, MobileRentAccessoryFilterBinding mobileRentAccessoryFilterBinding, MobileRentAccessoryMainBinding mobileRentAccessoryMainBinding, MobileRentAccessoryNothingFoundBinding mobileRentAccessoryNothingFoundBinding, FrameLayout frameLayout2, RecyclerView recyclerView) {
        this.rootView = frameLayout;
        this.btnAdd = imageView;
        this.btnBack = imageView2;
        this.createAdd = mobileRentAccessoryAddBinding;
        this.filter = mobileRentAccessoryFilterBinding;
        this.main = mobileRentAccessoryMainBinding;
        this.notData = mobileRentAccessoryNothingFoundBinding;
        this.rentAccessory = frameLayout2;
        this.rvCategories = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MobileRentAccessoryPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobileRentAccessoryPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_rent_accessory_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobileRentAccessoryPageBinding bind(View view) {
        View findChildViewById;
        int i = R.id.btn_add;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.btn_back;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.create_add))) != null) {
                MobileRentAccessoryAddBinding bind = MobileRentAccessoryAddBinding.bind(findChildViewById);
                i = R.id.filter;
                View findChildViewById2 = ViewBindings.findChildViewById(view, i);
                if (findChildViewById2 != null) {
                    MobileRentAccessoryFilterBinding bind2 = MobileRentAccessoryFilterBinding.bind(findChildViewById2);
                    i = R.id.main;
                    View findChildViewById3 = ViewBindings.findChildViewById(view, i);
                    if (findChildViewById3 != null) {
                        MobileRentAccessoryMainBinding bind3 = MobileRentAccessoryMainBinding.bind(findChildViewById3);
                        i = R.id.not_data;
                        View findChildViewById4 = ViewBindings.findChildViewById(view, i);
                        if (findChildViewById4 != null) {
                            MobileRentAccessoryNothingFoundBinding bind4 = MobileRentAccessoryNothingFoundBinding.bind(findChildViewById4);
                            FrameLayout frameLayout = (FrameLayout) view;
                            i = R.id.rv_categories;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                            if (recyclerView != null) {
                                return new MobileRentAccessoryPageBinding(frameLayout, imageView, imageView2, bind, bind2, bind3, bind4, frameLayout, recyclerView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
