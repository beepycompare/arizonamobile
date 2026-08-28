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
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: VideoPlayer.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u001aA\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007b\u0010\b\u0007\u0012\f\b\b\u0012\b\b\fJ\u0004\b\t0\tb\u0002\b\nb\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r¢\u0006\u0002\u0010\u0006¨\u0006\u000e²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u0084\u0002"}, d2 = {"ExoPlayerView", "", "uri", "Landroid/net/Uri;", "isSoundOn", "", "(Landroid/net/Uri;ZLandroidx/compose/runtime/Composer;I)V", "Landroidx/annotation/OptIn;", "markerClass", "Landroidx/media3/common/util/UnstableApi;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "download-screen", "exoPlayer", "Landroidx/media3/exoplayer/ExoPlayer;"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VideoPlayerKt {

    /* compiled from: VideoPlayer.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ExoPlayerView$lambda$8(Uri uri, boolean z, int i, Composer composer, int i2) {
        ExoPlayerView(uri, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ExoPlayerView(final Uri uri, final boolean z, Composer composer, final int i) {
        int i2;
        Object obj;
        MediaItem mediaItem;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Composer startRestartGroup = composer.startRestartGroup(-794781196);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExoPlayerView)N(uri,isSoundOn)28@1080L7,29@1133L7,32@1191L63,33@1296L34,36@1382L52,40@1466L60,40@1440L86,45@1596L394,45@1568L422,60@2266L984,60@2222L1028,93@3361L446,92@3330L539:VideoPlayer.kt#k3v2wi");
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final LifecycleOwner lifecycleOwner = (LifecycleOwner) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 719456499, "CC(remember):VideoPlayer.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new ExoPlayer.Builder(context).build(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 719459830, "CC(remember):VideoPlayer.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 719462600, "CC(remember):VideoPlayer.kt#9igjgp");
            boolean changed = startRestartGroup.changed(uri);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = MediaItem.fromUri(uri);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            MediaItem mediaItem2 = (MediaItem) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Intrinsics.checkNotNull(mediaItem2);
            Boolean valueOf = Boolean.valueOf(z);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 719465296, "CC(remember):VideoPlayer.kt#9igjgp");
            boolean z2 = (i2 & 112) == 32;
            VideoPlayerKt$ExoPlayerView$1$1 rememberedValue4 = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new VideoPlayerKt$ExoPlayerView$1$1(z, mutableState, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue4, startRestartGroup, (i2 >> 3) & 14);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 719469790, "CC(remember):VideoPlayer.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(mediaItem2) | startRestartGroup.changedInstance(lifecycleOwner);
            VideoPlayerKt$ExoPlayerView$2$1 rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue5 == Composer.Companion.getEmpty()) {
                obj = null;
                mediaItem = mediaItem2;
                rememberedValue5 = new VideoPlayerKt$ExoPlayerView$2$1(mediaItem, lifecycleOwner, mutableState2, mutableState, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            } else {
                obj = null;
                mediaItem = mediaItem2;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(mediaItem, (Function2) rememberedValue5, startRestartGroup, 0);
            ExoPlayer ExoPlayerView$lambda$1 = ExoPlayerView$lambda$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 719491820, "CC(remember):VideoPlayer.kt#9igjgp");
            boolean changedInstance2 = startRestartGroup.changedInstance(lifecycleOwner);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = new Function1() { // from class: com.miami.game.feature.download.screen.ui.compose.VideoPlayerKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        DisposableEffectResult ExoPlayerView$lambda$6$0;
                        ExoPlayerView$lambda$6$0 = VideoPlayerKt.ExoPlayerView$lambda$6$0(LifecycleOwner.this, mutableState2, mutableState, (DisposableEffectScope) obj2);
                        return ExoPlayerView$lambda$6$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.DisposableEffect(lifecycleOwner, ExoPlayerView$lambda$1, (Function1) rememberedValue6, startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 719526322, "CC(remember):VideoPlayer.kt#9igjgp");
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == Composer.Companion.getEmpty()) {
                rememberedValue7 = new Function1() { // from class: com.miami.game.feature.download.screen.ui.compose.VideoPlayerKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        PlayerView ExoPlayerView$lambda$7$0;
                        ExoPlayerView$lambda$7$0 = VideoPlayerKt.ExoPlayerView$lambda$7$0(MutableState.this, (Context) obj2);
                        return ExoPlayerView$lambda$7$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            AndroidView_androidKt.AndroidView((Function1) rememberedValue7, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, obj), null, startRestartGroup, 54, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.screen.ui.compose.VideoPlayerKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return VideoPlayerKt.ExoPlayerView$lambda$8(uri, z, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExoPlayer ExoPlayerView$lambda$1(MutableState<ExoPlayer> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult ExoPlayerView$lambda$6$0(final LifecycleOwner lifecycleOwner, final MutableState mutableState, final MutableState mutableState2, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: com.miami.game.feature.download.screen.ui.compose.VideoPlayerKt$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                VideoPlayerKt.ExoPlayerView$lambda$6$0$0(MutableState.this, mutableState2, lifecycleOwner2, event);
            }
        };
        lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
        return new DisposableEffectResult() { // from class: com.miami.game.feature.download.screen.ui.compose.VideoPlayerKt$ExoPlayerView$lambda$6$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                ExoPlayer ExoPlayerView$lambda$1;
                LifecycleOwner.this.getLifecycle().removeObserver(lifecycleEventObserver);
                ExoPlayerView$lambda$1 = VideoPlayerKt.ExoPlayerView$lambda$1(mutableState2);
                ExoPlayerView$lambda$1.release();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ExoPlayerView$lambda$6$0$0(MutableState mutableState, MutableState mutableState2, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1 || i == 2) {
            if (ExoPlayerView$lambda$1(mutableState2).isPlaying() || ExoPlayerView$lambda$1(mutableState2).getPlayWhenReady()) {
                mutableState.setValue(true);
                ExoPlayerView$lambda$1(mutableState2).pause();
            }
        } else if (i == 3 && ((Boolean) mutableState.getValue()).booleanValue()) {
            mutableState.setValue(false);
            ExoPlayerView$lambda$1(mutableState2).setPlayWhenReady(true);
            ExoPlayerView$lambda$1(mutableState2).play();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlayerView ExoPlayerView$lambda$7$0(MutableState mutableState, Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        PlayerView playerView = new PlayerView(ctx);
        playerView.setPlayer(ExoPlayerView$lambda$1(mutableState));
        playerView.setUseController(false);
        playerView.setResizeMode(0);
        playerView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return playerView;
    }
}
