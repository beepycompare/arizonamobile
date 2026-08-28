package com.arizona.launcher;

import com.arizona.launcher.ArchiveForegroundPromotion;
import com.arizona.launcher.updater.archive.download.ArchivePackageDownloadErrorCode;
import com.arizona.launcher.updater.archive.model.ArchiveManifest;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveMetadataFinalizationResult;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveMirrorRetryPolicy;
import com.arizona.launcher.updater.archive.orchestrator.ArchivePackageUpdater;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveStartupGuard;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveStorageRequirementsSnapshot;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateSessionSnapshot;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateSessionState;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterErrorCode;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterResult;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveWorkDispatchPolicy;
import com.arizona.launcher.updater.archive.planner.ArchiveUpdatePlan;
import com.facebook.widget.FacebookDialog;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: ArchiveUpdateServiceFlow.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u008a\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012_\b\u0002\u0010\b\u001aY\b\u0001\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ \u0010 \u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J:\u0010#\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00100%H\u0082@¢\u0006\u0002\u0010&J\u0016\u0010'\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010(J\u0018\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000Rg\u0010\b\u001aY\b\u0001\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000Ê\u0001\f\b-\u0012\b\b.\u0012\u0004\b\u0003\u0010\u0000¨\u0006,"}, d2 = {"Lcom/arizona/launcher/ArchiveUpdateServiceFlow;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sessionState", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateSessionState;", "host", "Lcom/arizona/launcher/ArchiveUpdateServiceHost;", "executeOverride", "Lkotlin/Function4;", "Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;", "Lkotlin/ParameterName;", "name", "plan", "", "server", "", "operationToken", "Lkotlin/coroutines/Continuation;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterResult;", "executionDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateSessionState;Lcom/arizona/launcher/ArchiveUpdateServiceHost;Lkotlin/jvm/functions/Function4;Lkotlinx/coroutines/CoroutineDispatcher;)V", "Lkotlin/jvm/functions/Function4;", "archiveUpdateJob", "Lkotlinx/coroutines/Job;", "isDownloadActive", "", FacebookDialog.COMPLETION_GESTURE_CANCEL, "", "requestDownload", "startArchiveUpdate", "snapshot", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateSessionSnapshot;", "executeArchiveUpdate", "plannedArchiveDownloadBytesByPackage", "", "(Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;Ljava/lang/String;JLjava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "completeSuccessfully", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "completeWithFailure", "result", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterResult$Failure;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveUpdateServiceFlow {
    public static final int $stable = 8;
    private volatile Job archiveUpdateJob;
    private final Function4<ArchiveUpdatePlan, String, Long, Continuation<? super ArchiveUpdaterResult>, Object> executeOverride;
    private final CoroutineDispatcher executionDispatcher;
    private final ArchiveUpdateServiceHost host;
    private final CoroutineScope scope;
    private final ArchiveUpdateSessionState sessionState;

    /* compiled from: ArchiveUpdateServiceFlow.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ArchiveStartupGuard.values().length];
            try {
                iArr[ArchiveStartupGuard.CORRUPT_STATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArchiveStartupGuard.RECOVERY_REQUIRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ArchiveStartupGuard.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArchiveUpdateServiceFlow(CoroutineScope scope, ArchiveUpdateSessionState sessionState, ArchiveUpdateServiceHost host, Function4<? super ArchiveUpdatePlan, ? super String, ? super Long, ? super Continuation<? super ArchiveUpdaterResult>, ? extends Object> function4, CoroutineDispatcher executionDispatcher) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(sessionState, "sessionState");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(executionDispatcher, "executionDispatcher");
        this.scope = scope;
        this.sessionState = sessionState;
        this.host = host;
        this.executeOverride = function4;
        this.executionDispatcher = executionDispatcher;
    }

    public /* synthetic */ ArchiveUpdateServiceFlow(CoroutineScope coroutineScope, ArchiveUpdateSessionState archiveUpdateSessionState, ArchiveUpdateServiceHost archiveUpdateServiceHost, Function4 function4, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, archiveUpdateSessionState, archiveUpdateServiceHost, (i & 8) != 0 ? null : function4, (i & 16) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    public final boolean isDownloadActive() {
        Job job = this.archiveUpdateJob;
        return job != null && job.isActive();
    }

    public final void cancel() {
        Job job = this.archiveUpdateJob;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.archiveUpdateJob = null;
    }

    public final void requestDownload() {
        if (this.host.isArchiveServiceAlive()) {
            boolean isDownloadActive = isDownloadActive();
            ArchiveUpdateServiceHost archiveUpdateServiceHost = this.host;
            if (isDownloadActive) {
                archiveUpdateServiceHost.onArchiveRequestCoalesced(true, UpdateOperationKind.ARCHIVE_UPDATE);
                return;
            }
            UpdateOperationSnapshot activeUpdateOperation = archiveUpdateServiceHost.activeUpdateOperation();
            if (activeUpdateOperation != null) {
                this.host.onArchiveRequestCoalesced(false, activeUpdateOperation.getKind());
                return;
            }
            ArchiveUpdateSessionSnapshot snapshot = this.sessionState.snapshot();
            int i = WhenMappings.$EnumSwitchMapping$0[snapshot.getStartupGuard().ordinal()];
            if (i == 1) {
                this.host.onArchiveStartupCorrupt();
            } else if (i == 2) {
                this.host.requestArchiveManifestRefresh("Archive recovery requires a fresh manifest; starting combined check", false);
            } else if (i != 3) {
                throw new NoWhenBranchMatchedException();
            } else {
                if (snapshot.getBootstrapPending() != null) {
                    this.host.requestArchiveManifestRefresh("Clean archive bootstrap requires a complete manifest; starting combined check", false);
                    return;
                }
                boolean hasPendingWork = snapshot.getHasPendingWork();
                ArchiveUpdateServiceHost archiveUpdateServiceHost2 = this.host;
                if (!hasPendingWork) {
                    archiveUpdateServiceHost2.setArchiveBenchmarkMode("none");
                    this.host.onArchiveNoWork();
                    return;
                }
                archiveUpdateServiceHost2.onArchiveDownloadSelected();
                ArchiveUpdatePlan plan = snapshot.getPlan();
                if (plan == null || !ArchiveWorkDispatchPolicy.INSTANCE.hasPendingWork(plan.getType(), snapshot.getRequiresFinalization())) {
                    this.host.setArchiveBenchmarkMode("archive_manifest_refresh");
                    this.sessionState.markRecoveryRequired();
                    this.host.requestArchiveManifestRefresh("Archive-only update has no prepared plan; refreshing manifest", true);
                    return;
                }
                this.host.setArchiveBenchmarkMode("archive");
                Long beginArchiveOperation = this.host.beginArchiveOperation();
                if (beginArchiveOperation != null) {
                    startArchiveUpdate(plan, snapshot, beginArchiveOperation.longValue());
                }
            }
        }
    }

    private final void startArchiveUpdate(ArchiveUpdatePlan archiveUpdatePlan, ArchiveUpdateSessionSnapshot archiveUpdateSessionSnapshot, final long j) {
        final Job job;
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Function0 function0 = new Function0() { // from class: com.arizona.launcher.ArchiveUpdateServiceFlow$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ArchiveUpdateServiceFlow.startArchiveUpdate$lambda$0(atomicBoolean, this, j);
            }
        };
        try {
            String server = archiveUpdateSessionSnapshot.getServer();
            if (server == null) {
                server = "";
            }
            if (StringsKt.isBlank(server)) {
                function0.invoke();
                this.host.completeArchiveFailure(new ArchiveServiceFailure("archive server is empty", null, null, null, null, 30, null));
                return;
            }
            boolean isFinalizationOnly = ArchiveWorkDispatchPolicy.INSTANCE.isFinalizationOnly(archiveUpdatePlan.getType(), archiveUpdateSessionSnapshot.getRequiresFinalization());
            ArchiveStorageRequirementsSnapshot storageRequirements = archiveUpdateSessionSnapshot.getStorageRequirements();
            if (!isFinalizationOnly && !this.host.hasEnoughSpaceForArchive(storageRequirements)) {
                function0.invoke();
                this.host.completeArchiveFailure(new ArchiveServiceFailure("not enough free space for archive install; required=" + storageRequirements.getRequiredFreeSpaceBytes() + " plus reserve", ArchiveServiceFailureKind.INSUFFICIENT_STORAGE, null, Long.valueOf(storageRequirements.getRequiredFreeSpaceBytes()), null, 20, null));
                return;
            }
            ArchiveForegroundPromotion promoteArchiveForeground = this.host.promoteArchiveForeground();
            if (!Intrinsics.areEqual(promoteArchiveForeground, ArchiveForegroundPromotion.Ready.INSTANCE)) {
                if (!(promoteArchiveForeground instanceof ArchiveForegroundPromotion.Rejected)) {
                    throw new NoWhenBranchMatchedException();
                }
                function0.invoke();
                this.host.completeArchiveFailure(new ArchiveServiceFailure("foreground promotion rejected: " + ((ArchiveForegroundPromotion.Rejected) promoteArchiveForeground).getDetail(), ArchiveServiceFailureKind.FOREGROUND_UNAVAILABLE, null, null, null, 28, null));
                return;
            }
            this.host.beginArchiveProgress(storageRequirements.getDownloadBytes(), isFinalizationOnly);
            job = BuildersKt__Builders_commonKt.launch$default(this.scope, null, CoroutineStart.LAZY, new ArchiveUpdateServiceFlow$startArchiveUpdate$job$1(this, j, archiveUpdatePlan, server, archiveUpdateSessionSnapshot.getPlannedArchiveDownloadBytesByPackage(), null), 1, null);
            try {
                this.archiveUpdateJob = job;
                job.invokeOnCompletion(new Function1() { // from class: com.arizona.launcher.ArchiveUpdateServiceFlow$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ArchiveUpdateServiceFlow.startArchiveUpdate$lambda$1(Function0.this, this, job, (Throwable) obj);
                    }
                });
                job.start();
            } catch (Throwable th) {
                th = th;
                if (job != null) {
                    Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                if (this.archiveUpdateJob == job) {
                    this.archiveUpdateJob = null;
                }
                function0.invoke();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            job = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit startArchiveUpdate$lambda$0(AtomicBoolean atomicBoolean, ArchiveUpdateServiceFlow archiveUpdateServiceFlow, long j) {
        if (atomicBoolean.compareAndSet(false, true)) {
            archiveUpdateServiceFlow.host.finishArchiveOperation(j);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit startArchiveUpdate$lambda$1(Function0 function0, ArchiveUpdateServiceFlow archiveUpdateServiceFlow, Job job, Throwable th) {
        function0.invoke();
        if (archiveUpdateServiceFlow.archiveUpdateJob == job) {
            archiveUpdateServiceFlow.archiveUpdateJob = null;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object executeArchiveUpdate(ArchiveUpdatePlan archiveUpdatePlan, String str, long j, Map<String, Long> map, Continuation<? super ArchiveUpdaterResult> continuation) {
        ArchiveUpdateServiceFlow$executeArchiveUpdate$1 archiveUpdateServiceFlow$executeArchiveUpdate$1;
        int i;
        try {
            if (continuation instanceof ArchiveUpdateServiceFlow$executeArchiveUpdate$1) {
                archiveUpdateServiceFlow$executeArchiveUpdate$1 = (ArchiveUpdateServiceFlow$executeArchiveUpdate$1) continuation;
                if ((archiveUpdateServiceFlow$executeArchiveUpdate$1.label & Integer.MIN_VALUE) != 0) {
                    archiveUpdateServiceFlow$executeArchiveUpdate$1.label -= Integer.MIN_VALUE;
                    Object obj = archiveUpdateServiceFlow$executeArchiveUpdate$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = archiveUpdateServiceFlow$executeArchiveUpdate$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        ArchivePackageUpdater createArchivePackageUpdater = this.host.createArchivePackageUpdater();
                        if (createArchivePackageUpdater == null) {
                            return new ArchiveUpdaterResult.Failure(ArchiveUpdaterErrorCode.INVALID_ENVIRONMENT, null, null, null, null, null, null, WebSocketProtocol.PAYLOAD_SHORT, null);
                        }
                        archiveUpdateServiceFlow$executeArchiveUpdate$1.L$0 = SpillingKt.nullOutSpilledVariable(archiveUpdatePlan);
                        archiveUpdateServiceFlow$executeArchiveUpdate$1.L$1 = SpillingKt.nullOutSpilledVariable(str);
                        archiveUpdateServiceFlow$executeArchiveUpdate$1.L$2 = SpillingKt.nullOutSpilledVariable(map);
                        archiveUpdateServiceFlow$executeArchiveUpdate$1.L$3 = SpillingKt.nullOutSpilledVariable(createArchivePackageUpdater);
                        archiveUpdateServiceFlow$executeArchiveUpdate$1.J$0 = j;
                        archiveUpdateServiceFlow$executeArchiveUpdate$1.label = 1;
                        obj = this.host.createArchiveMirrorCoordinator(j).execute(archiveUpdatePlan, str, new ArchiveUpdateServiceFlow$executeArchiveUpdate$2(createArchivePackageUpdater, archiveUpdatePlan, map, null), archiveUpdateServiceFlow$executeArchiveUpdate$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        long j2 = archiveUpdateServiceFlow$executeArchiveUpdate$1.J$0;
                        ArchivePackageUpdater archivePackageUpdater = (ArchivePackageUpdater) archiveUpdateServiceFlow$executeArchiveUpdate$1.L$3;
                        Map map2 = (Map) archiveUpdateServiceFlow$executeArchiveUpdate$1.L$2;
                        String str2 = (String) archiveUpdateServiceFlow$executeArchiveUpdate$1.L$1;
                        ArchiveUpdatePlan archiveUpdatePlan2 = (ArchiveUpdatePlan) archiveUpdateServiceFlow$executeArchiveUpdate$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    return (ArchiveUpdaterResult) obj;
                }
            }
            if (i != 0) {
            }
            return (ArchiveUpdaterResult) obj;
        } catch (CancellationException e) {
            throw e;
        } catch (Exception e2) {
            this.host.recordArchiveExecutionException(e2);
            return new ArchiveUpdaterResult.Failure(ArchiveUpdaterErrorCode.INSTALL_NOT_READY, null, e2.getMessage(), null, null, null, null, 122, null);
        }
        archiveUpdateServiceFlow$executeArchiveUpdate$1 = new ArchiveUpdateServiceFlow$executeArchiveUpdate$1(this, continuation);
        Object obj2 = archiveUpdateServiceFlow$executeArchiveUpdate$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = archiveUpdateServiceFlow$executeArchiveUpdate$1.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(6:5|6|7|(1:(2:10|11)(2:32|33))(2:34|(2:36|37)(4:38|(1:40)(1:44)|41|(1:43)))|12|(2:26|(4:28|29|15|(2:17|18)(2:20|(2:22|23)(2:24|25)))(2:30|31))(3:14|15|(0)(0))))|56|6|7|(0)(0)|12|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a1, code lost:
        r17.host.recordArchiveFinalizationException(r0);
        r4 = com.arizona.launcher.updater.archive.io.ArchiveStorageFailureClassifier.INSTANCE.isNoSpace(r0);
        r10 = "archive metadata reconciliation or durable finalization failed: " + r0.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c4, code lost:
        if (r4 != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c6, code lost:
        r0 = com.arizona.launcher.ArchiveServiceFailureKind.INSUFFICIENT_STORAGE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c9, code lost:
        r0 = com.arizona.launcher.ArchiveServiceFailureKind.RECOVERY_BLOCKED;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00cb, code lost:
        r11 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00cc, code lost:
        if (r4 != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ce, code lost:
        r8 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r17.sessionState.snapshot().getStorageRequirements().getRequiredFreeSpaceBytes());
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e0, code lost:
        r9 = new com.arizona.launcher.ArchiveServiceFailure(r10, r11, null, r8, kotlin.coroutines.jvm.internal.Boxing.boxLong(r2), 4, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0112, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0113, code lost:
        throw r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007f A[Catch: Exception -> 0x0037, CancellationException -> 0x0112, TryCatch #2 {CancellationException -> 0x0112, Exception -> 0x0037, blocks: (B:12:0x0033, B:29:0x0074, B:32:0x007f, B:34:0x0083, B:35:0x009b, B:36:0x00a0, B:26:0x0061), top: B:58:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object completeSuccessfully(long j, Continuation<? super Unit> continuation) {
        ArchiveUpdateServiceFlow$completeSuccessfully$1 archiveUpdateServiceFlow$completeSuccessfully$1;
        int i;
        ArchiveMetadataFinalizationResult archiveMetadataFinalizationResult;
        long j2 = j;
        if (continuation instanceof ArchiveUpdateServiceFlow$completeSuccessfully$1) {
            archiveUpdateServiceFlow$completeSuccessfully$1 = (ArchiveUpdateServiceFlow$completeSuccessfully$1) continuation;
            if ((archiveUpdateServiceFlow$completeSuccessfully$1.label & Integer.MIN_VALUE) != 0) {
                archiveUpdateServiceFlow$completeSuccessfully$1.label -= Integer.MIN_VALUE;
                Object obj = archiveUpdateServiceFlow$completeSuccessfully$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = archiveUpdateServiceFlow$completeSuccessfully$1.label;
                Long l = null;
                ArchiveServiceFailure archiveServiceFailure = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!this.host.isCurrentArchiveOperation(j2)) {
                        return Unit.INSTANCE;
                    }
                    ArchiveUpdatePlan plan = this.sessionState.snapshot().getPlan();
                    ArchiveManifest remoteManifest = plan != null ? plan.getRemoteManifest() : null;
                    ArchiveUpdateServiceHost archiveUpdateServiceHost = this.host;
                    archiveUpdateServiceFlow$completeSuccessfully$1.L$0 = SpillingKt.nullOutSpilledVariable(remoteManifest);
                    archiveUpdateServiceFlow$completeSuccessfully$1.J$0 = j2;
                    archiveUpdateServiceFlow$completeSuccessfully$1.label = 1;
                    obj = archiveUpdateServiceHost.finalizeArchiveMetadata(remoteManifest, archiveUpdateServiceFlow$completeSuccessfully$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    j2 = archiveUpdateServiceFlow$completeSuccessfully$1.J$0;
                    ArchiveManifest archiveManifest = (ArchiveManifest) archiveUpdateServiceFlow$completeSuccessfully$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                archiveMetadataFinalizationResult = (ArchiveMetadataFinalizationResult) obj;
                if (!Intrinsics.areEqual(archiveMetadataFinalizationResult, ArchiveMetadataFinalizationResult.Success.INSTANCE)) {
                    if (!(archiveMetadataFinalizationResult instanceof ArchiveMetadataFinalizationResult.Blocked)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    ArchiveServiceFailure archiveServiceFailure2 = new ArchiveServiceFailure(((ArchiveMetadataFinalizationResult.Blocked) archiveMetadataFinalizationResult).getDetail(), ArchiveServiceFailureKind.RECOVERY_BLOCKED, null, null, Boxing.boxLong(j2), 12, null);
                    archiveServiceFailure = archiveServiceFailure2;
                    if (this.host.isCurrentArchiveOperation(j2)) {
                        return Unit.INSTANCE;
                    }
                    ArchiveUpdateSessionState archiveUpdateSessionState = this.sessionState;
                    if (archiveServiceFailure != null) {
                        archiveUpdateSessionState.markFinalizationRequired();
                        this.host.completeArchiveFailure(archiveServiceFailure);
                        return Unit.INSTANCE;
                    }
                    archiveUpdateSessionState.markCommitted();
                    this.host.completeArchiveSuccess();
                    return Unit.INSTANCE;
                } else if (this.host.isCurrentArchiveOperation(j2)) {
                }
            }
        }
        archiveUpdateServiceFlow$completeSuccessfully$1 = new ArchiveUpdateServiceFlow$completeSuccessfully$1(this, continuation);
        Object obj2 = archiveUpdateServiceFlow$completeSuccessfully$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = archiveUpdateServiceFlow$completeSuccessfully$1.label;
        Long l2 = null;
        ArchiveServiceFailure archiveServiceFailure3 = null;
        if (i != 0) {
        }
        archiveMetadataFinalizationResult = (ArchiveMetadataFinalizationResult) obj2;
        if (!Intrinsics.areEqual(archiveMetadataFinalizationResult, ArchiveMetadataFinalizationResult.Success.INSTANCE)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void completeWithFailure(ArchiveUpdaterResult.Failure failure, long j) {
        ArchiveServiceFailureKind archiveServiceFailureKind;
        String detail;
        Long l;
        if (this.host.isCurrentArchiveOperation(j)) {
            Long runtimeDownloadBytes = failure.getRuntimeDownloadBytes();
            if (runtimeDownloadBytes != null) {
                this.sessionState.recordRuntimeRequirements(runtimeDownloadBytes.longValue(), failure.getRuntimeRequiredFreeSpaceBytes());
            }
            this.host.expandArchiveRuntimeRequirements(this.sessionState.snapshot().getStorageRequirements());
            this.sessionState.markRecoveryRequired();
            if (failure.getCode() == ArchiveUpdaterErrorCode.INSUFFICIENT_STORAGE) {
                archiveServiceFailureKind = ArchiveServiceFailureKind.INSUFFICIENT_STORAGE;
            } else if (failure.getDownloadErrorCode() == ArchivePackageDownloadErrorCode.NETWORK_MONITOR_FAILED) {
                archiveServiceFailureKind = ArchiveServiceFailureKind.CONNECTION;
            } else {
                DownloadFailureDetails downloadFailure = failure.getDownloadFailure();
                if (downloadFailure != null && (ArchiveMirrorRetryPolicy.INSTANCE.isEligibleNetworkRetryFailure(downloadFailure) || ArchiveMirrorRetryPolicy.INSTANCE.isArchiveMirrorLagFailure(downloadFailure))) {
                    archiveServiceFailureKind = ArchiveServiceFailureKind.CONNECTION;
                } else {
                    archiveServiceFailureKind = ArchiveServiceFailureKind.CORRUPTED;
                }
            }
            ArchiveServiceFailureKind archiveServiceFailureKind2 = archiveServiceFailureKind;
            ArchiveUpdateServiceHost archiveUpdateServiceHost = this.host;
            ArchiveUpdaterErrorCode code = failure.getCode();
            String packageId = failure.getPackageId();
            if (packageId == null) {
                packageId = "";
            }
            String str = code + " package=" + packageId + " " + (failure.getDetail() != null ? detail : "");
            DownloadFailureDetails downloadFailure2 = failure.getDownloadFailure();
            if (failure.getCode() == ArchiveUpdaterErrorCode.INSUFFICIENT_STORAGE) {
                Long runtimeRequiredFreeSpaceBytes = failure.getRuntimeRequiredFreeSpaceBytes();
                l = Long.valueOf(runtimeRequiredFreeSpaceBytes != null ? runtimeRequiredFreeSpaceBytes.longValue() : this.sessionState.snapshot().getStorageRequirements().getRequiredFreeSpaceBytes());
            } else {
                l = null;
            }
            archiveUpdateServiceHost.completeArchiveFailure(new ArchiveServiceFailure(str, archiveServiceFailureKind2, downloadFailure2, l, Long.valueOf(j)));
        }
    }
}
