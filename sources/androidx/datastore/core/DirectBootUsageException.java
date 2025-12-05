package androidx.datastore.core;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DirectBootExceptionUtil.android.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/datastore/core/DirectBootUsageException;", "Ljava/io/IOException;", "Landroidx/datastore/core/IOException;", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(Ljava/lang/Exception;)V", "message", "", "getMessage", "()Ljava/lang/String;", "datastore-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DirectBootUsageException extends IOException {
    private final String message;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectBootUsageException(Exception ex) {
        super(ex);
        Intrinsics.checkNotNullParameter(ex, "ex");
        this.message = "Encountered a [" + ex.getMessage() + "]. If you are trying to use DataStore during direct boot, this exception likely indicates that your DataStore file is not located in the Device Encrypted Storage and therefore is not available for write access during direct boot mode. DataStore to be used during direct boot must be initialized using `DataStoreFactory.createInDeviceProtectedStorage()`.";
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }
}
