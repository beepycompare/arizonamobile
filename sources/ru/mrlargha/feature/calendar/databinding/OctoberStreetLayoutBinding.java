package ru.mrlargha.feature.calendar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.calendar.LeftFadingEdgeRecyclerView;
import ru.mrlargha.feature.calendar.R;
/* loaded from: classes6.dex */
public final class OctoberStreetLayoutBinding implements ViewBinding {
    public final LinearLayout contentContainer;
    public final ImageView exitButton;
    public final FrameLayout headerContainer;
    public final FrameLayout octoberStreetLayout;
    public final LeftFadingEdgeRecyclerView rewardsRc;
    private final FrameLayout rootView;
    public final CustomCardView scrollbarThumb;
    public final CustomCardView scrollbarTrack;

    private OctoberStreetLayoutBinding(FrameLayout frameLayout, LinearLayout linearLayout, ImageView imageView, FrameLayout frameLayout2, FrameLayout frameLayout3, LeftFadingEdgeRecyclerView leftFadingEdgeRecyclerView, CustomCardView customCardView, CustomCardView customCardView2) {
        this.rootView = frameLayout;
        this.contentContainer = linearLayout;
        this.exitButton = imageView;
        this.headerContainer = frameLayout2;
        this.octoberStreetLayout = frameLayout3;
        this.rewardsRc = leftFadingEdgeRecyclerView;
        this.scrollbarThumb = customCardView;
        this.scrollbarTrack = customCardView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static OctoberStreetLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static OctoberStreetLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.october_street_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static OctoberStreetLayoutBinding bind(View view) {
        int i = R.id.content_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.exit_button;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.header_container;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    FrameLayout frameLayout2 = (FrameLayout) view;
                    i = R.id.rewards_rc;
                    LeftFadingEdgeRecyclerView leftFadingEdgeRecyclerView = (LeftFadingEdgeRecyclerView) ViewBindings.findChildViewById(view, i);
                    if (leftFadingEdgeRecyclerView != null) {
                        i = R.id.scrollbar_thumb;
                        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
                        if (customCardView != null) {
                            i = R.id.scrollbar_track;
                            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                            if (customCardView2 != null) {
                                return new OctoberStreetLayoutBinding(frameLayout2, linearLayout, imageView, frameLayout, frameLayout2, leftFadingEdgeRecyclerView, customCardView, customCardView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
