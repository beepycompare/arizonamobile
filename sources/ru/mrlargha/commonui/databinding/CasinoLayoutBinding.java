package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class CasinoLayoutBinding implements ViewBinding {
    public final ConstraintLayout actionButton;
    public final Guideline actionButtonTopLine;
    public final TextView actionButtonTxt;
    public final TextView balance;
    public final TextView bet;
    public final ImageView bottomButton;
    public final ConstraintLayout casinoWinScreen;
    public final ConstraintLayout controlContainer;
    public final ImageView exitButton;
    public final TextView gameName;
    public final ImageView leftButton;
    public final ConstraintLayout linkingLayout;
    public final ImageView minusButton;
    public final ImageView plusButton;
    public final ImageView rightButton;
    private final ConstraintLayout rootView;
    public final ImageView upButton;
    public final TextView winCount;
    public final TextView winTitle;

    private CasinoLayoutBinding(ConstraintLayout rootView, ConstraintLayout actionButton, Guideline actionButtonTopLine, TextView actionButtonTxt, TextView balance, TextView bet, ImageView bottomButton, ConstraintLayout casinoWinScreen, ConstraintLayout controlContainer, ImageView exitButton, TextView gameName, ImageView leftButton, ConstraintLayout linkingLayout, ImageView minusButton, ImageView plusButton, ImageView rightButton, ImageView upButton, TextView winCount, TextView winTitle) {
        this.rootView = rootView;
        this.actionButton = actionButton;
        this.actionButtonTopLine = actionButtonTopLine;
        this.actionButtonTxt = actionButtonTxt;
        this.balance = balance;
        this.bet = bet;
        this.bottomButton = bottomButton;
        this.casinoWinScreen = casinoWinScreen;
        this.controlContainer = controlContainer;
        this.exitButton = exitButton;
        this.gameName = gameName;
        this.leftButton = leftButton;
        this.linkingLayout = linkingLayout;
        this.minusButton = minusButton;
        this.plusButton = plusButton;
        this.rightButton = rightButton;
        this.upButton = upButton;
        this.winCount = winCount;
        this.winTitle = winTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static CasinoLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CasinoLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.casino_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static CasinoLayoutBinding bind(View rootView) {
        int i = R.id.action_button;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
        if (constraintLayout != null) {
            i = R.id.action_button_top_line;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
            if (guideline != null) {
                i = R.id.action_button_txt;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.balance;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.bet;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            i = R.id.bottom_button;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView != null) {
                                i = R.id.casino_win_screen;
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                if (constraintLayout2 != null) {
                                    i = R.id.control_container;
                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (constraintLayout3 != null) {
                                        i = R.id.exit_button;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                        if (imageView2 != null) {
                                            i = R.id.game_name;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView4 != null) {
                                                i = R.id.left_button;
                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                if (imageView3 != null) {
                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) rootView;
                                                    i = R.id.minus_button;
                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                    if (imageView4 != null) {
                                                        i = R.id.plus_button;
                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                        if (imageView5 != null) {
                                                            i = R.id.right_button;
                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                            if (imageView6 != null) {
                                                                i = R.id.up_button;
                                                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                if (imageView7 != null) {
                                                                    i = R.id.win_count;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (textView5 != null) {
                                                                        i = R.id.win_title;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (textView6 != null) {
                                                                            return new CasinoLayoutBinding(constraintLayout4, constraintLayout, guideline, textView, textView2, textView3, imageView, constraintLayout2, constraintLayout3, imageView2, textView4, imageView3, constraintLayout4, imageView4, imageView5, imageView6, imageView7, textView5, textView6);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
