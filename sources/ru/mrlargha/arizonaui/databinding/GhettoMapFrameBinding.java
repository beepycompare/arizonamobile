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
public final class GhettoMapFrameBinding implements ViewBinding {
    public final TextView balance;
    public final CardView bandCard;
    public final CardView buttonClose;
    public final CardView buttonEvent;
    public final TextView buttonEventText;
    public final CardView card1;
    public final LinearLayout containerBalance;
    public final LinearLayout containerFam;
    public final LinearLayout containerPlantBalance;
    public final LinearLayout containerPlantCount;
    public final LinearLayout containerRespect;
    public final TextView famName;
    public final ImageView logo;
    public final TextView plantBalance;
    public final TextView plantCount;
    public final TextView respect;
    private final LinearLayout rootView;
    public final TextView title;

    private GhettoMapFrameBinding(LinearLayout linearLayout, TextView textView, CardView cardView, CardView cardView2, CardView cardView3, TextView textView2, CardView cardView4, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, TextView textView3, ImageView imageView, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = linearLayout;
        this.balance = textView;
        this.bandCard = cardView;
        this.buttonClose = cardView2;
        this.buttonEvent = cardView3;
        this.buttonEventText = textView2;
        this.card1 = cardView4;
        this.containerBalance = linearLayout2;
        this.containerFam = linearLayout3;
        this.containerPlantBalance = linearLayout4;
        this.containerPlantCount = linearLayout5;
        this.containerRespect = linearLayout6;
        this.famName = textView3;
        this.logo = imageView;
        this.plantBalance = textView4;
        this.plantCount = textView5;
        this.respect = textView6;
        this.title = textView7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static GhettoMapFrameBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GhettoMapFrameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.ghetto_map_frame, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static GhettoMapFrameBinding bind(View view) {
        int i = R.id.balance;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.band_card;
            CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
            if (cardView != null) {
                i = R.id.button_close;
                CardView cardView2 = (CardView) ViewBindings.findChildViewById(view, i);
                if (cardView2 != null) {
                    i = R.id.button_event;
                    CardView cardView3 = (CardView) ViewBindings.findChildViewById(view, i);
                    if (cardView3 != null) {
                        i = R.id.button_event_text;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.card1;
                            CardView cardView4 = (CardView) ViewBindings.findChildViewById(view, i);
                            if (cardView4 != null) {
                                i = R.id.container_balance;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    i = R.id.container_fam;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout2 != null) {
                                        i = R.id.container_plant_balance;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout3 != null) {
                                            i = R.id.container_plant_count;
                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout4 != null) {
                                                i = R.id.container_respect;
                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout5 != null) {
                                                    i = R.id.fam_name;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null) {
                                                        i = R.id.logo;
                                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView != null) {
                                                            i = R.id.plant_balance;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null) {
                                                                i = R.id.plant_count;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView5 != null) {
                                                                    i = R.id.respect;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView6 != null) {
                                                                        i = R.id.title;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView7 != null) {
                                                                            return new GhettoMapFrameBinding((LinearLayout) view, textView, cardView, cardView2, cardView3, textView2, cardView4, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, textView3, imageView, textView4, textView5, textView6, textView7);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
