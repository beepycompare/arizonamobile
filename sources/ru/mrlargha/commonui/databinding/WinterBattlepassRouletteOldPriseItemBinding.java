package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class WinterBattlepassRouletteOldPriseItemBinding implements ViewBinding {
    public final FrameLayout bg;
    public final ImageView imagePrise;
    public final TextView oldPriseTitle;
    public final TextView priseTimeStamp;
    public final View rarity;
    private final LinearLayout rootView;
    public final FrameLayout timerContainer;

    private WinterBattlepassRouletteOldPriseItemBinding(LinearLayout rootView, FrameLayout bg, ImageView imagePrise, TextView oldPriseTitle, TextView priseTimeStamp, View rarity, FrameLayout timerContainer) {
        this.rootView = rootView;
        this.bg = bg;
        this.imagePrise = imagePrise;
        this.oldPriseTitle = oldPriseTitle;
        this.priseTimeStamp = priseTimeStamp;
        this.rarity = rarity;
        this.timerContainer = timerContainer;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassRouletteOldPriseItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static WinterBattlepassRouletteOldPriseItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.winter_battlepass_roulette_old_prise_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassRouletteOldPriseItemBinding bind(View rootView) {
        View findChildViewById;
        int i = R.id.bg;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
        if (frameLayout != null) {
            i = R.id.imagePrise;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.oldPriseTitle;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.priseTimeStamp;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.rarity))) != null) {
                        i = R.id.timer_container;
                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                        if (frameLayout2 != null) {
                            return new WinterBattlepassRouletteOldPriseItemBinding((LinearLayout) rootView, frameLayout, imageView, textView, textView2, findChildViewById, frameLayout2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
