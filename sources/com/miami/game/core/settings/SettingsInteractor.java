package com.miami.game.core.settings;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.preference.PreferenceManager;
import com.miami.game.core.local.repository.common.LocalRepository;
import com.miami.game.core.settings.game_test.GameTestSavedScript;
import com.miami.game.core.settings.game_test.GameTestScriptPreferences;
import com.miami.game.core.settings.game_test.GameTestScriptStorage;
import com.miami.game.core.settings.logs.SaveLogToDownloadsKt;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
/* compiled from: SettingsInteractor.kt */
@Singleton
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0007\u0018\u0000 <2\u00020\u0001:\u0001<B\u0015\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0002\b\u0006¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010J\u0006\u0010\u0018\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0016J\u0006\u0010\u001a\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u0016J\u000e\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!J\u0018\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%H\u0002J\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\fH\u0002J*\u0010(\u001a\u0004\u0018\u00010!2\b\u0010)\u001a\u0004\u0018\u00010!2\u0006\u0010*\u001a\u00020\f2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/H\u0002J\u001a\u00101\u001a\u0004\u0018\u00010!2\u0006\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u00020!H\u0002J%\u00104\u001a\u0004\u0018\u0001H5\"\u0004\b\u0000\u001052\u0006\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u00020!H\u0002¢\u0006\u0002\u00106J\u001c\u00107\u001a\u00020\f*\u0002082\u0006\u00109\u001a\u00020!2\u0006\u0010:\u001a\u00020\fH\u0002J \u0010;\u001a\u0004\u0018\u00010!*\u0002082\u0006\u00109\u001a\u00020!2\b\u0010:\u001a\u0004\u0018\u00010!H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0002\b=¨\u0006\u0017"}, d2 = {"Lcom/miami/game/core/settings/SettingsInteractor;", "", "localRepository", "Lcom/miami/game/core/local/repository/common/LocalRepository;", "<init>", "(Lcom/miami/game/core/local/repository/common/LocalRepository;)V", "Ljavax/inject/Inject;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "isTablet", "", "()Z", "stateStore", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/miami/game/core/settings/SettingState;", "interactorStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getInteractorStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "saveSettings", "", "settings", "getSettings", "changeNotifications", "saveLogFile", "importGameTestScript", "uri", "Landroid/net/Uri;", "useBundledGameTestScript", "selectImportedGameTestScript", "fileName", "", "showToast", "message", TypedValues.TransitionType.S_DURATION, "", "normalizeLoadedSettings", "notifications", "resolveActiveImportedScriptFileName", "activeFileName", "useImported", "importedScripts", "", "Lcom/miami/game/core/settings/game_test/GameTestSavedScript;", "normalizeConnectionData", "Lcom/miami/game/core/settings/ConnectionData;", "connectionData", "readRawStringField", TypedValues.AttributesType.S_TARGET, "fieldName", "readRawField", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "getBooleanCompat", "Landroid/content/SharedPreferences;", "key", "defaultValue", "getStringCompat", "Companion", "Ljavax/inject/Singleton;"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingsInteractor {
    private static final String AMBIENT_SOUNDS_KEY = "ambient_sounds";
    private static final String CHAT_FONT_SIZE_KEY = "chat_fontsize";
    private static final String CHAT_PAGE_SIZE_KEY = "chat_pagesize";
    private static final String CHAT_PRINT_TIMESTAMP_KEY = "chat_print_timestamp";
    public static final Companion Companion = new Companion(null);
    private static final String DEBUG_AUTO_CONNECT_TEST_SERVER_KEY = "debug_auto_connect_test_server";
    private static final String DEBUG_TEST_SERVER_IP_KEY = "debug_test_server_ip";
    private static final String DEBUG_TEST_SERVER_PASSWORD_KEY = "debug_test_server_password";
    private static final String DEBUG_TEST_SERVER_PORT_KEY = "debug_test_server_port";
    private static final String SHOW_FPS_KEY = "show_fps";
    private static final String STREAMER_MODE_KEY = "streamer_mode";
    public static final String SettingsKey = "SETTINGS";
    private static final String USE_FULLSCREEN_KEY = "use_fullscreen";
    private final StateFlow<SettingState> interactorStateFlow;
    private final boolean isTablet;
    private final LocalRepository localRepository;
    private final CoroutineScope scope;
    private final MutableStateFlow<SettingState> stateStore;

    @Inject
    public SettingsInteractor(LocalRepository localRepository) {
        Intrinsics.checkNotNullParameter(localRepository, "localRepository");
        this.localRepository = localRepository;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        boolean z = localRepository.getContext().getResources().getConfiguration().smallestScreenWidthDp >= 600;
        this.isTablet = z;
        MutableStateFlow<SettingState> MutableStateFlow = StateFlowKt.MutableStateFlow(SettingState.Companion.init(z));
        this.stateStore = MutableStateFlow;
        this.interactorStateFlow = FlowKt.asStateFlow(MutableStateFlow);
        getSettings();
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    public final boolean isTablet() {
        return this.isTablet;
    }

    public final StateFlow<SettingState> getInteractorStateFlow() {
        return this.interactorStateFlow;
    }

    public final void saveSettings(SettingState settings) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new SettingsInteractor$saveSettings$1(this, settings, null), 3, null);
    }

    public final void getSettings() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new SettingsInteractor$getSettings$1(this, null), 3, null);
    }

    public final void changeNotifications() {
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.APP_PACKAGE", this.localRepository.getContext().getPackageName());
        intent.setFlags(268435456);
        this.localRepository.getContext().startActivity(intent);
    }

    public final void saveLogFile() {
        File externalFilesDir = this.localRepository.getContext().getExternalFilesDir(null);
        File file = new File((externalFilesDir != null ? externalFilesDir.getPath() : null) + "/logcat/samp.log");
        File externalFilesDir2 = this.localRepository.getContext().getExternalFilesDir(null);
        File file2 = new File((externalFilesDir2 != null ? externalFilesDir2.getPath() : null) + "/logcat/crashes.log");
        long currentTimeMillis = System.currentTimeMillis();
        SaveLogToDownloadsKt.copyToDownloads(this.localRepository.getContext(), file, "arizona_" + currentTimeMillis + "_" + file.getName());
        SaveLogToDownloadsKt.copyToDownloads(this.localRepository.getContext(), file2, "arizona_" + currentTimeMillis + "_" + file2.getName());
        Toast.makeText(this.localRepository.getContext(), "Логи сохранены в Загрузки", 1).show();
    }

    public final void importGameTestScript(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new SettingsInteractor$importGameTestScript$1(this, uri, null), 3, null);
    }

    public final void useBundledGameTestScript() {
        saveSettings(SettingState.copy$default(this.stateStore.getValue(), 0.0f, 0, false, false, false, false, false, false, false, false, false, false, null, null, null, null, false, false, null, null, 1046527, null));
    }

    public final void selectImportedGameTestScript(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new SettingsInteractor$selectImportedGameTestScript$1(this, fileName, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(final String str, final int i) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.miami.game.core.settings.SettingsInteractor$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Toast.makeText(SettingsInteractor.this.localRepository.getContext(), str, i).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a4, code lost:
        if (r7 != null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final SettingState normalizeLoadedSettings(SettingState settingState, boolean z) {
        Object obj;
        String str;
        String displayName;
        ConnectionData normalizeConnectionData;
        String obj2;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.localRepository.getContext());
        List<GameTestSavedScript> listImportedScripts = GameTestScriptStorage.listImportedScripts(this.localRepository.getContext());
        Intrinsics.checkNotNull(defaultSharedPreferences);
        Boolean bool = (Boolean) readRawField(settingState, "debugUseImportedTestScript");
        boolean z2 = false;
        boolean booleanCompat = getBooleanCompat(defaultSharedPreferences, GameTestScriptPreferences.USE_IMPORTED_KEY, bool != null ? bool.booleanValue() : false);
        String stringCompat = getStringCompat(defaultSharedPreferences, GameTestScriptPreferences.IMPORTED_SCRIPT_NAME_KEY, readRawStringField(settingState, "debugImportedTestScriptName"));
        if (stringCompat == null || StringsKt.isBlank(stringCompat)) {
            stringCompat = null;
        }
        String resolveActiveImportedScriptFileName = resolveActiveImportedScriptFileName(getStringCompat(defaultSharedPreferences, GameTestScriptPreferences.ACTIVE_IMPORTED_SCRIPT_FILE_KEY, readRawStringField(settingState, "debugActiveImportedTestScriptFileName")), booleanCompat, listImportedScripts);
        Iterator<T> it = listImportedScripts.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((GameTestSavedScript) obj).getFileName(), resolveActiveImportedScriptFileName)) {
                break;
            }
        }
        GameTestSavedScript gameTestSavedScript = (GameTestSavedScript) obj;
        String stringCompat2 = getStringCompat(defaultSharedPreferences, GameTestScriptPreferences.SCREENSHOT_PULL_PATH_KEY, readRawStringField(settingState, "debugGameTestScreenshotPullPath"));
        if (stringCompat2 != null && (obj2 = StringsKt.trim((CharSequence) stringCompat2).toString()) != null) {
            String str2 = obj2;
            str = StringsKt.isBlank(str2) ? null : str2;
        }
        str = GameTestScriptPreferences.DEFAULT_SCREENSHOT_PULL_PATH;
        String str3 = str;
        Boolean bool2 = (Boolean) readRawField(settingState, "debugGameTestScreenshotButtonEnabled");
        boolean booleanCompat2 = getBooleanCompat(defaultSharedPreferences, GameTestScriptPreferences.SCREENSHOT_BUTTON_ENABLED_KEY, bool2 != null ? bool2.booleanValue() : false);
        Boolean bool3 = (Boolean) readRawField(settingState, "debugGameTestLogShareButtonEnabled");
        boolean booleanCompat3 = getBooleanCompat(defaultSharedPreferences, GameTestScriptPreferences.LOG_SHARE_BUTTON_ENABLED_KEY, bool3 != null ? bool3.booleanValue() : false);
        String stringCompat3 = getStringCompat(defaultSharedPreferences, GameTestScriptPreferences.SCREENSHOT_DEVICE_DIR_KEY, readRawStringField(settingState, "debugGameTestScreenshotDeviceDir"));
        String str4 = (stringCompat3 == null || (r7 = StringsKt.trim((CharSequence) stringCompat3).toString()) == null) ? "" : "";
        ConnectionData connectionData = (ConnectionData) readRawField(settingState, "connectionData");
        ConnectionData connectionData2 = (connectionData == null || (normalizeConnectionData = normalizeConnectionData(connectionData)) == null) ? new ConnectionData(null, null, null, 7, null) : normalizeConnectionData;
        boolean booleanCompat4 = getBooleanCompat(defaultSharedPreferences, "debug_auto_connect_test_server", settingState.getDebugAutoConnectTestServer());
        boolean booleanCompat5 = getBooleanCompat(defaultSharedPreferences, GameTestScriptPreferences.AUTO_RUN_KEY, settingState.getDebugAutoRunTestScript());
        if (booleanCompat && gameTestSavedScript != null) {
            z2 = true;
        }
        return SettingState.copy$default(settingState, 0.0f, 0, false, false, false, false, false, false, z, booleanCompat4, booleanCompat5, z2, (gameTestSavedScript == null || (displayName = gameTestSavedScript.getDisplayName()) == null) ? stringCompat : displayName, resolveActiveImportedScriptFileName, listImportedScripts, str3, booleanCompat2, booleanCompat3, str4, connectionData2, 255, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String resolveActiveImportedScriptFileName(String str, boolean z, List<GameTestSavedScript> list) {
        String str2 = (str == null || (str2 = StringsKt.trim((CharSequence) str).toString()) == null || StringsKt.isBlank(str2)) ? null : null;
        if (str2 != null) {
            List<GameTestSavedScript> list2 = list;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                for (GameTestSavedScript gameTestSavedScript : list2) {
                    if (Intrinsics.areEqual(gameTestSavedScript.getFileName(), str2)) {
                        return str2;
                    }
                }
            }
        }
        if (z) {
            GameTestSavedScript gameTestSavedScript2 = (GameTestSavedScript) CollectionsKt.firstOrNull((List<? extends Object>) list);
            if (gameTestSavedScript2 != null) {
                return gameTestSavedScript2.getFileName();
            }
            return null;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r2 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (r1 == null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ConnectionData normalizeConnectionData(ConnectionData connectionData) {
        String port;
        ConnectionData connectionData2 = new ConnectionData(null, null, null, 7, null);
        String readRawStringField = readRawStringField(connectionData, "ip");
        if (readRawStringField != null) {
            if (StringsKt.isBlank(readRawStringField)) {
                readRawStringField = null;
            }
        }
        readRawStringField = connectionData2.getIp();
        String readRawStringField2 = readRawStringField(connectionData, "port");
        if (readRawStringField2 != null) {
            port = StringsKt.isBlank(readRawStringField2) ? null : readRawStringField2;
        }
        port = connectionData2.getPort();
        String readRawStringField3 = readRawStringField(connectionData, HintConstants.AUTOFILL_HINT_PASSWORD);
        if (readRawStringField3 == null) {
            readRawStringField3 = connectionData2.getPassword();
        }
        return new ConnectionData(readRawStringField, port, readRawStringField3);
    }

    private final String readRawStringField(Object obj, String str) {
        Object readRawField = readRawField(obj, str);
        if (readRawField instanceof String) {
            return (String) readRawField;
        }
        return null;
    }

    private final <T> T readRawField(Object obj, String str) {
        Object m9916constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            SettingsInteractor settingsInteractor = this;
            Field declaredField = obj.getClass().getDeclaredField(str);
            Intrinsics.checkNotNullExpressionValue(declaredField, "getDeclaredField(...)");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 == null) {
                obj2 = null;
            }
            m9916constructorimpl = Result.m9916constructorimpl(obj2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9916constructorimpl = Result.m9916constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9922isFailureimpl(m9916constructorimpl)) {
            return null;
        }
        return (T) m9916constructorimpl;
    }

    private final boolean getBooleanCompat(SharedPreferences sharedPreferences, String str, boolean z) {
        return sharedPreferences.contains(str) ? sharedPreferences.getBoolean(str, z) : z;
    }

    private final String getStringCompat(SharedPreferences sharedPreferences, String str, String str2) {
        return sharedPreferences.contains(str) ? sharedPreferences.getString(str, str2) : str2;
    }

    /* compiled from: SettingsInteractor.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/miami/game/core/settings/SettingsInteractor$Companion;", "", "<init>", "()V", "SettingsKey", "", "USE_FULLSCREEN_KEY", "SHOW_FPS_KEY", "CHAT_PAGE_SIZE_KEY", "CHAT_FONT_SIZE_KEY", "CHAT_PRINT_TIMESTAMP_KEY", "AMBIENT_SOUNDS_KEY", "STREAMER_MODE_KEY", "DEBUG_AUTO_CONNECT_TEST_SERVER_KEY", "DEBUG_TEST_SERVER_IP_KEY", "DEBUG_TEST_SERVER_PORT_KEY", "DEBUG_TEST_SERVER_PASSWORD_KEY", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
