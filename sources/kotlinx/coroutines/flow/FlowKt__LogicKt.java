package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Logic.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001aB\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0086@¢\u0006\u0002\u0010\b\u001aB\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0086@¢\u0006\u0002\u0010\b\u001aB\u0010\n\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0086@¢\u0006\u0002\u0010\b¨\u0006\u000b"}, d2 = {"any", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", TtmlNode.COMBINE_ALL, "none", "kotlinx-coroutines-core"}, k = 5, mv = {2, 1, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__LogicKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object any(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super Boolean> continuation) {
        FlowKt__LogicKt$any$1 flowKt__LogicKt$any$1;
        int i;
        Ref.BooleanRef booleanRef;
        AbortFlowException e;
        FlowCollector<? super Object> flowCollector;
        if (continuation instanceof FlowKt__LogicKt$any$1) {
            flowKt__LogicKt$any$1 = (FlowKt__LogicKt$any$1) continuation;
            if ((flowKt__LogicKt$any$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__LogicKt$any$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__LogicKt$any$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__LogicKt$any$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                    FlowCollector<? super Object> flowKt__LogicKt$any$$inlined$collectWhile$1 = new FlowKt__LogicKt$any$$inlined$collectWhile$1<>(function2, booleanRef2);
                    try {
                        flowKt__LogicKt$any$1.L$0 = booleanRef2;
                        flowKt__LogicKt$any$1.L$1 = flowKt__LogicKt$any$$inlined$collectWhile$1;
                        flowKt__LogicKt$any$1.label = 1;
                        if (flow.collect(flowKt__LogicKt$any$$inlined$collectWhile$1, flowKt__LogicKt$any$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        booleanRef = booleanRef2;
                    } catch (AbortFlowException e2) {
                        booleanRef = booleanRef2;
                        e = e2;
                        flowCollector = flowKt__LogicKt$any$$inlined$collectWhile$1;
                        FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                        JobKt.ensureActive(flowKt__LogicKt$any$1.getContext());
                        return Boxing.boxBoolean(booleanRef.element);
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    flowCollector = (FlowKt__LogicKt$any$$inlined$collectWhile$1) flowKt__LogicKt$any$1.L$1;
                    booleanRef = (Ref.BooleanRef) flowKt__LogicKt$any$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (AbortFlowException e3) {
                        e = e3;
                        FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                        JobKt.ensureActive(flowKt__LogicKt$any$1.getContext());
                        return Boxing.boxBoolean(booleanRef.element);
                    }
                }
                return Boxing.boxBoolean(booleanRef.element);
            }
        }
        flowKt__LogicKt$any$1 = new FlowKt__LogicKt$any$1(continuation);
        Object obj2 = flowKt__LogicKt$any$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__LogicKt$any$1.label;
        if (i != 0) {
        }
        return Boxing.boxBoolean(booleanRef.element);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object all(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super Boolean> continuation) {
        FlowKt__LogicKt$all$1 flowKt__LogicKt$all$1;
        int i;
        Ref.BooleanRef booleanRef;
        AbortFlowException e;
        FlowCollector<? super Object> flowCollector;
        if (continuation instanceof FlowKt__LogicKt$all$1) {
            flowKt__LogicKt$all$1 = (FlowKt__LogicKt$all$1) continuation;
            if ((flowKt__LogicKt$all$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__LogicKt$all$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__LogicKt$all$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__LogicKt$all$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                    FlowCollector<? super Object> flowKt__LogicKt$all$$inlined$collectWhile$1 = new FlowKt__LogicKt$all$$inlined$collectWhile$1<>(function2, booleanRef2);
                    try {
                        flowKt__LogicKt$all$1.L$0 = booleanRef2;
                        flowKt__LogicKt$all$1.L$1 = flowKt__LogicKt$all$$inlined$collectWhile$1;
                        flowKt__LogicKt$all$1.label = 1;
                        if (flow.collect(flowKt__LogicKt$all$$inlined$collectWhile$1, flowKt__LogicKt$all$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        booleanRef = booleanRef2;
                    } catch (AbortFlowException e2) {
                        booleanRef = booleanRef2;
                        e = e2;
                        flowCollector = flowKt__LogicKt$all$$inlined$collectWhile$1;
                        FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                        JobKt.ensureActive(flowKt__LogicKt$all$1.getContext());
                        return Boxing.boxBoolean(!booleanRef.element);
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    flowCollector = (FlowKt__LogicKt$all$$inlined$collectWhile$1) flowKt__LogicKt$all$1.L$1;
                    booleanRef = (Ref.BooleanRef) flowKt__LogicKt$all$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (AbortFlowException e3) {
                        e = e3;
                        FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                        JobKt.ensureActive(flowKt__LogicKt$all$1.getContext());
                        return Boxing.boxBoolean(!booleanRef.element);
                    }
                }
                return Boxing.boxBoolean(!booleanRef.element);
            }
        }
        flowKt__LogicKt$all$1 = new FlowKt__LogicKt$all$1(continuation);
        Object obj2 = flowKt__LogicKt$all$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__LogicKt$all$1.label;
        if (i != 0) {
        }
        return Boxing.boxBoolean(!booleanRef.element);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object none(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super Boolean> continuation) {
        FlowKt__LogicKt$none$1 flowKt__LogicKt$none$1;
        int i;
        if (continuation instanceof FlowKt__LogicKt$none$1) {
            flowKt__LogicKt$none$1 = (FlowKt__LogicKt$none$1) continuation;
            if ((flowKt__LogicKt$none$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__LogicKt$none$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__LogicKt$none$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__LogicKt$none$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    flowKt__LogicKt$none$1.label = 1;
                    obj = FlowKt.any(flow, function2, flowKt__LogicKt$none$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxBoolean(!((Boolean) obj).booleanValue());
            }
        }
        flowKt__LogicKt$none$1 = new FlowKt__LogicKt$none$1(continuation);
        Object obj2 = flowKt__LogicKt$none$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__LogicKt$none$1.label;
        if (i != 0) {
        }
        return Boxing.boxBoolean(!((Boolean) obj2).booleanValue());
    }
}
