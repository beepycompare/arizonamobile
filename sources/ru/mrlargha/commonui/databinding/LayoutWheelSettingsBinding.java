package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class LayoutWheelSettingsBinding implements ViewBinding {
    public final AppCompatButton btnFrontMinus;
    public final AppCompatButton btnFrontPlus;
    public final AppCompatButton btnRearMinus;
    public final AppCompatButton btnRearPlus;
    public final ConstraintLayout layoutFrontWheels;
    public final ConstraintLayout layoutRearWheels;
    public final ConstraintLayout parentLayout;
    private final ConstraintLayout rootView;
    public final SeekBar seekBarFront;
    public final SeekBar seekBarRear;
    public final AppCompatTextView tvFrontMiddle;
    public final AppCompatTextView tvFrontMinus;
    public final AppCompatTextView tvFrontPlus;
    public final AppCompatTextView tvFrontWheels;
    public final AppCompatTextView tvRearMiddle;
    public final AppCompatTextView tvRearMinus;
    public final AppCompatTextView tvRearPlus;
    public final AppCompatTextView tvRearWheels;
    public final AppCompatTextView tvTitle;

    private LayoutWheelSettingsBinding(ConstraintLayout rootView, AppCompatButton btnFrontMinus, AppCompatButton btnFrontPlus, AppCompatButton btnRearMinus, AppCompatButton btnRearPlus, ConstraintLayout layoutFrontWheels, ConstraintLayout layoutRearWheels, ConstraintLayout parentLayout, SeekBar seekBarFront, SeekBar seekBarRear, AppCompatTextView tvFrontMiddle, AppCompatTextView tvFrontMinus, AppCompatTextView tvFrontPlus, AppCompatTextView tvFrontWheels, AppCompatTextView tvRearMiddle, AppCompatTextView tvRearMinus, AppCompatTextView tvRearPlus, AppCompatTextView tvRearWheels, AppCompatTextView tvTitle) {
        this.rootView = rootView;
        this.btnFrontMinus = btnFrontMinus;
        this.btnFrontPlus = btnFrontPlus;
        this.btnRearMinus = btnRearMinus;
        this.btnRearPlus = btnRearPlus;
        this.layoutFrontWheels = layoutFrontWheels;
        this.layoutRearWheels = layoutRearWheels;
        this.parentLayout = parentLayout;
        this.seekBarFront = seekBarFront;
        this.seekBarRear = seekBarRear;
        this.tvFrontMiddle = tvFrontMiddle;
        this.tvFrontMinus = tvFrontMinus;
        this.tvFrontPlus = tvFrontPlus;
        this.tvFrontWheels = tvFrontWheels;
        this.tvRearMiddle = tvRearMiddle;
        this.tvRearMinus = tvRearMinus;
        this.tvRearPlus = tvRearPlus;
        this.tvRearWheels = tvRearWheels;
        this.tvTitle = tvTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutWheelSettingsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutWheelSettingsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.layout_wheel_settings, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutWheelSettingsBinding bind(View rootView) {
        int i = R.id.btnFrontMinus;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(rootView, i);
        if (appCompatButton != null) {
            i = R.id.btnFrontPlus;
            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(rootView, i);
            if (appCompatButton2 != null) {
                i = R.id.btnRearMinus;
                AppCompatButton appCompatButton3 = (AppCompatButton) ViewBindings.findChildViewById(rootView, i);
                if (appCompatButton3 != null) {
                    i = R.id.btnRearPlus;
                    AppCompatButton appCompatButton4 = (AppCompatButton) ViewBindings.findChildViewById(rootView, i);
                    if (appCompatButton4 != null) {
                        i = R.id.layoutFrontWheels;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                        if (constraintLayout != null) {
                            i = R.id.layoutRearWheels;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                            if (constraintLayout2 != null) {
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) rootView;
                                i = R.id.seekBarFront;
                                SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(rootView, i);
                                if (seekBar != null) {
                                    i = R.id.seekBarRear;
                                    SeekBar seekBar2 = (SeekBar) ViewBindings.findChildViewById(rootView, i);
                                    if (seekBar2 != null) {
                                        i = R.id.tvFrontMiddle;
                                        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                        if (appCompatTextView != null) {
                                            i = R.id.tvFrontMinus;
                                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                            if (appCompatTextView2 != null) {
                                                i = R.id.tvFrontPlus;
                                                AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                                if (appCompatTextView3 != null) {
                                                    i = R.id.tvFrontWheels;
                                                    AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (appCompatTextView4 != null) {
                                                        i = R.id.tvRearMiddle;
                                                        AppCompatTextView appCompatTextView5 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (appCompatTextView5 != null) {
                                                            i = R.id.tvRearMinus;
                                                            AppCompatTextView appCompatTextView6 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (appCompatTextView6 != null) {
                                                                i = R.id.tvRearPlus;
                                                                AppCompatTextView appCompatTextView7 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                                                if (appCompatTextView7 != null) {
                                                                    i = R.id.tvRearWheels;
                                                                    AppCompatTextView appCompatTextView8 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (appCompatTextView8 != null) {
                                                                        i = R.id.tvTitle;
                                                                        AppCompatTextView appCompatTextView9 = (AppCompatTextView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (appCompatTextView9 != null) {
                                                                            return new LayoutWheelSettingsBinding(constraintLayout3, appCompatButton, appCompatButton2, appCompatButton3, appCompatButton4, constraintLayout, constraintLayout2, constraintLayout3, seekBar, seekBar2, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6, appCompatTextView7, appCompatTextView8, appCompatTextView9);
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
