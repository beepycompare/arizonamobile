package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import ru.mrlargha.feature.battlepassWinter2025.roulette.RouletteView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Context.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.CancellableFlowImpl$collect$2", f = "Context.kt", i = {0}, l = {RouletteView.DEFAULT_ROULETTE_WIDTH}, m = "emit", n = {"it"}, s = {"L$0"}, v = 1)
/* loaded from: classes5.dex */
public final class CancellableFlowImpl$collect$2$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CancellableFlowImpl$collect$2<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CancellableFlowImpl$collect$2$emit$1(CancellableFlowImpl$collect$2<? super T> cancellableFlowImpl$collect$2, Continuation<? super CancellableFlowImpl$collect$2$emit$1> continuation) {
        super(continuation);
        this.this$0 = cancellableFlowImpl$collect$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
