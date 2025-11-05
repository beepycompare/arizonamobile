package ru.mrlargha.feature.battlepassWinter2025.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.battlepassWinter2025.R;
/* loaded from: classes6.dex */
public final class WinterBattlepassRoulettePriseItemBinding implements ViewBinding {
    public final FrameLayout bg;
    public final ImageView imagePrise;
    public final View rarity;
    private final FrameLayout rootView;

    private WinterBattlepassRoulettePriseItemBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, View view) {
        this.rootView = frameLayout;
        this.bg = frameLayout2;
        this.imagePrise = imageView;
        this.rarity = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassRoulettePriseItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WinterBattlepassRoulettePriseItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.winter_battlepass_roulette_prise_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassRoulettePriseItemBinding bind(View view) {
        View findChildViewById;
        int i = R.id.bg;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = R.id.imagePrise;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.rarity))) != null) {
                return new WinterBattlepassRoulettePriseItemBinding((FrameLayout) view, frameLayout, imageView, findChildViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
