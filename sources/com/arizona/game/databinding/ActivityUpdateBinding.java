package com.arizona.game.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.media3.exoplayer.video.spherical.SphericalGLSurfaceView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizona.game.R;
import com.google.android.material.imageview.ShapeableImageView;
/* loaded from: classes3.dex */
public final class ActivityUpdateBinding implements ViewBinding {
    public final TextView bytesDownloaded;
    public final TextView currentLen;
    public final TextView currentSpeed;
    public final Guideline endLine;
    public final ShapeableImageView icon;
    public final ImageView imageView22;
    public final ImageView imageView44;
    public final ImageView ivVolumeOff;
    public final ImageView ivVolumeOn;
    public final SphericalGLSurfaceView playerView;
    public final TextView progress;
    public final ProgressBar progressBar;
    public final TextView replayVideo;
    private final ConstraintLayout rootView;
    public final TextView speedDownloaded;
    public final Guideline startLine;
    public final TextView textView13;
    public final TextView textView14;
    public final TextView textView15;
    public final TextView textView16;
    public final TextView updateState;

    private ActivityUpdateBinding(ConstraintLayout rootView, TextView bytesDownloaded, TextView currentLen, TextView currentSpeed, Guideline endLine, ShapeableImageView icon, ImageView imageView22, ImageView imageView44, ImageView ivVolumeOff, ImageView ivVolumeOn, SphericalGLSurfaceView playerView, TextView progress, ProgressBar progressBar, TextView replayVideo, TextView speedDownloaded, Guideline startLine, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView updateState) {
        this.rootView = rootView;
        this.bytesDownloaded = bytesDownloaded;
        this.currentLen = currentLen;
        this.currentSpeed = currentSpeed;
        this.endLine = endLine;
        this.icon = icon;
        this.imageView22 = imageView22;
        this.imageView44 = imageView44;
        this.ivVolumeOff = ivVolumeOff;
        this.ivVolumeOn = ivVolumeOn;
        this.playerView = playerView;
        this.progress = progress;
        this.progressBar = progressBar;
        this.replayVideo = replayVideo;
        this.speedDownloaded = speedDownloaded;
        this.startLine = startLine;
        this.textView13 = textView13;
        this.textView14 = textView14;
        this.textView15 = textView15;
        this.textView16 = textView16;
        this.updateState = updateState;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityUpdateBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityUpdateBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_update, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityUpdateBinding bind(View rootView) {
        int i = R.id.bytes_downloaded;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.current_len;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.current_speed;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.end_line;
                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                    if (guideline != null) {
                        i = R.id.icon;
                        ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(rootView, i);
                        if (shapeableImageView != null) {
                            i = R.id.imageView22;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView != null) {
                                i = R.id.imageView44;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                if (imageView2 != null) {
                                    i = R.id.ivVolumeOff;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                    if (imageView3 != null) {
                                        i = R.id.ivVolumeOn;
                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                        if (imageView4 != null) {
                                            i = R.id.playerView;
                                            SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) ViewBindings.findChildViewById(rootView, i);
                                            if (sphericalGLSurfaceView != null) {
                                                i = R.id.progress;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView4 != null) {
                                                    i = R.id.progressBar;
                                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                                                    if (progressBar != null) {
                                                        i = R.id.replayVideo;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (textView5 != null) {
                                                            i = R.id.speed_downloaded;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView6 != null) {
                                                                i = R.id.start_line;
                                                                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                                if (guideline2 != null) {
                                                                    i = R.id.textView13;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (textView7 != null) {
                                                                        i = R.id.textView14;
                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (textView8 != null) {
                                                                            i = R.id.textView15;
                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (textView9 != null) {
                                                                                i = R.id.textView16;
                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                if (textView10 != null) {
                                                                                    i = R.id.update_state;
                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (textView11 != null) {
                                                                                        return new ActivityUpdateBinding((ConstraintLayout) rootView, textView, textView2, textView3, guideline, shapeableImageView, imageView, imageView2, imageView3, imageView4, sphericalGLSurfaceView, textView4, progressBar, textView5, textView6, guideline2, textView7, textView8, textView9, textView10, textView11);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
