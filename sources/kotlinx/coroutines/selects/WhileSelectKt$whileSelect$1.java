package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WhileSelect.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.selects.WhileSelectKt", f = "WhileSelect.kt", i = {0, 0, 0, 0, 0}, l = {34}, m = "whileSelect", n = {"builder", "$this$select_u24lambda_u240$iv", "$i$f$whileSelect", "$i$f$select", "$i$a$-run-SelectKt$select$2$iv"}, s = {"L$0", "L$1", "I$0", "I$1", "I$2"}, v = 1)
/* loaded from: classes5.dex */
public final class WhileSelectKt$whileSelect$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WhileSelectKt$whileSelect$1(Continuation<? super WhileSelectKt$whileSelect$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WhileSelectKt.whileSelect(null, this);
    }
}
