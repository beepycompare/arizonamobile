package ru.mrlargha.feature.arizona.promo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.arizona.promo.R;
/* loaded from: classes6.dex */
public final class TopbarBinding implements ViewBinding {
    public final MaterialCardView activateCard;
    public final TextView activateText;
    public final MaterialCardView close;
    public final TextView coins;
    public final ImageView coinsIc;
    public final CustomCardView getButton;
    public final MaterialCardView managementCard;
    public final TextView managementText;
    public final LinearLayout navContainer;
    public final TextView refs;
    public final MaterialCardView refsCard;
    private final LinearLayout rootView;

    private TopbarBinding(LinearLayout linearLayout, MaterialCardView materialCardView, TextView textView, MaterialCardView materialCardView2, TextView textView2, ImageView imageView, CustomCardView customCardView, MaterialCardView materialCardView3, TextView textView3, LinearLayout linearLayout2, TextView textView4, MaterialCardView materialCardView4) {
        this.rootView = linearLayout;
        this.activateCard = materialCardView;
        this.activateText = textView;
        this.close = materialCardView2;
        this.coins = textView2;
        this.coinsIc = imageView;
        this.getButton = customCardView;
        this.managementCard = materialCardView3;
        this.managementText = textView3;
        this.navContainer = linearLayout2;
        this.refs = textView4;
        this.refsCard = materialCardView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TopbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TopbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.topbar, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TopbarBinding bind(View view) {
        int i = R.id.activate_card;
        MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(view, i);
        if (materialCardView != null) {
            i = R.id.activate_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.close;
                MaterialCardView materialCardView2 = (MaterialCardView) ViewBindings.findChildViewById(view, i);
                if (materialCardView2 != null) {
                    i = R.id.coins;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.coins_ic;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R.id.get_button;
                            CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
                            if (customCardView != null) {
                                i = R.id.management_card;
                                MaterialCardView materialCardView3 = (MaterialCardView) ViewBindings.findChildViewById(view, i);
                                if (materialCardView3 != null) {
                                    i = R.id.management_text;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.nav_container;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout != null) {
                                            i = R.id.refs;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView4 != null) {
                                                i = R.id.refs_card;
                                                MaterialCardView materialCardView4 = (MaterialCardView) ViewBindings.findChildViewById(view, i);
                                                if (materialCardView4 != null) {
                                                    return new TopbarBinding((LinearLayout) view, materialCardView, textView, materialCardView2, textView2, imageView, customCardView, materialCardView3, textView3, linearLayout, textView4, materialCardView4);
                                                }
                                            }
                                        }
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
