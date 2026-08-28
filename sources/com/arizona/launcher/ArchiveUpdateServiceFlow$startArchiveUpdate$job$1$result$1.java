package com.arizona.launcher;

import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterResult;
import com.arizona.launcher.updater.archive.planner.ArchiveUpdatePlan;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: ArchiveUpdateServiceFlow.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.ArchiveUpdateServiceFlow$startArchiveUpdate$job$1$result$1", f = "ArchiveUpdateServiceFlow.kt", i = {}, l = {264, 266}, m = "invokeSuspend", n = {}, nl = {266, 272}, s = {}, v = 2)
/* loaded from: classes3.dex */
final class ArchiveUpdateServiceFlow$startArchiveUpdate$job$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArchiveUpdaterResult>, Object> {
    final /* synthetic */ long $operationToken;
    final /* synthetic */ ArchiveUpdatePlan $plan;
    final /* synthetic */ Map<String, Long> $plannedArchiveDownloadBytesByPackage;
    final /* synthetic */ String $server;
    int label;
    final /* synthetic */ ArchiveUpdateServiceFlow this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveUpdateServiceFlow$startArchiveUpdate$job$1$result$1(ArchiveUpdateServiceFlow archiveUpdateServiceFlow, ArchiveUpdatePlan archiveUpdatePlan, String str, long j, Map<String, Long> map, Continuation<? super ArchiveUpdateServiceFlow$startArchiveUpdate$job$1$result$1> continuation) {
        super(2, continuation);
        this.this$0 = archiveUpdateServiceFlow;
        this.$plan = archiveUpdatePlan;
        this.$server = str;
        this.$operationToken = j;
        this.$plannedArchiveDownloadBytesByPackage = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArchiveUpdateServiceFlow$startArchiveUpdate$job$1$result$1(this.this$0, this.$plan, this.$server, this.$operationToken, this.$plannedArchiveDownloadBytesByPackage, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ArchiveUpdaterResult> continuation) {
        return ((ArchiveUpdateServiceFlow$startArchiveUpdate$job$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
        if (r12 == r0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0056, code lost:
        if (r12 == r0) goto L18;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Function4 function4;
        Function4 function42;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return (ArchiveUpdaterResult) obj;
            } else if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return (ArchiveUpdaterResult) obj;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
        ResultKt.throwOnFailure(obj);
        function4 = this.this$0.executeOverride;
        ArchiveUpdateServiceFlow archiveUpdateServiceFlow = this.this$0;
        if (function4 != null) {
            function42 = archiveUpdateServiceFlow.executeOverride;
            ArchiveUpdatePlan archiveUpdatePlan = this.$plan;
            String str = this.$server;
            Long boxLong = Boxing.boxLong(this.$operationToken);
            this.label = 1;
            obj = function42.invoke(archiveUpdatePlan, str, boxLong, this);
        } else {
            this.label = 2;
            obj = archiveUpdateServiceFlow.executeArchiveUpdate(this.$plan, this.$server, this.$operationToken, this.$plannedArchiveDownloadBytesByPackage, this);
        }
        return coroutine_suspended;
    }
}
