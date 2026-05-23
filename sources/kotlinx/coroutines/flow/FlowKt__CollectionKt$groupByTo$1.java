package kotlinx.coroutines.flow;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Collection.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__CollectionKt", f = "Collection.kt", i = {0, 0, 0, 0}, l = {327}, m = "groupByTo", n = {"$this$groupByTo", FirebaseAnalytics.Param.DESTINATION, "keySelector", "$i$f$groupByTo"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
/* loaded from: classes5.dex */
public final class FlowKt__CollectionKt$groupByTo$1<T, K, M extends Map<? super K, List<T>>> extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowKt__CollectionKt$groupByTo$1(Continuation<? super FlowKt__CollectionKt$groupByTo$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FlowKt__CollectionKt.groupByTo(null, null, null, this);
    }
}
