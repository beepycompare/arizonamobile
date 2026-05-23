package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Collection.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__CollectionKt", f = "Collection.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {365}, m = "groupBy", n = {"$this$groupBy", "keySelector", "valueTransform", "$this$groupByTo$iv", "destination$iv", "$i$f$groupBy", "$i$f$groupByTo"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 1)
/* loaded from: classes5.dex */
public final class FlowKt__CollectionKt$groupBy$2<T, K, V> extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowKt__CollectionKt$groupBy$2(Continuation<? super FlowKt__CollectionKt$groupBy$2> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FlowKt__CollectionKt.groupBy(null, null, null, this);
    }
}
