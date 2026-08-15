package com.arizona.launcher;

import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckDecision;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
/* compiled from: GameUpdateServiceFlow.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;", "response", "", "server"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.GameUpdateServiceFlow$request$job$1$result$4", f = "GameUpdateServiceFlow.kt", i = {0, 0}, l = {149}, m = "invokeSuspend", n = {"response", "server"}, nl = {151}, s = {"L$0", "L$1"}, v = 2)
/* loaded from: classes3.dex */
final class GameUpdateServiceFlow$request$job$1$result$4 extends SuspendLambda implements Function3<String, String, Continuation<? super ArchiveUpdateCheckDecision>, Object> {
    final /* synthetic */ UpdateOperationKind $kind;
    final /* synthetic */ long $token;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ GameUpdateServiceFlow this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameUpdateServiceFlow$request$job$1$result$4(GameUpdateServiceFlow gameUpdateServiceFlow, UpdateOperationKind updateOperationKind, long j, Continuation<? super GameUpdateServiceFlow$request$job$1$result$4> continuation) {
        super(3, continuation);
        this.this$0 = gameUpdateServiceFlow;
        this.$kind = updateOperationKind;
        this.$token = j;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(String str, String str2, Continuation<? super ArchiveUpdateCheckDecision> continuation) {
        GameUpdateServiceFlow$request$job$1$result$4 gameUpdateServiceFlow$request$job$1$result$4 = new GameUpdateServiceFlow$request$job$1$result$4(this.this$0, this.$kind, this.$token, continuation);
        gameUpdateServiceFlow$request$job$1$result$4.L$0 = str;
        gameUpdateServiceFlow$request$job$1$result$4.L$1 = str2;
        return gameUpdateServiceFlow$request$job$1$result$4.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GameUpdateServiceFlow.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.arizona.launcher.GameUpdateServiceFlow$request$job$1$result$4$1", f = "GameUpdateServiceFlow.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    /* renamed from: com.arizona.launcher.GameUpdateServiceFlow$request$job$1$result$4$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArchiveUpdateCheckDecision>, Object> {
        final /* synthetic */ UpdateOperationKind $kind;
        final /* synthetic */ String $response;
        final /* synthetic */ String $server;
        final /* synthetic */ long $token;
        int label;
        final /* synthetic */ GameUpdateServiceFlow this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(GameUpdateServiceFlow gameUpdateServiceFlow, String str, String str2, UpdateOperationKind updateOperationKind, long j, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = gameUpdateServiceFlow;
            this.$response = str;
            this.$server = str2;
            this.$kind = updateOperationKind;
            this.$token = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$response, this.$server, this.$kind, this.$token, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ArchiveUpdateCheckDecision> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Function5 function5;
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
            function5 = this.this$0.prepare;
            String str = this.$response;
            String str2 = this.$server;
            UpdateOperationKind updateOperationKind = this.$kind;
            Long boxLong = Boxing.boxLong(this.$token);
            this.label = 1;
            Object invoke = function5.invoke(str, str2, updateOperationKind, boxLong, this);
            return invoke == coroutine_suspended ? coroutine_suspended : invoke;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str = (String) this.L$0;
        String str2 = (String) this.L$1;
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
        this.L$1 = SpillingKt.nullOutSpilledVariable(str2);
        this.label = 1;
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(this.this$0, str, str2, this.$kind, this.$token, null), this);
        return withContext == coroutine_suspended ? coroutine_suspended : withContext;
    }
}
