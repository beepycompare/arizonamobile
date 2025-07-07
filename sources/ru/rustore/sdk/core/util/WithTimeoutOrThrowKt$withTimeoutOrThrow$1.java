package ru.rustore.sdk.core.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WithTimeoutOrThrow.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "ru.rustore.sdk.core.util.WithTimeoutOrThrowKt", f = "WithTimeoutOrThrow.kt", i = {0}, l = {13}, m = "withTimeoutOrThrow", n = {"exceptionFactory"}, s = {"L$0"})
/* loaded from: classes5.dex */
public final class WithTimeoutOrThrowKt$withTimeoutOrThrow$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WithTimeoutOrThrowKt$withTimeoutOrThrow$1(Continuation<? super WithTimeoutOrThrowKt$withTimeoutOrThrow$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WithTimeoutOrThrowKt.withTimeoutOrThrow(0L, null, null, this);
    }
}
