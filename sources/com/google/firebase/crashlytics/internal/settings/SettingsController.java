package com.google.firebase.crashlytics.internal.settings;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.common.SystemCurrentTimeProvider;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SettingsController implements SettingsProvider {
    private static final String PREFS_BUILD_INSTANCE_IDENTIFIER = "existing_instance_identifier";
    private static final String SETTINGS_URL_FORMAT = "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings";
    private final CachedSettingsIo cachedSettingsIo;
    private final Context context;
    private final CurrentTimeProvider currentTimeProvider;
    private final DataCollectionArbiter dataCollectionArbiter;
    private final AtomicReference<Settings> settings;
    private final SettingsJsonParser settingsJsonParser;
    private final SettingsRequest settingsRequest;
    private final SettingsSpiCall settingsSpiCall;
    private final AtomicReference<TaskCompletionSource<Settings>> settingsTask;

    SettingsController(Context context, SettingsRequest settingsRequest, CurrentTimeProvider currentTimeProvider, SettingsJsonParser settingsJsonParser, CachedSettingsIo cachedSettingsIo, SettingsSpiCall settingsSpiCall, DataCollectionArbiter dataCollectionArbiter) {
        AtomicReference<Settings> atomicReference = new AtomicReference<>();
        this.settings = atomicReference;
        this.settingsTask = new AtomicReference<>(new TaskCompletionSource());
        this.context = context;
        this.settingsRequest = settingsRequest;
        this.currentTimeProvider = currentTimeProvider;
        this.settingsJsonParser = settingsJsonParser;
        this.cachedSettingsIo = cachedSettingsIo;
        this.settingsSpiCall = settingsSpiCall;
        this.dataCollectionArbiter = dataCollectionArbiter;
        atomicReference.set(DefaultSettingsJsonTransform.defaultSettings(currentTimeProvider));
    }

    public static SettingsController create(Context context, String str, IdManager idManager, HttpRequestFactory httpRequestFactory, String str2, String str3, FileStore fileStore, DataCollectionArbiter dataCollectionArbiter) {
        String installerPackageName = idManager.getInstallerPackageName();
        SystemCurrentTimeProvider systemCurrentTimeProvider = new SystemCurrentTimeProvider();
        return new SettingsController(context, new SettingsRequest(str, idManager.getModelName(), idManager.getOsBuildVersionString(), idManager.getOsDisplayVersionString(), idManager, CommonUtils.createInstanceIdFrom(CommonUtils.getMappingFileId(context), str, str3, str2), str3, str2, DeliveryMechanism.determineFrom(installerPackageName).getId()), systemCurrentTimeProvider, new SettingsJsonParser(systemCurrentTimeProvider), new CachedSettingsIo(fileStore), new DefaultSettingsSpiCall(String.format(Locale.US, SETTINGS_URL_FORMAT, str), httpRequestFactory), dataCollectionArbiter);
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsProvider
    public Task<Settings> getSettingsAsync() {
        return this.settingsTask.get().getTask();
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsProvider
    public Settings getSettingsSync() {
        return this.settings.get();
    }

    public Task<Void> loadSettingsData(CrashlyticsWorkers crashlyticsWorkers) {
        return loadSettingsData(SettingsCacheBehavior.USE_CACHE, crashlyticsWorkers);
    }

    public Task<Void> loadSettingsData(SettingsCacheBehavior settingsCacheBehavior, CrashlyticsWorkers crashlyticsWorkers) {
        Settings cachedSettingsData;
        if (!buildInstanceIdentifierChanged() && (cachedSettingsData = getCachedSettingsData(settingsCacheBehavior)) != null) {
            this.settings.set(cachedSettingsData);
            this.settingsTask.get().trySetResult(cachedSettingsData);
            return Tasks.forResult(null);
        }
        Settings cachedSettingsData2 = getCachedSettingsData(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
        if (cachedSettingsData2 != null) {
            this.settings.set(cachedSettingsData2);
            this.settingsTask.get().trySetResult(cachedSettingsData2);
        }
        return this.dataCollectionArbiter.waitForDataCollectionPermission().onSuccessTask(crashlyticsWorkers.common, new AnonymousClass1(crashlyticsWorkers));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.crashlytics.internal.settings.SettingsController$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass1 implements SuccessContinuation<Void, Void> {
        final /* synthetic */ CrashlyticsWorkers val$crashlyticsWorkers;

        AnonymousClass1(CrashlyticsWorkers crashlyticsWorkers) {
            this.val$crashlyticsWorkers = crashlyticsWorkers;
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        public Task<Void> then(Void r5) throws Exception {
            JSONObject jSONObject = (JSONObject) this.val$crashlyticsWorkers.network.getExecutor().submit(new Callable() { // from class: com.google.firebase.crashlytics.internal.settings.SettingsController$1$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return SettingsController.AnonymousClass1.this.m8248xd7ba6dd6();
                }
            }).get();
            if (jSONObject != null) {
                Settings parseSettingsJson = SettingsController.this.settingsJsonParser.parseSettingsJson(jSONObject);
                SettingsController.this.cachedSettingsIo.writeCachedSettings(parseSettingsJson.expiresAtMillis, jSONObject);
                SettingsController.this.logSettings(jSONObject, "Loaded settings: ");
                SettingsController settingsController = SettingsController.this;
                settingsController.setStoredBuildInstanceIdentifier(settingsController.settingsRequest.instanceId);
                SettingsController.this.settings.set(parseSettingsJson);
                ((TaskCompletionSource) SettingsController.this.settingsTask.get()).trySetResult(parseSettingsJson);
            }
            return Tasks.forResult(null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$then$0$com-google-firebase-crashlytics-internal-settings-SettingsController$1  reason: not valid java name */
        public /* synthetic */ JSONObject m8248xd7ba6dd6() throws Exception {
            return SettingsController.this.settingsSpiCall.invoke(SettingsController.this.settingsRequest, true);
        }
    }

    private Settings getCachedSettingsData(SettingsCacheBehavior settingsCacheBehavior) {
        Settings settings = null;
        try {
            if (!SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
                JSONObject readCachedSettings = this.cachedSettingsIo.readCachedSettings();
                if (readCachedSettings != null) {
                    Settings parseSettingsJson = this.settingsJsonParser.parseSettingsJson(readCachedSettings);
                    if (parseSettingsJson != null) {
                        logSettings(readCachedSettings, "Loaded cached settings: ");
                        long currentTimeMillis = this.currentTimeProvider.getCurrentTimeMillis();
                        if (!SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior) && parseSettingsJson.isExpired(currentTimeMillis)) {
                            Logger.getLogger().v("Cached settings have expired.");
                            return null;
                        }
                        try {
                            Logger.getLogger().v("Returning cached settings.");
                            return parseSettingsJson;
                        } catch (Exception e) {
                            e = e;
                            settings = parseSettingsJson;
                            Logger.getLogger().e("Failed to get cached settings", e);
                            return settings;
                        }
                    }
                    Logger.getLogger().e("Failed to parse cached settings data.", null);
                    return null;
                }
                Logger.getLogger().d("No cached settings data found.");
            }
            return null;
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logSettings(JSONObject jSONObject, String str) {
        Logger.getLogger().d(str + jSONObject.toString());
    }

    private String getStoredBuildInstanceIdentifier() {
        return CommonUtils.getSharedPrefs(this.context).getString(PREFS_BUILD_INSTANCE_IDENTIFIER, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean setStoredBuildInstanceIdentifier(String str) {
        SharedPreferences.Editor edit = CommonUtils.getSharedPrefs(this.context).edit();
        edit.putString(PREFS_BUILD_INSTANCE_IDENTIFIER, str);
        edit.apply();
        return true;
    }

    boolean buildInstanceIdentifierChanged() {
        return !getStoredBuildInstanceIdentifier().equals(this.settingsRequest.instanceId);
    }
}
