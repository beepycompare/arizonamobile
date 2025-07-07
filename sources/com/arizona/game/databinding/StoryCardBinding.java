package com.arizona.game.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizona.game.R;
import com.google.android.material.imageview.ShapeableImageView;
/* loaded from: classes3.dex */
public final class StoryCardBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final ShapeableImageView storyBg;
    public final TextView storyName;

    private StoryCardBinding(ConstraintLayout rootView, ShapeableImageView storyBg, TextView storyName) {
        this.rootView = rootView;
        this.storyBg = storyBg;
        this.storyName = storyName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static StoryCardBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static StoryCardBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.story_card, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static StoryCardBinding bind(View rootView) {
        int i = R.id.story_bg;
        ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(rootView, i);
        if (shapeableImageView != null) {
            i = R.id.story_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                return new StoryCardBinding((ConstraintLayout) rootView, shapeableImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
