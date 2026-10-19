package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizona.common.ui.KeyboardButton;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class KeyboardContainerSymbolsBinding implements ViewBinding {
    public final KeyboardButton abcButtonKey;
    public final KeyboardButton andButtonKey;
    public final KeyboardButton atButtonKey;
    public final KeyboardButton backspaceButtonKey;
    public final KeyboardButton colonButtonKey;
    public final KeyboardButton commaButtonKey;
    public final KeyboardButton dollarButtonKey;
    public final KeyboardButton dotButtonKey;
    public final KeyboardButton doubleQuotButtonKey;
    public final KeyboardButton eightButtonKey;
    public final KeyboardButton exclamationPointButtonKey;
    public final KeyboardButton fiveButtonKey;
    public final KeyboardButton fourButtonKey;
    public final KeyboardButton globusButtonKey;
    public final KeyboardButton hashtagButtonKey;
    public final KeyboardButton leftBracketButtonKey;
    public final KeyboardButton minusButtonKey;
    public final KeyboardButton multiplyButtonKey;
    public final KeyboardButton nineButtonKey;
    public final KeyboardButton oneButtonKey;
    public final KeyboardButton otherSymbolsButtonKey;
    public final KeyboardButton percentButtonKey;
    public final KeyboardButton plusButtonKey;
    public final KeyboardButton questionMarkButtonKey;
    public final KeyboardButton quotButtonKey;
    public final KeyboardButton rightBracketButtonKey;
    private final LinearLayout rootView;
    public final KeyboardButton semicolonButtonKey;
    public final KeyboardButton sendButtonKey;
    public final KeyboardButton sevenButtonKey;
    public final KeyboardButton sixButtonKey;
    public final KeyboardButton slashButtonKey;
    public final KeyboardButton spaceButtonKey;
    public final KeyboardButton splashButtonKey;
    public final KeyboardButton threeButtonKey;
    public final KeyboardButton twoButtonKey;
    public final KeyboardButton underlineButtonKey;
    public final KeyboardButton zeroButtonKey;

    private KeyboardContainerSymbolsBinding(LinearLayout rootView, KeyboardButton abcButtonKey, KeyboardButton andButtonKey, KeyboardButton atButtonKey, KeyboardButton backspaceButtonKey, KeyboardButton colonButtonKey, KeyboardButton commaButtonKey, KeyboardButton dollarButtonKey, KeyboardButton dotButtonKey, KeyboardButton doubleQuotButtonKey, KeyboardButton eightButtonKey, KeyboardButton exclamationPointButtonKey, KeyboardButton fiveButtonKey, KeyboardButton fourButtonKey, KeyboardButton globusButtonKey, KeyboardButton hashtagButtonKey, KeyboardButton leftBracketButtonKey, KeyboardButton minusButtonKey, KeyboardButton multiplyButtonKey, KeyboardButton nineButtonKey, KeyboardButton oneButtonKey, KeyboardButton otherSymbolsButtonKey, KeyboardButton percentButtonKey, KeyboardButton plusButtonKey, KeyboardButton questionMarkButtonKey, KeyboardButton quotButtonKey, KeyboardButton rightBracketButtonKey, KeyboardButton semicolonButtonKey, KeyboardButton sendButtonKey, KeyboardButton sevenButtonKey, KeyboardButton sixButtonKey, KeyboardButton slashButtonKey, KeyboardButton spaceButtonKey, KeyboardButton splashButtonKey, KeyboardButton threeButtonKey, KeyboardButton twoButtonKey, KeyboardButton underlineButtonKey, KeyboardButton zeroButtonKey) {
        this.rootView = rootView;
        this.abcButtonKey = abcButtonKey;
        this.andButtonKey = andButtonKey;
        this.atButtonKey = atButtonKey;
        this.backspaceButtonKey = backspaceButtonKey;
        this.colonButtonKey = colonButtonKey;
        this.commaButtonKey = commaButtonKey;
        this.dollarButtonKey = dollarButtonKey;
        this.dotButtonKey = dotButtonKey;
        this.doubleQuotButtonKey = doubleQuotButtonKey;
        this.eightButtonKey = eightButtonKey;
        this.exclamationPointButtonKey = exclamationPointButtonKey;
        this.fiveButtonKey = fiveButtonKey;
        this.fourButtonKey = fourButtonKey;
        this.globusButtonKey = globusButtonKey;
        this.hashtagButtonKey = hashtagButtonKey;
        this.leftBracketButtonKey = leftBracketButtonKey;
        this.minusButtonKey = minusButtonKey;
        this.multiplyButtonKey = multiplyButtonKey;
        this.nineButtonKey = nineButtonKey;
        this.oneButtonKey = oneButtonKey;
        this.otherSymbolsButtonKey = otherSymbolsButtonKey;
        this.percentButtonKey = percentButtonKey;
        this.plusButtonKey = plusButtonKey;
        this.questionMarkButtonKey = questionMarkButtonKey;
        this.quotButtonKey = quotButtonKey;
        this.rightBracketButtonKey = rightBracketButtonKey;
        this.semicolonButtonKey = semicolonButtonKey;
        this.sendButtonKey = sendButtonKey;
        this.sevenButtonKey = sevenButtonKey;
        this.sixButtonKey = sixButtonKey;
        this.slashButtonKey = slashButtonKey;
        this.spaceButtonKey = spaceButtonKey;
        this.splashButtonKey = splashButtonKey;
        this.threeButtonKey = threeButtonKey;
        this.twoButtonKey = twoButtonKey;
        this.underlineButtonKey = underlineButtonKey;
        this.zeroButtonKey = zeroButtonKey;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static KeyboardContainerSymbolsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static KeyboardContainerSymbolsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.keyboard_container_symbols, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static KeyboardContainerSymbolsBinding bind(View rootView) {
        int i = R.id.abc_button_key;
        KeyboardButton keyboardButton = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
        if (keyboardButton != null) {
            i = R.id.and_button_key;
            KeyboardButton keyboardButton2 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
            if (keyboardButton2 != null) {
                i = R.id.at_button_key;
                KeyboardButton keyboardButton3 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                if (keyboardButton3 != null) {
                    i = R.id.backspace_button_key;
                    KeyboardButton keyboardButton4 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                    if (keyboardButton4 != null) {
                        i = R.id.colon_button_key;
                        KeyboardButton keyboardButton5 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                        if (keyboardButton5 != null) {
                            i = R.id.comma_button_key;
                            KeyboardButton keyboardButton6 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                            if (keyboardButton6 != null) {
                                i = R.id.dollar_button_key;
                                KeyboardButton keyboardButton7 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                if (keyboardButton7 != null) {
                                    i = R.id.dot_button_key;
                                    KeyboardButton keyboardButton8 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                    if (keyboardButton8 != null) {
                                        i = R.id.double_quot_button_key;
                                        KeyboardButton keyboardButton9 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                        if (keyboardButton9 != null) {
                                            i = R.id.eight_button_key;
                                            KeyboardButton keyboardButton10 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                            if (keyboardButton10 != null) {
                                                i = R.id.exclamation_point_button_key;
                                                KeyboardButton keyboardButton11 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                if (keyboardButton11 != null) {
                                                    i = R.id.five_button_key;
                                                    KeyboardButton keyboardButton12 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                    if (keyboardButton12 != null) {
                                                        i = R.id.four_button_key;
                                                        KeyboardButton keyboardButton13 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                        if (keyboardButton13 != null) {
                                                            i = R.id.globus_button_key;
                                                            KeyboardButton keyboardButton14 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                            if (keyboardButton14 != null) {
                                                                i = R.id.hashtag_button_key;
                                                                KeyboardButton keyboardButton15 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                if (keyboardButton15 != null) {
                                                                    i = R.id.left_bracket_button_key;
                                                                    KeyboardButton keyboardButton16 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                    if (keyboardButton16 != null) {
                                                                        i = R.id.minus_button_key;
                                                                        KeyboardButton keyboardButton17 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                        if (keyboardButton17 != null) {
                                                                            i = R.id.multiply_button_key;
                                                                            KeyboardButton keyboardButton18 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                            if (keyboardButton18 != null) {
                                                                                i = R.id.nine_button_key;
                                                                                KeyboardButton keyboardButton19 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                if (keyboardButton19 != null) {
                                                                                    i = R.id.one_button_key;
                                                                                    KeyboardButton keyboardButton20 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (keyboardButton20 != null) {
                                                                                        i = R.id.other_symbols_button_key;
                                                                                        KeyboardButton keyboardButton21 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (keyboardButton21 != null) {
                                                                                            i = R.id.percent_button_key;
                                                                                            KeyboardButton keyboardButton22 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (keyboardButton22 != null) {
                                                                                                i = R.id.plus_button_key;
                                                                                                KeyboardButton keyboardButton23 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (keyboardButton23 != null) {
                                                                                                    i = R.id.question_mark_button_key;
                                                                                                    KeyboardButton keyboardButton24 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (keyboardButton24 != null) {
                                                                                                        i = R.id.quot_button_key;
                                                                                                        KeyboardButton keyboardButton25 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (keyboardButton25 != null) {
                                                                                                            i = R.id.right_bracket_button_key;
                                                                                                            KeyboardButton keyboardButton26 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                            if (keyboardButton26 != null) {
                                                                                                                i = R.id.semicolon_button_key;
                                                                                                                KeyboardButton keyboardButton27 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                if (keyboardButton27 != null) {
                                                                                                                    i = R.id.send_button_key;
                                                                                                                    KeyboardButton keyboardButton28 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                    if (keyboardButton28 != null) {
                                                                                                                        i = R.id.seven_button_key;
                                                                                                                        KeyboardButton keyboardButton29 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                        if (keyboardButton29 != null) {
                                                                                                                            i = R.id.six_button_key;
                                                                                                                            KeyboardButton keyboardButton30 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                            if (keyboardButton30 != null) {
                                                                                                                                i = R.id.slash_button_key;
                                                                                                                                KeyboardButton keyboardButton31 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                if (keyboardButton31 != null) {
                                                                                                                                    i = R.id.space_button_key;
                                                                                                                                    KeyboardButton keyboardButton32 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                    if (keyboardButton32 != null) {
                                                                                                                                        i = R.id.splash_button_key;
                                                                                                                                        KeyboardButton keyboardButton33 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                        if (keyboardButton33 != null) {
                                                                                                                                            i = R.id.three_button_key;
                                                                                                                                            KeyboardButton keyboardButton34 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                            if (keyboardButton34 != null) {
                                                                                                                                                i = R.id.two_button_key;
                                                                                                                                                KeyboardButton keyboardButton35 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                if (keyboardButton35 != null) {
                                                                                                                                                    i = R.id.underline_button_key;
                                                                                                                                                    KeyboardButton keyboardButton36 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                    if (keyboardButton36 != null) {
                                                                                                                                                        i = R.id.zero_button_key;
                                                                                                                                                        KeyboardButton keyboardButton37 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                        if (keyboardButton37 != null) {
                                                                                                                                                            return new KeyboardContainerSymbolsBinding((LinearLayout) rootView, keyboardButton, keyboardButton2, keyboardButton3, keyboardButton4, keyboardButton5, keyboardButton6, keyboardButton7, keyboardButton8, keyboardButton9, keyboardButton10, keyboardButton11, keyboardButton12, keyboardButton13, keyboardButton14, keyboardButton15, keyboardButton16, keyboardButton17, keyboardButton18, keyboardButton19, keyboardButton20, keyboardButton21, keyboardButton22, keyboardButton23, keyboardButton24, keyboardButton25, keyboardButton26, keyboardButton27, keyboardButton28, keyboardButton29, keyboardButton30, keyboardButton31, keyboardButton32, keyboardButton33, keyboardButton34, keyboardButton35, keyboardButton36, keyboardButton37);
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
