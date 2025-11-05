package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class StreamVideoBinding implements ViewBinding {
    public final Guideline bottomLine;
    public final Guideline leftLine;
    public final Guideline rightLine;
    private final ConstraintLayout rootView;
    public final ConstraintLayout stream;
    public final Guideline topLine;
    public final YouTubePlayerView youtubePlayerViewFullscreen;
    public final YouTubePlayerView youtubePlayerViewPip;

    private StreamVideoBinding(ConstraintLayout rootView, Guideline bottomLine, Guideline leftLine, Guideline rightLine, ConstraintLayout stream, Guideline topLine, YouTubePlayerView youtubePlayerViewFullscreen, YouTubePlayerView youtubePlayerViewPip) {
        this.rootView = rootView;
        this.bottomLine = bottomLine;
        this.leftLine = leftLine;
        this.rightLine = rightLine;
        this.stream = stream;
        this.topLine = topLine;
        this.youtubePlayerViewFullscreen = youtubePlayerViewFullscreen;
        this.youtubePlayerViewPip = youtubePlayerViewPip;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static StreamVideoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static StreamVideoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.stream_video, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static StreamVideoBinding bind(View rootView) {
        int i = R.id.bottom_line;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
        if (guideline != null) {
            i = R.id.left_line;
            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
            if (guideline2 != null) {
                i = R.id.right_line;
                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                if (guideline3 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                    i = R.id.top_line;
                    Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                    if (guideline4 != null) {
                        i = R.id.youtube_player_view_fullscreen;
                        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) ViewBindings.findChildViewById(rootView, i);
                        if (youTubePlayerView != null) {
                            i = R.id.youtube_player_view_pip;
                            YouTubePlayerView youTubePlayerView2 = (YouTubePlayerView) ViewBindings.findChildViewById(rootView, i);
                            if (youTubePlayerView2 != null) {
                                return new StreamVideoBinding(constraintLayout, guideline, guideline2, guideline3, constraintLayout, guideline4, youTubePlayerView, youTubePlayerView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
