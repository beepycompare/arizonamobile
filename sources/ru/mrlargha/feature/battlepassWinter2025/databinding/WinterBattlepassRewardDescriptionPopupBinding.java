package ru.mrlargha.feature.battlepassWinter2025.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.battlepassWinter2025.R;
/* loaded from: classes6.dex */
public final class WinterBattlepassRewardDescriptionPopupBinding implements ViewBinding {
    public final TextView rewardDescriptionText;
    private final CustomCardView rootView;

    private WinterBattlepassRewardDescriptionPopupBinding(CustomCardView customCardView, TextView textView) {
        this.rootView = customCardView;
        this.rewardDescriptionText = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassRewardDescriptionPopupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WinterBattlepassRewardDescriptionPopupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.winter_battlepass_reward_description_popup, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassRewardDescriptionPopupBinding bind(View view) {
        int i = R.id.reward_description_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            return new WinterBattlepassRewardDescriptionPopupBinding((CustomCardView) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
