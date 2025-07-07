package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class BackgroundVideoBinding implements ViewBinding {
    public final AppCompatImageView exitButton;
    public final ProgressBar loaderBar;
    public final TextView loadingText;
    private final ConstraintLayout rootView;
    public final ConstraintLayout video;
    public final VideoView videoBg;

    private BackgroundVideoBinding(ConstraintLayout rootView, AppCompatImageView exitButton, ProgressBar loaderBar, TextView loadingText, ConstraintLayout video, VideoView videoBg) {
        this.rootView = rootView;
        this.exitButton = exitButton;
        this.loaderBar = loaderBar;
        this.loadingText = loadingText;
        this.video = video;
        this.videoBg = videoBg;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BackgroundVideoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BackgroundVideoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.background_video, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static BackgroundVideoBinding bind(View rootView) {
        int i = R.id.exit_button;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
        if (appCompatImageView != null) {
            i = R.id.loader_bar;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
            if (progressBar != null) {
                i = R.id.loading_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                    i = R.id.video_bg;
                    VideoView videoView = (VideoView) ViewBindings.findChildViewById(rootView, i);
                    if (videoView != null) {
                        return new BackgroundVideoBinding(constraintLayout, appCompatImageView, progressBar, textView, constraintLayout, videoView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
