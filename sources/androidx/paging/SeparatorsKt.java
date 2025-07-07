package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
/* compiled from: Separators.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a=\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0002\u0010\n\u001ak\u0010\u000b\u001a\u00020\f\"\b\b\u0000\u0010\r*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u0002H\r*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u00010\u000e2\b\u0010\u0004\u001a\u0004\u0018\u0001H\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0002\u0010\u0011\u001aI\u0010\u000b\u001a\u00020\f\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u000e2\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0002\u0010\u0012\u001au\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u00150\u0014\"\b\b\u0000\u0010\u0002*\u0002H\r\"\b\b\u0001\u0010\r*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00172.\u0010\u0018\u001a*\b\u0001\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0019H\u0000¢\u0006\u0002\u0010\u001b\u001ab\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\r0\u0001\"\b\b\u0000\u0010\r*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u0002H\r*\b\u0012\u0004\u0012\u0002H\u00020\u00012.\u0010\u0018\u001a*\b\u0001\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0019H\u0080@¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"separatorPage", "Landroidx/paging/TransformablePage;", ExifInterface.GPS_DIRECTION_TRUE, "", "separator", "originalPageOffsets", "", "hintOriginalPageOffset", "", "hintOriginalIndex", "(Ljava/lang/Object;[III)Landroidx/paging/TransformablePage;", "addSeparatorPage", "", "R", "", "adjacentPageBefore", "adjacentPageAfter", "(Ljava/util/List;Ljava/lang/Object;Landroidx/paging/TransformablePage;Landroidx/paging/TransformablePage;II)V", "(Ljava/util/List;Ljava/lang/Object;[III)V", "insertEventSeparators", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PageEvent;", "terminalSeparatorType", "Landroidx/paging/TerminalSeparatorType;", "generator", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/flow/Flow;Landroidx/paging/TerminalSeparatorType;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "insertInternalSeparators", "(Landroidx/paging/TransformablePage;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-common_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SeparatorsKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00d2 -> B:12:0x0044). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <R, T extends R> Object insertInternalSeparators(TransformablePage<T> transformablePage, Function3<? super T, ? super T, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super TransformablePage<R>> continuation) {
        SeparatorsKt$insertInternalSeparators$1 separatorsKt$insertInternalSeparators$1;
        int i;
        ArrayList arrayList;
        ArrayList arrayList2;
        SeparatorsKt$insertInternalSeparators$1 separatorsKt$insertInternalSeparators$12;
        Function3<? super T, ? super T, ? super Continuation<? super R>, ? extends Object> function32;
        TransformablePage<T> transformablePage2;
        int size;
        int i2;
        if (continuation instanceof SeparatorsKt$insertInternalSeparators$1) {
            separatorsKt$insertInternalSeparators$1 = (SeparatorsKt$insertInternalSeparators$1) continuation;
            if ((separatorsKt$insertInternalSeparators$1.label & Integer.MIN_VALUE) != 0) {
                separatorsKt$insertInternalSeparators$1.label -= Integer.MIN_VALUE;
                Object obj = separatorsKt$insertInternalSeparators$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = separatorsKt$insertInternalSeparators$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (transformablePage.getData().isEmpty()) {
                        Intrinsics.checkNotNull(transformablePage, "null cannot be cast to non-null type androidx.paging.TransformablePage<R of androidx.paging.SeparatorsKt.insertInternalSeparators>");
                        return transformablePage;
                    }
                    int size2 = transformablePage.getData().size() + 4;
                    ArrayList arrayList3 = new ArrayList(size2);
                    arrayList = new ArrayList(size2);
                    arrayList3.add(CollectionsKt.first((List<? extends Object>) transformablePage.getData()));
                    List<Integer> hintOriginalIndices = transformablePage.getHintOriginalIndices();
                    arrayList.add(Boxing.boxInt(hintOriginalIndices != null ? ((Number) CollectionsKt.first((List<? extends Object>) hintOriginalIndices)).intValue() : 0));
                    arrayList2 = arrayList3;
                    separatorsKt$insertInternalSeparators$12 = separatorsKt$insertInternalSeparators$1;
                    function32 = function3;
                    transformablePage2 = transformablePage;
                    size = transformablePage.getData().size();
                    i2 = 1;
                    if (i2 < size) {
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    size = separatorsKt$insertInternalSeparators$1.I$1;
                    int i3 = separatorsKt$insertInternalSeparators$1.I$0;
                    Object obj2 = separatorsKt$insertInternalSeparators$1.L$4;
                    arrayList2 = (ArrayList) separatorsKt$insertInternalSeparators$1.L$2;
                    TransformablePage<T> transformablePage3 = (TransformablePage) separatorsKt$insertInternalSeparators$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    ArrayList arrayList4 = (ArrayList) separatorsKt$insertInternalSeparators$1.L$3;
                    SeparatorsKt$insertInternalSeparators$1 separatorsKt$insertInternalSeparators$13 = separatorsKt$insertInternalSeparators$1;
                    function32 = (Function3) separatorsKt$insertInternalSeparators$1.L$1;
                    ArrayList arrayList5 = arrayList2;
                    ArrayList arrayList6 = arrayList4;
                    if (obj != null) {
                        arrayList5.add(obj);
                        arrayList6.add(Boxing.boxInt(i3));
                    }
                    arrayList5.add(obj2);
                    arrayList6.add(Boxing.boxInt(i3));
                    i2 = i3 + 1;
                    separatorsKt$insertInternalSeparators$12 = separatorsKt$insertInternalSeparators$13;
                    arrayList = arrayList6;
                    arrayList2 = arrayList5;
                    transformablePage2 = transformablePage3;
                    if (i2 < size) {
                        T t = transformablePage2.getData().get(i2);
                        T t2 = transformablePage2.getData().get(i2 - 1);
                        separatorsKt$insertInternalSeparators$12.L$0 = transformablePage2;
                        separatorsKt$insertInternalSeparators$12.L$1 = function32;
                        separatorsKt$insertInternalSeparators$12.L$2 = arrayList2;
                        separatorsKt$insertInternalSeparators$12.L$3 = arrayList;
                        separatorsKt$insertInternalSeparators$12.L$4 = t;
                        separatorsKt$insertInternalSeparators$12.I$0 = i2;
                        separatorsKt$insertInternalSeparators$12.I$1 = size;
                        separatorsKt$insertInternalSeparators$12.label = 1;
                        Object invoke = function32.invoke(t2, t, separatorsKt$insertInternalSeparators$12);
                        if (invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        transformablePage3 = transformablePage2;
                        i3 = i2;
                        obj = invoke;
                        arrayList4 = arrayList;
                        separatorsKt$insertInternalSeparators$13 = separatorsKt$insertInternalSeparators$12;
                        obj2 = t;
                        ArrayList arrayList52 = arrayList2;
                        ArrayList arrayList62 = arrayList4;
                        if (obj != null) {
                        }
                        arrayList52.add(obj2);
                        arrayList62.add(Boxing.boxInt(i3));
                        i2 = i3 + 1;
                        separatorsKt$insertInternalSeparators$12 = separatorsKt$insertInternalSeparators$13;
                        arrayList = arrayList62;
                        arrayList2 = arrayList52;
                        transformablePage2 = transformablePage3;
                        if (i2 < size) {
                            if (arrayList2.size() == transformablePage2.getData().size()) {
                                Intrinsics.checkNotNull(transformablePage2, "null cannot be cast to non-null type androidx.paging.TransformablePage<R of androidx.paging.SeparatorsKt.insertInternalSeparators>");
                                return transformablePage2;
                            }
                            return new TransformablePage(transformablePage2.getOriginalPageOffsets(), arrayList2, transformablePage2.getHintOriginalPageOffset(), arrayList);
                        }
                    }
                }
            }
        }
        separatorsKt$insertInternalSeparators$1 = new SeparatorsKt$insertInternalSeparators$1(continuation);
        Object obj3 = separatorsKt$insertInternalSeparators$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = separatorsKt$insertInternalSeparators$1.label;
        if (i != 0) {
        }
    }

    public static final <T> TransformablePage<T> separatorPage(T separator, int[] originalPageOffsets, int i, int i2) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(originalPageOffsets, "originalPageOffsets");
        return new TransformablePage<>(originalPageOffsets, CollectionsKt.listOf(separator), i, CollectionsKt.listOf(Integer.valueOf(i2)));
    }

    public static final <T> void addSeparatorPage(List<TransformablePage<T>> list, T t, int[] originalPageOffsets, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(originalPageOffsets, "originalPageOffsets");
        if (t == null) {
            return;
        }
        list.add(separatorPage(t, originalPageOffsets, i, i2));
    }

    public static final <R, T extends R> void addSeparatorPage(List<TransformablePage<R>> list, R r, TransformablePage<T> transformablePage, TransformablePage<T> transformablePage2, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        int[] originalPageOffsets = transformablePage != null ? transformablePage.getOriginalPageOffsets() : null;
        int[] originalPageOffsets2 = transformablePage2 != null ? transformablePage2.getOriginalPageOffsets() : null;
        if (originalPageOffsets != null && originalPageOffsets2 != null) {
            originalPageOffsets = CollectionsKt.toIntArray(CollectionsKt.sorted(ArraysKt.distinct(ArraysKt.plus(originalPageOffsets, originalPageOffsets2))));
        } else if (originalPageOffsets == null && originalPageOffsets2 != null) {
            originalPageOffsets = originalPageOffsets2;
        } else if (originalPageOffsets == null || originalPageOffsets2 != null) {
            throw new IllegalArgumentException("Separator page expected adjacentPageBefore or adjacentPageAfter, but both were null.");
        }
        addSeparatorPage(list, r, originalPageOffsets, i, i2);
    }

    public static final <T extends R, R> Flow<PageEvent<R>> insertEventSeparators(final Flow<? extends PageEvent<T>> flow, TerminalSeparatorType terminalSeparatorType, Function3<? super T, ? super T, ? super Continuation<? super R>, ? extends Object> generator) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(terminalSeparatorType, "terminalSeparatorType");
        Intrinsics.checkNotNullParameter(generator, "generator");
        final SeparatorState separatorState = new SeparatorState(terminalSeparatorType, new SeparatorsKt$insertEventSeparators$separatorState$1(generator, null));
        return new Flow<PageEvent<R>>() { // from class: androidx.paging.SeparatorsKt$insertEventSeparators$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
            /* renamed from: androidx.paging.SeparatorsKt$insertEventSeparators$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ SeparatorState $separatorState$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.paging.SeparatorsKt$insertEventSeparators$$inlined$map$1$2", f = "Separators.kt", i = {}, l = {224, 223}, m = "emit", n = {}, s = {})
                /* renamed from: androidx.paging.SeparatorsKt$insertEventSeparators$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, SeparatorState separatorState) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$separatorState$inlined = separatorState;
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
                                SeparatorState separatorState = this.$separatorState$inlined;
                                anonymousClass1.L$0 = flowCollector2;
                                anonymousClass1.label = 1;
                                Object onEvent = separatorState.onEvent((PageEvent) obj, anonymousClass1);
                                if (onEvent != coroutine_suspended) {
                                    obj2 = onEvent;
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
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, separatorState), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
    }
}
