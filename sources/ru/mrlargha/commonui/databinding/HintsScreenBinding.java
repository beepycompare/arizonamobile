package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class HintsScreenBinding implements ViewBinding {
    public final ConstraintLayout leftHint;
    public final ImageView leftHintCloseButton;
    public final ConstraintLayout leftHintContainer;
    public final TextView leftHintContainerText;
    public final ImageView leftHintPerson;
    public final ConstraintLayout rightHint;
    public final ImageView rightHintCloseButton;
    public final ConstraintLayout rightHintContainer;
    public final TextView rightHintContainerText;
    public final ImageView rightHintPerson;
    private final ConstraintLayout rootView;
    public final ConstraintLayout streetFood;

    private HintsScreenBinding(ConstraintLayout rootView, ConstraintLayout leftHint, ImageView leftHintCloseButton, ConstraintLayout leftHintContainer, TextView leftHintContainerText, ImageView leftHintPerson, ConstraintLayout rightHint, ImageView rightHintCloseButton, ConstraintLayout rightHintContainer, TextView rightHintContainerText, ImageView rightHintPerson, ConstraintLayout streetFood) {
        this.rootView = rootView;
        this.leftHint = leftHint;
        this.leftHintCloseButton = leftHintCloseButton;
        this.leftHintContainer = leftHintContainer;
        this.leftHintContainerText = leftHintContainerText;
        this.leftHintPerson = leftHintPerson;
        this.rightHint = rightHint;
        this.rightHintCloseButton = rightHintCloseButton;
        this.rightHintContainer = rightHintContainer;
        this.rightHintContainerText = rightHintContainerText;
        this.rightHintPerson = rightHintPerson;
        this.streetFood = streetFood;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HintsScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HintsScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hints_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HintsScreenBinding bind(View rootView) {
        int i = R.id.left_hint;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
        if (constraintLayout != null) {
            i = R.id.left_hint_close_button;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.left_hint_container;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                if (constraintLayout2 != null) {
                    i = R.id.left_hint_container_text;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null) {
                        i = R.id.left_hint_person;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView2 != null) {
                            i = R.id.right_hint;
                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                            if (constraintLayout3 != null) {
                                i = R.id.right_hint_close_button;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                if (imageView3 != null) {
                                    i = R.id.right_hint_container;
                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (constraintLayout4 != null) {
                                        i = R.id.right_hint_container_text;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView2 != null) {
                                            i = R.id.right_hint_person;
                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                            if (imageView4 != null) {
                                                ConstraintLayout constraintLayout5 = (ConstraintLayout) rootView;
                                                return new HintsScreenBinding(constraintLayout5, constraintLayout, imageView, constraintLayout2, textView, imageView2, constraintLayout3, imageView3, constraintLayout4, textView2, imageView4, constraintLayout5);
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
