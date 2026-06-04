package androidx.datastore.core;

import androidx.exifinterface.media.ExifInterface;
import coil3.util.UtilsKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FileStorage.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/datastore/core/FileWriteScope;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/FileReadScope;", "Landroidx/datastore/core/WriteScope;", UtilsKt.SCHEME_FILE, "Ljava/io/File;", "serializer", "Landroidx/datastore/core/Serializer;", "<init>", "(Ljava/io/File;Landroidx/datastore/core/Serializer;)V", "writeData", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FileWriteScope<T> extends FileReadScope<T> implements WriteScope<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileWriteScope(File file, Serializer<T> serializer) {
        super(file, serializer);
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
    }

    @Override // androidx.datastore.core.WriteScope
    public Object writeData(T t, Continuation<? super Unit> continuation) {
        Object runFileDiagnosticsIfNotCorruption;
        checkNotClosed();
        runFileDiagnosticsIfNotCorruption = FileStorageKt.runFileDiagnosticsIfNotCorruption(getFile(), new FileWriteScope$writeData$2(this, t, null), continuation);
        return runFileDiagnosticsIfNotCorruption == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? runFileDiagnosticsIfNotCorruption : Unit.INSTANCE;
    }
}
