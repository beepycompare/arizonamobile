package com.arkivanov.decompose.extensions.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.Cancellation;
import com.arkivanov.decompose.value.Value;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SubscribeAsState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"subscribeAsState", "Landroidx/compose/runtime/State;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/arkivanov/decompose/value/Value;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "(Lcom/arkivanov/decompose/value/Value;Landroidx/compose/runtime/SnapshotMutationPolicy;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "extensions-compose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SubscribeAsStateKt {
    public static final <T> State<T> subscribeAsState(final Value<? extends T> value, SnapshotMutationPolicy<T> snapshotMutationPolicy, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(value, "<this>");
        composer.startReplaceGroup(-220138742);
        if ((i2 & 1) != 0) {
            snapshotMutationPolicy = SnapshotStateKt.structuralEqualityPolicy();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-220138742, i, -1, "com.arkivanov.decompose.extensions.compose.subscribeAsState (SubscribeAsState.kt:18)");
        }
        composer.startReplaceGroup(644836070);
        boolean changed = composer.changed(value) | composer.changed(snapshotMutationPolicy);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt.mutableStateOf(value.getValue(), snapshotMutationPolicy);
            composer.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(644838839);
        boolean changedInstance = composer.changedInstance(value) | composer.changed(mutableState);
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.SubscribeAsStateKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    DisposableEffectResult subscribeAsState$lambda$4$lambda$3;
                    subscribeAsState$lambda$4$lambda$3 = SubscribeAsStateKt.subscribeAsState$lambda$4$lambda$3(Value.this, mutableState, (DisposableEffectScope) obj);
                    return subscribeAsState$lambda$4$lambda$3;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        EffectsKt.DisposableEffect(value, (Function1) rememberedValue2, composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return mutableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult subscribeAsState$lambda$4$lambda$3(Value value, final MutableState mutableState, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final Cancellation subscribe = value.subscribe(new Function1() { // from class: com.arkivanov.decompose.extensions.compose.SubscribeAsStateKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit subscribeAsState$lambda$4$lambda$3$lambda$1;
                subscribeAsState$lambda$4$lambda$3$lambda$1 = SubscribeAsStateKt.subscribeAsState$lambda$4$lambda$3$lambda$1(MutableState.this, obj);
                return subscribeAsState$lambda$4$lambda$3$lambda$1;
            }
        });
        return new DisposableEffectResult() { // from class: com.arkivanov.decompose.extensions.compose.SubscribeAsStateKt$subscribeAsState$lambda$4$lambda$3$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                Cancellation.this.cancel();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit subscribeAsState$lambda$4$lambda$3$lambda$1(MutableState mutableState, Object it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }
}
