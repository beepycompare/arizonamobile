package kotlinx.coroutines.rx2;

import io.reactivex.ObservableEmitter;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RxConvert.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.rx2.RxConvertKt$asObservable$1$job$1", f = "RxConvert.kt", i = {0}, l = {113}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"}, v = 1)
/* loaded from: classes5.dex */
public final class RxConvertKt$asObservable$1$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ObservableEmitter<T> $emitter;
    final /* synthetic */ Flow<T> $this_asObservable;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RxConvertKt$asObservable$1$job$1(Flow<? extends T> flow, ObservableEmitter<T> observableEmitter, Continuation<? super RxConvertKt$asObservable$1$job$1> continuation) {
        super(2, continuation);
        this.$this_asObservable = flow;
        this.$emitter = observableEmitter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RxConvertKt$asObservable$1$job$1 rxConvertKt$asObservable$1$job$1 = new RxConvertKt$asObservable$1$job$1(this.$this_asObservable, this.$emitter, continuation);
        rxConvertKt$asObservable$1$job$1.L$0 = obj;
        return rxConvertKt$asObservable$1$job$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RxConvertKt$asObservable$1$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<T> flow = this.$this_asObservable;
                final ObservableEmitter<T> observableEmitter = this.$emitter;
                this.L$0 = coroutineScope;
                this.label = 1;
                if (flow.collect(new FlowCollector() { // from class: kotlinx.coroutines.rx2.RxConvertKt$asObservable$1$job$1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(T t, Continuation<? super Unit> continuation) {
                        observableEmitter.onNext(t);
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            this.$emitter.onComplete();
        } catch (Throwable th) {
            boolean z = th instanceof CancellationException;
            ObservableEmitter<T> observableEmitter2 = this.$emitter;
            if (!z) {
                if (!observableEmitter2.tryOnError(th)) {
                    RxCancellableKt.handleUndeliverableException(th, coroutineScope.getCoroutineContext());
                }
            } else {
                observableEmitter2.onComplete();
            }
        }
        return Unit.INSTANCE;
    }
}
