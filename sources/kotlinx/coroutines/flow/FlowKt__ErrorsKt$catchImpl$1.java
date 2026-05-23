package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.metadata.internal.metadata.builtins.BuiltInsProtoBuf;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Errors.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt", f = "Errors.kt", i = {0, 0, 0}, l = {BuiltInsProtoBuf.PROPERTY_GETTER_ANNOTATION_FIELD_NUMBER}, m = "catchImpl", n = {"$this$catchImpl", "collector", "fromDownstream"}, s = {"L$0", "L$1", "L$2"}, v = 1)
/* loaded from: classes5.dex */
public final class FlowKt__ErrorsKt$catchImpl$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowKt__ErrorsKt$catchImpl$1(Continuation<? super FlowKt__ErrorsKt$catchImpl$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FlowKt.catchImpl(null, null, this);
    }
}
