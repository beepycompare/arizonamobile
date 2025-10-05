package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import ru.mrlargha.commonui.R;
/* loaded from: classes3.dex */
public final class HudElementPromoBinding implements ViewBinding {
    public final MaterialCardView card;
    public final ImageView ic;
    public final ImageView ic2;
    public final LinearLayout main;
    public final TextView progress;
    public final MaterialCardView promo;
    private final MaterialCardView rootView;
    public final TextView title;
    public final TextView topText;

    private HudElementPromoBinding(MaterialCardView rootView, MaterialCardView card, ImageView ic, ImageView ic2, LinearLayout main, TextView progress, MaterialCardView promo, TextView title, TextView topText) {
        this.rootView = rootView;
        this.card = card;
        this.ic = ic;
        this.ic2 = ic2;
        this.main = main;
        this.progress = progress;
        this.promo = promo;
        this.title = title;
        this.topText = topText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
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
        MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(rootView, i);
        if (materialCardView != null) {
            i = R.id.ic;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.ic2;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView2 != null) {
                    i = R.id.main;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout != null) {
                        i = R.id.progress;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView != null) {
                            MaterialCardView materialCardView2 = (MaterialCardView) rootView;
                            i = R.id.title;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView2 != null) {
                                i = R.id.top_text;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView3 != null) {
                                    return new HudElementPromoBinding(materialCardView2, materialCardView, imageView, imageView2, linearLayout, textView, materialCardView2, textView2, textView3);
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
