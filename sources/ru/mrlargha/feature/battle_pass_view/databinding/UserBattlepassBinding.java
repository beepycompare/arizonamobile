package ru.mrlargha.feature.battle_pass_view.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.battle_pass_view.R;
/* loaded from: classes6.dex */
public final class UserBattlepassBinding implements ViewBinding {
    public final CustomCardView btnClose;
    public final CustomCardView contentCard;
    public final CustomCardView headerGradient;
    public final AppCompatImageView ivMainImage;
    public final LinearLayout linearLayout;
    public final FrameLayout parentLayout;
    private final FrameLayout rootView;
    public final RecyclerView rvRewardsGrid;
    public final RecyclerView rvRewardsLinear;
    public final CustomCardView topbarBackground;
    public final AppCompatTextView tvTitleText;

    private UserBattlepassBinding(FrameLayout frameLayout, CustomCardView customCardView, CustomCardView customCardView2, CustomCardView customCardView3, AppCompatImageView appCompatImageView, LinearLayout linearLayout, FrameLayout frameLayout2, RecyclerView recyclerView, RecyclerView recyclerView2, CustomCardView customCardView4, AppCompatTextView appCompatTextView) {
        this.rootView = frameLayout;
        this.btnClose = customCardView;
        this.contentCard = customCardView2;
        this.headerGradient = customCardView3;
        this.ivMainImage = appCompatImageView;
        this.linearLayout = linearLayout;
        this.parentLayout = frameLayout2;
        this.rvRewardsGrid = recyclerView;
        this.rvRewardsLinear = recyclerView2;
        this.topbarBackground = customCardView4;
        this.tvTitleText = appCompatTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static UserBattlepassBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static UserBattlepassBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.user_battlepass, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static UserBattlepassBinding bind(View view) {
        int i = R.id.btnClose;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
        if (customCardView != null) {
            i = R.id.contentCard;
            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
            if (customCardView2 != null) {
                i = R.id.headerGradient;
                CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView3 != null) {
                    i = R.id.ivMainImage;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                    if (appCompatImageView != null) {
                        i = R.id.linearLayout;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            FrameLayout frameLayout = (FrameLayout) view;
                            i = R.id.rvRewardsGrid;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                            if (recyclerView != null) {
                                i = R.id.rvRewardsLinear;
                                RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                if (recyclerView2 != null) {
                                    i = R.id.topbarBackground;
                                    CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                    if (customCardView4 != null) {
                                        i = R.id.tvTitleText;
                                        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                                        if (appCompatTextView != null) {
                                            return new UserBattlepassBinding(frameLayout, customCardView, customCardView2, customCardView3, appCompatImageView, linearLayout, frameLayout, recyclerView, recyclerView2, customCardView4, appCompatTextView);
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
