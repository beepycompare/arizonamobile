package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class DonatePayPassPrizeBinding implements ViewBinding {
    public final CustomCardView paypassPrizeCard;
    public final TextView paypassPrizeCount;
    public final ImageView paypassPrizeImage;
    private final CustomCardView rootView;

    private DonatePayPassPrizeBinding(CustomCardView rootView, CustomCardView paypassPrizeCard, TextView paypassPrizeCount, ImageView paypassPrizeImage) {
        this.rootView = rootView;
        this.paypassPrizeCard = paypassPrizeCard;
        this.paypassPrizeCount = paypassPrizeCount;
        this.paypassPrizeImage = paypassPrizeImage;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static DonatePayPassPrizeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DonatePayPassPrizeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.donate_pay_pass_prize, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DonatePayPassPrizeBinding bind(View rootView) {
        CustomCardView customCardView = (CustomCardView) rootView;
        int i = R.id.paypass_prize_count;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.paypass_prize_image;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                return new DonatePayPassPrizeBinding(customCardView, customCardView, textView, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
