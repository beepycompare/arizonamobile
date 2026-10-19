package com.arizona.launcher;

import android.os.Messenger;
import android.util.Log;
import com.arizona.launcher.UpdateService;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateSessionState;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpdateService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.UpdateService$launchViceCityRequest$1", f = "UpdateService.kt", i = {}, l = {1004}, m = "invokeSuspend", n = {}, nl = {1011}, s = {}, v = 2)
/* loaded from: classes3.dex */
public final class UpdateService$launchViceCityRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super UpdateService.ViceCityRequestResult>, Object> $action;
    final /* synthetic */ int $messageCode;
    final /* synthetic */ Messenger $recipient;
    final /* synthetic */ long $requestId;
    int label;
    final /* synthetic */ UpdateService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UpdateService$launchViceCityRequest$1(Function1<? super Continuation<? super UpdateService.ViceCityRequestResult>, ? extends Object> function1, UpdateService updateService, Messenger messenger, int i, long j, Continuation<? super UpdateService$launchViceCityRequest$1> continuation) {
        super(2, continuation);
        this.$action = function1;
        this.this$0 = updateService;
        this.$recipient = messenger;
        this.$messageCode = i;
        this.$requestId = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UpdateService$launchViceCityRequest$1(this.$action, this.this$0, this.$recipient, this.$messageCode, this.$requestId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UpdateService$launchViceCityRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AtomicBoolean atomicBoolean;
        UpdateService.ViceCityRequestResult viceCityRequestResult;
        AtomicBoolean atomicBoolean2;
        AtomicBoolean atomicBoolean3;
        ArchiveUpdateSessionState archiveUpdateSessionState;
        ArchiveUpdateSessionState archiveUpdateSessionState2;
        AtomicBoolean atomicBoolean4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Function1<Continuation<? super UpdateService.ViceCityRequestResult>, Object> function1 = this.$action;
                        this.label = 1;
                        obj = function1.invoke(this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    viceCityRequestResult = (UpdateService.ViceCityRequestResult) obj;
                    atomicBoolean4 = this.this$0.viceCityMutationActive;
                    atomicBoolean4.set(false);
                } catch (CancellationException e) {
                    throw e;
                }
            } catch (Exception e2) {
                Log.e("UPDATE_SERVICE", "Vice-City content request failed", e2);
                UpdateService.ViceCityRequestResult viceCityRequestResult2 = new UpdateService.ViceCityRequestResult(false, 0L, e2.getMessage(), null, false, 26, null);
                atomicBoolean = this.this$0.viceCityMutationActive;
                atomicBoolean.set(false);
                viceCityRequestResult = viceCityRequestResult2;
            }
            Boolean enabled = viceCityRequestResult.getEnabled();
            if (enabled != null) {
                UpdateService updateService = this.this$0;
                boolean booleanValue = enabled.booleanValue();
                updateService.viceContentAvailable = false;
                if (booleanValue) {
                    archiveUpdateSessionState2 = updateService.viceArchiveSession;
                    archiveUpdateSessionState2.invalidateForManifestRefresh();
                } else {
                    archiveUpdateSessionState = updateService.viceArchiveSession;
                    archiveUpdateSessionState.markCommitted();
                }
            }
            if (viceCityRequestResult.getRefresh()) {
                atomicBoolean3 = this.this$0.refreshAfterViceCityMutation;
                atomicBoolean3.set(true);
            }
            this.this$0.sendViceCityContentResult(this.$recipient, this.$messageCode, this.$requestId, viceCityRequestResult.getSuccess(), viceCityRequestResult.getSizeBytes(), viceCityRequestResult.getDetail());
            this.this$0.dispatchPendingViceCityRefresh();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            atomicBoolean2 = this.this$0.viceCityMutationActive;
            atomicBoolean2.set(false);
            throw th;
        }
    }
}
