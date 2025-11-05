package ru.mrlargha.feature.battlepassWinter2025.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.GradientText.ArizonaGradientTextView;
import ru.mrlargha.feature.battlepassWinter2025.R;
/* loaded from: classes6.dex */
public final class WinterBattlepassRouletteLayoutBinding implements ViewBinding {
    public final LinearLayout battlepass2025WinterRoulettePremButton;
    public final TextView battlepass2025WinterRoulettePremCount;
    public final ImageView battlepass2025WinterRouletteUsual;
    public final LinearLayout battlepass2025WinterRouletteUsualButton;
    public final TextView battlepass2025WinterRouletteUsualCount;
    public final ArizonaGradientTextView premText;
    private final ConstraintLayout rootView;
    public final TextView roulettePageSaleText;
    public final TextView usualTitle;
    public final TextView usualTitle1;
    public final TextView usualTitle2;
    public final ConstraintLayout winterBattlepassTasksLayoutContainer;

    private WinterBattlepassRouletteLayoutBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, TextView textView, ImageView imageView, LinearLayout linearLayout2, TextView textView2, ArizonaGradientTextView arizonaGradientTextView, TextView textView3, TextView textView4, TextView textView5, TextView textView6, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.battlepass2025WinterRoulettePremButton = linearLayout;
        this.battlepass2025WinterRoulettePremCount = textView;
        this.battlepass2025WinterRouletteUsual = imageView;
        this.battlepass2025WinterRouletteUsualButton = linearLayout2;
        this.battlepass2025WinterRouletteUsualCount = textView2;
        this.premText = arizonaGradientTextView;
        this.roulettePageSaleText = textView3;
        this.usualTitle = textView4;
        this.usualTitle1 = textView5;
        this.usualTitle2 = textView6;
        this.winterBattlepassTasksLayoutContainer = constraintLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassRouletteLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WinterBattlepassRouletteLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.winter_battlepass_roulette_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassRouletteLayoutBinding bind(View view) {
        int i = R.id.battlepass_2025_winter_roulette_prem_button;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.battlepass_2025_winter_roulette_prem_count;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.battlepass_2025_winter_roulette_usual;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.battlepass_2025_winter_roulette_usual_button;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = R.id.battlepass_2025_winter_roulette_usual_count;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.prem_text;
                            ArizonaGradientTextView arizonaGradientTextView = (ArizonaGradientTextView) ViewBindings.findChildViewById(view, i);
                            if (arizonaGradientTextView != null) {
                                i = R.id.roulette_page_sale_text;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.usual_title;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.usual_title1;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            i = R.id.usual_title2;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView6 != null) {
                                                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                return new WinterBattlepassRouletteLayoutBinding(constraintLayout, linearLayout, textView, imageView, linearLayout2, textView2, arizonaGradientTextView, textView3, textView4, textView5, textView6, constraintLayout);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
