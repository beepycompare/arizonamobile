package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class EasterBattlepassPriseItemEventBinding implements ViewBinding {
    public final FrameLayout bg;
    public final ImageView imagePrise;
    public final View rarity;
    private final LinearLayout rootView;

    private EasterBattlepassPriseItemEventBinding(LinearLayout rootView, FrameLayout bg, ImageView imagePrise, View rarity) {
        this.rootView = rootView;
        this.bg = bg;
        this.imagePrise = imagePrise;
        this.rarity = rarity;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EasterBattlepassPriseItemEventBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EasterBattlepassPriseItemEventBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.easter_battlepass_prise_item_event, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static EasterBattlepassPriseItemEventBinding bind(View rootView) {
        View findChildViewById;
        int i = R.id.bg;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
        if (frameLayout != null) {
            i = R.id.imagePrise;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.rarity))) != null) {
                return new EasterBattlepassPriseItemEventBinding((LinearLayout) rootView, frameLayout, imageView, findChildViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
