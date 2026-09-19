package ru.mrlargha.commonui.elements.video;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.StreamVideoBinding;
/* compiled from: StreamVideo.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u001f"}, d2 = {"Lru/mrlargha/commonui/elements/video/StreamVideo;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "isDestroyed", "", "screenLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/StreamVideoBinding;", "fullScreenWebView", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/YouTubePlayerView;", "kotlin.jvm.PlatformType", "getFullScreenWebView", "()Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/YouTubePlayerView;", "pipBoyWebView", "getPipBoyWebView", "destroy", "", "initFullScreenVideo", "youTubeVideoId", "", "initPipboyScreenVideo", "onBackendMessageHandled", "data", "subId", "Spawner", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class StreamVideo extends SAMPUIElement {
    private final StreamVideoBinding binding;
    private final YouTubePlayerView fullScreenWebView;
    private boolean isDestroyed;
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
        if (this.isDestroyed) {
            return;
        }
        this.isDestroyed = true;
        this.fullScreenWebView.release();
        this.pipBoyWebView.release();
        detachFromLayoutSilently$CommonUI();
    }

    private final void initFullScreenVideo(final String str) {
        this.binding.youtubePlayerViewPip.setVisibility(8);
        this.binding.youtubePlayerViewFullscreen.setVisibility(0);
        this.fullScreenWebView.setEnableAutomaticInitialization(false);
        IFramePlayerOptions build = new IFramePlayerOptions.Builder(getTargetActivity()).autoplay(1).modestBranding(0).controls(0).fullscreen(0).rel(0).ivLoadPolicy(3).build();
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
        IFramePlayerOptions build = new IFramePlayerOptions.Builder(getTargetActivity()).autoplay(1).modestBranding(0).controls(0).fullscreen(0).rel(0).ivLoadPolicy(3).build();
        this.pipBoyWebView.initialize(new AbstractYouTubePlayerListener() { // from class: ru.mrlargha.commonui.elements.video.StreamVideo$initPipboyScreenVideo$listener$1
            @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
            public void onReady(YouTubePlayer youTubePlayer) {
                Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
                youTubePlayer.loadVideo(str, 0.0f);
            }
        }, build);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            initFullScreenVideo(data);
        } else if (i != 1) {
        } else {
            initPipboyScreenVideo(data);
        }
    }

    /* compiled from: StreamVideo.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/video/StreamVideo$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.emptySet();

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new StreamVideo(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}
