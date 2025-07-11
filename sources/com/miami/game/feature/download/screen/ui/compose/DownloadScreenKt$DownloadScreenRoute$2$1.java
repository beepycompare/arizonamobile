package com.miami.game.feature.download.screen.ui.compose;

import com.miami.game.feature.download.screen.ui.model.DownloadScreenUiAction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: DownloadScreen.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "uiAction", "Lcom/miami/game/feature/download/screen/ui/model/DownloadScreenUiAction;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.download.screen.ui.compose.DownloadScreenKt$DownloadScreenRoute$2$1", f = "DownloadScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class DownloadScreenKt$DownloadScreenRoute$2$1 extends SuspendLambda implements Function3<CoroutineScope, DownloadScreenUiAction, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DownloadScreenKt$DownloadScreenRoute$2$1(Continuation<? super DownloadScreenKt$DownloadScreenRoute$2$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, DownloadScreenUiAction downloadScreenUiAction, Continuation<? super Unit> continuation) {
        return new DownloadScreenKt$DownloadScreenRoute$2$1(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return Unit.INSTANCE;
    }
}
