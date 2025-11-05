package ru.mrlargha.feature.battlepassWinter2025.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.battlepassWinter2025.R;
/* loaded from: classes6.dex */
public final class WinterBattlepassRoulettePriseInfoItemBinding implements ViewBinding {
    public final LinearLayout btnSellPrise;
    public final TextView pricePrise;
    private final LinearLayout rootView;
    public final LinearLayout selledPrise;
    public final TextView tvPriseName;

    private WinterBattlepassRoulettePriseInfoItemBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, LinearLayout linearLayout3, TextView textView2) {
        this.rootView = linearLayout;
        this.btnSellPrise = linearLayout2;
        this.pricePrise = textView;
        this.selledPrise = linearLayout3;
        this.tvPriseName = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassRoulettePriseInfoItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WinterBattlepassRoulettePriseInfoItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.winter_battlepass_roulette_prise_info_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassRoulettePriseInfoItemBinding bind(View view) {
        int i = R.id.btn_sell_prise;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.price_prise;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.selled_prise;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null) {
                    i = R.id.tv_prise_name;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new WinterBattlepassRoulettePriseInfoItemBinding((LinearLayout) view, linearLayout, textView, linearLayout2, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
