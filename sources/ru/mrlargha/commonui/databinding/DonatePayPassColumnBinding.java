package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class DonatePayPassColumnBinding implements ViewBinding {
    public final DonatePayPassMarkerBinding paypassMarker;
    public final View paypassProgressAfter;
    public final View paypassProgressBefore;
    public final View paypassProgressGap;
    public final LinearLayout paypassProgressRow;
    public final DonatePayPassTierBinding paypassTier;
    private final LinearLayout rootView;

    private DonatePayPassColumnBinding(LinearLayout rootView, DonatePayPassMarkerBinding paypassMarker, View paypassProgressAfter, View paypassProgressBefore, View paypassProgressGap, LinearLayout paypassProgressRow, DonatePayPassTierBinding paypassTier) {
        this.rootView = rootView;
        this.paypassMarker = paypassMarker;
        this.paypassProgressAfter = paypassProgressAfter;
        this.paypassProgressBefore = paypassProgressBefore;
        this.paypassProgressGap = paypassProgressGap;
        this.paypassProgressRow = paypassProgressRow;
        this.paypassTier = paypassTier;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DonatePayPassColumnBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DonatePayPassColumnBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.donate_pay_pass_column, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DonatePayPassColumnBinding bind(View rootView) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        int i = R.id.paypass_marker;
        View findChildViewById4 = ViewBindings.findChildViewById(rootView, i);
        if (findChildViewById4 != null) {
            DonatePayPassMarkerBinding bind = DonatePayPassMarkerBinding.bind(findChildViewById4);
            i = R.id.paypass_progress_after;
            View findChildViewById5 = ViewBindings.findChildViewById(rootView, i);
            if (findChildViewById5 != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.paypass_progress_before))) != null && (findChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.paypass_progress_gap))) != null) {
                i = R.id.paypass_progress_row;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                if (linearLayout != null && (findChildViewById3 = ViewBindings.findChildViewById(rootView, (i = R.id.paypass_tier))) != null) {
                    return new DonatePayPassColumnBinding((LinearLayout) rootView, bind, findChildViewById5, findChildViewById, findChildViewById2, linearLayout, DonatePayPassTierBinding.bind(findChildViewById3));
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
