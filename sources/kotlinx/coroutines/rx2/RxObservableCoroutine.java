package kotlinx.coroutines.rx2;

import androidx.exifinterface.media.ExifInterface;
import io.reactivex.ObservableEmitter;
import io.reactivex.exceptions.UndeliverableException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RxObservable.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0005B\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001e\u0010\u0018\u001a\u00020\u00192\u0014\u0010\u001a\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00040\u001bH\u0016J\u001e\u0010$\u001a\u00020\u00042\n\u0010%\u001a\u0006\u0012\u0002\b\u00030&2\b\u0010'\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010(\u001a\u0004\u0018\u00010\u00022\b\u0010'\u001a\u0004\u0018\u00010\u00022\b\u0010)\u001a\u0004\u0018\u00010\u0002H\u0002J\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040+2\u0006\u0010'\u001a\u00028\u0000H\u0016¢\u0006\u0004\b,\u0010-J\u0016\u0010.\u001a\u00020\u00042\u0006\u0010'\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010/J\u0017\u00100\u001a\u0004\u0018\u00010\u00172\u0006\u00101\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00102J\b\u00103\u001a\u00020\u0004H\u0002J\u001a\u00104\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u00105\u001a\u00020\u0013H\u0002J\u001a\u00106\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u00105\u001a\u00020\u0013H\u0002J\u0015\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u0004H\u0014¢\u0006\u0002\u00109J\u0018\u0010:\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u0013H\u0014R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\t\u0010\u0010\u001a\u00020\u0011X\u0082\u0004R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\u001f8VX\u0096\u0004¢\u0006\f\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006;"}, d2 = {"Lkotlinx/coroutines/rx2/RxObservableCoroutine;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/ProducerScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "subscriber", "Lio/reactivex/ObservableEmitter;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lio/reactivex/ObservableEmitter;)V", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "_signal", "Lkotlinx/atomicfu/AtomicInt;", "isClosedForSend", "", "()Z", "close", "cause", "", "invokeOnClose", "", "handler", "Lkotlin/Function1;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend$annotations", "()V", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "registerSelectForSend", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "element", "processResultSelectSend", "selectResult", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doLockedNext", "elem", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "unlockAndCheckCompleted", "doLockedSignalCompleted", "handled", "signalCompleted", "onCompleted", "value", "(Lkotlin/Unit;)V", "onCancelled", "kotlinx-coroutines-rx2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RxObservableCoroutine<T> extends AbstractCoroutine<Unit> implements ProducerScope<T> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater _signal$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(RxObservableCoroutine.class, "_signal$volatile");
    private volatile /* synthetic */ int _signal$volatile;
    private final Mutex mutex;
    private final ObservableEmitter<T> subscriber;

    public static /* synthetic */ void getOnSend$annotations() {
    }

    private final /* synthetic */ int get_signal$volatile() {
        return this._signal$volatile;
    }

    private final /* synthetic */ void set_signal$volatile(int i) {
        this._signal$volatile = i;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: invokeOnClose */
    public /* bridge */ /* synthetic */ void mo10066invokeOnClose(Function1 function1) {
        invokeOnClose((Function1<? super Throwable, Unit>) function1);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(T t) {
        return ProducerScope.DefaultImpls.offer(this, t);
    }

    public RxObservableCoroutine(CoroutineContext coroutineContext, ObservableEmitter<T> observableEmitter) {
        super(coroutineContext, false, true);
        this.subscriber = observableEmitter;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
    }

    @Override // kotlinx.coroutines.channels.ProducerScope
    public SendChannel<T> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return !isActive();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable th) {
        return cancelCoroutine(th);
    }

    public Void invokeOnClose(Function1<? super Throwable, Unit> function1) {
        throw new UnsupportedOperationException("RxObservableCoroutine doesn't support invokeOnClose");
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public SelectClause2<T, SendChannel<T>> getOnSend() {
        RxObservableCoroutine$onSend$1 rxObservableCoroutine$onSend$1 = RxObservableCoroutine$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(rxObservableCoroutine$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        RxObservableCoroutine$onSend$2 rxObservableCoroutine$onSend$2 = RxObservableCoroutine$onSend$2.INSTANCE;
        Intrinsics.checkNotNull(rxObservableCoroutine$onSend$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause2Impl(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(rxObservableCoroutine$onSend$1, 3), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(rxObservableCoroutine$onSend$2, 3), null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerSelectForSend(SelectInstance<?> selectInstance, Object obj) {
        if (!Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new RxObservableCoroutine$registerSelectForSend$1(this, selectInstance, null), 3, null);
        } else {
            selectInstance.selectInRegistrationPhase(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object processResultSelectSend(Object obj, Object obj2) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of kotlinx.coroutines.rx2.RxObservableCoroutine");
        Throwable doLockedNext = doLockedNext(obj);
        if (doLockedNext == null) {
            return this;
        }
        throw doLockedNext;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public Object mo7544trySendJP2dKIU(T t) {
        if (!Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            return ChannelResult.Companion.m10011failurePtdJZtk();
        }
        Throwable doLockedNext = doLockedNext(t);
        if (doLockedNext == null) {
            return ChannelResult.Companion.m10012successJP2dKIU(Unit.INSTANCE);
        }
        return ChannelResult.Companion.m10010closedJP2dKIU(doLockedNext);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
    @Override // kotlinx.coroutines.channels.SendChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object send(T t, Continuation<? super Unit> continuation) {
        RxObservableCoroutine$send$1 rxObservableCoroutine$send$1;
        int i;
        RxObservableCoroutine<T> rxObservableCoroutine;
        Throwable doLockedNext;
        if (continuation instanceof RxObservableCoroutine$send$1) {
            rxObservableCoroutine$send$1 = (RxObservableCoroutine$send$1) continuation;
            if ((rxObservableCoroutine$send$1.label & Integer.MIN_VALUE) != 0) {
                rxObservableCoroutine$send$1.label -= Integer.MIN_VALUE;
                Object obj = rxObservableCoroutine$send$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = rxObservableCoroutine$send$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Mutex mutex = this.mutex;
                    rxObservableCoroutine$send$1.L$0 = this;
                    rxObservableCoroutine$send$1.L$1 = t;
                    rxObservableCoroutine$send$1.label = 1;
                    if (Mutex.DefaultImpls.lock$default(mutex, null, rxObservableCoroutine$send$1, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    rxObservableCoroutine = this;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    t = (T) rxObservableCoroutine$send$1.L$1;
                    rxObservableCoroutine = (RxObservableCoroutine) rxObservableCoroutine$send$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                doLockedNext = rxObservableCoroutine.doLockedNext(t);
                if (doLockedNext == null) {
                    throw doLockedNext;
                }
                return Unit.INSTANCE;
            }
        }
        rxObservableCoroutine$send$1 = new RxObservableCoroutine$send$1(this, continuation);
        Object obj2 = rxObservableCoroutine$send$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = rxObservableCoroutine$send$1.label;
        if (i != 0) {
        }
        doLockedNext = rxObservableCoroutine.doLockedNext(t);
        if (doLockedNext == null) {
        }
    }

    private final Throwable doLockedNext(T t) {
        if (!isActive()) {
            doLockedSignalCompleted(getCompletionCause(), getCompletionCauseHandled());
            return getCancellationException();
        }
        try {
            this.subscriber.onNext(t);
            unlockAndCheckCompleted();
            return null;
        } catch (Throwable th) {
            UndeliverableException undeliverableException = new UndeliverableException(th);
            boolean close = close(undeliverableException);
            unlockAndCheckCompleted();
            if (close) {
                return undeliverableException;
            }
            RxCancellableKt.handleUndeliverableException(undeliverableException, getContext());
            return getCancellationException();
        }
    }

    private final void unlockAndCheckCompleted() {
        Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
        if (isActive() || !Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            return;
        }
        doLockedSignalCompleted(getCompletionCause(), getCompletionCauseHandled());
    }

    private final void doLockedSignalCompleted(Throwable th, boolean z) {
        Throwable th2;
        if (_signal$volatile$FU.get(this) != -2) {
            _signal$volatile$FU.set(this, -2);
            if (th != null) {
                th2 = !DebugKt.getRECOVER_STACK_TRACES() ? th : StackTraceRecoveryKt.unwrapImpl(th);
            } else {
                th2 = null;
            }
            if (th2 == null) {
                try {
                    this.subscriber.onComplete();
                } catch (Exception e) {
                    RxCancellableKt.handleUndeliverableException(e, getContext());
                }
            } else if ((th2 instanceof UndeliverableException) && !z) {
                RxCancellableKt.handleUndeliverableException(th, getContext());
            } else if (th2 != getCancellationException() || !this.subscriber.isDisposed()) {
                try {
                    this.subscriber.onError(th);
                } catch (Exception e2) {
                    ExceptionsKt.addSuppressed(th, e2);
                    RxCancellableKt.handleUndeliverableException(th, getContext());
                }
            }
            Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
        }
    }

    private final void signalCompleted(Throwable th, boolean z) {
        if (_signal$volatile$FU.compareAndSet(this, 0, -1) && Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            doLockedSignalCompleted(th, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.AbstractCoroutine
    public void onCompleted(Unit unit) {
        signalCompleted(null, false);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void onCancelled(Throwable th, boolean z) {
        signalCompleted(th, z);
    }
}
