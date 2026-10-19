package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class KeyboardContainerEmojiBinding implements ViewBinding {
    public final RecyclerView emojiList;
    private final LinearLayout rootView;

    private KeyboardContainerEmojiBinding(LinearLayout rootView, RecyclerView emojiList) {
        this.rootView = rootView;
        this.emojiList = emojiList;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static KeyboardContainerEmojiBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static KeyboardContainerEmojiBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.keyboard_container_emoji, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static KeyboardContainerEmojiBinding bind(View rootView) {
        int i = R.id.emoji_list;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
        if (recyclerView != null) {
            return new KeyboardContainerEmojiBinding((LinearLayout) rootView, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
