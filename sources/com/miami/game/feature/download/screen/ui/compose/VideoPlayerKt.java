package com.miami.game.feature.download.screen.ui.compose;

import android.content.Context;
import android.net.Uri;
import android.widget.FrameLayout;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: VideoPlayer.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007²\u0006\n\u0010\b\u001a\u00020\tX\u008a\u0084\u0002"}, d2 = {"ExoPlayerView", "", "uri", "Landroid/net/Uri;", "isSoundOn", "", "(Landroid/net/Uri;ZLandroidx/compose/runtime/Composer;I)V", "download-screen_release_web", "exoPlayer", "Landroidx/media3/exoplayer/ExoPlayer;"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VideoPlayerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExoPlayerView$lambda$11(Uri uri, boolean z, int i, Composer composer, int i2) {
        ExoPlayerView(uri, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ExoPlayerView(final Uri uri, final boolean z, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Composer startRestartGroup = composer.startRestartGroup(-794781196);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExoPlayerView)P(1)28@1080L7,31@1138L63,34@1253L52,38@1337L60,38@1311L86,43@1467L175,43@1439L203,51@1702L69,51@1679L92,59@1882L446,58@1851L539:VideoPlayer.kt#k3v2wi");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(uri) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-794781196, i2, -1, "com.miami.game.feature.download.screen.ui.compose.ExoPlayerView (VideoPlayer.kt:26)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Context context = (Context) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 719456051, "CC(remember):VideoPlayer.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new ExoPlayer.Builder(context).build(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 719459720, "CC(remember):VideoPlayer.kt#9igjgp");
            boolean changed = startRestartGroup.changed(uri);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = MediaItem.fromUri(uri);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MediaItem mediaItem = (MediaItem) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Intrinsics.checkNotNull(mediaItem);
            Boolean valueOf = Boolean.valueOf(z);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 719462416, "CC(remember):VideoPlayer.kt#9igjgp");
            boolean z2 = (i2 & 112) == 32;
            VideoPlayerKt$ExoPlayerView$1$1 rememberedValue3 = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new VideoPlayerKt$ExoPlayerView$1$1(z, mutableState, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue3, startRestartGroup, (i2 >> 3) & 14);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 719466691, "CC(remember):VideoPlayer.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(mediaItem);
            VideoPlayerKt$ExoPlayerView$2$1 rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new VideoPlayerKt$ExoPlayerView$2$1(mediaItem, mutableState, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(mediaItem, (Function2) rememberedValue4, startRestartGroup, 0);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 719474105, "CC(remember):VideoPlayer.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new Function1() { // from class: com.miami.game.feature.download.screen.ui.compose.VideoPlayerKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DisposableEffectResult ExoPlayerView$lambda$7$lambda$6;
                        ExoPlayerView$lambda$7$lambda$6 = VideoPlayerKt.ExoPlayerView$lambda$7$lambda$6(MutableState.this, (DisposableEffectScope) obj);
                        return ExoPlayerView$lambda$7$lambda$6;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.DisposableEffect(unit, (Function1) rememberedValue5, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 719480242, "CC(remember):VideoPlayer.kt#9igjgp");
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = new Function1() { // from class: com.miami.game.feature.download.screen.ui.compose.VideoPlayerKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        PlayerView ExoPlayerView$lambda$10$lambda$9;
                        ExoPlayerView$lambda$10$lambda$9 = VideoPlayerKt.ExoPlayerView$lambda$10$lambda$9(MutableState.this, (Context) obj);
                        return ExoPlayerView$lambda$10$lambda$9;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            AndroidView_androidKt.AndroidView((Function1) rememberedValue6, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), null, startRestartGroup, 54, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.screen.ui.compose.VideoPlayerKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ExoPlayerView$lambda$11;
                    ExoPlayerView$lambda$11 = VideoPlayerKt.ExoPlayerView$lambda$11(uri, z, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ExoPlayerView$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExoPlayer ExoPlayerView$lambda$1(MutableState<ExoPlayer> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlayerView ExoPlayerView$lambda$10$lambda$9(MutableState mutableState, Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        PlayerView playerView = new PlayerView(ctx);
        playerView.setPlayer(ExoPlayerView$lambda$1(mutableState));
        playerView.setUseController(false);
        playerView.setResizeMode(0);
        playerView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return playerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult ExoPlayerView$lambda$7$lambda$6(final MutableState mutableState, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: com.miami.game.feature.download.screen.ui.compose.VideoPlayerKt$ExoPlayerView$lambda$7$lambda$6$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                ExoPlayer ExoPlayerView$lambda$1;
                ExoPlayerView$lambda$1 = VideoPlayerKt.ExoPlayerView$lambda$1(MutableState.this);
                ExoPlayerView$lambda$1.release();
            }
        };
    }
}
