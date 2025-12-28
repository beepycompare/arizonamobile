package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class AzVoiceSettingsBinding implements ViewBinding {
    public final AppCompatImageView appCompatImageView2;
    public final AppCompatImageView closeButton;
    public final ConstraintLayout formLayout;
    public final Guideline leftGuideline;
    public final LinearLayout linearLayout6;
    public final TextView microStateText;
    public final SwitchCompat microSwitch;
    public final LinearLayout nearestPlayers;
    public final Guideline rightGuideline;
    private final ConstraintLayout rootView;
    public final RecyclerView slidersRecycler;
    public final TextView textView5;
    public final Guideline verticalGuide;
    public final TextView viewPlayers;

    private AzVoiceSettingsBinding(ConstraintLayout rootView, AppCompatImageView appCompatImageView2, AppCompatImageView closeButton, ConstraintLayout formLayout, Guideline leftGuideline, LinearLayout linearLayout6, TextView microStateText, SwitchCompat microSwitch, LinearLayout nearestPlayers, Guideline rightGuideline, RecyclerView slidersRecycler, TextView textView5, Guideline verticalGuide, TextView viewPlayers) {
        this.rootView = rootView;
        this.appCompatImageView2 = appCompatImageView2;
        this.closeButton = closeButton;
        this.formLayout = formLayout;
        this.leftGuideline = leftGuideline;
        this.linearLayout6 = linearLayout6;
        this.microStateText = microStateText;
        this.microSwitch = microSwitch;
        this.nearestPlayers = nearestPlayers;
        this.rightGuideline = rightGuideline;
        this.slidersRecycler = slidersRecycler;
        this.textView5 = textView5;
        this.verticalGuide = verticalGuide;
        this.viewPlayers = viewPlayers;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AzVoiceSettingsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AzVoiceSettingsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.az_voice_settings, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static AzVoiceSettingsBinding bind(View rootView) {
        int i = R.id.appCompatImageView2;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
        if (appCompatImageView != null) {
            i = R.id.closeButton;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
            if (appCompatImageView2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                i = R.id.leftGuideline;
                Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                if (guideline != null) {
                    i = R.id.linearLayout6;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout != null) {
                        i = R.id.micro_state_text;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView != null) {
                            i = R.id.micro_switch;
                            SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(rootView, i);
                            if (switchCompat != null) {
                                i = R.id.nearestPlayers;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                if (linearLayout2 != null) {
                                    i = R.id.rightGuideline;
                                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                    if (guideline2 != null) {
                                        i = R.id.slidersRecycler;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                        if (recyclerView != null) {
                                            i = R.id.textView5;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView2 != null) {
                                                i = R.id.verticalGuide;
                                                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                if (guideline3 != null) {
                                                    i = R.id.viewPlayers;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView3 != null) {
                                                        return new AzVoiceSettingsBinding(constraintLayout, appCompatImageView, appCompatImageView2, constraintLayout, guideline, linearLayout, textView, switchCompat, linearLayout2, guideline2, recyclerView, textView2, guideline3, textView3);
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
