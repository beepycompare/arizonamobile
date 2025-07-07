package ru.rustore.sdk.core.tasks;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
/* compiled from: TaskHelper.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bJB\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rø\u0001\u0000¢\u0006\u0002\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lru/rustore/sdk/core/tasks/TaskHelper;", "", "()V", "forException", "Lru/rustore/sdk/core/tasks/Task;", ExifInterface.GPS_DIRECTION_TRUE, "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "wrap", "taskDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "task", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function1;)Lru/rustore/sdk/core/tasks/Task;", "sdk-public-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
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

    public final <T> Task<T> wrap(CoroutineDispatcher taskDispatcher, Function1<? super Continuation<? super T>, ? extends Object> task) {
        CompletableJob Job$default;
        Intrinsics.checkNotNullParameter(taskDispatcher, "taskDispatcher");
        Intrinsics.checkNotNullParameter(task, "task");
        Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        final CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(taskDispatcher.plus(Job$default));
        TaskResultProvider taskResultProvider = new TaskResultProvider();
        Task<T> task2 = new Task<>(taskResultProvider, new Function0<Unit>() { // from class: ru.rustore.sdk.core.tasks.TaskHelper$wrap$result$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                CoroutineScopeKt.cancel$default(CoroutineScope.this, null, 1, null);
            }
        });
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new TaskHelper$wrap$1(taskResultProvider, task, null), 3, null);
        return task2;
    }

    public final <T> Task<T> forException(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        TaskResultProvider taskResultProvider = new TaskResultProvider();
        Task<T> task = new Task<>(taskResultProvider, null, 2, null);
        taskResultProvider.setTaskResult((Throwable) exception);
        return task;
    }
}
