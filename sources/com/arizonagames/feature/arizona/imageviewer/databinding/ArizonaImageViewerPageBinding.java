package com.arizonagames.feature.arizona.imageviewer.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizonagames.feature.arizona.imageviewer.R;
/* loaded from: classes3.dex */
public final class ArizonaImageViewerPageBinding implements ViewBinding {
    public final ImageView image;
    public final ProgressBar loader;
    private final FrameLayout rootView;

    private ArizonaImageViewerPageBinding(FrameLayout frameLayout, ImageView imageView, ProgressBar progressBar) {
        this.rootView = frameLayout;
        this.image = imageView;
        this.loader = progressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ArizonaImageViewerPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ArizonaImageViewerPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.arizona_image_viewer_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ArizonaImageViewerPageBinding bind(View view) {
        int i = R.id.image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.loader;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
            if (progressBar != null) {
                return new ArizonaImageViewerPageBinding((FrameLayout) view, imageView, progressBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
