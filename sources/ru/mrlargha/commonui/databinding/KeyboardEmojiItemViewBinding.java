package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.emoji.widget.EmojiTextView;
import androidx.viewbinding.ViewBinding;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class KeyboardEmojiItemViewBinding implements ViewBinding {
    private final EmojiTextView rootView;

    private KeyboardEmojiItemViewBinding(EmojiTextView rootView) {
        this.rootView = rootView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public EmojiTextView getRoot() {
        return this.rootView;
    }

    public static KeyboardEmojiItemViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static KeyboardEmojiItemViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.keyboard_emoji_item_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static KeyboardEmojiItemViewBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new KeyboardEmojiItemViewBinding((EmojiTextView) rootView);
    }
}
