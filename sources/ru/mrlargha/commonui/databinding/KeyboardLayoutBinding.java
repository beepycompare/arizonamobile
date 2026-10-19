package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizona.common.ui.KeyboardButton;
import com.google.android.material.textfield.TextInputEditText;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class KeyboardLayoutBinding implements ViewBinding {
    public final LinearLayout bindersBtnContainer;
    public final LinearLayout bindersBtnsContainer;
    public final KeyboardButton bindersKeyBtn;
    public final Space bindersSpacerLeft;
    public final Space bindersSpacerRight;
    public final ImageView bindersTickOpen;
    public final ImageView clearText;
    public final KeyboardButton downBtnHistory;
    public final Space editTextSpacerLeft;
    public final Space editTextSpacerRight;
    public final KeyboardButton emojiBtn;
    public final KeyboardButton familyBinderButtonKey;
    public final LinearLayout inputContainer;
    public final LinearLayout keyboardContainer;
    public final KeyboardContainerBindingsBinding keyboardContainerBinding;
    public final KeyboardContainerEmojiBinding keyboardContainerEmoji;
    public final KeyboardContainerEngBinding keyboardContainerEng;
    public final KeyboardContainerOtherSymbolsBinding keyboardContainerOtherSymbols;
    public final KeyboardContainerRusBinding keyboardContainerRus;
    public final KeyboardContainerSymbolsBinding keyboardContainerSymbols;
    public final RelativeLayout mainBinderBtn;
    public final TextInputEditText mainInputEt;
    public final LinearLayout mainKeyboardLayout;
    public final KeyboardButton nonRpBinderButtonKey;
    public final KeyboardButton orgBinderButtonKey;
    private final LinearLayout rootView;
    public final KeyboardButton rpBinderButtonKey;
    public final KeyboardButton upBtnHistory;
    public final KeyboardButton vipBinderButtonKey;
    public final KeyboardButton workBinderButtonKey;

    private KeyboardLayoutBinding(LinearLayout rootView, LinearLayout bindersBtnContainer, LinearLayout bindersBtnsContainer, KeyboardButton bindersKeyBtn, Space bindersSpacerLeft, Space bindersSpacerRight, ImageView bindersTickOpen, ImageView clearText, KeyboardButton downBtnHistory, Space editTextSpacerLeft, Space editTextSpacerRight, KeyboardButton emojiBtn, KeyboardButton familyBinderButtonKey, LinearLayout inputContainer, LinearLayout keyboardContainer, KeyboardContainerBindingsBinding keyboardContainerBinding, KeyboardContainerEmojiBinding keyboardContainerEmoji, KeyboardContainerEngBinding keyboardContainerEng, KeyboardContainerOtherSymbolsBinding keyboardContainerOtherSymbols, KeyboardContainerRusBinding keyboardContainerRus, KeyboardContainerSymbolsBinding keyboardContainerSymbols, RelativeLayout mainBinderBtn, TextInputEditText mainInputEt, LinearLayout mainKeyboardLayout, KeyboardButton nonRpBinderButtonKey, KeyboardButton orgBinderButtonKey, KeyboardButton rpBinderButtonKey, KeyboardButton upBtnHistory, KeyboardButton vipBinderButtonKey, KeyboardButton workBinderButtonKey) {
        this.rootView = rootView;
        this.bindersBtnContainer = bindersBtnContainer;
        this.bindersBtnsContainer = bindersBtnsContainer;
        this.bindersKeyBtn = bindersKeyBtn;
        this.bindersSpacerLeft = bindersSpacerLeft;
        this.bindersSpacerRight = bindersSpacerRight;
        this.bindersTickOpen = bindersTickOpen;
        this.clearText = clearText;
        this.downBtnHistory = downBtnHistory;
        this.editTextSpacerLeft = editTextSpacerLeft;
        this.editTextSpacerRight = editTextSpacerRight;
        this.emojiBtn = emojiBtn;
        this.familyBinderButtonKey = familyBinderButtonKey;
        this.inputContainer = inputContainer;
        this.keyboardContainer = keyboardContainer;
        this.keyboardContainerBinding = keyboardContainerBinding;
        this.keyboardContainerEmoji = keyboardContainerEmoji;
        this.keyboardContainerEng = keyboardContainerEng;
        this.keyboardContainerOtherSymbols = keyboardContainerOtherSymbols;
        this.keyboardContainerRus = keyboardContainerRus;
        this.keyboardContainerSymbols = keyboardContainerSymbols;
        this.mainBinderBtn = mainBinderBtn;
        this.mainInputEt = mainInputEt;
        this.mainKeyboardLayout = mainKeyboardLayout;
        this.nonRpBinderButtonKey = nonRpBinderButtonKey;
        this.orgBinderButtonKey = orgBinderButtonKey;
        this.rpBinderButtonKey = rpBinderButtonKey;
        this.upBtnHistory = upBtnHistory;
        this.vipBinderButtonKey = vipBinderButtonKey;
        this.workBinderButtonKey = workBinderButtonKey;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static KeyboardLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static KeyboardLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.keyboard_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static KeyboardLayoutBinding bind(View rootView) {
        int i = R.id.binders_btn_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.binders_btns_container;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout2 != null) {
                i = R.id.binders_key_btn;
                KeyboardButton keyboardButton = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                if (keyboardButton != null) {
                    i = R.id.binders_spacer_left;
                    Space space = (Space) ViewBindings.findChildViewById(rootView, i);
                    if (space != null) {
                        i = R.id.binders_spacer_right;
                        Space space2 = (Space) ViewBindings.findChildViewById(rootView, i);
                        if (space2 != null) {
                            i = R.id.binders_tick_open;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView != null) {
                                i = R.id.clear_text;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                if (imageView2 != null) {
                                    i = R.id.down_btn_history;
                                    KeyboardButton keyboardButton2 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                    if (keyboardButton2 != null) {
                                        i = R.id.edit_text_spacer_left;
                                        Space space3 = (Space) ViewBindings.findChildViewById(rootView, i);
                                        if (space3 != null) {
                                            i = R.id.edit_text_spacer_right;
                                            Space space4 = (Space) ViewBindings.findChildViewById(rootView, i);
                                            if (space4 != null) {
                                                i = R.id.emoji_btn;
                                                KeyboardButton keyboardButton3 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                if (keyboardButton3 != null) {
                                                    i = R.id.family_binder_button_key;
                                                    KeyboardButton keyboardButton4 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                    if (keyboardButton4 != null) {
                                                        i = R.id.input_container;
                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                        if (linearLayout3 != null) {
                                                            LinearLayout linearLayout4 = (LinearLayout) rootView;
                                                            i = R.id.keyboard_container_binding;
                                                            View findChildViewById = ViewBindings.findChildViewById(rootView, i);
                                                            if (findChildViewById != null) {
                                                                KeyboardContainerBindingsBinding bind = KeyboardContainerBindingsBinding.bind(findChildViewById);
                                                                i = R.id.keyboard_container_emoji;
                                                                View findChildViewById2 = ViewBindings.findChildViewById(rootView, i);
                                                                if (findChildViewById2 != null) {
                                                                    KeyboardContainerEmojiBinding bind2 = KeyboardContainerEmojiBinding.bind(findChildViewById2);
                                                                    i = R.id.keyboard_container_eng;
                                                                    View findChildViewById3 = ViewBindings.findChildViewById(rootView, i);
                                                                    if (findChildViewById3 != null) {
                                                                        KeyboardContainerEngBinding bind3 = KeyboardContainerEngBinding.bind(findChildViewById3);
                                                                        i = R.id.keyboard_container_other_symbols;
                                                                        View findChildViewById4 = ViewBindings.findChildViewById(rootView, i);
                                                                        if (findChildViewById4 != null) {
                                                                            KeyboardContainerOtherSymbolsBinding bind4 = KeyboardContainerOtherSymbolsBinding.bind(findChildViewById4);
                                                                            i = R.id.keyboard_container_rus;
                                                                            View findChildViewById5 = ViewBindings.findChildViewById(rootView, i);
                                                                            if (findChildViewById5 != null) {
                                                                                KeyboardContainerRusBinding bind5 = KeyboardContainerRusBinding.bind(findChildViewById5);
                                                                                i = R.id.keyboard_container_symbols;
                                                                                View findChildViewById6 = ViewBindings.findChildViewById(rootView, i);
                                                                                if (findChildViewById6 != null) {
                                                                                    KeyboardContainerSymbolsBinding bind6 = KeyboardContainerSymbolsBinding.bind(findChildViewById6);
                                                                                    i = R.id.main_binder_btn;
                                                                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (relativeLayout != null) {
                                                                                        i = R.id.main_input_et;
                                                                                        TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (textInputEditText != null) {
                                                                                            i = R.id.main_keyboard_layout;
                                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (linearLayout5 != null) {
                                                                                                i = R.id.non_rp_binder_button_key;
                                                                                                KeyboardButton keyboardButton5 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (keyboardButton5 != null) {
                                                                                                    i = R.id.org_binder_button_key;
                                                                                                    KeyboardButton keyboardButton6 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (keyboardButton6 != null) {
                                                                                                        i = R.id.rp_binder_button_key;
                                                                                                        KeyboardButton keyboardButton7 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (keyboardButton7 != null) {
                                                                                                            i = R.id.up_btn_history;
                                                                                                            KeyboardButton keyboardButton8 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                            if (keyboardButton8 != null) {
                                                                                                                i = R.id.vip_binder_button_key;
                                                                                                                KeyboardButton keyboardButton9 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                if (keyboardButton9 != null) {
                                                                                                                    i = R.id.work_binder_button_key;
                                                                                                                    KeyboardButton keyboardButton10 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                    if (keyboardButton10 != null) {
                                                                                                                        return new KeyboardLayoutBinding(linearLayout4, linearLayout, linearLayout2, keyboardButton, space, space2, imageView, imageView2, keyboardButton2, space3, space4, keyboardButton3, keyboardButton4, linearLayout3, linearLayout4, bind, bind2, bind3, bind4, bind5, bind6, relativeLayout, textInputEditText, linearLayout5, keyboardButton5, keyboardButton6, keyboardButton7, keyboardButton8, keyboardButton9, keyboardButton10);
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
