package coil3.compose;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* compiled from: LocalAsyncImagePreviewHandler.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
@DebugMetadata(c = "coil3.compose.LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1", f = "LocalAsyncImagePreviewHandler.kt", i = {0}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE}, m = "handle", n = {"request"}, s = {"L$0"})
/* loaded from: classes3.dex */
public final class LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1(LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1 localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1, Continuation<? super LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1> continuation) {
        super(continuation);
        this.this$0 = localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.handle(null, null, this);
    }
}
