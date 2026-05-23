package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
/* compiled from: Collection.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\t\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001a4\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086@¢\u0006\u0002\u0010\n\u001a8\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\u0002\"\u0010\b\u0001\u0010\f*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\fH\u0086@¢\u0006\u0002\u0010\u000e\u001ah\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00120\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0011\"\u0004\b\u0002\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00020\u000320\b\u0004\u0010\u0013\u001a*\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00120\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014H\u0086H¢\u0006\u0002\u0010\u0018\u001aV\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00020\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00020\u00032$\b\u0004\u0010\u001a\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014H\u0086H¢\u0006\u0002\u0010\u0018\u001a\u0082\u0001\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00120\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0011\"\u0004\b\u0002\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00020\u00032$\b\u0004\u0010\u001a\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00142$\b\u0004\u0010\u001b\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014H\u0086H¢\u0006\u0002\u0010\u001c\u001al\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0011\"\u0018\b\u0002\u0010\u001e*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0011\u0012\u0006\b\u0000\u0012\u0002H\u00020\u001f*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u001e2$\b\u0004\u0010\u001a\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014H\u0086H¢\u0006\u0002\u0010 \u001a\u0098\u0001\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0011\"\u0004\b\u0002\u0010\u0012\"\u0018\b\u0003\u0010\u001e*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0011\u0012\u0006\b\u0000\u0012\u0002H\u00120\u001f*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u001e2$\b\u0004\u0010\u001a\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00142$\b\u0004\u0010\u001b\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014H\u0086H¢\u0006\u0002\u0010!\u001a~\u0010\"\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0011\"\u0004\b\u0002\u0010\u0012\"\u0018\b\u0003\u0010\u001e*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0011\u0012\u0006\b\u0000\u0012\u0002H\u00120\u001f*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u001e20\b\u0004\u0010\u0013\u001a*\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00120\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014H\u0086H¢\u0006\u0002\u0010 \u001aV\u0010#\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00120\u0010\"\u0004\b\u0000\u0010\u0011\"\u0004\b\u0001\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00110\u00032$\b\u0004\u0010$\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014H\u0086H¢\u0006\u0002\u0010\u0018\u001al\u0010%\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u0011\"\u0004\b\u0001\u0010\u0012\"\u0018\b\u0002\u0010\u001e*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0011\u0012\u0006\b\u0000\u0012\u0002H\u00120\u001f*\b\u0012\u0004\u0012\u0002H\u00110\u00032\u0006\u0010\u0004\u001a\u0002H\u001e2$\b\u0004\u0010$\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014H\u0086H¢\u0006\u0002\u0010 \u001a\\\u0010&\u001a\u0014\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00020\u00032$\b\u0004\u0010\u001a\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014H\u0086H¢\u0006\u0002\u0010\u0018\u001a\u0088\u0001\u0010&\u001a\u0014\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u00010\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0011\"\u0004\b\u0002\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00020\u00032$\b\u0004\u0010\u001a\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00142$\b\u0004\u0010\u001b\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014H\u0086H¢\u0006\u0002\u0010\u001c\u001ap\u0010'\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0011\"\u001c\b\u0002\u0010\u001e*\u0016\u0012\u0006\b\u0000\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u001f*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u001e2$\b\u0004\u0010\u001a\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014H\u0086H¢\u0006\u0002\u0010 \u001a\u009c\u0001\u0010'\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0011\"\u0004\b\u0002\u0010\u0012\"\u001c\b\u0003\u0010\u001e*\u0016\u0012\u0006\b\u0000\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u00050\u001f*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u001e2$\b\u0004\u0010\u001a\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00142$\b\u0004\u0010\u001b\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014H\u0086H¢\u0006\u0002\u0010!¨\u0006("}, d2 = {"toList", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", FirebaseAnalytics.Param.DESTINATION, "", "(Lkotlinx/coroutines/flow/Flow;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSet", "", "", "(Lkotlinx/coroutines/flow/Flow;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toCollection", "C", "", "(Lkotlinx/coroutines/flow/Flow;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "associate", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "transform", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lkotlin/Pair;", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "associateBy", "keySelector", "valueTransform", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "associateByTo", "M", "", "(Lkotlinx/coroutines/flow/Flow;Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlinx/coroutines/flow/Flow;Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "associateTo", "associateWith", "valueSelector", "associateWithTo", "groupBy", "groupByTo", "kotlinx-coroutines-core"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__CollectionKt {
    public static final <T> Object toList(Flow<? extends T> flow, List<T> list, Continuation<? super List<? extends T>> continuation) {
        return FlowKt.toCollection(flow, list, continuation);
    }

    public static /* synthetic */ Object toList$default(Flow flow, List list, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        return FlowKt.toList(flow, list, continuation);
    }

    public static final <T> Object toSet(Flow<? extends T> flow, Set<T> set, Continuation<? super Set<? extends T>> continuation) {
        return FlowKt.toCollection(flow, set, continuation);
    }

    public static /* synthetic */ Object toSet$default(Flow flow, Set set, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            set = new LinkedHashSet();
        }
        return FlowKt.toSet(flow, set, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, C extends Collection<? super T>> Object toCollection(Flow<? extends T> flow, final C c, Continuation<? super C> continuation) {
        FlowKt__CollectionKt$toCollection$1 flowKt__CollectionKt$toCollection$1;
        int i;
        if (continuation instanceof FlowKt__CollectionKt$toCollection$1) {
            flowKt__CollectionKt$toCollection$1 = (FlowKt__CollectionKt$toCollection$1) continuation;
            if ((flowKt__CollectionKt$toCollection$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__CollectionKt$toCollection$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__CollectionKt$toCollection$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CollectionKt$toCollection$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    flowKt__CollectionKt$toCollection$1.L$0 = SpillingKt.nullOutSpilledVariable(flow);
                    flowKt__CollectionKt$toCollection$1.L$1 = c;
                    flowKt__CollectionKt$toCollection$1.label = 1;
                    return flow.collect(new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$2
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(T t, Continuation<? super Unit> continuation2) {
                            c.add(t);
                            return Unit.INSTANCE;
                        }
                    }, flowKt__CollectionKt$toCollection$1) == coroutine_suspended ? coroutine_suspended : c;
                } else if (i == 1) {
                    Collection collection = (Collection) flowKt__CollectionKt$toCollection$1.L$1;
                    Flow flow2 = (Flow) flowKt__CollectionKt$toCollection$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    return collection;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        flowKt__CollectionKt$toCollection$1 = new FlowKt__CollectionKt$toCollection$1(continuation);
        Object obj2 = flowKt__CollectionKt$toCollection$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CollectionKt$toCollection$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, K, V> Object associate(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Pair<? extends K, ? extends V>>, ? extends Object> function2, Continuation<? super Map<K, ? extends V>> continuation) {
        FlowKt__CollectionKt$associate$1 flowKt__CollectionKt$associate$1;
        int i;
        if (continuation instanceof FlowKt__CollectionKt$associate$1) {
            flowKt__CollectionKt$associate$1 = (FlowKt__CollectionKt$associate$1) continuation;
            if ((flowKt__CollectionKt$associate$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__CollectionKt$associate$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__CollectionKt$associate$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CollectionKt$associate$1.label;
                if (i == 0) {
                    if (i == 1) {
                        int i2 = flowKt__CollectionKt$associate$1.I$1;
                        int i3 = flowKt__CollectionKt$associate$1.I$0;
                        Map map = (Map) flowKt__CollectionKt$associate$1.L$3;
                        Flow flow2 = (Flow) flowKt__CollectionKt$associate$1.L$2;
                        Function2 function22 = (Function2) flowKt__CollectionKt$associate$1.L$1;
                        Flow flow3 = (Flow) flowKt__CollectionKt$associate$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return map;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                flowKt__CollectionKt$associate$1.L$0 = SpillingKt.nullOutSpilledVariable(flow);
                flowKt__CollectionKt$associate$1.L$1 = SpillingKt.nullOutSpilledVariable(function2);
                flowKt__CollectionKt$associate$1.L$2 = SpillingKt.nullOutSpilledVariable(flow);
                flowKt__CollectionKt$associate$1.L$3 = linkedHashMap;
                flowKt__CollectionKt$associate$1.I$0 = 0;
                flowKt__CollectionKt$associate$1.I$1 = 0;
                flowKt__CollectionKt$associate$1.label = 1;
                return flow.collect(new FlowKt__CollectionKt$associateTo$2<>(linkedHashMap, function2), flowKt__CollectionKt$associate$1) == coroutine_suspended ? coroutine_suspended : linkedHashMap;
            }
        }
        flowKt__CollectionKt$associate$1 = new FlowKt__CollectionKt$associate$1(continuation);
        Object obj2 = flowKt__CollectionKt$associate$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CollectionKt$associate$1.label;
        if (i == 0) {
        }
    }

    private static final <T, K, V> Object associate$$forInline(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Pair<? extends K, ? extends V>>, ? extends Object> function2, Continuation<? super Map<K, ? extends V>> continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        flow.collect(new FlowKt__CollectionKt$associateTo$2(linkedHashMap, function2), continuation);
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, K> Object associateBy(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Continuation<? super Map<K, ? extends T>> continuation) {
        FlowKt__CollectionKt$associateBy$1 flowKt__CollectionKt$associateBy$1;
        int i;
        if (continuation instanceof FlowKt__CollectionKt$associateBy$1) {
            flowKt__CollectionKt$associateBy$1 = (FlowKt__CollectionKt$associateBy$1) continuation;
            if ((flowKt__CollectionKt$associateBy$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__CollectionKt$associateBy$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__CollectionKt$associateBy$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CollectionKt$associateBy$1.label;
                if (i == 0) {
                    if (i == 1) {
                        int i2 = flowKt__CollectionKt$associateBy$1.I$1;
                        int i3 = flowKt__CollectionKt$associateBy$1.I$0;
                        Map map = (Map) flowKt__CollectionKt$associateBy$1.L$3;
                        Flow flow2 = (Flow) flowKt__CollectionKt$associateBy$1.L$2;
                        Function2 function22 = (Function2) flowKt__CollectionKt$associateBy$1.L$1;
                        Flow flow3 = (Flow) flowKt__CollectionKt$associateBy$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return map;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                flowKt__CollectionKt$associateBy$1.L$0 = SpillingKt.nullOutSpilledVariable(flow);
                flowKt__CollectionKt$associateBy$1.L$1 = SpillingKt.nullOutSpilledVariable(function2);
                flowKt__CollectionKt$associateBy$1.L$2 = SpillingKt.nullOutSpilledVariable(flow);
                flowKt__CollectionKt$associateBy$1.L$3 = linkedHashMap;
                flowKt__CollectionKt$associateBy$1.I$0 = 0;
                flowKt__CollectionKt$associateBy$1.I$1 = 0;
                flowKt__CollectionKt$associateBy$1.label = 1;
                return flow.collect(new FlowKt__CollectionKt$associateByTo$2<>(linkedHashMap, function2), flowKt__CollectionKt$associateBy$1) == coroutine_suspended ? coroutine_suspended : linkedHashMap;
            }
        }
        flowKt__CollectionKt$associateBy$1 = new FlowKt__CollectionKt$associateBy$1(continuation);
        Object obj2 = flowKt__CollectionKt$associateBy$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CollectionKt$associateBy$1.label;
        if (i == 0) {
        }
    }

    private static final <T, K> Object associateBy$$forInline(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Continuation<? super Map<K, ? extends T>> continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        flow.collect(new FlowKt__CollectionKt$associateByTo$2(linkedHashMap, function2), continuation);
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, K, V> Object associateBy(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Function2<? super T, ? super Continuation<? super V>, ? extends Object> function22, Continuation<? super Map<K, ? extends V>> continuation) {
        FlowKt__CollectionKt$associateBy$2 flowKt__CollectionKt$associateBy$2;
        int i;
        if (continuation instanceof FlowKt__CollectionKt$associateBy$2) {
            flowKt__CollectionKt$associateBy$2 = (FlowKt__CollectionKt$associateBy$2) continuation;
            if ((flowKt__CollectionKt$associateBy$2.label & Integer.MIN_VALUE) != 0) {
                flowKt__CollectionKt$associateBy$2.label -= Integer.MIN_VALUE;
                Object obj = flowKt__CollectionKt$associateBy$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CollectionKt$associateBy$2.label;
                if (i == 0) {
                    if (i == 1) {
                        int i2 = flowKt__CollectionKt$associateBy$2.I$1;
                        int i3 = flowKt__CollectionKt$associateBy$2.I$0;
                        Map map = (Map) flowKt__CollectionKt$associateBy$2.L$4;
                        Flow flow2 = (Flow) flowKt__CollectionKt$associateBy$2.L$3;
                        Function2 function23 = (Function2) flowKt__CollectionKt$associateBy$2.L$2;
                        Function2 function24 = (Function2) flowKt__CollectionKt$associateBy$2.L$1;
                        Flow flow3 = (Flow) flowKt__CollectionKt$associateBy$2.L$0;
                        ResultKt.throwOnFailure(obj);
                        return map;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                flowKt__CollectionKt$associateBy$2.L$0 = SpillingKt.nullOutSpilledVariable(flow);
                flowKt__CollectionKt$associateBy$2.L$1 = SpillingKt.nullOutSpilledVariable(function2);
                flowKt__CollectionKt$associateBy$2.L$2 = SpillingKt.nullOutSpilledVariable(function22);
                flowKt__CollectionKt$associateBy$2.L$3 = SpillingKt.nullOutSpilledVariable(flow);
                flowKt__CollectionKt$associateBy$2.L$4 = linkedHashMap;
                flowKt__CollectionKt$associateBy$2.I$0 = 0;
                flowKt__CollectionKt$associateBy$2.I$1 = 0;
                flowKt__CollectionKt$associateBy$2.label = 1;
                return flow.collect(new FlowKt__CollectionKt$associateByTo$4<>(linkedHashMap, function2, function22), flowKt__CollectionKt$associateBy$2) == coroutine_suspended ? coroutine_suspended : linkedHashMap;
            }
        }
        flowKt__CollectionKt$associateBy$2 = new FlowKt__CollectionKt$associateBy$2(continuation);
        Object obj2 = flowKt__CollectionKt$associateBy$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CollectionKt$associateBy$2.label;
        if (i == 0) {
        }
    }

    private static final <T, K, V> Object associateBy$$forInline(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Function2<? super T, ? super Continuation<? super V>, ? extends Object> function22, Continuation<? super Map<K, ? extends V>> continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        flow.collect(new FlowKt__CollectionKt$associateByTo$4(linkedHashMap, function2, function22), continuation);
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, K, M extends Map<? super K, ? super T>> Object associateByTo(Flow<? extends T> flow, M m, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Continuation<? super M> continuation) {
        FlowKt__CollectionKt$associateByTo$1 flowKt__CollectionKt$associateByTo$1;
        int i;
        if (continuation instanceof FlowKt__CollectionKt$associateByTo$1) {
            flowKt__CollectionKt$associateByTo$1 = (FlowKt__CollectionKt$associateByTo$1) continuation;
            if ((flowKt__CollectionKt$associateByTo$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__CollectionKt$associateByTo$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__CollectionKt$associateByTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CollectionKt$associateByTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    flowKt__CollectionKt$associateByTo$1.L$0 = SpillingKt.nullOutSpilledVariable(flow);
                    flowKt__CollectionKt$associateByTo$1.L$1 = m;
                    flowKt__CollectionKt$associateByTo$1.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                    flowKt__CollectionKt$associateByTo$1.I$0 = 0;
                    flowKt__CollectionKt$associateByTo$1.label = 1;
                    return flow.collect(new FlowKt__CollectionKt$associateByTo$2<>(m, function2), flowKt__CollectionKt$associateByTo$1) == coroutine_suspended ? coroutine_suspended : m;
                } else if (i == 1) {
                    int i2 = flowKt__CollectionKt$associateByTo$1.I$0;
                    Function2 function22 = (Function2) flowKt__CollectionKt$associateByTo$1.L$2;
                    Map map = (Map) flowKt__CollectionKt$associateByTo$1.L$1;
                    Flow flow2 = (Flow) flowKt__CollectionKt$associateByTo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    return map;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        flowKt__CollectionKt$associateByTo$1 = new FlowKt__CollectionKt$associateByTo$1(continuation);
        Object obj2 = flowKt__CollectionKt$associateByTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CollectionKt$associateByTo$1.label;
        if (i != 0) {
        }
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    private static final <T, K, M extends java.util.Map<? super K, ? super T>> java.lang.Object associateByTo$$forInline(kotlinx.coroutines.flow.Flow<? extends T> r1, M r2, kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super K>, ? extends java.lang.Object> r3, kotlin.coroutines.Continuation<? super M> r4) {
        /*
            kotlinx.coroutines.flow.FlowKt__CollectionKt$associateByTo$2 r0 = new kotlinx.coroutines.flow.FlowKt__CollectionKt$associateByTo$2
            r0.<init>(r2, r3)
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            r1.collect(r0, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__CollectionKt.associateByTo$$forInline(kotlinx.coroutines.flow.Flow, java.util.Map, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, K, V, M extends Map<? super K, ? super V>> Object associateByTo(Flow<? extends T> flow, M m, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Function2<? super T, ? super Continuation<? super V>, ? extends Object> function22, Continuation<? super M> continuation) {
        FlowKt__CollectionKt$associateByTo$3 flowKt__CollectionKt$associateByTo$3;
        int i;
        if (continuation instanceof FlowKt__CollectionKt$associateByTo$3) {
            flowKt__CollectionKt$associateByTo$3 = (FlowKt__CollectionKt$associateByTo$3) continuation;
            if ((flowKt__CollectionKt$associateByTo$3.label & Integer.MIN_VALUE) != 0) {
                flowKt__CollectionKt$associateByTo$3.label -= Integer.MIN_VALUE;
                Object obj = flowKt__CollectionKt$associateByTo$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CollectionKt$associateByTo$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    flowKt__CollectionKt$associateByTo$3.L$0 = SpillingKt.nullOutSpilledVariable(flow);
                    flowKt__CollectionKt$associateByTo$3.L$1 = m;
                    flowKt__CollectionKt$associateByTo$3.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                    flowKt__CollectionKt$associateByTo$3.L$3 = SpillingKt.nullOutSpilledVariable(function22);
                    flowKt__CollectionKt$associateByTo$3.I$0 = 0;
                    flowKt__CollectionKt$associateByTo$3.label = 1;
                    return flow.collect(new FlowKt__CollectionKt$associateByTo$4<>(m, function2, function22), flowKt__CollectionKt$associateByTo$3) == coroutine_suspended ? coroutine_suspended : m;
                } else if (i == 1) {
                    int i2 = flowKt__CollectionKt$associateByTo$3.I$0;
                    Function2 function23 = (Function2) flowKt__CollectionKt$associateByTo$3.L$3;
                    Function2 function24 = (Function2) flowKt__CollectionKt$associateByTo$3.L$2;
                    Map map = (Map) flowKt__CollectionKt$associateByTo$3.L$1;
                    Flow flow2 = (Flow) flowKt__CollectionKt$associateByTo$3.L$0;
                    ResultKt.throwOnFailure(obj);
                    return map;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        flowKt__CollectionKt$associateByTo$3 = new FlowKt__CollectionKt$associateByTo$3(continuation);
        Object obj2 = flowKt__CollectionKt$associateByTo$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CollectionKt$associateByTo$3.label;
        if (i != 0) {
        }
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    private static final <T, K, V, M extends java.util.Map<? super K, ? super V>> java.lang.Object associateByTo$$forInline(kotlinx.coroutines.flow.Flow<? extends T> r1, M r2, kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super K>, ? extends java.lang.Object> r3, kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super V>, ? extends java.lang.Object> r4, kotlin.coroutines.Continuation<? super M> r5) {
        /*
            kotlinx.coroutines.flow.FlowKt__CollectionKt$associateByTo$4 r0 = new kotlinx.coroutines.flow.FlowKt__CollectionKt$associateByTo$4
            r0.<init>(r2, r3, r4)
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            r1.collect(r0, r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__CollectionKt.associateByTo$$forInline(kotlinx.coroutines.flow.Flow, java.util.Map, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, K, V, M extends Map<? super K, ? super V>> Object associateTo(Flow<? extends T> flow, M m, Function2<? super T, ? super Continuation<? super Pair<? extends K, ? extends V>>, ? extends Object> function2, Continuation<? super M> continuation) {
        FlowKt__CollectionKt$associateTo$1 flowKt__CollectionKt$associateTo$1;
        int i;
        if (continuation instanceof FlowKt__CollectionKt$associateTo$1) {
            flowKt__CollectionKt$associateTo$1 = (FlowKt__CollectionKt$associateTo$1) continuation;
            if ((flowKt__CollectionKt$associateTo$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__CollectionKt$associateTo$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__CollectionKt$associateTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CollectionKt$associateTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    flowKt__CollectionKt$associateTo$1.L$0 = SpillingKt.nullOutSpilledVariable(flow);
                    flowKt__CollectionKt$associateTo$1.L$1 = m;
                    flowKt__CollectionKt$associateTo$1.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                    flowKt__CollectionKt$associateTo$1.I$0 = 0;
                    flowKt__CollectionKt$associateTo$1.label = 1;
                    return flow.collect(new FlowKt__CollectionKt$associateTo$2<>(m, function2), flowKt__CollectionKt$associateTo$1) == coroutine_suspended ? coroutine_suspended : m;
                } else if (i == 1) {
                    int i2 = flowKt__CollectionKt$associateTo$1.I$0;
                    Function2 function22 = (Function2) flowKt__CollectionKt$associateTo$1.L$2;
                    Map map = (Map) flowKt__CollectionKt$associateTo$1.L$1;
                    Flow flow2 = (Flow) flowKt__CollectionKt$associateTo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    return map;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        flowKt__CollectionKt$associateTo$1 = new FlowKt__CollectionKt$associateTo$1(continuation);
        Object obj2 = flowKt__CollectionKt$associateTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CollectionKt$associateTo$1.label;
        if (i != 0) {
        }
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    private static final <T, K, V, M extends java.util.Map<? super K, ? super V>> java.lang.Object associateTo$$forInline(kotlinx.coroutines.flow.Flow<? extends T> r1, M r2, kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super kotlin.Pair<? extends K, ? extends V>>, ? extends java.lang.Object> r3, kotlin.coroutines.Continuation<? super M> r4) {
        /*
            kotlinx.coroutines.flow.FlowKt__CollectionKt$associateTo$2 r0 = new kotlinx.coroutines.flow.FlowKt__CollectionKt$associateTo$2
            r0.<init>(r2, r3)
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            r1.collect(r0, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__CollectionKt.associateTo$$forInline(kotlinx.coroutines.flow.Flow, java.util.Map, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <K, V> Object associateWith(Flow<? extends K> flow, Function2<? super K, ? super Continuation<? super V>, ? extends Object> function2, Continuation<? super Map<K, ? extends V>> continuation) {
        FlowKt__CollectionKt$associateWith$1 flowKt__CollectionKt$associateWith$1;
        int i;
        if (continuation instanceof FlowKt__CollectionKt$associateWith$1) {
            flowKt__CollectionKt$associateWith$1 = (FlowKt__CollectionKt$associateWith$1) continuation;
            if ((flowKt__CollectionKt$associateWith$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__CollectionKt$associateWith$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__CollectionKt$associateWith$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CollectionKt$associateWith$1.label;
                if (i == 0) {
                    if (i == 1) {
                        int i2 = flowKt__CollectionKt$associateWith$1.I$1;
                        int i3 = flowKt__CollectionKt$associateWith$1.I$0;
                        Map map = (Map) flowKt__CollectionKt$associateWith$1.L$3;
                        Flow flow2 = (Flow) flowKt__CollectionKt$associateWith$1.L$2;
                        Function2 function22 = (Function2) flowKt__CollectionKt$associateWith$1.L$1;
                        Flow flow3 = (Flow) flowKt__CollectionKt$associateWith$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return map;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                flowKt__CollectionKt$associateWith$1.L$0 = SpillingKt.nullOutSpilledVariable(flow);
                flowKt__CollectionKt$associateWith$1.L$1 = SpillingKt.nullOutSpilledVariable(function2);
                flowKt__CollectionKt$associateWith$1.L$2 = SpillingKt.nullOutSpilledVariable(flow);
                flowKt__CollectionKt$associateWith$1.L$3 = linkedHashMap;
                flowKt__CollectionKt$associateWith$1.I$0 = 0;
                flowKt__CollectionKt$associateWith$1.I$1 = 0;
                flowKt__CollectionKt$associateWith$1.label = 1;
                return flow.collect(new FlowKt__CollectionKt$associateWithTo$2<>(linkedHashMap, function2), flowKt__CollectionKt$associateWith$1) == coroutine_suspended ? coroutine_suspended : linkedHashMap;
            }
        }
        flowKt__CollectionKt$associateWith$1 = new FlowKt__CollectionKt$associateWith$1(continuation);
        Object obj2 = flowKt__CollectionKt$associateWith$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CollectionKt$associateWith$1.label;
        if (i == 0) {
        }
    }

    private static final <K, V> Object associateWith$$forInline(Flow<? extends K> flow, Function2<? super K, ? super Continuation<? super V>, ? extends Object> function2, Continuation<? super Map<K, ? extends V>> continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        flow.collect(new FlowKt__CollectionKt$associateWithTo$2(linkedHashMap, function2), continuation);
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <K, V, M extends Map<? super K, ? super V>> Object associateWithTo(Flow<? extends K> flow, M m, Function2<? super K, ? super Continuation<? super V>, ? extends Object> function2, Continuation<? super M> continuation) {
        FlowKt__CollectionKt$associateWithTo$1 flowKt__CollectionKt$associateWithTo$1;
        int i;
        if (continuation instanceof FlowKt__CollectionKt$associateWithTo$1) {
            flowKt__CollectionKt$associateWithTo$1 = (FlowKt__CollectionKt$associateWithTo$1) continuation;
            if ((flowKt__CollectionKt$associateWithTo$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__CollectionKt$associateWithTo$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__CollectionKt$associateWithTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CollectionKt$associateWithTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    flowKt__CollectionKt$associateWithTo$1.L$0 = SpillingKt.nullOutSpilledVariable(flow);
                    flowKt__CollectionKt$associateWithTo$1.L$1 = m;
                    flowKt__CollectionKt$associateWithTo$1.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                    flowKt__CollectionKt$associateWithTo$1.I$0 = 0;
                    flowKt__CollectionKt$associateWithTo$1.label = 1;
                    return flow.collect(new FlowKt__CollectionKt$associateWithTo$2<>(m, function2), flowKt__CollectionKt$associateWithTo$1) == coroutine_suspended ? coroutine_suspended : m;
                } else if (i == 1) {
                    int i2 = flowKt__CollectionKt$associateWithTo$1.I$0;
                    Function2 function22 = (Function2) flowKt__CollectionKt$associateWithTo$1.L$2;
                    Map map = (Map) flowKt__CollectionKt$associateWithTo$1.L$1;
                    Flow flow2 = (Flow) flowKt__CollectionKt$associateWithTo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    return map;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        flowKt__CollectionKt$associateWithTo$1 = new FlowKt__CollectionKt$associateWithTo$1(continuation);
        Object obj2 = flowKt__CollectionKt$associateWithTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CollectionKt$associateWithTo$1.label;
        if (i != 0) {
        }
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    private static final <K, V, M extends java.util.Map<? super K, ? super V>> java.lang.Object associateWithTo$$forInline(kotlinx.coroutines.flow.Flow<? extends K> r1, M r2, kotlin.jvm.functions.Function2<? super K, ? super kotlin.coroutines.Continuation<? super V>, ? extends java.lang.Object> r3, kotlin.coroutines.Continuation<? super M> r4) {
        /*
            kotlinx.coroutines.flow.FlowKt__CollectionKt$associateWithTo$2 r0 = new kotlinx.coroutines.flow.FlowKt__CollectionKt$associateWithTo$2
            r0.<init>(r2, r3)
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            r1.collect(r0, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__CollectionKt.associateWithTo$$forInline(kotlinx.coroutines.flow.Flow, java.util.Map, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, K> Object groupBy(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Continuation<? super Map<K, ? extends List<? extends T>>> continuation) {
        FlowKt__CollectionKt$groupBy$1 flowKt__CollectionKt$groupBy$1;
        int i;
        if (continuation instanceof FlowKt__CollectionKt$groupBy$1) {
            flowKt__CollectionKt$groupBy$1 = (FlowKt__CollectionKt$groupBy$1) continuation;
            if ((flowKt__CollectionKt$groupBy$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__CollectionKt$groupBy$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__CollectionKt$groupBy$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CollectionKt$groupBy$1.label;
                if (i == 0) {
                    if (i == 1) {
                        int i2 = flowKt__CollectionKt$groupBy$1.I$1;
                        int i3 = flowKt__CollectionKt$groupBy$1.I$0;
                        Map map = (Map) flowKt__CollectionKt$groupBy$1.L$3;
                        Flow flow2 = (Flow) flowKt__CollectionKt$groupBy$1.L$2;
                        Function2 function22 = (Function2) flowKt__CollectionKt$groupBy$1.L$1;
                        Flow flow3 = (Flow) flowKt__CollectionKt$groupBy$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return map;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                flowKt__CollectionKt$groupBy$1.L$0 = SpillingKt.nullOutSpilledVariable(flow);
                flowKt__CollectionKt$groupBy$1.L$1 = SpillingKt.nullOutSpilledVariable(function2);
                flowKt__CollectionKt$groupBy$1.L$2 = SpillingKt.nullOutSpilledVariable(flow);
                flowKt__CollectionKt$groupBy$1.L$3 = linkedHashMap;
                flowKt__CollectionKt$groupBy$1.I$0 = 0;
                flowKt__CollectionKt$groupBy$1.I$1 = 0;
                flowKt__CollectionKt$groupBy$1.label = 1;
                return flow.collect(new FlowKt__CollectionKt$groupByTo$2<>(function2, linkedHashMap), flowKt__CollectionKt$groupBy$1) == coroutine_suspended ? coroutine_suspended : linkedHashMap;
            }
        }
        flowKt__CollectionKt$groupBy$1 = new FlowKt__CollectionKt$groupBy$1(continuation);
        Object obj2 = flowKt__CollectionKt$groupBy$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CollectionKt$groupBy$1.label;
        if (i == 0) {
        }
    }

    private static final <T, K> Object groupBy$$forInline(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Continuation<? super Map<K, ? extends List<? extends T>>> continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        flow.collect(new FlowKt__CollectionKt$groupByTo$2(function2, linkedHashMap), continuation);
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, K, V> Object groupBy(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Function2<? super T, ? super Continuation<? super V>, ? extends Object> function22, Continuation<? super Map<K, ? extends List<? extends V>>> continuation) {
        FlowKt__CollectionKt$groupBy$2 flowKt__CollectionKt$groupBy$2;
        int i;
        if (continuation instanceof FlowKt__CollectionKt$groupBy$2) {
            flowKt__CollectionKt$groupBy$2 = (FlowKt__CollectionKt$groupBy$2) continuation;
            if ((flowKt__CollectionKt$groupBy$2.label & Integer.MIN_VALUE) != 0) {
                flowKt__CollectionKt$groupBy$2.label -= Integer.MIN_VALUE;
                Object obj = flowKt__CollectionKt$groupBy$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CollectionKt$groupBy$2.label;
                if (i == 0) {
                    if (i == 1) {
                        int i2 = flowKt__CollectionKt$groupBy$2.I$1;
                        int i3 = flowKt__CollectionKt$groupBy$2.I$0;
                        Map map = (Map) flowKt__CollectionKt$groupBy$2.L$4;
                        Flow flow2 = (Flow) flowKt__CollectionKt$groupBy$2.L$3;
                        Function2 function23 = (Function2) flowKt__CollectionKt$groupBy$2.L$2;
                        Function2 function24 = (Function2) flowKt__CollectionKt$groupBy$2.L$1;
                        Flow flow3 = (Flow) flowKt__CollectionKt$groupBy$2.L$0;
                        ResultKt.throwOnFailure(obj);
                        return map;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                flowKt__CollectionKt$groupBy$2.L$0 = SpillingKt.nullOutSpilledVariable(flow);
                flowKt__CollectionKt$groupBy$2.L$1 = SpillingKt.nullOutSpilledVariable(function2);
                flowKt__CollectionKt$groupBy$2.L$2 = SpillingKt.nullOutSpilledVariable(function22);
                flowKt__CollectionKt$groupBy$2.L$3 = SpillingKt.nullOutSpilledVariable(flow);
                flowKt__CollectionKt$groupBy$2.L$4 = linkedHashMap;
                flowKt__CollectionKt$groupBy$2.I$0 = 0;
                flowKt__CollectionKt$groupBy$2.I$1 = 0;
                flowKt__CollectionKt$groupBy$2.label = 1;
                return flow.collect(new FlowKt__CollectionKt$groupByTo$4<>(function2, linkedHashMap, function22), flowKt__CollectionKt$groupBy$2) == coroutine_suspended ? coroutine_suspended : linkedHashMap;
            }
        }
        flowKt__CollectionKt$groupBy$2 = new FlowKt__CollectionKt$groupBy$2(continuation);
        Object obj2 = flowKt__CollectionKt$groupBy$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CollectionKt$groupBy$2.label;
        if (i == 0) {
        }
    }

    private static final <T, K, V> Object groupBy$$forInline(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Function2<? super T, ? super Continuation<? super V>, ? extends Object> function22, Continuation<? super Map<K, ? extends List<? extends V>>> continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        flow.collect(new FlowKt__CollectionKt$groupByTo$4(function2, linkedHashMap, function22), continuation);
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, K, M extends Map<? super K, List<T>>> Object groupByTo(Flow<? extends T> flow, M m, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Continuation<? super M> continuation) {
        FlowKt__CollectionKt$groupByTo$1 flowKt__CollectionKt$groupByTo$1;
        int i;
        if (continuation instanceof FlowKt__CollectionKt$groupByTo$1) {
            flowKt__CollectionKt$groupByTo$1 = (FlowKt__CollectionKt$groupByTo$1) continuation;
            if ((flowKt__CollectionKt$groupByTo$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__CollectionKt$groupByTo$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__CollectionKt$groupByTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CollectionKt$groupByTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    flowKt__CollectionKt$groupByTo$1.L$0 = SpillingKt.nullOutSpilledVariable(flow);
                    flowKt__CollectionKt$groupByTo$1.L$1 = m;
                    flowKt__CollectionKt$groupByTo$1.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                    flowKt__CollectionKt$groupByTo$1.I$0 = 0;
                    flowKt__CollectionKt$groupByTo$1.label = 1;
                    return flow.collect(new FlowKt__CollectionKt$groupByTo$2<>(function2, m), flowKt__CollectionKt$groupByTo$1) == coroutine_suspended ? coroutine_suspended : m;
                } else if (i == 1) {
                    int i2 = flowKt__CollectionKt$groupByTo$1.I$0;
                    Function2 function22 = (Function2) flowKt__CollectionKt$groupByTo$1.L$2;
                    Map map = (Map) flowKt__CollectionKt$groupByTo$1.L$1;
                    Flow flow2 = (Flow) flowKt__CollectionKt$groupByTo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    return map;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        flowKt__CollectionKt$groupByTo$1 = new FlowKt__CollectionKt$groupByTo$1(continuation);
        Object obj2 = flowKt__CollectionKt$groupByTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CollectionKt$groupByTo$1.label;
        if (i != 0) {
        }
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    private static final <T, K, M extends java.util.Map<? super K, java.util.List<T>>> java.lang.Object groupByTo$$forInline(kotlinx.coroutines.flow.Flow<? extends T> r1, M r2, kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super K>, ? extends java.lang.Object> r3, kotlin.coroutines.Continuation<? super M> r4) {
        /*
            kotlinx.coroutines.flow.FlowKt__CollectionKt$groupByTo$2 r0 = new kotlinx.coroutines.flow.FlowKt__CollectionKt$groupByTo$2
            r0.<init>(r3, r2)
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            r1.collect(r0, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__CollectionKt.groupByTo$$forInline(kotlinx.coroutines.flow.Flow, java.util.Map, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, K, V, M extends Map<? super K, List<V>>> Object groupByTo(Flow<? extends T> flow, M m, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Function2<? super T, ? super Continuation<? super V>, ? extends Object> function22, Continuation<? super M> continuation) {
        FlowKt__CollectionKt$groupByTo$3 flowKt__CollectionKt$groupByTo$3;
        int i;
        if (continuation instanceof FlowKt__CollectionKt$groupByTo$3) {
            flowKt__CollectionKt$groupByTo$3 = (FlowKt__CollectionKt$groupByTo$3) continuation;
            if ((flowKt__CollectionKt$groupByTo$3.label & Integer.MIN_VALUE) != 0) {
                flowKt__CollectionKt$groupByTo$3.label -= Integer.MIN_VALUE;
                Object obj = flowKt__CollectionKt$groupByTo$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CollectionKt$groupByTo$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    flowKt__CollectionKt$groupByTo$3.L$0 = SpillingKt.nullOutSpilledVariable(flow);
                    flowKt__CollectionKt$groupByTo$3.L$1 = m;
                    flowKt__CollectionKt$groupByTo$3.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                    flowKt__CollectionKt$groupByTo$3.L$3 = SpillingKt.nullOutSpilledVariable(function22);
                    flowKt__CollectionKt$groupByTo$3.I$0 = 0;
                    flowKt__CollectionKt$groupByTo$3.label = 1;
                    return flow.collect(new FlowKt__CollectionKt$groupByTo$4<>(function2, m, function22), flowKt__CollectionKt$groupByTo$3) == coroutine_suspended ? coroutine_suspended : m;
                } else if (i == 1) {
                    int i2 = flowKt__CollectionKt$groupByTo$3.I$0;
                    Function2 function23 = (Function2) flowKt__CollectionKt$groupByTo$3.L$3;
                    Function2 function24 = (Function2) flowKt__CollectionKt$groupByTo$3.L$2;
                    Map map = (Map) flowKt__CollectionKt$groupByTo$3.L$1;
                    Flow flow2 = (Flow) flowKt__CollectionKt$groupByTo$3.L$0;
                    ResultKt.throwOnFailure(obj);
                    return map;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        flowKt__CollectionKt$groupByTo$3 = new FlowKt__CollectionKt$groupByTo$3(continuation);
        Object obj2 = flowKt__CollectionKt$groupByTo$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CollectionKt$groupByTo$3.label;
        if (i != 0) {
        }
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    private static final <T, K, V, M extends java.util.Map<? super K, java.util.List<V>>> java.lang.Object groupByTo$$forInline(kotlinx.coroutines.flow.Flow<? extends T> r1, M r2, kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super K>, ? extends java.lang.Object> r3, kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super V>, ? extends java.lang.Object> r4, kotlin.coroutines.Continuation<? super M> r5) {
        /*
            kotlinx.coroutines.flow.FlowKt__CollectionKt$groupByTo$4 r0 = new kotlinx.coroutines.flow.FlowKt__CollectionKt$groupByTo$4
            r0.<init>(r3, r2, r4)
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            r1.collect(r0, r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__CollectionKt.groupByTo$$forInline(kotlinx.coroutines.flow.Flow, java.util.Map, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
