package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class HudFactionCaptureBinding implements ViewBinding {
    public final CustomCardView counterContainer;
    public final TextView leftFaction;
    public final LinearLayout leftFactionColumn;
    public final TextView leftScore;
    public final CustomCardView leftScoreContainer;
    public final TextView rightFaction;
    public final LinearLayout rightFactionColumn;
    public final TextView rightScore;
    public final CustomCardView rightScoreContainer;
    private final LinearLayout rootView;
    public final TextView status;
    public final TextView timer;

    private HudFactionCaptureBinding(LinearLayout rootView, CustomCardView counterContainer, TextView leftFaction, LinearLayout leftFactionColumn, TextView leftScore, CustomCardView leftScoreContainer, TextView rightFaction, LinearLayout rightFactionColumn, TextView rightScore, CustomCardView rightScoreContainer, TextView status, TextView timer) {
        this.rootView = rootView;
        this.counterContainer = counterContainer;
        this.leftFaction = leftFaction;
        this.leftFactionColumn = leftFactionColumn;
        this.leftScore = leftScore;
        this.leftScoreContainer = leftScoreContainer;
        this.rightFaction = rightFaction;
        this.rightFactionColumn = rightFactionColumn;
        this.rightScore = rightScore;
        this.rightScoreContainer = rightScoreContainer;
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
        int i = R.id.counter_container;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
        if (customCardView != null) {
            i = R.id.left_faction;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.left_faction_column;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                if (linearLayout != null) {
                    i = R.id.left_score;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.left_score_container;
                        CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                        if (customCardView2 != null) {
                            i = R.id.right_faction;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView3 != null) {
                                i = R.id.right_faction_column;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                if (linearLayout2 != null) {
                                    i = R.id.right_score;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView4 != null) {
                                        i = R.id.right_score_container;
                                        CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                        if (customCardView3 != null) {
                                            i = R.id.status;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView5 != null) {
                                                i = R.id.timer;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView6 != null) {
                                                    return new HudFactionCaptureBinding((LinearLayout) rootView, customCardView, textView, linearLayout, textView2, customCardView2, textView3, linearLayout2, textView4, customCardView3, textView5, textView6);
                                                }
                                            }
                                        }
                                    }
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
