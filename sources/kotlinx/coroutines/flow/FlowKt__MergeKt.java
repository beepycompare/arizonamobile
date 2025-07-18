package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.internal.ChannelFlowMerge;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge;
import kotlinx.coroutines.internal.SystemPropsKt;
/* compiled from: Merge.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ab\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\f0\n27\u0010\r\u001a3\b\u0001\u0012\u0013\u0012\u0011H\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\n0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000eH\u0007¢\u0006\u0002\u0010\u0014\u001al\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\f0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u000527\u0010\r\u001a3\b\u0001\u0012\u0013\u0012\u0011H\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\n0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000eH\u0007¢\u0006\u0002\u0010\u0017\u001a$\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\f0\n\"\u0004\b\u0000\u0010\f*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\n0\nH\u0007\u001a\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\f0\n\"\u0004\b\u0000\u0010\f*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\n0\u001a\u001a7\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\f0\n\"\u0004\b\u0000\u0010\f2\u001e\u0010\u001b\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\f0\n0\u001c\"\b\u0012\u0004\u0012\u0002H\f0\n¢\u0006\u0002\u0010\u001d\u001a.\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\f0\n\"\u0004\b\u0000\u0010\f*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\n0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u0005H\u0007\u001ao\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\f0\n2D\b\u0001\u0010\r\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0!\u0012\u0013\u0012\u0011H\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130 ¢\u0006\u0002\b#H\u0007¢\u0006\u0002\u0010$\u001ae\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\f0\n29\b\u0005\u0010\r\u001a3\b\u0001\u0012\u0013\u0012\u0011H\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\n0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000eH\u0087\b¢\u0006\u0002\u0010\u0014\u001a^\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\f0\n23\b\u0001\u0010\r\u001a-\b\u0001\u0012\u0013\u0012\u0011H\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000eH\u0007¢\u0006\u0002\u0010\u0014\"\u0016\u0010\u0000\u001a\u00020\u00018\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006'"}, d2 = {"DEFAULT_CONCURRENCY_PROPERTY_NAME", "", "getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations", "()V", "DEFAULT_CONCURRENCY", "", "getDEFAULT_CONCURRENCY$annotations", "getDEFAULT_CONCURRENCY", "()I", "flatMapConcat", "Lkotlinx/coroutines/flow/Flow;", "R", ExifInterface.GPS_DIRECTION_TRUE, "transform", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "flatMapMerge", "concurrency", "(Lkotlinx/coroutines/flow/Flow;ILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "flattenConcat", "merge", "", "flows", "", "([Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "flattenMerge", "transformLatest", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "flatMapLatest", "mapLatest", "kotlinx-coroutines-core"}, k = 5, mv = {2, 1, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__MergeKt {
    private static final int DEFAULT_CONCURRENCY = SystemPropsKt.systemProp(FlowKt.DEFAULT_CONCURRENCY_PROPERTY_NAME, 16, 1, Integer.MAX_VALUE);

    public static /* synthetic */ void getDEFAULT_CONCURRENCY$annotations() {
    }

    public static /* synthetic */ void getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations() {
    }

    public static final int getDEFAULT_CONCURRENCY() {
        return DEFAULT_CONCURRENCY;
    }

    public static /* synthetic */ Flow flatMapMerge$default(Flow flow, int i, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = DEFAULT_CONCURRENCY;
        }
        return FlowKt.flatMapMerge(flow, i, function2);
    }

    public static final <T> Flow<T> merge(Iterable<? extends Flow<? extends T>> iterable) {
        return new ChannelLimitedFlowMerge(iterable, null, 0, null, 14, null);
    }

    public static final <T> Flow<T> merge(Flow<? extends T>... flowArr) {
        return FlowKt.merge(ArraysKt.asIterable(flowArr));
    }

    public static /* synthetic */ Flow flattenMerge$default(Flow flow, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = DEFAULT_CONCURRENCY;
        }
        return FlowKt.flattenMerge(flow, i);
    }

    public static final <T> Flow<T> flattenMerge(Flow<? extends Flow<? extends T>> flow, int i) {
        if (i > 0) {
            return i == 1 ? FlowKt.flattenConcat(flow) : new ChannelFlowMerge(flow, i, null, 0, null, 28, null);
        }
        throw new IllegalArgumentException(("Expected positive concurrency level, but had " + i).toString());
    }

    public static final <T, R> Flow<R> transformLatest(Flow<? extends T> flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return new ChannelFlowTransformLatest(function3, flow, null, 0, null, 28, null);
    }

    public static final <T, R> Flow<R> flatMapLatest(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt.transformLatest(flow, new FlowKt__MergeKt$flatMapLatest$1(function2, null));
    }

    public static final <T, R> Flow<R> mapLatest(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return FlowKt.transformLatest(flow, new FlowKt__MergeKt$mapLatest$1(function2, null));
    }

    public static final <T, R> Flow<R> flatMapConcat(final Flow<? extends T> flow, final Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt.flattenConcat(new Flow<Flow<? extends R>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ Function2 $transform$inlined;

                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2", f = "Merge.kt", i = {}, l = {50, 50}, m = "emit", n = {}, s = {})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Function2 function2) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$transform$inlined = function2;
                }

                /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
                    if (r7.emit(r8, r0) != r1) goto L11;
                 */
                /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
                /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i;
                    FlowCollector flowCollector;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.label;
                            if (i != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector2 = this.$this_unsafeFlow;
                                Function2 function2 = this.$transform$inlined;
                                anonymousClass1.L$0 = flowCollector2;
                                anonymousClass1.label = 1;
                                Object invoke = function2.invoke(obj, anonymousClass1);
                                if (invoke != coroutine_suspended) {
                                    obj2 = invoke;
                                    flowCollector = flowCollector2;
                                }
                                return coroutine_suspended;
                            } else if (i != 1) {
                                if (i == 2) {
                                    ResultKt.throwOnFailure(obj2);
                                    return Unit.INSTANCE;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                flowCollector = (FlowCollector) anonymousClass1.L$0;
                                ResultKt.throwOnFailure(obj2);
                            }
                            anonymousClass1.L$0 = null;
                            anonymousClass1.label = 2;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.label;
                    if (i != 0) {
                    }
                    anonymousClass1.L$0 = null;
                    anonymousClass1.label = 2;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, function2), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        });
    }

    public static final <T, R> Flow<R> flatMapMerge(final Flow<? extends T> flow, int i, final Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt.flattenMerge(new Flow<Flow<? extends R>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ Function2 $transform$inlined;

                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2", f = "Merge.kt", i = {}, l = {50, 50}, m = "emit", n = {}, s = {})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Function2 function2) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$transform$inlined = function2;
                }

                /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
                    if (r7.emit(r8, r0) != r1) goto L11;
                 */
                /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
                /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i;
                    FlowCollector flowCollector;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.label;
                            if (i != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector2 = this.$this_unsafeFlow;
                                Function2 function2 = this.$transform$inlined;
                                anonymousClass1.L$0 = flowCollector2;
                                anonymousClass1.label = 1;
                                Object invoke = function2.invoke(obj, anonymousClass1);
                                if (invoke != coroutine_suspended) {
                                    obj2 = invoke;
                                    flowCollector = flowCollector2;
                                }
                                return coroutine_suspended;
                            } else if (i != 1) {
                                if (i == 2) {
                                    ResultKt.throwOnFailure(obj2);
                                    return Unit.INSTANCE;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                flowCollector = (FlowCollector) anonymousClass1.L$0;
                                ResultKt.throwOnFailure(obj2);
                            }
                            anonymousClass1.L$0 = null;
                            anonymousClass1.label = 2;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.label;
                    if (i != 0) {
                    }
                    anonymousClass1.L$0 = null;
                    anonymousClass1.label = 2;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, function2), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }, i);
    }

    public static final <T> Flow<T> flattenConcat(final Flow<? extends Flow<? extends T>> flow) {
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flattenConcat$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
                Object collect = Flow.this.collect(new FlowKt__MergeKt$flattenConcat$1$1(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
    }
}
