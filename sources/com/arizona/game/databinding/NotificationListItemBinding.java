package com.arizona.game.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizona.game.R;
/* loaded from: classes3.dex */
public final class NotificationListItemBinding implements ViewBinding {
    public final Guideline guideline26;
    public final ImageView imageView24;
    public final TextView notificationContent;
    public final ImageView notificationImage;
    public final TextView notificationTitle;
    private final FrameLayout rootView;

    private NotificationListItemBinding(FrameLayout rootView, Guideline guideline26, ImageView imageView24, TextView notificationContent, ImageView notificationImage, TextView notificationTitle) {
        this.rootView = rootView;
        this.guideline26 = guideline26;
        this.imageView24 = imageView24;
        this.notificationContent = notificationContent;
        this.notificationImage = notificationImage;
        this.notificationTitle = notificationTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static NotificationListItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static NotificationListItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.notification_list_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static NotificationListItemBinding bind(View rootView) {
        int i = R.id.guideline26;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
        if (guideline != null) {
            i = R.id.imageView24;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.notification_content;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.notification_image;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView2 != null) {
                        i = R.id.notification_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            return new NotificationListItemBinding((FrameLayout) rootView, guideline, imageView, textView, imageView2, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
