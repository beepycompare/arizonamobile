package com.miami.game.feature.download.dialog.ui.setup;

import com.miami.game.feature.download.dialog.ui.common.model.CommonDialogUiAction;
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
/* compiled from: SetupDialog.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "uiAction", "Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogUiAction;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.download.dialog.ui.setup.SetupDialogKt$SetupDialogRoute$1$1", f = "SetupDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class SetupDialogKt$SetupDialogRoute$1$1 extends SuspendLambda implements Function3<CoroutineScope, CommonDialogUiAction, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $navigateToDownloadScreen;
    final /* synthetic */ Function0<Unit> $onBackClick;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetupDialogKt$SetupDialogRoute$1$1(Function0<Unit> function0, Function0<Unit> function02, Continuation<? super SetupDialogKt$SetupDialogRoute$1$1> continuation) {
        super(3, continuation);
        this.$onBackClick = function0;
        this.$navigateToDownloadScreen = function02;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, CommonDialogUiAction commonDialogUiAction, Continuation<? super Unit> continuation) {
        SetupDialogKt$SetupDialogRoute$1$1 setupDialogKt$SetupDialogRoute$1$1 = new SetupDialogKt$SetupDialogRoute$1$1(this.$onBackClick, this.$navigateToDownloadScreen, continuation);
        setupDialogKt$SetupDialogRoute$1$1.L$0 = commonDialogUiAction;
        return setupDialogKt$SetupDialogRoute$1$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CommonDialogUiAction commonDialogUiAction = (CommonDialogUiAction) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (Intrinsics.areEqual(commonDialogUiAction, CommonDialogUiAction.Cancel.INSTANCE)) {
            this.$onBackClick.invoke();
        } else if (!Intrinsics.areEqual(commonDialogUiAction, CommonDialogUiAction.Confirm.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        } else {
            this.$navigateToDownloadScreen.invoke();
        }
        return Unit.INSTANCE;
    }
}
