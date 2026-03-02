package androidx.paging;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
/* compiled from: PagingDataTransforms.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001ag\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004\"\b\b\u0001\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u000120\b\u0004\u0010\u0000\u001a*\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00060\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0005H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\b\u001aU\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004\"\b\b\u0001\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u00012\"\u0010\u0000\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0005H\u0007¢\u0006\u0002\u0010\b\u001a[\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004\"\b\b\u0001\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u00012(\u0010\u0000\u001a$\b\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u000b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0005H\u0007¢\u0006\u0002\u0010\b\u001aK\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u00012\"\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0005H\u0007¢\u0006\u0002\u0010\b\u001ak\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0003*\u0002H\u0002\"\b\b\u0001\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00112.\u0010\u0012\u001a*\b\u0001\u0012\u0006\u0012\u0004\u0018\u0001H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001a9\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u0002H\u0003H\u0007¢\u0006\u0002\u0010\u0017\u001a9\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u0002H\u0003H\u0007¢\u0006\u0002\u0010\u0017\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0019"}, d2 = {"transform", "Landroidx/paging/PagingData;", "R", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/Function2;", "Landroidx/paging/PageEvent;", "Lkotlin/coroutines/Continuation;", "(Landroidx/paging/PagingData;Lkotlin/jvm/functions/Function2;)Landroidx/paging/PagingData;", "map", "flatMap", "", "filter", "predicate", "", "insertSeparators", "terminalSeparatorType", "Landroidx/paging/TerminalSeparatorType;", "generator", "Lkotlin/Function3;", "(Landroidx/paging/PagingData;Landroidx/paging/TerminalSeparatorType;Lkotlin/jvm/functions/Function3;)Landroidx/paging/PagingData;", "insertHeaderItem", "item", "(Landroidx/paging/PagingData;Landroidx/paging/TerminalSeparatorType;Ljava/lang/Object;)Landroidx/paging/PagingData;", "insertFooterItem", "paging-common"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "androidx/paging/PagingDataTransforms")
/* loaded from: classes3.dex */
public final /* synthetic */ class PagingDataTransforms__PagingDataTransformsKt {
    public static final <T> PagingData<T> insertFooterItem(PagingData<T> pagingData, T item) {
        PagingData<T> insertFooterItem$default;
        Intrinsics.checkNotNullParameter(pagingData, "<this>");
        Intrinsics.checkNotNullParameter(item, "item");
        insertFooterItem$default = insertFooterItem$default(pagingData, null, item, 1, null);
        return insertFooterItem$default;
    }

    public static final <T> PagingData<T> insertHeaderItem(PagingData<T> pagingData, T item) {
        PagingData<T> insertHeaderItem$default;
        Intrinsics.checkNotNullParameter(pagingData, "<this>");
        Intrinsics.checkNotNullParameter(item, "item");
        insertHeaderItem$default = insertHeaderItem$default(pagingData, null, item, 1, null);
        return insertHeaderItem$default;
    }

    public static final <T, R> PagingData<R> transform(PagingData<T> pagingData, Function2<? super PageEvent<T>, ? super Continuation<? super PageEvent<R>>, ? extends Object> transform) {
        Intrinsics.checkNotNullParameter(pagingData, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return new PagingData<>(new PagingDataTransforms__PagingDataTransformsKt$transform$$inlined$map$1(pagingData.getFlow$paging_common(), transform), pagingData.getUiReceiver$paging_common(), pagingData.getHintReceiver$paging_common(), null, 8, null);
    }

    public static /* synthetic */ PagingData insertSeparators$default(PagingData pagingData, TerminalSeparatorType terminalSeparatorType, Function3 function3, int i, Object obj) {
        PagingData insertSeparators;
        if ((i & 1) != 0) {
            terminalSeparatorType = TerminalSeparatorType.FULLY_COMPLETE;
        }
        insertSeparators = insertSeparators(pagingData, terminalSeparatorType, function3);
        return insertSeparators;
    }

    public static final /* synthetic */ PagingData insertSeparators(PagingData pagingData, TerminalSeparatorType terminalSeparatorType, Function3 generator) {
        Intrinsics.checkNotNullParameter(pagingData, "<this>");
        Intrinsics.checkNotNullParameter(terminalSeparatorType, "terminalSeparatorType");
        Intrinsics.checkNotNullParameter(generator, "generator");
        return new PagingData(SeparatorsKt.insertEventSeparators(pagingData.getFlow$paging_common(), terminalSeparatorType, generator), pagingData.getUiReceiver$paging_common(), pagingData.getHintReceiver$paging_common(), null, 8, null);
    }

    public static /* synthetic */ PagingData insertHeaderItem$default(PagingData pagingData, TerminalSeparatorType terminalSeparatorType, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            terminalSeparatorType = TerminalSeparatorType.FULLY_COMPLETE;
        }
        return PagingDataTransforms.insertHeaderItem(pagingData, terminalSeparatorType, obj);
    }

    public static final <T> PagingData<T> insertHeaderItem(PagingData<T> pagingData, TerminalSeparatorType terminalSeparatorType, T item) {
        PagingData<T> insertSeparators;
        Intrinsics.checkNotNullParameter(pagingData, "<this>");
        Intrinsics.checkNotNullParameter(terminalSeparatorType, "terminalSeparatorType");
        Intrinsics.checkNotNullParameter(item, "item");
        insertSeparators = insertSeparators(pagingData, terminalSeparatorType, new PagingDataTransforms__PagingDataTransformsKt$insertHeaderItem$1(item, null));
        return insertSeparators;
    }

    public static /* synthetic */ PagingData insertFooterItem$default(PagingData pagingData, TerminalSeparatorType terminalSeparatorType, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            terminalSeparatorType = TerminalSeparatorType.FULLY_COMPLETE;
        }
        return PagingDataTransforms.insertFooterItem(pagingData, terminalSeparatorType, obj);
    }

    public static final <T> PagingData<T> insertFooterItem(PagingData<T> pagingData, TerminalSeparatorType terminalSeparatorType, T item) {
        PagingData<T> insertSeparators;
        Intrinsics.checkNotNullParameter(pagingData, "<this>");
        Intrinsics.checkNotNullParameter(terminalSeparatorType, "terminalSeparatorType");
        Intrinsics.checkNotNullParameter(item, "item");
        insertSeparators = insertSeparators(pagingData, terminalSeparatorType, new PagingDataTransforms__PagingDataTransformsKt$insertFooterItem$1(item, null));
        return insertSeparators;
    }

    public static final /* synthetic */ PagingData map(PagingData pagingData, final Function2 transform) {
        Intrinsics.checkNotNullParameter(pagingData, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        final Flow flow$paging_common = pagingData.getFlow$paging_common();
        return new PagingData(new Flow<PageEvent<R>>() { // from class: androidx.paging.PagingDataTransforms__PagingDataTransformsKt$map$$inlined$transform$1

            /* compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
            /* renamed from: androidx.paging.PagingDataTransforms__PagingDataTransformsKt$map$$inlined$transform$1$2  reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ Function2 $transform$inlined;

                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "androidx.paging.PagingDataTransforms__PagingDataTransformsKt$map$$inlined$transform$1$2", f = "PagingDataTransforms.kt", i = {}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF, 50}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: androidx.paging.PagingDataTransforms__PagingDataTransformsKt$map$$inlined$transform$1$2$1  reason: invalid class name */
                /* loaded from: classes3.dex */
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

                /* JADX WARN: Code restructure failed: missing block: B:21:0x0060, code lost:
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
                                Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2 = this.$transform$inlined;
                                anonymousClass1.L$0 = flowCollector2;
                                anonymousClass1.label = 1;
                                Object map = ((PageEvent) obj).map(function2, anonymousClass1);
                                if (map != coroutine_suspended) {
                                    obj2 = map;
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
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, transform), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }, pagingData.getUiReceiver$paging_common(), pagingData.getHintReceiver$paging_common(), null, 8, null);
    }

    public static final /* synthetic */ PagingData flatMap(PagingData pagingData, final Function2 transform) {
        Intrinsics.checkNotNullParameter(pagingData, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        final Flow flow$paging_common = pagingData.getFlow$paging_common();
        return new PagingData(new Flow<PageEvent<R>>() { // from class: androidx.paging.PagingDataTransforms__PagingDataTransformsKt$flatMap$$inlined$transform$1

            /* compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
            /* renamed from: androidx.paging.PagingDataTransforms__PagingDataTransformsKt$flatMap$$inlined$transform$1$2  reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ Function2 $transform$inlined;

                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "androidx.paging.PagingDataTransforms__PagingDataTransformsKt$flatMap$$inlined$transform$1$2", f = "PagingDataTransforms.kt", i = {}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF, 50}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: androidx.paging.PagingDataTransforms__PagingDataTransformsKt$flatMap$$inlined$transform$1$2$1  reason: invalid class name */
                /* loaded from: classes3.dex */
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

                /* JADX WARN: Code restructure failed: missing block: B:21:0x0060, code lost:
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
                                Function2<? super T, ? super Continuation<? super Iterable<? extends R>>, ? extends Object> function2 = this.$transform$inlined;
                                anonymousClass1.L$0 = flowCollector2;
                                anonymousClass1.label = 1;
                                Object flatMap = ((PageEvent) obj).flatMap(function2, anonymousClass1);
                                if (flatMap != coroutine_suspended) {
                                    obj2 = flatMap;
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
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, transform), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }, pagingData.getUiReceiver$paging_common(), pagingData.getHintReceiver$paging_common(), null, 8, null);
    }

    public static final /* synthetic */ PagingData filter(PagingData pagingData, final Function2 predicate) {
        Intrinsics.checkNotNullParameter(pagingData, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        final Flow flow$paging_common = pagingData.getFlow$paging_common();
        return new PagingData(new Flow<PageEvent<T>>() { // from class: androidx.paging.PagingDataTransforms__PagingDataTransformsKt$filter$$inlined$transform$1

            /* compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
            /* renamed from: androidx.paging.PagingDataTransforms__PagingDataTransformsKt$filter$$inlined$transform$1$2  reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ Function2 $predicate$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "androidx.paging.PagingDataTransforms__PagingDataTransformsKt$filter$$inlined$transform$1$2", f = "PagingDataTransforms.kt", i = {}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF, 50}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: androidx.paging.PagingDataTransforms__PagingDataTransformsKt$filter$$inlined$transform$1$2$1  reason: invalid class name */
                /* loaded from: classes3.dex */
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
                    this.$predicate$inlined = function2;
                }

                /* JADX WARN: Code restructure failed: missing block: B:21:0x0060, code lost:
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
                                Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2 = this.$predicate$inlined;
                                anonymousClass1.L$0 = flowCollector2;
                                anonymousClass1.label = 1;
                                Object filter = ((PageEvent) obj).filter(function2, anonymousClass1);
                                if (filter != coroutine_suspended) {
                                    obj2 = filter;
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
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, predicate), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }, pagingData.getUiReceiver$paging_common(), pagingData.getHintReceiver$paging_common(), null, 8, null);
    }
}
