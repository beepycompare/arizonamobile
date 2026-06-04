package androidx.datastore.core;

import coil3.util.UtilsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileStorage.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.FileStorageKt", f = "FileStorage.kt", i = {0}, l = {224}, m = "runFileDiagnosticsIfNotCorruption", n = {UtilsKt.SCHEME_FILE}, s = {"L$0"}, v = 1)
/* loaded from: classes2.dex */
public final class FileStorageKt$runFileDiagnosticsIfNotCorruption$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileStorageKt$runFileDiagnosticsIfNotCorruption$1(Continuation<? super FileStorageKt$runFileDiagnosticsIfNotCorruption$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object runFileDiagnosticsIfNotCorruption;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        runFileDiagnosticsIfNotCorruption = FileStorageKt.runFileDiagnosticsIfNotCorruption(null, null, this);
        return runFileDiagnosticsIfNotCorruption;
    }
}
