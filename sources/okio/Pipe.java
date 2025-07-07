package okio;

import com.facebook.widget.FacebookDialog;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Pipe.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010*\u001a\u00020+2\u0006\u0010&\u001a\u00020\u0019J&\u0010,\u001a\u00020+*\u00020\u00192\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020+0.¢\u0006\u0002\b/H\u0082\bJ\r\u0010&\u001a\u00020\u0019H\u0007¢\u0006\u0002\b0J\r\u0010'\u001a\u00020(H\u0007¢\u0006\u0002\b1J\u0006\u00102\u001a\u00020+R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010&\u001a\u00020\u00198G¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0013\u0010'\u001a\u00020(8G¢\u0006\b\n\u0000\u001a\u0004\b'\u0010)¨\u00063"}, d2 = {"Lokio/Pipe;", "", "maxBufferSize", "", "<init>", "(J)V", "getMaxBufferSize$okio", "()J", "buffer", "Lokio/Buffer;", "getBuffer$okio", "()Lokio/Buffer;", "canceled", "", "getCanceled$okio", "()Z", "setCanceled$okio", "(Z)V", "sinkClosed", "getSinkClosed$okio", "setSinkClosed$okio", "sourceClosed", "getSourceClosed$okio", "setSourceClosed$okio", "foldedSink", "Lokio/Sink;", "getFoldedSink$okio", "()Lokio/Sink;", "setFoldedSink$okio", "(Lokio/Sink;)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "condition", "Ljava/util/concurrent/locks/Condition;", "getCondition", "()Ljava/util/concurrent/locks/Condition;", "sink", "source", "Lokio/Source;", "()Lokio/Source;", "fold", "", "forward", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "-deprecated_sink", "-deprecated_source", FacebookDialog.COMPLETION_GESTURE_CANCEL, "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Pipe {
    private final Buffer buffer = new Buffer();
    private boolean canceled;
    private final Condition condition;
    private Sink foldedSink;
    private final ReentrantLock lock;
    private final long maxBufferSize;
    private final Sink sink;
    private boolean sinkClosed;
    private final Source source;
    private boolean sourceClosed;

    public Pipe(long j) {
        this.maxBufferSize = j;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        Condition newCondition = reentrantLock.newCondition();
        Intrinsics.checkNotNullExpressionValue(newCondition, "newCondition(...)");
        this.condition = newCondition;
        if (j < 1) {
            throw new IllegalArgumentException(("maxBufferSize < 1: " + j).toString());
        }
        this.sink = new Sink() { // from class: okio.Pipe$sink$1
            private final Timeout timeout = new Timeout();

            /* JADX WARN: Code restructure failed: missing block: B:26:0x0077, code lost:
                r1 = kotlin.Unit.INSTANCE;
             */
            /* JADX WARN: Code restructure failed: missing block: B:28:0x007c, code lost:
                if (r2 == null) goto L71;
             */
            /* JADX WARN: Code restructure failed: missing block: B:29:0x007e, code lost:
                r0 = r11.this$0;
                r1 = r2.timeout();
                r0 = r0.sink().timeout();
                r3 = r1.timeoutNanos();
                r1.timeout(okio.Timeout.Companion.minTimeout(r0.timeoutNanos(), r1.timeoutNanos()), java.util.concurrent.TimeUnit.NANOSECONDS);
             */
            /* JADX WARN: Code restructure failed: missing block: B:30:0x00a7, code lost:
                if (r1.hasDeadline() == false) goto L55;
             */
            /* JADX WARN: Code restructure failed: missing block: B:31:0x00a9, code lost:
                r5 = r1.deadlineNanoTime();
             */
            /* JADX WARN: Code restructure failed: missing block: B:32:0x00b1, code lost:
                if (r0.hasDeadline() == false) goto L42;
             */
            /* JADX WARN: Code restructure failed: missing block: B:33:0x00b3, code lost:
                r1.deadlineNanoTime(java.lang.Math.min(r1.deadlineNanoTime(), r0.deadlineNanoTime()));
             */
            /* JADX WARN: Code restructure failed: missing block: B:34:0x00c2, code lost:
                r2.write(r12, r13);
                r12 = kotlin.Unit.INSTANCE;
             */
            /* JADX WARN: Code restructure failed: missing block: B:38:0x00d5, code lost:
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:39:0x00d6, code lost:
                r12 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:40:0x00d7, code lost:
                r1.timeout(r3, java.util.concurrent.TimeUnit.NANOSECONDS);
             */
            /* JADX WARN: Code restructure failed: missing block: B:41:0x00e0, code lost:
                if (r0.hasDeadline() != false) goto L53;
             */
            /* JADX WARN: Code restructure failed: missing block: B:42:0x00e2, code lost:
                r1.deadlineNanoTime(r5);
             */
            /* JADX WARN: Code restructure failed: missing block: B:43:0x00e5, code lost:
                throw r12;
             */
            /* JADX WARN: Code restructure failed: missing block: B:45:0x00ea, code lost:
                if (r0.hasDeadline() == false) goto L58;
             */
            /* JADX WARN: Code restructure failed: missing block: B:46:0x00ec, code lost:
                r1.deadlineNanoTime(r0.deadlineNanoTime());
             */
            /* JADX WARN: Code restructure failed: missing block: B:47:0x00f3, code lost:
                r2.write(r12, r13);
                r12 = kotlin.Unit.INSTANCE;
             */
            /* JADX WARN: Code restructure failed: missing block: B:51:0x0106, code lost:
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:52:0x0107, code lost:
                r12 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:53:0x0108, code lost:
                r1.timeout(r3, java.util.concurrent.TimeUnit.NANOSECONDS);
             */
            /* JADX WARN: Code restructure failed: missing block: B:54:0x0111, code lost:
                if (r0.hasDeadline() != false) goto L69;
             */
            /* JADX WARN: Code restructure failed: missing block: B:55:0x0113, code lost:
                r1.clearDeadline();
             */
            /* JADX WARN: Code restructure failed: missing block: B:56:0x0116, code lost:
                throw r12;
             */
            /* JADX WARN: Code restructure failed: missing block: B:57:0x0117, code lost:
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:79:?, code lost:
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:80:?, code lost:
                return;
             */
            @Override // okio.Sink
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void write(Buffer source, long j2) {
                Sink sink;
                Intrinsics.checkNotNullParameter(source, "source");
                ReentrantLock lock = Pipe.this.getLock();
                Pipe pipe = Pipe.this;
                lock.lock();
                try {
                    if (pipe.getSinkClosed$okio()) {
                        throw new IllegalStateException("closed".toString());
                    }
                    if (!pipe.getCanceled$okio()) {
                        while (true) {
                            if (j2 <= 0) {
                                sink = null;
                                break;
                            }
                            sink = pipe.getFoldedSink$okio();
                            if (sink != null) {
                                break;
                            } else if (pipe.getSourceClosed$okio()) {
                                throw new IOException("source is closed");
                            } else {
                                long maxBufferSize$okio = pipe.getMaxBufferSize$okio() - pipe.getBuffer$okio().size();
                                if (maxBufferSize$okio == 0) {
                                    this.timeout.awaitSignal(pipe.getCondition());
                                    if (pipe.getCanceled$okio()) {
                                        throw new IOException("canceled");
                                    }
                                } else {
                                    long min = Math.min(maxBufferSize$okio, j2);
                                    pipe.getBuffer$okio().write(source, min);
                                    j2 -= min;
                                    pipe.getCondition().signalAll();
                                }
                            }
                        }
                    } else {
                        throw new IOException("canceled");
                    }
                } finally {
                    lock.unlock();
                }
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() {
                boolean hasDeadline;
                ReentrantLock lock = Pipe.this.getLock();
                Pipe pipe = Pipe.this;
                lock.lock();
                try {
                    if (pipe.getSinkClosed$okio()) {
                        throw new IllegalStateException("closed".toString());
                    }
                    if (pipe.getCanceled$okio()) {
                        throw new IOException("canceled");
                    }
                    Sink foldedSink$okio = pipe.getFoldedSink$okio();
                    if (foldedSink$okio == null) {
                        if (pipe.getSourceClosed$okio() && pipe.getBuffer$okio().size() > 0) {
                            throw new IOException("source is closed");
                        }
                        foldedSink$okio = null;
                    }
                    Unit unit = Unit.INSTANCE;
                    if (foldedSink$okio != null) {
                        Pipe pipe2 = Pipe.this;
                        Timeout timeout = foldedSink$okio.timeout();
                        Timeout timeout2 = pipe2.sink().timeout();
                        long timeoutNanos = timeout.timeoutNanos();
                        timeout.timeout(Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos()), TimeUnit.NANOSECONDS);
                        if (timeout.hasDeadline()) {
                            long deadlineNanoTime = timeout.deadlineNanoTime();
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                            }
                            try {
                                foldedSink$okio.flush();
                                Unit unit2 = Unit.INSTANCE;
                                if (hasDeadline) {
                                    return;
                                }
                                return;
                            } finally {
                                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.hasDeadline()) {
                                    timeout.deadlineNanoTime(deadlineNanoTime);
                                }
                            }
                        }
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                        }
                        try {
                            foldedSink$okio.flush();
                            Unit unit3 = Unit.INSTANCE;
                        } finally {
                            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout2.hasDeadline()) {
                                timeout.clearDeadline();
                            }
                        }
                    }
                } finally {
                    lock.unlock();
                }
            }

            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                boolean hasDeadline;
                ReentrantLock lock = Pipe.this.getLock();
                Pipe pipe = Pipe.this;
                lock.lock();
                try {
                    if (pipe.getSinkClosed$okio()) {
                        return;
                    }
                    Sink foldedSink$okio = pipe.getFoldedSink$okio();
                    if (foldedSink$okio == null) {
                        if (pipe.getSourceClosed$okio() && pipe.getBuffer$okio().size() > 0) {
                            throw new IOException("source is closed");
                        }
                        pipe.setSinkClosed$okio(true);
                        pipe.getCondition().signalAll();
                        foldedSink$okio = null;
                    }
                    Unit unit = Unit.INSTANCE;
                    if (foldedSink$okio != null) {
                        Pipe pipe2 = Pipe.this;
                        Timeout timeout = foldedSink$okio.timeout();
                        Timeout timeout2 = pipe2.sink().timeout();
                        long timeoutNanos = timeout.timeoutNanos();
                        timeout.timeout(Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos()), TimeUnit.NANOSECONDS);
                        if (timeout.hasDeadline()) {
                            long deadlineNanoTime = timeout.deadlineNanoTime();
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                            }
                            try {
                                foldedSink$okio.close();
                                Unit unit2 = Unit.INSTANCE;
                                if (hasDeadline) {
                                    return;
                                }
                                return;
                            } finally {
                                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.hasDeadline()) {
                                    timeout.deadlineNanoTime(deadlineNanoTime);
                                }
                            }
                        }
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                        }
                        try {
                            foldedSink$okio.close();
                            Unit unit3 = Unit.INSTANCE;
                        } finally {
                            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout2.hasDeadline()) {
                                timeout.clearDeadline();
                            }
                        }
                    }
                } finally {
                    lock.unlock();
                }
            }

            @Override // okio.Sink
            public Timeout timeout() {
                return this.timeout;
            }
        };
        this.source = new Source() { // from class: okio.Pipe$source$1
            private final Timeout timeout = new Timeout();

            @Override // okio.Source
            public long read(Buffer sink, long j2) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                ReentrantLock lock = Pipe.this.getLock();
                Pipe pipe = Pipe.this;
                lock.lock();
                try {
                    if (pipe.getSourceClosed$okio()) {
                        throw new IllegalStateException("closed".toString());
                    }
                    if (pipe.getCanceled$okio()) {
                        throw new IOException("canceled");
                    }
                    while (pipe.getBuffer$okio().size() == 0) {
                        if (pipe.getSinkClosed$okio()) {
                            lock.unlock();
                            return -1L;
                        }
                        this.timeout.awaitSignal(pipe.getCondition());
                        if (pipe.getCanceled$okio()) {
                            throw new IOException("canceled");
                        }
                    }
                    long read = pipe.getBuffer$okio().read(sink, j2);
                    pipe.getCondition().signalAll();
                    return read;
                } finally {
                    lock.unlock();
                }
            }

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                ReentrantLock lock = Pipe.this.getLock();
                Pipe pipe = Pipe.this;
                lock.lock();
                try {
                    pipe.setSourceClosed$okio(true);
                    pipe.getCondition().signalAll();
                    Unit unit = Unit.INSTANCE;
                } finally {
                    lock.unlock();
                }
            }

            @Override // okio.Source
            public Timeout timeout() {
                return this.timeout;
            }
        };
    }

    public final long getMaxBufferSize$okio() {
        return this.maxBufferSize;
    }

    public final Buffer getBuffer$okio() {
        return this.buffer;
    }

    public final boolean getCanceled$okio() {
        return this.canceled;
    }

    public final void setCanceled$okio(boolean z) {
        this.canceled = z;
    }

    public final boolean getSinkClosed$okio() {
        return this.sinkClosed;
    }

    public final void setSinkClosed$okio(boolean z) {
        this.sinkClosed = z;
    }

    public final boolean getSourceClosed$okio() {
        return this.sourceClosed;
    }

    public final void setSourceClosed$okio(boolean z) {
        this.sourceClosed = z;
    }

    public final Sink getFoldedSink$okio() {
        return this.foldedSink;
    }

    public final void setFoldedSink$okio(Sink sink) {
        this.foldedSink = sink;
    }

    public final ReentrantLock getLock() {
        return this.lock;
    }

    public final Condition getCondition() {
        return this.condition;
    }

    public final Sink sink() {
        return this.sink;
    }

    public final Source source() {
        return this.source;
    }

    public final void fold(Sink sink) throws IOException {
        Buffer buffer;
        boolean z;
        Intrinsics.checkNotNullParameter(sink, "sink");
        while (true) {
            this.lock.lock();
            try {
                if (this.foldedSink != null) {
                    throw new IllegalStateException("sink already folded".toString());
                }
                if (this.canceled) {
                    this.foldedSink = sink;
                    throw new IOException("canceled");
                }
                boolean z2 = this.sinkClosed;
                Buffer buffer2 = null;
                if (this.buffer.exhausted()) {
                    this.sourceClosed = true;
                    this.foldedSink = sink;
                    buffer = null;
                    z = true;
                } else {
                    buffer = new Buffer();
                    Buffer buffer3 = this.buffer;
                    buffer.write(buffer3, buffer3.size());
                    this.condition.signalAll();
                    z = false;
                }
                Unit unit = Unit.INSTANCE;
                if (z) {
                    if (z2) {
                        sink.close();
                        return;
                    }
                    return;
                }
                if (buffer == null) {
                    try {
                        Intrinsics.throwUninitializedPropertyAccessException("sinkBuffer");
                        continue;
                    } catch (Throwable th) {
                        this.lock.lock();
                        try {
                            this.sourceClosed = true;
                            this.condition.signalAll();
                            Unit unit2 = Unit.INSTANCE;
                            throw th;
                        } finally {
                        }
                    }
                } else {
                    buffer2 = buffer;
                    continue;
                }
                sink.write(buffer2, buffer.size());
                sink.flush();
            } finally {
            }
        }
    }

    private final void forward(Sink sink, Function1<? super Sink, Unit> function1) {
        boolean hasDeadline;
        Timeout timeout = sink.timeout();
        Timeout timeout2 = sink().timeout();
        long timeoutNanos = timeout.timeoutNanos();
        timeout.timeout(Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos()), TimeUnit.NANOSECONDS);
        if (timeout.hasDeadline()) {
            long deadlineNanoTime = timeout.deadlineNanoTime();
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
            }
            try {
                function1.invoke(sink);
                Unit unit = Unit.INSTANCE;
                if (hasDeadline) {
                    return;
                }
                return;
            } finally {
                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(deadlineNanoTime);
                }
            }
        }
        if (timeout2.hasDeadline()) {
            timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
        }
        try {
            function1.invoke(sink);
            Unit unit2 = Unit.INSTANCE;
        } finally {
            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            if (timeout2.hasDeadline()) {
                timeout.clearDeadline();
            }
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sink", imports = {}))
    /* renamed from: -deprecated_sink  reason: not valid java name */
    public final Sink m10318deprecated_sink() {
        return this.sink;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "source", imports = {}))
    /* renamed from: -deprecated_source  reason: not valid java name */
    public final Source m10319deprecated_source() {
        return this.source;
    }

    public final void cancel() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.canceled = true;
            this.buffer.clear();
            this.condition.signalAll();
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }
}
