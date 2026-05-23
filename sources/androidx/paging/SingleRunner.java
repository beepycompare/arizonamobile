package androidx.paging;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
/* compiled from: SingleRunner.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0003\u0010\u0011\u0012B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J6\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rH\u0086@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/paging/SingleRunner;", "", "cancelPreviousInEqualPriority", "", "<init>", "(Z)V", "holder", "Landroidx/paging/SingleRunner$Holder;", "runInIsolation", "", "priority", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CancelIsolatedRunnerException", "Holder", "Companion", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SingleRunner {
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_PRIORITY = 0;
    private final Holder holder;

    public SingleRunner() {
        this(false, 1, null);
    }

    public SingleRunner(boolean z) {
        this.holder = new Holder(this, z);
    }

    public /* synthetic */ SingleRunner(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }

    public static /* synthetic */ Object runInIsolation$default(SingleRunner singleRunner, int i, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return singleRunner.runInIsolation(i, function1, continuation);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(1:10)(2:16|17))(3:18|19|(1:21))|11|12|13))|26|6|7|(0)(0)|11|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004c, code lost:
        if (r5.getRunner() != r4) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0051, code lost:
        throw r5;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Type inference failed for: r4v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object runInIsolation(int i, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        SingleRunner$runInIsolation$1 singleRunner$runInIsolation$1;
        int i2;
        if (continuation instanceof SingleRunner$runInIsolation$1) {
            singleRunner$runInIsolation$1 = (SingleRunner$runInIsolation$1) continuation;
            if ((singleRunner$runInIsolation$1.label & Integer.MIN_VALUE) != 0) {
                singleRunner$runInIsolation$1.label -= Integer.MIN_VALUE;
                Object obj = singleRunner$runInIsolation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = singleRunner$runInIsolation$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    singleRunner$runInIsolation$1.label = 1;
                    Object coroutineScope = CoroutineScopeKt.coroutineScope(new SingleRunner$runInIsolation$2(this, i, function1, null), singleRunner$runInIsolation$1);
                    this = coroutineScope;
                    if (coroutineScope == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                    this = this;
                }
                return Unit.INSTANCE;
            }
        }
        singleRunner$runInIsolation$1 = new SingleRunner$runInIsolation$1(this, continuation);
        Object obj2 = singleRunner$runInIsolation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = singleRunner$runInIsolation$1.label;
        if (i2 != 0) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SingleRunner.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/paging/SingleRunner$CancelIsolatedRunnerException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "runner", "Landroidx/paging/SingleRunner;", "<init>", "(Landroidx/paging/SingleRunner;)V", "getRunner", "()Landroidx/paging/SingleRunner;", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class CancelIsolatedRunnerException extends CancellationException {
        private final SingleRunner runner;

        public final SingleRunner getRunner() {
            return this.runner;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CancelIsolatedRunnerException(SingleRunner runner) {
            super("Cancelled isolated runner");
            Intrinsics.checkNotNullParameter(runner, "runner");
            this.runner = runner;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SingleRunner.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/paging/SingleRunner$Holder;", "", "singleRunner", "Landroidx/paging/SingleRunner;", "cancelPreviousInEqualPriority", "", "<init>", "(Landroidx/paging/SingleRunner;Z)V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "previous", "Lkotlinx/coroutines/Job;", "previousPriority", "", "tryEnqueue", "priority", "job", "(ILkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onFinish", "", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Holder {
        private final boolean cancelPreviousInEqualPriority;
        private final Mutex mutex;
        private Job previous;
        private int previousPriority;
        private final SingleRunner singleRunner;

        public Holder(SingleRunner singleRunner, boolean z) {
            Intrinsics.checkNotNullParameter(singleRunner, "singleRunner");
            this.singleRunner = singleRunner;
            this.cancelPreviousInEqualPriority = z;
            this.mutex = MutexKt.Mutex$default(false, 1, null);
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x0081, code lost:
            r11.cancel((java.util.concurrent.CancellationException) new androidx.paging.SingleRunner.CancelIsolatedRunnerException(r8.singleRunner));
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x008f A[Catch: all -> 0x0039, TryCatch #0 {all -> 0x0039, blocks: (B:13:0x0034, B:43:0x00a0, B:44:0x00a4, B:24:0x0068, B:26:0x006c, B:28:0x0072, B:31:0x0078, B:36:0x0081, B:38:0x008f), top: B:49:0x0024 }] */
        /* JADX WARN: Type inference failed for: r10v0, types: [kotlinx.coroutines.Job, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r10v1, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r10v13 */
        /* JADX WARN: Type inference failed for: r10v14 */
        /* JADX WARN: Type inference failed for: r10v4, types: [kotlinx.coroutines.sync.Mutex] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object tryEnqueue(int i, Job job, Continuation<? super Boolean> continuation) {
            SingleRunner$Holder$tryEnqueue$1 singleRunner$Holder$tryEnqueue$1;
            int i2;
            boolean z;
            Job job2;
            Mutex mutex;
            Job job3;
            Job job4;
            int i3;
            try {
                if (continuation instanceof SingleRunner$Holder$tryEnqueue$1) {
                    singleRunner$Holder$tryEnqueue$1 = (SingleRunner$Holder$tryEnqueue$1) continuation;
                    if ((singleRunner$Holder$tryEnqueue$1.label & Integer.MIN_VALUE) != 0) {
                        singleRunner$Holder$tryEnqueue$1.label -= Integer.MIN_VALUE;
                        Object obj = singleRunner$Holder$tryEnqueue$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i2 = singleRunner$Holder$tryEnqueue$1.label;
                        z = true;
                        if (i2 != 0) {
                            ResultKt.throwOnFailure(obj);
                            Mutex mutex2 = this.mutex;
                            singleRunner$Holder$tryEnqueue$1.L$0 = job;
                            singleRunner$Holder$tryEnqueue$1.L$1 = mutex2;
                            singleRunner$Holder$tryEnqueue$1.I$0 = i;
                            singleRunner$Holder$tryEnqueue$1.label = 1;
                            if (mutex2.lock(null, singleRunner$Holder$tryEnqueue$1) != coroutine_suspended) {
                                job2 = job;
                                mutex = mutex2;
                            }
                            return coroutine_suspended;
                        } else if (i2 != 1) {
                            if (i2 == 2) {
                                i = singleRunner$Holder$tryEnqueue$1.I$0;
                                Mutex mutex3 = (Mutex) singleRunner$Holder$tryEnqueue$1.L$1;
                                job4 = (Job) singleRunner$Holder$tryEnqueue$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                mutex = mutex3;
                                job2 = job4;
                                this.previous = job2;
                                this.previousPriority = i;
                                job = mutex;
                                return Boxing.boxBoolean(z);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            i = singleRunner$Holder$tryEnqueue$1.I$0;
                            mutex = (Mutex) singleRunner$Holder$tryEnqueue$1.L$1;
                            job2 = (Job) singleRunner$Holder$tryEnqueue$1.L$0;
                            ResultKt.throwOnFailure(obj);
                        }
                        job3 = this.previous;
                        if (job3 != null && job3.isActive() && (i3 = this.previousPriority) >= i && (i3 != i || !this.cancelPreviousInEqualPriority)) {
                            z = false;
                            job = mutex;
                            return Boxing.boxBoolean(z);
                        }
                        if (job3 != null) {
                            singleRunner$Holder$tryEnqueue$1.L$0 = job2;
                            singleRunner$Holder$tryEnqueue$1.L$1 = mutex;
                            singleRunner$Holder$tryEnqueue$1.I$0 = i;
                            singleRunner$Holder$tryEnqueue$1.label = 2;
                            if (job3.join(singleRunner$Holder$tryEnqueue$1) != coroutine_suspended) {
                                job4 = job2;
                                mutex = mutex;
                                job2 = job4;
                            }
                            return coroutine_suspended;
                        }
                        this.previous = job2;
                        this.previousPriority = i;
                        job = mutex;
                        return Boxing.boxBoolean(z);
                    }
                }
                if (i2 != 0) {
                }
                job3 = this.previous;
                if (job3 != null) {
                    z = false;
                    job = mutex;
                    return Boxing.boxBoolean(z);
                }
                if (job3 != null) {
                }
                this.previous = job2;
                this.previousPriority = i;
                job = mutex;
                return Boxing.boxBoolean(z);
            } finally {
                job.unlock(null);
            }
            singleRunner$Holder$tryEnqueue$1 = new SingleRunner$Holder$tryEnqueue$1(this, continuation);
            Object obj2 = singleRunner$Holder$tryEnqueue$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i2 = singleRunner$Holder$tryEnqueue$1.label;
            z = true;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0053 A[Catch: all -> 0x005d, TryCatch #0 {all -> 0x005d, blocks: (B:17:0x004f, B:19:0x0053, B:20:0x0055), top: B:26:0x004f }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object onFinish(Job job, Continuation<? super Unit> continuation) {
            SingleRunner$Holder$onFinish$1 singleRunner$Holder$onFinish$1;
            int i;
            Mutex mutex;
            try {
                if (continuation instanceof SingleRunner$Holder$onFinish$1) {
                    singleRunner$Holder$onFinish$1 = (SingleRunner$Holder$onFinish$1) continuation;
                    if ((singleRunner$Holder$onFinish$1.label & Integer.MIN_VALUE) != 0) {
                        singleRunner$Holder$onFinish$1.label -= Integer.MIN_VALUE;
                        Object obj = singleRunner$Holder$onFinish$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = singleRunner$Holder$onFinish$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            mutex = this.mutex;
                            singleRunner$Holder$onFinish$1.L$0 = job;
                            singleRunner$Holder$onFinish$1.L$1 = mutex;
                            singleRunner$Holder$onFinish$1.label = 1;
                            if (mutex.lock(null, singleRunner$Holder$onFinish$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            ResultKt.throwOnFailure(obj);
                            mutex = (Mutex) singleRunner$Holder$onFinish$1.L$1;
                            job = (Job) singleRunner$Holder$onFinish$1.L$0;
                        }
                        if (job == this.previous) {
                            this.previous = null;
                        }
                        Unit unit = Unit.INSTANCE;
                        mutex.unlock(null);
                        return Unit.INSTANCE;
                    }
                }
                if (job == this.previous) {
                }
                Unit unit2 = Unit.INSTANCE;
                mutex.unlock(null);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
            singleRunner$Holder$onFinish$1 = new SingleRunner$Holder$onFinish$1(this, continuation);
            Object obj2 = singleRunner$Holder$onFinish$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = singleRunner$Holder$onFinish$1.label;
            if (i != 0) {
            }
        }
    }

    /* compiled from: SingleRunner.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/paging/SingleRunner$Companion;", "", "<init>", "()V", "DEFAULT_PRIORITY", "", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
