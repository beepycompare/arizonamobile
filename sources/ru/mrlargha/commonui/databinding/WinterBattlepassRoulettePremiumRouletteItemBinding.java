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
public final class WinterBattlepassRoulettePremiumRouletteItemBinding implements ViewBinding {
    public final ImageView prise;
    public final ImageView priseBg;
    private final FrameLayout rootView;

    private WinterBattlepassRoulettePremiumRouletteItemBinding(FrameLayout rootView, ImageView prise, ImageView priseBg) {
        this.rootView = rootView;
        this.prise = prise;
        this.priseBg = priseBg;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassRoulettePremiumRouletteItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static WinterBattlepassRoulettePremiumRouletteItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.winter_battlepass_roulette_premium_roulette_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassRoulettePremiumRouletteItemBinding bind(View rootView) {
        int i = R.id.prise;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.priseBg;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView2 != null) {
                return new WinterBattlepassRoulettePremiumRouletteItemBinding((FrameLayout) rootView, imageView, imageView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
