package ru.mrlargha.feature.event.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.event.R;
/* loaded from: classes3.dex */
public final class EventPriseItemEventBinding implements ViewBinding {
    public final FrameLayout bg;
    public final ImageView imagePrise;
    public final View rarity;
    private final LinearLayout rootView;

    private EventPriseItemEventBinding(LinearLayout linearLayout, FrameLayout frameLayout, ImageView imageView, View view) {
        this.rootView = linearLayout;
        this.bg = frameLayout;
        this.imagePrise = imageView;
        this.rarity = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EventPriseItemEventBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static EventPriseItemEventBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.event_prise_item_event, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EventPriseItemEventBinding bind(View view) {
        View findChildViewById;
        int i = R.id.bg;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = R.id.imagePrise;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.rarity))) != null) {
                return new EventPriseItemEventBinding((LinearLayout) view, frameLayout, imageView, findChildViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
