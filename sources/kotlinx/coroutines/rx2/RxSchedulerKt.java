package kotlinx.coroutines.rx2;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.InterruptibleKt;
/* compiled from: RxScheduler.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0011\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0007¢\u0006\u0002\b\u0000\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0001\u001aR\u0010\u000b\u001a\u00020\f*\u00020\r2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\u0011\u001a\u00020\u001220\u0010\u0013\u001a,\u0012\u001e\u0012\u001c\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007j\u0002`\u0014\u0012\b\u0012\u00060\u000fj\u0002`\u00100\u0007H\u0002*8\b\u0002\u0010\u0006\"\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00072\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007¨\u0006\u0015"}, d2 = {"asCoroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lio/reactivex/Scheduler;", "asCoroutineDispatcher0", "Lkotlinx/coroutines/rx2/SchedulerCoroutineDispatcher;", "asScheduler", "Task", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "scheduleTask", "Lio/reactivex/disposables/Disposable;", "Lkotlinx/coroutines/CoroutineScope;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "delayMillis", "", "adaptForScheduling", "Lkotlinx/coroutines/rx2/Task;", "kotlinx-coroutines-rx2"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RxSchedulerKt {
    public static final CoroutineDispatcher asCoroutineDispatcher(Scheduler scheduler) {
        if (scheduler instanceof DispatcherScheduler) {
            return ((DispatcherScheduler) scheduler).dispatcher;
        }
        return new SchedulerCoroutineDispatcher(scheduler);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.4.2, binary compatibility with earlier versions")
    /* renamed from: asCoroutineDispatcher  reason: collision with other method in class */
    public static final /* synthetic */ SchedulerCoroutineDispatcher m10045asCoroutineDispatcher(Scheduler scheduler) {
        return new SchedulerCoroutineDispatcher(scheduler);
    }

    public static final Scheduler asScheduler(CoroutineDispatcher coroutineDispatcher) {
        if (coroutineDispatcher instanceof SchedulerCoroutineDispatcher) {
            return ((SchedulerCoroutineDispatcher) coroutineDispatcher).getScheduler();
        }
        return new DispatcherScheduler(coroutineDispatcher);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r5v4, types: [kotlinx.coroutines.DisposableHandle, T] */
    public static final Disposable scheduleTask(CoroutineScope coroutineScope, Runnable runnable, long j, Function1<? super Function1<? super Continuation<? super Unit>, ? extends Object>, ? extends Runnable> function1) {
        CoroutineContext coroutineContext = coroutineScope.getCoroutineContext();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Disposable fromRunnable = Disposables.fromRunnable(new Runnable() { // from class: kotlinx.coroutines.rx2.RxSchedulerKt$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                RxSchedulerKt.scheduleTask$lambda$0(Ref.ObjectRef.this);
            }
        });
        Runnable invoke = function1.invoke(new RxSchedulerKt$scheduleTask$toSchedule$1(fromRunnable, coroutineContext, RxJavaPlugins.onSchedule(runnable)));
        if (CoroutineScopeKt.isActive(coroutineScope)) {
            if (j <= 0) {
                invoke.run();
                return fromRunnable;
            }
            objectRef.element = DelayKt.getDelay(coroutineContext).invokeOnTimeout(j, invoke, coroutineContext);
            return fromRunnable;
        }
        return Disposables.disposed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleTask$lambda$0(Ref.ObjectRef objectRef) {
        DisposableHandle disposableHandle = (DisposableHandle) objectRef.element;
        if (disposableHandle != null) {
            disposableHandle.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(2:10|11)(2:17|18))(2:19|(2:21|22)(2:23|(1:25)))|12|13|14))|28|6|7|(0)(0)|12|13|14) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0055, code lost:
        kotlinx.coroutines.rx2.RxCancellableKt.handleUndeliverableException(r4, r5);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object scheduleTask$task(Disposable disposable, CoroutineContext coroutineContext, final Runnable runnable, Continuation<? super Unit> continuation) {
        RxSchedulerKt$scheduleTask$task$1 rxSchedulerKt$scheduleTask$task$1;
        int i;
        if (continuation instanceof RxSchedulerKt$scheduleTask$task$1) {
            rxSchedulerKt$scheduleTask$task$1 = (RxSchedulerKt$scheduleTask$task$1) continuation;
            if ((rxSchedulerKt$scheduleTask$task$1.label & Integer.MIN_VALUE) != 0) {
                rxSchedulerKt$scheduleTask$task$1.label -= Integer.MIN_VALUE;
                Object obj = rxSchedulerKt$scheduleTask$task$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = rxSchedulerKt$scheduleTask$task$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (disposable.isDisposed()) {
                        return Unit.INSTANCE;
                    }
                    Function0 function0 = new Function0() { // from class: kotlinx.coroutines.rx2.RxSchedulerKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit scheduleTask$task$lambda$1;
                            scheduleTask$task$lambda$1 = RxSchedulerKt.scheduleTask$task$lambda$1(runnable);
                            return scheduleTask$task$lambda$1;
                        }
                    };
                    rxSchedulerKt$scheduleTask$task$1.L$0 = coroutineContext;
                    rxSchedulerKt$scheduleTask$task$1.label = 1;
                    if (InterruptibleKt.runInterruptible$default(null, function0, rxSchedulerKt$scheduleTask$task$1, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    coroutineContext = (CoroutineContext) rxSchedulerKt$scheduleTask$task$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
        rxSchedulerKt$scheduleTask$task$1 = new RxSchedulerKt$scheduleTask$task$1(continuation);
        Object obj2 = rxSchedulerKt$scheduleTask$task$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = rxSchedulerKt$scheduleTask$task$1.label;
        if (i != 0) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit scheduleTask$task$lambda$1(Runnable runnable) {
        runnable.run();
        return Unit.INSTANCE;
    }
}
