package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class DiceMessageItemBinding implements ViewBinding {
    public final ConstraintLayout diceMessageItem;
    public final TextView messageNickname;
    public final TextView messageText;
    private final ConstraintLayout rootView;

    private DiceMessageItemBinding(ConstraintLayout rootView, ConstraintLayout diceMessageItem, TextView messageNickname, TextView messageText) {
        this.rootView = rootView;
        this.diceMessageItem = diceMessageItem;
        this.messageNickname = messageNickname;
        this.messageText = messageText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DiceMessageItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DiceMessageItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dice_message_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DiceMessageItemBinding bind(View rootView) {
        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
        int i = R.id.message_nickname;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.message_text;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                return new DiceMessageItemBinding(constraintLayout, constraintLayout, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
