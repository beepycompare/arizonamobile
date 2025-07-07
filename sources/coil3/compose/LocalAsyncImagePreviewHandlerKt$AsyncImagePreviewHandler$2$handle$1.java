package coil3.compose;

import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* compiled from: LocalAsyncImagePreviewHandler.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
@DebugMetadata(c = "coil3.compose.LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$2", f = "LocalAsyncImagePreviewHandler.kt", i = {0}, l = {TsExtractor.TS_SYNC_BYTE}, m = "handle", n = {"request"}, s = {"L$0"})
/* loaded from: classes3.dex */
public final class LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$2$handle$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$2$handle$1(LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$2 localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$2, Continuation<? super LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$2$handle$1> continuation) {
        super(continuation);
        this.this$0 = localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.handle(null, null, this);
    }
}
