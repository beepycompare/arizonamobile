package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.elements.dialogs.views.DialogSignaturePadView;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class DialogSignBinding implements ViewBinding {
    public final CustomCardView background;
    public final CustomCardView bankCardSignatureConfirmButton;
    public final TextView bankCardSignatureConfirmButtonText;
    public final TextView bankCardSignatureHint;
    public final FrameLayout bankCardSignatureModalRoot;
    public final TextView bankCardSignatureModalTitle;
    public final DialogSignaturePadView bankCardSignaturePad;
    public final ImageView btnCancel;
    private final FrameLayout rootView;
    public final TextView tvBackground;
    public final TextView tvSignatureProgressValue;

    private DialogSignBinding(FrameLayout rootView, CustomCardView background, CustomCardView bankCardSignatureConfirmButton, TextView bankCardSignatureConfirmButtonText, TextView bankCardSignatureHint, FrameLayout bankCardSignatureModalRoot, TextView bankCardSignatureModalTitle, DialogSignaturePadView bankCardSignaturePad, ImageView btnCancel, TextView tvBackground, TextView tvSignatureProgressValue) {
        this.rootView = rootView;
        this.background = background;
        this.bankCardSignatureConfirmButton = bankCardSignatureConfirmButton;
        this.bankCardSignatureConfirmButtonText = bankCardSignatureConfirmButtonText;
        this.bankCardSignatureHint = bankCardSignatureHint;
        this.bankCardSignatureModalRoot = bankCardSignatureModalRoot;
        this.bankCardSignatureModalTitle = bankCardSignatureModalTitle;
        this.bankCardSignaturePad = bankCardSignaturePad;
        this.btnCancel = btnCancel;
        this.tvBackground = tvBackground;
        this.tvSignatureProgressValue = tvSignatureProgressValue;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogSignBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogSignBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_sign, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogSignBinding bind(View rootView) {
        int i = R.id.background;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
        if (customCardView != null) {
            i = R.id.bank_card_signature_confirm_button;
            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
            if (customCardView2 != null) {
                i = R.id.bank_card_signature_confirm_button_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.bank_card_signature_hint;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        FrameLayout frameLayout = (FrameLayout) rootView;
                        i = R.id.bank_card_signature_modal_title;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            i = R.id.bank_card_signature_pad;
                            DialogSignaturePadView dialogSignaturePadView = (DialogSignaturePadView) ViewBindings.findChildViewById(rootView, i);
                            if (dialogSignaturePadView != null) {
                                i = R.id.btn_cancel;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                if (imageView != null) {
                                    i = R.id.tv_background;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView4 != null) {
                                        i = R.id.tv_signature_progress_value;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView5 != null) {
                                            return new DialogSignBinding(frameLayout, customCardView, customCardView2, textView, textView2, frameLayout, textView3, dialogSignaturePadView, imageView, textView4, textView5);
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
