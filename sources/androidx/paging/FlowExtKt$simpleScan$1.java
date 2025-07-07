package androidx.paging;

import androidx.constraintlayout.widget.ConstraintLayout;
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
/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: FlowExt.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.FlowExtKt$simpleScan$1", f = "FlowExt.kt", i = {0, 0}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE, ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE}, m = "invokeSuspend", n = {"$this$flow", "accumulator"}, s = {"L$0", "L$1"})
/* loaded from: classes3.dex */
final class FlowExtKt$simpleScan$1<R> extends SuspendLambda implements Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ R $initial;
    final /* synthetic */ Function3<R, T, Continuation<? super R>, Object> $operation;
    final /* synthetic */ Flow<T> $this_simpleScan;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowExtKt$simpleScan$1(R r, Flow<? extends T> flow, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super FlowExtKt$simpleScan$1> continuation) {
        super(2, continuation);
        this.$initial = r;
        this.$this_simpleScan = flow;
        this.$operation = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowExtKt$simpleScan$1 flowExtKt$simpleScan$1 = new FlowExtKt$simpleScan$1(this.$initial, this.$this_simpleScan, this.$operation, continuation);
        flowExtKt$simpleScan$1.L$0 = obj;
        return flowExtKt$simpleScan$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((FlowCollector) ((FlowCollector) obj), continuation);
    }

    public final Object invoke(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
        return ((FlowExtKt$simpleScan$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0062, code lost:
        if (r6.$this_simpleScan.collect(new androidx.paging.FlowExtKt$simpleScan$1.AnonymousClass1(r1, r6.$operation, r3), r6) == r0) goto L14;
     */
    /* JADX WARN: Type inference failed for: r4v0, types: [R, T] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Ref.ObjectRef objectRef;
        FlowCollector flowCollector;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector2 = (FlowCollector) this.L$0;
            objectRef = new Ref.ObjectRef();
            objectRef.element = this.$initial;
            this.L$0 = flowCollector2;
            this.L$1 = objectRef;
            this.label = 1;
            if (flowCollector2.emit(objectRef.element, this) != coroutine_suspended) {
                flowCollector = flowCollector2;
            }
            return coroutine_suspended;
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            objectRef = (Ref.ObjectRef) this.L$1;
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowExt.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.paging.FlowExtKt$simpleScan$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ FlowCollector<R> $$this$flow;
        final /* synthetic */ Ref.ObjectRef<R> $accumulator;
        final /* synthetic */ Function3<R, T, Continuation<? super R>, Object> $operation;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Ref.ObjectRef<R> objectRef, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3, FlowCollector<? super R> flowCollector) {
            this.$accumulator = objectRef;
            this.$operation = function3;
            this.$$this$flow = flowCollector;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x006e, code lost:
            if (r2.$$this$flow.emit(r8, r0) != r1) goto L11;
         */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(T t, Continuation<? super Unit> continuation) {
            FlowExtKt$simpleScan$1$1$emit$1 flowExtKt$simpleScan$1$1$emit$1;
            int i;
            Ref.ObjectRef<R> objectRef;
            AnonymousClass1<T> anonymousClass1;
            if (continuation instanceof FlowExtKt$simpleScan$1$1$emit$1) {
                flowExtKt$simpleScan$1$1$emit$1 = (FlowExtKt$simpleScan$1$1$emit$1) continuation;
                if ((flowExtKt$simpleScan$1$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                    flowExtKt$simpleScan$1$1$emit$1.label -= Integer.MIN_VALUE;
                    T t2 = (T) flowExtKt$simpleScan$1$1$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = flowExtKt$simpleScan$1$1$emit$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(t2);
                        Ref.ObjectRef<R> objectRef2 = this.$accumulator;
                        Function3<R, T, Continuation<? super R>, Object> function3 = this.$operation;
                        R r = objectRef2.element;
                        flowExtKt$simpleScan$1$1$emit$1.L$0 = this;
                        flowExtKt$simpleScan$1$1$emit$1.L$1 = objectRef2;
                        flowExtKt$simpleScan$1$1$emit$1.label = 1;
                        Object invoke = function3.invoke(r, t, flowExtKt$simpleScan$1$1$emit$1);
                        if (invoke != coroutine_suspended) {
                            t2 = invoke;
                            objectRef = objectRef2;
                            anonymousClass1 = this;
                        }
                        return coroutine_suspended;
                    } else if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(t2);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        objectRef = (Ref.ObjectRef) flowExtKt$simpleScan$1$1$emit$1.L$1;
                        anonymousClass1 = (AnonymousClass1) flowExtKt$simpleScan$1$1$emit$1.L$0;
                        ResultKt.throwOnFailure(t2);
                    }
                    objectRef.element = t2;
                    R r2 = anonymousClass1.$accumulator.element;
                    flowExtKt$simpleScan$1$1$emit$1.L$0 = null;
                    flowExtKt$simpleScan$1$1$emit$1.L$1 = null;
                    flowExtKt$simpleScan$1$1$emit$1.label = 2;
                }
            }
            flowExtKt$simpleScan$1$1$emit$1 = new FlowExtKt$simpleScan$1$1$emit$1(this, continuation);
            T t22 = (T) flowExtKt$simpleScan$1$1$emit$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = flowExtKt$simpleScan$1$1$emit$1.label;
            if (i != 0) {
            }
            objectRef.element = t22;
            R r22 = anonymousClass1.$accumulator.element;
            flowExtKt$simpleScan$1$1$emit$1.L$0 = null;
            flowExtKt$simpleScan$1$1$emit$1.L$1 = null;
            flowExtKt$simpleScan$1$1$emit$1.label = 2;
        }
    }
}
