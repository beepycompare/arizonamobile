package ru.mrlargha.arizonaui.databinding;

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
import ru.mrlargha.arizonaui.R;
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

    private NewContainerLayoutBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, ConstraintLayout constraintLayout3, Guideline guideline, TextView textView2, ImageView imageView, Guideline guideline2, RecyclerView recyclerView, ImageView imageView2, ConstraintLayout constraintLayout4, Guideline guideline3) {
        this.rootView = constraintLayout;
        this.actionButton = constraintLayout2;
        this.actionButtonText = textView;
        this.blurContainer = constraintLayout3;
        this.bottomLine = guideline;
        this.containerTitle = textView2;
        this.exitButton = imageView;
        this.leftLine = guideline2;
        this.listAwardsPremium = recyclerView;
        this.mainImageContainer = imageView2;
        this.newContainer = constraintLayout4;
        this.rightLine = guideline3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static NewContainerLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static NewContainerLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.new_container_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NewContainerLayoutBinding bind(View view) {
        int i = R.id.action_button;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.action_button_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.blur_container;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout2 != null) {
                    i = R.id.bottom_line;
                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                    if (guideline != null) {
                        i = R.id.container_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.exit_button;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView != null) {
                                i = R.id.left_line;
                                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                if (guideline2 != null) {
                                    i = R.id.list_awards_premium;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                    if (recyclerView != null) {
                                        i = R.id.main_image_container;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView2 != null) {
                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) view;
                                            i = R.id.right_line;
                                            Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
