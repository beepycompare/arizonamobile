package coil3.disk;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;
/* compiled from: FaultHidingSink.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0016\u0010\u0003\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\t\u0010\u0013\u001a\u00020\u0014H\u0096\u0001R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0003\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcoil3/disk/FaultHidingSink;", "Lokio/Sink;", "delegate", "onException", "Lkotlin/Function1;", "Ljava/io/IOException;", "Lokio/IOException;", "", "<init>", "(Lokio/Sink;Lkotlin/jvm/functions/Function1;)V", "hasErrors", "", "write", "source", "Lokio/Buffer;", "byteCount", "", "flush", "close", "timeout", "Lokio/Timeout;", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FaultHidingSink implements Sink {
    private final Sink delegate;
    private boolean hasErrors;
    private final Function1<IOException, Unit> onException;

    @Override // okio.Sink
    public Timeout timeout() {
        return this.delegate.timeout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FaultHidingSink(Sink sink, Function1<? super IOException, Unit> function1) {
        this.delegate = sink;
        this.onException = function1;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) {
        if (this.hasErrors) {
            buffer.skip(j);
            return;
        }
        try {
            this.delegate.write(buffer, j);
        } catch (IOException e) {
            this.hasErrors = true;
            this.onException.invoke(e);
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        try {
            this.delegate.flush();
        } catch (IOException e) {
            this.hasErrors = true;
            this.onException.invoke(e);
        }
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.delegate.close();
        } catch (IOException e) {
            this.hasErrors = true;
            this.onException.invoke(e);
        }
    }
}
