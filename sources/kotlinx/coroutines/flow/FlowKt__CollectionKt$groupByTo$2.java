package kotlinx.coroutines.flow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
/* JADX WARN: Incorrect field signature: TM; */
/* compiled from: Collection.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
/* loaded from: classes5.dex */
public final class FlowKt__CollectionKt$groupByTo$2<T> implements FlowCollector {
    final /* synthetic */ Map $destination;
    final /* synthetic */ Function2<T, Continuation<? super K>, Object> $keySelector;

    /* JADX WARN: Incorrect types in method signature: (Lkotlin/jvm/functions/Function2<-TT;-Lkotlin/coroutines/Continuation<-TK;>;+Ljava/lang/Object;>;TM;)V */
    public FlowKt__CollectionKt$groupByTo$2(Function2 function2, Map map) {
        this.$keySelector = function2;
        this.$destination = map;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        FlowKt__CollectionKt$groupByTo$2$emit$1 flowKt__CollectionKt$groupByTo$2$emit$1;
        int i;
        Object obj;
        if (continuation instanceof FlowKt__CollectionKt$groupByTo$2$emit$1) {
            flowKt__CollectionKt$groupByTo$2$emit$1 = (FlowKt__CollectionKt$groupByTo$2$emit$1) continuation;
            if ((flowKt__CollectionKt$groupByTo$2$emit$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__CollectionKt$groupByTo$2$emit$1.label -= Integer.MIN_VALUE;
                Object obj2 = flowKt__CollectionKt$groupByTo$2$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CollectionKt$groupByTo$2$emit$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Function2<T, Continuation<? super K>, Object> function2 = this.$keySelector;
                    flowKt__CollectionKt$groupByTo$2$emit$1.L$0 = t;
                    flowKt__CollectionKt$groupByTo$2$emit$1.label = 1;
                    obj2 = function2.invoke(t, flowKt__CollectionKt$groupByTo$2$emit$1);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    t = (T) flowKt__CollectionKt$groupByTo$2$emit$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                }
                Map map = this.$destination;
                obj = map.get(obj2);
                if (obj == null) {
                    obj = (List) new ArrayList();
                    map.put(obj2, obj);
                }
                ((List) obj).add(t);
                return Unit.INSTANCE;
            }
        }
        flowKt__CollectionKt$groupByTo$2$emit$1 = new FlowKt__CollectionKt$groupByTo$2$emit$1(this, continuation);
        Object obj22 = flowKt__CollectionKt$groupByTo$2$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CollectionKt$groupByTo$2$emit$1.label;
        if (i != 0) {
        }
        Map map2 = this.$destination;
        obj = map2.get(obj22);
        if (obj == null) {
        }
        ((List) obj).add(t);
        return Unit.INSTANCE;
    }

    public final Object emit$$forInline(T t, Continuation<? super Unit> continuation) {
        new FlowKt__CollectionKt$groupByTo$2$emit$1(this, continuation);
        Object invoke = this.$keySelector.invoke(t, continuation);
        Map map = this.$destination;
        Object obj = map.get(invoke);
        if (obj == null) {
            obj = (List) new ArrayList();
            map.put(invoke, obj);
        }
        ((List) obj).add(t);
        return Unit.INSTANCE;
    }
}
