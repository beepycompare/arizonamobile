package kotlinx.coroutines.flow;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
/* JADX WARN: Incorrect field signature: TM; */
/* compiled from: Collection.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
/* loaded from: classes5.dex */
public final class FlowKt__CollectionKt$associateTo$2<T> implements FlowCollector {
    final /* synthetic */ Map $destination;
    final /* synthetic */ Function2<T, Continuation<? super Pair<? extends K, ? extends V>>, Object> $transform;

    /* JADX WARN: Incorrect types in method signature: (TM;Lkotlin/jvm/functions/Function2<-TT;-Lkotlin/coroutines/Continuation<-Lkotlin/Pair<+TK;+TV;>;>;+Ljava/lang/Object;>;)V */
    public FlowKt__CollectionKt$associateTo$2(Map map, Function2 function2) {
        this.$destination = map;
        this.$transform = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        FlowKt__CollectionKt$associateTo$2$emit$1 flowKt__CollectionKt$associateTo$2$emit$1;
        int i;
        Map map;
        if (continuation instanceof FlowKt__CollectionKt$associateTo$2$emit$1) {
            flowKt__CollectionKt$associateTo$2$emit$1 = (FlowKt__CollectionKt$associateTo$2$emit$1) continuation;
            if ((flowKt__CollectionKt$associateTo$2$emit$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__CollectionKt$associateTo$2$emit$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__CollectionKt$associateTo$2$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CollectionKt$associateTo$2$emit$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Map map2 = this.$destination;
                    Function2<T, Continuation<? super Pair<? extends K, ? extends V>>, Object> function2 = this.$transform;
                    flowKt__CollectionKt$associateTo$2$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(t);
                    flowKt__CollectionKt$associateTo$2$emit$1.L$1 = map2;
                    flowKt__CollectionKt$associateTo$2$emit$1.label = 1;
                    Object invoke = function2.invoke(t, flowKt__CollectionKt$associateTo$2$emit$1);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = invoke;
                    map = map2;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    map = (Map) flowKt__CollectionKt$associateTo$2$emit$1.L$1;
                    Object obj2 = flowKt__CollectionKt$associateTo$2$emit$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Pair pair = (Pair) obj;
                map.put(pair.getFirst(), pair.getSecond());
                return Unit.INSTANCE;
            }
        }
        flowKt__CollectionKt$associateTo$2$emit$1 = new FlowKt__CollectionKt$associateTo$2$emit$1(this, continuation);
        Object obj3 = flowKt__CollectionKt$associateTo$2$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CollectionKt$associateTo$2$emit$1.label;
        if (i != 0) {
        }
        Pair pair2 = (Pair) obj3;
        map.put(pair2.getFirst(), pair2.getSecond());
        return Unit.INSTANCE;
    }

    public final Object emit$$forInline(T t, Continuation<? super Unit> continuation) {
        new FlowKt__CollectionKt$associateTo$2$emit$1(this, continuation);
        Map map = this.$destination;
        Pair pair = (Pair) this.$transform.invoke(t, continuation);
        map.put(pair.getFirst(), pair.getSecond());
        return Unit.INSTANCE;
    }
}
