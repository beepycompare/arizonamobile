package io.appmetrica.analytics.coreutils.internal.buffering;

import androidx.exifinterface.media.ExifInterface;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u0017*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0017B?\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006¨\u0006\u0018"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/buffering/DeferredBatchExecutor;", ExifInterface.GPS_DIRECTION_TRUE, "", "task", "", "urgent", "", "submit", "(Ljava/lang/Object;Z)V", "flush", "flushAsync", "Lio/appmetrica/analytics/coreapi/internal/executors/IHandlerExecutor;", "executor", "Lio/appmetrica/analytics/coreutils/internal/buffering/TaskBuffer;", "buffer", "Lio/appmetrica/analytics/coreutils/internal/buffering/BatchProcessor;", "processor", "", "delayMillis", "", "tag", "<init>", "(Lio/appmetrica/analytics/coreapi/internal/executors/IHandlerExecutor;Lio/appmetrica/analytics/coreutils/internal/buffering/TaskBuffer;Lio/appmetrica/analytics/coreutils/internal/buffering/BatchProcessor;JLjava/lang/String;)V", "Companion", "core-utils_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class DeferredBatchExecutor<T> {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final IHandlerExecutor f349a;
    private final TaskBuffer b;
    private final BatchProcessor c;
    private final long d;
    private Runnable e;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/buffering/DeferredBatchExecutor$Companion;", "", "", "DEFAULT_DELAY_MILLIS", "J", "core-utils_release"}, k = 1, mv = {1, 9, 0})
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public DeferredBatchExecutor(IHandlerExecutor iHandlerExecutor, TaskBuffer<T> taskBuffer, BatchProcessor<T> batchProcessor, long j, String str) {
        this.f349a = iHandlerExecutor;
        this.b = taskBuffer;
        this.c = batchProcessor;
        this.d = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DeferredBatchExecutor deferredBatchExecutor) {
        deferredBatchExecutor.flush();
    }

    private final void b() {
        Runnable runnable = new Runnable() { // from class: io.appmetrica.analytics.coreutils.internal.buffering.DeferredBatchExecutor$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DeferredBatchExecutor.b(DeferredBatchExecutor.this);
            }
        };
        this.e = runnable;
        this.f349a.executeDelayed(runnable, this.d);
    }

    public static /* synthetic */ void submit$default(DeferredBatchExecutor deferredBatchExecutor, Object obj, boolean z, int i, Object obj2) {
        if ((i & 2) != 0) {
            z = false;
        }
        deferredBatchExecutor.submit(obj, z);
    }

    public final synchronized void flush() {
        Runnable runnable = this.e;
        if (runnable != null) {
            this.f349a.remove(runnable);
            this.e = null;
        }
        if (!this.b.isEmpty()) {
            a();
        }
    }

    public final void flushAsync() {
        this.f349a.execute(new Runnable() { // from class: io.appmetrica.analytics.coreutils.internal.buffering.DeferredBatchExecutor$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DeferredBatchExecutor.a(DeferredBatchExecutor.this);
            }
        });
    }

    public final synchronized void submit(T t, boolean z) {
        this.b.add(t);
        Runnable runnable = this.e;
        if (z) {
            if (runnable != null) {
                this.f349a.remove(runnable);
                this.e = null;
            }
            a();
        } else if (runnable == null) {
            b();
        }
    }

    private final void a() {
        if (this.b.isEmpty()) {
            this.e = null;
            return;
        }
        List<T> andClear = this.b.getAndClear();
        this.e = null;
        try {
            this.c.processBatch(andClear);
        } catch (Exception unused) {
        }
    }

    public /* synthetic */ DeferredBatchExecutor(IHandlerExecutor iHandlerExecutor, TaskBuffer taskBuffer, BatchProcessor batchProcessor, long j, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(iHandlerExecutor, taskBuffer, batchProcessor, (i & 8) != 0 ? 1000L : j, (i & 16) != 0 ? "[DeferredBatchExecutor]" : str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DeferredBatchExecutor deferredBatchExecutor) {
        synchronized (deferredBatchExecutor) {
            deferredBatchExecutor.a();
        }
    }
}
