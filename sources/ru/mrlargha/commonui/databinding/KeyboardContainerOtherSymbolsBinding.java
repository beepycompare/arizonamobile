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
public final class KeyboardContainerOtherSymbolsBinding implements ViewBinding {
    public final KeyboardButton aButtonKey;
    public final KeyboardButton abcButtonKey;
    public final KeyboardButton backspaceButtonKey;
    public final KeyboardButton centerDotButtonKey;
    public final KeyboardButton commaButtonKey;
    public final KeyboardButton divideButtonKey;
    public final KeyboardButton eightButtonKey;
    public final KeyboardButton equalButtonKey;
    public final KeyboardButton figureBraceLeftButtonKey;
    public final KeyboardButton figureBraceRightButtonKey;
    public final KeyboardButton fiveButtonKey;
    public final KeyboardButton fourButtonKey;
    public final KeyboardButton globusButtonKey;
    public final KeyboardButton minusButtonKey;
    public final KeyboardButton multiplyButtonKey;
    public final KeyboardButton nineButtonKey;
    public final KeyboardButton oneButtonKey;
    public final KeyboardButton otherSymbolsButtonKey;
    public final KeyboardButton plusButtonKey;
    public final KeyboardButton questionButtonKey;
    public final KeyboardButton rootNumberButtonKey;
    private final LinearLayout rootView;
    public final KeyboardButton sendButtonKey;
    public final KeyboardButton sevenButtonKey;
    public final KeyboardButton sixButtonKey;
    public final KeyboardButton spaceButtonKey;
    public final KeyboardButton splashButtonKey;
    public final KeyboardButton squareBraceLeftButtonKey;
    public final KeyboardButton squareBraceRightButtonKey;
    public final KeyboardButton threeButtonKey;
    public final KeyboardButton tickLeftButtonKey;
    public final KeyboardButton tickRightButtonKey;
    public final KeyboardButton tickUpButtonKey;
    public final KeyboardButton topCircleButtonKey;
    public final KeyboardButton triangleButtonKey;
    public final KeyboardButton twoButtonKey;
    public final KeyboardButton verticalLineButtonKey;
    public final KeyboardButton zeroButtonKey;

