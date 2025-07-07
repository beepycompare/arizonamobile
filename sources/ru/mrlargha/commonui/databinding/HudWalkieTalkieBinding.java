package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class HudWalkieTalkieBinding implements ViewBinding {
    public final ImageView ivWalkieTalkie;
    private final ImageView rootView;

    private HudWalkieTalkieBinding(ImageView rootView, ImageView ivWalkieTalkie) {
        this.rootView = rootView;
        this.ivWalkieTalkie = ivWalkieTalkie;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ImageView getRoot() {
        return this.rootView;
    }

    public static HudWalkieTalkieBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudWalkieTalkieBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_walkie_talkie, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudWalkieTalkieBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        ImageView imageView = (ImageView) rootView;
        return new HudWalkieTalkieBinding(imageView, imageView);
    }
}
