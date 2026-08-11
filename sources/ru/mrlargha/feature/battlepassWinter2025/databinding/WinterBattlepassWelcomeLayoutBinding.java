package ru.mrlargha.feature.battlepassWinter2025.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.CustomTextView;
import ru.mrlargha.feature.battlepassWinter2025.R;
/* loaded from: classes6.dex */
public final class WinterBattlepassWelcomeLayoutBinding implements ViewBinding {
    public final ImageView backWelcomeButton;
    public final ImageView battlepassWelcomeContainerBg;
    public final Button btnGetInfoWinterWelcome;
    public final ImageView logoWelcome;
    private final ConstraintLayout rootView;
    public final CustomTextView welcomePremiumDescription;
    public final WinterBattlepassRouletteOldPriseItemWelcomeBinding welcomePrice1;
    public final WinterBattlepassRouletteOldPriseItemWelcomeBinding welcomePrice2;
    public final WinterBattlepassRouletteOldPriseItemWelcomeBinding welcomePrice3;
    public final CustomTextView welcomeTitle;

    private WinterBattlepassWelcomeLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, Button button, ImageView imageView3, CustomTextView customTextView, WinterBattlepassRouletteOldPriseItemWelcomeBinding winterBattlepassRouletteOldPriseItemWelcomeBinding, WinterBattlepassRouletteOldPriseItemWelcomeBinding winterBattlepassRouletteOldPriseItemWelcomeBinding2, WinterBattlepassRouletteOldPriseItemWelcomeBinding winterBattlepassRouletteOldPriseItemWelcomeBinding3, CustomTextView customTextView2) {
        this.rootView = constraintLayout;
        this.backWelcomeButton = imageView;
        this.battlepassWelcomeContainerBg = imageView2;
        this.btnGetInfoWinterWelcome = button;
        this.logoWelcome = imageView3;
        this.welcomePremiumDescription = customTextView;
        this.welcomePrice1 = winterBattlepassRouletteOldPriseItemWelcomeBinding;
        this.welcomePrice2 = winterBattlepassRouletteOldPriseItemWelcomeBinding2;
        this.welcomePrice3 = winterBattlepassRouletteOldPriseItemWelcomeBinding3;
        this.welcomeTitle = customTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassWelcomeLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WinterBattlepassWelcomeLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.winter_battlepass_welcome_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassWelcomeLayoutBinding bind(View view) {
        View findChildViewById;
        int i = R.id.back_welcome_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.battlepass_welcome_container_bg;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.btnGetInfo_winter_welcome;
                Button button = (Button) ViewBindings.findChildViewById(view, i);
                if (button != null) {
                    i = R.id.logo_welcome;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = R.id.welcome_premium_description;
                        CustomTextView customTextView = (CustomTextView) ViewBindings.findChildViewById(view, i);
                        if (customTextView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.welcome_price_1))) != null) {
                            WinterBattlepassRouletteOldPriseItemWelcomeBinding bind = WinterBattlepassRouletteOldPriseItemWelcomeBinding.bind(findChildViewById);
                            i = R.id.welcome_price_2;
                            View findChildViewById2 = ViewBindings.findChildViewById(view, i);
                            if (findChildViewById2 != null) {
                                WinterBattlepassRouletteOldPriseItemWelcomeBinding bind2 = WinterBattlepassRouletteOldPriseItemWelcomeBinding.bind(findChildViewById2);
                                i = R.id.welcome_price_3;
                                View findChildViewById3 = ViewBindings.findChildViewById(view, i);
                                if (findChildViewById3 != null) {
                                    WinterBattlepassRouletteOldPriseItemWelcomeBinding bind3 = WinterBattlepassRouletteOldPriseItemWelcomeBinding.bind(findChildViewById3);
                                    i = R.id.welcome_title;
                                    CustomTextView customTextView2 = (CustomTextView) ViewBindings.findChildViewById(view, i);
                                    if (customTextView2 != null) {
                                        return new WinterBattlepassWelcomeLayoutBinding((ConstraintLayout) view, imageView, imageView2, button, imageView3, customTextView, bind, bind2, bind3, customTextView2);
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
