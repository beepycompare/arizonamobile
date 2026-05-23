package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.YieldKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
/* compiled from: Emitters.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.AsyncPagingDataDiffer$special$$inlined$transform$1", f = "AsyncPagingDataDiffer.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes3.dex */
public final class AsyncPagingDataDiffer$special$$inlined$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super CombinedLoadStates>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $this_transform;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AsyncPagingDataDiffer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncPagingDataDiffer$special$$inlined$transform$1(Flow flow, Continuation continuation, AsyncPagingDataDiffer asyncPagingDataDiffer) {
        super(2, continuation);
        this.$this_transform = flow;
        this.this$0 = asyncPagingDataDiffer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AsyncPagingDataDiffer$special$$inlined$transform$1 asyncPagingDataDiffer$special$$inlined$transform$1 = new AsyncPagingDataDiffer$special$$inlined$transform$1(this.$this_transform, continuation, this.this$0);
        asyncPagingDataDiffer$special$$inlined$transform$1.L$0 = obj;
        return asyncPagingDataDiffer$special$$inlined$transform$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super CombinedLoadStates> flowCollector, Continuation<? super Unit> continuation) {
        return ((AsyncPagingDataDiffer$special$$inlined$transform$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: Emitters.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.paging.AsyncPagingDataDiffer$special$$inlined$transform$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ FlowCollector<CombinedLoadStates> $$this$flow;
        final /* synthetic */ AsyncPagingDataDiffer this$0;

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "androidx.paging.AsyncPagingDataDiffer$special$$inlined$transform$1$1", f = "AsyncPagingDataDiffer.kt", i = {0, 0, 1, 1}, l = {40, 41, 43}, m = "emit", n = {"it", "$this$loadStateFlow_u24lambda_u240", "it", "$this$loadStateFlow_u24lambda_u240"}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
        /* renamed from: androidx.paging.AsyncPagingDataDiffer$special$$inlined$transform$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C00341 extends ContinuationImpl {
            Object L$0;
            Object L$1;
            int label;
            /* synthetic */ Object result;

            public C00341(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass1.this.emit(null, this);
            }
        }

        public AnonymousClass1(FlowCollector flowCollector, AsyncPagingDataDiffer asyncPagingDataDiffer) {
            this.this$0 = asyncPagingDataDiffer;
            this.$$this$flow = flowCollector;
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x00a6, code lost:
            if (r9.emit(r8, r0) == r1) goto L21;
         */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0099  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(T t, Continuation<? super Unit> continuation) {
            C00341 c00341;
            Object coroutine_suspended;
            int i;
            FlowCollector<CombinedLoadStates> flowCollector;
            CombinedLoadStates combinedLoadStates;
            CombinedLoadStates combinedLoadStates2;
            FlowCollector<CombinedLoadStates> flowCollector2;
            FlowCollector<CombinedLoadStates> flowCollector3;
            if (continuation instanceof C00341) {
                c00341 = (C00341) continuation;
                if ((c00341.label & Integer.MIN_VALUE) != 0) {
                    c00341.label -= Integer.MIN_VALUE;
                    Object obj = c00341.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = c00341.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        flowCollector = this.$$this$flow;
                        combinedLoadStates = (CombinedLoadStates) t;
                        if (this.this$0.getInGetItem$paging_runtime().getValue().booleanValue()) {
                            c00341.L$0 = combinedLoadStates;
                            c00341.L$1 = flowCollector;
                            c00341.label = 1;
                            if (YieldKt.yield(c00341) != coroutine_suspended) {
                                combinedLoadStates2 = combinedLoadStates;
                                flowCollector2 = flowCollector;
                            }
                            return coroutine_suspended;
                        }
                        c00341.L$0 = null;
                        c00341.L$1 = null;
                        c00341.label = 3;
                    } else if (i == 1) {
                        flowCollector2 = (FlowCollector) c00341.L$1;
                        combinedLoadStates2 = (CombinedLoadStates) c00341.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else if (i != 2) {
                        if (i == 3) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        flowCollector3 = (FlowCollector) c00341.L$1;
                        combinedLoadStates = (CombinedLoadStates) c00341.L$0;
                        ResultKt.throwOnFailure(obj);
                        flowCollector = flowCollector3;
                        c00341.L$0 = null;
                        c00341.L$1 = null;
                        c00341.label = 3;
                    }
                    c00341.L$0 = combinedLoadStates2;
                    c00341.L$1 = flowCollector2;
                    c00341.label = 2;
                    if (FlowKt.firstOrNull(this.this$0.getInGetItem$paging_runtime(), new AsyncPagingDataDiffer$loadStateFlow$1$1(null), c00341) != coroutine_suspended) {
                        flowCollector3 = flowCollector2;
                        combinedLoadStates = combinedLoadStates2;
                        flowCollector = flowCollector3;
                        c00341.L$0 = null;
                        c00341.L$1 = null;
                        c00341.label = 3;
                    }
                    return coroutine_suspended;
                }
            }
            c00341 = new C00341(continuation);
            Object obj2 = c00341.result;
            coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = c00341.label;
            if (i != 0) {
            }
            c00341.L$0 = combinedLoadStates2;
            c00341.L$1 = flowCollector2;
            c00341.label = 2;
            if (FlowKt.firstOrNull(this.this$0.getInGetItem$paging_runtime(), new AsyncPagingDataDiffer$loadStateFlow$1$1(null), c00341) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.$this_transform.collect(new AnonymousClass1((FlowCollector) this.L$0, this.this$0), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
