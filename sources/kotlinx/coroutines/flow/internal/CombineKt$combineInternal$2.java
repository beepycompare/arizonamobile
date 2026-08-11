package kotlinx.coroutines.flow.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
/* compiled from: Combine.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG, 73, 76}, m = "invokeSuspend", n = {"$this$flowScope", "latestValues", "resultChannel", "nonClosed", "lastReceivedEpoch", "size", "remainingAbsentValues", "currentEpoch", "$this$flowScope", "latestValues", "resultChannel", "nonClosed", "lastReceivedEpoch", "element", "results", "size", "remainingAbsentValues", "currentEpoch", "$this$flowScope", "latestValues", "resultChannel", "nonClosed", "lastReceivedEpoch", "element", "results", "size", "remainingAbsentValues", "currentEpoch"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2"}, v = 1)
/* loaded from: classes5.dex */
final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<T[]> $arrayFactory;
    final /* synthetic */ Flow<T>[] $flows;
    final /* synthetic */ FlowCollector<R> $this_combineInternal;
    final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> $transform;
    int I$0;
    int I$1;
    int I$2;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$combineInternal$2(Flow<? extends T>[] flowArr, Function0<T[]> function0, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> function3, FlowCollector<? super R> flowCollector, Continuation<? super CombineKt$combineInternal$2> continuation) {
        super(2, continuation);
        this.$flows = flowArr;
        this.$arrayFactory = function0;
        this.$transform = function3;
        this.$this_combineInternal = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, continuation);
        combineKt$combineInternal$2.L$0 = obj;
        return combineKt$combineInternal$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CombineKt$combineInternal$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0168, code lost:
        if (r10.invoke(r15, r13, r22) == r1) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x016b, code lost:
        r20 = r12;
        r12 = r4;
        r4 = r6;
        r6 = r20;
        r20 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01b1, code lost:
        if (r10.invoke(r11, r14, r22) == r1) goto L37;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0102 A[LOOP:0: B:28:0x0102->B:36:0x012b, LOOP_START, PHI: r4 r14 
      PHI: (r4v6 int) = (r4v5 int), (r4v7 int) binds: [B:25:0x00fd, B:36:0x012b] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r14v5 kotlin.collections.IndexedValue) = (r14v4 kotlin.collections.IndexedValue), (r14v10 kotlin.collections.IndexedValue) binds: [B:25:0x00fd, B:36:0x012b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r15v1, types: [kotlinx.coroutines.flow.Flow[], kotlinx.coroutines.flow.Flow<T>[]] */
    /* JADX WARN: Type inference failed for: r3v1, types: [kotlinx.coroutines.flow.Flow<T>[]] */
    /* JADX WARN: Type inference failed for: r3v12, types: [int] */
    /* JADX WARN: Type inference failed for: r3v14, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x016b -> B:44:0x0173). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x01b4 -> B:20:0x00c5). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int length;
        Object[] objArr;
        byte b;
        byte[] bArr;
        int i;
        AtomicInteger atomicInteger;
        Channel channel;
        Object obj2;
        Channel channel2;
        byte b2;
        byte[] bArr2;
        int i2;
        IndexedValue indexedValue;
        IndexedValue indexedValue2;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        int i4 = 1;
        Object obj3 = null;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            length = this.$flows.length;
            if (length == 0) {
                return Unit.INSTANCE;
            }
            objArr = new Object[length];
            ArraysKt.fill$default(objArr, NullSurrogateKt.UNINITIALIZED, 0, 0, 6, (Object) null);
            Channel Channel$default = ChannelKt.Channel$default(length, null, null, 6, null);
            AtomicInteger atomicInteger2 = new AtomicInteger(length);
            b = 0;
            int i5 = 0;
            while (i5 < length) {
                AtomicInteger atomicInteger3 = atomicInteger2;
                int i6 = i5;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(this.$flows, i6, atomicInteger3, Channel$default, null), 3, null);
                i5 = i6 + 1;
                atomicInteger2 = atomicInteger3;
            }
            bArr = new byte[length];
            i = length;
            atomicInteger = atomicInteger2;
            channel = Channel$default;
            b2 = (byte) (b + 1);
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = objArr;
            this.L$2 = channel;
            this.L$3 = SpillingKt.nullOutSpilledVariable(atomicInteger);
            this.L$4 = bArr;
            this.L$5 = obj3;
            this.L$6 = obj3;
            this.I$0 = i;
            this.I$1 = length;
            this.I$2 = b2;
            this.label = i4;
            obj2 = channel.mo11456receiveCatchingJP2dKIU(this);
            if (obj2 != coroutine_suspended) {
            }
            return coroutine_suspended;
        } else if (i3 != 1) {
            if (i3 == 2 || i3 == 3) {
                ?? r3 = this.I$2;
                int i7 = this.I$1;
                i = this.I$0;
                Object[] objArr2 = (Object[]) this.L$6;
                IndexedValue indexedValue3 = (IndexedValue) this.L$5;
                Channel channel3 = (Channel) this.L$2;
                objArr = (Object[]) this.L$1;
                ResultKt.throwOnFailure(obj);
                length = i7;
                bArr = (byte[]) this.L$4;
                channel = channel3;
                b = r3;
                atomicInteger = (AtomicInteger) this.L$3;
                i4 = 1;
                obj3 = null;
                b2 = (byte) (b + 1);
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = objArr;
                this.L$2 = channel;
                this.L$3 = SpillingKt.nullOutSpilledVariable(atomicInteger);
                this.L$4 = bArr;
                this.L$5 = obj3;
                this.L$6 = obj3;
                this.I$0 = i;
                this.I$1 = length;
                this.I$2 = b2;
                this.label = i4;
                obj2 = channel.mo11456receiveCatchingJP2dKIU(this);
                if (obj2 != coroutine_suspended) {
                    Channel channel4 = channel;
                    bArr2 = bArr;
                    i2 = length;
                    channel2 = channel4;
                    indexedValue = (IndexedValue) ChannelResult.m11468getOrNullimpl(obj2);
                    if (indexedValue != null) {
                        return Unit.INSTANCE;
                    }
                    while (true) {
                        indexedValue2 = indexedValue;
                        int index = indexedValue2.getIndex();
                        Object obj4 = objArr[index];
                        objArr[index] = indexedValue2.getValue();
                        if (obj4 == NullSurrogateKt.UNINITIALIZED) {
                            i2--;
                        }
                        if (bArr2[index] == b2) {
                            break;
                        }
                        bArr2[index] = b2;
                        indexedValue = (IndexedValue) ChannelResult.m11468getOrNullimpl(channel2.mo11457tryReceivePtdJZtk());
                        if (indexedValue == null) {
                            break;
                        }
                    }
                    if (i2 != 0) {
                        Channel channel5 = channel2;
                        length = i2;
                        bArr = bArr2;
                        channel = channel5;
                        b = b2;
                        i4 = 1;
                        b2 = (byte) (b + 1);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                        this.L$1 = objArr;
                        this.L$2 = channel;
                        this.L$3 = SpillingKt.nullOutSpilledVariable(atomicInteger);
                        this.L$4 = bArr;
                        this.L$5 = obj3;
                        this.L$6 = obj3;
                        this.I$0 = i;
                        this.I$1 = length;
                        this.I$2 = b2;
                        this.label = i4;
                        obj2 = channel.mo11456receiveCatchingJP2dKIU(this);
                        if (obj2 != coroutine_suspended) {
                        }
                    } else {
                        Object[] objArr3 = (Object[]) this.$arrayFactory.invoke();
                        if (objArr3 == null) {
                            Function3 function3 = this.$transform;
                            Object obj5 = this.$this_combineInternal;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                            this.L$1 = objArr;
                            this.L$2 = channel2;
                            this.L$3 = SpillingKt.nullOutSpilledVariable(atomicInteger);
                            this.L$4 = bArr2;
                            this.L$5 = SpillingKt.nullOutSpilledVariable(indexedValue2);
                            this.L$6 = SpillingKt.nullOutSpilledVariable(objArr3);
                            this.I$0 = i;
                            this.I$1 = i2;
                            this.I$2 = b2;
                            this.label = 2;
                        } else {
                            ArraysKt.copyInto$default(objArr, objArr3, 0, 0, 0, 14, (Object) null);
                            Function3 function32 = this.$transform;
                            Object obj6 = this.$this_combineInternal;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                            this.L$1 = objArr;
                            this.L$2 = channel2;
                            this.L$3 = SpillingKt.nullOutSpilledVariable(atomicInteger);
                            this.L$4 = bArr2;
                            this.L$5 = SpillingKt.nullOutSpilledVariable(indexedValue2);
                            this.L$6 = SpillingKt.nullOutSpilledVariable(objArr3);
                            this.I$0 = i;
                            this.I$1 = i2;
                            this.I$2 = b2;
                            this.label = 3;
                        }
                        i4 = 1;
                        obj3 = null;
                        b2 = (byte) (b + 1);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                        this.L$1 = objArr;
                        this.L$2 = channel;
                        this.L$3 = SpillingKt.nullOutSpilledVariable(atomicInteger);
                        this.L$4 = bArr;
                        this.L$5 = obj3;
                        this.L$6 = obj3;
                        this.I$0 = i;
                        this.I$1 = length;
                        this.I$2 = b2;
                        this.label = i4;
                        obj2 = channel.mo11456receiveCatchingJP2dKIU(this);
                        if (obj2 != coroutine_suspended) {
                        }
                    }
                }
                return coroutine_suspended;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ?? r32 = this.I$2;
            i2 = this.I$1;
            i = this.I$0;
            bArr2 = (byte[]) this.L$4;
            AtomicInteger atomicInteger4 = (AtomicInteger) this.L$3;
            channel2 = (Channel) this.L$2;
            objArr = (Object[]) this.L$1;
            ResultKt.throwOnFailure(obj);
            obj2 = ((ChannelResult) obj).m11475unboximpl();
            b2 = r32;
            atomicInteger = atomicInteger4;
            indexedValue = (IndexedValue) ChannelResult.m11468getOrNullimpl(obj2);
            if (indexedValue != null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Combine.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Flow<T>[] $flows;
        final /* synthetic */ int $i;
        final /* synthetic */ AtomicInteger $nonClosed;
        final /* synthetic */ Channel<IndexedValue<Object>> $resultChannel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Flow<? extends T>[] flowArr, int i, AtomicInteger atomicInteger, Channel<IndexedValue<Object>> channel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$flows = flowArr;
            this.$i = i;
            this.$nonClosed = atomicInteger;
            this.$resultChannel = channel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$flows, this.$i, this.$nonClosed, this.$resultChannel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AtomicInteger atomicInteger;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (this.$flows[this.$i].collect(new C00791(this.$resultChannel, this.$i), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    SendChannel.close$default(this.$resultChannel, null, 1, null);
                }
                return Unit.INSTANCE;
            } finally {
                if (this.$nonClosed.decrementAndGet() == 0) {
                    SendChannel.close$default(this.$resultChannel, null, 1, null);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Combine.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C00791<T> implements FlowCollector {
            final /* synthetic */ int $i;
            final /* synthetic */ Channel<IndexedValue<Object>> $resultChannel;

            C00791(Channel<IndexedValue<Object>> channel, int i) {
                this.$resultChannel = channel;
                this.$i = i;
            }

            /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
                if (r7.send(r2, r0) == r1) goto L19;
             */
            /* JADX WARN: Code restructure failed: missing block: B:20:0x0064, code lost:
                if (kotlinx.coroutines.YieldKt.yield(r0) != r1) goto L11;
             */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x0066, code lost:
                return r1;
             */
            /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
            /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(T t, Continuation<? super Unit> continuation) {
                CombineKt$combineInternal$2$1$1$emit$1 combineKt$combineInternal$2$1$1$emit$1;
                int i;
                if (continuation instanceof CombineKt$combineInternal$2$1$1$emit$1) {
                    combineKt$combineInternal$2$1$1$emit$1 = (CombineKt$combineInternal$2$1$1$emit$1) continuation;
                    if ((combineKt$combineInternal$2$1$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                        combineKt$combineInternal$2$1$1$emit$1.label -= Integer.MIN_VALUE;
                        Object obj = combineKt$combineInternal$2$1$1$emit$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = combineKt$combineInternal$2$1$1$emit$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            Channel<IndexedValue<Object>> channel = this.$resultChannel;
                            IndexedValue<Object> indexedValue = new IndexedValue<>(this.$i, t);
                            combineKt$combineInternal$2$1$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(t);
                            combineKt$combineInternal$2$1$1$emit$1.label = 1;
                        } else if (i != 1) {
                            if (i == 2) {
                                Object obj2 = combineKt$combineInternal$2$1$1$emit$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            t = (T) combineKt$combineInternal$2$1$1$emit$1.L$0;
                            ResultKt.throwOnFailure(obj);
                        }
                        combineKt$combineInternal$2$1$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(t);
                        combineKt$combineInternal$2$1$1$emit$1.label = 2;
                    }
                }
                combineKt$combineInternal$2$1$1$emit$1 = new CombineKt$combineInternal$2$1$1$emit$1(this, continuation);
                Object obj3 = combineKt$combineInternal$2$1$1$emit$1.result;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = combineKt$combineInternal$2$1$1$emit$1.label;
                if (i != 0) {
                }
                combineKt$combineInternal$2$1$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(t);
                combineKt$combineInternal$2$1$1$emit$1.label = 2;
            }
        }
    }
}
