package com.arizonagames.feature.arizona.bank.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizonagames.feature.arizona.bank.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class BankOtherVehicleItemBinding implements ViewBinding {
    public final CustomCardView bankOtherVehicleBuyButton;
    public final TextView bankOtherVehicleBuyText;
    public final TextView bankOtherVehicleCost;
    public final TextView bankOtherVehicleName;
    public final TextView bankOtherVehicleReason;
    private final CustomCardView rootView;

    private BankOtherVehicleItemBinding(CustomCardView customCardView, CustomCardView customCardView2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = customCardView;
        this.bankOtherVehicleBuyButton = customCardView2;
        this.bankOtherVehicleBuyText = textView;
        this.bankOtherVehicleCost = textView2;
        this.bankOtherVehicleName = textView3;
        this.bankOtherVehicleReason = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static BankOtherVehicleItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BankOtherVehicleItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bank_other_vehicle_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BankOtherVehicleItemBinding bind(View view) {
        int i = R.id.bank_other_vehicle_buy_button;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
        if (customCardView != null) {
            i = R.id.bank_other_vehicle_buy_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.bank_other_vehicle_cost;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.bank_other_vehicle_name;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.bank_other_vehicle_reason;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            return new BankOtherVehicleItemBinding((CustomCardView) view, customCardView, textView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
