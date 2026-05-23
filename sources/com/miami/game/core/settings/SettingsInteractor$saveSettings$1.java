package com.miami.game.core.settings;

import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import com.arizona.launcher.model.settings.SettingsConstants;
import com.miami.game.core.local.repository.common.LocalRepository;
import com.miami.game.core.settings.game_test.GameTestSavedScript;
import com.miami.game.core.settings.game_test.GameTestScriptPreferences;
import com.miami.game.core.settings.game_test.GameTestScriptStorage;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.settings.SettingsInteractor$saveSettings$1", f = "SettingsInteractor.kt", i = {0, 0, 0, 0}, l = {70}, m = "invokeSuspend", n = {"savedTestScripts", "resolvedActiveImportedScriptFileName", "activeImportedScript", "normalizedSettings"}, nl = {72}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
/* loaded from: classes5.dex */
public final class SettingsInteractor$saveSettings$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SettingState $settings;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
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
        String resolveActiveImportedScriptFileName;
        Object obj2;
        String debugImportedTestScriptName;
        ConnectionData normalizeConnectionData;
        LocalRepository localRepository2;
        SettingState settingState;
        LocalRepository localRepository3;
        MutableStateFlow mutableStateFlow;
        Object value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            localRepository = this.this$0.localRepository;
            List<GameTestSavedScript> listImportedScripts = GameTestScriptStorage.listImportedScripts(localRepository.getContext());
            resolveActiveImportedScriptFileName = this.this$0.resolveActiveImportedScriptFileName(this.$settings.getDebugActiveImportedTestScriptFileName(), this.$settings.getDebugUseImportedTestScript(), listImportedScripts);
            Iterator<T> it = listImportedScripts.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it.next();
                if (Intrinsics.areEqual(((GameTestSavedScript) obj2).getFileName(), resolveActiveImportedScriptFileName)) {
                    break;
                }
            }
            GameTestSavedScript gameTestSavedScript = (GameTestSavedScript) obj2;
            SettingState settingState2 = this.$settings;
            boolean z = settingState2.getDebugUseImportedTestScript() && gameTestSavedScript != null;
            String str = ((gameTestSavedScript == null || (debugImportedTestScriptName = gameTestSavedScript.getDisplayName()) == null) && ((debugImportedTestScriptName = this.$settings.getDebugImportedTestScriptName()) == null || StringsKt.isBlank(debugImportedTestScriptName))) ? null : debugImportedTestScriptName;
            String obj3 = StringsKt.trim((CharSequence) this.$settings.getDebugGameTestScreenshotPullPath()).toString();
            if (StringsKt.isBlank(obj3)) {
                obj3 = GameTestScriptPreferences.DEFAULT_SCREENSHOT_PULL_PATH;
            }
            String obj4 = StringsKt.trim((CharSequence) this.$settings.getDebugGameTestScreenshotDeviceDir()).toString();
            normalizeConnectionData = this.this$0.normalizeConnectionData(this.$settings.getConnectionData());
            SettingState copy$default = SettingState.copy$default(settingState2, 0.0f, 0, false, false, false, false, false, false, false, false, false, z, str, resolveActiveImportedScriptFileName, listImportedScripts, obj3, false, obj4, normalizeConnectionData, 67583, null);
            localRepository2 = this.this$0.localRepository;
            this.L$0 = SpillingKt.nullOutSpilledVariable(listImportedScripts);
            this.L$1 = SpillingKt.nullOutSpilledVariable(resolveActiveImportedScriptFileName);
            this.L$2 = SpillingKt.nullOutSpilledVariable(gameTestSavedScript);
            this.L$3 = copy$default;
            this.label = 1;
            if (localRepository2.save2(SettingsInteractor.SettingsKey, (String) copy$default, (Continuation<? super Unit>) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            settingState = copy$default;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            settingState = (SettingState) this.L$3;
            GameTestSavedScript gameTestSavedScript2 = (GameTestSavedScript) this.L$2;
            String str2 = (String) this.L$1;
            List list = (List) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        localRepository3 = this.this$0.localRepository;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(localRepository3.getContext());
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        SharedPreferences.Editor putBoolean = defaultSharedPreferences.edit().putInt(SettingsConstants.CHAT_PAGE_SIZE, settingState.getPageSize()).putFloat(SettingsConstants.CHAT_FONT_SIZE, settingState.getChatFontSize()).putBoolean(SettingsConstants.CHAT_PRINT_TIMESTAMP, settingState.getShowChatTime()).putBoolean(SettingsConstants.SHOW_FPS, settingState.getShowFps()).putBoolean(SettingsConstants.USE_FULLSCREEN, settingState.getFullScreen()).putBoolean(SettingsConstants.STREAMER_MODE, settingState.getStreamerMode()).putBoolean(SettingsConstants.AMBIENT_SOUNDS, settingState.getAmbientSounds()).putBoolean(SettingsConstants.DEBUG_AUTO_CONNECT_TEST_SERVER, settingState.getDebugAutoConnectTestServer()).putBoolean(GameTestScriptPreferences.AUTO_RUN_KEY, settingState.getDebugAutoRunTestScript()).putBoolean(GameTestScriptPreferences.USE_IMPORTED_KEY, settingState.getDebugUseImportedTestScript());
        String debugImportedTestScriptName2 = settingState.getDebugImportedTestScriptName();
        if (debugImportedTestScriptName2 == null) {
            debugImportedTestScriptName2 = "";
        }
        SharedPreferences.Editor putString = putBoolean.putString(GameTestScriptPreferences.IMPORTED_SCRIPT_NAME_KEY, debugImportedTestScriptName2);
        String debugActiveImportedTestScriptFileName = settingState.getDebugActiveImportedTestScriptFileName();
        putString.putString(GameTestScriptPreferences.ACTIVE_IMPORTED_SCRIPT_FILE_KEY, debugActiveImportedTestScriptFileName != null ? debugActiveImportedTestScriptFileName : "").putString(GameTestScriptPreferences.SCREENSHOT_PULL_PATH_KEY, settingState.getDebugGameTestScreenshotPullPath()).putBoolean(GameTestScriptPreferences.SCREENSHOT_BUTTON_ENABLED_KEY, settingState.getDebugGameTestScreenshotButtonEnabled()).putString(GameTestScriptPreferences.SCREENSHOT_DEVICE_DIR_KEY, settingState.getDebugGameTestScreenshotDeviceDir()).putString(SettingsConstants.DEBUG_TEST_SERVER_IP, settingState.getConnectionData().getIp()).putString(SettingsConstants.DEBUG_TEST_SERVER_PORT, settingState.getConnectionData().getPort()).putString(SettingsConstants.DEBUG_TEST_SERVER_PASSWORD, settingState.getConnectionData().getPassword()).apply();
        mutableStateFlow = this.this$0.stateStore;
        do {
            value = mutableStateFlow.getValue();
            SettingState settingState3 = (SettingState) value;
        } while (!mutableStateFlow.compareAndSet(value, settingState));
        return Unit.INSTANCE;
    }
}
