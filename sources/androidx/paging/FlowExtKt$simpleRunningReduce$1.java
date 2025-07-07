package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: FlowExt.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.FlowExtKt$simpleRunningReduce$1", f = "FlowExt.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class FlowExtKt$simpleRunningReduce$1<T> extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<T, T, Continuation<? super T>, Object> $operation;
    final /* synthetic */ Flow<T> $this_simpleRunningReduce;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowExtKt$simpleRunningReduce$1(Flow<? extends T> flow, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> function3, Continuation<? super FlowExtKt$simpleRunningReduce$1> continuation) {
        super(2, continuation);
        this.$this_simpleRunningReduce = flow;
        this.$operation = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowExtKt$simpleRunningReduce$1 flowExtKt$simpleRunningReduce$1 = new FlowExtKt$simpleRunningReduce$1(this.$this_simpleRunningReduce, this.$operation, continuation);
        flowExtKt$simpleRunningReduce$1.L$0 = obj;
        return flowExtKt$simpleRunningReduce$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((FlowCollector) ((FlowCollector) obj), continuation);
    }

    public final Object invoke(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return ((FlowExtKt$simpleRunningReduce$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            obj2 = FlowExtKt.NULL;
            objectRef.element = (T) obj2;
            Flow<T> flow = this.$this_simpleRunningReduce;
            Function3<T, T, Continuation<? super T>, Object> function3 = this.$operation;
            this.label = 1;
            if (flow.collect(new AnonymousClass1(objectRef, function3, (FlowCollector) this.L$0), this) == coroutine_suspended) {
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
    /* compiled from: FlowExt.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.paging.FlowExtKt$simpleRunningReduce$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ FlowCollector<T> $$this$flow;
        final /* synthetic */ Ref.ObjectRef<Object> $accumulator;
        final /* synthetic */ Function3<T, T, Continuation<? super T>, Object> $operation;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Ref.ObjectRef<Object> objectRef, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> function3, FlowCollector<? super T> flowCollector) {
            this.$accumulator = objectRef;
            this.$operation = function3;
            this.$$this$flow = flowCollector;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x007d, code lost:
            if (r8.emit(r9, r0) == r1) goto L20;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
        /* JADX WARN: Type inference failed for: r9v7 */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(T t, Continuation<? super Unit> continuation) {
            FlowExtKt$simpleRunningReduce$1$1$emit$1 flowExtKt$simpleRunningReduce$1$1$emit$1;
            int i;
            Ref.ObjectRef<Object> objectRef;
            Object obj;
            Ref.ObjectRef<Object> objectRef2;
            AnonymousClass1<T> anonymousClass1;
            if (continuation instanceof FlowExtKt$simpleRunningReduce$1$1$emit$1) {
                flowExtKt$simpleRunningReduce$1$1$emit$1 = (FlowExtKt$simpleRunningReduce$1$1$emit$1) continuation;
                if ((flowExtKt$simpleRunningReduce$1$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                    flowExtKt$simpleRunningReduce$1$1$emit$1.label -= Integer.MIN_VALUE;
                    Object obj2 = flowExtKt$simpleRunningReduce$1$1$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = flowExtKt$simpleRunningReduce$1$1$emit$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        objectRef = this.$accumulator;
                        Object obj3 = objectRef.element;
                        obj = FlowExtKt.NULL;
                        if (obj3 == obj) {
                            anonymousClass1 = this;
                            objectRef.element = t;
                            FlowCollector<T> flowCollector = anonymousClass1.$$this$flow;
                            T t2 = anonymousClass1.$accumulator.element;
                            flowExtKt$simpleRunningReduce$1$1$emit$1.L$0 = null;
                            flowExtKt$simpleRunningReduce$1$1$emit$1.L$1 = null;
                            flowExtKt$simpleRunningReduce$1$1$emit$1.label = 2;
                        } else {
                            Function3<T, T, Continuation<? super T>, Object> function3 = this.$operation;
                            T t3 = this.$accumulator.element;
                            flowExtKt$simpleRunningReduce$1$1$emit$1.L$0 = this;
                            flowExtKt$simpleRunningReduce$1$1$emit$1.L$1 = objectRef;
                            flowExtKt$simpleRunningReduce$1$1$emit$1.label = 1;
                            Object invoke = function3.invoke(t3, t, flowExtKt$simpleRunningReduce$1$1$emit$1);
                            if (invoke != coroutine_suspended) {
                                obj2 = invoke;
                                objectRef2 = objectRef;
                                anonymousClass1 = this;
                            }
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj2);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        objectRef2 = (Ref.ObjectRef) flowExtKt$simpleRunningReduce$1$1$emit$1.L$1;
                        anonymousClass1 = (AnonymousClass1) flowExtKt$simpleRunningReduce$1$1$emit$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    T t4 = obj2;
                    objectRef = objectRef2;
                    t = t4;
                    objectRef.element = t;
                    FlowCollector<T> flowCollector2 = anonymousClass1.$$this$flow;
                    T t22 = anonymousClass1.$accumulator.element;
                    flowExtKt$simpleRunningReduce$1$1$emit$1.L$0 = null;
                    flowExtKt$simpleRunningReduce$1$1$emit$1.L$1 = null;
                    flowExtKt$simpleRunningReduce$1$1$emit$1.label = 2;
                }
            }
            flowExtKt$simpleRunningReduce$1$1$emit$1 = new FlowExtKt$simpleRunningReduce$1$1$emit$1(this, continuation);
            Object obj22 = flowExtKt$simpleRunningReduce$1$1$emit$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = flowExtKt$simpleRunningReduce$1$1$emit$1.label;
            if (i != 0) {
            }
            T t42 = obj22;
            objectRef = objectRef2;
            t = t42;
            objectRef.element = t;
            FlowCollector<T> flowCollector22 = anonymousClass1.$$this$flow;
            T t222 = anonymousClass1.$accumulator.element;
            flowExtKt$simpleRunningReduce$1$1$emit$1.L$0 = null;
            flowExtKt$simpleRunningReduce$1$1$emit$1.L$1 = null;
            flowExtKt$simpleRunningReduce$1$1$emit$1.label = 2;
        }
    }
}
