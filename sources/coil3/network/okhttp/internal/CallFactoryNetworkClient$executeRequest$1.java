package coil3.network.okhttp.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: utils.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.okhttp.internal.CallFactoryNetworkClient", f = "utils.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2}, l = {24, 24, 25}, m = "executeRequest-impl", n = {"arg0", "request", "block", "arg0", "request", "block", "arg0", "request", "block", "response", "$i$a$-use-CallFactoryNetworkClient$executeRequest$2"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$4", "I$0"})
/* loaded from: classes3.dex */
public final class CallFactoryNetworkClient$executeRequest$1<T> extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallFactoryNetworkClient$executeRequest$1(Continuation<? super CallFactoryNetworkClient$executeRequest$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return CallFactoryNetworkClient.m9210executeRequestimpl(null, null, null, this);
    }
}
