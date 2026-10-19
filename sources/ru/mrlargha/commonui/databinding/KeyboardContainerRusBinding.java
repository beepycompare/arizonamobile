package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizona.common.ui.KeyboardButton;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class KeyboardContainerRusBinding implements ViewBinding {
    public final KeyboardButton aButtonKey;
    public final KeyboardButton bButtonKey;
    public final KeyboardButton backspaceButtonKey;
    public final KeyboardButton cButtonKey;
    public final KeyboardButton chButtonKey;
    public final KeyboardButton commaButtonKey;
    public final KeyboardButton dButtonKey;
    public final KeyboardButton dotPointButtonKey;
    public final KeyboardButton eButtonKey;
    public final KeyboardButton eeButtonKey;
    public final KeyboardButton fButtonKey;
    public final KeyboardButton gButtonKey;
    public final KeyboardButton globusButtonKey;
    public final KeyboardButton hButtonKey;
    public final KeyboardButton iButtonKey;
    public final KeyboardButton iaiButtonKey;
    public final KeyboardButton jButtonKey;
    public final KeyboardButton kButtonKey;
    public final KeyboardButton lButtonKey;
    public final KeyboardButton mButtonKey;
    public final KeyboardButton nButtonKey;
    public final KeyboardButton oButtonKey;
    public final KeyboardButton pButtonKey;
    public final KeyboardButton rButtonKey;
    private final LinearLayout rootView;
    public final KeyboardButton sButtonKey;
    public final KeyboardButton sendButtonKey;
    public final KeyboardButton shButtonKey;
    public final KeyboardButton shchButtonKey;
    public final KeyboardButton shiftButtonKey;
    public final KeyboardButton slashButtonKey;
    public final KeyboardButton spaceButtonKey;
    public final Space spacerLeft;
    public final Space spacerRight;
    public final KeyboardButton symbolsButtonKey;
    public final KeyboardButton tButtonKey;
    public final KeyboardButton uButtonKey;
    public final KeyboardButton vButtonKey;
    public final KeyboardButton yButtonKey;
    public final KeyboardButton yaButtonKey;
    public final KeyboardButton yuButtonKey;
    public final KeyboardButton zButtonKey;
    public final KeyboardButton zhButtonKey;

    private KeyboardContainerRusBinding(LinearLayout rootView, KeyboardButton aButtonKey, KeyboardButton bButtonKey, KeyboardButton backspaceButtonKey, KeyboardButton cButtonKey, KeyboardButton chButtonKey, KeyboardButton commaButtonKey, KeyboardButton dButtonKey, KeyboardButton dotPointButtonKey, KeyboardButton eButtonKey, KeyboardButton eeButtonKey, KeyboardButton fButtonKey, KeyboardButton gButtonKey, KeyboardButton globusButtonKey, KeyboardButton hButtonKey, KeyboardButton iButtonKey, KeyboardButton iaiButtonKey, KeyboardButton jButtonKey, KeyboardButton kButtonKey, KeyboardButton lButtonKey, KeyboardButton mButtonKey, KeyboardButton nButtonKey, KeyboardButton oButtonKey, KeyboardButton pButtonKey, KeyboardButton rButtonKey, KeyboardButton sButtonKey, KeyboardButton sendButtonKey, KeyboardButton shButtonKey, KeyboardButton shchButtonKey, KeyboardButton shiftButtonKey, KeyboardButton slashButtonKey, KeyboardButton spaceButtonKey, Space spacerLeft, Space spacerRight, KeyboardButton symbolsButtonKey, KeyboardButton tButtonKey, KeyboardButton uButtonKey, KeyboardButton vButtonKey, KeyboardButton yButtonKey, KeyboardButton yaButtonKey, KeyboardButton yuButtonKey, KeyboardButton zButtonKey, KeyboardButton zhButtonKey) {
        this.rootView = rootView;
        this.aButtonKey = aButtonKey;
        this.bButtonKey = bButtonKey;
        this.backspaceButtonKey = backspaceButtonKey;
        this.cButtonKey = cButtonKey;
        this.chButtonKey = chButtonKey;
        this.commaButtonKey = commaButtonKey;
        this.dButtonKey = dButtonKey;
        this.dotPointButtonKey = dotPointButtonKey;
        this.eButtonKey = eButtonKey;
        this.eeButtonKey = eeButtonKey;
        this.fButtonKey = fButtonKey;
        this.gButtonKey = gButtonKey;
        this.globusButtonKey = globusButtonKey;
        this.hButtonKey = hButtonKey;
        this.iButtonKey = iButtonKey;
        this.iaiButtonKey = iaiButtonKey;
        this.jButtonKey = jButtonKey;
        this.kButtonKey = kButtonKey;
        this.lButtonKey = lButtonKey;
        this.mButtonKey = mButtonKey;
        this.nButtonKey = nButtonKey;
        this.oButtonKey = oButtonKey;
        this.pButtonKey = pButtonKey;
        this.rButtonKey = rButtonKey;
        this.sButtonKey = sButtonKey;
        this.sendButtonKey = sendButtonKey;
        this.shButtonKey = shButtonKey;
        this.shchButtonKey = shchButtonKey;
        this.shiftButtonKey = shiftButtonKey;
        this.slashButtonKey = slashButtonKey;
        this.spaceButtonKey = spaceButtonKey;
        this.spacerLeft = spacerLeft;
        this.spacerRight = spacerRight;
        this.symbolsButtonKey = symbolsButtonKey;
        this.tButtonKey = tButtonKey;
        this.uButtonKey = uButtonKey;
        this.vButtonKey = vButtonKey;
        this.yButtonKey = yButtonKey;
        this.yaButtonKey = yaButtonKey;
        this.yuButtonKey = yuButtonKey;
        this.zButtonKey = zButtonKey;
        this.zhButtonKey = zhButtonKey;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static KeyboardContainerRusBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static KeyboardContainerRusBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.keyboard_container_rus, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static KeyboardContainerRusBinding bind(View rootView) {
        int i = R.id.a_button_key;
        KeyboardButton keyboardButton = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
        if (keyboardButton != null) {
            i = R.id.b_button_key;
            KeyboardButton keyboardButton2 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
            if (keyboardButton2 != null) {
                i = R.id.backspace_button_key;
                KeyboardButton keyboardButton3 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                if (keyboardButton3 != null) {
                    i = R.id.c_button_key;
                    KeyboardButton keyboardButton4 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                    if (keyboardButton4 != null) {
                        i = R.id.ch_button_key;
                        KeyboardButton keyboardButton5 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                        if (keyboardButton5 != null) {
                            i = R.id.comma_button_key;
                            KeyboardButton keyboardButton6 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                            if (keyboardButton6 != null) {
                                i = R.id.d_button_key;
                                KeyboardButton keyboardButton7 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                if (keyboardButton7 != null) {
                                    i = R.id.dot_point_button_key;
                                    KeyboardButton keyboardButton8 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                    if (keyboardButton8 != null) {
                                        i = R.id.e_button_key;
                                        KeyboardButton keyboardButton9 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                        if (keyboardButton9 != null) {
                                            i = R.id.ee_button_key;
                                            KeyboardButton keyboardButton10 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                            if (keyboardButton10 != null) {
                                                i = R.id.f_button_key;
                                                KeyboardButton keyboardButton11 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                if (keyboardButton11 != null) {
                                                    i = R.id.g_button_key;
                                                    KeyboardButton keyboardButton12 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                    if (keyboardButton12 != null) {
                                                        i = R.id.globus_button_key;
                                                        KeyboardButton keyboardButton13 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                        if (keyboardButton13 != null) {
                                                            i = R.id.h_button_key;
                                                            KeyboardButton keyboardButton14 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                            if (keyboardButton14 != null) {
                                                                i = R.id.i_button_key;
                                                                KeyboardButton keyboardButton15 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                if (keyboardButton15 != null) {
                                                                    i = R.id.iai_button_key;
                                                                    KeyboardButton keyboardButton16 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                    if (keyboardButton16 != null) {
                                                                        i = R.id.j_button_key;
                                                                        KeyboardButton keyboardButton17 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                        if (keyboardButton17 != null) {
                                                                            i = R.id.k_button_key;
                                                                            KeyboardButton keyboardButton18 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                            if (keyboardButton18 != null) {
                                                                                i = R.id.l_button_key;
                                                                                KeyboardButton keyboardButton19 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                if (keyboardButton19 != null) {
                                                                                    i = R.id.m_button_key;
                                                                                    KeyboardButton keyboardButton20 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (keyboardButton20 != null) {
                                                                                        i = R.id.n_button_key;
                                                                                        KeyboardButton keyboardButton21 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (keyboardButton21 != null) {
                                                                                            i = R.id.o_button_key;
                                                                                            KeyboardButton keyboardButton22 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (keyboardButton22 != null) {
                                                                                                i = R.id.p_button_key;
                                                                                                KeyboardButton keyboardButton23 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (keyboardButton23 != null) {
                                                                                                    i = R.id.r_button_key;
                                                                                                    KeyboardButton keyboardButton24 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (keyboardButton24 != null) {
                                                                                                        i = R.id.s_button_key;
                                                                                                        KeyboardButton keyboardButton25 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (keyboardButton25 != null) {
                                                                                                            i = R.id.send_button_key;
                                                                                                            KeyboardButton keyboardButton26 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                            if (keyboardButton26 != null) {
                                                                                                                i = R.id.sh_button_key;
                                                                                                                KeyboardButton keyboardButton27 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                if (keyboardButton27 != null) {
                                                                                                                    i = R.id.shch_button_key;
                                                                                                                    KeyboardButton keyboardButton28 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                    if (keyboardButton28 != null) {
                                                                                                                        i = R.id.shift_button_key;
                                                                                                                        KeyboardButton keyboardButton29 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                        if (keyboardButton29 != null) {
                                                                                                                            i = R.id.slash_button_key;
                                                                                                                            KeyboardButton keyboardButton30 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                            if (keyboardButton30 != null) {
                                                                                                                                i = R.id.space_button_key;
                                                                                                                                KeyboardButton keyboardButton31 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                if (keyboardButton31 != null) {
                                                                                                                                    i = R.id.spacer_left;
                                                                                                                                    Space space = (Space) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                    if (space != null) {
                                                                                                                                        i = R.id.spacer_right;
                                                                                                                                        Space space2 = (Space) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                        if (space2 != null) {
                                                                                                                                            i = R.id.symbols_button_key;
                                                                                                                                            KeyboardButton keyboardButton32 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                            if (keyboardButton32 != null) {
                                                                                                                                                i = R.id.t_button_key;
                                                                                                                                                KeyboardButton keyboardButton33 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                if (keyboardButton33 != null) {
                                                                                                                                                    i = R.id.u_button_key;
                                                                                                                                                    KeyboardButton keyboardButton34 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                    if (keyboardButton34 != null) {
                                                                                                                                                        i = R.id.v_button_key;
                                                                                                                                                        KeyboardButton keyboardButton35 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                        if (keyboardButton35 != null) {
                                                                                                                                                            i = R.id.y_button_key;
                                                                                                                                                            KeyboardButton keyboardButton36 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                            if (keyboardButton36 != null) {
                                                                                                                                                                i = R.id.ya_button_key;
                                                                                                                                                                KeyboardButton keyboardButton37 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                if (keyboardButton37 != null) {
                                                                                                                                                                    i = R.id.yu_button_key;
                                                                                                                                                                    KeyboardButton keyboardButton38 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                    if (keyboardButton38 != null) {
                                                                                                                                                                        i = R.id.z_button_key;
                                                                                                                                                                        KeyboardButton keyboardButton39 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                        if (keyboardButton39 != null) {
                                                                                                                                                                            i = R.id.zh_button_key;
                                                                                                                                                                            KeyboardButton keyboardButton40 = (KeyboardButton) ViewBindings.findChildViewById(rootView, i);
                                                                                                                                                                            if (keyboardButton40 != null) {
                                                                                                                                                                                return new KeyboardContainerRusBinding((LinearLayout) rootView, keyboardButton, keyboardButton2, keyboardButton3, keyboardButton4, keyboardButton5, keyboardButton6, keyboardButton7, keyboardButton8, keyboardButton9, keyboardButton10, keyboardButton11, keyboardButton12, keyboardButton13, keyboardButton14, keyboardButton15, keyboardButton16, keyboardButton17, keyboardButton18, keyboardButton19, keyboardButton20, keyboardButton21, keyboardButton22, keyboardButton23, keyboardButton24, keyboardButton25, keyboardButton26, keyboardButton27, keyboardButton28, keyboardButton29, keyboardButton30, keyboardButton31, space, space2, keyboardButton32, keyboardButton33, keyboardButton34, keyboardButton35, keyboardButton36, keyboardButton37, keyboardButton38, keyboardButton39, keyboardButton40);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
