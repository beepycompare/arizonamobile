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
public final class AzBattlepassNewbieAwardsItemBinding implements ViewBinding {
    public final TextView awardItemPosition;
    public final ImageView itemAwardAcceptIc;
    public final ConstraintLayout itemAwardContainer;
    public final TextView itemAwardExp;
    public final ConstraintLayout itemAwardGetButton;
    public final ImageView itemAwardGlow;
    public final ImageView itemAwardIc;
    public final TextView itemAwardName;
    public final ProgressBar itemAwardProgressBar;
    public final ConstraintLayout itemAwardProgressBarContainer;
    public final ConstraintLayout newbieAwardItem;
    private final ConstraintLayout rootView;

    private AzBattlepassNewbieAwardsItemBinding(ConstraintLayout rootView, TextView awardItemPosition, ImageView itemAwardAcceptIc, ConstraintLayout itemAwardContainer, TextView itemAwardExp, ConstraintLayout itemAwardGetButton, ImageView itemAwardGlow, ImageView itemAwardIc, TextView itemAwardName, ProgressBar itemAwardProgressBar, ConstraintLayout itemAwardProgressBarContainer, ConstraintLayout newbieAwardItem) {
        this.rootView = rootView;
        this.awardItemPosition = awardItemPosition;
        this.itemAwardAcceptIc = itemAwardAcceptIc;
        this.itemAwardContainer = itemAwardContainer;
        this.itemAwardExp = itemAwardExp;
        this.itemAwardGetButton = itemAwardGetButton;
        this.itemAwardGlow = itemAwardGlow;
        this.itemAwardIc = itemAwardIc;
        this.itemAwardName = itemAwardName;
        this.itemAwardProgressBar = itemAwardProgressBar;
        this.itemAwardProgressBarContainer = itemAwardProgressBarContainer;
        this.newbieAwardItem = newbieAwardItem;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AzBattlepassNewbieAwardsItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AzBattlepassNewbieAwardsItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.az_battlepass_newbie_awards_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static AzBattlepassNewbieAwardsItemBinding bind(View rootView) {
        int i = R.id.award_item_position;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.item_award_accept_ic;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.item_award_container;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                if (constraintLayout != null) {
                    i = R.id.item_award_exp;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.item_award_get_button;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                        if (constraintLayout2 != null) {
                            i = R.id.item_award_glow;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView2 != null) {
                                i = R.id.item_award_ic;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                if (imageView3 != null) {
                                    i = R.id.item_award_name;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView3 != null) {
                                        i = R.id.item_award_progress_bar;
                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                                        if (progressBar != null) {
                                            i = R.id.item_award_progress_bar_container;
                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (constraintLayout3 != null) {
                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) rootView;
                                                return new AzBattlepassNewbieAwardsItemBinding(constraintLayout4, textView, imageView, constraintLayout, textView2, constraintLayout2, imageView2, imageView3, textView3, progressBar, constraintLayout3, constraintLayout4);
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
