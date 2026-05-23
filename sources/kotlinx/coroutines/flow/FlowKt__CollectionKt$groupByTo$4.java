package kotlinx.coroutines.flow;

import java.util.ArrayList;
import java.util.List;
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
public final class FlowKt__CollectionKt$groupByTo$4<T> implements FlowCollector {
    final /* synthetic */ Map $destination;
    final /* synthetic */ Function2<T, Continuation<? super K>, Object> $keySelector;
    final /* synthetic */ Function2<T, Continuation<? super V>, Object> $valueTransform;

    /* JADX WARN: Incorrect types in method signature: (Lkotlin/jvm/functions/Function2<-TT;-Lkotlin/coroutines/Continuation<-TK;>;+Ljava/lang/Object;>;TM;Lkotlin/jvm/functions/Function2<-TT;-Lkotlin/coroutines/Continuation<-TV;>;+Ljava/lang/Object;>;)V */
    public FlowKt__CollectionKt$groupByTo$4(Function2 function2, Map map, Function2 function22) {
        this.$keySelector = function2;
        this.$destination = map;
        this.$valueTransform = function22;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0054, code lost:
        if (r7 == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008b  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        FlowKt__CollectionKt$groupByTo$4$emit$1 flowKt__CollectionKt$groupByTo$4$emit$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        Object obj2;
        List list;
        if (continuation instanceof FlowKt__CollectionKt$groupByTo$4$emit$1) {
            flowKt__CollectionKt$groupByTo$4$emit$1 = (FlowKt__CollectionKt$groupByTo$4$emit$1) continuation;
            if ((flowKt__CollectionKt$groupByTo$4$emit$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__CollectionKt$groupByTo$4$emit$1.label -= Integer.MIN_VALUE;
                obj = flowKt__CollectionKt$groupByTo$4$emit$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CollectionKt$groupByTo$4$emit$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Function2<T, Continuation<? super K>, Object> function2 = this.$keySelector;
                    flowKt__CollectionKt$groupByTo$4$emit$1.L$0 = t;
                    flowKt__CollectionKt$groupByTo$4$emit$1.label = 1;
                    obj = function2.invoke(t, flowKt__CollectionKt$groupByTo$4$emit$1);
                } else if (i != 1) {
                    if (i == 2) {
                        list = (List) flowKt__CollectionKt$groupByTo$4$emit$1.L$3;
                        List list2 = (List) flowKt__CollectionKt$groupByTo$4$emit$1.L$2;
                        Object obj3 = flowKt__CollectionKt$groupByTo$4$emit$1.L$1;
                        Object obj4 = flowKt__CollectionKt$groupByTo$4$emit$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        list.add(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    t = (T) flowKt__CollectionKt$groupByTo$4$emit$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Map map = this.$destination;
                obj2 = map.get(obj);
                if (obj2 == null) {
                    obj2 = (List) new ArrayList();
                    map.put(obj, obj2);
                }
                List list3 = (List) obj2;
                Function2<T, Continuation<? super V>, Object> function22 = this.$valueTransform;
                flowKt__CollectionKt$groupByTo$4$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(t);
                flowKt__CollectionKt$groupByTo$4$emit$1.L$1 = SpillingKt.nullOutSpilledVariable(obj);
                flowKt__CollectionKt$groupByTo$4$emit$1.L$2 = SpillingKt.nullOutSpilledVariable(list3);
                flowKt__CollectionKt$groupByTo$4$emit$1.L$3 = list3;
                flowKt__CollectionKt$groupByTo$4$emit$1.label = 2;
                obj = function22.invoke(t, flowKt__CollectionKt$groupByTo$4$emit$1);
                if (obj != coroutine_suspended) {
                    list = list3;
                    list.add(obj);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            }
        }
        flowKt__CollectionKt$groupByTo$4$emit$1 = new FlowKt__CollectionKt$groupByTo$4$emit$1(this, continuation);
        obj = flowKt__CollectionKt$groupByTo$4$emit$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CollectionKt$groupByTo$4$emit$1.label;
        if (i != 0) {
        }
        Map map2 = this.$destination;
        obj2 = map2.get(obj);
        if (obj2 == null) {
        }
        List list32 = (List) obj2;
        Function2<T, Continuation<? super V>, Object> function222 = this.$valueTransform;
        flowKt__CollectionKt$groupByTo$4$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(t);
        flowKt__CollectionKt$groupByTo$4$emit$1.L$1 = SpillingKt.nullOutSpilledVariable(obj);
        flowKt__CollectionKt$groupByTo$4$emit$1.L$2 = SpillingKt.nullOutSpilledVariable(list32);
        flowKt__CollectionKt$groupByTo$4$emit$1.L$3 = list32;
        flowKt__CollectionKt$groupByTo$4$emit$1.label = 2;
        obj = function222.invoke(t, flowKt__CollectionKt$groupByTo$4$emit$1);
        if (obj != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    public final Object emit$$forInline(T t, Continuation<? super Unit> continuation) {
        new FlowKt__CollectionKt$groupByTo$4$emit$1(this, continuation);
        Object invoke = this.$keySelector.invoke(t, continuation);
        Map map = this.$destination;
        Object obj = map.get(invoke);
        if (obj == null) {
            obj = (List) new ArrayList();
            map.put(invoke, obj);
        }
        ((List) obj).add(this.$valueTransform.invoke(t, continuation));
        return Unit.INSTANCE;
    }
}
