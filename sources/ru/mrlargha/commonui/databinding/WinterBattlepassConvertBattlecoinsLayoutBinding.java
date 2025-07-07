package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class WinterBattlepassConvertBattlecoinsLayoutBinding implements ViewBinding {
    public final TextView battlepointsAmountText;
    public final TextView battlepointsCurseInfoText;
    public final RelativeLayout buttonBattleCoinsConvert;
    public final TextView coinsConvertNumbText;
    public final ImageView minusBattlepointsButton;
    public final TextView multiplierBattlepoints1000Text;
    public final TextView multiplierBattlepoints100Text;
    public final TextView multiplierBattlepoints10Text;
    public final ImageView plusBattlepointsButton;
    private final LinearLayout rootView;

    private WinterBattlepassConvertBattlecoinsLayoutBinding(LinearLayout rootView, TextView battlepointsAmountText, TextView battlepointsCurseInfoText, RelativeLayout buttonBattleCoinsConvert, TextView coinsConvertNumbText, ImageView minusBattlepointsButton, TextView multiplierBattlepoints1000Text, TextView multiplierBattlepoints100Text, TextView multiplierBattlepoints10Text, ImageView plusBattlepointsButton) {
        this.rootView = rootView;
        this.battlepointsAmountText = battlepointsAmountText;
        this.battlepointsCurseInfoText = battlepointsCurseInfoText;
        this.buttonBattleCoinsConvert = buttonBattleCoinsConvert;
        this.coinsConvertNumbText = coinsConvertNumbText;
        this.minusBattlepointsButton = minusBattlepointsButton;
        this.multiplierBattlepoints1000Text = multiplierBattlepoints1000Text;
        this.multiplierBattlepoints100Text = multiplierBattlepoints100Text;
        this.multiplierBattlepoints10Text = multiplierBattlepoints10Text;
        this.plusBattlepointsButton = plusBattlepointsButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassConvertBattlecoinsLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static WinterBattlepassConvertBattlecoinsLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.winter_battlepass_convert_battlecoins_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassConvertBattlecoinsLayoutBinding bind(View rootView) {
        int i = R.id.battlepoints_amount_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.battlepoints_curse_info_text;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.button_battle_coins_convert;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                if (relativeLayout != null) {
                    i = R.id.coins_convert_numb_text;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.minus_battlepoints_button;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView != null) {
                            i = R.id.multiplier_battlepoints_1000_text;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView4 != null) {
                                i = R.id.multiplier_battlepoints_100_text;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView5 != null) {
                                    i = R.id.multiplier_battlepoints_10_text;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView6 != null) {
                                        i = R.id.plus_battlepoints_button;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                        if (imageView2 != null) {
                                            return new WinterBattlepassConvertBattlecoinsLayoutBinding((LinearLayout) rootView, textView, textView2, relativeLayout, textView3, imageView, textView4, textView5, textView6, imageView2);
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
