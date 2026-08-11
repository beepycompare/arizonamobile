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
/* loaded from: classes6.dex */
public final class GhettoMapFrameBinding implements ViewBinding {
    public final TextView balance;
    public final CardView bandCard;
    public final TextView businessName;
    public final CardView buttonClose;
    public final CardView buttonEvent;
    public final TextView buttonEventText;
    public final CardView card1;
    public final LinearLayout containerBalance;
    public final LinearLayout containerBusiness;
    public final LinearLayout containerDrugs;
    public final LinearLayout containerFam;
    public final LinearLayout containerPayday;
    public final LinearLayout containerPlantBalance;
    public final LinearLayout containerPlantCount;
    public final LinearLayout containerRespect;
    public final TextView drugsCount;
    public final TextView famName;
    public final ImageView logo;
    public final TextView paydayMoney;
    public final TextView plantBalance;
    public final TextView plantCount;
    public final TextView respect;
    private final LinearLayout rootView;
    public final TextView title;

    private GhettoMapFrameBinding(LinearLayout linearLayout, TextView textView, CardView cardView, TextView textView2, CardView cardView2, CardView cardView3, TextView textView3, CardView cardView4, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, LinearLayout linearLayout9, TextView textView4, TextView textView5, ImageView imageView, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10) {
        this.rootView = linearLayout;
        this.balance = textView;
        this.bandCard = cardView;
        this.businessName = textView2;
        this.buttonClose = cardView2;
        this.buttonEvent = cardView3;
        this.buttonEventText = textView3;
        this.card1 = cardView4;
        this.containerBalance = linearLayout2;
        this.containerBusiness = linearLayout3;
        this.containerDrugs = linearLayout4;
        this.containerFam = linearLayout5;
        this.containerPayday = linearLayout6;
        this.containerPlantBalance = linearLayout7;
        this.containerPlantCount = linearLayout8;
        this.containerRespect = linearLayout9;
        this.drugsCount = textView4;
        this.famName = textView5;
        this.logo = imageView;
        this.paydayMoney = textView6;
        this.plantBalance = textView7;
        this.plantCount = textView8;
        this.respect = textView9;
        this.title = textView10;
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
                i = R.id.business_name;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.button_close;
                    CardView cardView2 = (CardView) ViewBindings.findChildViewById(view, i);
                    if (cardView2 != null) {
                        i = R.id.button_event;
                        CardView cardView3 = (CardView) ViewBindings.findChildViewById(view, i);
                        if (cardView3 != null) {
                            i = R.id.button_event_text;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.card1;
                                CardView cardView4 = (CardView) ViewBindings.findChildViewById(view, i);
                                if (cardView4 != null) {
                                    i = R.id.container_balance;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout != null) {
                                        i = R.id.container_business;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout2 != null) {
                                            i = R.id.container_drugs;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout3 != null) {
                                                i = R.id.container_fam;
                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout4 != null) {
                                                    i = R.id.container_payday;
                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout5 != null) {
                                                        i = R.id.container_plant_balance;
                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout6 != null) {
                                                            i = R.id.container_plant_count;
                                                            LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                            if (linearLayout7 != null) {
                                                                i = R.id.container_respect;
                                                                LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                if (linearLayout8 != null) {
                                                                    i = R.id.drugs_count;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView4 != null) {
                                                                        i = R.id.fam_name;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView5 != null) {
                                                                            i = R.id.logo;
                                                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                            if (imageView != null) {
                                                                                i = R.id.payday_money;
                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView6 != null) {
                                                                                    i = R.id.plant_balance;
                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView7 != null) {
                                                                                        i = R.id.plant_count;
                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView8 != null) {
                                                                                            i = R.id.respect;
                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView9 != null) {
                                                                                                i = R.id.title;
                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView10 != null) {
                                                                                                    return new GhettoMapFrameBinding((LinearLayout) view, textView, cardView, textView2, cardView2, cardView3, textView3, cardView4, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, textView4, textView5, imageView, textView6, textView7, textView8, textView9, textView10);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
