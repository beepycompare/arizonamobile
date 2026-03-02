package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
/* compiled from: FlowExt.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ay\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00050\u00032\u0006\u0010\u0006\u001a\u0002H\u00042F\u0010\u0007\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bH\u0000¢\u0006\u0002\u0010\u000e\u001ak\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u00032F\u0010\u0007\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bH\u0000¢\u0006\u0002\u0010\u0010\u001am\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00050\u00032B\u0010\u0012\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u0013\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b¢\u0006\u0002\b\u0015H\u0000¢\u0006\u0002\u0010\u0010\u001ah\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00050\u000329\b\u0004\u0010\u0012\u001a3\b\u0001\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001ab\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00050\u000323\b\u0004\u0010\u0012\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a\u007f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u001b\"\u0004\b\u0001\u0010\u001c\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u001b0\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u00032?\b\u0004\u0010\u0012\u001a9\b\u0001\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001c\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b( \u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001eH\u0080H¢\u0006\u0002\u0010!\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\""}, d2 = {"NULL", "", "simpleScan", "Lkotlinx/coroutines/flow/Flow;", "R", ExifInterface.GPS_DIRECTION_TRUE, "initial", "operation", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "accumulator", "value", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "simpleRunningReduce", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "simpleTransformLatest", "transform", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ExtensionFunctionType;", "simpleFlatMapLatest", "Lkotlin/Function2;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "simpleMapLatest", "combineWithoutBatching", "T1", "T2", "otherFlow", "Lkotlin/Function4;", "Landroidx/paging/CombineSource;", "updateFrom", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-common"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FlowExtKt {
    private static final Object NULL = new Object();

    public static final <T, R> Flow<R> simpleScan(Flow<? extends T> flow, R r, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> operation) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        return FlowKt.flow(new FlowExtKt$simpleScan$1(r, flow, operation, null));
    }

    public static final <T> Flow<T> simpleRunningReduce(Flow<? extends T> flow, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> operation) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        return FlowKt.flow(new FlowExtKt$simpleRunningReduce$1(flow, operation, null));
    }

    public static final <T, R> Flow<R> simpleTransformLatest(Flow<? extends T> flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> transform) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return SimpleChannelFlowKt.simpleChannelFlow(new FlowExtKt$simpleTransformLatest$1(flow, transform, null));
    }

    public static final <T, R> Flow<R> simpleFlatMapLatest(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> transform) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return simpleTransformLatest(flow, new FlowExtKt$simpleFlatMapLatest$1(transform, null));
    }

    public static final <T, R> Flow<R> simpleMapLatest(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super R>, ? extends Object> transform) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return simpleTransformLatest(flow, new FlowExtKt$simpleMapLatest$1(transform, null));
    }

    public static final <T1, T2, R> Object combineWithoutBatching(Flow<? extends T1> flow, Flow<? extends T2> flow2, Function4<? super T1, ? super T2, ? super CombineSource, ? super Continuation<? super R>, ? extends Object> function4, Continuation<? super Flow<? extends R>> continuation) {
        return SimpleChannelFlowKt.simpleChannelFlow(new FlowExtKt$combineWithoutBatching$2(flow, flow2, function4, null));
    }
}
