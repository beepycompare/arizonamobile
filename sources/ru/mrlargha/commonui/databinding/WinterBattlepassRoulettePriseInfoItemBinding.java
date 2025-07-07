package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class WinterBattlepassRoulettePriseInfoItemBinding implements ViewBinding {
    public final LinearLayout btnSellPrise;
    public final TextView pricePrise;
    private final LinearLayout rootView;
    public final LinearLayout selledPrise;
    public final TextView tvPriseName;

    private WinterBattlepassRoulettePriseInfoItemBinding(LinearLayout rootView, LinearLayout btnSellPrise, TextView pricePrise, LinearLayout selledPrise, TextView tvPriseName) {
        this.rootView = rootView;
        this.btnSellPrise = btnSellPrise;
        this.pricePrise = pricePrise;
        this.selledPrise = selledPrise;
        this.tvPriseName = tvPriseName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassRoulettePriseInfoItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static WinterBattlepassRoulettePriseInfoItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.winter_battlepass_roulette_prise_info_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassRoulettePriseInfoItemBinding bind(View rootView) {
        int i = R.id.btn_sell_prise;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.price_prise;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.selled_prise;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                if (linearLayout2 != null) {
                    i = R.id.tv_prise_name;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        return new WinterBattlepassRoulettePriseInfoItemBinding((LinearLayout) rootView, linearLayout, textView, linearLayout2, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
