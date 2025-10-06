package ru.mrlargha.feature.arizona.cases.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.arizona.cases.R;
/* loaded from: classes6.dex */
public final class CasesMainPageBinding implements ViewBinding {
    public final LinearLayout availableUntilConateiner;
    public final LinearLayout btnOpen;
    public final CardView discountContainer;
    public final View guaranteedBlock;
    public final ImageView ivCase;
    public final ImageView ivCaseLogo;
    public final ImageView ivMoneyIc;
    public final LinearLayout mainPageContainer;
    public final CasesPrizesPageBinding prizePage;
    private final FrameLayout rootView;
    public final RecyclerView rvGuaranteed;
    public final RecyclerView rvSameCases;
    public final TextView tvAvailableUntil;
    public final TextView tvCountLeft;
    public final TextView tvDiscount;
    public final TextView tvOneX;
    public final TextView tvOpenCase;
    public final TextView tvTenX;

    private CasesMainPageBinding(FrameLayout frameLayout, LinearLayout linearLayout, LinearLayout linearLayout2, CardView cardView, View view, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout3, CasesPrizesPageBinding casesPrizesPageBinding, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = frameLayout;
        this.availableUntilConateiner = linearLayout;
        this.btnOpen = linearLayout2;
        this.discountContainer = cardView;
        this.guaranteedBlock = view;
        this.ivCase = imageView;
        this.ivCaseLogo = imageView2;
        this.ivMoneyIc = imageView3;
        this.mainPageContainer = linearLayout3;
        this.prizePage = casesPrizesPageBinding;
        this.rvGuaranteed = recyclerView;
        this.rvSameCases = recyclerView2;
        this.tvAvailableUntil = textView;
        this.tvCountLeft = textView2;
        this.tvDiscount = textView3;
        this.tvOneX = textView4;
        this.tvOpenCase = textView5;
        this.tvTenX = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static CasesMainPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CasesMainPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.cases_main_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CasesMainPageBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        int i = R.id.available_until_conateiner;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.btn_open;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = R.id.discount_container;
                CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
                if (cardView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.guaranteed_block))) != null) {
                    i = R.id.iv_case;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.iv_case_logo;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.iv_money_ic;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView3 != null) {
                                i = R.id.main_page_container;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout3 != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.prize_page))) != null) {
                                    CasesPrizesPageBinding bind = CasesPrizesPageBinding.bind(findChildViewById2);
                                    i = R.id.rv_guaranteed;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                    if (recyclerView != null) {
                                        i = R.id.rv_same_cases;
                                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                        if (recyclerView2 != null) {
                                            i = R.id.tv_available_until;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView != null) {
                                                i = R.id.tv_count_left;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView2 != null) {
                                                    i = R.id.tv_discount;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null) {
                                                        i = R.id.tv_one_x;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView4 != null) {
                                                            i = R.id.tv_open_case;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView5 != null) {
                                                                i = R.id.tv_ten_x;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView6 != null) {
                                                                    return new CasesMainPageBinding((FrameLayout) view, linearLayout, linearLayout2, cardView, findChildViewById, imageView, imageView2, imageView3, linearLayout3, bind, recyclerView, recyclerView2, textView, textView2, textView3, textView4, textView5, textView6);
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
