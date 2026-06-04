package androidx.core.content;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Context.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.core.content.ContextKt", f = "Context.kt", i = {}, l = {240}, m = "receiveBroadcastsAsync", n = {}, s = {}, v = 1)
/* loaded from: classes2.dex */
public final class ContextKt$receiveBroadcastsAsync$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContextKt$receiveBroadcastsAsync$1(Continuation<? super ContextKt$receiveBroadcastsAsync$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ContextKt.receiveBroadcastsAsync(null, null, 0, null, null, null, this);
    }
}
