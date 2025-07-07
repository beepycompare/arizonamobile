package com.arizona.game.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.arizona.game.R;
import com.google.android.material.tabs.TabLayout;
/* loaded from: classes3.dex */
public final class FragmentServersBinding implements ViewBinding {
    public final ImageView backIcon;
    public final LinearLayout backLayout;
    public final TextView backText;
    public final ImageView imageView;
    public final ConstraintLayout linearLayout2;
    private final ConstraintLayout rootView;
    public final FrameLayout tabLayout;
    public final TabLayout tabs;
    public final ViewPager2 viewpager;

    private FragmentServersBinding(ConstraintLayout rootView, ImageView backIcon, LinearLayout backLayout, TextView backText, ImageView imageView, ConstraintLayout linearLayout2, FrameLayout tabLayout, TabLayout tabs, ViewPager2 viewpager) {
        this.rootView = rootView;
        this.backIcon = backIcon;
        this.backLayout = backLayout;
        this.backText = backText;
        this.imageView = imageView;
        this.linearLayout2 = linearLayout2;
        this.tabLayout = tabLayout;
        this.tabs = tabs;
        this.viewpager = viewpager;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentServersBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentServersBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_servers, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentServersBinding bind(View rootView) {
        int i = R.id.back_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.back_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                i = R.id.back_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.imageView;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView2 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                        i = R.id.tab_layout;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                        if (frameLayout != null) {
                            i = R.id.tabs;
                            TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(rootView, i);
                            if (tabLayout != null) {
                                i = R.id.viewpager;
                                ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(rootView, i);
                                if (viewPager2 != null) {
                                    return new FragmentServersBinding(constraintLayout, imageView, linearLayout, textView, imageView2, constraintLayout, frameLayout, tabLayout, viewPager2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
