package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class DonateDialogBonusItemBinding implements ViewBinding {
    public final LinearLayout bonusContainer;
    private final FrameLayout rootView;
    public final TextView tvFrom;
    public final TextView tvPercent;

    private DonateDialogBonusItemBinding(FrameLayout rootView, LinearLayout bonusContainer, TextView tvFrom, TextView tvPercent) {
        this.rootView = rootView;
        this.bonusContainer = bonusContainer;
        this.tvFrom = tvFrom;
        this.tvPercent = tvPercent;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DonateDialogBonusItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DonateDialogBonusItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.donate_dialog_bonus_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DonateDialogBonusItemBinding bind(View rootView) {
        int i = R.id.bonus_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.tv_from;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.tv_percent;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    return new DonateDialogBonusItemBinding((FrameLayout) rootView, linearLayout, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
