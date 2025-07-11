package kotlinx.coroutines.reactive;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.widget.FacebookDialog;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* compiled from: Publish.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005B7\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0016J\u001e\u0010\u001b\u001a\u00020\u001c2\u0014\u0010\u001d\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00030\u001eH\u0016J\u001e\u0010'\u001a\u00020\u00032\n\u0010(\u001a\u0006\u0012\u0002\b\u00030)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u001e\u0010,\u001a\u0004\u0018\u00010+2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010-\u001a\u0004\u0018\u00010+H\u0002J\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00030/2\u0006\u0010*\u001a\u00028\u0000H\u0016¢\u0006\u0004\b0\u00101J\u0016\u00102\u001a\u00020\u00032\u0006\u0010*\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u00103J\u0017\u00104\u001a\u0004\u0018\u00010\f2\u0006\u00105\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00106J\b\u00107\u001a\u00020\u0003H\u0002J\u001a\u00108\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\f2\u0006\u00109\u001a\u00020\u0016H\u0002J\u0010\u0010:\u001a\u00020\u00032\u0006\u0010;\u001a\u00020<H\u0016J\u001a\u0010=\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\f2\u0006\u00109\u001a\u00020\u0016H\u0002J\u0015\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u0003H\u0014¢\u0006\u0002\u0010@J\u0018\u0010A\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\f2\u0006\u00109\u001a\u00020\u0016H\u0014J\b\u0010B\u001a\u00020\u0003H\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\t\u0010\u0013\u001a\u00020\u0014X\u0082\u0004R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010!\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00100\"8VX\u0096\u0004¢\u0006\f\u0012\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006C"}, d2 = {"Lkotlinx/coroutines/reactive/PublisherCoroutine;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lorg/reactivestreams/Subscription;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "subscriber", "Lorg/reactivestreams/Subscriber;", "exceptionOnCancelHandler", "Lkotlin/Function2;", "", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lorg/reactivestreams/Subscriber;Lkotlin/jvm/functions/Function2;)V", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "_nRequested", "Lkotlinx/atomicfu/AtomicLong;", "cancelled", "", "isClosedForSend", "()Z", "close", "cause", "invokeOnClose", "", "handler", "Lkotlin/Function1;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend$annotations", "()V", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "registerSelectForSend", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "element", "", "processResultSelectSend", "selectResult", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doLockedNext", "elem", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "unlockAndCheckCompleted", "doLockedSignalCompleted", "handled", "request", "n", "", "signalCompleted", "onCompleted", "value", "(Lkotlin/Unit;)V", "onCancelled", FacebookDialog.COMPLETION_GESTURE_CANCEL, "kotlinx-coroutines-reactive"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PublisherCoroutine<T> extends AbstractCoroutine<Unit> implements ProducerScope<T>, Subscription {
    private static final /* synthetic */ AtomicLongFieldUpdater _nRequested$volatile$FU = AtomicLongFieldUpdater.newUpdater(PublisherCoroutine.class, "_nRequested$volatile");
    private volatile /* synthetic */ long _nRequested$volatile;
    private volatile boolean cancelled;
    private final Function2<Throwable, CoroutineContext, Unit> exceptionOnCancelHandler;
    private final Mutex mutex;
    private final Subscriber<T> subscriber;

    public static /* synthetic */ void getOnSend$annotations() {
    }

    private final /* synthetic */ long get_nRequested$volatile() {
        return this._nRequested$volatile;
    }

    private final /* synthetic */ void set_nRequested$volatile(long j) {
        this._nRequested$volatile = j;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: invokeOnClose  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ void mo10066invokeOnClose(Function1 function1) {
        invokeOnClose((Function1<? super Throwable, Unit>) function1);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(T t) {
        return ProducerScope.DefaultImpls.offer(this, t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PublisherCoroutine(CoroutineContext coroutineContext, Subscriber<T> subscriber, Function2<? super Throwable, ? super CoroutineContext, Unit> function2) {
        super(coroutineContext, false, true);
        this.subscriber = subscriber;
        this.exceptionOnCancelHandler = function2;
        this.mutex = MutexKt.Mutex(true);
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
        throw new UnsupportedOperationException("PublisherCoroutine doesn't support invokeOnClose");
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public SelectClause2<T, SendChannel<T>> getOnSend() {
        PublisherCoroutine$onSend$1 publisherCoroutine$onSend$1 = PublisherCoroutine$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(publisherCoroutine$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        PublisherCoroutine$onSend$2 publisherCoroutine$onSend$2 = PublisherCoroutine$onSend$2.INSTANCE;
        Intrinsics.checkNotNull(publisherCoroutine$onSend$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause2Impl(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(publisherCoroutine$onSend$1, 3), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(publisherCoroutine$onSend$2, 3), null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerSelectForSend(SelectInstance<?> selectInstance, Object obj) {
        if (!Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new PublisherCoroutine$registerSelectForSend$1(this, selectInstance, null), 3, null);
        } else {
            selectInstance.selectInRegistrationPhase(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object processResultSelectSend(Object obj, Object obj2) {
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
        PublisherCoroutine$send$1 publisherCoroutine$send$1;
        int i;
        PublisherCoroutine<T> publisherCoroutine;
        Throwable doLockedNext;
        if (continuation instanceof PublisherCoroutine$send$1) {
            publisherCoroutine$send$1 = (PublisherCoroutine$send$1) continuation;
            if ((publisherCoroutine$send$1.label & Integer.MIN_VALUE) != 0) {
                publisherCoroutine$send$1.label -= Integer.MIN_VALUE;
                Object obj = publisherCoroutine$send$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = publisherCoroutine$send$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Mutex mutex = this.mutex;
                    publisherCoroutine$send$1.L$0 = this;
                    publisherCoroutine$send$1.L$1 = t;
                    publisherCoroutine$send$1.label = 1;
                    if (Mutex.DefaultImpls.lock$default(mutex, null, publisherCoroutine$send$1, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    publisherCoroutine = this;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    t = (T) publisherCoroutine$send$1.L$1;
                    publisherCoroutine = (PublisherCoroutine) publisherCoroutine$send$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                doLockedNext = publisherCoroutine.doLockedNext(t);
                if (doLockedNext == null) {
                    throw doLockedNext;
                }
                return Unit.INSTANCE;
            }
        }
        publisherCoroutine$send$1 = new PublisherCoroutine$send$1(this, continuation);
        Object obj2 = publisherCoroutine$send$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = publisherCoroutine$send$1.label;
        if (i != 0) {
        }
        doLockedNext = publisherCoroutine.doLockedNext(t);
        if (doLockedNext == null) {
        }
    }

    private final Throwable doLockedNext(T t) {
        long j;
        long j2;
        if (t == null) {
            unlockAndCheckCompleted();
            throw new NullPointerException("Attempted to emit `null` inside a reactive publisher");
        } else if (!isActive()) {
            unlockAndCheckCompleted();
            return getCancellationException();
        } else {
            try {
                this.subscriber.onNext(t);
                do {
                    j = _nRequested$volatile$FU.get(this);
                    if (j < 0 || j == Long.MAX_VALUE) {
                        break;
                    }
                    j2 = j - 1;
                } while (!_nRequested$volatile$FU.compareAndSet(this, j, j2));
                if (j2 == 0) {
                    return null;
                }
                unlockAndCheckCompleted();
                return null;
            } catch (Throwable th) {
                this.cancelled = true;
                boolean close = close(th);
                unlockAndCheckCompleted();
                if (close) {
                    return th;
                }
                this.exceptionOnCancelHandler.invoke(th, getContext());
                return getCancellationException();
            }
        }
    }

    private final void unlockAndCheckCompleted() {
        Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
        if (isCompleted() && Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            doLockedSignalCompleted(getCompletionCause(), getCompletionCauseHandled());
        }
    }

    private final void doLockedSignalCompleted(Throwable th, boolean z) {
        try {
            if (_nRequested$volatile$FU.get(this) != -2) {
                _nRequested$volatile$FU.set(this, -2L);
                if (this.cancelled) {
                    if (th != null && !z) {
                        this.exceptionOnCancelHandler.invoke(th, getContext());
                    }
                } else if (th == null) {
                    this.subscriber.onComplete();
                } else {
                    this.subscriber.onError(th);
                }
            }
        } finally {
            Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        long j2;
        int i;
        long j3;
        if (j <= 0) {
            cancelCoroutine(new IllegalArgumentException("non-positive subscription request " + j));
            return;
        }
        do {
            j2 = _nRequested$volatile$FU.get(this);
            i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i < 0) {
                return;
            }
            long j4 = j2 + j;
            j3 = (j4 < 0 || j == Long.MAX_VALUE) ? Long.MAX_VALUE : j4;
            if (j2 == j3) {
                return;
            }
        } while (!_nRequested$volatile$FU.compareAndSet(this, j2, j3));
        if (i == 0) {
            unlockAndCheckCompleted();
        }
    }

    private final void signalCompleted(Throwable th, boolean z) {
        long j;
        int i;
        do {
            j = _nRequested$volatile$FU.get(this);
            if (j == -2) {
                return;
            }
            i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i < 0) {
                throw new IllegalStateException("Check failed.");
            }
        } while (!_nRequested$volatile$FU.compareAndSet(this, j, -1L));
        if (i == 0) {
            doLockedSignalCompleted(th, z);
        } else if (Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
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

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public void cancel() {
        this.cancelled = true;
        super.cancel((CancellationException) null);
    }
}
