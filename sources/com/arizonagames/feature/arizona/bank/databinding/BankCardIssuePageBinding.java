package com.arizonagames.feature.arizona.bank.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizonagames.feature.arizona.bank.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class BankCardIssuePageBinding implements ViewBinding {
    public final NestedScrollView bankCardIssueFormContent;
    public final TextView bankCardIssueHeaderText;
    public final CustomCardView bankCardIssueIdentityCard;
    public final CustomCardView bankCardIssueIdentityCheck;
    public final ImageView bankCardIssueIdentityCheckmark;
    public final TextView bankCardIssueIdentityTitle;
    public final TextView bankCardIssueIdentityValue;
    public final CustomCardView bankCardIssueIntroButton;
    public final FrameLayout bankCardIssueIntroState;
    public final CustomCardView bankCardIssuePolicyCard;
    public final CustomCardView bankCardIssuePolicyCheck;
    public final ImageView bankCardIssuePolicyCheckmark;
    public final TextView bankCardIssuePolicyText;
    public final CustomCardView bankCardIssueSignature;
    public final CustomCardView bankCardIssueSignatureCard;
    public final CustomCardView bankCardIssueSignatureCheck;
    public final TextView bankCardIssueSignatureText;
    public final CustomCardView bankCardIssueSubmitButton;
    public final TextView bankCardIssueSubmitButtonText;
    private final FrameLayout rootView;

    private BankCardIssuePageBinding(FrameLayout frameLayout, NestedScrollView nestedScrollView, TextView textView, CustomCardView customCardView, CustomCardView customCardView2, ImageView imageView, TextView textView2, TextView textView3, CustomCardView customCardView3, FrameLayout frameLayout2, CustomCardView customCardView4, CustomCardView customCardView5, ImageView imageView2, TextView textView4, CustomCardView customCardView6, CustomCardView customCardView7, CustomCardView customCardView8, TextView textView5, CustomCardView customCardView9, TextView textView6) {
        this.rootView = frameLayout;
        this.bankCardIssueFormContent = nestedScrollView;
        this.bankCardIssueHeaderText = textView;
        this.bankCardIssueIdentityCard = customCardView;
        this.bankCardIssueIdentityCheck = customCardView2;
        this.bankCardIssueIdentityCheckmark = imageView;
        this.bankCardIssueIdentityTitle = textView2;
        this.bankCardIssueIdentityValue = textView3;
        this.bankCardIssueIntroButton = customCardView3;
        this.bankCardIssueIntroState = frameLayout2;
        this.bankCardIssuePolicyCard = customCardView4;
        this.bankCardIssuePolicyCheck = customCardView5;
        this.bankCardIssuePolicyCheckmark = imageView2;
        this.bankCardIssuePolicyText = textView4;
        this.bankCardIssueSignature = customCardView6;
        this.bankCardIssueSignatureCard = customCardView7;
        this.bankCardIssueSignatureCheck = customCardView8;
        this.bankCardIssueSignatureText = textView5;
        this.bankCardIssueSubmitButton = customCardView9;
        this.bankCardIssueSubmitButtonText = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BankCardIssuePageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BankCardIssuePageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bank_card_issue_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BankCardIssuePageBinding bind(View view) {
        int i = R.id.bank_card_issue_form_content;
        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i);
        if (nestedScrollView != null) {
            i = R.id.bank_card_issue_header_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.bank_card_issue_identity_card;
                CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView != null) {
                    i = R.id.bank_card_issue_identity_check;
                    CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                    if (customCardView2 != null) {
                        i = R.id.bank_card_issue_identity_checkmark;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R.id.bank_card_issue_identity_title;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.bank_card_issue_identity_value;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.bank_card_issue_intro_button;
                                    CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                    if (customCardView3 != null) {
                                        i = R.id.bank_card_issue_intro_state;
                                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                        if (frameLayout != null) {
                                            i = R.id.bank_card_issue_policy_card;
                                            CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                            if (customCardView4 != null) {
                                                i = R.id.bank_card_issue_policy_check;
                                                CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                if (customCardView5 != null) {
                                                    i = R.id.bank_card_issue_policy_checkmark;
                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView2 != null) {
                                                        i = R.id.bank_card_issue_policy_text;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView4 != null) {
                                                            i = R.id.bank_card_issue_signature;
                                                            CustomCardView customCardView6 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                            if (customCardView6 != null) {
                                                                i = R.id.bank_card_issue_signature_card;
                                                                CustomCardView customCardView7 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                if (customCardView7 != null) {
                                                                    i = R.id.bank_card_issue_signature_check;
                                                                    CustomCardView customCardView8 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                    if (customCardView8 != null) {
                                                                        i = R.id.bank_card_issue_signature_text;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView5 != null) {
                                                                            i = R.id.bank_card_issue_submit_button;
                                                                            CustomCardView customCardView9 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                            if (customCardView9 != null) {
                                                                                i = R.id.bank_card_issue_submit_button_text;
                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView6 != null) {
                                                                                    return new BankCardIssuePageBinding((FrameLayout) view, nestedScrollView, textView, customCardView, customCardView2, imageView, textView2, textView3, customCardView3, frameLayout, customCardView4, customCardView5, imageView2, textView4, customCardView6, customCardView7, customCardView8, textView5, customCardView9, textView6);
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
