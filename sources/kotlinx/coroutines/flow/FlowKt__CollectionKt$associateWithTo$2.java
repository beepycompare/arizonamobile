package kotlinx.coroutines.flow;

import java.util.Map;
import kotlin.Metadata;
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
public final class FlowKt__CollectionKt$associateWithTo$2<T> implements FlowCollector {
    final /* synthetic */ Map $destination;
    final /* synthetic */ Function2<K, Continuation<? super V>, Object> $valueSelector;

    /* JADX WARN: Incorrect types in method signature: (TM;Lkotlin/jvm/functions/Function2<-TK;-Lkotlin/coroutines/Continuation<-TV;>;+Ljava/lang/Object;>;)V */
    public FlowKt__CollectionKt$associateWithTo$2(Map map, Function2 function2) {
        this.$destination = map;
        this.$valueSelector = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(K k, Continuation<? super Unit> continuation) {
        FlowKt__CollectionKt$associateWithTo$2$emit$1 flowKt__CollectionKt$associateWithTo$2$emit$1;
        int i;
        Map map;
        Object obj;
        if (continuation instanceof FlowKt__CollectionKt$associateWithTo$2$emit$1) {
            flowKt__CollectionKt$associateWithTo$2$emit$1 = (FlowKt__CollectionKt$associateWithTo$2$emit$1) continuation;
            if ((flowKt__CollectionKt$associateWithTo$2$emit$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__CollectionKt$associateWithTo$2$emit$1.label -= Integer.MIN_VALUE;
                Object obj2 = flowKt__CollectionKt$associateWithTo$2$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CollectionKt$associateWithTo$2$emit$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Map map2 = this.$destination;
                    Function2<K, Continuation<? super V>, Object> function2 = this.$valueSelector;
                    flowKt__CollectionKt$associateWithTo$2$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(k);
                    flowKt__CollectionKt$associateWithTo$2$emit$1.L$1 = map2;
                    flowKt__CollectionKt$associateWithTo$2$emit$1.L$2 = k;
                    flowKt__CollectionKt$associateWithTo$2$emit$1.label = 1;
                    Object invoke = function2.invoke(k, flowKt__CollectionKt$associateWithTo$2$emit$1);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj2 = invoke;
                    map = map2;
                    obj = k;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    Object obj3 = flowKt__CollectionKt$associateWithTo$2$emit$1.L$2;
                    map = (Map) flowKt__CollectionKt$associateWithTo$2$emit$1.L$1;
                    Object obj4 = flowKt__CollectionKt$associateWithTo$2$emit$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    obj = obj3;
                }
                map.put(obj, obj2);
                return Unit.INSTANCE;
            }
        }
        flowKt__CollectionKt$associateWithTo$2$emit$1 = new FlowKt__CollectionKt$associateWithTo$2$emit$1(this, continuation);
        Object obj22 = flowKt__CollectionKt$associateWithTo$2$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CollectionKt$associateWithTo$2$emit$1.label;
        if (i != 0) {
        }
        map.put(obj, obj22);
        return Unit.INSTANCE;
    }

    public final Object emit$$forInline(K k, Continuation<? super Unit> continuation) {
        new FlowKt__CollectionKt$associateWithTo$2$emit$1(this, continuation);
        this.$destination.put(k, this.$valueSelector.invoke(k, continuation));
        return Unit.INSTANCE;
    }
}
