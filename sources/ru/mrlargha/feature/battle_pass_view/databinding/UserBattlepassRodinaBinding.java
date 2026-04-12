package ru.mrlargha.feature.battle_pass_view.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.battle_pass_view.R;
/* loaded from: classes6.dex */
public final class UserBattlepassRodinaBinding implements ViewBinding {
    public final AppCompatButton btnClose;
    public final Button btnGetInfo;
    public final AppCompatImageView ivMainImage;
    public final LinearLayout linearLayout;
    public final ConstraintLayout parentLayout;
    private final ConstraintLayout rootView;
    public final RecyclerView rvRewardsGrid;
    public final RecyclerView rvRewardsLinear;
    public final AppCompatTextView tvDescriptionText;
    public final AppCompatTextView tvTitleText;

    private UserBattlepassRodinaBinding(ConstraintLayout constraintLayout, AppCompatButton appCompatButton, Button button, AppCompatImageView appCompatImageView, LinearLayout linearLayout, ConstraintLayout constraintLayout2, RecyclerView recyclerView, RecyclerView recyclerView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.rootView = constraintLayout;
        this.btnClose = appCompatButton;
        this.btnGetInfo = button;
        this.ivMainImage = appCompatImageView;
        this.linearLayout = linearLayout;
        this.parentLayout = constraintLayout2;
        this.rvRewardsGrid = recyclerView;
        this.rvRewardsLinear = recyclerView2;
        this.tvDescriptionText = appCompatTextView;
        this.tvTitleText = appCompatTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static UserBattlepassRodinaBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static UserBattlepassRodinaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.user_battlepass_rodina, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static UserBattlepassRodinaBinding bind(View view) {
        int i = R.id.btnClose;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R.id.btnGetInfo;
            Button button = (Button) ViewBindings.findChildViewById(view, i);
            if (button != null) {
                i = R.id.ivMainImage;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                if (appCompatImageView != null) {
                    i = R.id.linearLayout;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i = R.id.rvRewardsGrid;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                        if (recyclerView != null) {
                            i = R.id.rvRewardsLinear;
                            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                            if (recyclerView2 != null) {
                                i = R.id.tvDescriptionText;
                                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                                if (appCompatTextView != null) {
                                    i = R.id.tvTitleText;
                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                                    if (appCompatTextView2 != null) {
                                        return new UserBattlepassRodinaBinding(constraintLayout, appCompatButton, button, appCompatImageView, linearLayout, constraintLayout, recyclerView, recyclerView2, appCompatTextView, appCompatTextView2);
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
