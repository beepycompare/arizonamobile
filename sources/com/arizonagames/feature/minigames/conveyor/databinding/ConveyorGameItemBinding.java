package com.arizonagames.feature.minigames.conveyor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizonagames.feature.minigames.conveyor.R;
/* loaded from: classes3.dex */
public final class ConveyorGameItemBinding implements ViewBinding {
    public final ImageView ivItem;
    private final FrameLayout rootView;

    private ConveyorGameItemBinding(FrameLayout frameLayout, ImageView imageView) {
        this.rootView = frameLayout;
        this.ivItem = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ConveyorGameItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ConveyorGameItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.conveyor_game_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ConveyorGameItemBinding bind(View view) {
        int i = R.id.iv_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            return new ConveyorGameItemBinding((FrameLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
