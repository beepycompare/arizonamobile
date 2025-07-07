package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class BannerElementBinding implements ViewBinding {
    public final CardView banner;
    public final ImageView bgImg;
    public final CardView buttonCard;
    public final ImageView buttonIc;
    public final TextView buttonText;
    public final ImageView clockIc;
    public final FrameLayout main;
    public final ImageView rootBg;
    private final CardView rootView;
    public final TextView time;
    public final CardView timerCard;
    public final TextView title;

    private BannerElementBinding(CardView rootView, CardView banner, ImageView bgImg, CardView buttonCard, ImageView buttonIc, TextView buttonText, ImageView clockIc, FrameLayout main, ImageView rootBg, TextView time, CardView timerCard, TextView title) {
        this.rootView = rootView;
        this.banner = banner;
        this.bgImg = bgImg;
        this.buttonCard = buttonCard;
        this.buttonIc = buttonIc;
        this.buttonText = buttonText;
        this.clockIc = clockIc;
        this.main = main;
        this.rootBg = rootBg;
        this.time = time;
        this.timerCard = timerCard;
        this.title = title;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static BannerElementBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BannerElementBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.banner_element, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static BannerElementBinding bind(View rootView) {
        CardView cardView = (CardView) rootView;
        int i = R.id.bg_img;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.button_card;
            CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, i);
            if (cardView2 != null) {
                i = R.id.button_ic;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView2 != null) {
                    i = R.id.button_text;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null) {
                        i = R.id.clock_ic;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView3 != null) {
                            i = R.id.main;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                            if (frameLayout != null) {
                                i = R.id.rootBg;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                if (imageView4 != null) {
                                    i = R.id.time;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView2 != null) {
                                        i = R.id.timer_card;
                                        CardView cardView3 = (CardView) ViewBindings.findChildViewById(rootView, i);
                                        if (cardView3 != null) {
                                            i = R.id.title;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView3 != null) {
                                                return new BannerElementBinding(cardView, cardView, imageView, cardView2, imageView2, textView, imageView3, frameLayout, imageView4, textView2, cardView3, textView3);
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
