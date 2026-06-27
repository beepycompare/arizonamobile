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
/* loaded from: classes6.dex */
public final class DialogWithdrawBinding implements ViewBinding {
    public final ImageView btnCancel;
    public final CustomCardView btnMinus;
    public final CustomCardView btnPlus;
    public final DialogButtonsBinding buttons;
    public final TextView caption;
    public final CustomCardView cardViewMoney;
    public final EditText etMoney;
    public final TextView infoText;
    public final LinearLayout moneyContainer;
    private final FrameLayout rootView;
    public final TextView tvError;
    public final FrameLayout withdraw;

    private DialogWithdrawBinding(FrameLayout rootView, ImageView btnCancel, CustomCardView btnMinus, CustomCardView btnPlus, DialogButtonsBinding buttons, TextView caption, CustomCardView cardViewMoney, EditText etMoney, TextView infoText, LinearLayout moneyContainer, TextView tvError, FrameLayout withdraw) {
        this.rootView = rootView;
        this.btnCancel = btnCancel;
        this.btnMinus = btnMinus;
        this.btnPlus = btnPlus;
        this.buttons = buttons;
        this.caption = caption;
        this.cardViewMoney = cardViewMoney;
        this.etMoney = etMoney;
        this.infoText = infoText;
        this.moneyContainer = moneyContainer;
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
            i = R.id.btn_minus;
            CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
            if (customCardView != null) {
                i = R.id.btn_plus;
                CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                if (customCardView2 != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.buttons))) != null) {
                    DialogButtonsBinding bind = DialogButtonsBinding.bind(findChildViewById);
                    i = R.id.caption;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null) {
                        i = R.id.card_view_money;
                        CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                        if (customCardView3 != null) {
                            i = R.id.et_money;
                            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, i);
                            if (editText != null) {
                                i = R.id.infoText;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView2 != null) {
                                    i = R.id.money_container;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (linearLayout != null) {
                                        i = R.id.tv_error;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView3 != null) {
                                            FrameLayout frameLayout = (FrameLayout) rootView;
                                            return new DialogWithdrawBinding(frameLayout, imageView, customCardView, customCardView2, bind, textView, customCardView3, editText, textView2, linearLayout, textView3, frameLayout);
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
