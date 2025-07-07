package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class MobilePhoneChatMenuItemBinding implements ViewBinding {
    public final View divider;
    public final AppCompatImageView icon;
    public final AppCompatTextView name;
    private final LinearLayout rootView;

    private MobilePhoneChatMenuItemBinding(LinearLayout linearLayout, View view, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView) {
        this.rootView = linearLayout;
        this.divider = view;
        this.icon = appCompatImageView;
        this.name = appCompatTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MobilePhoneChatMenuItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobilePhoneChatMenuItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_phone_chat_menu_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobilePhoneChatMenuItemBinding bind(View view) {
        int i = R.id.divider;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.icon;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView != null) {
                i = R.id.name;
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                if (appCompatTextView != null) {
                    return new MobilePhoneChatMenuItemBinding((LinearLayout) view, findChildViewById, appCompatImageView, appCompatTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
