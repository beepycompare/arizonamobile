package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Await.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", i = {0, 0, 0, 0, 0, 0}, l = {47}, m = "joinAll", n = {"jobs", "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-AwaitKt$joinAll$2"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$3"}, v = 1)
/* loaded from: classes5.dex */
public final class AwaitKt$joinAll$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AwaitKt$joinAll$1(Continuation<? super AwaitKt$joinAll$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AwaitKt.joinAll((Job[]) null, this);
    }
}
