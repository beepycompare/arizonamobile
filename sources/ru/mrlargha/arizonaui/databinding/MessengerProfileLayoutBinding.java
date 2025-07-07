package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizona.common.ui.AvatarView;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class MessengerProfileLayoutBinding implements ViewBinding {
    public final AvatarView avatar;
    public final RecyclerView colorsRv;
    public final TextView name;
    public final SwitchCompat notificationSwitch;
    public final TextView notificationText;
    public final TextView phone;
    private final LinearLayout rootView;

    private MessengerProfileLayoutBinding(LinearLayout linearLayout, AvatarView avatarView, RecyclerView recyclerView, TextView textView, SwitchCompat switchCompat, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.avatar = avatarView;
        this.colorsRv = recyclerView;
        this.name = textView;
        this.notificationSwitch = switchCompat;
        this.notificationText = textView2;
        this.phone = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MessengerProfileLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MessengerProfileLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.messenger_profile_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MessengerProfileLayoutBinding bind(View view) {
        int i = R.id.avatar;
        AvatarView avatarView = (AvatarView) ViewBindings.findChildViewById(view, i);
        if (avatarView != null) {
            i = R.id.colors_rv;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
            if (recyclerView != null) {
                i = R.id.name;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.notification_switch;
                    SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                    if (switchCompat != null) {
                        i = R.id.notification_text;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.phone;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                return new MessengerProfileLayoutBinding((LinearLayout) view, avatarView, recyclerView, textView, switchCompat, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
