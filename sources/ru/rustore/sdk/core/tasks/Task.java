package ru.rustore.sdk.core.tasks;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.widget.FacebookDialog;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Task.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001)B%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ8\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017J\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0012J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0016\u001a\u00020\u0012J\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010J\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010J\u000b\u0010\u001a\u001a\u00028\u0000¢\u0006\u0002\u0010\u001bJ\u001b\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\u0007J\u0015\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010$J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&H\u0002J\u001c\u0010'\u001a\u00020\u0007*\u0004\u0018\u00010\u00142\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\rX\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, d2 = {"Lru/rustore/sdk/core/tasks/Task;", ExifInterface.GPS_DIRECTION_TRUE, "", "resultProvider", "Lru/rustore/sdk/core/tasks/TaskResultProvider;", "onCancel", "Lkotlin/Function0;", "", "(Lru/rustore/sdk/core/tasks/TaskResultProvider;Lkotlin/jvm/functions/Function0;)V", "listeners", "", "Lru/rustore/sdk/core/tasks/Task$Listener;", "taskResult", "Lkotlin/Result;", "addListener", "onSuccess", "Lru/rustore/sdk/core/tasks/OnSuccessListener;", "onFailure", "Lru/rustore/sdk/core/tasks/OnFailureListener;", "executor", "Ljava/util/concurrent/Executor;", "addOnCompleteListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lru/rustore/sdk/core/tasks/OnCompleteListener;", "addOnFailureListener", "addOnSuccessListener", "await", "()Ljava/lang/Object;", "timeout", "", "unit", "Ljava/util/concurrent/TimeUnit;", "(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", FacebookDialog.COMPLETION_GESTURE_CANCEL, "setTaskResult", "data", "(Ljava/lang/Object;)V", "error", "", "runWithFallbackToMain", "block", "Listener", "sdk-public-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Task<T> {
    private final List<Listener<T>> listeners;
    private final Function0<Unit> onCancel;
    private volatile Result<? extends T> taskResult;

    public Task(TaskResultProvider<T> resultProvider, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(resultProvider, "resultProvider");
        this.onCancel = function0;
        resultProvider.setOnDataTaskResult(new AnonymousClass1(this));
        resultProvider.setOnErrorTaskResult(new AnonymousClass2(this));
        this.listeners = new ArrayList();
    }

    public /* synthetic */ Task(TaskResultProvider taskResultProvider, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(taskResultProvider, (i & 2) != 0 ? null : function0);
    }

    /* compiled from: Task.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: ru.rustore.sdk.core.tasks.Task$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<T, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, Task.class, "setTaskResult", "setTaskResult(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2((AnonymousClass1) obj);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(T t) {
            ((Task) this.receiver).setTaskResult((Task) t);
        }
    }

    /* compiled from: Task.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: ru.rustore.sdk.core.tasks.Task$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
        AnonymousClass2(Object obj) {
            super(1, obj, Task.class, "setTaskResult", "setTaskResult(Ljava/lang/Throwable;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((Task) this.receiver).setTaskResult(p0);
        }
    }

    public final T await() {
        return await(30L, TimeUnit.SECONDS);
    }

    public final T await(long j, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        if (this.taskResult != null) {
            countDownLatch.countDown();
        } else {
            addListener(new OnSuccessListener() { // from class: ru.rustore.sdk.core.tasks.Task$$ExternalSyntheticLambda2
                @Override // ru.rustore.sdk.core.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    Task.await$lambda$0(countDownLatch, obj);
                }
            }, new OnFailureListener() { // from class: ru.rustore.sdk.core.tasks.Task$$ExternalSyntheticLambda3
                @Override // ru.rustore.sdk.core.tasks.OnFailureListener
                public final void onFailure(Throwable th) {
                    Task.await$lambda$1(countDownLatch, th);
                }
            }, TaskThreadHelper.INSTANCE.getExecutorService());
        }
        countDownLatch.await(j, unit);
        Result<? extends T> result = this.taskResult;
        if (result != null) {
            T t = (T) result.m8480unboximpl();
            ResultKt.throwOnFailure(t);
            return t;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void await$lambda$0(CountDownLatch countDownLatch, Object obj) {
        Intrinsics.checkNotNullParameter(countDownLatch, "$countDownLatch");
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void await$lambda$1(CountDownLatch countDownLatch, Throwable it) {
        Intrinsics.checkNotNullParameter(countDownLatch, "$countDownLatch");
        Intrinsics.checkNotNullParameter(it, "it");
        countDownLatch.countDown();
    }

    public final void cancel() {
        Function0<Unit> function0 = this.onCancel;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final Task<T> addOnCompleteListener(OnCompleteListener<T> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return addListener(listener, listener, null);
    }

    public final Task<T> addOnCompleteListener(Executor executor, OnCompleteListener<T> listener) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(listener, "listener");
        return addListener(listener, listener, executor);
    }

    public final Task<T> addOnSuccessListener(OnSuccessListener<T> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return addListener(listener, null, null);
    }

    public final Task<T> addOnSuccessListener(Executor executor, OnSuccessListener<T> listener) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(listener, "listener");
        return addListener(listener, null, executor);
    }

    public final Task<T> addOnFailureListener(OnFailureListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return addListener(null, listener, null);
    }

    public final Task<T> addOnFailureListener(Executor executor, OnFailureListener listener) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(listener, "listener");
        return addListener(null, listener, executor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void setTaskResult(final T t) {
        Result.Companion companion = Result.Companion;
        this.taskResult = Result.m8470boximpl(Result.m8471constructorimpl(t));
        for (Listener<T> listener : this.listeners) {
            final OnSuccessListener<T> onSuccess = listener.getOnSuccess();
            if (onSuccess != null) {
                runWithFallbackToMain(listener.getExecutor(), new Function0<Unit>() { // from class: ru.rustore.sdk.core.tasks.Task$setTaskResult$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        onSuccess.onSuccess(t);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void setTaskResult(final Throwable th) {
        Result.Companion companion = Result.Companion;
        this.taskResult = Result.m8470boximpl(Result.m8471constructorimpl(ResultKt.createFailure(th)));
        for (Listener<T> listener : this.listeners) {
            final OnFailureListener onFailure = listener.getOnFailure();
            if (onFailure != null) {
                runWithFallbackToMain(listener.getExecutor(), new Function0<Unit>() { // from class: ru.rustore.sdk.core.tasks.Task$setTaskResult$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        OnFailureListener.this.onFailure(th);
                    }
                });
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Task addListener$default(Task task, OnSuccessListener onSuccessListener, OnFailureListener onFailureListener, Executor executor, int i, Object obj) {
        if ((i & 1) != 0) {
            onSuccessListener = null;
        }
        if ((i & 2) != 0) {
            onFailureListener = null;
        }
        if ((i & 4) != 0) {
            executor = null;
        }
        return task.addListener(onSuccessListener, onFailureListener, executor);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000e, code lost:
        if (kotlin.Result.m8477isFailureimpl(r2) != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final synchronized Task<T> addListener(final OnSuccessListener<T> onSuccessListener, final OnFailureListener onFailureListener, Executor executor) {
        final Object obj;
        Result<? extends T> result = this.taskResult;
        if (result != null) {
            obj = result.m8480unboximpl();
        }
        obj = null;
        final Throwable m8474exceptionOrNullimpl = result != null ? Result.m8474exceptionOrNullimpl(result.m8480unboximpl()) : null;
        if (obj != null && onSuccessListener != null) {
            runWithFallbackToMain(executor, new Function0<Unit>() { // from class: ru.rustore.sdk.core.tasks.Task$addListener$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    onSuccessListener.onSuccess(obj);
                }
            });
        }
        if (m8474exceptionOrNullimpl != null && onFailureListener != null) {
            runWithFallbackToMain(executor, new Function0<Unit>() { // from class: ru.rustore.sdk.core.tasks.Task$addListener$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    OnFailureListener.this.onFailure(m8474exceptionOrNullimpl);
                }
            });
        }
        this.listeners.add(new Listener<>(onSuccessListener, onFailureListener, executor));
        return this;
    }

    private final void runWithFallbackToMain(Executor executor, final Function0<Unit> function0) {
        if (executor != null) {
            executor.execute(new Runnable() { // from class: ru.rustore.sdk.core.tasks.Task$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    Task.runWithFallbackToMain$lambda$2(Function0.this);
                }
            });
        } else {
            TaskThreadHelper.INSTANCE.getMainHandler().post(new Runnable() { // from class: ru.rustore.sdk.core.tasks.Task$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    Task.runWithFallbackToMain$lambda$3(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runWithFallbackToMain$lambda$2(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runWithFallbackToMain$lambda$3(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Task.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B/\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lru/rustore/sdk/core/tasks/Task$Listener;", ExifInterface.GPS_DIRECTION_TRUE, "", "onSuccess", "Lru/rustore/sdk/core/tasks/OnSuccessListener;", "onFailure", "Lru/rustore/sdk/core/tasks/OnFailureListener;", "executor", "Ljava/util/concurrent/Executor;", "(Lru/rustore/sdk/core/tasks/OnSuccessListener;Lru/rustore/sdk/core/tasks/OnFailureListener;Ljava/util/concurrent/Executor;)V", "getExecutor", "()Ljava/util/concurrent/Executor;", "getOnFailure", "()Lru/rustore/sdk/core/tasks/OnFailureListener;", "getOnSuccess", "()Lru/rustore/sdk/core/tasks/OnSuccessListener;", "sdk-public-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Listener<T> {
        private final Executor executor;
        private final OnFailureListener onFailure;
        private final OnSuccessListener<T> onSuccess;

        public Listener() {
            this(null, null, null, 7, null);
        }

        public Listener(OnSuccessListener<T> onSuccessListener, OnFailureListener onFailureListener, Executor executor) {
            this.onSuccess = onSuccessListener;
            this.onFailure = onFailureListener;
            this.executor = executor;
        }

        public /* synthetic */ Listener(OnSuccessListener onSuccessListener, OnFailureListener onFailureListener, Executor executor, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : onSuccessListener, (i & 2) != 0 ? null : onFailureListener, (i & 4) != 0 ? null : executor);
        }

        public final OnSuccessListener<T> getOnSuccess() {
            return this.onSuccess;
        }

        public final OnFailureListener getOnFailure() {
            return this.onFailure;
        }

        public final Executor getExecutor() {
            return this.executor;
        }
    }
}
