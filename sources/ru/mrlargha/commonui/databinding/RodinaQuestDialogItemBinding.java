package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.emoji.widget.EmojiTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class RodinaQuestDialogItemBinding implements ViewBinding {
    public final EmojiTextView rodinaQuestDialogItemEmoji;
    public final TextView rodinaQuestDialogItemText;
    private final LinearLayout rootView;

    private RodinaQuestDialogItemBinding(LinearLayout rootView, EmojiTextView rodinaQuestDialogItemEmoji, TextView rodinaQuestDialogItemText) {
        this.rootView = rootView;
        this.rodinaQuestDialogItemEmoji = rodinaQuestDialogItemEmoji;
        this.rodinaQuestDialogItemText = rodinaQuestDialogItemText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RodinaQuestDialogItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RodinaQuestDialogItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.rodina_quest_dialog_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RodinaQuestDialogItemBinding bind(View rootView) {
        int i = R.id.rodina_quest_dialog_item_emoji;
        EmojiTextView emojiTextView = (EmojiTextView) ViewBindings.findChildViewById(rootView, i);
        if (emojiTextView != null) {
            i = R.id.rodina_quest_dialog_item_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                return new RodinaQuestDialogItemBinding((LinearLayout) rootView, emojiTextView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
