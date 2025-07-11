package okhttp3.internal.connection;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RoutePlanner;
/* compiled from: FastFallbackExchangeFinder.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0002J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lokhttp3/internal/connection/FastFallbackExchangeFinder;", "Lokhttp3/internal/connection/ExchangeFinder;", "routePlanner", "Lokhttp3/internal/connection/RoutePlanner;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "<init>", "(Lokhttp3/internal/connection/RoutePlanner;Lokhttp3/internal/concurrent/TaskRunner;)V", "getRoutePlanner", "()Lokhttp3/internal/connection/RoutePlanner;", "connectDelayNanos", "", "nextTcpConnectAtNanos", "tcpConnectsInFlight", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lokhttp3/internal/connection/RoutePlanner$Plan;", "connectResults", "Ljava/util/concurrent/BlockingQueue;", "Lokhttp3/internal/connection/RoutePlanner$ConnectResult;", "kotlin.jvm.PlatformType", "find", "Lokhttp3/internal/connection/RealConnection;", "launchTcpConnect", "awaitTcpConnect", "timeout", "unit", "Ljava/util/concurrent/TimeUnit;", "cancelInFlightConnects", "", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FastFallbackExchangeFinder implements ExchangeFinder {
    private final long connectDelayNanos;
    private final BlockingQueue<RoutePlanner.ConnectResult> connectResults;
    private long nextTcpConnectAtNanos;
    private final RoutePlanner routePlanner;
    private final TaskRunner taskRunner;
    private final CopyOnWriteArrayList<RoutePlanner.Plan> tcpConnectsInFlight;

    public FastFallbackExchangeFinder(RoutePlanner routePlanner, TaskRunner taskRunner) {
        Intrinsics.checkNotNullParameter(routePlanner, "routePlanner");
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        this.routePlanner = routePlanner;
        this.taskRunner = taskRunner;
        this.connectDelayNanos = TimeUnit.MILLISECONDS.toNanos(250L);
        this.nextTcpConnectAtNanos = Long.MIN_VALUE;
        this.tcpConnectsInFlight = new CopyOnWriteArrayList<>();
        this.connectResults = taskRunner.getBackend().decorate(new LinkedBlockingDeque());
    }

    @Override // okhttp3.internal.connection.ExchangeFinder
    public RoutePlanner getRoutePlanner() {
        return this.routePlanner;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0062 A[Catch: all -> 0x00bd, TryCatch #0 {all -> 0x00bd, blocks: (B:3:0x0002, B:5:0x000c, B:10:0x001f, B:12:0x0029, B:20:0x0053, B:23:0x005c, B:25:0x0062, B:27:0x006f, B:28:0x0078, B:30:0x007e, B:33:0x008a, B:35:0x0090, B:38:0x0096, B:39:0x009a, B:40:0x00a1, B:41:0x00a2, B:43:0x00a8, B:18:0x0048, B:44:0x00b5, B:45:0x00bc), top: B:49:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0090 A[Catch: all -> 0x00bd, TryCatch #0 {all -> 0x00bd, blocks: (B:3:0x0002, B:5:0x000c, B:10:0x001f, B:12:0x0029, B:20:0x0053, B:23:0x005c, B:25:0x0062, B:27:0x006f, B:28:0x0078, B:30:0x007e, B:33:0x008a, B:35:0x0090, B:38:0x0096, B:39:0x009a, B:40:0x00a1, B:41:0x00a2, B:43:0x00a8, B:18:0x0048, B:44:0x00b5, B:45:0x00bc), top: B:49:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0002 A[SYNTHETIC] */
    @Override // okhttp3.internal.connection.ExchangeFinder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RealConnection find() {
        RoutePlanner.ConnectResult launchTcpConnect;
        long j;
        Throwable throwable;
        RoutePlanner.Plan nextPlan;
        IOException iOException = null;
        while (true) {
            try {
                if (!this.tcpConnectsInFlight.isEmpty() || RoutePlanner.hasNext$default(getRoutePlanner(), null, 1, null)) {
                    if (getRoutePlanner().isCanceled()) {
                        throw new IOException("Canceled");
                    }
                    long nanoTime = this.taskRunner.getBackend().nanoTime();
                    long j2 = this.nextTcpConnectAtNanos - nanoTime;
                    if (!this.tcpConnectsInFlight.isEmpty() && j2 > 0) {
                        j = j2;
                        launchTcpConnect = null;
                        if (launchTcpConnect == null || (launchTcpConnect = awaitTcpConnect(j, TimeUnit.NANOSECONDS)) != null) {
                            if (launchTcpConnect.isSuccess()) {
                                cancelInFlightConnects();
                                if (!launchTcpConnect.getPlan().isReady()) {
                                    launchTcpConnect = launchTcpConnect.getPlan().mo10378connectTlsEtc();
                                }
                                if (launchTcpConnect.isSuccess()) {
                                    return launchTcpConnect.getPlan().mo10374handleSuccess();
                                }
                            }
                            throwable = launchTcpConnect.getThrowable();
                            if (throwable != null) {
                                if (!(throwable instanceof IOException)) {
                                    throw throwable;
                                }
                                if (iOException == null) {
                                    iOException = (IOException) throwable;
                                } else {
                                    ExceptionsKt.addSuppressed(iOException, throwable);
                                }
                            }
                            nextPlan = launchTcpConnect.getNextPlan();
                            if (nextPlan == null) {
                                getRoutePlanner().getDeferredPlans().addFirst(nextPlan);
                            }
                        }
                    }
                    launchTcpConnect = launchTcpConnect();
                    j = this.connectDelayNanos;
                    this.nextTcpConnectAtNanos = nanoTime + j;
                    if (launchTcpConnect == null) {
                    }
                    if (launchTcpConnect.isSuccess()) {
                    }
                    throwable = launchTcpConnect.getThrowable();
                    if (throwable != null) {
                    }
                    nextPlan = launchTcpConnect.getNextPlan();
                    if (nextPlan == null) {
                    }
                } else {
                    cancelInFlightConnects();
                    Intrinsics.checkNotNull(iOException);
                    throw iOException;
                }
            } finally {
                cancelInFlightConnects();
            }
        }
    }

    private final RoutePlanner.ConnectResult launchTcpConnect() {
        FailedPlan failedPlan;
        if (RoutePlanner.hasNext$default(getRoutePlanner(), null, 1, null)) {
            try {
                failedPlan = getRoutePlanner().plan();
            } catch (Throwable th) {
                failedPlan = new FailedPlan(th);
            }
            final RoutePlanner.Plan plan = failedPlan;
            if (plan.isReady()) {
                return new RoutePlanner.ConnectResult(plan, null, null, 6, null);
            }
            if (plan instanceof FailedPlan) {
                return ((FailedPlan) plan).getResult();
            }
            this.tcpConnectsInFlight.add(plan);
            final String str = _UtilJvmKt.okHttpName + " connect " + getRoutePlanner().getAddress().url().redact();
            TaskQueue.schedule$default(this.taskRunner.newQueue(), new Task(str) { // from class: okhttp3.internal.connection.FastFallbackExchangeFinder$launchTcpConnect$1
                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    RoutePlanner.ConnectResult connectResult;
                    CopyOnWriteArrayList copyOnWriteArrayList;
                    BlockingQueue blockingQueue;
                    try {
                        connectResult = plan.mo10377connectTcp();
                    } catch (Throwable th2) {
                        connectResult = new RoutePlanner.ConnectResult(plan, null, th2, 2, null);
                    }
                    copyOnWriteArrayList = this.tcpConnectsInFlight;
                    if (copyOnWriteArrayList.contains(plan)) {
                        blockingQueue = this.connectResults;
                        blockingQueue.put(connectResult);
                        return -1L;
                    }
                    return -1L;
                }
            }, 0L, 2, null);
        }
        return null;
    }

    private final RoutePlanner.ConnectResult awaitTcpConnect(long j, TimeUnit timeUnit) {
        RoutePlanner.ConnectResult poll;
        if (this.tcpConnectsInFlight.isEmpty() || (poll = this.connectResults.poll(j, timeUnit)) == null) {
            return null;
        }
        this.tcpConnectsInFlight.remove(poll.getPlan());
        return poll;
    }

    private final void cancelInFlightConnects() {
        Iterator<RoutePlanner.Plan> it = this.tcpConnectsInFlight.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            RoutePlanner.Plan next = it.next();
            next.mo10373cancel();
            RoutePlanner.Plan mo10375retry = next.mo10375retry();
            if (mo10375retry != null) {
                getRoutePlanner().getDeferredPlans().addLast(mo10375retry);
            }
        }
        this.tcpConnectsInFlight.clear();
    }
}
