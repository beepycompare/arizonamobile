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
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class DialogWithdrawBinding implements ViewBinding {
    public final ImageView btnCancel;
    public final CustomCardView btnMinusK;
    public final CustomCardView btnMinusKk;
    public final CustomCardView btnMinusM;
    public final CustomCardView btnPlusK;
    public final CustomCardView btnPlusKk;
    public final CustomCardView btnPlusM;
    public final DialogButtonsBinding buttons;
    public final TextView caption;
    public final CustomCardView cardViewK;
    public final CustomCardView cardViewKk;
    public final CustomCardView cardViewM;
    public final EditText etK;
    public final EditText etKk;
    public final EditText etM;
    public final TextView infoText;
    public final LinearLayout kContainer;
    public final LinearLayout kkContainer;
    public final LinearLayout mContainer;
    private final FrameLayout rootView;
    public final TextView tvError;
    public final FrameLayout withdraw;

    private DialogWithdrawBinding(FrameLayout rootView, ImageView btnCancel, CustomCardView btnMinusK, CustomCardView btnMinusKk, CustomCardView btnMinusM, CustomCardView btnPlusK, CustomCardView btnPlusKk, CustomCardView btnPlusM, DialogButtonsBinding buttons, TextView caption, CustomCardView cardViewK, CustomCardView cardViewKk, CustomCardView cardViewM, EditText etK, EditText etKk, EditText etM, TextView infoText, LinearLayout kContainer, LinearLayout kkContainer, LinearLayout mContainer, TextView tvError, FrameLayout withdraw) {
        this.rootView = rootView;
        this.btnCancel = btnCancel;
        this.btnMinusK = btnMinusK;
        this.btnMinusKk = btnMinusKk;
        this.btnMinusM = btnMinusM;
        this.btnPlusK = btnPlusK;
        this.btnPlusKk = btnPlusKk;
        this.btnPlusM = btnPlusM;
        this.buttons = buttons;
        this.caption = caption;
        this.cardViewK = cardViewK;
        this.cardViewKk = cardViewKk;
        this.cardViewM = cardViewM;
        this.etK = etK;
        this.etKk = etKk;
        this.etM = etM;
        this.infoText = infoText;
        this.kContainer = kContainer;
        this.kkContainer = kkContainer;
        this.mContainer = mContainer;
        this.tvError = tvError;
        this.withdraw = withdraw;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogWithdrawBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogWithdrawBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_withdraw, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogWithdrawBinding bind(View rootView) {
        View findChildViewById;
        int i = R.id.btn_cancel;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.btn_minus_k;
            CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
            if (customCardView != null) {
                i = R.id.btn_minus_kk;
                CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                if (customCardView2 != null) {
                    i = R.id.btn_minus_m;
                    CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                    if (customCardView3 != null) {
                        i = R.id.btn_plus_k;
                        CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                        if (customCardView4 != null) {
                            i = R.id.btn_plus_kk;
                            CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                            if (customCardView5 != null) {
                                i = R.id.btn_plus_m;
                                CustomCardView customCardView6 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                if (customCardView6 != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.buttons))) != null) {
                                    DialogButtonsBinding bind = DialogButtonsBinding.bind(findChildViewById);
                                    i = R.id.caption;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView != null) {
                                        i = R.id.card_view_k;
                                        CustomCardView customCardView7 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                        if (customCardView7 != null) {
                                            i = R.id.card_view_kk;
                                            CustomCardView customCardView8 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                            if (customCardView8 != null) {
                                                i = R.id.card_view_m;
                                                CustomCardView customCardView9 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                                if (customCardView9 != null) {
                                                    i = R.id.et_k;
                                                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, i);
                                                    if (editText != null) {
                                                        i = R.id.et_kk;
                                                        EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, i);
                                                        if (editText2 != null) {
                                                            i = R.id.et_m;
                                                            EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, i);
                                                            if (editText3 != null) {
                                                                i = R.id.infoText;
                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                if (textView2 != null) {
                                                                    i = R.id.k_container;
                                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                    if (linearLayout != null) {
                                                                        i = R.id.kk_container;
                                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                        if (linearLayout2 != null) {
                                                                            i = R.id.m_container;
                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                            if (linearLayout3 != null) {
                                                                                i = R.id.tv_error;
                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                if (textView3 != null) {
                                                                                    FrameLayout frameLayout = (FrameLayout) rootView;
                                                                                    return new DialogWithdrawBinding(frameLayout, imageView, customCardView, customCardView2, customCardView3, customCardView4, customCardView5, customCardView6, bind, textView, customCardView7, customCardView8, customCardView9, editText, editText2, editText3, textView2, linearLayout, linearLayout2, linearLayout3, textView3, frameLayout);
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
