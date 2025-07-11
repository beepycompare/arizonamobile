package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CachedPageEventFlow.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.CachedPageEventFlow$job$1", f = "CachedPageEventFlow.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class CachedPageEventFlow$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<PageEvent<T>> $src;
    int label;
    final /* synthetic */ CachedPageEventFlow<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CachedPageEventFlow$job$1(Flow<? extends PageEvent<T>> flow, CachedPageEventFlow<T> cachedPageEventFlow, Continuation<? super CachedPageEventFlow$job$1> continuation) {
        super(2, continuation);
        this.$src = flow;
        this.this$0 = cachedPageEventFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CachedPageEventFlow$job$1(this.$src, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CachedPageEventFlow$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (FlowKt.withIndex(this.$src).collect(new AnonymousClass1(this.this$0), this) == coroutine_suspended) {
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
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00060\u0005H\u008a@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "it", "Lkotlin/collections/IndexedValue;", "Landroidx/paging/PageEvent;", "emit", "(Lkotlin/collections/IndexedValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.paging.CachedPageEventFlow$job$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ CachedPageEventFlow<T> this$0;

        AnonymousClass1(CachedPageEventFlow<T> cachedPageEventFlow) {
            this.this$0 = cachedPageEventFlow;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((IndexedValue) ((IndexedValue) obj), (Continuation<? super Unit>) continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0069, code lost:
            if (r7.record(r6, r0) != r1) goto L11;
         */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(IndexedValue<? extends PageEvent<T>> indexedValue, Continuation<? super Unit> continuation) {
            CachedPageEventFlow$job$1$1$emit$1 cachedPageEventFlow$job$1$1$emit$1;
            int i;
            MutableSharedFlow mutableSharedFlow;
            AnonymousClass1<T> anonymousClass1;
            FlattenedPageController flattenedPageController;
            if (continuation instanceof CachedPageEventFlow$job$1$1$emit$1) {
                cachedPageEventFlow$job$1$1$emit$1 = (CachedPageEventFlow$job$1$1$emit$1) continuation;
                if ((cachedPageEventFlow$job$1$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                    cachedPageEventFlow$job$1$1$emit$1.label -= Integer.MIN_VALUE;
                    Object obj = cachedPageEventFlow$job$1$1$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = cachedPageEventFlow$job$1$1$emit$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutableSharedFlow = ((CachedPageEventFlow) this.this$0).mutableSharedSrc;
                        cachedPageEventFlow$job$1$1$emit$1.L$0 = this;
                        cachedPageEventFlow$job$1$1$emit$1.L$1 = indexedValue;
                        cachedPageEventFlow$job$1$1$emit$1.label = 1;
                        if (mutableSharedFlow.emit(indexedValue, cachedPageEventFlow$job$1$1$emit$1) != coroutine_suspended) {
                            anonymousClass1 = this;
                        }
                        return coroutine_suspended;
                    } else if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        indexedValue = (IndexedValue) cachedPageEventFlow$job$1$1$emit$1.L$1;
                        anonymousClass1 = (AnonymousClass1) cachedPageEventFlow$job$1$1$emit$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    flattenedPageController = ((CachedPageEventFlow) anonymousClass1.this$0).pageController;
                    cachedPageEventFlow$job$1$1$emit$1.L$0 = null;
                    cachedPageEventFlow$job$1$1$emit$1.L$1 = null;
                    cachedPageEventFlow$job$1$1$emit$1.label = 2;
                }
            }
            cachedPageEventFlow$job$1$1$emit$1 = new CachedPageEventFlow$job$1$1$emit$1(this, continuation);
            Object obj2 = cachedPageEventFlow$job$1$1$emit$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = cachedPageEventFlow$job$1$1$emit$1.label;
            if (i != 0) {
            }
            flattenedPageController = ((CachedPageEventFlow) anonymousClass1.this$0).pageController;
            cachedPageEventFlow$job$1$1$emit$1.L$0 = null;
            cachedPageEventFlow$job$1$1$emit$1.L$1 = null;
            cachedPageEventFlow$job$1$1$emit$1.label = 2;
        }
    }
}
