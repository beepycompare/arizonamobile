package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputLayout;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class InputDialogBinding implements ViewBinding {
    public final CustomCardView btnEmoji;
    public final DialogButtonsBinding buttons;
    public final TextView caption;
    public final EditText findPlayerInput;
    public final CustomCardView findPlayerInputContainer;
    public final LinearLayout findPlayerInputRow;
    public final TextInputLayout findPlayerTextInputLayout;
    public final TextView findPlayerTitle;
    public final TextView headerInfoBadge;
    public final LinearLayout headerInfoContainer;
    public final TextView headerInfoText;
    public final FrameLayout infoDialogLayout;
    public final TextView infoText;
    public final CustomCardView inputContainer;
    public final LinearLayout moneyInputRow;
    public final TextView moneyTitle;
    public final LinearLayout moneyTitleContainer;
    private final FrameLayout rootView;
    public final TextInputLayout textInputLayout;
    public final LinearLayout transferCommissionContainer;
    public final TextView transferCommissionText;
    public final TextView transferCommissionValue;
    public final EditText userInput;

    private InputDialogBinding(FrameLayout rootView, CustomCardView btnEmoji, DialogButtonsBinding buttons, TextView caption, EditText findPlayerInput, CustomCardView findPlayerInputContainer, LinearLayout findPlayerInputRow, TextInputLayout findPlayerTextInputLayout, TextView findPlayerTitle, TextView headerInfoBadge, LinearLayout headerInfoContainer, TextView headerInfoText, FrameLayout infoDialogLayout, TextView infoText, CustomCardView inputContainer, LinearLayout moneyInputRow, TextView moneyTitle, LinearLayout moneyTitleContainer, TextInputLayout textInputLayout, LinearLayout transferCommissionContainer, TextView transferCommissionText, TextView transferCommissionValue, EditText userInput) {
        this.rootView = rootView;
        this.btnEmoji = btnEmoji;
        this.buttons = buttons;
        this.caption = caption;
        this.findPlayerInput = findPlayerInput;
        this.findPlayerInputContainer = findPlayerInputContainer;
        this.findPlayerInputRow = findPlayerInputRow;
        this.findPlayerTextInputLayout = findPlayerTextInputLayout;
        this.findPlayerTitle = findPlayerTitle;
        this.headerInfoBadge = headerInfoBadge;
        this.headerInfoContainer = headerInfoContainer;
        this.headerInfoText = headerInfoText;
        this.infoDialogLayout = infoDialogLayout;
        this.infoText = infoText;
        this.inputContainer = inputContainer;
        this.moneyInputRow = moneyInputRow;
        this.moneyTitle = moneyTitle;
        this.moneyTitleContainer = moneyTitleContainer;
        this.textInputLayout = textInputLayout;
        this.transferCommissionContainer = transferCommissionContainer;
        this.transferCommissionText = transferCommissionText;
        this.transferCommissionValue = transferCommissionValue;
        this.userInput = userInput;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static InputDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static InputDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.input_dialog, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static InputDialogBinding bind(View rootView) {
        View findChildViewById;
        int i = R.id.btn_emoji;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
        if (customCardView != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.buttons))) != null) {
            DialogButtonsBinding bind = DialogButtonsBinding.bind(findChildViewById);
            i = R.id.caption;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.find_player_input;
                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, i);
                if (editText != null) {
                    i = R.id.find_player_input_container;
                    CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                    if (customCardView2 != null) {
                        i = R.id.find_player_input_row;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                        if (linearLayout != null) {
                            i = R.id.find_player_text_input_layout;
                            TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(rootView, i);
                            if (textInputLayout != null) {
                                i = R.id.find_player_title;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView2 != null) {
                                    i = R.id.header_info_badge;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView3 != null) {
                                        i = R.id.header_info_container;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (linearLayout2 != null) {
                                            i = R.id.header_info_text;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView4 != null) {
                                                FrameLayout frameLayout = (FrameLayout) rootView;
                                                i = R.id.infoText;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView5 != null) {
                                                    i = R.id.input_container;
                                                    CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                                    if (customCardView3 != null) {
                                                        i = R.id.money_input_row;
                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                        if (linearLayout3 != null) {
                                                            i = R.id.money_title;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView6 != null) {
                                                                i = R.id.money_title_container;
                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                if (linearLayout4 != null) {
                                                                    i = R.id.textInputLayout;
                                                                    TextInputLayout textInputLayout2 = (TextInputLayout) ViewBindings.findChildViewById(rootView, i);
                                                                    if (textInputLayout2 != null) {
                                                                        i = R.id.transfer_commission_container;
                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                        if (linearLayout5 != null) {
                                                                            i = R.id.transfer_commission_text;
                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (textView7 != null) {
                                                                                i = R.id.transfer_commission_value;
                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                if (textView8 != null) {
                                                                                    i = R.id.user_input;
                                                                                    EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (editText2 != null) {
                                                                                        return new InputDialogBinding(frameLayout, customCardView, bind, textView, editText, customCardView2, linearLayout, textInputLayout, textView2, textView3, linearLayout2, textView4, frameLayout, textView5, customCardView3, linearLayout3, textView6, linearLayout4, textInputLayout2, linearLayout5, textView7, textView8, editText2);
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
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
