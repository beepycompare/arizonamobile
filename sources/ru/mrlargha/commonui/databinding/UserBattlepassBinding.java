package ru.mrlargha.commonui.databinding;

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
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class UserBattlepassBinding implements ViewBinding {
    public final AppCompatButton btnClose;
    public final Button btnGetInfo;
    public final AppCompatImageView ivMainImage;
    public final LinearLayout linearLayout;
    public final ConstraintLayout parentLayout;
    private final ConstraintLayout rootView;
    public final RecyclerView rvRewards;
    public final AppCompatTextView tvDescriptionText;
    public final AppCompatTextView tvTitleText;

    private UserBattlepassBinding(ConstraintLayout rootView, AppCompatButton btnClose, Button btnGetInfo, AppCompatImageView ivMainImage, LinearLayout linearLayout, ConstraintLayout parentLayout, RecyclerView rvRewards, AppCompatTextView tvDescriptionText, AppCompatTextView tvTitleText) {
        this.rootView = rootView;
        this.btnClose = btnClose;
        this.btnGetInfo = btnGetInfo;
        this.ivMainImage = ivMainImage;
        this.linearLayout = linearLayout;
        this.parentLayout = parentLayout;
        this.rvRewards = rvRewards;
        this.tvDescriptionText = tvDescriptionText;
        this.tvTitleText = tvTitleText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static UserBattlepassBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static UserBattlepassBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.user_battlepass, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static UserBattlepassBinding bind(View rootView) {
        int i = R.id.btnClose;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(rootView, i);
        if (appCompatButton != null) {
            i = R.id.btnGetInfo;
            Button button = (Button) ViewBindings.findChildViewById(rootView, i);
            if (button != null) {
                i = R.id.ivMainImage;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                if (appCompatImageView != null) {
                    i = R.id.linearLayout;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                        i = R.id.rvRewards;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                        if (recyclerView != null) {
                            i = R.id.tvDescriptionText;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                            if (appCompatTextView != null) {
                                i = R.id.tvTitleText;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                if (appCompatTextView2 != null) {
                                    return new UserBattlepassBinding(constraintLayout, appCompatButton, button, appCompatImageView, linearLayout, constraintLayout, recyclerView, appCompatTextView, appCompatTextView2);
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
