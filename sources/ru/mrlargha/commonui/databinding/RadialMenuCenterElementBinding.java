package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class RadialMenuCenterElementBinding implements ViewBinding {
    public final ImageView centerIvIcon;
    private final LinearLayout rootView;
    public final TextView tvTitle;

    private RadialMenuCenterElementBinding(LinearLayout rootView, ImageView centerIvIcon, TextView tvTitle) {
        this.rootView = rootView;
        this.centerIvIcon = centerIvIcon;
        this.tvTitle = tvTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RadialMenuCenterElementBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RadialMenuCenterElementBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.radial_menu_center_element, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RadialMenuCenterElementBinding bind(View rootView) {
        int i = R.id.center_iv_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.tv_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                return new RadialMenuCenterElementBinding((LinearLayout) rootView, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
