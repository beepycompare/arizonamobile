package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.slider.Slider;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class SoundSliderBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final Slider slider;
    public final TextView sliderName;
    public final TextView sliderValue;

    private SoundSliderBinding(ConstraintLayout rootView, Slider slider, TextView sliderName, TextView sliderValue) {
        this.rootView = rootView;
        this.slider = slider;
        this.sliderName = sliderName;
        this.sliderValue = sliderValue;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SoundSliderBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SoundSliderBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.sound_slider, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static SoundSliderBinding bind(View rootView) {
        int i = R.id.slider;
        Slider slider = (Slider) ViewBindings.findChildViewById(rootView, i);
        if (slider != null) {
            i = R.id.slider_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.slider_value;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    return new SoundSliderBinding((ConstraintLayout) rootView, slider, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
