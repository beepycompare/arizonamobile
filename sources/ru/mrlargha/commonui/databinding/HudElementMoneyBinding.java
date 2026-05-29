package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class HudElementMoneyBinding implements ViewBinding {
    public final HudElementMoneyItemBinding blockMoney;
    public final LinearLayout main;
    public final FrameLayout root;
    private final FrameLayout rootView;

    private HudElementMoneyBinding(FrameLayout rootView, HudElementMoneyItemBinding blockMoney, LinearLayout main, FrameLayout root) {
        this.rootView = rootView;
        this.blockMoney = blockMoney;
        this.main = main;
        this.root = root;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudElementMoneyBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudElementMoneyBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_element_money, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudElementMoneyBinding bind(View rootView) {
        int i = R.id.blockMoney;
        View findChildViewById = ViewBindings.findChildViewById(rootView, i);
        if (findChildViewById != null) {
            HudElementMoneyItemBinding bind = HudElementMoneyItemBinding.bind(findChildViewById);
            int i2 = R.id.main;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i2);
            if (linearLayout != null) {
                FrameLayout frameLayout = (FrameLayout) rootView;
                return new HudElementMoneyBinding(frameLayout, bind, linearLayout, frameLayout);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
