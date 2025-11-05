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
/* loaded from: classes5.dex */
public final class HudElementPromoBinding implements ViewBinding {
    public final CustomCardView card;
    public final ImageView ic;
    public final ImageView ic2;
    public final CustomCardView labelContainer;
    public final LinearLayout main;
    public final TextView progress;
    public final FrameLayout promo;
    public final TextView promoText;
    private final FrameLayout rootView;
    public final TextView title;
    public final TextView topText;

    private HudElementPromoBinding(FrameLayout rootView, CustomCardView card, ImageView ic, ImageView ic2, CustomCardView labelContainer, LinearLayout main, TextView progress, FrameLayout promo, TextView promoText, TextView title, TextView topText) {
        this.rootView = rootView;
        this.card = card;
        this.ic = ic;
        this.ic2 = ic2;
        this.labelContainer = labelContainer;
        this.main = main;
        this.progress = progress;
        this.promo = promo;
        this.promoText = promoText;
        this.title = title;
        this.topText = topText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudElementPromoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudElementPromoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_element_promo, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudElementPromoBinding bind(View rootView) {
        int i = R.id.card;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
        if (customCardView != null) {
            i = R.id.ic;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.ic2;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView2 != null) {
                    i = R.id.label_container;
                    CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                    if (customCardView2 != null) {
                        i = R.id.main;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                        if (linearLayout != null) {
                            i = R.id.progress;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView != null) {
                                FrameLayout frameLayout = (FrameLayout) rootView;
                                i = R.id.promo_text;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView2 != null) {
                                    i = R.id.title;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView3 != null) {
                                        i = R.id.top_text;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView4 != null) {
                                            return new HudElementPromoBinding(frameLayout, customCardView, imageView, imageView2, customCardView2, linearLayout, textView, frameLayout, textView2, textView3, textView4);
                                        }
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
