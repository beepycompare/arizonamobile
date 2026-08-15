package com.arizona.launcher;

import com.arizona.launcher.updater.archive.orchestrator.ArchivePayloadAuditResult;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
/* compiled from: FileCheckServiceFlow.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007\u0012,\b\u0002\u0010\n\u001a&\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0010\u001a\u00020\u000bJ$\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0082@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR2\u0010\n\u001a&\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0018"}, d2 = {"Lcom/arizona/launcher/FileCheckServiceFlow;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "host", "Lcom/arizona/launcher/FileCheckServiceHost;", "audit", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePayloadAuditResult;", "launchOverride", "", "Lkotlinx/coroutines/Job;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lcom/arizona/launcher/FileCheckServiceHost;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "requestFullCheck", "performFullCheck", "operationToken", "", "releaseOperation", "Lkotlin/Function0;", "", "(JLkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FileCheckServiceFlow {
    public static final int $stable = 0;
    private final Function1<Continuation<? super ArchivePayloadAuditResult>, Object> audit;
    private final FileCheckServiceHost host;
    private final Function1<Function1<? super Continuation<? super Unit>, ? extends Object>, Job> launchOverride;
    private final CoroutineScope scope;

    /* JADX WARN: Multi-variable type inference failed */
    public FileCheckServiceFlow(CoroutineScope scope, FileCheckServiceHost host, Function1<? super Continuation<? super ArchivePayloadAuditResult>, ? extends Object> audit, Function1<? super Function1<? super Continuation<? super Unit>, ? extends Object>, ? extends Job> function1) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(audit, "audit");
        this.scope = scope;
        this.host = host;
        this.audit = audit;
        this.launchOverride = function1;
    }

    public /* synthetic */ FileCheckServiceFlow(CoroutineScope coroutineScope, FileCheckServiceHost fileCheckServiceHost, Function1 function1, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, fileCheckServiceHost, function1, (i & 8) != 0 ? null : function12);
    }

    public final void requestFullCheck() {
        final Function0 function0;
        Job launch$default;
        Long beginFileCheckOperation = this.host.beginFileCheckOperation();
        if (beginFileCheckOperation == null) {
            return;
        }
        final long longValue = beginFileCheckOperation.longValue();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
        Function0 function02 = new Function0() { // from class: com.arizona.launcher.FileCheckServiceFlow$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(FileCheckServiceFlow.requestFullCheck$lambda$0(atomicBoolean, atomicBoolean2, this, longValue));
            }
        };
        try {
            FileCheckServiceFlow$requestFullCheck$task$1 fileCheckServiceFlow$requestFullCheck$task$1 = new FileCheckServiceFlow$requestFullCheck$task$1(this, longValue, function02, null);
            function0 = function02;
            try {
                FileCheckServiceFlow$requestFullCheck$task$1 fileCheckServiceFlow$requestFullCheck$task$12 = fileCheckServiceFlow$requestFullCheck$task$1;
                Function1<Function1<? super Continuation<? super Unit>, ? extends Object>, Job> function1 = this.launchOverride;
                if (function1 == null || (launch$default = function1.invoke(fileCheckServiceFlow$requestFullCheck$task$12)) == null) {
                    launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new FileCheckServiceFlow$requestFullCheck$job$1(fileCheckServiceFlow$requestFullCheck$task$12, null), 3, null);
                }
                launch$default.invokeOnCompletion(new Function1() { // from class: com.arizona.launcher.FileCheckServiceFlow$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FileCheckServiceFlow.requestFullCheck$lambda$1(Function0.this, (Throwable) obj);
                    }
                });
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                function0.invoke();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            function0 = function02;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean requestFullCheck$lambda$0(AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, FileCheckServiceFlow fileCheckServiceFlow, long j) {
        if (atomicBoolean.compareAndSet(false, true)) {
            atomicBoolean2.set(fileCheckServiceFlow.host.finishFileCheckOperation(j));
        }
        return atomicBoolean2.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit requestFullCheck$lambda$1(Function0 function0, Throwable th) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:3|(9:5|6|7|(1:(2:10|11)(2:34|35))(2:36|(2:38|39)(2:40|(1:42)))|12|13|(1:15)|16|(2:18|19)(4:(1:22)|23|(2:31|32)|30)))|47|6|7|(0)(0)|12|13|(0)|16|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0059, code lost:
        r1 = new com.arizona.launcher.updater.archive.orchestrator.ArchivePayloadAuditResult.Unavailable(com.arizona.launcher.updater.archive.orchestrator.ArchivePayloadAuditUnavailableReason.STATE_NOT_LOADED);
        r4.host.onFileCheckAuditFailure(r8, r1);
        r8 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c3, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c4, code lost:
        throw r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object performFullCheck(long j, Function0<Boolean> function0, Continuation<? super Unit> continuation) {
        FileCheckServiceFlow$performFullCheck$1 fileCheckServiceFlow$performFullCheck$1;
        int i;
        ArchivePayloadAuditResult.Unavailable unavailable;
        if (continuation instanceof FileCheckServiceFlow$performFullCheck$1) {
            fileCheckServiceFlow$performFullCheck$1 = (FileCheckServiceFlow$performFullCheck$1) continuation;
            if ((fileCheckServiceFlow$performFullCheck$1.label & Integer.MIN_VALUE) != 0) {
                fileCheckServiceFlow$performFullCheck$1.label -= Integer.MIN_VALUE;
                Object obj = fileCheckServiceFlow$performFullCheck$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = fileCheckServiceFlow$performFullCheck$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!this.host.isCurrentFileCheckOperation(j)) {
                        return Unit.INSTANCE;
                    }
                    Function1<Continuation<? super ArchivePayloadAuditResult>, Object> function1 = this.audit;
                    fileCheckServiceFlow$performFullCheck$1.L$0 = function0;
                    fileCheckServiceFlow$performFullCheck$1.J$0 = j;
                    fileCheckServiceFlow$performFullCheck$1.label = 1;
                    obj = function1.invoke(fileCheckServiceFlow$performFullCheck$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    j = fileCheckServiceFlow$performFullCheck$1.J$0;
                    function0 = (Function0) fileCheckServiceFlow$performFullCheck$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                unavailable = (ArchivePayloadAuditResult) obj;
                JobKt.ensureActive(fileCheckServiceFlow$performFullCheck$1.getContext());
                boolean z = unavailable instanceof ArchivePayloadAuditResult.Valid;
                if (unavailable instanceof ArchivePayloadAuditResult.RepairScheduled) {
                    this.host.onFileCheckRepairScheduled((ArchivePayloadAuditResult.RepairScheduled) unavailable);
                }
                if (this.host.isCurrentFileCheckOperation(j)) {
                    return Unit.INSTANCE;
                }
                if (!z) {
                    this.host.markFileCheckRecoveryRequired();
                    this.host.markGameUpdateRequiredAfterFileCheck();
                }
                JobKt.ensureActive(fileCheckServiceFlow$performFullCheck$1.getContext());
                if (this.host.isCurrentFileCheckOperation(j) && function0.invoke().booleanValue()) {
                    JobKt.ensureActive(fileCheckServiceFlow$performFullCheck$1.getContext());
                    this.host.completeFullFileCheck(z);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
        }
        fileCheckServiceFlow$performFullCheck$1 = new FileCheckServiceFlow$performFullCheck$1(this, continuation);
        Object obj2 = fileCheckServiceFlow$performFullCheck$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = fileCheckServiceFlow$performFullCheck$1.label;
        if (i != 0) {
        }
        unavailable = (ArchivePayloadAuditResult) obj2;
        JobKt.ensureActive(fileCheckServiceFlow$performFullCheck$1.getContext());
        boolean z2 = unavailable instanceof ArchivePayloadAuditResult.Valid;
        if (unavailable instanceof ArchivePayloadAuditResult.RepairScheduled) {
        }
        if (this.host.isCurrentFileCheckOperation(j)) {
        }
    }
}
