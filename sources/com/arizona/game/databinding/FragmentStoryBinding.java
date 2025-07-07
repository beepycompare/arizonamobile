package com.arizona.game.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizona.common.ui.StoriesProgressView;
import com.arizona.game.R;
import com.google.android.material.button.MaterialButton;
/* loaded from: classes3.dex */
public final class FragmentStoryBinding implements ViewBinding {
    public final MaterialButton buttonMore;
    public final Guideline center;
    public final ConstraintLayout constraintLayout;
    public final Guideline guideline7;
    public final ImageView imageView44;
    private final ConstraintLayout rootView;
    public final TextView serverType;
    public final ImageView serverTypeBackground;
    public final StoriesProgressView stories;
    public final TextView storyDescription;
    public final ImageView storyImage;
    public final TextView textView17;

    private FragmentStoryBinding(ConstraintLayout rootView, MaterialButton buttonMore, Guideline center, ConstraintLayout constraintLayout, Guideline guideline7, ImageView imageView44, TextView serverType, ImageView serverTypeBackground, StoriesProgressView stories, TextView storyDescription, ImageView storyImage, TextView textView17) {
        this.rootView = rootView;
        this.buttonMore = buttonMore;
        this.center = center;
        this.constraintLayout = constraintLayout;
        this.guideline7 = guideline7;
        this.imageView44 = imageView44;
        this.serverType = serverType;
        this.serverTypeBackground = serverTypeBackground;
        this.stories = stories;
        this.storyDescription = storyDescription;
        this.storyImage = storyImage;
        this.textView17 = textView17;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentStoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentStoryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_story, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentStoryBinding bind(View rootView) {
        int i = R.id.button_more;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
        if (materialButton != null) {
            i = R.id.center;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
            if (guideline != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                i = R.id.guideline7;
                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                if (guideline2 != null) {
                    i = R.id.imageView44;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView != null) {
                        i = R.id.server_type;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView != null) {
                            i = R.id.server_type_background;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView2 != null) {
                                i = R.id.stories;
                                StoriesProgressView storiesProgressView = (StoriesProgressView) ViewBindings.findChildViewById(rootView, i);
                                if (storiesProgressView != null) {
                                    i = R.id.story_description;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView2 != null) {
                                        i = R.id.story_image;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                        if (imageView3 != null) {
                                            i = R.id.textView17;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView3 != null) {
                                                return new FragmentStoryBinding(constraintLayout, materialButton, guideline, constraintLayout, guideline2, imageView, textView, imageView2, storiesProgressView, textView2, imageView3, textView3);
                                            }
                                        }
                                    }
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
