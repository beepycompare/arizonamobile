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
/* loaded from: classes3.dex */
public final class NewContainerAwardItemBinding implements ViewBinding {
    public final ImageView awardIc;
    public final ConstraintLayout awardItem;
    public final TextView count;
    private final ConstraintLayout rootView;
    public final TextView title;

    private NewContainerAwardItemBinding(ConstraintLayout rootView, ImageView awardIc, ConstraintLayout awardItem, TextView count, TextView title) {
        this.rootView = rootView;
        this.awardIc = awardIc;
        this.awardItem = awardItem;
        this.count = count;
        this.title = title;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static NewContainerAwardItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static NewContainerAwardItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.new_container_award_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static NewContainerAwardItemBinding bind(View rootView) {
        int i = R.id.award_ic;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
            i = R.id.count;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    return new NewContainerAwardItemBinding(constraintLayout, imageView, constraintLayout, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
