package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class HudProgressBarContainerBinding implements ViewBinding {
    public final FrameLayout barProgress;
    public final FrameLayout barTotal;
    public final ConstraintLayout linearSum;
    public final ConstraintLayout linearTime;
    public final LinearLayout progressBarContainer;
    private final LinearLayout rootView;
    public final TextView tvNext;
    public final TextView tvProgress;
    public final TextView tvProgressTotal;

    private HudProgressBarContainerBinding(LinearLayout rootView, FrameLayout barProgress, FrameLayout barTotal, ConstraintLayout linearSum, ConstraintLayout linearTime, LinearLayout progressBarContainer, TextView tvNext, TextView tvProgress, TextView tvProgressTotal) {
        this.rootView = rootView;
        this.barProgress = barProgress;
        this.barTotal = barTotal;
        this.linearSum = linearSum;
        this.linearTime = linearTime;
        this.progressBarContainer = progressBarContainer;
        this.tvNext = tvNext;
        this.tvProgress = tvProgress;
        this.tvProgressTotal = tvProgressTotal;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static HudProgressBarContainerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudProgressBarContainerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_progress_bar_container, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudProgressBarContainerBinding bind(View rootView) {
        int i = R.id.barProgress;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
        if (frameLayout != null) {
            i = R.id.barTotal;
            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
            if (frameLayout2 != null) {
                i = R.id.linearSum;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                if (constraintLayout != null) {
                    i = R.id.linearTime;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                    if (constraintLayout2 != null) {
                        LinearLayout linearLayout = (LinearLayout) rootView;
                        i = R.id.tv_next;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView != null) {
                            i = R.id.tvProgress;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView2 != null) {
                                i = R.id.tvProgressTotal;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView3 != null) {
                                    return new HudProgressBarContainerBinding(linearLayout, frameLayout, frameLayout2, constraintLayout, constraintLayout2, linearLayout, textView, textView2, textView3);
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
