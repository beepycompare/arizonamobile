package com.arizona.launcher;

import androidx.media3.extractor.ts.TsExtractor;
import com.arizona.launcher.GameUpdateCheckRunResult;
import com.arizona.launcher.GameUpdateServiceCompletion;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckDecision;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateSessionSnapshot;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateSessionState;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GameUpdateServiceFlow.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.GameUpdateServiceFlow$request$job$1", f = "GameUpdateServiceFlow.kt", i = {}, l = {111, TsExtractor.TS_STREAM_TYPE_AC3}, m = "invokeSuspend", n = {}, nl = {114, 154}, s = {}, v = 2)
/* loaded from: classes3.dex */
public final class GameUpdateServiceFlow$request$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $combined;
    final /* synthetic */ UpdateOperationKind $kind;
    final /* synthetic */ Function0<Unit> $releaseOperation;
    final /* synthetic */ long $token;
    int label;
    final /* synthetic */ GameUpdateServiceFlow this$0;

    /* compiled from: GameUpdateServiceFlow.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GameUpdateMirrorRetryReason.values().length];
            try {
                iArr[GameUpdateMirrorRetryReason.METADATA_FAILURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GameUpdateMirrorRetryReason.ARCHIVE_CHECK_BLOCK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameUpdateServiceFlow$request$job$1(UpdateOperationKind updateOperationKind, GameUpdateServiceFlow gameUpdateServiceFlow, boolean z, long j, Function0<Unit> function0, Continuation<? super GameUpdateServiceFlow$request$job$1> continuation) {
        super(2, continuation);
        this.$kind = updateOperationKind;
        this.this$0 = gameUpdateServiceFlow;
        this.$combined = z;
        this.$token = j;
        this.$releaseOperation = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GameUpdateServiceFlow$request$job$1(this.$kind, this.this$0, this.$combined, this.$token, this.$releaseOperation, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GameUpdateServiceFlow$request$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x012a, code lost:
        if (r3 != r0) goto L8;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        GameUpdateServiceHost gameUpdateServiceHost;
        Object withContext;
        GameUpdateCheckRunner gameUpdateCheckRunner;
        Function0 function0;
        Function0 function02;
        Function0 function03;
        boolean z;
        Object run;
        GameUpdateServiceHost gameUpdateServiceHost2;
        ArchiveUpdateSessionState archiveUpdateSessionState;
        Function0 function04;
        Function2 function2;
        GameUpdateServiceHost gameUpdateServiceHost3;
        GameUpdateServiceHost gameUpdateServiceHost4;
        ArchiveUpdateSessionState archiveUpdateSessionState2;
        Function2 function22;
        GameUpdateServiceCompletion.Prepared prepared;
        GameUpdateServiceHost gameUpdateServiceHost5;
        GameUpdateServiceHost gameUpdateServiceHost6;
        GameUpdateServiceHost gameUpdateServiceHost7;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$kind == UpdateOperationKind.CHECK_UPDATE) {
                    gameUpdateServiceHost = this.this$0.host;
                    if (!gameUpdateServiceHost.isCurrentGameCheckOperation(this.$combined, this.$token)) {
                        return Unit.INSTANCE;
                    }
                    this.label = 1;
                    withContext = BuildersKt.withContext(Dispatchers.getIO(), new GameUpdateServiceFlow$request$job$1$preflightBlock$1(this.this$0, this.$token, null), this);
                    if (withContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                gameUpdateCheckRunner = this.this$0.runner;
                function0 = this.this$0.currentServer;
                String str = (String) function0.invoke();
                function02 = this.this$0.mirrorCount;
                int intValue = ((Number) function02.invoke()).intValue();
                function03 = this.this$0.metadataFileName;
                String str2 = (String) function03.invoke();
                final GameUpdateServiceFlow gameUpdateServiceFlow = this.this$0;
                final boolean z2 = this.$combined;
                final long j = this.$token;
                Function0<Boolean> function05 = new Function0() { // from class: com.arizona.launcher.GameUpdateServiceFlow$request$job$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(GameUpdateServiceFlow$request$job$1.invokeSuspend$lambda$0(GameUpdateServiceFlow.this, z2, j));
                    }
                };
                final GameUpdateServiceFlow gameUpdateServiceFlow2 = this.this$0;
                final boolean z3 = this.$combined;
                Function1<? super String, Unit> function1 = new Function1() { // from class: com.arizona.launcher.GameUpdateServiceFlow$request$job$1$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return GameUpdateServiceFlow$request$job$1.invokeSuspend$lambda$1(GameUpdateServiceFlow.this, z3, (String) obj2);
                    }
                };
                final GameUpdateServiceFlow gameUpdateServiceFlow3 = this.this$0;
                Function2<? super String, ? super GameUpdateMirrorRetryReason, Unit> function23 = new Function2() { // from class: com.arizona.launcher.GameUpdateServiceFlow$request$job$1$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return GameUpdateServiceFlow$request$job$1.invokeSuspend$lambda$2(GameUpdateServiceFlow.this, (String) obj2, (GameUpdateMirrorRetryReason) obj3);
                    }
                };
                z = true;
                this.label = 2;
                run = gameUpdateCheckRunner.run(str, intValue, str2, function05, function1, function23, new GameUpdateServiceFlow$request$job$1$result$4(this.this$0, this.$kind, this.$token, null), this);
            } else if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    run = obj;
                    z = true;
                    GameUpdateCheckRunResult gameUpdateCheckRunResult = (GameUpdateCheckRunResult) run;
                    gameUpdateServiceHost4 = this.this$0.host;
                    if (gameUpdateServiceHost4.isCurrentGameCheckOperation(this.$combined, this.$token)) {
                        if (Intrinsics.areEqual(gameUpdateCheckRunResult, GameUpdateCheckRunResult.Stale.INSTANCE)) {
                            return Unit.INSTANCE;
                        }
                        if (Intrinsics.areEqual(gameUpdateCheckRunResult, GameUpdateCheckRunResult.ServerEmpty.INSTANCE)) {
                            prepared = GameUpdateServiceCompletion.ServerEmpty.INSTANCE;
                        } else if (gameUpdateCheckRunResult instanceof GameUpdateCheckRunResult.MetadataFailed) {
                            prepared = new GameUpdateServiceCompletion.MetadataFailed(((GameUpdateCheckRunResult.MetadataFailed) gameUpdateCheckRunResult).getFailure());
                        } else if (!(gameUpdateCheckRunResult instanceof GameUpdateCheckRunResult.Prepared)) {
                            throw new NoWhenBranchMatchedException();
                        } else {
                            archiveUpdateSessionState2 = this.this$0.sessionState;
                            ArchiveUpdateSessionSnapshot applyDecision = archiveUpdateSessionState2.applyDecision(((GameUpdateCheckRunResult.Prepared) gameUpdateCheckRunResult).getDecision(), ((GameUpdateCheckRunResult.Prepared) gameUpdateCheckRunResult).getServer());
                            function22 = this.this$0.onPrepared;
                            function22.invoke(((GameUpdateCheckRunResult.Prepared) gameUpdateCheckRunResult).getDecision(), applyDecision);
                            prepared = new GameUpdateServiceCompletion.Prepared(z ^ (((GameUpdateCheckRunResult.Prepared) gameUpdateCheckRunResult).getDecision() instanceof ArchiveUpdateCheckDecision.Block));
                        }
                        this.$releaseOperation.invoke();
                        if (prepared instanceof GameUpdateServiceCompletion.Prepared) {
                            gameUpdateServiceHost7 = this.this$0.host;
                            gameUpdateServiceHost7.completePreparedGameCheck(this.$combined, ((GameUpdateServiceCompletion.Prepared) prepared).getSuccessfully());
                        } else if (prepared instanceof GameUpdateServiceCompletion.MetadataFailed) {
                            gameUpdateServiceHost6 = this.this$0.host;
                            gameUpdateServiceHost6.completeGameCheckMetadataFailed(this.$combined, ((GameUpdateServiceCompletion.MetadataFailed) prepared).getFailure().toString());
                        } else if (!Intrinsics.areEqual(prepared, GameUpdateServiceCompletion.ServerEmpty.INSTANCE)) {
                            throw new NoWhenBranchMatchedException();
                        } else {
                            gameUpdateServiceHost5 = this.this$0.host;
                            gameUpdateServiceHost5.completeGameCheckServerEmpty(this.$combined);
                        }
                        this.$releaseOperation.invoke();
                        return Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
                withContext = obj;
            }
            ArchiveUpdateCheckDecision.Block block = (ArchiveUpdateCheckDecision.Block) withContext;
            gameUpdateServiceHost2 = this.this$0.host;
            if (!gameUpdateServiceHost2.isCurrentGameCheckOperation(this.$combined, this.$token)) {
                return Unit.INSTANCE;
            }
            if (block != null) {
                archiveUpdateSessionState = this.this$0.sessionState;
                function04 = this.this$0.currentServer;
                ArchiveUpdateSessionSnapshot applyDecision2 = archiveUpdateSessionState.applyDecision(block, (String) function04.invoke());
                function2 = this.this$0.onPrepared;
                function2.invoke(block, applyDecision2);
                this.$releaseOperation.invoke();
                gameUpdateServiceHost3 = this.this$0.host;
                gameUpdateServiceHost3.completePreparedGameCheck(false, false);
                return Unit.INSTANCE;
            }
            gameUpdateCheckRunner = this.this$0.runner;
            function0 = this.this$0.currentServer;
            String str3 = (String) function0.invoke();
            function02 = this.this$0.mirrorCount;
            int intValue2 = ((Number) function02.invoke()).intValue();
            function03 = this.this$0.metadataFileName;
            String str22 = (String) function03.invoke();
            final GameUpdateServiceFlow gameUpdateServiceFlow4 = this.this$0;
            final boolean z22 = this.$combined;
            final long j2 = this.$token;
            Function0<Boolean> function052 = new Function0() { // from class: com.arizona.launcher.GameUpdateServiceFlow$request$job$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(GameUpdateServiceFlow$request$job$1.invokeSuspend$lambda$0(GameUpdateServiceFlow.this, z22, j2));
                }
            };
            final GameUpdateServiceFlow gameUpdateServiceFlow22 = this.this$0;
            final boolean z32 = this.$combined;
            Function1<? super String, Unit> function12 = new Function1() { // from class: com.arizona.launcher.GameUpdateServiceFlow$request$job$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return GameUpdateServiceFlow$request$job$1.invokeSuspend$lambda$1(GameUpdateServiceFlow.this, z32, (String) obj2);
                }
            };
            final GameUpdateServiceFlow gameUpdateServiceFlow32 = this.this$0;
            Function2<? super String, ? super GameUpdateMirrorRetryReason, Unit> function232 = new Function2() { // from class: com.arizona.launcher.GameUpdateServiceFlow$request$job$1$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return GameUpdateServiceFlow$request$job$1.invokeSuspend$lambda$2(GameUpdateServiceFlow.this, (String) obj2, (GameUpdateMirrorRetryReason) obj3);
                }
            };
            z = true;
            this.label = 2;
            run = gameUpdateCheckRunner.run(str3, intValue2, str22, function052, function12, function232, new GameUpdateServiceFlow$request$job$1$result$4(this.this$0, this.$kind, this.$token, null), this);
        } finally {
            this.$releaseOperation.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean invokeSuspend$lambda$0(GameUpdateServiceFlow gameUpdateServiceFlow, boolean z, long j) {
        GameUpdateServiceHost gameUpdateServiceHost;
        gameUpdateServiceHost = gameUpdateServiceFlow.host;
        return gameUpdateServiceHost.isCurrentGameCheckOperation(z, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit invokeSuspend$lambda$1(GameUpdateServiceFlow gameUpdateServiceFlow, boolean z, String str) {
        ArchiveUpdateSessionState archiveUpdateSessionState;
        GameUpdateServiceHost gameUpdateServiceHost;
        archiveUpdateSessionState = gameUpdateServiceFlow.sessionState;
        archiveUpdateSessionState.beginMetadataEvaluation();
        gameUpdateServiceHost = gameUpdateServiceFlow.host;
        gameUpdateServiceHost.onGameMetadataLoaded(z, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit invokeSuspend$lambda$2(GameUpdateServiceFlow gameUpdateServiceFlow, String str, GameUpdateMirrorRetryReason gameUpdateMirrorRetryReason) {
        GameUpdateServiceHost gameUpdateServiceHost;
        String str2;
        gameUpdateServiceHost = gameUpdateServiceFlow.host;
        int i = WhenMappings.$EnumSwitchMapping$0[gameUpdateMirrorRetryReason.ordinal()];
        if (i == 1) {
            str2 = "game metadata";
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            str2 = "archive manifest/index";
        }
        gameUpdateServiceHost.onGameCheckMirrorRetry(str, str2);
        return Unit.INSTANCE;
    }
}
