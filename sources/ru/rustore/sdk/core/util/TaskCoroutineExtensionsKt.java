package ru.rustore.sdk.core.util;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import ru.rustore.sdk.core.tasks.OnCompleteListener;
import ru.rustore.sdk.core.tasks.Task;
/* compiled from: TaskCoroutineExtensions.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, d2 = {"toSuspendResult", "Lkotlin/Result;", ExifInterface.GPS_DIRECTION_TRUE, "Lru/rustore/sdk/core/tasks/Task;", "(Lru/rustore/sdk/core/tasks/Task;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sdk-public-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TaskCoroutineExtensionsKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object toSuspendResult(final Task<T> task, Continuation<? super Result<? extends T>> continuation) {
        TaskCoroutineExtensionsKt$toSuspendResult$1 taskCoroutineExtensionsKt$toSuspendResult$1;
        int i;
        if (continuation instanceof TaskCoroutineExtensionsKt$toSuspendResult$1) {
            taskCoroutineExtensionsKt$toSuspendResult$1 = (TaskCoroutineExtensionsKt$toSuspendResult$1) continuation;
            if ((taskCoroutineExtensionsKt$toSuspendResult$1.label & Integer.MIN_VALUE) != 0) {
                taskCoroutineExtensionsKt$toSuspendResult$1.label -= Integer.MIN_VALUE;
                Object obj = taskCoroutineExtensionsKt$toSuspendResult$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = taskCoroutineExtensionsKt$toSuspendResult$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    taskCoroutineExtensionsKt$toSuspendResult$1.L$0 = task;
                    taskCoroutineExtensionsKt$toSuspendResult$1.label = 1;
                    TaskCoroutineExtensionsKt$toSuspendResult$1 taskCoroutineExtensionsKt$toSuspendResult$12 = taskCoroutineExtensionsKt$toSuspendResult$1;
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(taskCoroutineExtensionsKt$toSuspendResult$12), 1);
                    cancellableContinuationImpl.initCancellability();
                    final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
                    task.addOnCompleteListener(new OnCompleteListener<T>() { // from class: ru.rustore.sdk.core.util.TaskCoroutineExtensionsKt$toSuspendResult$2$1
                        @Override // ru.rustore.sdk.core.tasks.OnSuccessListener
                        public void onSuccess(T t) {
                            CancellableContinuation<Result<? extends T>> cancellableContinuation = cancellableContinuationImpl2;
                            Result.Companion companion = Result.Companion;
                            CancellableContinuationExtKt.resumeIfActive(cancellableContinuation, Result.m8470boximpl(Result.m8471constructorimpl(t)));
                        }

                        @Override // ru.rustore.sdk.core.tasks.OnFailureListener
                        public void onFailure(Throwable throwable) {
                            Intrinsics.checkNotNullParameter(throwable, "throwable");
                            CancellableContinuation<Result<? extends T>> cancellableContinuation = cancellableContinuationImpl2;
                            Result.Companion companion = Result.Companion;
                            CancellableContinuationExtKt.resumeIfActive(cancellableContinuation, Result.m8470boximpl(Result.m8471constructorimpl(ResultKt.createFailure(throwable))));
                        }
                    });
                    cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: ru.rustore.sdk.core.util.TaskCoroutineExtensionsKt$toSuspendResult$2$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable th) {
                            task.cancel();
                        }
                    });
                    obj = cancellableContinuationImpl.getResult();
                    if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(taskCoroutineExtensionsKt$toSuspendResult$12);
                    }
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    Task task2 = (Task) taskCoroutineExtensionsKt$toSuspendResult$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return ((Result) obj).m8480unboximpl();
            }
        }
        taskCoroutineExtensionsKt$toSuspendResult$1 = new TaskCoroutineExtensionsKt$toSuspendResult$1(continuation);
        Object obj2 = taskCoroutineExtensionsKt$toSuspendResult$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = taskCoroutineExtensionsKt$toSuspendResult$1.label;
        if (i != 0) {
        }
        return ((Result) obj2).m8480unboximpl();
    }
}
