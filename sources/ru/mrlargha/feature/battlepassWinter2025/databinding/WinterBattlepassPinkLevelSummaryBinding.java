package ru.mrlargha.feature.battlepassWinter2025.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.battlepassWinter2025.R;
/* loaded from: classes6.dex */
public final class WinterBattlepassPinkLevelSummaryBinding implements ViewBinding {
    public final CustomCardView buyLevelsButton;
    public final LinearProgressIndicator experienceProgress;
    public final TextView experienceText;
    public final FrameLayout levelSummaryRoot;
    public final TextView levelText;
    private final FrameLayout rootView;

    private WinterBattlepassPinkLevelSummaryBinding(FrameLayout frameLayout, CustomCardView customCardView, LinearProgressIndicator linearProgressIndicator, TextView textView, FrameLayout frameLayout2, TextView textView2) {
        this.rootView = frameLayout;
        this.buyLevelsButton = customCardView;
        this.experienceProgress = linearProgressIndicator;
        this.experienceText = textView;
        this.levelSummaryRoot = frameLayout2;
        this.levelText = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassPinkLevelSummaryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WinterBattlepassPinkLevelSummaryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.winter_battlepass_pink_level_summary, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassPinkLevelSummaryBinding bind(View view) {
        int i = R.id.buy_levels_button;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
        if (customCardView != null) {
            i = R.id.experience_progress;
            LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) ViewBindings.findChildViewById(view, i);
            if (linearProgressIndicator != null) {
                i = R.id.experience_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    FrameLayout frameLayout = (FrameLayout) view;
                    i = R.id.level_text;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new WinterBattlepassPinkLevelSummaryBinding(frameLayout, customCardView, linearProgressIndicator, textView, frameLayout, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
