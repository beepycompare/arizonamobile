package androidx.datastore.core;

import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DataStoreImpl.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl", f = "DataStoreImpl.kt", i = {0, 1, 2, 3, 4, 4, 4, 5, 5, 5}, l = {385, 386, 388, 389, 396, 400}, m = "readDataOrHandleCorruption", n = {"hasWriteFileLock", "hasWriteFileLock", "hasWriteFileLock", "hasWriteFileLock", "ex", "newData", "hasWriteFileLock", "ex", "newData", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN}, s = {"Z$0", "Z$0", "Z$0", "Z$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "L$2"}, v = 1)
/* loaded from: classes2.dex */
public final class DataStoreImpl$readDataOrHandleCorruption$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$readDataOrHandleCorruption$1(DataStoreImpl<T> dataStoreImpl, Continuation<? super DataStoreImpl$readDataOrHandleCorruption$1> continuation) {
        super(continuation);
        this.this$0 = dataStoreImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.readDataOrHandleCorruption(false, this);
    }
}
