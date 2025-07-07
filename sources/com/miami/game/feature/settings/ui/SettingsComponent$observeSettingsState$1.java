package com.miami.game.feature.settings.ui;

import com.miami.game.core.settings.SettingState;
import com.miami.game.feature.download.dialog.ui.connection.ConnectionData;
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
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsComponent.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "settingState", "Lcom/miami/game/core/settings/SettingState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.settings.ui.SettingsComponent$observeSettingsState$1", f = "SettingsComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class SettingsComponent$observeSettingsState$1 extends SuspendLambda implements Function2<SettingState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SettingsComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsComponent$observeSettingsState$1(SettingsComponent settingsComponent, Continuation<? super SettingsComponent$observeSettingsState$1> continuation) {
        super(2, continuation);
        this.this$0 = settingsComponent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SettingsComponent$observeSettingsState$1 settingsComponent$observeSettingsState$1 = new SettingsComponent$observeSettingsState$1(this.this$0, continuation);
        settingsComponent$observeSettingsState$1.L$0 = obj;
        return settingsComponent$observeSettingsState$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SettingState settingState, Continuation<? super Unit> continuation) {
        return ((SettingsComponent$observeSettingsState$1) create(settingState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object value;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            SettingState settingState = (SettingState) this.L$0;
            mutableStateFlow = this.this$0.stateStore;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, SettingsUiState.copy$default((SettingsUiState) value, 0, settingState, null, null, false, new ConnectionData(settingState.getConnectionData().getIp(), settingState.getConnectionData().getPort(), settingState.getConnectionData().getPassword()), false, null, 221, null)));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
