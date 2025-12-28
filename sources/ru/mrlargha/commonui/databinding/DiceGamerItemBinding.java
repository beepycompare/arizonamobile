package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class DiceGamerItemBinding implements ViewBinding {
    public final ConstraintLayout diceGamerItem;
    public final TextView diceScore;
    public final ConstraintLayout diceScoreBg;
    public final ConstraintLayout diceScoreContainer;
    public final TextView diceScoreTitle;
    public final AppCompatImageView gamerIcon;
    public final TextView gamerNickname;
    private final ConstraintLayout rootView;

    private DiceGamerItemBinding(ConstraintLayout rootView, ConstraintLayout diceGamerItem, TextView diceScore, ConstraintLayout diceScoreBg, ConstraintLayout diceScoreContainer, TextView diceScoreTitle, AppCompatImageView gamerIcon, TextView gamerNickname) {
        this.rootView = rootView;
        this.diceGamerItem = diceGamerItem;
        this.diceScore = diceScore;
        this.diceScoreBg = diceScoreBg;
        this.diceScoreContainer = diceScoreContainer;
        this.diceScoreTitle = diceScoreTitle;
        this.gamerIcon = gamerIcon;
        this.gamerNickname = gamerNickname;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DiceGamerItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DiceGamerItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dice_gamer_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DiceGamerItemBinding bind(View rootView) {
        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
        int i = R.id.dice_score;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.dice_score_bg;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
            if (constraintLayout2 != null) {
                i = R.id.dice_score_container;
                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                if (constraintLayout3 != null) {
                    i = R.id.dice_score_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.gamer_icon;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                        if (appCompatImageView != null) {
                            i = R.id.gamer_nickname;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView3 != null) {
                                return new DiceGamerItemBinding(constraintLayout, constraintLayout, textView, constraintLayout2, constraintLayout3, textView2, appCompatImageView, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
