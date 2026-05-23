package okio.internal;

import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileSystem.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "okio.internal.-FileSystem", f = "FileSystem.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {116, TsExtractor.TS_STREAM_TYPE_E_AC3, 145}, m = "collectRecursively", n = {"$this$collectRecursively", "fileSystem", "stack", "path", "followSymlinks", "postorder", "$this$collectRecursively", "fileSystem", "stack", "path", "children", "symlinkPath", "child", "followSymlinks", "postorder", "symlinkCount", "$this$collectRecursively", "fileSystem", "stack", "path", "children", "followSymlinks", "postorder"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "Z$0", "Z$1", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "Z$1"}, v = 1)
/* renamed from: okio.internal.-FileSystem$collectRecursively$1  reason: invalid class name */
/* loaded from: classes6.dex */
public final class FileSystem$collectRecursively$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileSystem$collectRecursively$1(Continuation<? super FileSystem$collectRecursively$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FileSystem.collectRecursively(null, null, null, null, false, false, this);
    }
}
