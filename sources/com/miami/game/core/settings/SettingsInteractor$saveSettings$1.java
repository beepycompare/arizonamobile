package com.miami.game.core.settings;

import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import com.arizona.launcher.model.settings.SettingsConstants;
import com.miami.game.core.local.repository.common.LocalRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.settings.SettingsInteractor$saveSettings$1", f = "SettingsInteractor.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class SettingsInteractor$saveSettings$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SettingState $settings;
    int label;
    final /* synthetic */ SettingsInteractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsInteractor$saveSettings$1(SettingsInteractor settingsInteractor, SettingState settingState, Continuation<? super SettingsInteractor$saveSettings$1> continuation) {
        super(2, continuation);
        this.this$0 = settingsInteractor;
        this.$settings = settingState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingsInteractor$saveSettings$1(this.this$0, this.$settings, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SettingsInteractor$saveSettings$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LocalRepository localRepository;
        LocalRepository localRepository2;
        MutableStateFlow mutableStateFlow;
        Object value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            localRepository = this.this$0.localRepository;
            this.label = 1;
            if (localRepository.save2(SettingsInteractor.Companion.getSettingsKey(), (String) this.$settings, (Continuation<? super Unit>) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        localRepository2 = this.this$0.localRepository;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(localRepository2.getContext());
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        defaultSharedPreferences.edit().putBoolean(SettingsConstants.SHOW_FPS, this.$settings.getShowFps()).putBoolean(SettingsConstants.USE_FULLSCREEN, this.$settings.getFullScreen()).putBoolean(SettingsConstants.STREAMER_MODE, this.$settings.getStreamerMode()).apply();
        mutableStateFlow = this.this$0.stateStore;
        SettingState settingState = this.$settings;
        do {
            value = mutableStateFlow.getValue();
            SettingState settingState2 = (SettingState) value;
        } while (!mutableStateFlow.compareAndSet(value, settingState));
        return Unit.INSTANCE;
    }
}
