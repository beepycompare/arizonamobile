package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class LayoutTintSettingsBinding implements ViewBinding {
    public final AppCompatButton btnMinus;
    public final AppCompatButton btnPlus;
    public final ConstraintLayout layoutTintSettings;
    public final ConstraintLayout parentLayout;
    private final ConstraintLayout rootView;
    public final RecyclerView rvColors;
    public final SeekBar seekBar;
    public final AppCompatTextView tvLightSettings;
    public final AppCompatTextView tvMiddle;
    public final AppCompatTextView tvMinus;
    public final AppCompatTextView tvPlus;
    public final TextView tvTitle;

    private LayoutTintSettingsBinding(ConstraintLayout rootView, AppCompatButton btnMinus, AppCompatButton btnPlus, ConstraintLayout layoutTintSettings, ConstraintLayout parentLayout, RecyclerView rvColors, SeekBar seekBar, AppCompatTextView tvLightSettings, AppCompatTextView tvMiddle, AppCompatTextView tvMinus, AppCompatTextView tvPlus, TextView tvTitle) {
        this.rootView = rootView;
        this.btnMinus = btnMinus;
        this.btnPlus = btnPlus;
        this.layoutTintSettings = layoutTintSettings;
        this.parentLayout = parentLayout;
        this.rvColors = rvColors;
        this.seekBar = seekBar;
        this.tvLightSettings = tvLightSettings;
        this.tvMiddle = tvMiddle;
        this.tvMinus = tvMinus;
        this.tvPlus = tvPlus;
        this.tvTitle = tvTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutTintSettingsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutTintSettingsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.layout_tint_settings, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutTintSettingsBinding bind(View rootView) {
        int i = R.id.btnMinus;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(rootView, i);
        if (appCompatButton != null) {
            i = R.id.btnPlus;
            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(rootView, i);
            if (appCompatButton2 != null) {
                i = R.id.layoutTintSettings;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                if (constraintLayout != null) {
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) rootView;
                    i = R.id.rvColors;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                    if (recyclerView != null) {
                        i = R.id.seekBar;
                        SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(rootView, i);
                        if (seekBar != null) {
                            i = R.id.tvLightSettings;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                            if (appCompatTextView != null) {
                                i = R.id.tvMiddle;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                if (appCompatTextView2 != null) {
                                    i = R.id.tvMinus;
                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                    if (appCompatTextView3 != null) {
                                        i = R.id.tvPlus;
                                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                        if (appCompatTextView4 != null) {
                                            i = R.id.tvTitle;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView != null) {
                                                return new LayoutTintSettingsBinding(constraintLayout2, appCompatButton, appCompatButton2, constraintLayout, constraintLayout2, recyclerView, seekBar, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, textView);
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
