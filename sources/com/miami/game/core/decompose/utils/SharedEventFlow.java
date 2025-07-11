package com.miami.game.core.decompose.utils;

import androidx.exifinterface.media.ExifInterface;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
/* compiled from: SharedEventFlow.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/miami/game/core/decompose/utils/SharedEventFlow;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/flow/Flow;", "<init>", "()V", "sharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collect", "collector", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isExistSubscription", "", "decompose-utils_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SharedEventFlow<T> implements FlowCollector<T>, Flow<T> {
    private final MutableSharedFlow<T> sharedFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0058, code lost:
        if (kotlinx.coroutines.flow.FlowKt.first(r6.sharedFlow.getSubscriptionCount(), new com.miami.game.core.decompose.utils.SharedEventFlow$emit$2(null), r0) == r1) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0069, code lost:
        if (r6.sharedFlow.emit(r7, r0) != r1) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006b, code lost:
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(T t, Continuation<? super Unit> continuation) {
        SharedEventFlow$emit$1 sharedEventFlow$emit$1;
        int i;
        if (continuation instanceof SharedEventFlow$emit$1) {
            sharedEventFlow$emit$1 = (SharedEventFlow$emit$1) continuation;
            if ((sharedEventFlow$emit$1.label & Integer.MIN_VALUE) != 0) {
                sharedEventFlow$emit$1.label -= Integer.MIN_VALUE;
                Object obj = sharedEventFlow$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = sharedEventFlow$emit$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    sharedEventFlow$emit$1.L$0 = t;
                    sharedEventFlow$emit$1.label = 1;
                } else if (i != 1) {
                    if (i == 2) {
                        Object obj2 = sharedEventFlow$emit$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    t = (T) sharedEventFlow$emit$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                sharedEventFlow$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(t);
                sharedEventFlow$emit$1.label = 2;
            }
        }
        sharedEventFlow$emit$1 = new SharedEventFlow$emit$1(this, continuation);
        Object obj3 = sharedEventFlow$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = sharedEventFlow$emit$1.label;
        if (i != 0) {
        }
        sharedEventFlow$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(t);
        sharedEventFlow$emit$1.label = 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        SharedEventFlow$collect$1 sharedEventFlow$collect$1;
        int i;
        if (continuation instanceof SharedEventFlow$collect$1) {
            sharedEventFlow$collect$1 = (SharedEventFlow$collect$1) continuation;
            if ((sharedEventFlow$collect$1.label & Integer.MIN_VALUE) != 0) {
                sharedEventFlow$collect$1.label -= Integer.MIN_VALUE;
                Object obj = sharedEventFlow$collect$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = sharedEventFlow$collect$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    MutableSharedFlow<T> mutableSharedFlow = this.sharedFlow;
                    sharedEventFlow$collect$1.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                    sharedEventFlow$collect$1.label = 1;
                    if (mutableSharedFlow.collect(flowCollector, sharedEventFlow$collect$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    FlowCollector flowCollector2 = (FlowCollector) sharedEventFlow$collect$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }
        sharedEventFlow$collect$1 = new SharedEventFlow$collect$1(this, continuation);
        Object obj2 = sharedEventFlow$collect$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = sharedEventFlow$collect$1.label;
        if (i != 0) {
        }
        throw new KotlinNothingValueException();
    }

    public final boolean isExistSubscription() {
        return this.sharedFlow.getSubscriptionCount().getValue().intValue() > 0;
    }
}
