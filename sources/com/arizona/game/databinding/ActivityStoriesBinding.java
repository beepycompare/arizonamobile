package com.arizona.game.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.arizona.game.R;
/* loaded from: classes3.dex */
public final class ActivityStoriesBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final ViewPager2 viewPager;

    private ActivityStoriesBinding(FrameLayout rootView, ViewPager2 viewPager) {
        this.rootView = rootView;
        this.viewPager = viewPager;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivityStoriesBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityStoriesBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_stories, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityStoriesBinding bind(View rootView) {
        int i = R.id.view_pager;
        ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(rootView, i);
        if (viewPager2 != null) {
            return new ActivityStoriesBinding((FrameLayout) rootView, viewPager2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
