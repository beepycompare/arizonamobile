package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class ConveyorGameItemBinding implements ViewBinding {
    public final ImageView ivItem;
    private final FrameLayout rootView;

    private ConveyorGameItemBinding(FrameLayout rootView, ImageView ivItem) {
        this.rootView = rootView;
        this.ivItem = ivItem;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ConveyorGameItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ConveyorGameItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.conveyor_game_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ConveyorGameItemBinding bind(View rootView) {
        int i = R.id.iv_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            return new ConveyorGameItemBinding((FrameLayout) rootView, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
