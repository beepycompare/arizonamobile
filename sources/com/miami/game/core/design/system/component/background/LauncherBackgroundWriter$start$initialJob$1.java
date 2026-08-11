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
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.design.system.component.background.LauncherBackgroundWriter$start$initialJob$1", f = "BackgroundManager.kt", i = {1, 2, 3}, l = {92, 682, 94, 95}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, nl = {93, 683, 95, 96}, s = {"L$0", "L$0", "L$0"}, v = 2)
/* loaded from: classes5.dex */
public final class LauncherBackgroundWriter$start$initialJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Job $previousInitialization;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LauncherBackgroundWriter$start$initialJob$1(Job job, Continuation<? super LauncherBackgroundWriter$start$initialJob$1> continuation) {
        super(2, continuation);
        this.$previousInitialization = job;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LauncherBackgroundWriter$start$initialJob$1(this.$previousInitialization, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LauncherBackgroundWriter$start$initialJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0052, code lost:
        if (r9 == r0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0066, code lost:
        if (r9.lock(null, r8) != r0) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0083  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        Object loadLocal;
        Throwable th;
        Mutex mutex2;
        Object syncRemoteAndStore;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Job job = this.$previousInitialization;
            if (job != null) {
                this.label = 1;
                obj = job.join(this);
            }
            mutex = LauncherBackgroundWriter.syncMutex;
            this.L$0 = mutex;
            this.label = 2;
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                mutex = (Mutex) this.L$0;
                try {
                    LauncherBackgroundWriter launcherBackgroundWriter = LauncherBackgroundWriter.INSTANCE;
                    this.L$0 = mutex;
                    this.label = 3;
                    loadLocal = launcherBackgroundWriter.loadLocal(this);
                    if (loadLocal == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    LauncherBackgroundWriter launcherBackgroundWriter2 = LauncherBackgroundWriter.INSTANCE;
                    this.L$0 = mutex;
                    this.label = 4;
                    syncRemoteAndStore = launcherBackgroundWriter2.syncRemoteAndStore(this);
                    if (syncRemoteAndStore != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } catch (Throwable th2) {
                    Mutex mutex3 = mutex;
                    th = th2;
                    mutex2 = mutex3;
                    mutex2.unlock(null);
                    throw th;
                }
            } else if (i != 3) {
                if (i == 4) {
                    mutex2 = (Mutex) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        Unit unit = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th3) {
                        th = th3;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                Mutex mutex4 = (Mutex) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    mutex = mutex4;
                    LauncherBackgroundWriter launcherBackgroundWriter22 = LauncherBackgroundWriter.INSTANCE;
                    this.L$0 = mutex;
                    this.label = 4;
                    syncRemoteAndStore = launcherBackgroundWriter22.syncRemoteAndStore(this);
                    if (syncRemoteAndStore != coroutine_suspended) {
                        mutex2 = mutex;
                        Unit unit2 = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                } catch (Throwable th4) {
                    th = th4;
                    mutex2 = mutex4;
                    mutex2.unlock(null);
                    throw th;
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
        }
        Unit unit3 = (Unit) obj;
        mutex = LauncherBackgroundWriter.syncMutex;
        this.L$0 = mutex;
        this.label = 2;
    }
}
