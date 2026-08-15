package com.arizona.launcher;

import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckDecision;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateSessionSnapshot;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateSessionState;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
/* compiled from: GameUpdateServiceFlow.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B²\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00125\b\u0002\u0010\u0010\u001a/\b\u0001\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011\u0012p\u0010\u0018\u001al\b\u0001\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019\u00126\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b( \u0012\u0013\u0012\u00110!¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020#0\u0011¢\u0006\u0004\b$\u0010%J\u0006\u0010(\u001a\u00020#J\u0006\u0010)\u001a\u00020#J\u0010\u0010*\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R=\u0010\u0010\u001a/\b\u0001\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&Rz\u0010\u0018\u001al\b\u0001\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'R>\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b( \u0012\u0013\u0012\u00110!¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020#0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b,\u0012\b\b-\u0012\u0004\b\u0003\u0010\u0000¨\u0006+"}, d2 = {"Lcom/arizona/launcher/GameUpdateServiceFlow;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "runner", "Lcom/arizona/launcher/GameUpdateCheckRunner;", "sessionState", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateSessionState;", "host", "Lcom/arizona/launcher/GameUpdateServiceHost;", "currentServer", "Lkotlin/Function0;", "", "mirrorCount", "", "metadataFileName", "primaryCheckPreflight", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "operationToken", "Lkotlin/coroutines/Continuation;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision$Block;", "prepare", "Lkotlin/Function5;", "response", "server", "Lcom/arizona/launcher/UpdateOperationKind;", "kind", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;", "onPrepared", "decision", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateSessionSnapshot;", "snapshot", "", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lcom/arizona/launcher/GameUpdateCheckRunner;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateSessionState;Lcom/arizona/launcher/GameUpdateServiceHost;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function5;", "requestCheck", "requestCheckAndDownload", "request", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GameUpdateServiceFlow {
    public static final int $stable = ArchiveUpdateSessionState.$stable | GameUpdateCheckRunner.$stable;
    private final Function0<String> currentServer;
    private final GameUpdateServiceHost host;
    private final Function0<String> metadataFileName;
    private final Function0<Integer> mirrorCount;
    private final Function2<ArchiveUpdateCheckDecision, ArchiveUpdateSessionSnapshot, Unit> onPrepared;
    private final Function5<String, String, UpdateOperationKind, Long, Continuation<? super ArchiveUpdateCheckDecision>, Object> prepare;
    private final Function2<Long, Continuation<? super ArchiveUpdateCheckDecision.Block>, Object> primaryCheckPreflight;
    private final GameUpdateCheckRunner runner;
    private final CoroutineScope scope;
    private final ArchiveUpdateSessionState sessionState;

    /* JADX WARN: Multi-variable type inference failed */
    public GameUpdateServiceFlow(CoroutineScope scope, GameUpdateCheckRunner runner, ArchiveUpdateSessionState sessionState, GameUpdateServiceHost host, Function0<String> currentServer, Function0<Integer> mirrorCount, Function0<String> metadataFileName, Function2<? super Long, ? super Continuation<? super ArchiveUpdateCheckDecision.Block>, ? extends Object> primaryCheckPreflight, Function5<? super String, ? super String, ? super UpdateOperationKind, ? super Long, ? super Continuation<? super ArchiveUpdateCheckDecision>, ? extends Object> prepare, Function2<? super ArchiveUpdateCheckDecision, ? super ArchiveUpdateSessionSnapshot, Unit> onPrepared) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(runner, "runner");
        Intrinsics.checkNotNullParameter(sessionState, "sessionState");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(currentServer, "currentServer");
        Intrinsics.checkNotNullParameter(mirrorCount, "mirrorCount");
        Intrinsics.checkNotNullParameter(metadataFileName, "metadataFileName");
        Intrinsics.checkNotNullParameter(primaryCheckPreflight, "primaryCheckPreflight");
        Intrinsics.checkNotNullParameter(prepare, "prepare");
        Intrinsics.checkNotNullParameter(onPrepared, "onPrepared");
        this.scope = scope;
        this.runner = runner;
        this.sessionState = sessionState;
        this.host = host;
        this.currentServer = currentServer;
        this.mirrorCount = mirrorCount;
        this.metadataFileName = metadataFileName;
        this.primaryCheckPreflight = primaryCheckPreflight;
        this.prepare = prepare;
        this.onPrepared = onPrepared;
    }

    /* compiled from: GameUpdateServiceFlow.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision$Block;", "it", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.arizona.launcher.GameUpdateServiceFlow$1", f = "GameUpdateServiceFlow.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    /* renamed from: com.arizona.launcher.GameUpdateServiceFlow$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Long, Continuation<? super ArchiveUpdateCheckDecision.Block>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        public final Object invoke(long j, Continuation<? super ArchiveUpdateCheckDecision.Block> continuation) {
            return ((AnonymousClass1) create(Long.valueOf(j), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Long l, Continuation<? super ArchiveUpdateCheckDecision.Block> continuation) {
            return invoke(l.longValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public /* synthetic */ GameUpdateServiceFlow(CoroutineScope coroutineScope, GameUpdateCheckRunner gameUpdateCheckRunner, ArchiveUpdateSessionState archiveUpdateSessionState, GameUpdateServiceHost gameUpdateServiceHost, Function0 function0, Function0 function02, Function0 function03, Function2 function2, Function5 function5, Function2 function22, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, gameUpdateCheckRunner, archiveUpdateSessionState, gameUpdateServiceHost, function0, function02, function03, (i & 128) != 0 ? new AnonymousClass1(null) : function2, function5, function22);
    }

    public final void requestCheck() {
        request(UpdateOperationKind.CHECK_UPDATE);
    }

    public final void requestCheckAndDownload() {
        request(UpdateOperationKind.CHECK_AND_DOWNLOAD);
    }

    private final void request(UpdateOperationKind updateOperationKind) {
        CoroutineScope coroutineScope;
        Job launch$default;
        if (updateOperationKind != UpdateOperationKind.CHECK_UPDATE && updateOperationKind != UpdateOperationKind.CHECK_AND_DOWNLOAD) {
            throw new IllegalArgumentException(("Unsupported game check operation: " + updateOperationKind).toString());
        }
        final boolean z = updateOperationKind == UpdateOperationKind.CHECK_AND_DOWNLOAD;
        Long beginGameCheckOperation = this.host.beginGameCheckOperation(z);
        if (beginGameCheckOperation != null) {
            final long longValue = beginGameCheckOperation.longValue();
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final Function0 function0 = new Function0() { // from class: com.arizona.launcher.GameUpdateServiceFlow$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GameUpdateServiceFlow.request$lambda$1(atomicBoolean, this, z, longValue);
                }
            };
            try {
                this.sessionState.invalidateForManifestRefresh();
                this.host.onGameCheckStarted(z);
                coroutineScope = this.scope;
            } catch (Throwable th) {
                th = th;
            }
            try {
                GameUpdateServiceFlow$request$job$1 gameUpdateServiceFlow$request$job$1 = new GameUpdateServiceFlow$request$job$1(updateOperationKind, this, z, longValue, function0, null);
                function0 = function0;
                launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, gameUpdateServiceFlow$request$job$1, 3, null);
                launch$default.invokeOnCompletion(new Function1() { // from class: com.arizona.launcher.GameUpdateServiceFlow$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GameUpdateServiceFlow.request$lambda$2(Function0.this, (Throwable) obj);
                    }
                });
            } catch (Throwable th2) {
                th = th2;
                function0 = function0;
                Throwable th3 = th;
                function0.invoke();
                throw th3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit request$lambda$1(AtomicBoolean atomicBoolean, GameUpdateServiceFlow gameUpdateServiceFlow, boolean z, long j) {
        if (atomicBoolean.compareAndSet(false, true)) {
            gameUpdateServiceFlow.host.finishGameCheckOperation(z, j);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit request$lambda$2(Function0 function0, Throwable th) {
        function0.invoke();
        return Unit.INSTANCE;
    }
}
