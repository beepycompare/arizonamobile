package com.miami.game.feature.download.screen.ui.compose;

import androidx.compose.runtime.MutableState;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoPlayer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.download.screen.ui.compose.VideoPlayerKt$ExoPlayerView$2$1", f = "VideoPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class VideoPlayerKt$ExoPlayerView$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<ExoPlayer> $exoPlayer$delegate;
    final /* synthetic */ MediaItem $mediaSource;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPlayerKt$ExoPlayerView$2$1(MediaItem mediaItem, MutableState<ExoPlayer> mutableState, Continuation<? super VideoPlayerKt$ExoPlayerView$2$1> continuation) {
        super(2, continuation);
        this.$mediaSource = mediaItem;
        this.$exoPlayer$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoPlayerKt$ExoPlayerView$2$1(this.$mediaSource, this.$exoPlayer$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VideoPlayerKt$ExoPlayerView$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ExoPlayer ExoPlayerView$lambda$1;
        ExoPlayer ExoPlayerView$lambda$12;
        ExoPlayer ExoPlayerView$lambda$13;
        ExoPlayer ExoPlayerView$lambda$14;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ExoPlayerView$lambda$1 = VideoPlayerKt.ExoPlayerView$lambda$1(this.$exoPlayer$delegate);
            ExoPlayerView$lambda$1.setMediaItem(this.$mediaSource);
            ExoPlayerView$lambda$12 = VideoPlayerKt.ExoPlayerView$lambda$1(this.$exoPlayer$delegate);
            ExoPlayerView$lambda$12.prepare();
            ExoPlayerView$lambda$13 = VideoPlayerKt.ExoPlayerView$lambda$1(this.$exoPlayer$delegate);
            ExoPlayerView$lambda$13.setPlayWhenReady(true);
            ExoPlayerView$lambda$14 = VideoPlayerKt.ExoPlayerView$lambda$1(this.$exoPlayer$delegate);
            ExoPlayerView$lambda$14.setRepeatMode(2);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
