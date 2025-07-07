package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class ChatBinding implements ViewBinding {
    public final AppCompatImageView binderButton;
    public final ConstraintLayout chat;
    public final ConstraintLayout chatContainer;
    public final TextView chatType;
    public final AppCompatImageView downButton;
    public final Guideline downChatLine;
    public final AppCompatImageView enterMessage;
    public final Button famButton;
    public final EditText inputZone;
    public final Guideline leftChatLine;
    public final Button nonrpButton;
    public final Button orgButton;
    public final Guideline rightChatLine;
    private final ConstraintLayout rootView;
    public final Button rpButton;
    public final AppCompatImageView selectButton;
    public final AppCompatImageView sendButton;
    public final AppCompatImageView slash;
    public final AppCompatImageView upButton;
    public final Guideline upChatLine;
    public final Button vipButton;
    public final Button workButton;

    private ChatBinding(ConstraintLayout rootView, AppCompatImageView binderButton, ConstraintLayout chat, ConstraintLayout chatContainer, TextView chatType, AppCompatImageView downButton, Guideline downChatLine, AppCompatImageView enterMessage, Button famButton, EditText inputZone, Guideline leftChatLine, Button nonrpButton, Button orgButton, Guideline rightChatLine, Button rpButton, AppCompatImageView selectButton, AppCompatImageView sendButton, AppCompatImageView slash, AppCompatImageView upButton, Guideline upChatLine, Button vipButton, Button workButton) {
        this.rootView = rootView;
        this.binderButton = binderButton;
        this.chat = chat;
        this.chatContainer = chatContainer;
        this.chatType = chatType;
        this.downButton = downButton;
        this.downChatLine = downChatLine;
        this.enterMessage = enterMessage;
        this.famButton = famButton;
        this.inputZone = inputZone;
        this.leftChatLine = leftChatLine;
        this.nonrpButton = nonrpButton;
        this.orgButton = orgButton;
        this.rightChatLine = rightChatLine;
        this.rpButton = rpButton;
        this.selectButton = selectButton;
        this.sendButton = sendButton;
        this.slash = slash;
        this.upButton = upButton;
        this.upChatLine = upChatLine;
        this.vipButton = vipButton;
        this.workButton = workButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ChatBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ChatBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.chat, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ChatBinding bind(View rootView) {
        int i = R.id.binder_button;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
        if (appCompatImageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
            i = R.id.chat_container;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
            if (constraintLayout2 != null) {
                i = R.id.chat_type;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.down_button;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                    if (appCompatImageView2 != null) {
                        i = R.id.down_chat_line;
                        Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                        if (guideline != null) {
                            i = R.id.enter_message;
                            AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                            if (appCompatImageView3 != null) {
                                i = R.id.fam_button;
                                Button button = (Button) ViewBindings.findChildViewById(rootView, i);
                                if (button != null) {
                                    i = R.id.input_zone;
                                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, i);
                                    if (editText != null) {
                                        i = R.id.left_chat_line;
                                        Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                        if (guideline2 != null) {
                                            i = R.id.nonrp_button;
                                            Button button2 = (Button) ViewBindings.findChildViewById(rootView, i);
                                            if (button2 != null) {
                                                i = R.id.org_button;
                                                Button button3 = (Button) ViewBindings.findChildViewById(rootView, i);
                                                if (button3 != null) {
                                                    i = R.id.right_chat_line;
                                                    Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                    if (guideline3 != null) {
                                                        i = R.id.rp_button;
                                                        Button button4 = (Button) ViewBindings.findChildViewById(rootView, i);
                                                        if (button4 != null) {
                                                            i = R.id.select_button;
                                                            AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                            if (appCompatImageView4 != null) {
                                                                i = R.id.send_button;
                                                                AppCompatImageView appCompatImageView5 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                if (appCompatImageView5 != null) {
                                                                    i = R.id.slash;
                                                                    AppCompatImageView appCompatImageView6 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (appCompatImageView6 != null) {
                                                                        i = R.id.up_button;
                                                                        AppCompatImageView appCompatImageView7 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (appCompatImageView7 != null) {
                                                                            i = R.id.up_chat_line;
                                                                            Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                            if (guideline4 != null) {
                                                                                i = R.id.vip_button;
                                                                                Button button5 = (Button) ViewBindings.findChildViewById(rootView, i);
                                                                                if (button5 != null) {
                                                                                    i = R.id.work_button;
                                                                                    Button button6 = (Button) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (button6 != null) {
                                                                                        return new ChatBinding(constraintLayout, appCompatImageView, constraintLayout, constraintLayout2, textView, appCompatImageView2, guideline, appCompatImageView3, button, editText, guideline2, button2, button3, guideline3, button4, appCompatImageView4, appCompatImageView5, appCompatImageView6, appCompatImageView7, guideline4, button5, button6);
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
