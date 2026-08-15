package ru.mrlargha.feature.event.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.event.R;
/* loaded from: classes6.dex */
public final class EventShipUpgradeItemBinding implements ViewBinding {
    public final CustomCardView button;
    public final TextView buttonText;
    public final ImageView currency;
    public final ImageView image;
    private final CustomCardView rootView;
    public final TextView text;

    private EventShipUpgradeItemBinding(CustomCardView customCardView, CustomCardView customCardView2, TextView textView, ImageView imageView, ImageView imageView2, TextView textView2) {
        this.rootView = customCardView;
        this.button = customCardView2;
        this.buttonText = textView;
        this.currency = imageView;
        this.image = imageView2;
        this.text = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static EventShipUpgradeItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static EventShipUpgradeItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.event_ship_upgrade_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EventShipUpgradeItemBinding bind(View view) {
        int i = R.id.button;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
        if (customCardView != null) {
            i = R.id.button_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.currency;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.image;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.text;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new EventShipUpgradeItemBinding((CustomCardView) view, customCardView, textView, imageView, imageView2, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
