package kotlinx.coroutines.rx2;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.rx2.DispatcherScheduler;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RxScheduler.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\t\u0010\n\u001a\u00020\u000bX\u0082\u0004¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/rx2/DispatcherScheduler;", "Lio/reactivex/Scheduler;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "schedulerJob", "Lkotlinx/coroutines/CompletableJob;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "workerCounter", "Lkotlinx/atomicfu/AtomicLong;", "scheduleDirect", "Lio/reactivex/disposables/Disposable;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "delay", "", "unit", "Ljava/util/concurrent/TimeUnit;", "createWorker", "Lio/reactivex/Scheduler$Worker;", "shutdown", "", "toString", "", "DispatcherWorker", "kotlinx-coroutines-rx2"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DispatcherScheduler extends Scheduler {
    private static final /* synthetic */ AtomicLongFieldUpdater workerCounter$volatile$FU = AtomicLongFieldUpdater.newUpdater(DispatcherScheduler.class, "workerCounter$volatile");
    public final CoroutineDispatcher dispatcher;
    private final CompletableJob schedulerJob;
    private final CoroutineScope scope;
    private volatile /* synthetic */ long workerCounter$volatile;

    private final /* synthetic */ long getWorkerCounter$volatile() {
        return this.workerCounter$volatile;
    }

    private final /* synthetic */ void setWorkerCounter$volatile(long j) {
        this.workerCounter$volatile = j;
    }

    public DispatcherScheduler(CoroutineDispatcher coroutineDispatcher) {
        this.dispatcher = coroutineDispatcher;
        CompletableJob SupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.schedulerJob = SupervisorJob$default;
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorJob$default.plus(coroutineDispatcher));
        this.workerCounter$volatile = 1L;
    }

    @Override // io.reactivex.Scheduler
    public Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        Disposable scheduleTask;
        scheduleTask = RxSchedulerKt.scheduleTask(this.scope, runnable, timeUnit.toMillis(j), new Function1() { // from class: kotlinx.coroutines.rx2.DispatcherScheduler$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DispatcherScheduler.scheduleDirect$lambda$0(DispatcherScheduler.this, (Function1) obj);
            }
        });
        return scheduleTask;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Runnable scheduleDirect$lambda$0(final DispatcherScheduler dispatcherScheduler, final Function1 function1) {
        return new Runnable() { // from class: kotlinx.coroutines.rx2.DispatcherScheduler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DispatcherScheduler.scheduleDirect$lambda$0$0(DispatcherScheduler.this, function1);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleDirect$lambda$0$0(DispatcherScheduler dispatcherScheduler, Function1 function1) {
        BuildersKt__Builders_commonKt.launch$default(dispatcherScheduler.scope, null, null, new DispatcherScheduler$scheduleDirect$1$1$1(function1, null), 3, null);
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker createWorker() {
        return new DispatcherWorker(workerCounter$volatile$FU.getAndIncrement(this), this.dispatcher, this.schedulerJob);
    }

    @Override // io.reactivex.Scheduler
    public void shutdown() {
        Job.cancel$default((Job) this.schedulerJob, (CancellationException) null, 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RxScheduler.kt */
    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ$\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lkotlinx/coroutines/rx2/DispatcherScheduler$DispatcherWorker;", "Lio/reactivex/Scheduler$Worker;", "counter", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "parentJob", "Lkotlinx/coroutines/Job;", "<init>", "(JLkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/Job;)V", "workerJob", "Lkotlinx/coroutines/CompletableJob;", "workerScope", "Lkotlinx/coroutines/CoroutineScope;", "blockChannel", "Lkotlinx/coroutines/channels/Channel;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "schedule", "Lio/reactivex/disposables/Disposable;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "delay", "unit", "Ljava/util/concurrent/TimeUnit;", "isDisposed", "", "dispose", "toString", "", "kotlinx-coroutines-rx2"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DispatcherWorker extends Scheduler.Worker {
        private final Channel<Function1<Continuation<? super Unit>, Object>> blockChannel;
        private final long counter;
        private final CoroutineDispatcher dispatcher;
        private final CompletableJob workerJob;
        private final CoroutineScope workerScope;

        public DispatcherWorker(long j, CoroutineDispatcher coroutineDispatcher, Job job) {
            this.counter = j;
            this.dispatcher = coroutineDispatcher;
            CompletableJob SupervisorJob = SupervisorKt.SupervisorJob(job);
            this.workerJob = SupervisorJob;
            CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorJob.plus(coroutineDispatcher));
            this.workerScope = CoroutineScope;
            this.blockChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
        }

        /* compiled from: RxScheduler.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "kotlinx.coroutines.rx2.DispatcherScheduler$DispatcherWorker$1", f = "RxScheduler.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {223, 80}, m = "invokeSuspend", n = {"$this$consumeEach$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv", "$this$consumeEach$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "e$iv", "it", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv", "$i$a$-consumeEach-DispatcherScheduler$DispatcherWorker$1$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1", "I$2", "I$3"}, v = 1)
        /* renamed from: kotlinx.coroutines.rx2.DispatcherScheduler$DispatcherWorker$1  reason: invalid class name */
        /* loaded from: classes5.dex */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:20:0x0098  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x00aa A[Catch: all -> 0x00f6, TryCatch #1 {all -> 0x00f6, blocks: (B:7:0x002c, B:21:0x00a2, B:23:0x00aa, B:28:0x00ea, B:12:0x0058, B:15:0x006b), top: B:41:0x000c }] */
            /* JADX WARN: Removed duplicated region for block: B:28:0x00ea A[Catch: all -> 0x00f6, TRY_LEAVE, TryCatch #1 {all -> 0x00f6, blocks: (B:7:0x002c, B:21:0x00a2, B:23:0x00aa, B:28:0x00ea, B:12:0x0058, B:15:0x006b), top: B:41:0x000c }] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00de -> B:27:0x00e8). Please submit an issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                Throwable th;
                ReceiveChannel receiveChannel;
                Channel channel;
                ChannelIterator it;
                int i;
                int i2;
                int i3;
                Throwable th2;
                ReceiveChannel receiveChannel2;
                ReceiveChannel receiveChannel3;
                Object obj2;
                ReceiveChannel receiveChannel4;
                ReceiveChannel receiveChannel5;
                ChannelIterator channelIterator;
                int i4;
                int i5;
                int i6;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i7 = this.label;
                int i8 = 1;
                try {
                    if (i7 == 0) {
                        ResultKt.throwOnFailure(obj);
                        channel = DispatcherWorker.this.blockChannel;
                        it = channel.iterator();
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                        th2 = null;
                        receiveChannel2 = channel;
                        receiveChannel3 = receiveChannel2;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(channel);
                        this.L$1 = receiveChannel2;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                        this.L$3 = it;
                        this.L$4 = null;
                        this.L$5 = null;
                        this.I$0 = i;
                        this.I$1 = i2;
                        this.I$2 = i3;
                        this.label = i8;
                        obj2 = it.hasNext(this);
                        if (obj2 != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    } else if (i7 != 1) {
                        if (i7 == 2) {
                            int i9 = this.I$2;
                            int i10 = this.I$1;
                            int i11 = this.I$0;
                            Function1 function1 = (Function1) this.L$5;
                            ChannelIterator channelIterator2 = (ChannelIterator) this.L$3;
                            ReceiveChannel receiveChannel6 = (ReceiveChannel) this.L$2;
                            ReceiveChannel receiveChannel7 = (ReceiveChannel) this.L$1;
                            ReceiveChannel receiveChannel8 = (ReceiveChannel) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            i3 = i9;
                            it = channelIterator2;
                            i = i11;
                            receiveChannel3 = receiveChannel6;
                            i2 = i10;
                            receiveChannel2 = receiveChannel7;
                            channel = receiveChannel8;
                            th2 = null;
                            i8 = 1;
                            try {
                                this.L$0 = SpillingKt.nullOutSpilledVariable(channel);
                                this.L$1 = receiveChannel2;
                                this.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                                this.L$3 = it;
                                this.L$4 = null;
                                this.L$5 = null;
                                this.I$0 = i;
                                this.I$1 = i2;
                                this.I$2 = i3;
                                this.label = i8;
                                obj2 = it.hasNext(this);
                                if (obj2 != coroutine_suspended) {
                                    int i12 = i;
                                    channelIterator = it;
                                    i6 = i3;
                                    receiveChannel4 = channel;
                                    receiveChannel = receiveChannel2;
                                    i5 = i2;
                                    receiveChannel5 = receiveChannel3;
                                    i4 = i12;
                                    if (!((Boolean) obj2).booleanValue()) {
                                        Object next = channelIterator.next();
                                        Function1 function12 = (Function1) next;
                                        this.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                                        this.L$1 = receiveChannel;
                                        this.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                                        this.L$3 = channelIterator;
                                        this.L$4 = SpillingKt.nullOutSpilledVariable(next);
                                        this.L$5 = SpillingKt.nullOutSpilledVariable(function12);
                                        this.I$0 = i4;
                                        this.I$1 = i5;
                                        this.I$2 = i6;
                                        this.I$3 = 0;
                                        this.label = 2;
                                        if (function12.invoke(this) != coroutine_suspended) {
                                            ReceiveChannel receiveChannel9 = receiveChannel4;
                                            i3 = i6;
                                            it = channelIterator;
                                            i = i4;
                                            receiveChannel3 = receiveChannel5;
                                            i2 = i5;
                                            receiveChannel2 = receiveChannel;
                                            channel = receiveChannel9;
                                            i8 = 1;
                                            this.L$0 = SpillingKt.nullOutSpilledVariable(channel);
                                            this.L$1 = receiveChannel2;
                                            this.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                                            this.L$3 = it;
                                            this.L$4 = null;
                                            this.L$5 = null;
                                            this.I$0 = i;
                                            this.I$1 = i2;
                                            this.I$2 = i3;
                                            this.label = i8;
                                            obj2 = it.hasNext(this);
                                            if (obj2 != coroutine_suspended) {
                                            }
                                        }
                                    } else {
                                        Unit unit = Unit.INSTANCE;
                                        ChannelsKt.cancelConsumed(receiveChannel, th2);
                                        return Unit.INSTANCE;
                                    }
                                }
                                return coroutine_suspended;
                            } catch (Throwable th3) {
                                th = th3;
                                receiveChannel = receiveChannel2;
                                try {
                                    throw th;
                                } catch (Throwable th4) {
                                    ChannelsKt.cancelConsumed(receiveChannel, th);
                                    throw th4;
                                }
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        i6 = this.I$2;
                        i5 = this.I$1;
                        i4 = this.I$0;
                        channelIterator = (ChannelIterator) this.L$3;
                        receiveChannel5 = (ReceiveChannel) this.L$2;
                        receiveChannel = (ReceiveChannel) this.L$1;
                        receiveChannel4 = (ReceiveChannel) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        obj2 = obj;
                        th2 = null;
                        if (!((Boolean) obj2).booleanValue()) {
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            }
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            Disposable scheduleTask;
            scheduleTask = RxSchedulerKt.scheduleTask(this.workerScope, runnable, timeUnit.toMillis(j), new Function1() { // from class: kotlinx.coroutines.rx2.DispatcherScheduler$DispatcherWorker$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DispatcherScheduler.DispatcherWorker.schedule$lambda$0(DispatcherScheduler.DispatcherWorker.this, (Function1) obj);
                }
            });
            return scheduleTask;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Runnable schedule$lambda$0(final DispatcherWorker dispatcherWorker, final Function1 function1) {
            return new Runnable() { // from class: kotlinx.coroutines.rx2.DispatcherScheduler$DispatcherWorker$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    DispatcherScheduler.DispatcherWorker.schedule$lambda$0$0(DispatcherScheduler.DispatcherWorker.this, function1);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void schedule$lambda$0$0(DispatcherWorker dispatcherWorker, Function1 function1) {
            dispatcherWorker.blockChannel.mo9005trySendJP2dKIU(function1);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return !CoroutineScopeKt.isActive(this.workerScope);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SendChannel.close$default(this.blockChannel, null, 1, null);
            Job.cancel$default((Job) this.workerJob, (CancellationException) null, 1, (Object) null);
        }

        public String toString() {
            return this.dispatcher + " (worker " + this.counter + ", " + (isDisposed() ? "disposed" : AppMeasurementSdk.ConditionalUserProperty.ACTIVE) + ')';
        }
    }

    public String toString() {
        return this.dispatcher.toString();
    }
}
