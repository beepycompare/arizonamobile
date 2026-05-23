package kotlinx.coroutines.rx2;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RxScheduler.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* synthetic */ class RxSchedulerKt$scheduleTask$toSchedule$1 extends FunctionReferenceImpl implements Function1<Continuation<? super Unit>, Object>, SuspendFunction {
    final /* synthetic */ CoroutineContext $ctx;
    final /* synthetic */ Runnable $decoratedBlock;
    final /* synthetic */ AtomicReference<Object> $disposableRef;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxSchedulerKt$scheduleTask$toSchedule$1(AtomicReference<Object> atomicReference, CoroutineContext coroutineContext, Runnable runnable) {
        super(1, Intrinsics.Kotlin.class, "task", "scheduleTask$task(Ljava/util/concurrent/atomic/AtomicReference;Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        this.$disposableRef = atomicReference;
        this.$ctx = coroutineContext;
        this.$decoratedBlock = runnable;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        Object scheduleTask$task;
        scheduleTask$task = RxSchedulerKt.scheduleTask$task(this.$disposableRef, this.$ctx, this.$decoratedBlock, continuation);
        return scheduleTask$task;
    }
}
