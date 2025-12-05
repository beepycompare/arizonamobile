package androidx.datastore.core;

import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
/* compiled from: FileStorage.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a:\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0082@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"runFileDiagnosticsIfNotCorruption", ExifInterface.GPS_DIRECTION_TRUE, "file", "Ljava/io/File;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Ljava/io/File;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FileStorageKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object runFileDiagnosticsIfNotCorruption(File file, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        FileStorageKt$runFileDiagnosticsIfNotCorruption$1 fileStorageKt$runFileDiagnosticsIfNotCorruption$1;
        int i;
        try {
            if (continuation instanceof FileStorageKt$runFileDiagnosticsIfNotCorruption$1) {
                fileStorageKt$runFileDiagnosticsIfNotCorruption$1 = (FileStorageKt$runFileDiagnosticsIfNotCorruption$1) continuation;
                if ((fileStorageKt$runFileDiagnosticsIfNotCorruption$1.label & Integer.MIN_VALUE) != 0) {
                    fileStorageKt$runFileDiagnosticsIfNotCorruption$1.label -= Integer.MIN_VALUE;
                    Object obj = fileStorageKt$runFileDiagnosticsIfNotCorruption$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = fileStorageKt$runFileDiagnosticsIfNotCorruption$1.label;
                    if (i == 0) {
                        if (i == 1) {
                            File file2 = (File) fileStorageKt$runFileDiagnosticsIfNotCorruption$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    fileStorageKt$runFileDiagnosticsIfNotCorruption$1.L$0 = file;
                    fileStorageKt$runFileDiagnosticsIfNotCorruption$1.label = 1;
                    Object invoke = function1.invoke(fileStorageKt$runFileDiagnosticsIfNotCorruption$1);
                    return invoke == coroutine_suspended ? coroutine_suspended : invoke;
                }
            }
            if (i == 0) {
            }
        } catch (IOException e) {
            if (e instanceof CorruptionException) {
                throw e;
            }
            throw FileDiagnostics.INSTANCE.attachFileDebugInfo(file, e);
        }
        fileStorageKt$runFileDiagnosticsIfNotCorruption$1 = new FileStorageKt$runFileDiagnosticsIfNotCorruption$1(continuation);
        Object obj2 = fileStorageKt$runFileDiagnosticsIfNotCorruption$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = fileStorageKt$runFileDiagnosticsIfNotCorruption$1.label;
    }
}
