package com.arizona.launcher;

import android.util.Log;
import com.arizona.launcher.UpdateService;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveViceCityDeleteFinalizeResult;
import com.arizona.launcher.updater.archive.orchestrator.ViceCityArchiveContentDeleteResult;
import com.arizona.launcher.updater.archive.orchestrator.ViceCityArchiveContentManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpdateService.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/arizona/launcher/UpdateService$ViceCityRequestResult;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.UpdateService$deleteViceCityContent$1", f = "UpdateService.kt", i = {}, l = {887}, m = "invokeSuspend", n = {}, nl = {931}, s = {}, v = 2)
/* loaded from: classes3.dex */
public final class UpdateService$deleteViceCityContent$1 extends SuspendLambda implements Function1<Continuation<? super UpdateService.ViceCityRequestResult>, Object> {
    int label;
    final /* synthetic */ UpdateService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateService$deleteViceCityContent$1(UpdateService updateService, Continuation<? super UpdateService$deleteViceCityContent$1> continuation) {
        super(1, continuation);
        this.this$0 = updateService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new UpdateService$deleteViceCityContent$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super UpdateService.ViceCityRequestResult> continuation) {
        return ((UpdateService$deleteViceCityContent$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object withViceCityArchiveLock;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        final UpdateService updateService = this.this$0;
        this.label = 1;
        withViceCityArchiveLock = updateService.withViceCityArchiveLock(new Function0() { // from class: com.arizona.launcher.UpdateService$deleteViceCityContent$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UpdateService$deleteViceCityContent$1.invokeSuspend$lambda$0(UpdateService.this);
            }
        }, this);
        return withViceCityArchiveLock == coroutine_suspended ? coroutine_suspended : withViceCityArchiveLock;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final UpdateService.ViceCityRequestResult invokeSuspend$lambda$0(UpdateService updateService) {
        String currentArchiveLaneCollisionDetail;
        boolean persistViceCityPreference;
        currentArchiveLaneCollisionDetail = updateService.currentArchiveLaneCollisionDetail();
        if (currentArchiveLaneCollisionDetail != null) {
            return new UpdateService.ViceCityRequestResult(false, 0L, currentArchiveLaneCollisionDetail, null, false, 26, null);
        }
        ViceCityArchiveContentManager forAndroid$default = ViceCityArchiveContentManager.Companion.forAndroid$default(ViceCityArchiveContentManager.Companion, updateService, null, 2, null);
        if (forAndroid$default == null) {
            return new UpdateService.ViceCityRequestResult(false, 0L, "Vice-City archive storage is unavailable", null, false, 26, null);
        }
        ViceCityArchiveContentDeleteResult delete = forAndroid$default.delete();
        if (delete instanceof ViceCityArchiveContentDeleteResult.Failure) {
            return new UpdateService.ViceCityRequestResult(false, 0L, ((ViceCityArchiveContentDeleteResult.Failure) delete).getDetail(), null, false, 26, null);
        }
        if (Intrinsics.areEqual(delete, ViceCityArchiveContentDeleteResult.Success.INSTANCE)) {
            persistViceCityPreference = updateService.persistViceCityPreference(false);
            if (!persistViceCityPreference) {
                return new UpdateService.ViceCityRequestResult(false, 0L, "Unable to persist the Vice-City setting", null, false, 26, null);
            }
            ArchiveViceCityDeleteFinalizeResult finalizePendingDelete = forAndroid$default.finalizePendingDelete();
            if (finalizePendingDelete instanceof ArchiveViceCityDeleteFinalizeResult.Failure) {
                Log.w("UPDATE_SERVICE", "Vice-City delete acknowledgement remains pending: " + ((ArchiveViceCityDeleteFinalizeResult.Failure) finalizePendingDelete).getDetail());
            } else if (!Intrinsics.areEqual(finalizePendingDelete, ArchiveViceCityDeleteFinalizeResult.Finalized.INSTANCE) && !Intrinsics.areEqual(finalizePendingDelete, ArchiveViceCityDeleteFinalizeResult.NoPending.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            return new UpdateService.ViceCityRequestResult(true, 0L, null, false, true, 6, null);
        }
        throw new NoWhenBranchMatchedException();
    }
}
