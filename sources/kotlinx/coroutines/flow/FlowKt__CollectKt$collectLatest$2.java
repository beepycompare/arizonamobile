package kotlinx.coroutines.flow;

import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Collect.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__CollectKt", f = "Collect.kt", i = {0, 0, 0}, l = {TsExtractor.TS_STREAM_TYPE_AC3}, m = "collectLatest", n = {"$this$collectLatest", "action", "$i$f$collectLatest"}, s = {"L$0", "L$1", "I$0"}, v = 1)
/* loaded from: classes5.dex */
public final class FlowKt__CollectKt$collectLatest$2<T> extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowKt__CollectKt$collectLatest$2(Continuation<? super FlowKt__CollectKt$collectLatest$2> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FlowKt__CollectKt.collectLatest((SharedFlow) null, (Function2) null, (Continuation<?>) this);
    }
}
