package com.arizona.launcher;

import android.util.Log;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateSessionState;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveViceCityDeleteFinalizeResult;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveViceCityDeleteRecoveryResult;
import com.arizona.launcher.updater.archive.orchestrator.ViceCityArchiveContentManager;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpdateService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.UpdateService$recoverPendingViceCityDelete$1", f = "UpdateService.kt", i = {0}, l = {1051}, m = "invokeSuspend", n = {"recovered"}, nl = {1081}, s = {"I$0"}, v = 2)
/* loaded from: classes3.dex */
public final class UpdateService$recoverPendingViceCityDelete$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int label;
    final /* synthetic */ UpdateService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateService$recoverPendingViceCityDelete$1(UpdateService updateService, Continuation<? super UpdateService$recoverPendingViceCityDelete$1> continuation) {
        super(2, continuation);
        this.this$0 = updateService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UpdateService$recoverPendingViceCityDelete$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UpdateService$recoverPendingViceCityDelete$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x009e, code lost:
        if (r1 != 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c0, code lost:
        if (r1 == 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c2, code lost:
        r8 = r7.this$0.refreshAfterViceCityMutation;
        r8.set(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00cb, code lost:
        r7.this$0.dispatchPendingViceCityRefresh();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d2, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e1  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2;
        int i;
        AtomicBoolean atomicBoolean3;
        ArchiveUpdateSessionState archiveUpdateSessionState;
        AtomicBoolean atomicBoolean4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    final UpdateService updateService = this.this$0;
                    this.I$0 = 0;
                    this.label = 1;
                    obj = updateService.withViceCityArchiveLock(new Function0() { // from class: com.arizona.launcher.UpdateService$recoverPendingViceCityDelete$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return UpdateService$recoverPendingViceCityDelete$1.invokeSuspend$lambda$0(UpdateService.this);
                        }
                    }, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i = 0;
                } catch (CancellationException e) {
                    throw e;
                } catch (Exception e2) {
                    e = e2;
                    i = 0;
                    Boxing.boxInt(Log.e("UPDATE_SERVICE", "Unable to recover pending Vice-City delete", e));
                    atomicBoolean3 = this.this$0.viceCityMutationActive;
                    atomicBoolean3.set(false);
                } catch (Throwable th) {
                    th = th;
                    coroutine_suspended = null;
                    atomicBoolean = this.this$0.viceCityMutationActive;
                    atomicBoolean.set(false);
                    if (coroutine_suspended != null) {
                        atomicBoolean2 = this.this$0.refreshAfterViceCityMutation;
                        atomicBoolean2.set(true);
                    }
                    this.this$0.dispatchPendingViceCityRefresh();
                    throw th;
                }
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                i = this.I$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (CancellationException e3) {
                    throw e3;
                } catch (Exception e4) {
                    e = e4;
                    Boxing.boxInt(Log.e("UPDATE_SERVICE", "Unable to recover pending Vice-City delete", e));
                    atomicBoolean3 = this.this$0.viceCityMutationActive;
                    atomicBoolean3.set(false);
                }
            }
            ArchiveViceCityDeleteRecoveryResult archiveViceCityDeleteRecoveryResult = (ArchiveViceCityDeleteRecoveryResult) obj;
            if (Intrinsics.areEqual(archiveViceCityDeleteRecoveryResult, ArchiveViceCityDeleteRecoveryResult.NoPending.INSTANCE)) {
                Unit unit = Unit.INSTANCE;
            } else if (Intrinsics.areEqual(archiveViceCityDeleteRecoveryResult, ArchiveViceCityDeleteRecoveryResult.Recovered.INSTANCE)) {
                try {
                    this.this$0.viceContentAvailable = false;
                    archiveUpdateSessionState = this.this$0.viceArchiveSession;
                    archiveUpdateSessionState.markCommitted();
                    Boxing.boxInt(Log.i("UPDATE_SERVICE", "Recovered pending Vice-City delete"));
                    i = 1;
                } catch (CancellationException e5) {
                    throw e5;
                } catch (Exception e6) {
                    e = e6;
                    i = 1;
                    Boxing.boxInt(Log.e("UPDATE_SERVICE", "Unable to recover pending Vice-City delete", e));
                    atomicBoolean3 = this.this$0.viceCityMutationActive;
                    atomicBoolean3.set(false);
                } catch (Throwable th2) {
                    th = th2;
                    coroutine_suspended = 1;
                    atomicBoolean = this.this$0.viceCityMutationActive;
                    atomicBoolean.set(false);
                    if (coroutine_suspended != null) {
                    }
                    this.this$0.dispatchPendingViceCityRefresh();
                    throw th;
                }
            } else if (!(archiveViceCityDeleteRecoveryResult instanceof ArchiveViceCityDeleteRecoveryResult.Failure)) {
                throw new NoWhenBranchMatchedException();
            } else {
                Boxing.boxInt(Log.w("UPDATE_SERVICE", "Vice-City delete recovery remains pending: " + ((ArchiveViceCityDeleteRecoveryResult.Failure) archiveViceCityDeleteRecoveryResult).getDetail()));
            }
            atomicBoolean4 = this.this$0.viceCityMutationActive;
            atomicBoolean4.set(false);
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ArchiveViceCityDeleteRecoveryResult invokeSuspend$lambda$0(UpdateService updateService) {
        boolean persistViceCityPreference;
        ViceCityArchiveContentManager forAndroid$default = ViceCityArchiveContentManager.Companion.forAndroid$default(ViceCityArchiveContentManager.Companion, updateService, null, 2, null);
        if (forAndroid$default == null) {
            return new ArchiveViceCityDeleteRecoveryResult.Failure("Vice-City archive storage is unavailable");
        }
        ArchiveViceCityDeleteRecoveryResult recoverPendingDelete = forAndroid$default.recoverPendingDelete();
        if (!Intrinsics.areEqual(recoverPendingDelete, ArchiveViceCityDeleteRecoveryResult.NoPending.INSTANCE) && !(recoverPendingDelete instanceof ArchiveViceCityDeleteRecoveryResult.Failure)) {
            if (Intrinsics.areEqual(recoverPendingDelete, ArchiveViceCityDeleteRecoveryResult.Recovered.INSTANCE)) {
                persistViceCityPreference = updateService.persistViceCityPreference(false);
                if (!persistViceCityPreference) {
                    return new ArchiveViceCityDeleteRecoveryResult.Failure("Unable to persist the Vice-City setting");
                }
                ArchiveViceCityDeleteFinalizeResult finalizePendingDelete = forAndroid$default.finalizePendingDelete();
                if (finalizePendingDelete instanceof ArchiveViceCityDeleteFinalizeResult.Failure) {
                    Log.w("UPDATE_SERVICE", "Vice-City delete acknowledgement remains pending: " + ((ArchiveViceCityDeleteFinalizeResult.Failure) finalizePendingDelete).getDetail());
                    return recoverPendingDelete;
                } else if (!Intrinsics.areEqual(finalizePendingDelete, ArchiveViceCityDeleteFinalizeResult.Finalized.INSTANCE) && !Intrinsics.areEqual(finalizePendingDelete, ArchiveViceCityDeleteFinalizeResult.NoPending.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return recoverPendingDelete;
    }
}
