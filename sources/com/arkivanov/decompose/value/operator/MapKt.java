package com.arkivanov.decompose.value.operator;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.value.Value;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Map.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a>\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004\"\b\b\u0001\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00020\u0006¨\u0006\u0007"}, d2 = {"map", "Lcom/arkivanov/decompose/value/Value;", "R", ExifInterface.GPS_DIRECTION_TRUE, "", "mapper", "Lkotlin/Function1;", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MapKt {
    public static final <T, R> Value<R> map(Value<? extends T> value, Function1<? super T, ? extends R> mapper) {
        Intrinsics.checkNotNullParameter(value, "<this>");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new MappedValue(value, mapper);
    }
}
