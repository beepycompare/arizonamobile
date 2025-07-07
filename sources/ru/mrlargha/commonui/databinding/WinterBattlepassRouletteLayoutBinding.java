package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class WinterBattlepassRouletteLayoutBinding implements ViewBinding {
    public final LinearLayout battlepass2025WinterRoulettePremButton;
    public final TextView battlepass2025WinterRoulettePremCount;
    public final ImageView battlepass2025WinterRouletteUsual;
    public final LinearLayout battlepass2025WinterRouletteUsualButton;
    public final TextView battlepass2025WinterRouletteUsualCount;
    private final ConstraintLayout rootView;
    public final TextView roulettePageSaleText;
    public final ConstraintLayout winterBattlepassTasksLayoutContainer;

    private WinterBattlepassRouletteLayoutBinding(ConstraintLayout rootView, LinearLayout battlepass2025WinterRoulettePremButton, TextView battlepass2025WinterRoulettePremCount, ImageView battlepass2025WinterRouletteUsual, LinearLayout battlepass2025WinterRouletteUsualButton, TextView battlepass2025WinterRouletteUsualCount, TextView roulettePageSaleText, ConstraintLayout winterBattlepassTasksLayoutContainer) {
        this.rootView = rootView;
        this.battlepass2025WinterRoulettePremButton = battlepass2025WinterRoulettePremButton;
        this.battlepass2025WinterRoulettePremCount = battlepass2025WinterRoulettePremCount;
        this.battlepass2025WinterRouletteUsual = battlepass2025WinterRouletteUsual;
        this.battlepass2025WinterRouletteUsualButton = battlepass2025WinterRouletteUsualButton;
        this.battlepass2025WinterRouletteUsualCount = battlepass2025WinterRouletteUsualCount;
        this.roulettePageSaleText = roulettePageSaleText;
        this.winterBattlepassTasksLayoutContainer = winterBattlepassTasksLayoutContainer;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassRouletteLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static WinterBattlepassRouletteLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.winter_battlepass_roulette_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassRouletteLayoutBinding bind(View rootView) {
        int i = R.id.battlepass_2025_winter_roulette_prem_button;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.battlepass_2025_winter_roulette_prem_count;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.battlepass_2025_winter_roulette_usual;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView != null) {
                    i = R.id.battlepass_2025_winter_roulette_usual_button;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout2 != null) {
                        i = R.id.battlepass_2025_winter_roulette_usual_count;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            i = R.id.roulette_page_sale_text;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView3 != null) {
                                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                                return new WinterBattlepassRouletteLayoutBinding(constraintLayout, linearLayout, textView, imageView, linearLayout2, textView2, textView3, constraintLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
