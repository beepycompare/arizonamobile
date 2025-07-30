package coil3.network.internal;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: utils.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.internal.UtilsKt", f = "utils.kt", i = {0, 0, 0, 0}, l = {31}, m = "readBuffer", n = {"$this$readBuffer", TtmlNode.TAG_BODY, "buffer", "$i$a$-use-UtilsKt$readBuffer$2"}, s = {"L$0", "L$2", "L$3", "I$0"})
/* loaded from: classes3.dex */
public final class UtilsKt$readBuffer$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UtilsKt$readBuffer$1(Continuation<? super UtilsKt$readBuffer$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return UtilsKt.readBuffer(null, this);
    }
}
