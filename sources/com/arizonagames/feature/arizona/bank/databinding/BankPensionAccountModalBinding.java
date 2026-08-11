package com.arizonagames.feature.arizona.bank.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizonagames.feature.arizona.bank.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class BankPensionAccountModalBinding implements ViewBinding {
    public final FrameLayout bankPensionAccountModal;
    public final CustomCardView bankPensionAccountModalBack;
    public final CustomCardView bankPensionAccountModalCheckbox;
    public final CustomCardView bankPensionAccountModalCheckboxContainer;
    public final TextView bankPensionAccountModalCheckboxText;
    public final ImageView bankPensionAccountModalClose;
    public final CustomCardView bankPensionAccountModalConfirm;
    public final TextView bankPensionAccountModalPrice;
    public final TextView bankPensionAccountModalSubtitle;
    public final TextView bankPensionAccountModalTitle;
    private final FrameLayout rootView;

    private BankPensionAccountModalBinding(FrameLayout frameLayout, FrameLayout frameLayout2, CustomCardView customCardView, CustomCardView customCardView2, CustomCardView customCardView3, TextView textView, ImageView imageView, CustomCardView customCardView4, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = frameLayout;
        this.bankPensionAccountModal = frameLayout2;
        this.bankPensionAccountModalBack = customCardView;
        this.bankPensionAccountModalCheckbox = customCardView2;
        this.bankPensionAccountModalCheckboxContainer = customCardView3;
        this.bankPensionAccountModalCheckboxText = textView;
        this.bankPensionAccountModalClose = imageView;
        this.bankPensionAccountModalConfirm = customCardView4;
        this.bankPensionAccountModalPrice = textView2;
        this.bankPensionAccountModalSubtitle = textView3;
        this.bankPensionAccountModalTitle = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BankPensionAccountModalBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BankPensionAccountModalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bank_pension_account_modal, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BankPensionAccountModalBinding bind(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i = R.id.bank_pension_account_modal_back;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
        if (customCardView != null) {
            i = R.id.bank_pension_account_modal_checkbox;
            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
            if (customCardView2 != null) {
                i = R.id.bank_pension_account_modal_checkbox_container;
                CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView3 != null) {
                    i = R.id.bank_pension_account_modal_checkbox_text;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.bank_pension_account_modal_close;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R.id.bank_pension_account_modal_confirm;
                            CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                            if (customCardView4 != null) {
                                i = R.id.bank_pension_account_modal_price;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.bank_pension_account_modal_subtitle;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.bank_pension_account_modal_title;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            return new BankPensionAccountModalBinding(frameLayout, frameLayout, customCardView, customCardView2, customCardView3, textView, imageView, customCardView4, textView2, textView3, textView4);
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
