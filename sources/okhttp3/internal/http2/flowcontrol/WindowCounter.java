package okhttp3.internal.http2.flowcontrol;

import kotlin.Metadata;
/* compiled from: WindowCounter.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\tJ\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\f¨\u0006\u0015"}, d2 = {"Lokhttp3/internal/http2/flowcontrol/WindowCounter;", "", "streamId", "", "<init>", "(I)V", "getStreamId", "()I", "value", "", "total", "getTotal", "()J", "acknowledged", "getAcknowledged", "unacknowledged", "getUnacknowledged", "update", "", "toString", "", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WindowCounter {
    private long acknowledged;
    private final int streamId;
    private long total;

    public WindowCounter(int i) {
        this.streamId = i;
    }

    public final int getStreamId() {
        return this.streamId;
    }

    public final long getTotal() {
        return this.total;
    }

    public final long getAcknowledged() {
        return this.acknowledged;
    }

    public final synchronized long getUnacknowledged() {
        return this.total - this.acknowledged;
    }

    public static /* synthetic */ void update$default(WindowCounter windowCounter, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        if ((i & 2) != 0) {
            j2 = 0;
        }
        windowCounter.update(j, j2);
    }

    public final synchronized void update(long j, long j2) {
        if (j < 0) {
            throw new IllegalStateException("Check failed.");
        }
        if (j2 < 0) {
            throw new IllegalStateException("Check failed.");
        }
        long j3 = this.total + j;
        this.total = j3;
        long j4 = this.acknowledged + j2;
        this.acknowledged = j4;
        if (j4 > j3) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public String toString() {
        return "WindowCounter(streamId=" + this.streamId + ", total=" + this.total + ", acknowledged=" + this.acknowledged + ", unacknowledged=" + getUnacknowledged() + ')';
    }
}
