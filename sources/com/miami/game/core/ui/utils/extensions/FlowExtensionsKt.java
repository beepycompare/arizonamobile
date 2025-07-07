package com.miami.game.core.ui.utils.extensions;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.FlowExtKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
/* compiled from: FlowExtensions.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001ax\u0010\t\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\f\"\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072-\u0010\u000e\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000f¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0013¨\u0006\u0014²\u00067\u0010\u0015\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000f¢\u0006\u0002\b\u0012\"\u0004\b\u0000\u0010\u0002X\u008a\u0084\u0002"}, d2 = {"rememberFlowWithLifecycle", "Lkotlinx/coroutines/flow/Flow;", ExifInterface.GPS_DIRECTION_TRUE, "flow", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "minActiveState", "Landroidx/lifecycle/Lifecycle$State;", "(Lkotlinx/coroutines/flow/Flow;Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Landroidx/compose/runtime/Composer;II)Lkotlinx/coroutines/flow/Flow;", "collectInLaunchedEffectWithLifecycle", "", UserMetadata.KEYDATA_FILENAME, "", "", "collector", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;[Ljava/lang/Object;Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ui-utils_release_web", "currentCollector"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FlowExtensionsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit collectInLaunchedEffectWithLifecycle$lambda$3(Flow flow, Object[] objArr, Lifecycle lifecycle, Lifecycle.State state, Function3 function3, int i, int i2, Composer composer, int i3) {
        collectInLaunchedEffectWithLifecycle(flow, objArr, lifecycle, state, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final <T> Flow<T> rememberFlowWithLifecycle(Flow<? extends T> flow, Lifecycle lifecycle, Lifecycle.State state, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(flow, "flow");
        composer.startReplaceGroup(1523529420);
        ComposerKt.sourceInformation(composer, "C(rememberFlowWithLifecycle)19@721L7,21@815L150:FlowExtensions.kt#iw6472");
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
            ComposerKt.sourceInformationMarkerEnd(composer);
            lifecycle = ((LifecycleOwner) consume).getLifecycle();
        }
        if ((i2 & 4) != 0) {
            state = Lifecycle.State.STARTED;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1523529420, i, -1, "com.miami.game.core.ui.utils.extensions.rememberFlowWithLifecycle (FlowExtensions.kt:21)");
        }
        composer.startReplaceGroup(-1746271574);
        ComposerKt.sourceInformation(composer, "CC(remember):FlowExtensions.kt#9igjgp");
        boolean changed = ((((i & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(state.ordinal())) || (i & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | composer.changed(flow) | composer.changed(lifecycle);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = FlowExtKt.flowWithLifecycle(flow, lifecycle, state);
            composer.updateRememberedValue(rememberedValue);
        }
        Flow<T> flow2 = (Flow) rememberedValue;
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return flow2;
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> void collectInLaunchedEffectWithLifecycle(final Flow<? extends T> flow, final Object[] keys, Lifecycle lifecycle, Lifecycle.State state, final Function3<? super CoroutineScope, ? super T, ? super Continuation<? super Unit>, ? extends Object> collector, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        int i4;
        Lifecycle.State state2;
        boolean changedInstance;
        FlowExtensionsKt$collectInLaunchedEffectWithLifecycle$1$1 rememberedValue;
        Lifecycle lifecycle2;
        final Lifecycle lifecycle3;
        final Lifecycle.State state3;
        int i5;
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(collector, "collector");
        Composer startRestartGroup = composer.startRestartGroup(239778954);
        ComposerKt.sourceInformation(startRestartGroup, "C(collectInLaunchedEffectWithLifecycle)P(1,2,3)37@1317L31,39@1409L193,39@1354L248:FlowExtensions.kt#iw6472");
        if ((i2 & Integer.MIN_VALUE) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(flow) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i2 & 2) == 0) {
                obj = lifecycle;
                if (startRestartGroup.changedInstance(obj)) {
                    i5 = 256;
                    i3 |= i5;
                }
            } else {
                obj = lifecycle;
            }
            i5 = 128;
            i3 |= i5;
        } else {
            obj = lifecycle;
        }
        int i6 = i2 & 4;
        if (i6 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changed(state == null ? -1 : state.ordinal()) ? 2048 : 1024;
        }
        if ((i2 & 8) != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            i3 |= startRestartGroup.changedInstance(collector) ? 16384 : 8192;
        }
        startRestartGroup.startMovableGroup(-1500655973, Integer.valueOf(keys.length));
        ComposerKt.sourceInformation(startRestartGroup, "32@1133L7");
        int i7 = i3 | (startRestartGroup.changed(keys.length) ? 32 : 0);
        for (Object obj2 : keys) {
            i7 |= startRestartGroup.changedInstance(obj2) ? 32 : 0;
        }
        startRestartGroup.endMovableGroup();
        if ((i7 & 112) == 0) {
            i7 |= 16;
        }
        if ((i7 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            lifecycle3 = obj;
            state3 = state;
        } else {
            startRestartGroup.startDefaults();
            ComposerKt.sourceInformation(startRestartGroup, "");
            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 2) != 0) {
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    obj = ((LifecycleOwner) consume).getLifecycle();
                    i7 &= -897;
                }
                if (i6 != 0) {
                    i4 = i7;
                    state2 = Lifecycle.State.STARTED;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(239778954, i4, -1, "com.miami.game.core.ui.utils.extensions.collectInLaunchedEffectWithLifecycle (FlowExtensions.kt:35)");
                    }
                    State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(collector, startRestartGroup, (i4 >> 12) & 14);
                    SpreadBuilder spreadBuilder = new SpreadBuilder(4);
                    spreadBuilder.add(flow);
                    spreadBuilder.add(obj);
                    spreadBuilder.add(state2);
                    spreadBuilder.addSpread(keys);
                    Object[] array = spreadBuilder.toArray(new Object[spreadBuilder.size()]);
                    startRestartGroup.startReplaceGroup(-1224400529);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):FlowExtensions.kt#9igjgp");
                    changedInstance = startRestartGroup.changedInstance(obj) | ((i4 & 7168) != 2048) | startRestartGroup.changedInstance(flow) | startRestartGroup.changed(rememberUpdatedState);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                        lifecycle2 = obj;
                        rememberedValue = new FlowExtensionsKt$collectInLaunchedEffectWithLifecycle$1$1(lifecycle2, state2, flow, rememberUpdatedState, null);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    } else {
                        lifecycle2 = obj;
                    }
                    startRestartGroup.endReplaceGroup();
                    EffectsKt.LaunchedEffect(array, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    lifecycle3 = lifecycle2;
                    state3 = state2;
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i7 &= -897;
                }
            }
            i4 = i7;
            state2 = state;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(collector, startRestartGroup, (i4 >> 12) & 14);
            SpreadBuilder spreadBuilder2 = new SpreadBuilder(4);
            spreadBuilder2.add(flow);
            spreadBuilder2.add(obj);
            spreadBuilder2.add(state2);
            spreadBuilder2.addSpread(keys);
            Object[] array2 = spreadBuilder2.toArray(new Object[spreadBuilder2.size()]);
            startRestartGroup.startReplaceGroup(-1224400529);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):FlowExtensions.kt#9igjgp");
            changedInstance = startRestartGroup.changedInstance(obj) | ((i4 & 7168) != 2048) | startRestartGroup.changedInstance(flow) | startRestartGroup.changed(rememberUpdatedState2);
            rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance) {
            }
            lifecycle2 = obj;
            rememberedValue = new FlowExtensionsKt$collectInLaunchedEffectWithLifecycle$1$1(lifecycle2, state2, flow, rememberUpdatedState2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(array2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            lifecycle3 = lifecycle2;
            state3 = state2;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.core.ui.utils.extensions.FlowExtensionsKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    Unit collectInLaunchedEffectWithLifecycle$lambda$3;
                    collectInLaunchedEffectWithLifecycle$lambda$3 = FlowExtensionsKt.collectInLaunchedEffectWithLifecycle$lambda$3(Flow.this, keys, lifecycle3, state3, collector, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                    return collectInLaunchedEffectWithLifecycle$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Function3<CoroutineScope, T, Continuation<? super Unit>, Object> collectInLaunchedEffectWithLifecycle$lambda$1(State<? extends Function3<? super CoroutineScope, ? super T, ? super Continuation<? super Unit>, ? extends Object>> state) {
        return (Function3) ((Function3<? super CoroutineScope, ? super T, ? super Continuation<? super Unit>, ? extends Object>) state.getValue());
    }
}
