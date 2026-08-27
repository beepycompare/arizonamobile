package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class HudFactionCaptureBinding implements ViewBinding {
    public final TextView leftFaction;
    public final TextView leftScore;
    public final TextView rightFaction;
    public final TextView rightScore;
    private final LinearLayout rootView;
    public final TextView status;
    public final TextView timer;

    private HudFactionCaptureBinding(LinearLayout rootView, TextView leftFaction, TextView leftScore, TextView rightFaction, TextView rightScore, TextView status, TextView timer) {
        this.rootView = rootView;
        this.leftFaction = leftFaction;
        this.leftScore = leftScore;
        this.rightFaction = rightFaction;
        this.rightScore = rightScore;
        this.status = status;
        this.timer = timer;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static HudFactionCaptureBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudFactionCaptureBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_faction_capture, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudFactionCaptureBinding bind(View rootView) {
        int i = R.id.left_faction;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.left_score;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.right_faction;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.right_score;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.status;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            i = R.id.timer;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView6 != null) {
                                return new HudFactionCaptureBinding((LinearLayout) rootView, textView, textView2, textView3, textView4, textView5, textView6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
