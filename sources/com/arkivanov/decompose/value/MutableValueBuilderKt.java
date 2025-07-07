package com.arkivanov.decompose.value;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MutableValueBuilder.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"MutableValue", "Lcom/arkivanov/decompose/value/MutableValue;", ExifInterface.GPS_DIRECTION_TRUE, "", "initialValue", "(Ljava/lang/Object;)Lcom/arkivanov/decompose/value/MutableValue;", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MutableValueBuilderKt {
    public static final <T> MutableValue<T> MutableValue(T initialValue) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        return new MutableValueImpl(initialValue);
    }
}
