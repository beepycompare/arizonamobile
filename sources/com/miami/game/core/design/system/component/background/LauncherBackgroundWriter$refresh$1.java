package com.miami.game.core.design.system.component.background;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.design.system.component.background.LauncherBackgroundWriter$refresh$1", f = "BackgroundManager.kt", i = {0, 1}, l = {682, 116}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, nl = {683, 117}, s = {"L$0", "L$0"}, v = 2)
/* loaded from: classes5.dex */
public final class LauncherBackgroundWriter$refresh$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LauncherBackgroundWriter$refresh$1(Continuation<? super LauncherBackgroundWriter$refresh$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LauncherBackgroundWriter$refresh$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LauncherBackgroundWriter$refresh$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
        if (r7.lock(null, r6) == r0) goto L22;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        Throwable th;
        Mutex mutex2;
        Object syncRemoteAndStore;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = LauncherBackgroundWriter.syncMutex;
                this.L$0 = mutex;
                this.label = 1;
            } else if (i != 1) {
                if (i == 2) {
                    mutex2 = (Mutex) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        Unit unit = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
                mutex = (Mutex) this.L$0;
            }
            LauncherBackgroundWriter launcherBackgroundWriter = LauncherBackgroundWriter.INSTANCE;
            this.L$0 = mutex;
            this.label = 2;
            syncRemoteAndStore = launcherBackgroundWriter.syncRemoteAndStore(this);
            if (syncRemoteAndStore != coroutine_suspended) {
                mutex2 = mutex;
                Unit unit2 = Unit.INSTANCE;
                mutex2.unlock(null);
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            Mutex mutex3 = mutex;
            th = th3;
            mutex2 = mutex3;
            mutex2.unlock(null);
            throw th;
        }
    }
}
