package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class DonateScreenBinding implements ViewBinding {
    public final LinearLayout contentContainer;
    public final ProgressBar contentProgressBar;
    public final FrameLayout donate;
    public final LinearLayout errorPlaceholder;
    public final LinearLayout errorPlaceholderItems;
    public final DonateMainPageBinding mainPage;
    public final DonateOrdinaryPageBinding ordinaryPage;
    public final ProgressBar pageProgressBar;
    public final FrameLayout pagesContainer;
    public final DonatePayPassBinding payPassPage;
    public final DonatePurchasePageBinding purchasePage;
    public final DonateReplenishmentDialogBinding replenishmentDialogPage;
    private final FrameLayout rootView;
    public final RecyclerView rvCategories;
    public final DonateTopBarBinding topBar;

    private DonateScreenBinding(FrameLayout rootView, LinearLayout contentContainer, ProgressBar contentProgressBar, FrameLayout donate, LinearLayout errorPlaceholder, LinearLayout errorPlaceholderItems, DonateMainPageBinding mainPage, DonateOrdinaryPageBinding ordinaryPage, ProgressBar pageProgressBar, FrameLayout pagesContainer, DonatePayPassBinding payPassPage, DonatePurchasePageBinding purchasePage, DonateReplenishmentDialogBinding replenishmentDialogPage, RecyclerView rvCategories, DonateTopBarBinding topBar) {
        this.rootView = rootView;
        this.contentContainer = contentContainer;
        this.contentProgressBar = contentProgressBar;
        this.donate = donate;
        this.errorPlaceholder = errorPlaceholder;
        this.errorPlaceholderItems = errorPlaceholderItems;
        this.mainPage = mainPage;
        this.ordinaryPage = ordinaryPage;
        this.pageProgressBar = pageProgressBar;
        this.pagesContainer = pagesContainer;
        this.payPassPage = payPassPage;
        this.purchasePage = purchasePage;
        this.replenishmentDialogPage = replenishmentDialogPage;
        this.rvCategories = rvCategories;
        this.topBar = topBar;
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
        View findChildViewById2;
        View findChildViewById3;
        int i = R.id.content_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.content_progress_bar;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
            if (progressBar != null) {
                FrameLayout frameLayout = (FrameLayout) rootView;
                i = R.id.error_placeholder;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                if (linearLayout2 != null) {
                    i = R.id.error_placeholder_items;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout3 != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.main_page))) != null) {
                        DonateMainPageBinding bind = DonateMainPageBinding.bind(findChildViewById);
                        i = R.id.ordinary_page;
                        View findChildViewById4 = ViewBindings.findChildViewById(rootView, i);
                        if (findChildViewById4 != null) {
                            DonateOrdinaryPageBinding bind2 = DonateOrdinaryPageBinding.bind(findChildViewById4);
                            i = R.id.page_progress_bar;
                            ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                            if (progressBar2 != null) {
                                i = R.id.pages_container;
                                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                if (frameLayout2 != null && (findChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.pay_pass_page))) != null) {
                                    DonatePayPassBinding bind3 = DonatePayPassBinding.bind(findChildViewById2);
                                    i = R.id.purchase_page;
                                    View findChildViewById5 = ViewBindings.findChildViewById(rootView, i);
                                    if (findChildViewById5 != null) {
                                        DonatePurchasePageBinding bind4 = DonatePurchasePageBinding.bind(findChildViewById5);
                                        i = R.id.replenishment_dialog_page;
                                        View findChildViewById6 = ViewBindings.findChildViewById(rootView, i);
                                        if (findChildViewById6 != null) {
                                            DonateReplenishmentDialogBinding bind5 = DonateReplenishmentDialogBinding.bind(findChildViewById6);
                                            i = R.id.rv_categories;
                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                            if (recyclerView != null && (findChildViewById3 = ViewBindings.findChildViewById(rootView, (i = R.id.top_bar))) != null) {
                                                return new DonateScreenBinding(frameLayout, linearLayout, progressBar, frameLayout, linearLayout2, linearLayout3, bind, bind2, progressBar2, frameLayout2, bind3, bind4, bind5, recyclerView, DonateTopBarBinding.bind(findChildViewById3));
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
