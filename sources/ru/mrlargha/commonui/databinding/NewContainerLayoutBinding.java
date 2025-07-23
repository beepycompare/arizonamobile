package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class NewContainerLayoutBinding implements ViewBinding {
    public final ConstraintLayout actionButton;
    public final TextView actionButtonText;
    public final ConstraintLayout blurContainer;
    public final Guideline bottomLine;
    public final TextView containerTitle;
    public final ImageView exitButton;
    public final Guideline leftLine;
    public final RecyclerView listAwardsPremium;
    public final ImageView mainImageContainer;
    public final ConstraintLayout newContainer;
    public final Guideline rightLine;
    private final ConstraintLayout rootView;

    private NewContainerLayoutBinding(ConstraintLayout rootView, ConstraintLayout actionButton, TextView actionButtonText, ConstraintLayout blurContainer, Guideline bottomLine, TextView containerTitle, ImageView exitButton, Guideline leftLine, RecyclerView listAwardsPremium, ImageView mainImageContainer, ConstraintLayout newContainer, Guideline rightLine) {
        this.rootView = rootView;
        this.actionButton = actionButton;
        this.actionButtonText = actionButtonText;
        this.blurContainer = blurContainer;
        this.bottomLine = bottomLine;
        this.containerTitle = containerTitle;
        this.exitButton = exitButton;
        this.leftLine = leftLine;
        this.listAwardsPremium = listAwardsPremium;
        this.mainImageContainer = mainImageContainer;
        this.newContainer = newContainer;
        this.rightLine = rightLine;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static NewContainerLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static NewContainerLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.new_container_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static NewContainerLayoutBinding bind(View rootView) {
        int i = R.id.action_button;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
        if (constraintLayout != null) {
            i = R.id.action_button_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.blur_container;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                if (constraintLayout2 != null) {
                    i = R.id.bottom_line;
                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                    if (guideline != null) {
                        i = R.id.container_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            i = R.id.exit_button;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView != null) {
                                i = R.id.left_line;
                                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                if (guideline2 != null) {
                                    i = R.id.list_awards_premium;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                    if (recyclerView != null) {
                                        i = R.id.main_image_container;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                        if (imageView2 != null) {
                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) rootView;
                                            i = R.id.right_line;
                                            Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                            if (guideline3 != null) {
                                                return new NewContainerLayoutBinding(constraintLayout3, constraintLayout, textView, constraintLayout2, guideline, textView2, imageView, guideline2, recyclerView, imageView2, constraintLayout3, guideline3);
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
