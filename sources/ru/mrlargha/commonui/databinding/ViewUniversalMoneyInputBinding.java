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
public final class ViewUniversalMoneyInputBinding implements ViewBinding {
    public final ViewMoneyPartInputBinding blockK;
    public final ViewMoneyPartInputBinding blockKK;
    public final ViewMoneyPartInputBinding blockM;
    public final ViewMoneyPartInputBinding etSingle;
    public final LinearLayout layoutMoney;
    public final FrameLayout root;
    private final FrameLayout rootView;

    private ViewUniversalMoneyInputBinding(FrameLayout rootView, ViewMoneyPartInputBinding blockK, ViewMoneyPartInputBinding blockKK, ViewMoneyPartInputBinding blockM, ViewMoneyPartInputBinding etSingle, LinearLayout layoutMoney, FrameLayout root) {
        this.rootView = rootView;
        this.blockK = blockK;
        this.blockKK = blockKK;
        this.blockM = blockM;
        this.etSingle = etSingle;
        this.layoutMoney = layoutMoney;
        this.root = root;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ViewUniversalMoneyInputBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ViewUniversalMoneyInputBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.view_universal_money_input, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewUniversalMoneyInputBinding bind(View rootView) {
        int i = R.id.blockK;
        View findChildViewById = ViewBindings.findChildViewById(rootView, i);
        if (findChildViewById != null) {
            ViewMoneyPartInputBinding bind = ViewMoneyPartInputBinding.bind(findChildViewById);
            i = R.id.blockKK;
            View findChildViewById2 = ViewBindings.findChildViewById(rootView, i);
            if (findChildViewById2 != null) {
                ViewMoneyPartInputBinding bind2 = ViewMoneyPartInputBinding.bind(findChildViewById2);
                i = R.id.blockM;
                View findChildViewById3 = ViewBindings.findChildViewById(rootView, i);
                if (findChildViewById3 != null) {
                    ViewMoneyPartInputBinding bind3 = ViewMoneyPartInputBinding.bind(findChildViewById3);
                    i = R.id.etSingle;
                    View findChildViewById4 = ViewBindings.findChildViewById(rootView, i);
                    if (findChildViewById4 != null) {
                        ViewMoneyPartInputBinding bind4 = ViewMoneyPartInputBinding.bind(findChildViewById4);
                        i = R.id.layoutMoney;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                        if (linearLayout != null) {
                            FrameLayout frameLayout = (FrameLayout) rootView;
                            return new ViewUniversalMoneyInputBinding(frameLayout, bind, bind2, bind3, bind4, linearLayout, frameLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
