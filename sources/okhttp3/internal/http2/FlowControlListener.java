package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.flowcontrol.WindowCounter;
/* compiled from: FlowControlListener.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lokhttp3/internal/http2/FlowControlListener;", "", "receivingStreamWindowChanged", "", "streamId", "", "windowCounter", "Lokhttp3/internal/http2/flowcontrol/WindowCounter;", "bufferSize", "", "receivingConnectionWindowChanged", "None", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FlowControlListener {
    void receivingConnectionWindowChanged(WindowCounter windowCounter);

    void receivingStreamWindowChanged(int i, WindowCounter windowCounter, long j);

    /* compiled from: FlowControlListener.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\r"}, d2 = {"Lokhttp3/internal/http2/FlowControlListener$None;", "Lokhttp3/internal/http2/FlowControlListener;", "<init>", "()V", "receivingStreamWindowChanged", "", "streamId", "", "windowCounter", "Lokhttp3/internal/http2/flowcontrol/WindowCounter;", "bufferSize", "", "receivingConnectionWindowChanged", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class None implements FlowControlListener {
        public static final None INSTANCE = new None();

        @Override // okhttp3.internal.http2.FlowControlListener
        public void receivingConnectionWindowChanged(WindowCounter windowCounter) {
            Intrinsics.checkNotNullParameter(windowCounter, "windowCounter");
        }

        @Override // okhttp3.internal.http2.FlowControlListener
        public void receivingStreamWindowChanged(int i, WindowCounter windowCounter, long j) {
            Intrinsics.checkNotNullParameter(windowCounter, "windowCounter");
        }

        private None() {
        }
    }
}
