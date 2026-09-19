package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class DonatePayPassTooltipBinding implements ViewBinding {
    public final TextView paypassTooltipDescription;
    public final TextView paypassTooltipTitle;
    private final CustomCardView rootView;

    private DonatePayPassTooltipBinding(CustomCardView rootView, TextView paypassTooltipDescription, TextView paypassTooltipTitle) {
        this.rootView = rootView;
        this.paypassTooltipDescription = paypassTooltipDescription;
        this.paypassTooltipTitle = paypassTooltipTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static DonatePayPassTooltipBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DonatePayPassTooltipBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.donate_pay_pass_tooltip, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DonatePayPassTooltipBinding bind(View rootView) {
        int i = R.id.paypass_tooltip_description;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.paypass_tooltip_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                return new DonatePayPassTooltipBinding((CustomCardView) rootView, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
