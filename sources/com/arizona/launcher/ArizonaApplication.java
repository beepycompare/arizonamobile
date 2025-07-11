package com.arizona.launcher;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.LogLevel;
import com.arizona.launcher.util.FlavorUtilKt;
import com.google.firebase.FirebaseApp;
import com.google.firebase.ktx.Firebase;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.ktx.RemoteConfigKt;
import com.miami.game.core.connection.resolver.R;
import dagger.hilt.android.HiltAndroidApp;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.AppMetricaConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;
/* compiled from: ArizonaApplication.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\u0007"}, d2 = {"Lcom/arizona/launcher/ArizonaApplication;", "Landroid/app/Application;", "<init>", "()V", "onCreate", "", "adjustInitialize", "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
@HiltAndroidApp
/* loaded from: classes3.dex */
public final class ArizonaApplication extends Hilt_ArizonaApplication {
    public static final int $stable = 8;

    @Override // com.arizona.launcher.Hilt_ArizonaApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
        ArizonaApplication arizonaApplication = this;
        FirebaseApp.initializeApp(arizonaApplication);
        String str = FlavorUtilKt.isArizona() ? ArizonaApplicationKt.ARIZONA_API_KEY : ArizonaApplicationKt.RODINA_API_KEY;
        FirebaseRemoteConfig remoteConfig = RemoteConfigKt.getRemoteConfig(Firebase.INSTANCE);
        remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults);
        remoteConfig.fetchAndActivate();
        AppMetricaConfig build = AppMetricaConfig.newConfigBuilder(str).withLocationTracking(true).withCrashReporting(false).withNativeCrashReporting(false).withLogs().build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        AppMetrica.activate(arizonaApplication, build);
        Timber.Forest.plant(new Timber.DebugTree());
        adjustInitialize();
    }

    private final void adjustInitialize() {
        AdjustConfig adjustConfig = new AdjustConfig(this, FlavorUtilKt.isArizona() ? ArizonaApplicationKt.ADJUST_ARIZONA_API_KEY : ArizonaApplicationKt.ADJUST_RODINA_API_KEY, AdjustConfig.ENVIRONMENT_PRODUCTION);
        adjustConfig.setLogLevel(LogLevel.VERBOSE);
        Adjust.initSdk(adjustConfig);
    }
}
