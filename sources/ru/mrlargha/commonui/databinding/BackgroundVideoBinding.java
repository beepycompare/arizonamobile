package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.ui.PlayerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class BackgroundVideoBinding implements ViewBinding {
    public final LinearLayout btnContainer;
    public final CustomCardView btnPlay;
    public final CustomCardView btnSound;
    public final AppCompatImageView exitButton;
    public final ImageView ivPlay;
    public final ImageView ivSound;
    public final ProgressBar loaderBar;
    public final TextView loadingText;
    public final PlayerView playerView;
    private final ConstraintLayout rootView;
    public final ConstraintLayout video;

    private BackgroundVideoBinding(ConstraintLayout rootView, LinearLayout btnContainer, CustomCardView btnPlay, CustomCardView btnSound, AppCompatImageView exitButton, ImageView ivPlay, ImageView ivSound, ProgressBar loaderBar, TextView loadingText, PlayerView playerView, ConstraintLayout video) {
        this.rootView = rootView;
        this.btnContainer = btnContainer;
        this.btnPlay = btnPlay;
        this.btnSound = btnSound;
        this.exitButton = exitButton;
        this.ivPlay = ivPlay;
        this.ivSound = ivSound;
        this.loaderBar = loaderBar;
        this.loadingText = loadingText;
        this.playerView = playerView;
        this.video = video;
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
        int i = R.id.btn_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.btn_play;
            CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
            if (customCardView != null) {
                i = R.id.btn_sound;
                CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                if (customCardView2 != null) {
                    i = R.id.exit_button;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                    if (appCompatImageView != null) {
                        i = R.id.iv_play;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView != null) {
                            i = R.id.iv_sound;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView2 != null) {
                                i = R.id.loader_bar;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                                if (progressBar != null) {
                                    i = R.id.loading_text;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView != null) {
                                        i = R.id.playerView;
                                        PlayerView playerView = (PlayerView) ViewBindings.findChildViewById(rootView, i);
                                        if (playerView != null) {
                                            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                                            return new BackgroundVideoBinding(constraintLayout, linearLayout, customCardView, customCardView2, appCompatImageView, imageView, imageView2, progressBar, textView, playerView, constraintLayout);
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
