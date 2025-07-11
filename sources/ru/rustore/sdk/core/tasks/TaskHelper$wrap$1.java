package ru.rustore.sdk.core.tasks;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: TaskHelper.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "ru.rustore.sdk.core.tasks.TaskHelper$wrap$1", f = "TaskHelper.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class TaskHelper$wrap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TaskResultProvider<T> $resultProvider;
    final /* synthetic */ Function1<Continuation<? super T>, Object> $task;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TaskHelper$wrap$1(TaskResultProvider<T> taskResultProvider, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super TaskHelper$wrap$1> continuation) {
        super(2, continuation);
        this.$resultProvider = taskResultProvider;
        this.$task = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TaskHelper$wrap$1 taskHelper$wrap$1 = new TaskHelper$wrap$1(this.$resultProvider, this.$task, continuation);
        taskHelper$wrap$1.L$0 = obj;
        return taskHelper$wrap$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TaskHelper$wrap$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m8471constructorimpl;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Function1<Continuation<? super T>, Object> function1 = this.$task;
                Result.Companion companion = Result.Companion;
                this.label = 1;
                obj = function1.invoke(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            m8471constructorimpl = Result.m8471constructorimpl(obj);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m8471constructorimpl = Result.m8471constructorimpl(ResultKt.createFailure(th));
        }
        TaskResultProvider<T> taskResultProvider = this.$resultProvider;
        if (Result.m8478isSuccessimpl(m8471constructorimpl)) {
            taskResultProvider.setTaskResult((TaskResultProvider<T>) m8471constructorimpl);
        }
        TaskResultProvider<T> taskResultProvider2 = this.$resultProvider;
        Throwable m8474exceptionOrNullimpl = Result.m8474exceptionOrNullimpl(m8471constructorimpl);
        if (m8474exceptionOrNullimpl != null) {
            taskResultProvider2.setTaskResult(m8474exceptionOrNullimpl);
        }
        return Unit.INSTANCE;
    }
}
