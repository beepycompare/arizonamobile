package androidx.datastore.core.okio;

import androidx.datastore.core.WriteScope;
import androidx.exifinterface.media.ExifInterface;
import java.io.Closeable;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.FileHandle;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
/* compiled from: OkioStorage.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/datastore/core/okio/OkioWriteScope;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/okio/OkioReadScope;", "Landroidx/datastore/core/WriteScope;", "fileSystem", "Lokio/FileSystem;", "path", "Lokio/Path;", "serializer", "Landroidx/datastore/core/okio/OkioSerializer;", "(Lokio/FileSystem;Lokio/Path;Landroidx/datastore/core/okio/OkioSerializer;)V", "writeData", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core-okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OkioWriteScope<T> extends OkioReadScope<T> implements WriteScope<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkioWriteScope(FileSystem fileSystem, Path path, OkioSerializer<T> serializer) {
        super(fileSystem, path, serializer);
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a2 A[Catch: all -> 0x009b, TRY_LEAVE, TryCatch #5 {all -> 0x009b, blocks: (B:42:0x00a2, B:48:0x00af, B:34:0x0092), top: B:68:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00af A[Catch: all -> 0x009b, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x009b, blocks: (B:42:0x00a2, B:48:0x00af, B:34:0x0092), top: B:68:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r10v14, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v19, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v9 */
    @Override // androidx.datastore.core.WriteScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object writeData(T t, Continuation<? super Unit> continuation) {
        OkioWriteScope$writeData$1 okioWriteScope$writeData$1;
        int i;
        Unit unit;
        FileHandle fileHandle;
        Throwable th;
        BufferedSink bufferedSink;
        FileHandle fileHandle2;
        Throwable th2;
        Unit unit2;
        if (continuation instanceof OkioWriteScope$writeData$1) {
            okioWriteScope$writeData$1 = (OkioWriteScope$writeData$1) continuation;
            if ((okioWriteScope$writeData$1.label & Integer.MIN_VALUE) != 0) {
                okioWriteScope$writeData$1.label -= Integer.MIN_VALUE;
                Object obj = okioWriteScope$writeData$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = okioWriteScope$writeData$1.label;
                Throwable th3 = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    checkClose();
                    FileHandle openReadWrite = getFileSystem().openReadWrite(getPath());
                    try {
                        FileHandle fileHandle3 = openReadWrite;
                        BufferedSink buffer = Okio.buffer(FileHandle.sink$default(fileHandle3, 0L, 1, null));
                        try {
                            OkioSerializer<T> serializer = getSerializer();
                            okioWriteScope$writeData$1.L$0 = openReadWrite;
                            okioWriteScope$writeData$1.L$1 = fileHandle3;
                            okioWriteScope$writeData$1.L$2 = buffer;
                            okioWriteScope$writeData$1.label = 1;
                            if (serializer.writeTo(t, buffer, okioWriteScope$writeData$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            fileHandle = openReadWrite;
                            fileHandle2 = fileHandle3;
                            bufferedSink = buffer;
                        } catch (Throwable th4) {
                            fileHandle = openReadWrite;
                            th = th4;
                            bufferedSink = buffer;
                            if (bufferedSink != 0) {
                            }
                            th2 = th;
                            unit2 = null;
                            if (th2 == null) {
                            }
                        }
                    } catch (Throwable th5) {
                        if (openReadWrite != null) {
                            try {
                                openReadWrite.close();
                            } catch (Throwable th6) {
                                ExceptionsKt.addSuppressed(th5, th6);
                            }
                        }
                        th3 = th5;
                        unit = null;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    bufferedSink = (Closeable) okioWriteScope$writeData$1.L$2;
                    fileHandle2 = (FileHandle) okioWriteScope$writeData$1.L$1;
                    fileHandle = (Closeable) okioWriteScope$writeData$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        fileHandle = fileHandle;
                        bufferedSink = bufferedSink;
                    } catch (Throwable th7) {
                        th = th7;
                        if (bufferedSink != 0) {
                            try {
                                bufferedSink.close();
                            }
                        }
                        th2 = th;
                        unit2 = null;
                        if (th2 == null) {
                        }
                    }
                }
                fileHandle2.flush();
                unit2 = Unit.INSTANCE;
                if (bufferedSink != 0) {
                    try {
                        bufferedSink.close();
                    } catch (Throwable th8) {
                        th2 = th8;
                    }
                }
                th2 = null;
                if (th2 == null) {
                    throw th2;
                }
                Intrinsics.checkNotNull(unit2);
                unit = Unit.INSTANCE;
                if (fileHandle != 0) {
                    try {
                        fileHandle.close();
                    } catch (Throwable th9) {
                        th3 = th9;
                    }
                }
                if (th3 != null) {
                    throw th3;
                }
                Intrinsics.checkNotNull(unit);
                return Unit.INSTANCE;
            }
        }
        okioWriteScope$writeData$1 = new OkioWriteScope$writeData$1(this, continuation);
        Object obj2 = okioWriteScope$writeData$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = okioWriteScope$writeData$1.label;
        Throwable th32 = null;
        if (i != 0) {
        }
        fileHandle2.flush();
        unit2 = Unit.INSTANCE;
        if (bufferedSink != 0) {
        }
        th2 = null;
        if (th2 == null) {
        }
    }
}
