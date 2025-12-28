package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class LayoutTuningCartBinding implements ViewBinding {
    public final Button btnBuyItems;
    public final Button btnEmptyCart;
    public final ConstraintLayout parentLayout;
    private final ConstraintLayout rootView;
    public final RecyclerView rvUserCart;
    public final TextView tvSubPriceText;
    public final TextView tvSubTitle;
    public final TextView tvTitle;
    public final TextView tvTotalPrice;

    private LayoutTuningCartBinding(ConstraintLayout rootView, Button btnBuyItems, Button btnEmptyCart, ConstraintLayout parentLayout, RecyclerView rvUserCart, TextView tvSubPriceText, TextView tvSubTitle, TextView tvTitle, TextView tvTotalPrice) {
        this.rootView = rootView;
        this.btnBuyItems = btnBuyItems;
        this.btnEmptyCart = btnEmptyCart;
        this.parentLayout = parentLayout;
        this.rvUserCart = rvUserCart;
        this.tvSubPriceText = tvSubPriceText;
        this.tvSubTitle = tvSubTitle;
        this.tvTitle = tvTitle;
        this.tvTotalPrice = tvTotalPrice;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutTuningCartBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutTuningCartBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.layout_tuning_cart, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutTuningCartBinding bind(View rootView) {
        int i = R.id.btnBuyItems;
        Button button = (Button) ViewBindings.findChildViewById(rootView, i);
        if (button != null) {
            i = R.id.btnEmptyCart;
            Button button2 = (Button) ViewBindings.findChildViewById(rootView, i);
            if (button2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                i = R.id.rvUserCart;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                if (recyclerView != null) {
                    i = R.id.tvSubPriceText;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null) {
                        i = R.id.tvSubTitle;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            i = R.id.tvTitle;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView3 != null) {
                                i = R.id.tvTotalPrice;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView4 != null) {
                                    return new LayoutTuningCartBinding(constraintLayout, button, button2, constraintLayout, recyclerView, textView, textView2, textView3, textView4);
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
