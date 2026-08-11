package com.arizonagames.feature.arizona.imageviewer.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.arizonagames.feature.arizona.imageviewer.ImageViewerPageIndicator;
import com.arizonagames.feature.arizona.imageviewer.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class ArizonaImageViewerBinding implements ViewBinding {
    public final CustomCardView closeButton;
    public final ProgressBar contentLoader;
    public final ViewPager2 contentPager;
    public final CustomCardView nextButton;
    public final ImageViewerPageIndicator pageIndicator;
    public final CustomCardView previousButton;
    private final FrameLayout rootView;

    private ArizonaImageViewerBinding(FrameLayout frameLayout, CustomCardView customCardView, ProgressBar progressBar, ViewPager2 viewPager2, CustomCardView customCardView2, ImageViewerPageIndicator imageViewerPageIndicator, CustomCardView customCardView3) {
        this.rootView = frameLayout;
        this.closeButton = customCardView;
        this.contentLoader = progressBar;
        this.contentPager = viewPager2;
        this.nextButton = customCardView2;
        this.pageIndicator = imageViewerPageIndicator;
        this.previousButton = customCardView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ArizonaImageViewerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ArizonaImageViewerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.arizona_image_viewer, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ArizonaImageViewerBinding bind(View view) {
        int i = R.id.close_button;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
        if (customCardView != null) {
            i = R.id.content_loader;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
            if (progressBar != null) {
                i = R.id.content_pager;
                ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i);
                if (viewPager2 != null) {
                    i = R.id.next_button;
                    CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                    if (customCardView2 != null) {
                        i = R.id.page_indicator;
                        ImageViewerPageIndicator imageViewerPageIndicator = (ImageViewerPageIndicator) ViewBindings.findChildViewById(view, i);
                        if (imageViewerPageIndicator != null) {
                            i = R.id.previous_button;
                            CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                            if (customCardView3 != null) {
                                return new ArizonaImageViewerBinding((FrameLayout) view, customCardView, progressBar, viewPager2, customCardView2, imageViewerPageIndicator, customCardView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
