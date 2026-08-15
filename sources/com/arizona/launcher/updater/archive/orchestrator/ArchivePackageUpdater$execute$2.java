package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.planner.ArchiveUpdatePlan;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchivePackageUpdater.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.ArchivePackageUpdater$execute$2", f = "ArchivePackageUpdater.kt", i = {0}, l = {116}, m = "invokeSuspend", n = {"$this$supervisorScope"}, nl = {-1}, s = {"L$0"}, v = 2)
/* loaded from: classes3.dex */
public final class ArchivePackageUpdater$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArchiveUpdaterResult>, Object> {
    final /* synthetic */ ArchiveUpdaterListener $listener;
    final /* synthetic */ ArchiveUpdatePlan $plan;
    final /* synthetic */ String $serverBaseUrl;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ArchivePackageUpdater this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchivePackageUpdater$execute$2(ArchivePackageUpdater archivePackageUpdater, ArchiveUpdatePlan archiveUpdatePlan, String str, ArchiveUpdaterListener archiveUpdaterListener, Continuation<? super ArchivePackageUpdater$execute$2> continuation) {
        super(2, continuation);
        this.this$0 = archivePackageUpdater;
        this.$plan = archiveUpdatePlan;
        this.$serverBaseUrl = str;
        this.$listener = archiveUpdaterListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ArchivePackageUpdater$execute$2 archivePackageUpdater$execute$2 = new ArchivePackageUpdater$execute$2(this.this$0, this.$plan, this.$serverBaseUrl, this.$listener, continuation);
        archivePackageUpdater$execute$2.L$0 = obj;
        return archivePackageUpdater$execute$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ArchiveUpdaterResult> continuation) {
        return ((ArchivePackageUpdater$execute$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object executeTransaction;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
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
        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
        this.label = 1;
        executeTransaction = this.this$0.executeTransaction(coroutineScope, this.$plan, this.$serverBaseUrl, this.$listener, this);
        return executeTransaction == coroutine_suspended ? coroutine_suspended : executeTransaction;
    }
}
