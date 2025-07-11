package com.miami.game.core.decompose.utils;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.Cancellation;
import com.arkivanov.decompose.value.Value;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ValueStateFlow.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/miami/game/core/decompose/utils/ValueStateFlow;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/flow/StateFlow;", "store", "Lcom/arkivanov/decompose/value/Value;", "<init>", "(Lcom/arkivanov/decompose/value/Value;)V", "value", "getValue", "()Ljava/lang/Object;", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "decompose-utils_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ValueStateFlow<T> implements StateFlow<T> {
    private final Value<T> store;

    /* JADX WARN: Multi-variable type inference failed */
    public ValueStateFlow(Value<? extends T> store) {
        Intrinsics.checkNotNullParameter(store, "store");
        this.store = store;
    }

    @Override // kotlinx.coroutines.flow.StateFlow
    public T getValue() {
        return this.store.getValue();
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public List<T> getReplayCache() {
        return CollectionsKt.listOf(this.store.getValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<?> continuation) {
        ValueStateFlow$collect$1 valueStateFlow$collect$1;
        int i;
        Cancellation cancellation;
        if (continuation instanceof ValueStateFlow$collect$1) {
            valueStateFlow$collect$1 = (ValueStateFlow$collect$1) continuation;
            if ((valueStateFlow$collect$1.label & Integer.MIN_VALUE) != 0) {
                valueStateFlow$collect$1.label -= Integer.MIN_VALUE;
                Object obj = valueStateFlow$collect$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = valueStateFlow$collect$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    final MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(this.store.getValue());
                    Function1<? super T, Unit> function1 = new Function1() { // from class: com.miami.game.core.decompose.utils.ValueStateFlow$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit collect$lambda$0;
                            collect$lambda$0 = ValueStateFlow.collect$lambda$0(MutableStateFlow.this, obj2);
                            return collect$lambda$0;
                        }
                    };
                    Cancellation subscribe = this.store.subscribe(function1);
                    try {
                        valueStateFlow$collect$1.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        valueStateFlow$collect$1.L$1 = SpillingKt.nullOutSpilledVariable(MutableStateFlow);
                        valueStateFlow$collect$1.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                        valueStateFlow$collect$1.L$3 = subscribe;
                        valueStateFlow$collect$1.label = 1;
                        if (MutableStateFlow.collect(flowCollector, valueStateFlow$collect$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        cancellation = subscribe;
                    } catch (Throwable th) {
                        th = th;
                        cancellation = subscribe;
                        cancellation.cancel();
                        throw th;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    cancellation = (Cancellation) valueStateFlow$collect$1.L$3;
                    Function1 function12 = (Function1) valueStateFlow$collect$1.L$2;
                    MutableStateFlow mutableStateFlow = (MutableStateFlow) valueStateFlow$collect$1.L$1;
                    FlowCollector flowCollector2 = (FlowCollector) valueStateFlow$collect$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th2) {
                        th = th2;
                        cancellation.cancel();
                        throw th;
                    }
                }
                throw new KotlinNothingValueException();
            }
        }
        valueStateFlow$collect$1 = new ValueStateFlow$collect$1(this, continuation);
        Object obj2 = valueStateFlow$collect$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = valueStateFlow$collect$1.label;
        if (i != 0) {
        }
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit collect$lambda$0(MutableStateFlow mutableStateFlow, Object it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableStateFlow.setValue(it);
        return Unit.INSTANCE;
    }
}
