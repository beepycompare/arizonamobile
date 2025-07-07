package com.miami.game.feature.home.ui;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.miami.game.core.settings.SettingState;
import com.miami.game.feature.download.dialog.ui.connection.ConnectionHolder;
import com.miami.game.feature.download.dialog.ui.connection.SettingsData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
/* compiled from: HomeComponent.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/miami/game/core/settings/SettingState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.home.ui.HomeComponent$observeSettings$1", f = "HomeComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class HomeComponent$observeSettings$1 extends SuspendLambda implements Function2<SettingState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HomeComponent$observeSettings$1(Continuation<? super HomeComponent$observeSettings$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HomeComponent$observeSettings$1 homeComponent$observeSettings$1 = new HomeComponent$observeSettings$1(continuation);
        homeComponent$observeSettings$1.L$0 = obj;
        return homeComponent$observeSettings$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SettingState settingState, Continuation<? super Unit> continuation) {
        return ((HomeComponent$observeSettings$1) create(settingState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        SettingState settingState = (SettingState) this.L$0;
        int pageSize = settingState.getPageSize();
        int i2 = 1;
        int i3 = pageSize != 5 ? pageSize != 8 ? 2 : 1 : 0;
        float chatFontSize = settingState.getChatFontSize();
        if (chatFontSize == 0.1f) {
            i = 0;
        } else {
            if (chatFontSize != 0.5f) {
                if (chatFontSize != 1.0f) {
                    if (chatFontSize == 1.5f) {
                        i2 = 3;
                    } else if (chatFontSize == 2.0f) {
                        i2 = 4;
                    }
                }
                i = 2;
            }
            i = i2;
        }
        ConnectionHolder.INSTANCE.setSettingsData(SettingsData.copy$default(ConnectionHolder.INSTANCE.getSettingsData(), i3, i, settingState.getCustomKeyBoard(), settingState.getStreamerMode(), settingState.getShowChatTime(), settingState.getShowFps(), settingState.getFullScreen(), null, null, null, 896, null));
        return Unit.INSTANCE;
    }
}
