package ru.rustore.sdk.core.util;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TaskCoroutineExtensions.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "ru.rustore.sdk.core.util.TaskCoroutineExtensionsKt", f = "TaskCoroutineExtensions.kt", i = {0}, l = {27}, m = "toSuspendResult", n = {"$this$toSuspendResult"}, s = {"L$0"})
/* loaded from: classes5.dex */
public final class TaskCoroutineExtensionsKt$toSuspendResult$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TaskCoroutineExtensionsKt$toSuspendResult$1(Continuation<? super TaskCoroutineExtensionsKt$toSuspendResult$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object suspendResult = TaskCoroutineExtensionsKt.toSuspendResult(null, this);
        return suspendResult == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? suspendResult : Result.m8442boximpl(suspendResult);
    }
}
