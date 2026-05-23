package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
/* compiled from: CombinedLoadStates.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\t\u0018\u00010\u0001¢\u0006\u0002\b\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0086@¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"awaitNotLoading", "Landroidx/paging/CombinedLoadStates;", "Lkotlin/jvm/JvmSuppressWildcards;", "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-common"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CombinedLoadStatesKt {
    public static final Object awaitNotLoading(Flow<CombinedLoadStates> flow, Continuation<CombinedLoadStates> continuation) {
        final Flow debounce = FlowKt.debounce(flow, 1L);
        return FlowKt.firstOrNull(new Flow<CombinedLoadStates>() { // from class: androidx.paging.CombinedLoadStatesKt$awaitNotLoading$$inlined$filter$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super CombinedLoadStates> flowCollector, Continuation continuation2) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation2);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            /* compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            /* renamed from: androidx.paging.CombinedLoadStatesKt$awaitNotLoading$$inlined$filter$1$2  reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                @DebugMetadata(c = "androidx.paging.CombinedLoadStatesKt$awaitNotLoading$$inlined$filter$1$2", f = "CombinedLoadStates.kt", i = {}, l = {50}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: androidx.paging.CombinedLoadStatesKt$awaitNotLoading$$inlined$filter$1$2$1  reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
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

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.label;
                            if (i != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                CombinedLoadStates combinedLoadStates = (CombinedLoadStates) obj;
                                if (combinedLoadStates.isIdle() || combinedLoadStates.hasError()) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.label;
                    if (i != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }
        }, continuation);
    }
}
