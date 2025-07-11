package com.miami.game.feature.download.dialog.ui.error.compose;

import com.miami.game.feature.download.dialog.ui.error.model.ErrorDialogUiAction;
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
/* compiled from: NoNetworkErrorDialog.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "uiAction", "Lcom/miami/game/feature/download/dialog/ui/error/model/ErrorDialogUiAction;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.download.dialog.ui.error.compose.NoNetworkErrorDialogKt$NoNetworkErrorDialogRoute$1$1", f = "NoNetworkErrorDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class NoNetworkErrorDialogKt$NoNetworkErrorDialogRoute$1$1 extends SuspendLambda implements Function3<CoroutineScope, ErrorDialogUiAction, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onRetry;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoNetworkErrorDialogKt$NoNetworkErrorDialogRoute$1$1(Function0<Unit> function0, Continuation<? super NoNetworkErrorDialogKt$NoNetworkErrorDialogRoute$1$1> continuation) {
        super(3, continuation);
        this.$onRetry = function0;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, ErrorDialogUiAction errorDialogUiAction, Continuation<? super Unit> continuation) {
        NoNetworkErrorDialogKt$NoNetworkErrorDialogRoute$1$1 noNetworkErrorDialogKt$NoNetworkErrorDialogRoute$1$1 = new NoNetworkErrorDialogKt$NoNetworkErrorDialogRoute$1$1(this.$onRetry, continuation);
        noNetworkErrorDialogKt$NoNetworkErrorDialogRoute$1$1.L$0 = errorDialogUiAction;
        return noNetworkErrorDialogKt$NoNetworkErrorDialogRoute$1$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ErrorDialogUiAction errorDialogUiAction = (ErrorDialogUiAction) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (!Intrinsics.areEqual(errorDialogUiAction, ErrorDialogUiAction.Retry.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        this.$onRetry.invoke();
        return Unit.INSTANCE;
    }
}
