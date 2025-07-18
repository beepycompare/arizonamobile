package com.google.firebase.crashlytics.internal.settings;

import com.adjust.sdk.Constants;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.Settings;
import kotlinx.datetime.internal.DateCalculationsKt;
import org.json.JSONObject;
/* loaded from: classes4.dex */
class DefaultSettingsJsonTransform implements SettingsJsonTransform {
    @Override // com.google.firebase.crashlytics.internal.settings.SettingsJsonTransform
    public Settings buildFromJson(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) {
        return defaultSettings(currentTimeProvider);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Settings defaultSettings(CurrentTimeProvider currentTimeProvider) {
        return new Settings(currentTimeProvider.getCurrentTimeMillis() + ((long) Constants.ONE_HOUR), new Settings.SessionData(8, 4), new Settings.FeatureFlagData(true, false, false), 0, DateCalculationsKt.SECONDS_PER_HOUR, 10.0d, 1.2d, 60);
    }
}
