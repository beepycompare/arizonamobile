package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.OnTimeoutKt;
import kotlinx.coroutines.selects.SelectImplementation;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Delay.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {215, 415}, m = "invokeSuspend", n = {"$this$scopedFlow", "downstream", "values", "lastValue", "timeoutMillis", "$this$scopedFlow", "downstream", "values", "lastValue", "timeoutMillis", "$this$select_u24lambda_u240$iv", "$i$f$select", "$i$a$-run-SelectKt$select$2$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1"}, v = 1)
/* loaded from: classes5.dex */
public final class FlowKt__DelayKt$debounceInternal$1<T> extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<T> $this_debounceInternal;
    final /* synthetic */ Function1<T, Long> $timeoutMillisSelector;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounceInternal$1(Function1<? super T, Long> function1, Flow<? extends T> flow, Continuation<? super FlowKt__DelayKt$debounceInternal$1> continuation) {
        super(3, continuation);
        this.$timeoutMillisSelector = function1;
        this.$this_debounceInternal = flow;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object obj, Continuation<? super Unit> continuation) {
        return invoke(coroutineScope, (FlowCollector) ((FlowCollector) obj), continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(this.$timeoutMillisSelector, this.$this_debounceInternal, continuation);
        flowKt__DelayKt$debounceInternal$1.L$0 = coroutineScope;
        flowKt__DelayKt$debounceInternal$1.L$1 = flowCollector;
        return flowKt__DelayKt$debounceInternal$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b7, code lost:
        if (r1.emit(r7, r17) == r8) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0133, code lost:
        if (r6.doSelect(r17) != r8) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0135, code lost:
        return r8;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0139  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0133 -> B:7:0x0030). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Ref.ObjectRef objectRef;
        ReceiveChannel receiveChannel;
        Ref.LongRef longRef;
        Ref.LongRef longRef2;
        Ref.ObjectRef objectRef2;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        FlowCollector flowCollector = (FlowCollector) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        int i2 = 1;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ReceiveChannel produce$default = ProduceKt.produce$default(coroutineScope, null, 0, new FlowKt__DelayKt$debounceInternal$1$values$1(this.$this_debounceInternal, null), 3, null);
            objectRef = new Ref.ObjectRef();
            receiveChannel = produce$default;
            if (objectRef.element == NullSurrogateKt.DONE) {
            }
        } else if (i == 1) {
            longRef = (Ref.LongRef) this.L$4;
            objectRef = (Ref.ObjectRef) this.L$3;
            receiveChannel = (ReceiveChannel) this.L$2;
            ResultKt.throwOnFailure(obj);
            objectRef.element = null;
            Ref.ObjectRef objectRef3 = objectRef;
            longRef2 = longRef;
            objectRef2 = objectRef3;
            if (!DebugKt.getASSERTIONS_ENABLED()) {
            }
            SelectImplementation selectImplementation = new SelectImplementation(getContext());
            SelectImplementation selectImplementation2 = selectImplementation;
            if (objectRef2.element != null) {
            }
            selectImplementation2.invoke(receiveChannel.getOnReceiveCatching(), new FlowKt__DelayKt$debounceInternal$1$3$2(objectRef2, flowCollector, null));
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = flowCollector;
            this.L$2 = receiveChannel;
            this.L$3 = objectRef2;
            this.L$4 = SpillingKt.nullOutSpilledVariable(longRef2);
            this.L$5 = SpillingKt.nullOutSpilledVariable(selectImplementation);
            this.I$0 = 0;
            this.I$1 = 0;
            this.label = 2;
        } else if (i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            SelectImplementation selectImplementation3 = (SelectImplementation) this.L$5;
            Ref.LongRef longRef3 = (Ref.LongRef) this.L$4;
            objectRef2 = (Ref.ObjectRef) this.L$3;
            ResultKt.throwOnFailure(obj);
            receiveChannel = (ReceiveChannel) this.L$2;
            objectRef = objectRef2;
            i2 = 1;
            if (objectRef.element == NullSurrogateKt.DONE) {
                longRef = new Ref.LongRef();
                if (objectRef.element != null) {
                    Function1<T, Long> function1 = this.$timeoutMillisSelector;
                    Symbol symbol = NullSurrogateKt.NULL;
                    T t = objectRef.element;
                    if (t == symbol) {
                        t = null;
                    }
                    longRef.element = function1.invoke(t).longValue();
                    if (longRef.element < 0) {
                        throw new IllegalArgumentException("Debounce timeout should not be negative".toString());
                    }
                    if (longRef.element == 0) {
                        Symbol symbol2 = NullSurrogateKt.NULL;
                        T t2 = objectRef.element;
                        if (t2 == symbol2) {
                            t2 = null;
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                        this.L$1 = flowCollector;
                        this.L$2 = receiveChannel;
                        this.L$3 = objectRef;
                        this.L$4 = longRef;
                        this.L$5 = null;
                        this.label = i2;
                    }
                }
                Ref.ObjectRef objectRef32 = objectRef;
                longRef2 = longRef;
                objectRef2 = objectRef32;
                if (!DebugKt.getASSERTIONS_ENABLED() && objectRef2.element != null && longRef2.element <= 0) {
                    throw new AssertionError();
                }
                SelectImplementation selectImplementation4 = new SelectImplementation(getContext());
                SelectImplementation selectImplementation22 = selectImplementation4;
                if (objectRef2.element != null) {
                    OnTimeoutKt.onTimeout(selectImplementation22, longRef2.element, new FlowKt__DelayKt$debounceInternal$1$3$1(flowCollector, objectRef2, null));
                }
                selectImplementation22.invoke(receiveChannel.getOnReceiveCatching(), new FlowKt__DelayKt$debounceInternal$1$3$2(objectRef2, flowCollector, null));
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = flowCollector;
                this.L$2 = receiveChannel;
                this.L$3 = objectRef2;
                this.L$4 = SpillingKt.nullOutSpilledVariable(longRef2);
                this.L$5 = SpillingKt.nullOutSpilledVariable(selectImplementation4);
                this.I$0 = 0;
                this.I$1 = 0;
                this.label = 2;
            } else {
                return Unit.INSTANCE;
            }
        }
    }
}
