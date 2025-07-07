package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class AzVoiceUserSettingsBinding implements ViewBinding {
    public final AppCompatImageView appCompatImageView2;
    public final ConstraintLayout azUserVoiceSettingsLayout;
    public final AppCompatImageView closeButton;
    public final Guideline leftGuideline;
    public final Guideline rightGuideline;
    private final ConstraintLayout rootView;
    public final TextView textView5;
    public final RecyclerView usersSoundSlidersRecycler;
    public final Guideline verticalGuide;

    private AzVoiceUserSettingsBinding(ConstraintLayout rootView, AppCompatImageView appCompatImageView2, ConstraintLayout azUserVoiceSettingsLayout, AppCompatImageView closeButton, Guideline leftGuideline, Guideline rightGuideline, TextView textView5, RecyclerView usersSoundSlidersRecycler, Guideline verticalGuide) {
        this.rootView = rootView;
        this.appCompatImageView2 = appCompatImageView2;
        this.azUserVoiceSettingsLayout = azUserVoiceSettingsLayout;
        this.closeButton = closeButton;
        this.leftGuideline = leftGuideline;
        this.rightGuideline = rightGuideline;
        this.textView5 = textView5;
        this.usersSoundSlidersRecycler = usersSoundSlidersRecycler;
        this.verticalGuide = verticalGuide;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AzVoiceUserSettingsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AzVoiceUserSettingsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.az_voice_user_settings, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static AzVoiceUserSettingsBinding bind(View rootView) {
        int i = R.id.appCompatImageView2;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
        if (appCompatImageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
            i = R.id.closeButton;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
            if (appCompatImageView2 != null) {
                i = R.id.leftGuideline;
                Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                if (guideline != null) {
                    i = R.id.rightGuideline;
                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                    if (guideline2 != null) {
                        i = R.id.textView5;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView != null) {
                            i = R.id.users_sound_sliders_recycler;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                            if (recyclerView != null) {
                                i = R.id.verticalGuide;
                                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                if (guideline3 != null) {
                                    return new AzVoiceUserSettingsBinding(constraintLayout, appCompatImageView, constraintLayout, appCompatImageView2, guideline, guideline2, textView, recyclerView, guideline3);
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
