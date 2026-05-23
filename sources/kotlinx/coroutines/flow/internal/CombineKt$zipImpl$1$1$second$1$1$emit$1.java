package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Combine.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1", f = "Combine.kt", i = {0}, l = {87}, m = "emit", n = {"value"}, s = {"L$0"}, v = 1)
/* loaded from: classes5.dex */
public final class CombineKt$zipImpl$1$1$second$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CombineKt$zipImpl$1$1$second$1.AnonymousClass1<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$zipImpl$1$1$second$1$1$emit$1(CombineKt$zipImpl$1$1$second$1.AnonymousClass1<? super T> anonymousClass1, Continuation<? super CombineKt$zipImpl$1$1$second$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
