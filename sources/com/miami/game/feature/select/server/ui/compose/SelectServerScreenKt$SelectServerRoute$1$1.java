package com.miami.game.feature.select.server.ui.compose;

import com.miami.game.feature.select.server.ui.model.ServerUiAction;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: SelectServerScreen.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "uiAction", "Lcom/miami/game/feature/select/server/ui/model/ServerUiAction;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.select.server.ui.compose.SelectServerScreenKt$SelectServerRoute$1$1", f = "SelectServerScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class SelectServerScreenKt$SelectServerRoute$1$1 extends SuspendLambda implements Function3<CoroutineScope, ServerUiAction, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $navigateHome;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectServerScreenKt$SelectServerRoute$1$1(Function0<Unit> function0, Continuation<? super SelectServerScreenKt$SelectServerRoute$1$1> continuation) {
        super(3, continuation);
        this.$navigateHome = function0;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, ServerUiAction serverUiAction, Continuation<? super Unit> continuation) {
        SelectServerScreenKt$SelectServerRoute$1$1 selectServerScreenKt$SelectServerRoute$1$1 = new SelectServerScreenKt$SelectServerRoute$1$1(this.$navigateHome, continuation);
        selectServerScreenKt$SelectServerRoute$1$1.L$0 = serverUiAction;
        return selectServerScreenKt$SelectServerRoute$1$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ServerUiAction serverUiAction = (ServerUiAction) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (!Intrinsics.areEqual(serverUiAction, ServerUiAction.NavigateToHome.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        this.$navigateHome.invoke();
        return Unit.INSTANCE;
    }
}
