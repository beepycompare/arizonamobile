package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class RodinaPersonalPropertyItemViewBinding implements ViewBinding {
    public final TextView rodinaPersonalPropertyItemViewKey;
    public final TextView rodinaPersonalPropertyItemViewValue;
    private final LinearLayout rootView;

    private RodinaPersonalPropertyItemViewBinding(LinearLayout rootView, TextView rodinaPersonalPropertyItemViewKey, TextView rodinaPersonalPropertyItemViewValue) {
        this.rootView = rootView;
        this.rodinaPersonalPropertyItemViewKey = rodinaPersonalPropertyItemViewKey;
        this.rodinaPersonalPropertyItemViewValue = rodinaPersonalPropertyItemViewValue;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RodinaPersonalPropertyItemViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RodinaPersonalPropertyItemViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.rodina_personal_property_item_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RodinaPersonalPropertyItemViewBinding bind(View rootView) {
        int i = R.id.rodina_personal_property_item_view_key;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.rodina_personal_property_item_view_value;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                return new RodinaPersonalPropertyItemViewBinding((LinearLayout) rootView, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
