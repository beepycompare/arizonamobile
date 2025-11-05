package ru.mrlargha.feature.battlepassWinter2025.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.battlepassWinter2025.R;
/* loaded from: classes6.dex */
public final class WinterBattlepassRouletteOldPriseItemWelcomeBinding implements ViewBinding {
    public final FrameLayout bg;
    public final ImageView imagePrise;
    public final TextView oldPriseTitle;
    public final TextView priseTimeStamp;
    public final View rarity;
    private final LinearLayout rootView;
    public final FrameLayout timerContainer;

    private WinterBattlepassRouletteOldPriseItemWelcomeBinding(LinearLayout linearLayout, FrameLayout frameLayout, ImageView imageView, TextView textView, TextView textView2, View view, FrameLayout frameLayout2) {
        this.rootView = linearLayout;
        this.bg = frameLayout;
        this.imagePrise = imageView;
        this.oldPriseTitle = textView;
        this.priseTimeStamp = textView2;
        this.rarity = view;
        this.timerContainer = frameLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassRouletteOldPriseItemWelcomeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WinterBattlepassRouletteOldPriseItemWelcomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.winter_battlepass_roulette_old_prise_item_welcome, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassRouletteOldPriseItemWelcomeBinding bind(View view) {
        View findChildViewById;
        int i = R.id.bg;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = R.id.imagePrise;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.oldPriseTitle;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.priseTimeStamp;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.rarity))) != null) {
                        i = R.id.timer_container;
                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout2 != null) {
                            return new WinterBattlepassRouletteOldPriseItemWelcomeBinding((LinearLayout) view, frameLayout, imageView, textView, textView2, findChildViewById, frameLayout2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
