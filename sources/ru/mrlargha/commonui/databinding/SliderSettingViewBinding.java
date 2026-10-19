package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class SliderSettingViewBinding implements ViewBinding {
    private final View rootView;
    public final AppCompatSeekBar slider;

    private SliderSettingViewBinding(View rootView, AppCompatSeekBar slider) {
        this.rootView = rootView;
        this.slider = slider;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static SliderSettingViewBinding inflate(LayoutInflater inflater, ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.slider_setting_view, parent);
        return bind(parent);
    }

    public static SliderSettingViewBinding bind(View rootView) {
        int i = R.id.slider;
        AppCompatSeekBar appCompatSeekBar = (AppCompatSeekBar) ViewBindings.findChildViewById(rootView, i);
        if (appCompatSeekBar != null) {
            return new SliderSettingViewBinding(rootView, appCompatSeekBar);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
