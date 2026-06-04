package com.miami.game.feature.settings.ui;

import androidx.compose.ui.graphics.ImageBitmap;
import androidx.core.app.FrameMetricsAggregator;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.miami.game.core.design.system.component.background.LauncherBackgroundState;
import com.miami.game.feature.settings.ui.model.SettingsUiState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.MutableStateFlow;
/* compiled from: SettingsComponent.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/miami/game/core/design/system/component/background/LauncherBackgroundState;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.settings.ui.SettingsComponent$initVmState$2$1", f = "SettingsComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
/* loaded from: classes5.dex */
final class SettingsComponent$initVmState$2$1 extends SuspendLambda implements Function2<LauncherBackgroundState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SettingsComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsComponent$initVmState$2$1(SettingsComponent settingsComponent, Continuation<? super SettingsComponent$initVmState$2$1> continuation) {
        super(2, continuation);
        this.this$0 = settingsComponent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SettingsComponent$initVmState$2$1 settingsComponent$initVmState$2$1 = new SettingsComponent$initVmState$2$1(this.this$0, continuation);
        settingsComponent$initVmState$2$1.L$0 = obj;
        return settingsComponent$initVmState$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(LauncherBackgroundState launcherBackgroundState, Continuation<? super Unit> continuation) {
        return ((SettingsComponent$initVmState$2$1) create(launcherBackgroundState, continuation)).invokeSuspend(Unit.INSTANCE);
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
            } while (!mutableStateFlow.compareAndSet(value, SettingsUiState.copy$default((SettingsUiState) value, 0, null, null, null, false, null, false, null, false, launcherBackgroundState.getVersion(), launcherBackgroundState.getFile(), imageBitmap, FrameMetricsAggregator.EVERY_DURATION, null)));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
