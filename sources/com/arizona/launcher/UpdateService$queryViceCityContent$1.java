package com.arizona.launcher;

import com.arizona.launcher.UpdateService;
import com.arizona.launcher.updater.archive.orchestrator.ViceCityArchiveContentInspection;
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
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpdateService.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/arizona/launcher/UpdateService$ViceCityRequestResult;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.UpdateService$queryViceCityContent$1", f = "UpdateService.kt", i = {}, l = {834}, m = "invokeSuspend", n = {}, nl = {866}, s = {}, v = 2)
/* loaded from: classes3.dex */
public final class UpdateService$queryViceCityContent$1 extends SuspendLambda implements Function1<Continuation<? super UpdateService.ViceCityRequestResult>, Object> {
    int label;
    final /* synthetic */ UpdateService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateService$queryViceCityContent$1(UpdateService updateService, Continuation<? super UpdateService$queryViceCityContent$1> continuation) {
        super(1, continuation);
        this.this$0 = updateService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new UpdateService$queryViceCityContent$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super UpdateService.ViceCityRequestResult> continuation) {
        return ((UpdateService$queryViceCityContent$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
        withViceCityArchiveLock = updateService.withViceCityArchiveLock(new Function0() { // from class: com.arizona.launcher.UpdateService$queryViceCityContent$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UpdateService$queryViceCityContent$1.invokeSuspend$lambda$0(UpdateService.this);
            }
        }, this);
        return withViceCityArchiveLock == coroutine_suspended ? coroutine_suspended : withViceCityArchiveLock;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final UpdateService.ViceCityRequestResult invokeSuspend$lambda$0(UpdateService updateService) {
        boolean persistViceCityPreference;
        ViceCityArchiveContentManager forAndroid$default = ViceCityArchiveContentManager.Companion.forAndroid$default(ViceCityArchiveContentManager.Companion, updateService, null, 2, null);
        if (forAndroid$default == null) {
            return new UpdateService.ViceCityRequestResult(false, 0L, "Vice-City archive storage is unavailable", null, false, 26, null);
        }
        ViceCityArchiveContentInspection inspect = forAndroid$default.inspect();
        if (inspect instanceof ViceCityArchiveContentInspection.Failure) {
            return new UpdateService.ViceCityRequestResult(false, 0L, ((ViceCityArchiveContentInspection.Failure) inspect).getDetail(), null, false, 26, null);
        }
        if (!(inspect instanceof ViceCityArchiveContentInspection.Success)) {
            throw new NoWhenBranchMatchedException();
        }
        ViceCityArchiveContentInspection.Success success = (ViceCityArchiveContentInspection.Success) inspect;
        if (success.getTotalBytes() <= 0) {
            persistViceCityPreference = updateService.persistViceCityPreference(false);
            if (persistViceCityPreference) {
                return new UpdateService.ViceCityRequestResult(true, 0L, null, false, true, 6, null);
            }
            return new UpdateService.ViceCityRequestResult(false, 0L, "Unable to persist the Vice-City setting", null, false, 26, null);
        }
        return new UpdateService.ViceCityRequestResult(true, success.getTotalBytes(), null, null, false, 28, null);
    }
}
