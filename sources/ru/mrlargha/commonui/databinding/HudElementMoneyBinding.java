package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes3.dex */
public final class HudElementMoneyBinding implements ViewBinding {
    public final HudElementMoneyItemBinding blockK;
    public final HudElementMoneyItemBinding blockKK;
    public final HudElementMoneyItemBinding blockM;
    public final LinearLayout main;
    public final FrameLayout root;
    private final FrameLayout rootView;

    private HudElementMoneyBinding(FrameLayout rootView, HudElementMoneyItemBinding blockK, HudElementMoneyItemBinding blockKK, HudElementMoneyItemBinding blockM, LinearLayout main, FrameLayout root) {
        this.rootView = rootView;
        this.blockK = blockK;
        this.blockKK = blockKK;
        this.blockM = blockM;
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
        int i = R.id.blockK;
        View findChildViewById = ViewBindings.findChildViewById(rootView, i);
        if (findChildViewById != null) {
            HudElementMoneyItemBinding bind = HudElementMoneyItemBinding.bind(findChildViewById);
            i = R.id.blockKK;
            View findChildViewById2 = ViewBindings.findChildViewById(rootView, i);
            if (findChildViewById2 != null) {
                HudElementMoneyItemBinding bind2 = HudElementMoneyItemBinding.bind(findChildViewById2);
                i = R.id.blockM;
                View findChildViewById3 = ViewBindings.findChildViewById(rootView, i);
                if (findChildViewById3 != null) {
                    HudElementMoneyItemBinding bind3 = HudElementMoneyItemBinding.bind(findChildViewById3);
                    i = R.id.main;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout != null) {
                        FrameLayout frameLayout = (FrameLayout) rootView;
                        return new HudElementMoneyBinding(frameLayout, bind, bind2, bind3, linearLayout, frameLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
