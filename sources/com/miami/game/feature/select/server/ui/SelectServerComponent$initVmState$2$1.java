package com.miami.game.feature.select.server.ui;

import androidx.compose.ui.graphics.ImageBitmap;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.miami.game.core.design.system.component.background.LauncherBackgroundState;
import com.miami.game.feature.select.server.ui.model.SelectServerUiState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.MutableStateFlow;
/* compiled from: SelectServerComponent.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/miami/game/core/design/system/component/background/LauncherBackgroundState;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.select.server.ui.SelectServerComponent$initVmState$2$1", f = "SelectServerComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
/* loaded from: classes5.dex */
final class SelectServerComponent$initVmState$2$1 extends SuspendLambda implements Function2<LauncherBackgroundState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SelectServerComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectServerComponent$initVmState$2$1(SelectServerComponent selectServerComponent, Continuation<? super SelectServerComponent$initVmState$2$1> continuation) {
        super(2, continuation);
        this.this$0 = selectServerComponent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SelectServerComponent$initVmState$2$1 selectServerComponent$initVmState$2$1 = new SelectServerComponent$initVmState$2$1(this.this$0, continuation);
        selectServerComponent$initVmState$2$1.L$0 = obj;
        return selectServerComponent$initVmState$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(LauncherBackgroundState launcherBackgroundState, Continuation<? super Unit> continuation) {
        return ((SelectServerComponent$initVmState$2$1) create(launcherBackgroundState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object value;
        ImageBitmap imageBitmap;
        LauncherBackgroundState launcherBackgroundState = (LauncherBackgroundState) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0.stateStore;
            do {
                value = mutableStateFlow.getValue();
                imageBitmap = launcherBackgroundState.getImageBitmap();
            } while (!mutableStateFlow.compareAndSet(value, SelectServerUiState.copy$default((SelectServerUiState) value, null, null, null, false, 0, false, launcherBackgroundState.getVersion(), launcherBackgroundState.getFile(), imageBitmap, 63, null)));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
