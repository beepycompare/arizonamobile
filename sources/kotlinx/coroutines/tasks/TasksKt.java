package kotlinx.coroutines.tasks;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.ChildJob;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectClause1;
/* compiled from: Tasks.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a&\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a(\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002\u001a\u001e\u0010\b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0086@¢\u0006\u0002\u0010\t\u001a&\u0010\b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0087@¢\u0006\u0002\u0010\n\u001a(\u0010\u000b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0082@¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"asTask", "Lcom/google/android/gms/tasks/Task;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/Deferred;", "asDeferred", "cancellationTokenSource", "Lcom/google/android/gms/tasks/CancellationTokenSource;", "asDeferredImpl", "await", "(Lcom/google/android/gms/tasks/Task;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lcom/google/android/gms/tasks/Task;Lcom/google/android/gms/tasks/CancellationTokenSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitImpl", "kotlinx-coroutines-play-services"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TasksKt {
    public static final <T> Task<T> asTask(final Deferred<? extends T> deferred) {
        final CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
        deferred.invokeOnCompletion(new Function1() { // from class: kotlinx.coroutines.tasks.TasksKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit asTask$lambda$0;
                asTask$lambda$0 = TasksKt.asTask$lambda$0(CancellationTokenSource.this, deferred, taskCompletionSource, (Throwable) obj);
                return asTask$lambda$0;
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit asTask$lambda$0(CancellationTokenSource cancellationTokenSource, Deferred deferred, TaskCompletionSource taskCompletionSource, Throwable th) {
        if (th instanceof CancellationException) {
            cancellationTokenSource.cancel();
            return Unit.INSTANCE;
        }
        Throwable completionExceptionOrNull = deferred.getCompletionExceptionOrNull();
        if (completionExceptionOrNull == null) {
            taskCompletionSource.setResult(deferred.getCompleted());
        } else {
            RuntimeExecutionException runtimeExecutionException = completionExceptionOrNull instanceof Exception ? (Exception) completionExceptionOrNull : null;
            if (runtimeExecutionException == null) {
                runtimeExecutionException = new RuntimeExecutionException(completionExceptionOrNull);
            }
            taskCompletionSource.setException(runtimeExecutionException);
        }
        return Unit.INSTANCE;
    }

    public static final <T> Deferred<T> asDeferred(Task<T> task) {
        return asDeferredImpl(task, null);
    }

    public static final <T> Deferred<T> asDeferred(Task<T> task, CancellationTokenSource cancellationTokenSource) {
        return asDeferredImpl(task, cancellationTokenSource);
    }

    private static final <T> Deferred<T> asDeferredImpl(Task<T> task, final CancellationTokenSource cancellationTokenSource) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        if (task.isComplete()) {
            Exception exception = task.getException();
            if (exception == null) {
                if (task.isCanceled()) {
                    Job.DefaultImpls.cancel$default((Job) CompletableDeferred$default, (CancellationException) null, 1, (Object) null);
                } else {
                    CompletableDeferred$default.complete(task.getResult());
                }
            } else {
                CompletableDeferred$default.completeExceptionally(exception);
            }
        } else {
            task.addOnCompleteListener(DirectExecutor.INSTANCE, new OnCompleteListener() { // from class: kotlinx.coroutines.tasks.TasksKt$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    TasksKt.asDeferredImpl$lambda$1(CompletableDeferred.this, task2);
                }
            });
        }
        if (cancellationTokenSource != null) {
            CompletableDeferred$default.invokeOnCompletion(new Function1() { // from class: kotlinx.coroutines.tasks.TasksKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit asDeferredImpl$lambda$2;
                    asDeferredImpl$lambda$2 = TasksKt.asDeferredImpl$lambda$2(CancellationTokenSource.this, (Throwable) obj);
                    return asDeferredImpl$lambda$2;
                }
            });
        }
        return new Deferred<T>() { // from class: kotlinx.coroutines.tasks.TasksKt$asDeferredImpl$3
            @Override // kotlinx.coroutines.Job
            public ChildHandle attachChild(ChildJob childJob) {
                return CompletableDeferred$default.attachChild(childJob);
            }

            @Override // kotlinx.coroutines.Deferred
            public Object await(Continuation<? super T> continuation) {
                return CompletableDeferred$default.await(continuation);
            }

            @Override // kotlinx.coroutines.Job
            @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
            public /* synthetic */ void cancel() {
                CompletableDeferred$default.cancel();
            }

            @Override // kotlinx.coroutines.Job
            public void cancel(CancellationException cancellationException) {
                CompletableDeferred$default.cancel(cancellationException);
            }

            @Override // kotlinx.coroutines.Job
            @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
            public /* synthetic */ boolean cancel(Throwable th) {
                return CompletableDeferred$default.cancel(th);
            }

            @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
            public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
                return (R) CompletableDeferred$default.fold(r, function2);
            }

            @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
            public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
                return (E) CompletableDeferred$default.get(key);
            }

            @Override // kotlinx.coroutines.Job
            public CancellationException getCancellationException() {
                return CompletableDeferred$default.getCancellationException();
            }

            @Override // kotlinx.coroutines.Job
            public Sequence<Job> getChildren() {
                return CompletableDeferred$default.getChildren();
            }

            @Override // kotlinx.coroutines.Deferred
            public T getCompleted() {
                return CompletableDeferred$default.getCompleted();
            }

            @Override // kotlinx.coroutines.Deferred
            public Throwable getCompletionExceptionOrNull() {
                return CompletableDeferred$default.getCompletionExceptionOrNull();
            }

            @Override // kotlin.coroutines.CoroutineContext.Element
            public CoroutineContext.Key<?> getKey() {
                return CompletableDeferred$default.getKey();
            }

            @Override // kotlinx.coroutines.Deferred
            public SelectClause1<T> getOnAwait() {
                return CompletableDeferred$default.getOnAwait();
            }

            @Override // kotlinx.coroutines.Job
            public SelectClause0 getOnJoin() {
                return CompletableDeferred$default.getOnJoin();
            }

            @Override // kotlinx.coroutines.Job
            public Job getParent() {
                return CompletableDeferred$default.getParent();
            }

            @Override // kotlinx.coroutines.Job
            public DisposableHandle invokeOnCompletion(Function1<? super Throwable, Unit> function1) {
                return CompletableDeferred$default.invokeOnCompletion(function1);
            }

            @Override // kotlinx.coroutines.Job
            public DisposableHandle invokeOnCompletion(boolean z, boolean z2, Function1<? super Throwable, Unit> function1) {
                return CompletableDeferred$default.invokeOnCompletion(z, z2, function1);
            }

            @Override // kotlinx.coroutines.Job
            public boolean isActive() {
                return CompletableDeferred$default.isActive();
            }

            @Override // kotlinx.coroutines.Job
            public boolean isCancelled() {
                return CompletableDeferred$default.isCancelled();
            }

            @Override // kotlinx.coroutines.Job
            public boolean isCompleted() {
                return CompletableDeferred$default.isCompleted();
            }

            @Override // kotlinx.coroutines.Job
            public Object join(Continuation<? super Unit> continuation) {
                return CompletableDeferred$default.join(continuation);
            }

            @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
            public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
                return CompletableDeferred$default.minusKey(key);
            }

            @Override // kotlin.coroutines.CoroutineContext
            public CoroutineContext plus(CoroutineContext coroutineContext) {
                return CompletableDeferred$default.plus(coroutineContext);
            }

            @Override // kotlinx.coroutines.Job
            @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
            public Job plus(Job job) {
                return CompletableDeferred$default.plus(job);
            }

            @Override // kotlinx.coroutines.Job
            public boolean start() {
                return CompletableDeferred$default.start();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asDeferredImpl$lambda$1(CompletableDeferred completableDeferred, Task task) {
        Exception exception = task.getException();
        if (exception == null) {
            if (task.isCanceled()) {
                Job.DefaultImpls.cancel$default((Job) completableDeferred, (CancellationException) null, 1, (Object) null);
                return;
            } else {
                completableDeferred.complete(task.getResult());
                return;
            }
        }
        completableDeferred.completeExceptionally(exception);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit asDeferredImpl$lambda$2(CancellationTokenSource cancellationTokenSource, Throwable th) {
        cancellationTokenSource.cancel();
        return Unit.INSTANCE;
    }

    public static final <T> Object await(Task<T> task, Continuation<? super T> continuation) {
        return awaitImpl(task, null, continuation);
    }

    public static final <T> Object await(Task<T> task, CancellationTokenSource cancellationTokenSource, Continuation<? super T> continuation) {
        return awaitImpl(task, cancellationTokenSource, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Object awaitImpl(Task<T> task, final CancellationTokenSource cancellationTokenSource, Continuation<? super T> continuation) {
        if (task.isComplete()) {
            Exception exception = task.getException();
            if (exception == null) {
                if (task.isCanceled()) {
                    throw new CancellationException("Task " + task + " was cancelled normally.");
                }
                return task.getResult();
            }
            throw exception;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        task.addOnCompleteListener(DirectExecutor.INSTANCE, new OnCompleteListener() { // from class: kotlinx.coroutines.tasks.TasksKt$awaitImpl$2$1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task<T> task2) {
                Exception exception2 = task2.getException();
                if (exception2 == null) {
                    if (task2.isCanceled()) {
                        CancellableContinuation.DefaultImpls.cancel$default(cancellableContinuationImpl2, null, 1, null);
                        return;
                    }
                    Result.Companion companion = Result.Companion;
                    cancellableContinuationImpl2.resumeWith(Result.m8471constructorimpl(task2.getResult()));
                    return;
                }
                Result.Companion companion2 = Result.Companion;
                cancellableContinuationImpl2.resumeWith(Result.m8471constructorimpl(ResultKt.createFailure(exception2)));
            }
        });
        if (cancellationTokenSource != null) {
            cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.tasks.TasksKt$awaitImpl$2$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    CancellationTokenSource.this.cancel();
                }
            });
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
