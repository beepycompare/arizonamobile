package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterResult;
import com.arizona.launcher.updater.archive.planner.ArchiveUpdatePlan;
import com.arizona.launcher.updater.archive.state.DurableArchiveStateStore;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
/* compiled from: ArchiveMirrorExecutionCoordinator.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 .2\u00020\u0001:\u0001.BÄ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0005\u0012\u0018\u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0005\u0012\u0004\u0012\u00020\u00100\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\"\u0010\u0015\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0016\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJf\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\f2F\u0010$\u001aB\b\u0001\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110'¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b((\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010%H\u0086@¢\u0006\u0002\u0010)J(\u0010*\u001a\u0004\u0018\u00010\f2\u0006\u0010\"\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,2\u0006\u0010\u000f\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010-J\b\u0010(\u001a\u00020'H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0005\u0012\u0004\u0012\u00020\u00100\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0015\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b0\u0012\b\b1\u0012\u0004\b\u0003\u0010\u0000¨\u0006/"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveMirrorExecutionCoordinator;", "", "sessionState", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateSessionState;", "mirrorCount", "Lkotlin/Function0;", "", "hasValidatedNetwork", "", "isCurrentOperation", "markCurrentServerUnreachable", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "failedServer", "", "currentServer", "postToMain", "callbacks", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveMirrorExecutionCallbacks;", "remainingDownloadBytes", "Lkotlin/Function2;", "Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;", "Lkotlin/coroutines/Continuation;", "", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "mainDispatcher", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateSessionState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveMirrorExecutionCallbacks;Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "Lkotlin/jvm/functions/Function2;", "execute", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterResult;", "plan", "initialServer", "executeAttempt", "Lkotlin/Function3;", "server", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "(Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareMirrorRetry", "failure", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterResult$Failure;", "(Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterResult$Failure;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveMirrorExecutionCoordinator {
    private final ArchiveMirrorExecutionCallbacks callbacks;
    private final Function0<String> currentServer;
    private final Function0<Boolean> hasValidatedNetwork;
    private final CoroutineDispatcher ioDispatcher;
    private final Function0<Boolean> isCurrentOperation;
    private final CoroutineDispatcher mainDispatcher;
    private final Function1<String, Unit> markCurrentServerUnreachable;
    private final Function0<Integer> mirrorCount;
    private final Function1<Function0<Unit>, Unit> postToMain;
    private final Function2<ArchiveUpdatePlan, Continuation<? super Long>, Object> remainingDownloadBytes;
    private final ArchiveUpdateSessionState sessionState;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public ArchiveMirrorExecutionCoordinator(ArchiveUpdateSessionState sessionState, Function0<Integer> mirrorCount, Function0<Boolean> hasValidatedNetwork, Function0<Boolean> isCurrentOperation, Function1<? super String, Unit> markCurrentServerUnreachable, Function0<String> currentServer, Function1<? super Function0<Unit>, Unit> postToMain, ArchiveMirrorExecutionCallbacks callbacks, Function2<? super ArchiveUpdatePlan, ? super Continuation<? super Long>, ? extends Object> remainingDownloadBytes, CoroutineDispatcher ioDispatcher, CoroutineDispatcher mainDispatcher) {
        Intrinsics.checkNotNullParameter(sessionState, "sessionState");
        Intrinsics.checkNotNullParameter(mirrorCount, "mirrorCount");
        Intrinsics.checkNotNullParameter(hasValidatedNetwork, "hasValidatedNetwork");
        Intrinsics.checkNotNullParameter(isCurrentOperation, "isCurrentOperation");
        Intrinsics.checkNotNullParameter(markCurrentServerUnreachable, "markCurrentServerUnreachable");
        Intrinsics.checkNotNullParameter(currentServer, "currentServer");
        Intrinsics.checkNotNullParameter(postToMain, "postToMain");
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        Intrinsics.checkNotNullParameter(remainingDownloadBytes, "remainingDownloadBytes");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        this.sessionState = sessionState;
        this.mirrorCount = mirrorCount;
        this.hasValidatedNetwork = hasValidatedNetwork;
        this.isCurrentOperation = isCurrentOperation;
        this.markCurrentServerUnreachable = markCurrentServerUnreachable;
        this.currentServer = currentServer;
        this.postToMain = postToMain;
        this.callbacks = callbacks;
        this.remainingDownloadBytes = remainingDownloadBytes;
        this.ioDispatcher = ioDispatcher;
        this.mainDispatcher = mainDispatcher;
    }

    public /* synthetic */ ArchiveMirrorExecutionCoordinator(ArchiveUpdateSessionState archiveUpdateSessionState, Function0 function0, Function0 function02, Function0 function03, Function1 function1, Function0 function04, Function1 function12, ArchiveMirrorExecutionCallbacks archiveMirrorExecutionCallbacks, Function2 function2, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(archiveUpdateSessionState, function0, function02, function03, function1, function04, function12, archiveMirrorExecutionCallbacks, function2, (i & 512) != 0 ? Dispatchers.getIO() : coroutineDispatcher, (i & 1024) != 0 ? Dispatchers.getMain().getImmediate() : coroutineDispatcher2);
    }

    public final Object execute(ArchiveUpdatePlan archiveUpdatePlan, String str, Function3<? super String, ? super ArchiveUpdaterListener, ? super Continuation<? super ArchiveUpdaterResult>, ? extends Object> function3, Continuation<? super ArchiveUpdaterResult> continuation) {
        return ArchiveUpdateTransactionLock.INSTANCE.withLock(new ArchiveMirrorExecutionCoordinator$execute$2(this, str, function3, archiveUpdatePlan, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(7:5|6|7|(1:(1:(2:11|12)(2:14|15))(2:16|17))(3:24|25|(2:27|21))|18|19|(1:21)(1:22)))|33|6|7|(0)(0)|18|19|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0075, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0076, code lost:
        r10.callbacks.onRemainingBytesFallback(r12.getPackageId(), r0);
        r4 = r10.sessionState.snapshot().getStorageRequirements().getDownloadBytes();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ba, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bc, code lost:
        throw r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b9 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object prepareMirrorRetry(ArchiveUpdatePlan archiveUpdatePlan, ArchiveUpdaterResult.Failure failure, String str, Continuation<? super String> continuation) {
        ArchiveMirrorExecutionCoordinator$prepareMirrorRetry$1 archiveMirrorExecutionCoordinator$prepareMirrorRetry$1;
        int i;
        if (continuation instanceof ArchiveMirrorExecutionCoordinator$prepareMirrorRetry$1) {
            archiveMirrorExecutionCoordinator$prepareMirrorRetry$1 = (ArchiveMirrorExecutionCoordinator$prepareMirrorRetry$1) continuation;
            if ((archiveMirrorExecutionCoordinator$prepareMirrorRetry$1.label & Integer.MIN_VALUE) != 0) {
                archiveMirrorExecutionCoordinator$prepareMirrorRetry$1.label -= Integer.MIN_VALUE;
                ArchiveMirrorExecutionCoordinator$prepareMirrorRetry$1 archiveMirrorExecutionCoordinator$prepareMirrorRetry$12 = archiveMirrorExecutionCoordinator$prepareMirrorRetry$1;
                Object obj = archiveMirrorExecutionCoordinator$prepareMirrorRetry$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = archiveMirrorExecutionCoordinator$prepareMirrorRetry$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Function2<ArchiveUpdatePlan, Continuation<? super Long>, Object> function2 = this.remainingDownloadBytes;
                    archiveMirrorExecutionCoordinator$prepareMirrorRetry$12.L$0 = SpillingKt.nullOutSpilledVariable(archiveUpdatePlan);
                    archiveMirrorExecutionCoordinator$prepareMirrorRetry$12.L$1 = failure;
                    archiveMirrorExecutionCoordinator$prepareMirrorRetry$12.L$2 = str;
                    archiveMirrorExecutionCoordinator$prepareMirrorRetry$12.label = 1;
                    obj = function2.invoke(archiveUpdatePlan, archiveMirrorExecutionCoordinator$prepareMirrorRetry$12);
                    if (obj == coroutine_suspended) {
                    }
                } else if (i != 1) {
                    if (i == 2) {
                        long j = archiveMirrorExecutionCoordinator$prepareMirrorRetry$12.J$0;
                        String str2 = (String) archiveMirrorExecutionCoordinator$prepareMirrorRetry$12.L$2;
                        ArchiveUpdaterResult.Failure failure2 = (ArchiveUpdaterResult.Failure) archiveMirrorExecutionCoordinator$prepareMirrorRetry$12.L$1;
                        ArchiveUpdatePlan archiveUpdatePlan2 = (ArchiveUpdatePlan) archiveMirrorExecutionCoordinator$prepareMirrorRetry$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    str = (String) archiveMirrorExecutionCoordinator$prepareMirrorRetry$12.L$2;
                    failure = (ArchiveUpdaterResult.Failure) archiveMirrorExecutionCoordinator$prepareMirrorRetry$12.L$1;
                    archiveUpdatePlan = (ArchiveUpdatePlan) archiveMirrorExecutionCoordinator$prepareMirrorRetry$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                long downloadBytes = ((Number) obj).longValue();
                String str3 = str;
                long j2 = downloadBytes;
                archiveMirrorExecutionCoordinator$prepareMirrorRetry$12.L$0 = SpillingKt.nullOutSpilledVariable(archiveUpdatePlan);
                archiveMirrorExecutionCoordinator$prepareMirrorRetry$12.L$1 = SpillingKt.nullOutSpilledVariable(failure);
                archiveMirrorExecutionCoordinator$prepareMirrorRetry$12.L$2 = SpillingKt.nullOutSpilledVariable(str3);
                archiveMirrorExecutionCoordinator$prepareMirrorRetry$12.J$0 = j2;
                archiveMirrorExecutionCoordinator$prepareMirrorRetry$12.label = 2;
                Object withContext = BuildersKt.withContext(this.mainDispatcher, new ArchiveMirrorExecutionCoordinator$prepareMirrorRetry$2(this, j2, str3, null), archiveMirrorExecutionCoordinator$prepareMirrorRetry$12);
                return withContext != coroutine_suspended ? coroutine_suspended : withContext;
            }
        }
        archiveMirrorExecutionCoordinator$prepareMirrorRetry$1 = new ArchiveMirrorExecutionCoordinator$prepareMirrorRetry$1(this, continuation);
        ArchiveMirrorExecutionCoordinator$prepareMirrorRetry$1 archiveMirrorExecutionCoordinator$prepareMirrorRetry$122 = archiveMirrorExecutionCoordinator$prepareMirrorRetry$1;
        Object obj2 = archiveMirrorExecutionCoordinator$prepareMirrorRetry$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = archiveMirrorExecutionCoordinator$prepareMirrorRetry$122.label;
        if (i != 0) {
        }
        long downloadBytes2 = ((Number) obj2).longValue();
        String str32 = str;
        long j22 = downloadBytes2;
        archiveMirrorExecutionCoordinator$prepareMirrorRetry$122.L$0 = SpillingKt.nullOutSpilledVariable(archiveUpdatePlan);
        archiveMirrorExecutionCoordinator$prepareMirrorRetry$122.L$1 = SpillingKt.nullOutSpilledVariable(failure);
        archiveMirrorExecutionCoordinator$prepareMirrorRetry$122.L$2 = SpillingKt.nullOutSpilledVariable(str32);
        archiveMirrorExecutionCoordinator$prepareMirrorRetry$122.J$0 = j22;
        archiveMirrorExecutionCoordinator$prepareMirrorRetry$122.label = 2;
        Object withContext2 = BuildersKt.withContext(this.mainDispatcher, new ArchiveMirrorExecutionCoordinator$prepareMirrorRetry$2(this, j22, str32, null), archiveMirrorExecutionCoordinator$prepareMirrorRetry$122);
        if (withContext2 != coroutine_suspended2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArchiveUpdaterListener listener() {
        return new ArchiveMirrorExecutionCoordinator$listener$1(this);
    }

    /* compiled from: ArchiveMirrorExecutionCoordinator.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0093\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b2\u0018\u0010\u0018\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u000b\u0012\u0004\u0012\u00020\u00160\u00112\u0006\u0010\u0019\u001a\u00020\u001a¨\u0006\u001b"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveMirrorExecutionCoordinator$Companion;", "", "<init>", "()V", "create", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveMirrorExecutionCoordinator;", "stateStore", "Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore;", "sessionState", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateSessionState;", "mirrorCount", "Lkotlin/Function0;", "", "hasValidatedNetwork", "", "isCurrentOperation", "markCurrentServerUnreachable", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "failedServer", "", "currentServer", "postToMain", "callbacks", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveMirrorExecutionCallbacks;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArchiveMirrorExecutionCoordinator create(DurableArchiveStateStore stateStore, ArchiveUpdateSessionState sessionState, Function0<Integer> mirrorCount, Function0<Boolean> hasValidatedNetwork, Function0<Boolean> isCurrentOperation, Function1<? super String, Unit> markCurrentServerUnreachable, Function0<String> currentServer, Function1<? super Function0<Unit>, Unit> postToMain, ArchiveMirrorExecutionCallbacks callbacks) {
            Intrinsics.checkNotNullParameter(stateStore, "stateStore");
            Intrinsics.checkNotNullParameter(sessionState, "sessionState");
            Intrinsics.checkNotNullParameter(mirrorCount, "mirrorCount");
            Intrinsics.checkNotNullParameter(hasValidatedNetwork, "hasValidatedNetwork");
            Intrinsics.checkNotNullParameter(isCurrentOperation, "isCurrentOperation");
            Intrinsics.checkNotNullParameter(markCurrentServerUnreachable, "markCurrentServerUnreachable");
            Intrinsics.checkNotNullParameter(currentServer, "currentServer");
            Intrinsics.checkNotNullParameter(postToMain, "postToMain");
            Intrinsics.checkNotNullParameter(callbacks, "callbacks");
            return new ArchiveMirrorExecutionCoordinator(sessionState, mirrorCount, hasValidatedNetwork, isCurrentOperation, markCurrentServerUnreachable, currentServer, postToMain, callbacks, new ArchiveMirrorExecutionCoordinator$Companion$create$1(stateStore, null), null, null, 1536, null);
        }
    }
}
