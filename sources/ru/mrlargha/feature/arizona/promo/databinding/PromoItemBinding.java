package ru.mrlargha.feature.arizona.promo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.arizona.promo.R;
/* loaded from: classes5.dex */
public final class PromoItemBinding implements ViewBinding {
    public final CardView available;
    public final TextView bottomText;
    public final CustomCardView buttonCard;
    public final MaterialCardView buttonDone;
    public final TextView buttonGet;
    private final FrameLayout rootView;
    public final RecyclerView rv;
    public final LinearLayout timerContainer;
    public final ImageView timerIc;
    public final TextView timerText;
    public final TextView timerText2;
    public final TextView title;

    private PromoItemBinding(FrameLayout frameLayout, CardView cardView, TextView textView, CustomCardView customCardView, MaterialCardView materialCardView, TextView textView2, RecyclerView recyclerView, LinearLayout linearLayout, ImageView imageView, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = frameLayout;
        this.available = cardView;
        this.bottomText = textView;
        this.buttonCard = customCardView;
        this.buttonDone = materialCardView;
        this.buttonGet = textView2;
        this.rv = recyclerView;
        this.timerContainer = linearLayout;
        this.timerIc = imageView;
        this.timerText = textView3;
        this.timerText2 = textView4;
        this.title = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static PromoItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PromoItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.promo_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PromoItemBinding bind(View view) {
        int i = R.id.available;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
        if (cardView != null) {
            i = R.id.bottom_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.button_card;
                CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView != null) {
                    i = R.id.button_done;
                    MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(view, i);
                    if (materialCardView != null) {
                        i = R.id.button_get;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.rv;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                            if (recyclerView != null) {
                                i = R.id.timer_container;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    i = R.id.timer_ic;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView != null) {
                                        i = R.id.timer_text;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = R.id.timer_text2;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView4 != null) {
                                                i = R.id.title;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    return new PromoItemBinding((FrameLayout) view, cardView, textView, customCardView, materialCardView, textView2, recyclerView, linearLayout, imageView, textView3, textView4, textView5);
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
