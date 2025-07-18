package okhttp3.internal.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt;
/* compiled from: TaskQueue.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u00014B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00132\b\b\u0002\u0010%\u001a\u00020&J&\u0010\"\u001a\u00020#2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0(J0\u0010)\u001a\u00020#2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010*\u001a\u00020\r2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020#0(J\u0006\u0010+\u001a\u00020,J%\u0010-\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&2\u0006\u0010.\u001a\u00020\rH\u0000¢\u0006\u0002\b/J\u0006\u00100\u001a\u00020#J\u0006\u0010\f\u001a\u00020#J\r\u00101\u001a\u00020\rH\u0000¢\u0006\u0002\b2J\b\u00103\u001a\u00020\u0005H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130 8F¢\u0006\u0006\u001a\u0004\b!\u0010\u001b¨\u00065"}, d2 = {"Lokhttp3/internal/concurrent/TaskQueue;", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "name", "", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;Ljava/lang/String;)V", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "getName$okhttp", "()Ljava/lang/String;", "shutdown", "", "getShutdown$okhttp", "()Z", "setShutdown$okhttp", "(Z)V", "activeTask", "Lokhttp3/internal/concurrent/Task;", "getActiveTask$okhttp", "()Lokhttp3/internal/concurrent/Task;", "setActiveTask$okhttp", "(Lokhttp3/internal/concurrent/Task;)V", "futureTasks", "", "getFutureTasks$okhttp", "()Ljava/util/List;", "cancelActiveTask", "getCancelActiveTask$okhttp", "setCancelActiveTask$okhttp", "scheduledTasks", "", "getScheduledTasks", "schedule", "", "task", "delayNanos", "", "block", "Lkotlin/Function0;", "execute", "cancelable", "idleLatch", "Ljava/util/concurrent/CountDownLatch;", "scheduleAndDecide", "recurrence", "scheduleAndDecide$okhttp", "cancelAll", "cancelAllAndDecide", "cancelAllAndDecide$okhttp", "toString", "AwaitIdleTask", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TaskQueue {
    private Task activeTask;
    private boolean cancelActiveTask;
    private final List<Task> futureTasks;
    private final String name;
    private boolean shutdown;
    private final TaskRunner taskRunner;

    public TaskQueue(TaskRunner taskRunner, String name) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(name, "name");
        this.taskRunner = taskRunner;
        this.name = name;
        this.futureTasks = new ArrayList();
    }

    public final TaskRunner getTaskRunner$okhttp() {
        return this.taskRunner;
    }

    public final String getName$okhttp() {
        return this.name;
    }

    public final boolean getShutdown$okhttp() {
        return this.shutdown;
    }

    public final void setShutdown$okhttp(boolean z) {
        this.shutdown = z;
    }

    public final Task getActiveTask$okhttp() {
        return this.activeTask;
    }

    public final void setActiveTask$okhttp(Task task) {
        this.activeTask = task;
    }

    public final List<Task> getFutureTasks$okhttp() {
        return this.futureTasks;
    }

    public final boolean getCancelActiveTask$okhttp() {
        return this.cancelActiveTask;
    }

    public final void setCancelActiveTask$okhttp(boolean z) {
        this.cancelActiveTask = z;
    }

    public final List<Task> getScheduledTasks() {
        List<Task> list;
        synchronized (this.taskRunner) {
            list = CollectionsKt.toList(this.futureTasks);
        }
        return list;
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, Task task, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        taskQueue.schedule(task, j);
    }

    public final void schedule(Task task, long j) {
        Intrinsics.checkNotNullParameter(task, "task");
        synchronized (this.taskRunner) {
            if (this.shutdown) {
                if (task.getCancelable()) {
                    Logger logger$okhttp = this.taskRunner.getLogger$okhttp();
                    if (logger$okhttp.isLoggable(Level.FINE)) {
                        TaskLoggerKt.log(logger$okhttp, task, this, "schedule canceled (queue is shutdown)");
                    }
                    return;
                }
                Logger logger$okhttp2 = this.taskRunner.getLogger$okhttp();
                if (logger$okhttp2.isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(logger$okhttp2, task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
            if (scheduleAndDecide$okhttp(task, j, false)) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, String str, long j, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        taskQueue.schedule(str, j, function0);
    }

    public final void schedule(final String name, long j, final Function0<Long> block) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(block, "block");
        schedule(new Task(name) { // from class: okhttp3.internal.concurrent.TaskQueue$schedule$2
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                return block.invoke().longValue();
            }
        }, j);
    }

    public static /* synthetic */ void execute$default(TaskQueue taskQueue, String str, long j, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            z = true;
        }
        taskQueue.execute(str, j2, z, function0);
    }

    public final void execute(final String name, long j, final boolean z, final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(block, "block");
        schedule(new Task(name, z) { // from class: okhttp3.internal.concurrent.TaskQueue$execute$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                block.invoke();
                return -1L;
            }
        }, j);
    }

    public final CountDownLatch idleLatch() {
        synchronized (this.taskRunner) {
            if (this.activeTask == null && this.futureTasks.isEmpty()) {
                return new CountDownLatch(0);
            }
            Task task = this.activeTask;
            if (task instanceof AwaitIdleTask) {
                return ((AwaitIdleTask) task).getLatch();
            }
            for (Task task2 : this.futureTasks) {
                if (task2 instanceof AwaitIdleTask) {
                    return ((AwaitIdleTask) task2).getLatch();
                }
            }
            AwaitIdleTask awaitIdleTask = new AwaitIdleTask();
            if (scheduleAndDecide$okhttp(awaitIdleTask, 0L, false)) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
            return awaitIdleTask.getLatch();
        }
    }

    /* compiled from: TaskQueue.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lokhttp3/internal/concurrent/TaskQueue$AwaitIdleTask;", "Lokhttp3/internal/concurrent/Task;", "<init>", "()V", "latch", "Ljava/util/concurrent/CountDownLatch;", "getLatch", "()Ljava/util/concurrent/CountDownLatch;", "runOnce", "", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class AwaitIdleTask extends Task {
        private final CountDownLatch latch;

        public AwaitIdleTask() {
            super(_UtilJvmKt.okHttpName + " awaitIdle", false);
            this.latch = new CountDownLatch(1);
        }

        public final CountDownLatch getLatch() {
            return this.latch;
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            this.latch.countDown();
            return -1L;
        }
    }

    public final boolean scheduleAndDecide$okhttp(Task task, long j, boolean z) {
        String str;
        Intrinsics.checkNotNullParameter(task, "task");
        task.initQueue$okhttp(this);
        long nanoTime = this.taskRunner.getBackend().nanoTime();
        long j2 = nanoTime + j;
        int indexOf = this.futureTasks.indexOf(task);
        if (indexOf != -1) {
            if (task.getNextExecuteNanoTime$okhttp() <= j2) {
                Logger logger$okhttp = this.taskRunner.getLogger$okhttp();
                if (logger$okhttp.isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(logger$okhttp, task, this, "already scheduled");
                }
                return false;
            }
            this.futureTasks.remove(indexOf);
        }
        task.setNextExecuteNanoTime$okhttp(j2);
        Logger logger$okhttp2 = this.taskRunner.getLogger$okhttp();
        if (logger$okhttp2.isLoggable(Level.FINE)) {
            if (z) {
                str = "run again after " + TaskLoggerKt.formatDuration(j2 - nanoTime);
            } else {
                str = "scheduled after " + TaskLoggerKt.formatDuration(j2 - nanoTime);
            }
            TaskLoggerKt.log(logger$okhttp2, task, this, str);
        }
        Iterator<Task> it = this.futureTasks.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (it.next().getNextExecuteNanoTime$okhttp() - nanoTime > j) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            i = this.futureTasks.size();
        }
        this.futureTasks.add(i, task);
        return i == 0;
    }

    public final void cancelAll() {
        TaskRunner taskRunner = this.taskRunner;
        if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock(taskRunner)) {
            synchronized (this.taskRunner) {
                if (cancelAllAndDecide$okhttp()) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
                Unit unit = Unit.INSTANCE;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + taskRunner);
    }

    public final void shutdown() {
        TaskRunner taskRunner = this.taskRunner;
        if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock(taskRunner)) {
            synchronized (this.taskRunner) {
                this.shutdown = true;
                if (cancelAllAndDecide$okhttp()) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
                Unit unit = Unit.INSTANCE;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + taskRunner);
    }

    public final boolean cancelAllAndDecide$okhttp() {
        Task task = this.activeTask;
        if (task != null) {
            Intrinsics.checkNotNull(task);
            if (task.getCancelable()) {
                this.cancelActiveTask = true;
            }
        }
        boolean z = false;
        for (int size = this.futureTasks.size() - 1; -1 < size; size--) {
            if (this.futureTasks.get(size).getCancelable()) {
                Logger logger$okhttp = this.taskRunner.getLogger$okhttp();
                Task task2 = this.futureTasks.get(size);
                if (logger$okhttp.isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(logger$okhttp, task2, this, "canceled");
                }
                this.futureTasks.remove(size);
                z = true;
            }
        }
        return z;
    }

    public String toString() {
        return this.name;
    }
}
