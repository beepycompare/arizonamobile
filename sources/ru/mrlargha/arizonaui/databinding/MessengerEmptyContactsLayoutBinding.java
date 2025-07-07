package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class MessengerEmptyContactsLayoutBinding implements ViewBinding {
    public final Button buttonNewChat;
    public final AppCompatImageView image;
    private final RelativeLayout rootView;

    private MessengerEmptyContactsLayoutBinding(RelativeLayout relativeLayout, Button button, AppCompatImageView appCompatImageView) {
        this.rootView = relativeLayout;
        this.buttonNewChat = button;
        this.image = appCompatImageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MessengerEmptyContactsLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MessengerEmptyContactsLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.messenger_empty_contacts_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MessengerEmptyContactsLayoutBinding bind(View view) {
        int i = R.id.button_new_chat;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.image;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView != null) {
                return new MessengerEmptyContactsLayoutBinding((RelativeLayout) view, button, appCompatImageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
