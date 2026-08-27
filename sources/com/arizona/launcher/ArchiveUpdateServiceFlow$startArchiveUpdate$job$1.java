package com.arizona.launcher;

import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterResult;
import com.arizona.launcher.updater.archive.planner.ArchiveUpdatePlan;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveUpdateServiceFlow.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.ArchiveUpdateServiceFlow$startArchiveUpdate$job$1", f = "ArchiveUpdateServiceFlow.kt", i = {2}, l = {256, 258, 262}, m = "invokeSuspend", n = {"result"}, nl = {258, 255, 263}, s = {"L$0"}, v = 2)
/* loaded from: classes3.dex */
public final class ArchiveUpdateServiceFlow$startArchiveUpdate$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $operationToken;
    final /* synthetic */ ArchiveUpdatePlan $plan;
    final /* synthetic */ String $server;
    Object L$0;
    int label;
    final /* synthetic */ ArchiveUpdateServiceFlow this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveUpdateServiceFlow$startArchiveUpdate$job$1(ArchiveUpdateServiceFlow archiveUpdateServiceFlow, ArchiveUpdatePlan archiveUpdatePlan, String str, long j, Continuation<? super ArchiveUpdateServiceFlow$startArchiveUpdate$job$1> continuation) {
        super(2, continuation);
        this.this$0 = archiveUpdateServiceFlow;
        this.$plan = archiveUpdatePlan;
        this.$server = str;
        this.$operationToken = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArchiveUpdateServiceFlow$startArchiveUpdate$job$1(this.this$0, this.$plan, this.$server, this.$operationToken, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ArchiveUpdateServiceFlow$startArchiveUpdate$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004b, code lost:
        if (r12 == r0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
        if (r12 == r0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007c, code lost:
        if (r11 == r0) goto L18;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Function4 function4;
        Function4 function42;
        ArchiveUpdaterResult archiveUpdaterResult;
        Object completeSuccessfully;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
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
                obj = archiveUpdateServiceFlow.executeArchiveUpdate(this.$plan, this.$server, this.$operationToken, this);
            }
            return coroutine_suspended;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            archiveUpdaterResult = (ArchiveUpdaterResult) obj;
        } else if (i != 2) {
            if (i == 3) {
                ArchiveUpdaterResult archiveUpdaterResult2 = (ArchiveUpdaterResult) this.L$0;
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            archiveUpdaterResult = (ArchiveUpdaterResult) obj;
        }
        if (archiveUpdaterResult instanceof ArchiveUpdaterResult.Success) {
            this.L$0 = SpillingKt.nullOutSpilledVariable(archiveUpdaterResult);
            this.label = 3;
            completeSuccessfully = this.this$0.completeSuccessfully(this.$operationToken, this);
        } else if (archiveUpdaterResult instanceof ArchiveUpdaterResult.Failure) {
            this.this$0.completeWithFailure((ArchiveUpdaterResult.Failure) archiveUpdaterResult, this.$operationToken);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }
}
