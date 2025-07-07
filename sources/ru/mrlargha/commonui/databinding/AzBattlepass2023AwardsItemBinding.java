package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class AzBattlepass2023AwardsItemBinding implements ViewBinding {
    public final TextView awardItemPosition;
    public final TextView itemAwardExp;
    public final ProgressBar itemAwardProgressBar;
    public final ConstraintLayout itemAwardProgressBarContainer;
    public final ImageView itemCommonAwardAcceptIc;
    public final ConstraintLayout itemCommonAwardContainer;
    public final ConstraintLayout itemCommonAwardGetButton;
    public final ImageView itemCommonAwardGlow;
    public final ImageView itemCommonAwardIc;
    public final TextView itemCommonAwardName;
    public final ImageView itemUpgAwardAcceptIc;
    public final ConstraintLayout itemUpgAwardContainer;
    public final ConstraintLayout itemUpgAwardGetButton;
    public final ImageView itemUpgAwardGlow;
    public final ImageView itemUpgAwardIc;
    public final TextView itemUpgAwardName;
    public final ConstraintLayout newbieAwardItem;
    private final ConstraintLayout rootView;

    private AzBattlepass2023AwardsItemBinding(ConstraintLayout rootView, TextView awardItemPosition, TextView itemAwardExp, ProgressBar itemAwardProgressBar, ConstraintLayout itemAwardProgressBarContainer, ImageView itemCommonAwardAcceptIc, ConstraintLayout itemCommonAwardContainer, ConstraintLayout itemCommonAwardGetButton, ImageView itemCommonAwardGlow, ImageView itemCommonAwardIc, TextView itemCommonAwardName, ImageView itemUpgAwardAcceptIc, ConstraintLayout itemUpgAwardContainer, ConstraintLayout itemUpgAwardGetButton, ImageView itemUpgAwardGlow, ImageView itemUpgAwardIc, TextView itemUpgAwardName, ConstraintLayout newbieAwardItem) {
        this.rootView = rootView;
        this.awardItemPosition = awardItemPosition;
        this.itemAwardExp = itemAwardExp;
        this.itemAwardProgressBar = itemAwardProgressBar;
        this.itemAwardProgressBarContainer = itemAwardProgressBarContainer;
        this.itemCommonAwardAcceptIc = itemCommonAwardAcceptIc;
        this.itemCommonAwardContainer = itemCommonAwardContainer;
        this.itemCommonAwardGetButton = itemCommonAwardGetButton;
        this.itemCommonAwardGlow = itemCommonAwardGlow;
        this.itemCommonAwardIc = itemCommonAwardIc;
        this.itemCommonAwardName = itemCommonAwardName;
        this.itemUpgAwardAcceptIc = itemUpgAwardAcceptIc;
        this.itemUpgAwardContainer = itemUpgAwardContainer;
        this.itemUpgAwardGetButton = itemUpgAwardGetButton;
        this.itemUpgAwardGlow = itemUpgAwardGlow;
        this.itemUpgAwardIc = itemUpgAwardIc;
        this.itemUpgAwardName = itemUpgAwardName;
        this.newbieAwardItem = newbieAwardItem;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AzBattlepass2023AwardsItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AzBattlepass2023AwardsItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.az_battlepass_2023_awards_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static AzBattlepass2023AwardsItemBinding bind(View rootView) {
        int i = R.id.award_item_position;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.item_award_exp;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.item_award_progress_bar;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                if (progressBar != null) {
                    i = R.id.item_award_progress_bar_container;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                    if (constraintLayout != null) {
                        i = R.id.item_common_award_accept_ic;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView != null) {
                            i = R.id.item_common_award_container;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                            if (constraintLayout2 != null) {
                                i = R.id.item_common_award_get_button;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                if (constraintLayout3 != null) {
                                    i = R.id.item_common_award_glow;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                    if (imageView2 != null) {
                                        i = R.id.item_common_award_ic;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                        if (imageView3 != null) {
                                            i = R.id.item_common_award_name;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView3 != null) {
                                                i = R.id.item_upg_award_accept_ic;
                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                if (imageView4 != null) {
                                                    i = R.id.item_upg_award_container;
                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                    if (constraintLayout4 != null) {
                                                        i = R.id.item_upg_award_get_button;
                                                        ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                        if (constraintLayout5 != null) {
                                                            i = R.id.item_upg_award_glow;
                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                            if (imageView5 != null) {
                                                                i = R.id.item_upg_award_ic;
                                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                if (imageView6 != null) {
                                                                    i = R.id.item_upg_award_name;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (textView4 != null) {
                                                                        ConstraintLayout constraintLayout6 = (ConstraintLayout) rootView;
                                                                        return new AzBattlepass2023AwardsItemBinding(constraintLayout6, textView, textView2, progressBar, constraintLayout, imageView, constraintLayout2, constraintLayout3, imageView2, imageView3, textView3, imageView4, constraintLayout4, constraintLayout5, imageView5, imageView6, textView4, constraintLayout6);
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
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
