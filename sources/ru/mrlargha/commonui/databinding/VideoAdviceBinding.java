package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.media3.ui.PlayerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class VideoAdviceBinding implements ViewBinding {
    public final FrameLayout btnSkip;
    private final FrameLayout rootView;
    public final LinearLayout skipQuest;
    public final FrameLayout videoAdvice;
    public final PlayerView videoAdviceBg;

    private VideoAdviceBinding(FrameLayout rootView, FrameLayout btnSkip, LinearLayout skipQuest, FrameLayout videoAdvice, PlayerView videoAdviceBg) {
        this.rootView = rootView;
        this.btnSkip = btnSkip;
        this.skipQuest = skipQuest;
        this.videoAdvice = videoAdvice;
        this.videoAdviceBg = videoAdviceBg;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VideoAdviceBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static VideoAdviceBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.video_advice, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static VideoAdviceBinding bind(View rootView) {
        int i = R.id.btn_skip;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
        if (frameLayout != null) {
            i = R.id.skip_quest;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                FrameLayout frameLayout2 = (FrameLayout) rootView;
                i = R.id.video_advice_bg;
                PlayerView playerView = (PlayerView) ViewBindings.findChildViewById(rootView, i);
                if (playerView != null) {
                    return new VideoAdviceBinding(frameLayout2, frameLayout, linearLayout, frameLayout2, playerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
