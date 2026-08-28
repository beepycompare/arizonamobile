package com.arizona.launcher;

import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterResult;
import com.arizona.launcher.updater.archive.planner.ArchiveUpdatePlan;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveUpdateServiceFlow.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.ArchiveUpdateServiceFlow$startArchiveUpdate$job$1", f = "ArchiveUpdateServiceFlow.kt", i = {1}, l = {262, 276}, m = "invokeSuspend", n = {"result"}, nl = {275, 277}, s = {"L$0"}, v = 2)
/* loaded from: classes3.dex */
public final class ArchiveUpdateServiceFlow$startArchiveUpdate$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $operationToken;
    final /* synthetic */ ArchiveUpdatePlan $plan;
    final /* synthetic */ Map<String, Long> $plannedArchiveDownloadBytesByPackage;
    final /* synthetic */ String $server;
    Object L$0;
    int label;
    final /* synthetic */ ArchiveUpdateServiceFlow this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveUpdateServiceFlow$startArchiveUpdate$job$1(ArchiveUpdateServiceFlow archiveUpdateServiceFlow, long j, ArchiveUpdatePlan archiveUpdatePlan, String str, Map<String, Long> map, Continuation<? super ArchiveUpdateServiceFlow$startArchiveUpdate$job$1> continuation) {
        super(2, continuation);
        this.this$0 = archiveUpdateServiceFlow;
        this.$operationToken = j;
        this.$plan = archiveUpdatePlan;
        this.$server = str;
        this.$plannedArchiveDownloadBytesByPackage = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArchiveUpdateServiceFlow$startArchiveUpdate$job$1(this.this$0, this.$operationToken, this.$plan, this.$server, this.$plannedArchiveDownloadBytesByPackage, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ArchiveUpdateServiceFlow$startArchiveUpdate$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0048, code lost:
        if (r13 == r0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0064, code lost:
        if (r12 == r0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0066, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineDispatcher coroutineDispatcher;
        Object completeSuccessfully;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineDispatcher = this.this$0.executionDispatcher;
            this.label = 1;
            obj = BuildersKt.withContext(coroutineDispatcher, new ArchiveUpdateServiceFlow$startArchiveUpdate$job$1$result$1(this.this$0, this.$plan, this.$server, this.$operationToken, this.$plannedArchiveDownloadBytesByPackage, null), this);
        } else if (i != 1) {
            if (i == 2) {
                ArchiveUpdaterResult archiveUpdaterResult = (ArchiveUpdaterResult) this.L$0;
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        ArchiveUpdaterResult archiveUpdaterResult2 = (ArchiveUpdaterResult) obj;
        if (archiveUpdaterResult2 instanceof ArchiveUpdaterResult.Success) {
            this.L$0 = SpillingKt.nullOutSpilledVariable(archiveUpdaterResult2);
            this.label = 2;
            completeSuccessfully = this.this$0.completeSuccessfully(this.$operationToken, this);
        } else if (archiveUpdaterResult2 instanceof ArchiveUpdaterResult.Failure) {
            this.this$0.completeWithFailure((ArchiveUpdaterResult.Failure) archiveUpdaterResult2, this.$operationToken);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }
}
