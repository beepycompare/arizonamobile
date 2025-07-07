package com.arkivanov.decompose.value;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MutableValueExt.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a.\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\u0006\u001a3\u0010\u0007\u001a\u0002H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\u0006¢\u0006\u0002\u0010\b\u001a3\u0010\t\u001a\u0002H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\u0006¢\u0006\u0002\u0010\b¨\u0006\n"}, d2 = {"update", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/arkivanov/decompose/value/MutableValue;", "function", "Lkotlin/Function1;", "updateAndGet", "(Lcom/arkivanov/decompose/value/MutableValue;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getAndUpdate", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MutableValueExtKt {
    public static final <T> void update(MutableValue<T> mutableValue, Function1<? super T, ? extends T> function) {
        Intrinsics.checkNotNullParameter(mutableValue, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        updateAndGet(mutableValue, function);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T updateAndGet(MutableValue<T> mutableValue, Function1<? super T, ? extends T> function) {
        Object obj;
        T invoke;
        Intrinsics.checkNotNullParameter(mutableValue, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            obj = (Object) mutableValue.getValue();
            invoke = function.invoke(obj);
        } while (!mutableValue.compareAndSet(obj, invoke));
        return invoke;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
    public static final <T> T getAndUpdate(MutableValue<T> mutableValue, Function1<? super T, ? extends T> function) {
        ?? r0;
        Intrinsics.checkNotNullParameter(mutableValue, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            r0 = (Object) mutableValue.getValue();
        } while (!mutableValue.compareAndSet(r0, function.invoke(r0)));
        return r0;
    }
}
