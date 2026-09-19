package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class DonatePurchasePageBinding implements ViewBinding {
    public final DonatePurchaseShortcutButtonBinding btnPurchasePackages;
    public final DonatePurchaseShortcutButtonBinding btnPurchasePaypass;
    public final DonatePurchaseShortcutButtonBinding btnPurchasePiggy;
    public final LinearLayout purchaseShortcutsRow;
    private final LinearLayout rootView;
    public final RecyclerView rvPurchaseItems;
    public final TextView title;

    private DonatePurchasePageBinding(LinearLayout rootView, DonatePurchaseShortcutButtonBinding btnPurchasePackages, DonatePurchaseShortcutButtonBinding btnPurchasePaypass, DonatePurchaseShortcutButtonBinding btnPurchasePiggy, LinearLayout purchaseShortcutsRow, RecyclerView rvPurchaseItems, TextView title) {
        this.rootView = rootView;
        this.btnPurchasePackages = btnPurchasePackages;
        this.btnPurchasePaypass = btnPurchasePaypass;
        this.btnPurchasePiggy = btnPurchasePiggy;
        this.purchaseShortcutsRow = purchaseShortcutsRow;
        this.rvPurchaseItems = rvPurchaseItems;
        this.title = title;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DonatePurchasePageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DonatePurchasePageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.donate_purchase_page, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DonatePurchasePageBinding bind(View rootView) {
        int i = R.id.btn_purchase_packages;
        View findChildViewById = ViewBindings.findChildViewById(rootView, i);
        if (findChildViewById != null) {
            DonatePurchaseShortcutButtonBinding bind = DonatePurchaseShortcutButtonBinding.bind(findChildViewById);
            i = R.id.btn_purchase_paypass;
            View findChildViewById2 = ViewBindings.findChildViewById(rootView, i);
            if (findChildViewById2 != null) {
                DonatePurchaseShortcutButtonBinding bind2 = DonatePurchaseShortcutButtonBinding.bind(findChildViewById2);
                i = R.id.btn_purchase_piggy;
                View findChildViewById3 = ViewBindings.findChildViewById(rootView, i);
                if (findChildViewById3 != null) {
                    DonatePurchaseShortcutButtonBinding bind3 = DonatePurchaseShortcutButtonBinding.bind(findChildViewById3);
                    i = R.id.purchase_shortcuts_row;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout != null) {
                        i = R.id.rv_purchase_items;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                        if (recyclerView != null) {
                            i = R.id.title;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView != null) {
                                return new DonatePurchasePageBinding((LinearLayout) rootView, bind, bind2, bind3, linearLayout, recyclerView, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
