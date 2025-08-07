package ru.rustore.sdk.reactive.core;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CompositeException.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lru/rustore/sdk/reactive/core/CompositeException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "cause", "", "", "(Ljava/lang/String;[Ljava/lang/Throwable;)V", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CompositeException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompositeException(String message, Throwable... cause) {
        super(message, (Throwable) ArraysKt.firstOrNull(cause));
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
