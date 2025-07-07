package androidx.paging;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
/* compiled from: FlowExt.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003Bb\u0012[\u0010\u0004\u001aW\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005¢\u0006\u0002\u0010\u000eJ \u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0086@¢\u0006\u0002\u0010\u001dR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000Re\u0010\u0004\u001aW\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u001c\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00100\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0018\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018¨\u0006\u001e"}, d2 = {"Landroidx/paging/UnbatchedFlowCombiner;", "T1", "T2", "", "send", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "t1", "t2", "Landroidx/paging/CombineSource;", "updateFrom", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function4;)V", "initialDispatched", "Lkotlinx/coroutines/CompletableDeferred;", "lock", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlin/jvm/functions/Function4;", "valueReceived", "", "[Lkotlinx/coroutines/CompletableDeferred;", "values", "[Ljava/lang/Object;", "onNext", FirebaseAnalytics.Param.INDEX, "", "value", "(ILjava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0087, code lost:
        if (r2.await(r3) == r4) goto L47;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b4 A[Catch: all -> 0x010a, TryCatch #1 {all -> 0x010a, blocks: (B:34:0x00ad, B:36:0x00b4, B:41:0x00c2, B:43:0x00ca, B:46:0x00d4, B:48:0x00d9, B:52:0x00e3, B:50:0x00de, B:51:0x00e1, B:39:0x00be), top: B:66:0x00ad }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ca A[Catch: all -> 0x010a, TryCatch #1 {all -> 0x010a, blocks: (B:34:0x00ad, B:36:0x00b4, B:41:0x00c2, B:43:0x00ca, B:46:0x00d4, B:48:0x00d9, B:52:0x00e3, B:50:0x00de, B:51:0x00e1, B:39:0x00be), top: B:66:0x00ad }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d9 A[Catch: all -> 0x010a, TryCatch #1 {all -> 0x010a, blocks: (B:34:0x00ad, B:36:0x00b4, B:41:0x00c2, B:43:0x00ca, B:46:0x00d4, B:48:0x00d9, B:52:0x00e3, B:50:0x00de, B:51:0x00e1, B:39:0x00be), top: B:66:0x00ad }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object onNext(int i, Object obj, Continuation<? super Unit> continuation) {
        UnbatchedFlowCombiner$onNext$1 unbatchedFlowCombiner$onNext$1;
        Object coroutine_suspended;
        int i2;
        Object obj2;
        UnbatchedFlowCombiner<T1, T2> unbatchedFlowCombiner;
        Mutex mutex;
        Object obj3;
        Mutex mutex2;
        int i3;
        UnbatchedFlowCombiner<T1, T2> unbatchedFlowCombiner2;
        Mutex mutex3;
        int length;
        int i4;
        boolean z;
        CombineSource combineSource;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        int i5 = i;
        if (continuation instanceof UnbatchedFlowCombiner$onNext$1) {
            unbatchedFlowCombiner$onNext$1 = (UnbatchedFlowCombiner$onNext$1) continuation;
            if ((unbatchedFlowCombiner$onNext$1.label & Integer.MIN_VALUE) != 0) {
                unbatchedFlowCombiner$onNext$1.label -= Integer.MIN_VALUE;
                Object obj8 = unbatchedFlowCombiner$onNext$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = unbatchedFlowCombiner$onNext$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj8);
                    if (this.valueReceived[i5].isCompleted()) {
                        CompletableDeferred<Unit> completableDeferred = this.initialDispatched;
                        unbatchedFlowCombiner$onNext$1.L$0 = this;
                        obj2 = obj;
                        unbatchedFlowCombiner$onNext$1.L$1 = obj2;
                        unbatchedFlowCombiner$onNext$1.I$0 = i5;
                        unbatchedFlowCombiner$onNext$1.label = 1;
                    } else {
                        obj2 = obj;
                        this.valueReceived[i5].complete(Unit.INSTANCE);
                    }
                    unbatchedFlowCombiner = this;
                } else if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            mutex3 = (Mutex) unbatchedFlowCombiner$onNext$1.L$1;
                            unbatchedFlowCombiner2 = (UnbatchedFlowCombiner) unbatchedFlowCombiner$onNext$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj8);
                                unbatchedFlowCombiner2.initialDispatched.complete(Unit.INSTANCE);
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
                    i5 = unbatchedFlowCombiner$onNext$1.I$0;
                    mutex2 = (Mutex) unbatchedFlowCombiner$onNext$1.L$2;
                    obj3 = unbatchedFlowCombiner$onNext$1.L$1;
                    unbatchedFlowCombiner = (UnbatchedFlowCombiner) unbatchedFlowCombiner$onNext$1.L$0;
                    ResultKt.throwOnFailure(obj8);
                    i3 = i5;
                    unbatchedFlowCombiner2 = unbatchedFlowCombiner;
                    try {
                        Object[] objArr = unbatchedFlowCombiner2.values;
                        length = objArr.length;
                        i4 = 0;
                        while (true) {
                            if (i4 < length) {
                                z = false;
                                break;
                            }
                            Object obj9 = objArr[i4];
                            obj7 = FlowExtKt.NULL;
                            if (obj9 == obj7) {
                                z = true;
                                break;
                            }
                            i4++;
                        }
                        Object[] objArr2 = unbatchedFlowCombiner2.values;
                        objArr2[i3] = obj3;
                        for (Object obj10 : objArr2) {
                            obj6 = FlowExtKt.NULL;
                            if (obj10 == obj6) {
                                mutex3 = mutex2;
                                break;
                            }
                        }
                        if (!z) {
                            combineSource = CombineSource.INITIAL;
                        } else if (i3 == 0) {
                            combineSource = CombineSource.RECEIVER;
                        } else {
                            combineSource = CombineSource.OTHER;
                        }
                        Object[] objArr3 = unbatchedFlowCombiner2.values;
                        obj4 = objArr3[0];
                        obj5 = objArr3[1];
                        unbatchedFlowCombiner$onNext$1.L$0 = unbatchedFlowCombiner2;
                        unbatchedFlowCombiner$onNext$1.L$1 = mutex2;
                        unbatchedFlowCombiner$onNext$1.L$2 = null;
                        unbatchedFlowCombiner$onNext$1.label = 3;
                        if (unbatchedFlowCombiner2.send.invoke(obj4, obj5, combineSource, unbatchedFlowCombiner$onNext$1) != coroutine_suspended) {
                            mutex3 = mutex2;
                            unbatchedFlowCombiner2.initialDispatched.complete(Unit.INSTANCE);
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
                    i5 = unbatchedFlowCombiner$onNext$1.I$0;
                    obj2 = unbatchedFlowCombiner$onNext$1.L$1;
                    unbatchedFlowCombiner = (UnbatchedFlowCombiner) unbatchedFlowCombiner$onNext$1.L$0;
                    ResultKt.throwOnFailure(obj8);
                }
                mutex = unbatchedFlowCombiner.lock;
                unbatchedFlowCombiner$onNext$1.L$0 = unbatchedFlowCombiner;
                unbatchedFlowCombiner$onNext$1.L$1 = obj2;
                unbatchedFlowCombiner$onNext$1.L$2 = mutex;
                unbatchedFlowCombiner$onNext$1.I$0 = i5;
                unbatchedFlowCombiner$onNext$1.label = 2;
                if (mutex.lock(null, unbatchedFlowCombiner$onNext$1) != coroutine_suspended) {
                    obj3 = obj2;
                    mutex2 = mutex;
                    i3 = i5;
                    unbatchedFlowCombiner2 = unbatchedFlowCombiner;
                    Object[] objArr4 = unbatchedFlowCombiner2.values;
                    length = objArr4.length;
                    i4 = 0;
                    while (true) {
                        if (i4 < length) {
                        }
                        i4++;
                    }
                    Object[] objArr22 = unbatchedFlowCombiner2.values;
                    objArr22[i3] = obj3;
                    while (r13 < r7) {
                    }
                    if (!z) {
                    }
                    Object[] objArr32 = unbatchedFlowCombiner2.values;
                    obj4 = objArr32[0];
                    obj5 = objArr32[1];
                    unbatchedFlowCombiner$onNext$1.L$0 = unbatchedFlowCombiner2;
                    unbatchedFlowCombiner$onNext$1.L$1 = mutex2;
                    unbatchedFlowCombiner$onNext$1.L$2 = null;
                    unbatchedFlowCombiner$onNext$1.label = 3;
                    if (unbatchedFlowCombiner2.send.invoke(obj4, obj5, combineSource, unbatchedFlowCombiner$onNext$1) != coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            }
        }
        unbatchedFlowCombiner$onNext$1 = new UnbatchedFlowCombiner$onNext$1(this, continuation);
        Object obj82 = unbatchedFlowCombiner$onNext$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = unbatchedFlowCombiner$onNext$1.label;
        if (i2 != 0) {
        }
        mutex = unbatchedFlowCombiner.lock;
        unbatchedFlowCombiner$onNext$1.L$0 = unbatchedFlowCombiner;
        unbatchedFlowCombiner$onNext$1.L$1 = obj2;
        unbatchedFlowCombiner$onNext$1.L$2 = mutex;
        unbatchedFlowCombiner$onNext$1.I$0 = i5;
        unbatchedFlowCombiner$onNext$1.label = 2;
        if (mutex.lock(null, unbatchedFlowCombiner$onNext$1) != coroutine_suspended) {
        }
        return coroutine_suspended;
    }
}
