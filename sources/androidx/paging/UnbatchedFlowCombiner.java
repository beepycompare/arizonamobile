package androidx.paging;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
/* compiled from: FlowExt.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003Bd\u0012[\u0010\u0004\u001aW\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u0086@¢\u0006\u0002\u0010\u001eRe\u0010\u0004\u001aW\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00120\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0018\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019¨\u0006\u001f"}, d2 = {"Landroidx/paging/UnbatchedFlowCombiner;", "T1", "T2", "", "send", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "t1", "t2", "Landroidx/paging/CombineSource;", "updateFrom", "Lkotlin/coroutines/Continuation;", "", "<init>", "(Lkotlin/jvm/functions/Function4;)V", "Lkotlin/jvm/functions/Function4;", "initialDispatched", "Lkotlinx/coroutines/CompletableDeferred;", "lock", "Lkotlinx/coroutines/sync/Mutex;", "valueReceived", "", "[Lkotlinx/coroutines/CompletableDeferred;", "values", "[Ljava/lang/Object;", "onNext", FirebaseAnalytics.Param.INDEX, "", "value", "(ILjava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UnbatchedFlowCombiner<T1, T2> {
    private final CompletableDeferred<Unit> initialDispatched;
    private final Mutex lock;
    private final Function4<T1, T2, CombineSource, Continuation<? super Unit>, Object> send;
    private final CompletableDeferred<Unit>[] valueReceived;
    private final Object[] values;

    /* JADX WARN: Multi-variable type inference failed */
    public UnbatchedFlowCombiner(Function4<? super T1, ? super T2, ? super CombineSource, ? super Continuation<? super Unit>, ? extends Object> send) {
        Object obj;
        Intrinsics.checkNotNullParameter(send, "send");
        this.send = send;
        this.initialDispatched = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.lock = MutexKt.Mutex$default(false, 1, null);
        CompletableDeferred<Unit>[] completableDeferredArr = new CompletableDeferred[2];
        for (int i = 0; i < 2; i++) {
            completableDeferredArr[i] = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        }
        this.valueReceived = completableDeferredArr;
        Object[] objArr = new Object[2];
        for (int i2 = 0; i2 < 2; i2++) {
            obj = FlowExtKt.NULL;
            objArr[i2] = obj;
        }
        this.values = objArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006e, code lost:
        if (r14.await(r0) == r1) goto L46;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0099 A[Catch: all -> 0x00ed, TryCatch #1 {all -> 0x00ed, blocks: (B:32:0x0092, B:34:0x0099, B:39:0x00a7, B:41:0x00af, B:44:0x00b9, B:46:0x00be, B:50:0x00c8, B:48:0x00c3, B:49:0x00c6, B:37:0x00a3), top: B:64:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00af A[Catch: all -> 0x00ed, TryCatch #1 {all -> 0x00ed, blocks: (B:32:0x0092, B:34:0x0099, B:39:0x00a7, B:41:0x00af, B:44:0x00b9, B:46:0x00be, B:50:0x00c8, B:48:0x00c3, B:49:0x00c6, B:37:0x00a3), top: B:64:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00be A[Catch: all -> 0x00ed, TryCatch #1 {all -> 0x00ed, blocks: (B:32:0x0092, B:34:0x0099, B:39:0x00a7, B:41:0x00af, B:44:0x00b9, B:46:0x00be, B:50:0x00c8, B:48:0x00c3, B:49:0x00c6, B:37:0x00a3), top: B:64:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00a6 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object onNext(int i, Object obj, Continuation<? super Unit> continuation) {
        UnbatchedFlowCombiner$onNext$1 unbatchedFlowCombiner$onNext$1;
        Object coroutine_suspended;
        int i2;
        Mutex mutex;
        Object obj2;
        Mutex mutex2;
        Mutex mutex3;
        int length;
        int i3;
        boolean z;
        CombineSource combineSource;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        if (continuation instanceof UnbatchedFlowCombiner$onNext$1) {
            unbatchedFlowCombiner$onNext$1 = (UnbatchedFlowCombiner$onNext$1) continuation;
            if ((unbatchedFlowCombiner$onNext$1.label & Integer.MIN_VALUE) != 0) {
                unbatchedFlowCombiner$onNext$1.label -= Integer.MIN_VALUE;
                Object obj7 = unbatchedFlowCombiner$onNext$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = unbatchedFlowCombiner$onNext$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj7);
                    if (this.valueReceived[i].isCompleted()) {
                        CompletableDeferred<Unit> completableDeferred = this.initialDispatched;
                        unbatchedFlowCombiner$onNext$1.L$0 = obj;
                        unbatchedFlowCombiner$onNext$1.I$0 = i;
                        unbatchedFlowCombiner$onNext$1.label = 1;
                    } else {
                        Boxing.boxBoolean(this.valueReceived[i].complete(Unit.INSTANCE));
                    }
                } else if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            mutex3 = (Mutex) unbatchedFlowCombiner$onNext$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj7);
                                this.initialDispatched.complete(Unit.INSTANCE);
                                Unit unit = Unit.INSTANCE;
                                mutex3.unlock(null);
                                return Unit.INSTANCE;
                            } catch (Throwable th) {
                                th = th;
                                mutex3.unlock(null);
                                throw th;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i = unbatchedFlowCombiner$onNext$1.I$0;
                    mutex2 = (Mutex) unbatchedFlowCombiner$onNext$1.L$1;
                    obj2 = unbatchedFlowCombiner$onNext$1.L$0;
                    ResultKt.throwOnFailure(obj7);
                    try {
                        Object[] objArr = this.values;
                        length = objArr.length;
                        i3 = 0;
                        while (true) {
                            if (i3 < length) {
                                z = false;
                                break;
                            }
                            Object obj8 = objArr[i3];
                            obj6 = FlowExtKt.NULL;
                            if (obj8 == obj6) {
                                z = true;
                                break;
                            }
                            i3++;
                        }
                        Object[] objArr2 = this.values;
                        objArr2[i] = obj2;
                        for (Object obj9 : objArr2) {
                            obj5 = FlowExtKt.NULL;
                            if (obj9 == obj5) {
                                mutex3 = mutex2;
                                break;
                            }
                        }
                        if (!z) {
                            combineSource = CombineSource.INITIAL;
                        } else if (i == 0) {
                            combineSource = CombineSource.RECEIVER;
                        } else {
                            combineSource = CombineSource.OTHER;
                        }
                        Object[] objArr3 = this.values;
                        obj3 = objArr3[0];
                        obj4 = objArr3[1];
                        unbatchedFlowCombiner$onNext$1.L$0 = mutex2;
                        unbatchedFlowCombiner$onNext$1.L$1 = null;
                        unbatchedFlowCombiner$onNext$1.label = 3;
                        if (this.send.invoke(obj3, obj4, combineSource, unbatchedFlowCombiner$onNext$1) != coroutine_suspended) {
                            mutex3 = mutex2;
                            this.initialDispatched.complete(Unit.INSTANCE);
                            Unit unit2 = Unit.INSTANCE;
                            mutex3.unlock(null);
                            return Unit.INSTANCE;
                        }
                        return coroutine_suspended;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex3 = mutex2;
                        mutex3.unlock(null);
                        throw th;
                    }
                } else {
                    i = unbatchedFlowCombiner$onNext$1.I$0;
                    obj = unbatchedFlowCombiner$onNext$1.L$0;
                    ResultKt.throwOnFailure(obj7);
                }
                mutex = this.lock;
                unbatchedFlowCombiner$onNext$1.L$0 = obj;
                unbatchedFlowCombiner$onNext$1.L$1 = mutex;
                unbatchedFlowCombiner$onNext$1.I$0 = i;
                unbatchedFlowCombiner$onNext$1.label = 2;
                if (mutex.lock(null, unbatchedFlowCombiner$onNext$1) != coroutine_suspended) {
                    obj2 = obj;
                    mutex2 = mutex;
                    Object[] objArr4 = this.values;
                    length = objArr4.length;
                    i3 = 0;
                    while (true) {
                        if (i3 < length) {
                        }
                        i3++;
                    }
                    Object[] objArr22 = this.values;
                    objArr22[i] = obj2;
                    while (r8 < r2) {
                    }
                    if (!z) {
                    }
                    Object[] objArr32 = this.values;
                    obj3 = objArr32[0];
                    obj4 = objArr32[1];
                    unbatchedFlowCombiner$onNext$1.L$0 = mutex2;
                    unbatchedFlowCombiner$onNext$1.L$1 = null;
                    unbatchedFlowCombiner$onNext$1.label = 3;
                    if (this.send.invoke(obj3, obj4, combineSource, unbatchedFlowCombiner$onNext$1) != coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            }
        }
        unbatchedFlowCombiner$onNext$1 = new UnbatchedFlowCombiner$onNext$1(this, continuation);
        Object obj72 = unbatchedFlowCombiner$onNext$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = unbatchedFlowCombiner$onNext$1.label;
        if (i2 != 0) {
        }
        mutex = this.lock;
        unbatchedFlowCombiner$onNext$1.L$0 = obj;
        unbatchedFlowCombiner$onNext$1.L$1 = mutex;
        unbatchedFlowCombiner$onNext$1.I$0 = i;
        unbatchedFlowCombiner$onNext$1.label = 2;
        if (mutex.lock(null, unbatchedFlowCombiner$onNext$1) != coroutine_suspended) {
        }
        return coroutine_suspended;
    }
}
