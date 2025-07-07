package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class MessengerInputFieldLayoutBinding implements ViewBinding {
    public final LinearLayout blockUserContainer;
    public final TextView blockUserDescription;
    public final TextView blockUserTitle;
    public final View divider;
    public final RecyclerView emojiBar;
    public final AppCompatImageView emojiBtn;
    public final LinearLayout inputContainer;
    public final EditText messageEditText;
    public final TextView messageLimitText;
    public final LinearLayout messengeContainer;
    private final LinearLayout rootView;
    public final RelativeLayout sendBtn;

    private MessengerInputFieldLayoutBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, View view, RecyclerView recyclerView, AppCompatImageView appCompatImageView, LinearLayout linearLayout3, EditText editText, TextView textView3, LinearLayout linearLayout4, RelativeLayout relativeLayout) {
        this.rootView = linearLayout;
        this.blockUserContainer = linearLayout2;
        this.blockUserDescription = textView;
        this.blockUserTitle = textView2;
        this.divider = view;
        this.emojiBar = recyclerView;
        this.emojiBtn = appCompatImageView;
        this.inputContainer = linearLayout3;
        this.messageEditText = editText;
        this.messageLimitText = textView3;
        this.messengeContainer = linearLayout4;
        this.sendBtn = relativeLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MessengerInputFieldLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MessengerInputFieldLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.messenger_input_field_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MessengerInputFieldLayoutBinding bind(View view) {
        View findChildViewById;
        int i = R.id.block_user_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.block_user_description;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.block_user_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.divider))) != null) {
                    i = R.id.emoji_bar;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                    if (recyclerView != null) {
                        i = R.id.emoji_btn;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                        if (appCompatImageView != null) {
                            i = R.id.input_container;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout2 != null) {
                                i = R.id.message_edit_text;
                                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                if (editText != null) {
                                    i = R.id.message_limit_text;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.messenge_container;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout3 != null) {
                                            i = R.id.send_btn;
                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                            if (relativeLayout != null) {
                                                return new MessengerInputFieldLayoutBinding((LinearLayout) view, linearLayout, textView, textView2, findChildViewById, recyclerView, appCompatImageView, linearLayout2, editText, textView3, linearLayout3, relativeLayout);
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
