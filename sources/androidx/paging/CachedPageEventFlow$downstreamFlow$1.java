package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: CachedPageEventFlow.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/paging/PageEvent;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.CachedPageEventFlow$downstreamFlow$1", f = "CachedPageEventFlow.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class CachedPageEventFlow$downstreamFlow$1<T> extends SuspendLambda implements Function2<FlowCollector<? super PageEvent<T>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CachedPageEventFlow<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CachedPageEventFlow$downstreamFlow$1(CachedPageEventFlow<T> cachedPageEventFlow, Continuation<? super CachedPageEventFlow$downstreamFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = cachedPageEventFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CachedPageEventFlow$downstreamFlow$1 cachedPageEventFlow$downstreamFlow$1 = new CachedPageEventFlow$downstreamFlow$1(this.this$0, continuation);
        cachedPageEventFlow$downstreamFlow$1.L$0 = obj;
        return cachedPageEventFlow$downstreamFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((FlowCollector) ((FlowCollector) obj), continuation);
    }

    public final Object invoke(FlowCollector<? super PageEvent<T>> flowCollector, Continuation<? super Unit> continuation) {
        return ((CachedPageEventFlow$downstreamFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SharedFlow sharedFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = Integer.MIN_VALUE;
            sharedFlow = ((CachedPageEventFlow) this.this$0).sharedForDownstream;
            this.label = 1;
            if (FlowKt.takeWhile(sharedFlow, new AnonymousClass1(null)).collect(new AnonymousClass2(intRef, (FlowCollector) this.L$0), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CachedPageEventFlow.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0018\u00010\u0005H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "it", "Lkotlin/collections/IndexedValue;", "Landroidx/paging/PageEvent;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.CachedPageEventFlow$downstreamFlow$1$1", f = "CachedPageEventFlow.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.paging.CachedPageEventFlow$downstreamFlow$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<IndexedValue<? extends PageEvent<T>>, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Boolean> continuation) {
            return invoke((IndexedValue) ((IndexedValue) obj), continuation);
        }

        public final Object invoke(IndexedValue<? extends PageEvent<T>> indexedValue, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass1) create(indexedValue, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(((IndexedValue) this.L$0) != null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CachedPageEventFlow.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0018\u00010\u0005H\u008a@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "indexedValue", "Lkotlin/collections/IndexedValue;", "Landroidx/paging/PageEvent;", "emit", "(Lkotlin/collections/IndexedValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.paging.CachedPageEventFlow$downstreamFlow$1$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2<T> implements FlowCollector {
        final /* synthetic */ FlowCollector<PageEvent<T>> $$this$flow;
        final /* synthetic */ Ref.IntRef $maxEventIndex;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Ref.IntRef intRef, FlowCollector<? super PageEvent<T>> flowCollector) {
            this.$maxEventIndex = intRef;
            this.$$this$flow = flowCollector;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((IndexedValue) ((IndexedValue) obj), (Continuation<? super Unit>) continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(IndexedValue<? extends PageEvent<T>> indexedValue, Continuation<? super Unit> continuation) {
            CachedPageEventFlow$downstreamFlow$1$2$emit$1 cachedPageEventFlow$downstreamFlow$1$2$emit$1;
            int i;
            AnonymousClass2<T> anonymousClass2;
            if (continuation instanceof CachedPageEventFlow$downstreamFlow$1$2$emit$1) {
                cachedPageEventFlow$downstreamFlow$1$2$emit$1 = (CachedPageEventFlow$downstreamFlow$1$2$emit$1) continuation;
                if ((cachedPageEventFlow$downstreamFlow$1$2$emit$1.label & Integer.MIN_VALUE) != 0) {
                    cachedPageEventFlow$downstreamFlow$1$2$emit$1.label -= Integer.MIN_VALUE;
                    Object obj = cachedPageEventFlow$downstreamFlow$1$2$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = cachedPageEventFlow$downstreamFlow$1$2$emit$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Intrinsics.checkNotNull(indexedValue);
                        if (indexedValue.getIndex() > this.$maxEventIndex.element) {
                            FlowCollector<PageEvent<T>> flowCollector = this.$$this$flow;
                            PageEvent<T> value = indexedValue.getValue();
                            cachedPageEventFlow$downstreamFlow$1$2$emit$1.L$0 = this;
                            cachedPageEventFlow$downstreamFlow$1$2$emit$1.L$1 = indexedValue;
                            cachedPageEventFlow$downstreamFlow$1$2$emit$1.label = 1;
                            if (flowCollector.emit(value, cachedPageEventFlow$downstreamFlow$1$2$emit$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            anonymousClass2 = this;
                        }
                        return Unit.INSTANCE;
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        indexedValue = (IndexedValue) cachedPageEventFlow$downstreamFlow$1$2$emit$1.L$1;
                        anonymousClass2 = (AnonymousClass2) cachedPageEventFlow$downstreamFlow$1$2$emit$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    anonymousClass2.$maxEventIndex.element = indexedValue.getIndex();
                    return Unit.INSTANCE;
                }
            }
            cachedPageEventFlow$downstreamFlow$1$2$emit$1 = new CachedPageEventFlow$downstreamFlow$1$2$emit$1(this, continuation);
            Object obj2 = cachedPageEventFlow$downstreamFlow$1$2$emit$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = cachedPageEventFlow$downstreamFlow$1$2$emit$1.label;
            if (i != 0) {
            }
            anonymousClass2.$maxEventIndex.element = indexedValue.getIndex();
            return Unit.INSTANCE;
        }
    }
}
