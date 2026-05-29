package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class HudElementMoneyItemBinding implements ViewBinding {
    public final LinearLayout deltaRow;
    public final LinearLayout root;
    private final LinearLayout rootView;
    public final LinearLayout topRow;
    public final TextView tvDelta;
    public final TextView tvDeltaSign;
    public final ImageView tvPrefix;
    public final ImageView tvPrefixDelta;
    public final TextView tvValue;

    private HudElementMoneyItemBinding(LinearLayout rootView, LinearLayout deltaRow, LinearLayout root, LinearLayout topRow, TextView tvDelta, TextView tvDeltaSign, ImageView tvPrefix, ImageView tvPrefixDelta, TextView tvValue) {
        this.rootView = rootView;
        this.deltaRow = deltaRow;
        this.root = root;
        this.topRow = topRow;
        this.tvDelta = tvDelta;
        this.tvDeltaSign = tvDeltaSign;
        this.tvPrefix = tvPrefix;
        this.tvPrefixDelta = tvPrefixDelta;
        this.tvValue = tvValue;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static HudElementMoneyItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudElementMoneyItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_element_money_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudElementMoneyItemBinding bind(View rootView) {
        int i = R.id.deltaRow;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            LinearLayout linearLayout2 = (LinearLayout) rootView;
            i = R.id.topRow;
            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout3 != null) {
                i = R.id.tvDelta;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.tvDeltaSign;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.tvPrefix;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView != null) {
                            i = R.id.tvPrefixDelta;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView2 != null) {
                                i = R.id.tvValue;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView3 != null) {
                                    return new HudElementMoneyItemBinding(linearLayout2, linearLayout, linearLayout2, linearLayout3, textView, textView2, imageView, imageView2, textView3);
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
