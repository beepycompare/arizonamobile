package androidx.datastore.core;

import androidx.exifinterface.media.ExifInterface;
import coil3.util.UtilsKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FileStorage.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000f\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/datastore/core/FileReadScope;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/ReadScope;", UtilsKt.SCHEME_FILE, "Ljava/io/File;", "serializer", "Landroidx/datastore/core/Serializer;", "<init>", "(Ljava/io/File;Landroidx/datastore/core/Serializer;)V", "getFile", "()Ljava/io/File;", "getSerializer", "()Landroidx/datastore/core/Serializer;", "closed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "readData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "", "checkNotClosed", "datastore-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public class FileReadScope<T> implements ReadScope<T> {
    private final java.util.concurrent.atomic.AtomicBoolean closed;
    private final File file;
    private final Serializer<T> serializer;

    @Override // androidx.datastore.core.ReadScope
    public Object readData(Continuation<? super T> continuation) {
        return readData$suspendImpl(this, continuation);
    }

    public FileReadScope(File file, Serializer<T> serializer) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.file = file;
        this.serializer = serializer;
        this.closed = new java.util.concurrent.atomic.AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final File getFile() {
        return this.file;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Serializer<T> getSerializer() {
        return this.serializer;
    }

    static /* synthetic */ <T> Object readData$suspendImpl(FileReadScope<T> fileReadScope, Continuation<? super T> continuation) {
        Object runFileDiagnosticsIfNotCorruption;
        fileReadScope.checkNotClosed();
        runFileDiagnosticsIfNotCorruption = FileStorageKt.runFileDiagnosticsIfNotCorruption(((FileReadScope) fileReadScope).file, new FileReadScope$readData$2(fileReadScope, null), continuation);
        return runFileDiagnosticsIfNotCorruption;
    }

    @Override // androidx.datastore.core.Closeable
    public void close() {
        this.closed.set(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void checkNotClosed() {
        if (this.closed.get()) {
            throw new IllegalStateException("This scope has already been closed.".toString());
        }
    }
}
