package androidx.paging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Separators.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.SeparatorState", f = "Separators.kt", i = {}, l = {217, 219, 220}, m = "onEvent", n = {}, s = {}, v = 1)
/* loaded from: classes3.dex */
public final class SeparatorState$onEvent$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SeparatorState<R, T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SeparatorState$onEvent$1(SeparatorState<R, T> separatorState, Continuation<? super SeparatorState$onEvent$1> continuation) {
        super(continuation);
        this.this$0 = separatorState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onEvent(null, this);
    }
}
