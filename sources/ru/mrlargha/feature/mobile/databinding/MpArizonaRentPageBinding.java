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
public final class MpArizonaRentPageBinding implements ViewBinding {
    public final LinearLayout adContainer;
    public final FrameLayout arizonaRentPage;
    public final CustomCardView btnCreateAd;
    public final CustomCardView btnFilter;
    public final CustomCardView btnUpdate;
    public final MpArizonaRentFilterBinding filterContainer;
    public final View foreground;
    public final ImageView ivFilter;
    public final FrameLayout nothingNotContainer;
    public final ProgressBar progressBar;
    private final FrameLayout rootView;
    public final RecyclerView rvAd;
    public final LinearLayout toolbar;
    public final CustomCardView toolbarAll;
    public final CustomCardView toolbarMy;
    public final MpArizonaRentTopBarBinding topBar;
    public final TextView tvAll;
    public final TextView tvMy;
    public final TextView tvNotContentDesc;

    private MpArizonaRentPageBinding(FrameLayout frameLayout, LinearLayout linearLayout, FrameLayout frameLayout2, CustomCardView customCardView, CustomCardView customCardView2, CustomCardView customCardView3, MpArizonaRentFilterBinding mpArizonaRentFilterBinding, View view, ImageView imageView, FrameLayout frameLayout3, ProgressBar progressBar, RecyclerView recyclerView, LinearLayout linearLayout2, CustomCardView customCardView4, CustomCardView customCardView5, MpArizonaRentTopBarBinding mpArizonaRentTopBarBinding, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = frameLayout;
        this.adContainer = linearLayout;
        this.arizonaRentPage = frameLayout2;
        this.btnCreateAd = customCardView;
        this.btnFilter = customCardView2;
        this.btnUpdate = customCardView3;
        this.filterContainer = mpArizonaRentFilterBinding;
        this.foreground = view;
        this.ivFilter = imageView;
        this.nothingNotContainer = frameLayout3;
        this.progressBar = progressBar;
        this.rvAd = recyclerView;
        this.toolbar = linearLayout2;
        this.toolbarAll = customCardView4;
        this.toolbarMy = customCardView5;
        this.topBar = mpArizonaRentTopBarBinding;
        this.tvAll = textView;
        this.tvMy = textView2;
        this.tvNotContentDesc = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MpArizonaRentPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MpArizonaRentPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mp_arizona_rent_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MpArizonaRentPageBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        int i = R.id.ad_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            i = R.id.btn_create_ad;
            CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
            if (customCardView != null) {
                i = R.id.btn_filter;
                CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView2 != null) {
                    i = R.id.btn_update;
                    CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                    if (customCardView3 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.filter_container))) != null) {
                        MpArizonaRentFilterBinding bind = MpArizonaRentFilterBinding.bind(findChildViewById);
                        i = R.id.foreground;
                        View findChildViewById3 = ViewBindings.findChildViewById(view, i);
                        if (findChildViewById3 != null) {
                            i = R.id.iv_filter;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView != null) {
                                i = R.id.nothing_not_container;
                                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                if (frameLayout2 != null) {
                                    i = R.id.progress_bar;
                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                    if (progressBar != null) {
                                        i = R.id.rv_ad;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                        if (recyclerView != null) {
                                            i = R.id.toolbar;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout2 != null) {
                                                i = R.id.toolbar_all;
                                                CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                if (customCardView4 != null) {
                                                    i = R.id.toolbar_my;
                                                    CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                    if (customCardView5 != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.top_bar))) != null) {
                                                        MpArizonaRentTopBarBinding bind2 = MpArizonaRentTopBarBinding.bind(findChildViewById2);
                                                        i = R.id.tv_all;
                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView != null) {
                                                            i = R.id.tv_my;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView2 != null) {
                                                                i = R.id.tv_not_content_desc;
                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView3 != null) {
                                                                    return new MpArizonaRentPageBinding(frameLayout, linearLayout, frameLayout, customCardView, customCardView2, customCardView3, bind, findChildViewById3, imageView, frameLayout2, progressBar, recyclerView, linearLayout2, customCardView4, customCardView5, bind2, textView, textView2, textView3);
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
