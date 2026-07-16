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
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class HudElementTimeItemBinding implements ViewBinding {
    public final ImageView image;
    public final CustomCardView innerCard;
    public final LinearLayout main;
    public final CustomCardView mainCard;
    public final TextView multiplier;
    public final CustomCardView multiplierCard;
    public final FrameLayout promo;
    private final FrameLayout rootView;
    public final TextView timer;
    public final TextView title;

    private HudElementTimeItemBinding(FrameLayout rootView, ImageView image, CustomCardView innerCard, LinearLayout main, CustomCardView mainCard, TextView multiplier, CustomCardView multiplierCard, FrameLayout promo, TextView timer, TextView title) {
        this.rootView = rootView;
        this.image = image;
        this.innerCard = innerCard;
        this.main = main;
        this.mainCard = mainCard;
        this.multiplier = multiplier;
        this.multiplierCard = multiplierCard;
        this.promo = promo;
        this.timer = timer;
        this.title = title;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudElementTimeItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudElementTimeItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_element_time_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudElementTimeItemBinding bind(View rootView) {
        int i = R.id.image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.inner_card;
            CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
            if (customCardView != null) {
                i = R.id.main;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                if (linearLayout != null) {
                    i = R.id.main_card;
                    CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                    if (customCardView2 != null) {
                        i = R.id.multiplier;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView != null) {
                            i = R.id.multiplier_card;
                            CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                            if (customCardView3 != null) {
                                FrameLayout frameLayout = (FrameLayout) rootView;
                                i = R.id.timer;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView2 != null) {
                                    i = R.id.title;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView3 != null) {
                                        return new HudElementTimeItemBinding(frameLayout, imageView, customCardView, linearLayout, customCardView2, textView, customCardView3, frameLayout, textView2, textView3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
