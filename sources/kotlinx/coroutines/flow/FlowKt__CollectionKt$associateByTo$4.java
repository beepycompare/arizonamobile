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
public final class FlowKt__CollectionKt$associateByTo$4<T> implements FlowCollector {
    final /* synthetic */ Map $destination;
    final /* synthetic */ Function2<T, Continuation<? super K>, Object> $keySelector;
    final /* synthetic */ Function2<T, Continuation<? super V>, Object> $valueTransform;

    /* JADX WARN: Incorrect types in method signature: (TM;Lkotlin/jvm/functions/Function2<-TT;-Lkotlin/coroutines/Continuation<-TK;>;+Ljava/lang/Object;>;Lkotlin/jvm/functions/Function2<-TT;-Lkotlin/coroutines/Continuation<-TV;>;+Ljava/lang/Object;>;)V */
    public FlowKt__CollectionKt$associateByTo$4(Map map, Function2 function2, Function2 function22) {
        this.$destination = map;
        this.$keySelector = function2;
        this.$valueTransform = function22;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0074  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        FlowKt__CollectionKt$associateByTo$4$emit$1 flowKt__CollectionKt$associateByTo$4$emit$1;
        Object coroutine_suspended;
        int i;
        Object obj;
        Map map;
        Object invoke;
        Object obj2;
        if (continuation instanceof FlowKt__CollectionKt$associateByTo$4$emit$1) {
            flowKt__CollectionKt$associateByTo$4$emit$1 = (FlowKt__CollectionKt$associateByTo$4$emit$1) continuation;
            if ((flowKt__CollectionKt$associateByTo$4$emit$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__CollectionKt$associateByTo$4$emit$1.label -= Integer.MIN_VALUE;
                Object obj3 = flowKt__CollectionKt$associateByTo$4$emit$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CollectionKt$associateByTo$4$emit$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    Map map2 = this.$destination;
                    Function2<T, Continuation<? super K>, Object> function2 = this.$keySelector;
                    flowKt__CollectionKt$associateByTo$4$emit$1.L$0 = t;
                    flowKt__CollectionKt$associateByTo$4$emit$1.L$1 = map2;
                    flowKt__CollectionKt$associateByTo$4$emit$1.label = 1;
                    Object invoke2 = function2.invoke(t, flowKt__CollectionKt$associateByTo$4$emit$1);
                    if (invoke2 != coroutine_suspended) {
                        obj = t;
                        map = map2;
                        obj3 = invoke2;
                    }
                    return coroutine_suspended;
                } else if (i != 1) {
                    if (i == 2) {
                        obj2 = flowKt__CollectionKt$associateByTo$4$emit$1.L$2;
                        map = (Map) flowKt__CollectionKt$associateByTo$4$emit$1.L$1;
                        Object obj4 = flowKt__CollectionKt$associateByTo$4$emit$1.L$0;
                        ResultKt.throwOnFailure(obj3);
                        map.put(obj2, obj3);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    map = (Map) flowKt__CollectionKt$associateByTo$4$emit$1.L$1;
                    obj = flowKt__CollectionKt$associateByTo$4$emit$1.L$0;
                    ResultKt.throwOnFailure(obj3);
                }
                Function2<T, Continuation<? super V>, Object> function22 = this.$valueTransform;
                flowKt__CollectionKt$associateByTo$4$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                flowKt__CollectionKt$associateByTo$4$emit$1.L$1 = map;
                flowKt__CollectionKt$associateByTo$4$emit$1.L$2 = obj3;
                flowKt__CollectionKt$associateByTo$4$emit$1.label = 2;
                invoke = function22.invoke(obj, flowKt__CollectionKt$associateByTo$4$emit$1);
                if (invoke != coroutine_suspended) {
                    Object obj5 = obj3;
                    obj3 = invoke;
                    obj2 = obj5;
                    map.put(obj2, obj3);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            }
        }
        flowKt__CollectionKt$associateByTo$4$emit$1 = new FlowKt__CollectionKt$associateByTo$4$emit$1(this, continuation);
        Object obj32 = flowKt__CollectionKt$associateByTo$4$emit$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CollectionKt$associateByTo$4$emit$1.label;
        if (i != 0) {
        }
        Function2<T, Continuation<? super V>, Object> function222 = this.$valueTransform;
        flowKt__CollectionKt$associateByTo$4$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
        flowKt__CollectionKt$associateByTo$4$emit$1.L$1 = map;
        flowKt__CollectionKt$associateByTo$4$emit$1.L$2 = obj32;
        flowKt__CollectionKt$associateByTo$4$emit$1.label = 2;
        invoke = function222.invoke(obj, flowKt__CollectionKt$associateByTo$4$emit$1);
        if (invoke != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    public final Object emit$$forInline(T t, Continuation<? super Unit> continuation) {
        new FlowKt__CollectionKt$associateByTo$4$emit$1(this, continuation);
        this.$destination.put(this.$keySelector.invoke(t, continuation), this.$valueTransform.invoke(t, continuation));
        return Unit.INSTANCE;
    }
}
