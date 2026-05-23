package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import ru.mrlargha.feature.battlepassWinter2025.roulette.RouletteView;
/* compiled from: Collection.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__CollectionKt$groupByTo$4", f = "Collection.kt", i = {0, 1, 1, 1}, l = {358, RouletteView.PREMIUM_ROULETTE_WIDTH}, m = "emit", n = {"element", "element", "key", "list"}, s = {"L$0", "L$0", "L$1", "L$2"}, v = 1)
/* loaded from: classes5.dex */
public final class FlowKt__CollectionKt$groupByTo$4$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowKt__CollectionKt$groupByTo$4<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__CollectionKt$groupByTo$4$emit$1(FlowKt__CollectionKt$groupByTo$4<? super T> flowKt__CollectionKt$groupByTo$4, Continuation<? super FlowKt__CollectionKt$groupByTo$4$emit$1> continuation) {
        super(continuation);
        this.this$0 = flowKt__CollectionKt$groupByTo$4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
