package com.miami.game.core.decompose.utils;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.value.Value;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
/* compiled from: ValueStateFlow.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"stateFlow", "Lkotlinx/coroutines/flow/StateFlow;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/arkivanov/decompose/value/Value;", "getStateFlow", "(Lcom/arkivanov/decompose/value/Value;)Lkotlinx/coroutines/flow/StateFlow;", "decompose-utils_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ValueStateFlowKt {
    public static final <T> StateFlow<T> getStateFlow(Value<? extends T> value) {
        Intrinsics.checkNotNullParameter(value, "<this>");
        return new ValueStateFlow(value);
    }
}
