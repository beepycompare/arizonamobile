package ru.mrlargha.feature.item.rating.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.item.rating.R;
/* loaded from: classes6.dex */
public final class RatingScreenBinding implements ViewBinding {
    public final CustomCardView close;
    public final LinearLayout filter1;
    public final ImageView filter1ic;
    public final LinearLayout filter2;
    public final ImageView filter2ic;
    public final CustomCardView filterLayout;
    public final View filterOverlay;
    public final RatingFullscreenItemBinding fullscreen;
    public final RatingListBinding list;
    private final ConstraintLayout rootView;
    public final TextView title;
    public final ConstraintLayout transportScreen;

    private RatingScreenBinding(ConstraintLayout constraintLayout, CustomCardView customCardView, LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, ImageView imageView2, CustomCardView customCardView2, View view, RatingFullscreenItemBinding ratingFullscreenItemBinding, RatingListBinding ratingListBinding, TextView textView, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.close = customCardView;
        this.filter1 = linearLayout;
        this.filter1ic = imageView;
        this.filter2 = linearLayout2;
        this.filter2ic = imageView2;
        this.filterLayout = customCardView2;
        this.filterOverlay = view;
        this.fullscreen = ratingFullscreenItemBinding;
        this.list = ratingListBinding;
        this.title = textView;
        this.transportScreen = constraintLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RatingScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static RatingScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.rating_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static RatingScreenBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        int i = R.id.close;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
        if (customCardView != null) {
            i = R.id.filter1;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.filter1ic;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.filter2;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = R.id.filter2ic;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.filter_layout;
                            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                            if (customCardView2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.filter_overlay))) != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.fullscreen))) != null) {
                                RatingFullscreenItemBinding bind = RatingFullscreenItemBinding.bind(findChildViewById2);
                                i = R.id.list;
                                View findChildViewById3 = ViewBindings.findChildViewById(view, i);
                                if (findChildViewById3 != null) {
                                    RatingListBinding bind2 = RatingListBinding.bind(findChildViewById3);
                                    i = R.id.title;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                        return new RatingScreenBinding(constraintLayout, customCardView, linearLayout, imageView, linearLayout2, imageView2, customCardView2, findChildViewById, bind, bind2, textView, constraintLayout);
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
