package ru.mrlargha.feature.battlepassWinter2025.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.battlepassWinter2025.R;
/* loaded from: classes6.dex */
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

    private WinterBattlepassConvertBattlecoinsLayoutBinding(LinearLayout linearLayout, TextView textView, TextView textView2, RelativeLayout relativeLayout, TextView textView3, ImageView imageView, TextView textView4, TextView textView5, TextView textView6, ImageView imageView2) {
        this.rootView = linearLayout;
        this.battlepointsAmountText = textView;
        this.battlepointsCurseInfoText = textView2;
        this.buttonBattleCoinsConvert = relativeLayout;
        this.coinsConvertNumbText = textView3;
        this.minusBattlepointsButton = imageView;
        this.multiplierBattlepoints1000Text = textView4;
        this.multiplierBattlepoints100Text = textView5;
        this.multiplierBattlepoints10Text = textView6;
        this.plusBattlepointsButton = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassConvertBattlecoinsLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WinterBattlepassConvertBattlecoinsLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.winter_battlepass_convert_battlecoins_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassConvertBattlecoinsLayoutBinding bind(View view) {
        int i = R.id.battlepoints_amount_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.battlepoints_curse_info_text;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.button_battle_coins_convert;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    i = R.id.coins_convert_numb_text;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.minus_battlepoints_button;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R.id.multiplier_battlepoints_1000_text;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                i = R.id.multiplier_battlepoints_100_text;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView5 != null) {
                                    i = R.id.multiplier_battlepoints_10_text;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView6 != null) {
                                        i = R.id.plus_battlepoints_button;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView2 != null) {
                                            return new WinterBattlepassConvertBattlecoinsLayoutBinding((LinearLayout) view, textView, textView2, relativeLayout, textView3, imageView, textView4, textView5, textView6, imageView2);
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
