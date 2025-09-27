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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import ru.rustore.sdk.core.tasks.Task;
/* compiled from: TaskHelper.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bJ?\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lru/rustore/sdk/core/tasks/TaskHelper;", "", "()V", "forException", "Lru/rustore/sdk/core/tasks/Task;", ExifInterface.GPS_DIRECTION_TRUE, "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "wrap", "taskDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "task", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function1;)Lru/rustore/sdk/core/tasks/Task;", "sdk-public-core_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TaskHelper {
    public static final TaskHelper INSTANCE = new TaskHelper();

    private TaskHelper() {
    }

    public static /* synthetic */ Task wrap$default(TaskHelper taskHelper, CoroutineDispatcher coroutineDispatcher, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineDispatcher = Dispatchers.getDefault();
        }
        return taskHelper.wrap(coroutineDispatcher, function1);
    }

    public final <T> Task<T> wrap(CoroutineDispatcher taskDispatcher, final Function1<? super Continuation<? super T>, ? extends Object> task) {
        CompletableJob Job$default;
        Intrinsics.checkNotNullParameter(taskDispatcher, "taskDispatcher");
        Intrinsics.checkNotNullParameter(task, "task");
        Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        final CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(taskDispatcher.plus(Job$default));
        Task<T> create = Task.Companion.create(new Function1<Task<T>.TaskResultProvider, Unit>() { // from class: ru.rustore.sdk.core.tasks.TaskHelper$wrap$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke((Task.TaskResultProvider) obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: TaskHelper.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 0}, xi = 48)
            @DebugMetadata(c = "ru.rustore.sdk.core.tasks.TaskHelper$wrap$1$1", f = "TaskHelper.kt", i = {}, l = {20}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: ru.rustore.sdk.core.tasks.TaskHelper$wrap$1$1  reason: invalid class name */
            /* loaded from: classes6.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function1<Continuation<? super T>, Object> $task;
                final /* synthetic */ Task<T>.TaskResultProvider $this_create;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass1(Task<T>.TaskResultProvider taskResultProvider, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$this_create = taskResultProvider;
                    this.$task = function1;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_create, this.$task, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object m9106constructorimpl;
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
                        m9106constructorimpl = Result.m9106constructorimpl(obj);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        m9106constructorimpl = Result.m9106constructorimpl(ResultKt.createFailure(th));
                    }
                    Task<T>.TaskResultProvider taskResultProvider = this.$this_create;
                    if (Result.m9113isSuccessimpl(m9106constructorimpl)) {
                        taskResultProvider.setTaskSuccessResult(m9106constructorimpl);
                    }
                    Task<T>.TaskResultProvider taskResultProvider2 = this.$this_create;
                    Throwable m9109exceptionOrNullimpl = Result.m9109exceptionOrNullimpl(m9106constructorimpl);
                    if (m9109exceptionOrNullimpl != null) {
                        taskResultProvider2.setTaskErrorResult(m9109exceptionOrNullimpl);
                    }
                    return Unit.INSTANCE;
                }
            }

            public final void invoke(Task<T>.TaskResultProvider create2) {
                Intrinsics.checkNotNullParameter(create2, "$this$create");
                BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(create2, task, null), 3, null);
            }
        });
        create.addOnCompletionListener(new OnCompletionListener() { // from class: ru.rustore.sdk.core.tasks.TaskHelper$$ExternalSyntheticLambda0
            @Override // ru.rustore.sdk.core.tasks.OnCompletionListener
            public final void onComplete(Throwable th) {
                TaskHelper.wrap$lambda$1$lambda$0(CoroutineScope.this, th);
            }
        });
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wrap$lambda$1$lambda$0(CoroutineScope coroutineScope, Throwable th) {
        Intrinsics.checkNotNullParameter(coroutineScope, "$coroutineScope");
        if (th instanceof TaskCancellationException) {
            CoroutineScopeKt.cancel$default(coroutineScope, null, 1, null);
        }
    }

    public final <T> Task<T> forException(final Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        return Task.Companion.create(new Function1<Task<T>.TaskResultProvider, Unit>() { // from class: ru.rustore.sdk.core.tasks.TaskHelper$forException$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke((Task.TaskResultProvider) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Task<T>.TaskResultProvider create) {
                Intrinsics.checkNotNullParameter(create, "$this$create");
                create.setTaskErrorResult(exception);
            }
        });
    }
}
