package coil3.compose;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConstraintsSizeResolver.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "coil3.compose.ConstraintsSizeResolver", f = "ConstraintsSizeResolver.kt", i = {0, 0}, l = {77}, m = "size", n = {"continuation", "$i$f$suspendCancellableCoroutine"}, s = {"L$0", "I$0"})
/* loaded from: classes3.dex */
public final class ConstraintsSizeResolver$size$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConstraintsSizeResolver this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintsSizeResolver$size$1(ConstraintsSizeResolver constraintsSizeResolver, Continuation<? super ConstraintsSizeResolver$size$1> continuation) {
        super(continuation);
        this.this$0 = constraintsSizeResolver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.size(this);
    }
}
