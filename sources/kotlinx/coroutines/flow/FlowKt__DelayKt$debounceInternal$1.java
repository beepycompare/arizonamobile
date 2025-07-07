package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
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
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {215, 415}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "timeoutMillis", "downstream", "values", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
/* loaded from: classes5.dex */
public final class FlowKt__DelayKt$debounceInternal$1<T> extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<T> $this_debounceInternal;
    final /* synthetic */ Function1<T, Long> $timeoutMillisSelector;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
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

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ae, code lost:
        if (r9.emit(r10, r13) == r0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0113, code lost:
        if (r9.doSelect(r13) != r0) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0115, code lost:
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0116  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0113 -> B:7:0x0020). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Ref.ObjectRef objectRef;
        FlowCollector flowCollector;
        ReceiveChannel receiveChannel;
        Ref.LongRef longRef;
        Ref.ObjectRef objectRef2;
        ReceiveChannel receiveChannel2;
        FlowCollector flowCollector2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ReceiveChannel produce$default = ProduceKt.produce$default((CoroutineScope) this.L$0, null, 0, new FlowKt__DelayKt$debounceInternal$1$values$1(this.$this_debounceInternal, null), 3, null);
            objectRef = new Ref.ObjectRef();
            flowCollector = (FlowCollector) this.L$1;
            receiveChannel = produce$default;
            if (objectRef.element == NullSurrogateKt.DONE) {
            }
        } else if (i == 1) {
            longRef = (Ref.LongRef) this.L$3;
            objectRef = (Ref.ObjectRef) this.L$2;
            receiveChannel = (ReceiveChannel) this.L$1;
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
            objectRef.element = null;
            Ref.LongRef longRef2 = longRef;
            objectRef2 = objectRef;
            receiveChannel2 = receiveChannel;
            flowCollector2 = flowCollector;
            if (!DebugKt.getASSERTIONS_ENABLED()) {
            }
            SelectImplementation selectImplementation = new SelectImplementation(getContext());
            SelectImplementation selectImplementation2 = selectImplementation;
            if (objectRef2.element != null) {
            }
            selectImplementation2.invoke(receiveChannel2.getOnReceiveCatching(), new FlowKt__DelayKt$debounceInternal$1$3$2(objectRef2, flowCollector2, null));
            this.L$0 = flowCollector2;
            this.L$1 = receiveChannel2;
            this.L$2 = objectRef2;
            this.L$3 = null;
            this.label = 2;
        } else if (i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            objectRef2 = (Ref.ObjectRef) this.L$2;
            receiveChannel2 = (ReceiveChannel) this.L$1;
            flowCollector2 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
            flowCollector = flowCollector2;
            receiveChannel = receiveChannel2;
            objectRef = objectRef2;
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
                        this.L$0 = flowCollector;
                        this.L$1 = receiveChannel;
                        this.L$2 = objectRef;
                        this.L$3 = longRef;
                        this.label = 1;
                    }
                }
                Ref.LongRef longRef22 = longRef;
                objectRef2 = objectRef;
                receiveChannel2 = receiveChannel;
                flowCollector2 = flowCollector;
                if (!DebugKt.getASSERTIONS_ENABLED() && objectRef2.element != null && longRef22.element <= 0) {
                    throw new AssertionError();
                }
                SelectImplementation selectImplementation3 = new SelectImplementation(getContext());
                SelectImplementation selectImplementation22 = selectImplementation3;
                if (objectRef2.element != null) {
                    OnTimeoutKt.onTimeout(selectImplementation22, longRef22.element, new FlowKt__DelayKt$debounceInternal$1$3$1(flowCollector2, objectRef2, null));
                }
                selectImplementation22.invoke(receiveChannel2.getOnReceiveCatching(), new FlowKt__DelayKt$debounceInternal$1$3$2(objectRef2, flowCollector2, null));
                this.L$0 = flowCollector2;
                this.L$1 = receiveChannel2;
                this.L$2 = objectRef2;
                this.L$3 = null;
                this.label = 2;
            } else {
                return Unit.INSTANCE;
            }
        }
    }
}
