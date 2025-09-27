package ru.mrlargha.feature.event.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.event.R;
/* loaded from: classes6.dex */
public final class EventMainResultScreenBinding implements ViewBinding {
    public final TextView awardName;
    public final TextView count;
    public final ImageView ivAward;
    public final LinearLayout resultBack;
    private final ConstraintLayout rootView;
    public final TextView tvDescription;

    private EventMainResultScreenBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, ImageView imageView, LinearLayout linearLayout, TextView textView3) {
        this.rootView = constraintLayout;
        this.awardName = textView;
        this.count = textView2;
        this.ivAward = imageView;
        this.resultBack = linearLayout;
        this.tvDescription = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static EventMainResultScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static EventMainResultScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.event_main_result_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EventMainResultScreenBinding bind(View view) {
        int i = R.id.award_name;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.count;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.iv_award;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.result_back;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R.id.tv_description;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            return new EventMainResultScreenBinding((ConstraintLayout) view, textView, textView2, imageView, linearLayout, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
