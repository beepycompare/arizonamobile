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
/* loaded from: classes3.dex */
public final class HudElementPaydayItemBinding implements ViewBinding {
    public final TextView bigText;
    public final TextView extraTitle;
    public final CustomCardView extraTitleCard;
    public final TextView extraValue;
    public final CustomCardView extraValueCard;
    public final ImageView image;
    public final CustomCardView innerCard;
    public final LinearLayout main;
    public final CustomCardView mainCard;
    public final FrameLayout promo;
    public final CustomCardView redCard;
    private final FrameLayout rootView;
    public final TextView title;
    public final TextView value;

    private HudElementPaydayItemBinding(FrameLayout rootView, TextView bigText, TextView extraTitle, CustomCardView extraTitleCard, TextView extraValue, CustomCardView extraValueCard, ImageView image, CustomCardView innerCard, LinearLayout main, CustomCardView mainCard, FrameLayout promo, CustomCardView redCard, TextView title, TextView value) {
        this.rootView = rootView;
        this.bigText = bigText;
        this.extraTitle = extraTitle;
        this.extraTitleCard = extraTitleCard;
        this.extraValue = extraValue;
        this.extraValueCard = extraValueCard;
        this.image = image;
        this.innerCard = innerCard;
        this.main = main;
        this.mainCard = mainCard;
        this.promo = promo;
        this.redCard = redCard;
        this.title = title;
        this.value = value;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudElementPaydayItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudElementPaydayItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_element_payday_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudElementPaydayItemBinding bind(View rootView) {
        int i = R.id.big_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.extra_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.extra_title_card;
                CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                if (customCardView != null) {
                    i = R.id.extra_value;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.extra_value_card;
                        CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                        if (customCardView2 != null) {
                            i = R.id.image;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView != null) {
                                i = R.id.inner_card;
                                CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                if (customCardView3 != null) {
                                    i = R.id.main;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (linearLayout != null) {
                                        i = R.id.main_card;
                                        CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                        if (customCardView4 != null) {
                                            FrameLayout frameLayout = (FrameLayout) rootView;
                                            i = R.id.red_card;
                                            CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                            if (customCardView5 != null) {
                                                i = R.id.title;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView4 != null) {
                                                    i = R.id.value;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView5 != null) {
                                                        return new HudElementPaydayItemBinding(frameLayout, textView, textView2, customCardView, textView3, customCardView2, imageView, customCardView3, linearLayout, customCardView4, frameLayout, customCardView5, textView4, textView5);
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
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
