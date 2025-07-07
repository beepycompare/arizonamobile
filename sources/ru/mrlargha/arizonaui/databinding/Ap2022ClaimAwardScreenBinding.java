package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class Ap2022ClaimAwardScreenBinding implements ViewBinding {
    public final TextView awardTitle;
    public final Button claimAwardToInventoryButton;
    public final ConstraintLayout claimLayout;
    public final AppCompatImageView receivedAward;
    private final ConstraintLayout rootView;
    public final Button sellAwardButton;
    public final TextView textView14;

    private Ap2022ClaimAwardScreenBinding(ConstraintLayout constraintLayout, TextView textView, Button button, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, Button button2, TextView textView2) {
        this.rootView = constraintLayout;
        this.awardTitle = textView;
        this.claimAwardToInventoryButton = button;
        this.claimLayout = constraintLayout2;
        this.receivedAward = appCompatImageView;
        this.sellAwardButton = button2;
        this.textView14 = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static Ap2022ClaimAwardScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static Ap2022ClaimAwardScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.ap_2022_claim_award_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Ap2022ClaimAwardScreenBinding bind(View view) {
        int i = R.id.award_title;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.claim_award_to_inventory_button;
            Button button = (Button) ViewBindings.findChildViewById(view, i);
            if (button != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.receivedAward;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                if (appCompatImageView != null) {
                    i = R.id.sell_award_button;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                    if (button2 != null) {
                        i = R.id.textView14;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new Ap2022ClaimAwardScreenBinding(constraintLayout, textView, button, constraintLayout, appCompatImageView, button2, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
