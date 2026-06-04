package com.miami.game.core.downloader.sync.data.store;

import com.miami.game.core.domain.model.DownloaderInfo;
import com.miami.game.core.downloader.database.entity.DownloaderInfoDbModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
/* compiled from: SafeCollector.common.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DownloaderSyncDbRepository$getAllFlow$$inlined$map$1 implements Flow<List<? extends DownloaderInfo>> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;

    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.miami.game.core.downloader.sync.data.store.DownloaderSyncDbRepository$getAllFlow$$inlined$map$1", f = "DownloaderSyncDbRepository.kt", i = {0, 0, 0}, l = {112}, m = "collect", n = {"collector", "$completion", "$this$unsafeTransform_u24lambda_u240"}, nl = {115}, s = {"L$0", "L$1", "L$2"}, v = 2)
    /* renamed from: com.miami.game.core.downloader.sync.data.store.DownloaderSyncDbRepository$getAllFlow$$inlined$map$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloaderSyncDbRepository$getAllFlow$$inlined$map$1.this.collect(null, this);
        }
    }

    /* compiled from: Emitters.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* renamed from: com.miami.game.core.downloader.sync.data.store.DownloaderSyncDbRepository$getAllFlow$$inlined$map$1$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass2<T> implements FlowCollector {
        final /* synthetic */ FlowCollector $this_unsafeFlow;

        @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.miami.game.core.downloader.sync.data.store.DownloaderSyncDbRepository$getAllFlow$$inlined$map$1$2", f = "DownloaderSyncDbRepository.kt", i = {0, 0, 0, 0}, l = {217}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u240"}, nl = {47}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
        /* renamed from: com.miami.game.core.downloader.sync.data.store.DownloaderSyncDbRepository$getAllFlow$$inlined$map$1$2$1  reason: invalid class name */
        /* loaded from: classes5.dex */
        public static final class AnonymousClass1 extends ContinuationImpl {
            int I$0;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
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
        /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1;
            int i;
            DownloaderInfo domain;
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
                        List<DownloaderInfoDbModel> list = (List) obj;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                        for (DownloaderInfoDbModel downloaderInfoDbModel : list) {
                            domain = DownloaderSyncDbRepositoryKt.toDomain(downloaderInfoDbModel);
                            arrayList.add(domain);
                        }
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(arrayList, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        FlowCollector flowCollector2 = (FlowCollector) anonymousClass1.L$3;
                        Object obj3 = anonymousClass1.L$2;
                        AnonymousClass1 anonymousClass12 = (AnonymousClass1) anonymousClass1.L$1;
                        Object obj4 = anonymousClass1.L$0;
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

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super List<? extends DownloaderInfo>> flowCollector, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        int i;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
                Object obj = anonymousClass1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = anonymousClass1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(flowCollector);
                    anonymousClass1.label = 1;
                    if (this.$this_unsafeTransform$inlined.collect(new AnonymousClass2(flowCollector), anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    FlowCollector flowCollector2 = (FlowCollector) anonymousClass1.L$2;
                    AnonymousClass1 anonymousClass12 = (AnonymousClass1) anonymousClass1.L$1;
                    FlowCollector flowCollector3 = (FlowCollector) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj2 = anonymousClass1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anonymousClass1.label;
        if (i != 0) {
        }
        return Unit.INSTANCE;
    }

    public DownloaderSyncDbRepository$getAllFlow$$inlined$map$1(Flow flow) {
        this.$this_unsafeTransform$inlined = flow;
    }
}
