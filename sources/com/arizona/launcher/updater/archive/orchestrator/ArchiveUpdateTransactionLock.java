package com.arizona.launcher.updater.archive.orchestrator;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
/* compiled from: ArchiveUpdateTransactionLock.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u001c\u0010\u000b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH\u0086@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bÊ\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u000f"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateTransactionLock;", "", "<init>", "()V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "isLocked", "", "()Z", "withLock", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveUpdateTransactionLock {
    public static final int $stable = 0;
    public static final ArchiveUpdateTransactionLock INSTANCE = new ArchiveUpdateTransactionLock();
    private static final Mutex mutex = MutexKt.Mutex$default(false, 1, null);

    private ArchiveUpdateTransactionLock() {
    }

    public final boolean isLocked() {
        return mutex.isLocked();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005d, code lost:
        if (r6.lock(null, r0) == r8) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object withLock(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        ArchiveUpdateTransactionLock$withLock$1 archiveUpdateTransactionLock$withLock$1;
        Object coroutine_suspended;
        int i;
        Mutex mutex2;
        Mutex mutex3;
        Throwable th;
        Object invoke;
        try {
            if (continuation instanceof ArchiveUpdateTransactionLock$withLock$1) {
                archiveUpdateTransactionLock$withLock$1 = (ArchiveUpdateTransactionLock$withLock$1) continuation;
                if ((archiveUpdateTransactionLock$withLock$1.label & Integer.MIN_VALUE) != 0) {
                    archiveUpdateTransactionLock$withLock$1.label -= Integer.MIN_VALUE;
                    Object obj = archiveUpdateTransactionLock$withLock$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = archiveUpdateTransactionLock$withLock$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex2 = mutex;
                        archiveUpdateTransactionLock$withLock$1.L$0 = function1;
                        archiveUpdateTransactionLock$withLock$1.L$1 = mutex2;
                        archiveUpdateTransactionLock$withLock$1.label = 1;
                    } else if (i != 1) {
                        if (i == 2) {
                            mutex3 = (Mutex) archiveUpdateTransactionLock$withLock$1.L$1;
                            Function1 function12 = (Function1) archiveUpdateTransactionLock$withLock$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                mutex3.unlock(null);
                                return obj;
                            } catch (Throwable th2) {
                                th = th2;
                                mutex3.unlock(null);
                                throw th;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                        mutex2 = (Mutex) archiveUpdateTransactionLock$withLock$1.L$1;
                        function1 = (Function1) archiveUpdateTransactionLock$withLock$1.L$0;
                    }
                    archiveUpdateTransactionLock$withLock$1.L$0 = SpillingKt.nullOutSpilledVariable(function1);
                    archiveUpdateTransactionLock$withLock$1.L$1 = mutex2;
                    archiveUpdateTransactionLock$withLock$1.label = 2;
                    invoke = function1.invoke(archiveUpdateTransactionLock$withLock$1);
                    if (invoke != coroutine_suspended) {
                        mutex3 = mutex2;
                        obj = invoke;
                        mutex3.unlock(null);
                        return obj;
                    }
                    return coroutine_suspended;
                }
            }
            archiveUpdateTransactionLock$withLock$1.L$0 = SpillingKt.nullOutSpilledVariable(function1);
            archiveUpdateTransactionLock$withLock$1.L$1 = mutex2;
            archiveUpdateTransactionLock$withLock$1.label = 2;
            invoke = function1.invoke(archiveUpdateTransactionLock$withLock$1);
            if (invoke != coroutine_suspended) {
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            mutex3 = mutex2;
            th = th3;
            mutex3.unlock(null);
            throw th;
        }
        archiveUpdateTransactionLock$withLock$1 = new ArchiveUpdateTransactionLock$withLock$1(this, continuation);
        Object obj2 = archiveUpdateTransactionLock$withLock$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = archiveUpdateTransactionLock$withLock$1.label;
        if (i != 0) {
        }
    }
}
