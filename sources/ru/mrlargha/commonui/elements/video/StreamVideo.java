package ru.mrlargha.commonui.elements.video;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.databinding.StreamVideoBinding;
/* compiled from: StreamVideo.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001cB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00010\r0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/video/StreamVideo;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screenLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/StreamVideoBinding;", "fullScreenWebView", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/YouTubePlayerView;", "kotlin.jvm.PlatformType", "getFullScreenWebView", "()Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/YouTubePlayerView;", "pipBoyWebView", "getPipBoyWebView", "destroy", "", "initFullScreenVideo", "youTubeVideoId", "", "initPipboyScreenVideo", "onBackendMessage", "data", "subId", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StreamVideo extends SAMPUIElement {
    private final StreamVideoBinding binding;
    private final YouTubePlayerView fullScreenWebView;
    private final YouTubePlayerView pipBoyWebView;
    private final ConstraintLayout screenLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamVideo(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.stream_video, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.screenLayout = constraintLayout;
        StreamVideoBinding bind = StreamVideoBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.fullScreenWebView = (YouTubePlayerView) constraintLayout.findViewById(R.id.youtube_player_view_fullscreen);
        this.pipBoyWebView = (YouTubePlayerView) constraintLayout.findViewById(R.id.youtube_player_view_pip);
        addViewToConstraintLayout(constraintLayout, -1, -1);
        setVisibility(true);
    }

    public final YouTubePlayerView getFullScreenWebView() {
        return this.fullScreenWebView;
    }

    public final YouTubePlayerView getPipBoyWebView() {
        return this.pipBoyWebView;
    }

    public final void destroy() {
        this.fullScreenWebView.release();
        this.pipBoyWebView.release();
    }

    private final void initFullScreenVideo(final String str) {
        this.binding.youtubePlayerViewPip.setVisibility(8);
        this.binding.youtubePlayerViewFullscreen.setVisibility(0);
        this.fullScreenWebView.setEnableAutomaticInitialization(false);
        IFramePlayerOptions build = new IFramePlayerOptions.Builder().autoplay(1).modestBranding(0).controls(0).fullscreen(0).rel(0).ivLoadPolicy(3).build();
        this.fullScreenWebView.initialize(new AbstractYouTubePlayerListener() { // from class: ru.mrlargha.commonui.elements.video.StreamVideo$initFullScreenVideo$listener$1
            @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
            public void onReady(YouTubePlayer youTubePlayer) {
                Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
                youTubePlayer.loadVideo(str, 0.0f);
            }
        }, build);
    }

    private final void initPipboyScreenVideo(final String str) {
        this.binding.youtubePlayerViewFullscreen.setVisibility(8);
        this.binding.youtubePlayerViewPip.setVisibility(0);
        this.pipBoyWebView.setEnableAutomaticInitialization(false);
        IFramePlayerOptions build = new IFramePlayerOptions.Builder().autoplay(1).modestBranding(0).controls(0).fullscreen(0).rel(0).ivLoadPolicy(3).build();
        this.pipBoyWebView.initialize(new AbstractYouTubePlayerListener() { // from class: ru.mrlargha.commonui.elements.video.StreamVideo$initPipboyScreenVideo$listener$1
            @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
            public void onReady(YouTubePlayer youTubePlayer) {
                Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
                youTubePlayer.loadVideo(str, 0.0f);
            }
        }, build);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            initFullScreenVideo(data);
        } else if (i != 1) {
        } else {
            initPipboyScreenVideo(data);
        }
    }

    /* compiled from: StreamVideo.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/video/StreamVideo$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new StreamVideo(targetActivity, i);
        }
    }
}
