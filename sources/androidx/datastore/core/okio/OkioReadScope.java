package androidx.datastore.core.okio;

import androidx.datastore.core.ReadScope;
import androidx.exifinterface.media.ExifInterface;
import java.io.Closeable;
import java.io.FileNotFoundException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
/* compiled from: OkioStorage.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\b\u0010\u0012\u001a\u00020\u0013H\u0004J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u000e\u0010\u0015\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Landroidx/datastore/core/okio/OkioReadScope;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/ReadScope;", "fileSystem", "Lokio/FileSystem;", "path", "Lokio/Path;", "serializer", "Landroidx/datastore/core/okio/OkioSerializer;", "(Lokio/FileSystem;Lokio/Path;Landroidx/datastore/core/okio/OkioSerializer;)V", "closed", "Landroidx/datastore/core/okio/AtomicBoolean;", "getFileSystem", "()Lokio/FileSystem;", "getPath", "()Lokio/Path;", "getSerializer", "()Landroidx/datastore/core/okio/OkioSerializer;", "checkClose", "", "close", "readData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core-okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public class OkioReadScope<T> implements ReadScope<T> {
    private final AtomicBoolean closed;
    private final FileSystem fileSystem;
    private final Path path;
    private final OkioSerializer<T> serializer;

    @Override // androidx.datastore.core.ReadScope
    public Object readData(Continuation<? super T> continuation) {
        return readData$suspendImpl(this, continuation);
    }

    public OkioReadScope(FileSystem fileSystem, Path path, OkioSerializer<T> serializer) {
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.fileSystem = fileSystem;
        this.path = path;
        this.serializer = serializer;
        this.closed = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final FileSystem getFileSystem() {
        return this.fileSystem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Path getPath() {
        return this.path;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final OkioSerializer<T> getSerializer() {
        return this.serializer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0097 A[Catch: FileNotFoundException -> 0x0091, TryCatch #2 {FileNotFoundException -> 0x0091, blocks: (B:46:0x0097, B:47:0x009b, B:39:0x0088), top: B:76:0x0088 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009b A[Catch: FileNotFoundException -> 0x0091, TRY_LEAVE, TryCatch #2 {FileNotFoundException -> 0x0091, blocks: (B:46:0x0097, B:47:0x009b, B:39:0x0088), top: B:76:0x0088 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ <T> Object readData$suspendImpl(OkioReadScope<T> okioReadScope, Continuation<? super T> continuation) {
        OkioReadScope$readData$1 okioReadScope$readData$1;
        int i;
        Throwable th;
        Closeable closeable;
        BufferedSource buffer;
        Closeable closeable2;
        Throwable th2;
        Throwable th3;
        if (continuation instanceof OkioReadScope$readData$1) {
            okioReadScope$readData$1 = (OkioReadScope$readData$1) continuation;
            if ((okioReadScope$readData$1.label & Integer.MIN_VALUE) != 0) {
                okioReadScope$readData$1.label -= Integer.MIN_VALUE;
                Object obj = okioReadScope$readData$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = okioReadScope$readData$1.label;
                Throwable th4 = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    okioReadScope.checkClose();
                    try {
                        buffer = Okio.buffer(((OkioReadScope) okioReadScope).fileSystem.source(((OkioReadScope) okioReadScope).path));
                    } catch (FileNotFoundException unused) {
                        if (!((OkioReadScope) okioReadScope).fileSystem.exists(((OkioReadScope) okioReadScope).path)) {
                            return ((OkioReadScope) okioReadScope).serializer.getDefaultValue();
                        }
                        BufferedSource buffer2 = Okio.buffer(((OkioReadScope) okioReadScope).fileSystem.source(((OkioReadScope) okioReadScope).path));
                        try {
                            OkioSerializer<T> okioSerializer = ((OkioReadScope) okioReadScope).serializer;
                            okioReadScope$readData$1.L$0 = buffer2;
                            okioReadScope$readData$1.L$1 = null;
                            okioReadScope$readData$1.label = 2;
                            Object readFrom = okioSerializer.readFrom(buffer2, okioReadScope$readData$1);
                            if (readFrom != coroutine_suspended) {
                                obj = readFrom;
                                closeable = buffer2;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            closeable = buffer2;
                            if (closeable != null) {
                                try {
                                    closeable.close();
                                } catch (Throwable th6) {
                                    ExceptionsKt.addSuppressed(th, th6);
                                }
                            }
                            th4 = th;
                            obj = null;
                            if (th4 != null) {
                            }
                        }
                    }
                    try {
                        OkioSerializer<T> okioSerializer2 = ((OkioReadScope) okioReadScope).serializer;
                        okioReadScope$readData$1.L$0 = okioReadScope;
                        okioReadScope$readData$1.L$1 = buffer;
                        okioReadScope$readData$1.label = 1;
                        Object readFrom2 = okioSerializer2.readFrom(buffer, okioReadScope$readData$1);
                        if (readFrom2 != coroutine_suspended) {
                            closeable2 = buffer;
                            obj = readFrom2;
                        }
                        return coroutine_suspended;
                    } catch (Throwable th7) {
                        closeable2 = buffer;
                        th2 = th7;
                        if (closeable2 != null) {
                        }
                        th3 = th2;
                        obj = null;
                        if (th3 == null) {
                        }
                    }
                } else if (i != 1) {
                    if (i == 2) {
                        closeable = (Closeable) okioReadScope$readData$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            if (closeable != null) {
                                try {
                                    closeable.close();
                                } catch (Throwable th8) {
                                    th4 = th8;
                                }
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            if (closeable != null) {
                            }
                            th4 = th;
                            obj = null;
                            if (th4 != null) {
                            }
                        }
                        if (th4 != null) {
                            throw th4;
                        }
                        Intrinsics.checkNotNull(obj);
                        return obj;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    closeable2 = (Closeable) okioReadScope$readData$1.L$1;
                    OkioReadScope okioReadScope2 = (OkioReadScope) okioReadScope$readData$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th10) {
                        th2 = th10;
                        if (closeable2 != null) {
                            try {
                                closeable2.close();
                            }
                        }
                        th3 = th2;
                        obj = null;
                        if (th3 == null) {
                        }
                    }
                }
                if (closeable2 != null) {
                    try {
                        closeable2.close();
                    } catch (Throwable th11) {
                        th3 = th11;
                    }
                }
                th3 = null;
                if (th3 == null) {
                    throw th3;
                }
                Intrinsics.checkNotNull(obj);
                return obj;
            }
        }
        okioReadScope$readData$1 = new OkioReadScope$readData$1(okioReadScope, continuation);
        Object obj2 = okioReadScope$readData$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = okioReadScope$readData$1.label;
        Throwable th42 = null;
        if (i != 0) {
        }
        if (closeable2 != null) {
        }
        th3 = null;
        if (th3 == null) {
        }
    }

    @Override // androidx.datastore.core.Closeable
    public void close() {
        this.closed.set(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void checkClose() {
        if (this.closed.get()) {
            throw new IllegalStateException("This scope has already been closed.".toString());
        }
    }
}
