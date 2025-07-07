package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class DonateScreenBinding implements ViewBinding {
    public final LinearLayout battlePassContainer;
    public final FrameLayout donate;
    public final TextView ivAzCoin;
    public final ImageView ivAzIc;
    public final TextView ivMoneyCount;
    public final ImageView ivMoneyIc;
    public final DonateMainPageBinding mainPage;
    public final DonateOrdinaryPageBinding ordinaryPage;
    public final DonatePurchasePageBinding purchasePage;
    public final DonateReplenishmentDialogBinding replenishmentDialogPage;
    private final FrameLayout rootView;
    public final RecyclerView rvCategories;
    public final FrameLayout topBar;
    public final TextView tvTitle;

    private DonateScreenBinding(FrameLayout rootView, LinearLayout battlePassContainer, FrameLayout donate, TextView ivAzCoin, ImageView ivAzIc, TextView ivMoneyCount, ImageView ivMoneyIc, DonateMainPageBinding mainPage, DonateOrdinaryPageBinding ordinaryPage, DonatePurchasePageBinding purchasePage, DonateReplenishmentDialogBinding replenishmentDialogPage, RecyclerView rvCategories, FrameLayout topBar, TextView tvTitle) {
        this.rootView = rootView;
        this.battlePassContainer = battlePassContainer;
        this.donate = donate;
        this.ivAzCoin = ivAzCoin;
        this.ivAzIc = ivAzIc;
        this.ivMoneyCount = ivMoneyCount;
        this.ivMoneyIc = ivMoneyIc;
        this.mainPage = mainPage;
        this.ordinaryPage = ordinaryPage;
        this.purchasePage = purchasePage;
        this.replenishmentDialogPage = replenishmentDialogPage;
        this.rvCategories = rvCategories;
        this.topBar = topBar;
        this.tvTitle = tvTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DonateScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DonateScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.donate_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DonateScreenBinding bind(View rootView) {
        View findChildViewById;
        int i = R.id.battle_pass_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            FrameLayout frameLayout = (FrameLayout) rootView;
            i = R.id.iv_az_coin;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.iv_az_ic;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView != null) {
                    i = R.id.iv_money_count;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.iv_money_ic;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView2 != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.main_page))) != null) {
                            DonateMainPageBinding bind = DonateMainPageBinding.bind(findChildViewById);
                            i = R.id.ordinary_page;
                            View findChildViewById2 = ViewBindings.findChildViewById(rootView, i);
                            if (findChildViewById2 != null) {
                                DonateOrdinaryPageBinding bind2 = DonateOrdinaryPageBinding.bind(findChildViewById2);
                                i = R.id.purchase_page;
                                View findChildViewById3 = ViewBindings.findChildViewById(rootView, i);
                                if (findChildViewById3 != null) {
                                    DonatePurchasePageBinding bind3 = DonatePurchasePageBinding.bind(findChildViewById3);
                                    i = R.id.replenishment_dialog_page;
                                    View findChildViewById4 = ViewBindings.findChildViewById(rootView, i);
                                    if (findChildViewById4 != null) {
                                        DonateReplenishmentDialogBinding bind4 = DonateReplenishmentDialogBinding.bind(findChildViewById4);
                                        i = R.id.rv_categories;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                        if (recyclerView != null) {
                                            i = R.id.top_bar;
                                            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (frameLayout2 != null) {
                                                i = R.id.tv_title;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView3 != null) {
                                                    return new DonateScreenBinding(frameLayout, linearLayout, frameLayout, textView, imageView, textView2, imageView2, bind, bind2, bind3, bind4, recyclerView, frameLayout2, textView3);
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
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
