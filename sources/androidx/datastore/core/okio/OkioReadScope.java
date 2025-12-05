package androidx.datastore.core.okio;

import androidx.datastore.core.DirectBootExceptionUtilKt;
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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0013\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/datastore/core/okio/OkioReadScope;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/ReadScope;", "fileSystem", "Lokio/FileSystem;", "path", "Lokio/Path;", "serializer", "Landroidx/datastore/core/okio/OkioSerializer;", "<init>", "(Lokio/FileSystem;Lokio/Path;Landroidx/datastore/core/okio/OkioSerializer;)V", "getFileSystem", "()Lokio/FileSystem;", "getPath", "()Lokio/Path;", "getSerializer", "()Landroidx/datastore/core/okio/OkioSerializer;", "closed", "Landroidx/datastore/core/okio/AtomicBoolean;", "readData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "", "checkClose", "datastore-core-okio"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009c A[Catch: FileNotFoundException -> 0x0094, TRY_LEAVE, TryCatch #5 {FileNotFoundException -> 0x0094, blocks: (B:47:0x009c, B:39:0x008b), top: B:92:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ed A[Catch: Exception -> 0x00ee, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x00ee, blocks: (B:73:0x00ed, B:50:0x00a7), top: B:88:0x00a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v21, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r9v27, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v33, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ <T> Object readData$suspendImpl(OkioReadScope<T> okioReadScope, Continuation<? super T> continuation) {
        OkioReadScope$readData$1 okioReadScope$readData$1;
        int i;
        OkioReadScope<T> okioReadScope2;
        Closeable closeable;
        ?? th;
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
                Object th4 = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    okioReadScope.checkClose();
                    try {
                        BufferedSource buffer = Okio.buffer(((OkioReadScope) okioReadScope).fileSystem.source(((OkioReadScope) okioReadScope).path));
                        try {
                            OkioSerializer<T> okioSerializer = ((OkioReadScope) okioReadScope).serializer;
                            okioReadScope$readData$1.L$0 = okioReadScope;
                            okioReadScope$readData$1.L$1 = buffer;
                            okioReadScope$readData$1.label = 1;
                            Object readFrom = okioSerializer.readFrom(buffer, okioReadScope$readData$1);
                            if (readFrom != coroutine_suspended) {
                                closeable2 = buffer;
                                obj = readFrom;
                            }
                        } catch (Throwable th5) {
                            closeable2 = buffer;
                            th2 = th5;
                            if (closeable2 != null) {
                                try {
                                    closeable2.close();
                                }
                            }
                            th3 = th2;
                            obj = null;
                            if (th3 != null) {
                            }
                        }
                    } catch (FileNotFoundException unused) {
                        if (!((OkioReadScope) okioReadScope).fileSystem.exists(((OkioReadScope) okioReadScope).path)) {
                            return ((OkioReadScope) okioReadScope).serializer.getDefaultValue();
                        }
                        try {
                            BufferedSource buffer2 = Okio.buffer(((OkioReadScope) okioReadScope).fileSystem.source(((OkioReadScope) okioReadScope).path));
                            try {
                                OkioSerializer<T> okioSerializer2 = ((OkioReadScope) okioReadScope).serializer;
                                okioReadScope$readData$1.L$0 = okioReadScope;
                                okioReadScope$readData$1.L$1 = buffer2;
                                okioReadScope$readData$1.label = 2;
                                Object readFrom2 = okioSerializer2.readFrom(buffer2, okioReadScope$readData$1);
                                if (readFrom2 != coroutine_suspended) {
                                    okioReadScope2 = okioReadScope;
                                    closeable = buffer2;
                                    obj = readFrom2;
                                }
                            } catch (Throwable th6) {
                                okioReadScope2 = okioReadScope;
                                closeable = buffer2;
                                th = th6;
                                if (closeable != null) {
                                    try {
                                        closeable.close();
                                    } catch (Throwable th7) {
                                        try {
                                            ExceptionsKt.addSuppressed(th, th7);
                                        } catch (Exception e) {
                                            e = e;
                                            if (!(e instanceof FileNotFoundException)) {
                                            }
                                        }
                                    }
                                }
                                okioReadScope = okioReadScope2;
                                if (th == 0) {
                                }
                            }
                        } catch (Exception e2) {
                            okioReadScope2 = okioReadScope;
                            e = e2;
                            if (!(e instanceof FileNotFoundException)) {
                                throw DirectBootExceptionUtilKt.wrapExceptionIfDueToDirectBoot(String.valueOf(((OkioReadScope) okioReadScope2).path.parent()), e);
                            }
                            throw e;
                        }
                    }
                    return coroutine_suspended;
                } else if (i != 1) {
                    if (i == 2) {
                        closeable = (Closeable) okioReadScope$readData$1.L$1;
                        okioReadScope2 = (OkioReadScope) okioReadScope$readData$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            if (closeable != null) {
                                try {
                                    closeable.close();
                                } catch (Throwable th8) {
                                    th4 = th8;
                                }
                            }
                            Object obj2 = th4;
                            th4 = obj;
                            th = obj2;
                        } catch (Throwable th9) {
                            th = th9;
                            if (closeable != null) {
                            }
                            okioReadScope = okioReadScope2;
                            if (th == 0) {
                            }
                        }
                        okioReadScope = okioReadScope2;
                        if (th == 0) {
                            return th4;
                        }
                        throw th;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    closeable2 = (Closeable) okioReadScope$readData$1.L$1;
                    OkioReadScope okioReadScope3 = (OkioReadScope) okioReadScope$readData$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th10) {
                        th2 = th10;
                        if (closeable2 != null) {
                        }
                        th3 = th2;
                        obj = null;
                        if (th3 != null) {
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
                if (th3 != null) {
                    return obj;
                }
                throw th3;
            }
        }
        okioReadScope$readData$1 = new OkioReadScope$readData$1(okioReadScope, continuation);
        Object obj3 = okioReadScope$readData$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = okioReadScope$readData$1.label;
        Object th42 = null;
        if (i != 0) {
        }
        if (closeable2 != null) {
        }
        th3 = null;
        if (th3 != null) {
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
