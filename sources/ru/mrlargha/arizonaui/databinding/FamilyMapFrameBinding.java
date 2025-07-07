package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class FamilyMapFrameBinding implements ViewBinding {
    public final TextView balance;
    public final TextView businessTitle;
    public final CardView buttonClose;
    public final CardView buttonEvent;
    public final CardView card1;
    public final TextView coins;
    public final LinearLayout containerBalance;
    public final LinearLayout containerBusiness;
    public final LinearLayout containerCoins;
    public final LinearLayout containerFam;
    public final TextView famName;
    public final ImageView flag;
    public final ImageView logo;
    private final LinearLayout rootView;
    public final TextView title;

    private FamilyMapFrameBinding(LinearLayout linearLayout, TextView textView, TextView textView2, CardView cardView, CardView cardView2, CardView cardView3, TextView textView3, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, TextView textView4, ImageView imageView, ImageView imageView2, TextView textView5) {
        this.rootView = linearLayout;
        this.balance = textView;
        this.businessTitle = textView2;
        this.buttonClose = cardView;
        this.buttonEvent = cardView2;
        this.card1 = cardView3;
        this.coins = textView3;
        this.containerBalance = linearLayout2;
        this.containerBusiness = linearLayout3;
        this.containerCoins = linearLayout4;
        this.containerFam = linearLayout5;
        this.famName = textView4;
        this.flag = imageView;
        this.logo = imageView2;
        this.title = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FamilyMapFrameBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FamilyMapFrameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.family_map_frame, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamilyMapFrameBinding bind(View view) {
        int i = R.id.balance;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.business_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.button_close;
                CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
                if (cardView != null) {
                    i = R.id.button_event;
                    CardView cardView2 = (CardView) ViewBindings.findChildViewById(view, i);
                    if (cardView2 != null) {
                        i = R.id.card1;
                        CardView cardView3 = (CardView) ViewBindings.findChildViewById(view, i);
                        if (cardView3 != null) {
                            i = R.id.coins;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.container_balance;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    i = R.id.container_business;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout2 != null) {
                                        i = R.id.container_coins;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout3 != null) {
                                            i = R.id.container_fam;
                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout4 != null) {
                                                i = R.id.fam_name;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    i = R.id.flag;
                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView != null) {
                                                        i = R.id.logo;
                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView2 != null) {
                                                            i = R.id.title;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView5 != null) {
                                                                return new FamilyMapFrameBinding((LinearLayout) view, textView, textView2, cardView, cardView2, cardView3, textView3, linearLayout, linearLayout2, linearLayout3, linearLayout4, textView4, imageView, imageView2, textView5);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
