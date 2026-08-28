package com.arizona.launcher;

import com.arizona.launcher.updater.archive.orchestrator.ArchivePackageUpdater;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterListener;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterResult;
import com.arizona.launcher.updater.archive.planner.ArchiveUpdatePlan;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
/* compiled from: ArchiveUpdateServiceFlow.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterResult;", "attemptServer", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterListener;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.ArchiveUpdateServiceFlow$executeArchiveUpdate$2", f = "ArchiveUpdateServiceFlow.kt", i = {0, 0}, l = {314}, m = "invokeSuspend", n = {"attemptServer", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER}, nl = {319}, s = {"L$0", "L$1"}, v = 2)
/* loaded from: classes3.dex */
final class ArchiveUpdateServiceFlow$executeArchiveUpdate$2 extends SuspendLambda implements Function3<String, ArchiveUpdaterListener, Continuation<? super ArchiveUpdaterResult>, Object> {
    final /* synthetic */ ArchiveUpdatePlan $plan;
    final /* synthetic */ Map<String, Long> $plannedArchiveDownloadBytesByPackage;
    final /* synthetic */ ArchivePackageUpdater $updater;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveUpdateServiceFlow$executeArchiveUpdate$2(ArchivePackageUpdater archivePackageUpdater, ArchiveUpdatePlan archiveUpdatePlan, Map<String, Long> map, Continuation<? super ArchiveUpdateServiceFlow$executeArchiveUpdate$2> continuation) {
        super(3, continuation);
        this.$updater = archivePackageUpdater;
        this.$plan = archiveUpdatePlan;
        this.$plannedArchiveDownloadBytesByPackage = map;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(String str, ArchiveUpdaterListener archiveUpdaterListener, Continuation<? super ArchiveUpdaterResult> continuation) {
        ArchiveUpdateServiceFlow$executeArchiveUpdate$2 archiveUpdateServiceFlow$executeArchiveUpdate$2 = new ArchiveUpdateServiceFlow$executeArchiveUpdate$2(this.$updater, this.$plan, this.$plannedArchiveDownloadBytesByPackage, continuation);
        archiveUpdateServiceFlow$executeArchiveUpdate$2.L$0 = str;
        archiveUpdateServiceFlow$executeArchiveUpdate$2.L$1 = archiveUpdaterListener;
        return archiveUpdateServiceFlow$executeArchiveUpdate$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str = (String) this.L$0;
        ArchiveUpdaterListener archiveUpdaterListener = (ArchiveUpdaterListener) this.L$1;
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
        this.L$0 = SpillingKt.nullOutSpilledVariable(str);
        this.L$1 = SpillingKt.nullOutSpilledVariable(archiveUpdaterListener);
        this.label = 1;
        Object execute = this.$updater.execute(this.$plan, str, archiveUpdaterListener, this.$plannedArchiveDownloadBytesByPackage, this);
        return execute == coroutine_suspended ? coroutine_suspended : execute;
    }
}
