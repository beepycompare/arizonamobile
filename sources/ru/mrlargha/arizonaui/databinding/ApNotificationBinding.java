package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class ApNotificationBinding implements ViewBinding {
    public final Group groupBig;
    public final Guideline guideline23;
    public final Guideline guideline24;
    public final Guideline guideline25;
    public final AppCompatImageView imageView12;
    public final AppCompatImageView imageView17;
    public final AppCompatImageView imageView4;
    private final ConstraintLayout rootView;
    public final AppCompatImageView smallIcon;
    public final TextView textView15;

    private ApNotificationBinding(ConstraintLayout constraintLayout, Group group, Guideline guideline, Guideline guideline2, Guideline guideline3, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, TextView textView) {
        this.rootView = constraintLayout;
        this.groupBig = group;
        this.guideline23 = guideline;
        this.guideline24 = guideline2;
        this.guideline25 = guideline3;
        this.imageView12 = appCompatImageView;
        this.imageView17 = appCompatImageView2;
        this.imageView4 = appCompatImageView3;
        this.smallIcon = appCompatImageView4;
        this.textView15 = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ApNotificationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ApNotificationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.ap_notification, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ApNotificationBinding bind(View view) {
        int i = R.id.group_big;
        Group group = (Group) ViewBindings.findChildViewById(view, i);
        if (group != null) {
            i = R.id.guideline23;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
            if (guideline != null) {
                i = R.id.guideline24;
                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                if (guideline2 != null) {
                    i = R.id.guideline25;
                    Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                    if (guideline3 != null) {
                        i = R.id.imageView12;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                        if (appCompatImageView != null) {
                            i = R.id.imageView17;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                            if (appCompatImageView2 != null) {
                                i = R.id.imageView4;
                                AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                if (appCompatImageView3 != null) {
                                    i = R.id.small_icon;
                                    AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                    if (appCompatImageView4 != null) {
                                        i = R.id.textView15;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView != null) {
                                            return new ApNotificationBinding((ConstraintLayout) view, group, guideline, guideline2, guideline3, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, textView);
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
