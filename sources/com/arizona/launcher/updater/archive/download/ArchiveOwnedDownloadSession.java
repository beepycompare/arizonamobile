package com.arizona.launcher.updater.archive.download;

import androidx.core.app.NotificationCompat;
import com.facebook.widget.FacebookDialog;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
/* compiled from: ArchiveDownloadResumeSidecar.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveOwnedDownloadSession;", "", "<init>", "()V", "callRef", "Ljava/util/concurrent/atomic/AtomicReference;", "Lokhttp3/Call;", "cancelRequested", "Ljava/util/concurrent/atomic/AtomicBoolean;", "attach", "", NotificationCompat.CATEGORY_CALL, FacebookDialog.COMPLETION_GESTURE_CANCEL, "", "isCancellationRequested", "clearCall", "canceledException", "Ljava/io/InterruptedIOException;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveOwnedDownloadSession {
    public static final int $stable = 8;
    private final AtomicReference<Call> callRef = new AtomicReference<>(null);
    private final AtomicBoolean cancelRequested = new AtomicBoolean(false);

    public final void attach(Call call) throws InterruptedIOException {
        Intrinsics.checkNotNullParameter(call, "call");
        if (this.cancelRequested.get()) {
            call.cancel();
            throw canceledException();
        } else if (!ArchiveOwnedDownloadSession$$ExternalSyntheticBackportWithForwarding0.m(this.callRef, null, call)) {
            call.cancel();
            throw new IOException("Download session already has an attached call");
        } else if (this.cancelRequested.get()) {
            call.cancel();
            ArchiveOwnedDownloadSession$$ExternalSyntheticBackportWithForwarding0.m(this.callRef, call, null);
            throw canceledException();
        }
    }

    public final boolean cancel() {
        boolean compareAndSet = this.cancelRequested.compareAndSet(false, true);
        Call call = this.callRef.get();
        if (call != null) {
            call.cancel();
        }
        return compareAndSet || call != null;
    }

    public final boolean isCancellationRequested() {
        return this.cancelRequested.get();
    }

    public final void clearCall(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        ArchiveOwnedDownloadSession$$ExternalSyntheticBackportWithForwarding0.m(this.callRef, call, null);
    }

    private final InterruptedIOException canceledException() {
        return new InterruptedIOException("Canceled archive download session");
    }
}
