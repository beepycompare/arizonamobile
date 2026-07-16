package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputLayout;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class DialogBuyCryptoBinding implements ViewBinding {
    public final EditText amountInput;
    public final TextInputLayout amountInputLayout;
    public final TextView amountSuffix;
    public final CustomCardView availabilityCard;
    public final TextView availabilityText;
    public final TextView bodyText;
    public final ImageView btnCancel;
    public final TextView caption;
    public final FrameLayout dialogBuyCryptoLayout;
    public final LinearLayout headerInfoContainer;
    public final TextView headerInfoLabel;
    public final TextView headerInfoValue;
    public final ImageView ivCurrency;
    public final CustomCardView primaryButton;
    public final TextView primaryButtonText;
    private final FrameLayout rootView;
    public final CustomCardView secondaryButton;
    public final TextView secondaryButtonText;
    public final CustomCardView summaryCardDollars;
    public final TextView summaryDollars;
    public final TextView validationText;

    private DialogBuyCryptoBinding(FrameLayout rootView, EditText amountInput, TextInputLayout amountInputLayout, TextView amountSuffix, CustomCardView availabilityCard, TextView availabilityText, TextView bodyText, ImageView btnCancel, TextView caption, FrameLayout dialogBuyCryptoLayout, LinearLayout headerInfoContainer, TextView headerInfoLabel, TextView headerInfoValue, ImageView ivCurrency, CustomCardView primaryButton, TextView primaryButtonText, CustomCardView secondaryButton, TextView secondaryButtonText, CustomCardView summaryCardDollars, TextView summaryDollars, TextView validationText) {
        this.rootView = rootView;
        this.amountInput = amountInput;
        this.amountInputLayout = amountInputLayout;
        this.amountSuffix = amountSuffix;
        this.availabilityCard = availabilityCard;
        this.availabilityText = availabilityText;
        this.bodyText = bodyText;
        this.btnCancel = btnCancel;
        this.caption = caption;
        this.dialogBuyCryptoLayout = dialogBuyCryptoLayout;
        this.headerInfoContainer = headerInfoContainer;
        this.headerInfoLabel = headerInfoLabel;
        this.headerInfoValue = headerInfoValue;
        this.ivCurrency = ivCurrency;
        this.primaryButton = primaryButton;
        this.primaryButtonText = primaryButtonText;
        this.secondaryButton = secondaryButton;
        this.secondaryButtonText = secondaryButtonText;
        this.summaryCardDollars = summaryCardDollars;
        this.summaryDollars = summaryDollars;
        this.validationText = validationText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogBuyCryptoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogBuyCryptoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_buy_crypto, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogBuyCryptoBinding bind(View rootView) {
        int i = R.id.amount_input;
        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, i);
        if (editText != null) {
            i = R.id.amount_input_layout;
            TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(rootView, i);
            if (textInputLayout != null) {
                i = R.id.amount_suffix;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.availability_card;
                    CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                    if (customCardView != null) {
                        i = R.id.availability_text;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            i = R.id.body_text;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView3 != null) {
                                i = R.id.btn_cancel;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                if (imageView != null) {
                                    i = R.id.caption;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView4 != null) {
                                        FrameLayout frameLayout = (FrameLayout) rootView;
                                        i = R.id.header_info_container;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (linearLayout != null) {
                                            i = R.id.header_info_label;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView5 != null) {
                                                i = R.id.header_info_value;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView6 != null) {
                                                    i = R.id.iv_currency;
                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                    if (imageView2 != null) {
                                                        i = R.id.primary_button;
                                                        CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                                        if (customCardView2 != null) {
                                                            i = R.id.primary_button_text;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView7 != null) {
                                                                i = R.id.secondary_button;
                                                                CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                                                if (customCardView3 != null) {
                                                                    i = R.id.secondary_button_text;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (textView8 != null) {
                                                                        i = R.id.summary_card_dollars;
                                                                        CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (customCardView4 != null) {
                                                                            i = R.id.summary_dollars;
                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (textView9 != null) {
                                                                                i = R.id.validation_text;
                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                if (textView10 != null) {
                                                                                    return new DialogBuyCryptoBinding(frameLayout, editText, textInputLayout, textView, customCardView, textView2, textView3, imageView, textView4, frameLayout, linearLayout, textView5, textView6, imageView2, customCardView2, textView7, customCardView3, textView8, customCardView4, textView9, textView10);
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
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
