package com.arizona.game.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizona.game.R;
/* loaded from: classes3.dex */
public final class SelectableValueSettingBinding implements ViewBinding {
    public final ImageView imageView12;
    private final ConstraintLayout rootView;
    public final ImageView settingIcon;
    public final TextView settingName;
    public final Spinner settingSpinner;

    private SelectableValueSettingBinding(ConstraintLayout rootView, ImageView imageView12, ImageView settingIcon, TextView settingName, Spinner settingSpinner) {
        this.rootView = rootView;
        this.imageView12 = imageView12;
        this.settingIcon = settingIcon;
        this.settingName = settingName;
        this.settingSpinner = settingSpinner;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SelectableValueSettingBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SelectableValueSettingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.selectable_value_setting, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static SelectableValueSettingBinding bind(View rootView) {
        int i = R.id.imageView12;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.setting_icon;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView2 != null) {
                i = R.id.setting_name;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.setting_spinner;
                    Spinner spinner = (Spinner) ViewBindings.findChildViewById(rootView, i);
                    if (spinner != null) {
                        return new SelectableValueSettingBinding((ConstraintLayout) rootView, imageView, imageView2, textView, spinner);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