    private KeyboardContainerOtherSymbolsBinding(LinearLayout rootView, KeyboardButton aButtonKey, KeyboardButton abcButtonKey, KeyboardButton backspaceButtonKey, KeyboardButton centerDotButtonKey, KeyboardButton commaButtonKey, KeyboardButton divideButtonKey, KeyboardButton eightButtonKey, KeyboardButton equalButtonKey, KeyboardButton figureBraceLeftButtonKey, KeyboardButton figureBraceRightButtonKey, KeyboardButton fiveButtonKey, KeyboardButton fourButtonKey, KeyboardButton globusButtonKey, KeyboardButton minusButtonKey, KeyboardButton multiplyButtonKey, KeyboardButton nineButtonKey, KeyboardButton oneButtonKey, KeyboardButton otherSymbolsButtonKey, KeyboardButton plusButtonKey, KeyboardButton questionButtonKey, KeyboardButton rootNumberButtonKey, KeyboardButton sendButtonKey, KeyboardButton sevenButtonKey, KeyboardButton sixButtonKey, KeyboardButton spaceButtonKey, KeyboardButton splashButtonKey, KeyboardButton squareBraceLeftButtonKey, KeyboardButton squareBraceRightButtonKey, KeyboardButton threeButtonKey, KeyboardButton tickLeftButtonKey, KeyboardButton tickRightButtonKey, KeyboardButton tickUpButtonKey, KeyboardButton topCircleButtonKey, KeyboardButton triangleButtonKey, KeyboardButton twoButtonKey, KeyboardButton verticalLineButtonKey, KeyboardButton zeroButtonKey) {
        this.rootView = rootView;
        this.aButtonKey = aButtonKey;
        this.abcButtonKey = abcButtonKey;
        this.backspaceButtonKey = backspaceButtonKey;
        this.centerDotButtonKey = centerDotButtonKey;
        this.commaButtonKey = commaButtonKey;
        this.divideButtonKey = divideButtonKey;
        this.eightButtonKey = eightButtonKey;
        this.equalButtonKey = equalButtonKey;
        this.figureBraceLeftButtonKey = figureBraceLeftButtonKey;
        this.figureBraceRightButtonKey = figureBraceRightButtonKey;
        this.fiveButtonKey = fiveButtonKey;
        this.fourButtonKey = fourButtonKey;
        this.globusButtonKey = globusButtonKey;
        this.minusButtonKey = minusButtonKey;
        this.multiplyButtonKey = multiplyButtonKey;
        this.nineButtonKey = nineButtonKey;
        this.oneButtonKey = oneButtonKey;
        this.otherSymbolsButtonKey = otherSymbolsButtonKey;
        this.plusButtonKey = plusButtonKey;
        this.questionButtonKey = questionButtonKey;
        this.rootNumberButtonKey = rootNumberButtonKey;
        this.sendButtonKey = sendButtonKey;
        this.sevenButtonKey = sevenButtonKey;
        this.sixButtonKey = sixButtonKey;
        this.spaceButtonKey = spaceButtonKey;
        this.splashButtonKey = splashButtonKey;
        this.squareBraceLeftButtonKey = squareBraceLeftButtonKey;
        this.squareBraceRightButtonKey = squareBraceRightButtonKey;
        this.threeButtonKey = threeButtonKey;
        this.tickLeftButtonKey = tickLeftButtonKey;
        this.tickRightButtonKey = tickRightButtonKey;
        this.tickUpButtonKey = tickUpButtonKey;
        this.topCircleButtonKey = topCircleButtonKey;
        this.triangleButtonKey = triangleButtonKey;
        this.twoButtonKey = twoButtonKey;
        this.verticalLineButtonKey = verticalLineButtonKey;
        this.zeroButtonKey = zeroButtonKey;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static KeyboardContainerOtherSymbolsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static KeyboardContainerOtherSymbolsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.keyboard_container_other_symbols, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static KeyboardContainerOtherSymbolsBinding bind(View rootView) {
        int i = R.id.a_button_key;
        KeyboardButton keyboardButton = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
        if (keyboardButton != null) {
            i = R.id.abc_button_key;
            KeyboardButton keyboardButton2 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
            if (keyboardButton2 != null) {
                i = R.id.backspace_button_key;
                KeyboardButton keyboardButton3 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                if (keyboardButton3 != null) {
                    i = R.id.center_dot_button_key;
                    KeyboardButton keyboardButton4 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                    if (keyboardButton4 != null) {
                        i = R.id.comma_button_key;
                        KeyboardButton keyboardButton5 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                        if (keyboardButton5 != null) {
                            i = R.id.divide_button_key;
                            KeyboardButton keyboardButton6 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                            if (keyboardButton6 != null) {
                                i = R.id.eight_button_key;
                                KeyboardButton keyboardButton7 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                if (keyboardButton7 != null) {
                                    i = R.id.equal_button_key;
                                    KeyboardButton keyboardButton8 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                    if (keyboardButton8 != null) {
                                        i = R.id.figure_brace_left_button_key;
                                        KeyboardButton keyboardButton9 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                        if (keyboardButton9 != null) {
                                            i = R.id.figure_brace_right_button_key;
                                            KeyboardButton keyboardButton10 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                            if (keyboardButton10 != null) {
                                                i = R.id.five_button_key;
                                                KeyboardButton keyboardButton11 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                if (keyboardButton11 != null) {
                                                    i = R.id.four_button_key;
                                                    KeyboardButton keyboardButton12 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                    if (keyboardButton12 != null) {
                                                        i = R.id.globus_button_key;
                                                        KeyboardButton keyboardButton13 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                        if (keyboardButton13 != null) {
                                                            i = R.id.minus_button_key;
                                                            KeyboardButton keyboardButton14 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                            if (keyboardButton14 != null) {
                                                                i = R.id.multiply_button_key;
                                                                KeyboardButton keyboardButton15 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                if (keyboardButton15 != null) {
                                                                    i = R.id.nine_button_key;
                                                                    KeyboardButton keyboardButton16 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                    if (keyboardButton16 != null) {
                                                                        i = R.id.one_button_key;
                                                                        KeyboardButton keyboardButton17 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                        if (keyboardButton17 != null) {
                                                                            i = R.id.other_symbols_button_key;
                                                                            KeyboardButton keyboardButton18 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                            if (keyboardButton18 != null) {
                                                                                i = R.id.plus_button_key;
                                                                                KeyboardButton keyboardButton19 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                if (keyboardButton19 != null) {
                                                                                    i = R.id.question_button_key;
                                                                                    KeyboardButton keyboardButton20 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (keyboardButton20 != null) {
                                                                                        i = R.id.root_number_button_key;
                                                                                        KeyboardButton keyboardButton21 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (keyboardButton21 != null) {
                                                                                            i = R.id.send_button_key;
                                                                                            KeyboardButton keyboardButton22 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (keyboardButton22 != null) {
                                                                                                i = R.id.seven_button_key;
                                                                                                KeyboardButton keyboardButton23 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (keyboardButton23 != null) {
                                                                                                    i = R.id.six_button_key;
                                                                                                    KeyboardButton keyboardButton24 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (keyboardButton24 != null) {
                                                                                                        i = R.id.space_button_key;
                                                                                                        KeyboardButton keyboardButton25 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (keyboardButton25 != null) {
                                                                                                            i = R.id.splash_button_key;
                                                                                                            KeyboardButton keyboardButton26 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                            if (keyboardButton26 != null) {
                                                                                                                i = R.id.square_brace_left_button_key;
                                                                                                                KeyboardButton keyboardButton27 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                if (keyboardButton27 != null) {
                                                                                                                    i = R.id.square_brace_right_button_key;
                                                                                                                    KeyboardButton keyboardButton28 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                    if (keyboardButton28 != null) {
                                                                                                                        i = R.id.three_button_key;
                                                                                                                        KeyboardButton keyboardButton29 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                        if (keyboardButton29 != null) {
                                                                                                                            i = R.id.tick_left_button_key;
                                                                                                                            KeyboardButton keyboardButton30 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                            if (keyboardButton30 != null) {
                                                                                                                                i = R.id.tick_right_button_key;
                                                                                                                                KeyboardButton keyboardButton31 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                if (keyboardButton31 != null) {
                                                                                                                                    i = R.id.tick_up_button_key;
                                                                                                                                    KeyboardButton keyboardButton32 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                    if (keyboardButton32 != null) {
                                                                                                                                        i = R.id.top_circle_button_key;
                                                                                                                                        KeyboardButton keyboardButton33 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                        if (keyboardButton33 != null) {
                                                                                                                                            i = R.id.triangle_button_key;
                                                                                                                                            KeyboardButton keyboardButton34 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                            if (keyboardButton34 != null) {
                                                                                                                                                i = R.id.two_button_key;
                                                                                                                                                KeyboardButton keyboardButton35 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                if (keyboardButton35 != null) {
                                                                                                                                                    i = R.id.vertical_line_button_key;
                                                                                                                                                    KeyboardButton keyboardButton36 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                    if (keyboardButton36 != null) {
                                                                                                                                                        i = R.id.zero_button_key;
                                                                                                                                                        KeyboardButton keyboardButton37 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                        if (keyboardButton37 != null) {
                                                                                                                                                            return new KeyboardContainerOtherSymbolsBinding((LinearLayout) rootView, keyboardButton, keyboardButton2, keyboardButton3, keyboardButton4, keyboardButton5, keyboardButton6, keyboardButton7, keyboardButton8, keyboardButton9, keyboardButton10, keyboardButton11, keyboardButton12, keyboardButton13, keyboardButton14, keyboardButton15, keyboardButton16, keyboardButton17, keyboardButton18, keyboardButton19, keyboardButton20, keyboardButton21, keyboardButton22, keyboardButton23, keyboardButton24, keyboardButton25, keyboardButton26, keyboardButton27, keyboardButton28, keyboardButton29, keyboardButton30, keyboardButton31, keyboardButton32, keyboardButton33, keyboardButton34, keyboardButton35, keyboardButton36, keyboardButton37);
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
