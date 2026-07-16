package kotlinx.coroutines.rx2;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.InterruptibleKt;
import kotlinx.coroutines.JobKt;
/* compiled from: RxScheduler.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0011\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0007¢\u0006\u0002\b\u0000\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0001\u001aR\u0010\u000b\u001a\u00020\f*\u00020\r2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\u0011\u001a\u00020\u001220\u0010\u0013\u001a,\u0012\u001e\u0012\u001c\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007j\u0002`\u0014\u0012\b\u0012\u00060\u000fj\u0002`\u00100\u0007H\u0002\"\u000e\u0010\u0015\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000*8\b\u0002\u0010\u0006\"\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00072\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007¨\u0006\u0016"}, d2 = {"asCoroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lio/reactivex/Scheduler;", "asCoroutineDispatcher0", "Lkotlinx/coroutines/rx2/SchedulerCoroutineDispatcher;", "asScheduler", "Task", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "scheduleTask", "Lio/reactivex/disposables/Disposable;", "Lkotlinx/coroutines/CoroutineScope;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "delayMillis", "", "adaptForScheduling", "Lkotlinx/coroutines/rx2/Task;", "TASK_FINISHED", "kotlinx-coroutines-rx2"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RxSchedulerKt {
    private static final Object TASK_FINISHED = new Object();

    public static final CoroutineDispatcher asCoroutineDispatcher(Scheduler scheduler) {
        if (scheduler instanceof DispatcherScheduler) {
            return ((DispatcherScheduler) scheduler).dispatcher;
        }
        return new SchedulerCoroutineDispatcher(scheduler);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.4.2, binary compatibility with earlier versions")
    /* renamed from: asCoroutineDispatcher  reason: collision with other method in class */
    public static final /* synthetic */ SchedulerCoroutineDispatcher m11510asCoroutineDispatcher(Scheduler scheduler) {
        return new SchedulerCoroutineDispatcher(scheduler);
    }

    public static final Scheduler asScheduler(CoroutineDispatcher coroutineDispatcher) {
        if (coroutineDispatcher instanceof SchedulerCoroutineDispatcher) {
            return ((SchedulerCoroutineDispatcher) coroutineDispatcher).getScheduler();
        }
        return new DispatcherScheduler(coroutineDispatcher);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Disposable scheduleTask(CoroutineScope coroutineScope, Runnable runnable, long j, Function1<? super Function1<? super Continuation<? super Unit>, ? extends Object>, ? extends Runnable> function1) {
        CoroutineContext coroutineContext = coroutineScope.getCoroutineContext();
        Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
        AtomicReference atomicReference = new AtomicReference(null);
        Runnable invoke = function1.invoke(new RxSchedulerKt$scheduleTask$toSchedule$1(atomicReference, coroutineContext, onSchedule));
        if (CoroutineScopeKt.isActive(coroutineScope)) {
            if (j <= 0) {
                invoke.run();
                Disposable empty = Disposables.empty();
                atomicReference.set(empty);
                return empty;
            }
            DisposableHandle invokeOnTimeout = DelayKt.getDelay(coroutineContext).invokeOnTimeout(j, invoke, coroutineContext);
            DisposableHandle disposeOnCompletion = JobKt.disposeOnCompletion(JobKt.getJob(coroutineContext), invokeOnTimeout);
            WorkerTaskDisposable workerTaskDisposable = new WorkerTaskDisposable(invokeOnTimeout, disposeOnCompletion);
            if (MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, workerTaskDisposable)) {
                return workerTaskDisposable;
            }
            disposeOnCompletion.dispose();
            return Disposables.empty();
        }
        return Disposables.disposed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(8:5|6|7|(1:(2:10|11)(2:25|26))(3:27|(1:29)(1:38)|(2:35|(1:37))(2:33|34))|12|(3:14|(1:16)|(1:18))|21|22))|62|6|7|(0)(0)|12|(0)|21|22|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008d, code lost:
        if (r5 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008f, code lost:
        r5.dispose();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0093, code lost:
        kotlinx.coroutines.rx2.RxCancellableKt.handleUndeliverableException(r7, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x009c, code lost:
        if (androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(r5, null, kotlinx.coroutines.rx2.RxSchedulerKt.TASK_FINISHED) == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009e, code lost:
        r5 = r5.get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a4, code lost:
        if ((r5 instanceof kotlinx.coroutines.rx2.WorkerTaskDisposable) != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a6, code lost:
        r4 = (kotlinx.coroutines.rx2.WorkerTaskDisposable) r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a9, code lost:
        if (r4 != null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ab, code lost:
        r5 = r4.getCleanupOnScopeCancellationHandle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00af, code lost:
        if (r5 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b5, code lost:
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00bc, code lost:
        if (androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(r5, null, kotlinx.coroutines.rx2.RxSchedulerKt.TASK_FINISHED) == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00be, code lost:
        r5 = r5.get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c4, code lost:
        if ((r5 instanceof kotlinx.coroutines.rx2.WorkerTaskDisposable) != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c6, code lost:
        r4 = (kotlinx.coroutines.rx2.WorkerTaskDisposable) r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00c9, code lost:
        if (r4 != null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d1, code lost:
        r5.dispose();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d4, code lost:
        throw r6;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007c  */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object, kotlin.coroutines.CoroutineContext] */
    /* JADX WARN: Type inference failed for: r6v1, types: [kotlin.coroutines.CoroutineContext] */
    /* JADX WARN: Type inference failed for: r6v8, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object scheduleTask$task(AtomicReference<Object> atomicReference, CoroutineContext coroutineContext, final Runnable runnable, Continuation<? super Unit> continuation) {
        RxSchedulerKt$scheduleTask$task$1 rxSchedulerKt$scheduleTask$task$1;
        int i;
        boolean m;
        if (continuation instanceof RxSchedulerKt$scheduleTask$task$1) {
            rxSchedulerKt$scheduleTask$task$1 = (RxSchedulerKt$scheduleTask$task$1) continuation;
            if ((rxSchedulerKt$scheduleTask$task$1.label & Integer.MIN_VALUE) != 0) {
                rxSchedulerKt$scheduleTask$task$1.label -= Integer.MIN_VALUE;
                Object obj = rxSchedulerKt$scheduleTask$task$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = rxSchedulerKt$scheduleTask$task$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Object obj2 = atomicReference.get();
                    Disposable disposable = obj2 instanceof Disposable ? (Disposable) obj2 : null;
                    if (disposable != null && disposable.isDisposed()) {
                        return Unit.INSTANCE;
                    }
                    Function0 function0 = new Function0() { // from class: kotlinx.coroutines.rx2.RxSchedulerKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return RxSchedulerKt.scheduleTask$task$lambda$0(runnable);
                        }
                    };
                    rxSchedulerKt$scheduleTask$task$1.L$0 = atomicReference;
                    rxSchedulerKt$scheduleTask$task$1.L$1 = coroutineContext;
                    rxSchedulerKt$scheduleTask$task$1.L$2 = SpillingKt.nullOutSpilledVariable(runnable);
                    rxSchedulerKt$scheduleTask$task$1.label = 1;
                    if (InterruptibleKt.runInterruptible$default(null, function0, rxSchedulerKt$scheduleTask$task$1, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    Runnable runnable2 = (Runnable) rxSchedulerKt$scheduleTask$task$1.L$2;
                    CoroutineContext coroutineContext2 = (CoroutineContext) rxSchedulerKt$scheduleTask$task$1.L$1;
                    atomicReference = (AtomicReference) rxSchedulerKt$scheduleTask$task$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (m == 0) {
                    Object obj3 = atomicReference.get();
                    r4 = obj3 instanceof WorkerTaskDisposable ? (WorkerTaskDisposable) obj3 : null;
                    if (r4 != null) {
                        DisposableHandle cleanupOnScopeCancellationHandle = r4.getCleanupOnScopeCancellationHandle();
                    }
                }
                return Unit.INSTANCE;
            }
        }
        rxSchedulerKt$scheduleTask$task$1 = new RxSchedulerKt$scheduleTask$task$1(continuation);
        Object obj4 = rxSchedulerKt$scheduleTask$task$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = rxSchedulerKt$scheduleTask$task$1.label;
        if (i != 0) {
        }
        if (m == 0) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit scheduleTask$task$lambda$0(Runnable runnable) {
        runnable.run();
        return Unit.INSTANCE;
    }
}
