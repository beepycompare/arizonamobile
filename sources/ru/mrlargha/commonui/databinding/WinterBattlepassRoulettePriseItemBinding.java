package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class WinterBattlepassRoulettePriseItemBinding implements ViewBinding {
    public final FrameLayout bg;
    public final ImageView imagePrise;
    public final View rarity;
    private final FrameLayout rootView;

    private WinterBattlepassRoulettePriseItemBinding(FrameLayout rootView, FrameLayout bg, ImageView imagePrise, View rarity) {
        this.rootView = rootView;
        this.bg = bg;
        this.imagePrise = imagePrise;
        this.rarity = rarity;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassRoulettePriseItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static WinterBattlepassRoulettePriseItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.winter_battlepass_roulette_prise_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassRoulettePriseItemBinding bind(View rootView) {
        View findChildViewById;
        int i = R.id.bg;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
        if (frameLayout != null) {
            i = R.id.imagePrise;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.rarity))) != null) {
                return new WinterBattlepassRoulettePriseItemBinding((FrameLayout) rootView, frameLayout, imageView, findChildViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
