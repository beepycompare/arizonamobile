package com.google.firebase.sessions.settings;

import android.os.Build;
import android.util.Log;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.ApplicationInfo;
import com.google.firebase.sessions.FirebaseSessions;
import com.google.firebase.sessions.InstallationId;
import com.google.firebase.sessions.TimeProvider;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
/* compiled from: RemoteSettings.kt */
@Singleton
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u0000 %2\u00020\u0001:\u0001%B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0011H\u0016J\u0010\u0010 \u001a\u00020\u001dH\u0081@¢\u0006\u0004\b!\u0010\u001eJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006&"}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettings;", "Lcom/google/firebase/sessions/settings/SettingsProvider;", "timeProvider", "Lcom/google/firebase/sessions/TimeProvider;", "firebaseInstallationsApi", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "appInfo", "Lcom/google/firebase/sessions/ApplicationInfo;", "configsFetcher", "Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;", "settingsCache", "Lcom/google/firebase/sessions/settings/SettingsCache;", "<init>", "(Lcom/google/firebase/sessions/TimeProvider;Lcom/google/firebase/installations/FirebaseInstallationsApi;Lcom/google/firebase/sessions/ApplicationInfo;Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;Lcom/google/firebase/sessions/settings/SettingsCache;)V", "fetchInProgress", "Lkotlinx/coroutines/sync/Mutex;", "sessionEnabled", "", "getSessionEnabled", "()Ljava/lang/Boolean;", "sessionRestartTimeout", "Lkotlin/time/Duration;", "getSessionRestartTimeout-FghU774", "()Lkotlin/time/Duration;", "samplingRate", "", "getSamplingRate", "()Ljava/lang/Double;", "updateSettings", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSettingsStale", "clearCachedSettings", "clearCachedSettings$com_google_firebase_firebase_sessions", "sanitize", "", CmcdData.STREAMING_FORMAT_SS, "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RemoteSettings implements SettingsProvider {
    private static final Companion Companion = new Companion(null);
    private static final int defaultCacheDuration;
    private static final Regex sanitizeRegex;
    private final ApplicationInfo appInfo;
    private final CrashlyticsSettingsFetcher configsFetcher;
    private final Mutex fetchInProgress;
    private final FirebaseInstallationsApi firebaseInstallationsApi;
    private final SettingsCache settingsCache;
    private final TimeProvider timeProvider;

    @Inject
    public RemoteSettings(TimeProvider timeProvider, FirebaseInstallationsApi firebaseInstallationsApi, ApplicationInfo appInfo, CrashlyticsSettingsFetcher configsFetcher, SettingsCache settingsCache) {
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        Intrinsics.checkNotNullParameter(firebaseInstallationsApi, "firebaseInstallationsApi");
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        Intrinsics.checkNotNullParameter(configsFetcher, "configsFetcher");
        Intrinsics.checkNotNullParameter(settingsCache, "settingsCache");
        this.timeProvider = timeProvider;
        this.firebaseInstallationsApi = firebaseInstallationsApi;
        this.appInfo = appInfo;
        this.configsFetcher = configsFetcher;
        this.settingsCache = settingsCache;
        this.fetchInProgress = MutexKt.Mutex$default(false, 1, null);
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Boolean getSessionEnabled() {
        return this.settingsCache.sessionsEnabled();
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    /* renamed from: getSessionRestartTimeout-FghU774 */
    public Duration mo9707getSessionRestartTimeoutFghU774() {
        Integer sessionRestartTimeout = this.settingsCache.sessionRestartTimeout();
        if (sessionRestartTimeout != null) {
            Duration.Companion companion = Duration.Companion;
            return Duration.m11197boximpl(DurationKt.toDuration(sessionRestartTimeout.intValue(), DurationUnit.SECONDS));
        }
        return null;
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Double getSamplingRate() {
        return this.settingsCache.sessionSamplingRate();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x007b, code lost:
        if (r13.lock(null, r0) == r1) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0087 A[Catch: all -> 0x014a, TRY_LEAVE, TryCatch #1 {all -> 0x014a, blocks: (B:43:0x00a2, B:45:0x00b0, B:49:0x00bc, B:35:0x007f, B:37:0x0087, B:40:0x0092), top: B:62:0x007f }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0092 A[Catch: all -> 0x014a, TRY_ENTER, TryCatch #1 {all -> 0x014a, blocks: (B:43:0x00a2, B:45:0x00b0, B:49:0x00bc, B:35:0x007f, B:37:0x0087, B:40:0x0092), top: B:62:0x007f }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b0 A[Catch: all -> 0x014a, TRY_LEAVE, TryCatch #1 {all -> 0x014a, blocks: (B:43:0x00a2, B:45:0x00b0, B:49:0x00bc, B:35:0x007f, B:37:0x0087, B:40:0x0092), top: B:62:0x007f }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00bb  */
    @Override // com.google.firebase.sessions.settings.SettingsProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object updateSettings(Continuation<? super Unit> continuation) {
        RemoteSettings$updateSettings$1 remoteSettings$updateSettings$1;
        int i;
        Mutex mutex;
        Throwable th;
        Mutex mutex2;
        Object create;
        String fid;
        try {
            if (continuation instanceof RemoteSettings$updateSettings$1) {
                remoteSettings$updateSettings$1 = (RemoteSettings$updateSettings$1) continuation;
                if ((remoteSettings$updateSettings$1.label & Integer.MIN_VALUE) != 0) {
                    remoteSettings$updateSettings$1.label -= Integer.MIN_VALUE;
                    Object obj = remoteSettings$updateSettings$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = remoteSettings$updateSettings$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (!this.fetchInProgress.isLocked() && !this.settingsCache.hasCacheExpired()) {
                            return Unit.INSTANCE;
                        }
                        mutex = this.fetchInProgress;
                        remoteSettings$updateSettings$1.L$0 = mutex;
                        remoteSettings$updateSettings$1.label = 1;
                    } else if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                                mutex2 = (Mutex) remoteSettings$updateSettings$1.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    Unit unit = Unit.INSTANCE;
                                    mutex2.unlock(null);
                                    return Unit.INSTANCE;
                                } catch (Throwable th2) {
                                    th = th2;
                                    mutex2.unlock(null);
                                    throw th;
                                }
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Mutex mutex3 = (Mutex) remoteSettings$updateSettings$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            create = obj;
                            mutex = mutex3;
                            fid = ((InstallationId) create).getFid();
                            if (!Intrinsics.areEqual(fid, "")) {
                                Log.w(FirebaseSessions.TAG, "Error getting Firebase Installation ID. Skipping this Session Event.");
                                Unit unit2 = Unit.INSTANCE;
                                mutex.unlock(null);
                                return unit2;
                            }
                            String INCREMENTAL = Build.VERSION.INCREMENTAL;
                            Intrinsics.checkNotNullExpressionValue(INCREMENTAL, "INCREMENTAL");
                            String RELEASE = Build.VERSION.RELEASE;
                            Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
                            Map<String, String> mapOf = MapsKt.mapOf(TuplesKt.to("X-Crashlytics-Installation-ID", fid), TuplesKt.to("X-Crashlytics-Device-Model", sanitize(Build.MANUFACTURER + Build.MODEL)), TuplesKt.to("X-Crashlytics-OS-Build-Version", sanitize(INCREMENTAL)), TuplesKt.to("X-Crashlytics-OS-Display-Version", sanitize(RELEASE)), TuplesKt.to("X-Crashlytics-API-Client-Version", this.appInfo.getSessionSdkVersion()));
                            Log.d(FirebaseSessions.TAG, "Fetching settings from server.");
                            remoteSettings$updateSettings$1.L$0 = mutex;
                            remoteSettings$updateSettings$1.label = 3;
                            if (this.configsFetcher.doConfigFetch(mapOf, new RemoteSettings$updateSettings$2$1(this, null), new RemoteSettings$updateSettings$2$2(null), remoteSettings$updateSettings$1) != coroutine_suspended) {
                                mutex2 = mutex;
                                Unit unit3 = Unit.INSTANCE;
                                mutex2.unlock(null);
                                return Unit.INSTANCE;
                            }
                            return coroutine_suspended;
                        } catch (Throwable th3) {
                            th = th3;
                            mutex2 = mutex3;
                            mutex2.unlock(null);
                            throw th;
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        mutex = (Mutex) remoteSettings$updateSettings$1.L$0;
                    }
                    if (this.settingsCache.hasCacheExpired()) {
                        Log.d(FirebaseSessions.TAG, "Remote settings cache not expired. Using cached values.");
                        Unit unit4 = Unit.INSTANCE;
                        mutex.unlock(null);
                        return unit4;
                    }
                    InstallationId.Companion companion = InstallationId.Companion;
                    FirebaseInstallationsApi firebaseInstallationsApi = this.firebaseInstallationsApi;
                    remoteSettings$updateSettings$1.L$0 = mutex;
                    remoteSettings$updateSettings$1.label = 2;
                    create = companion.create(firebaseInstallationsApi, remoteSettings$updateSettings$1);
                    if (create == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    fid = ((InstallationId) create).getFid();
                    if (!Intrinsics.areEqual(fid, "")) {
                    }
                }
            }
            if (this.settingsCache.hasCacheExpired()) {
            }
        } catch (Throwable th4) {
            Mutex mutex4 = mutex;
            th = th4;
            mutex2 = mutex4;
            mutex2.unlock(null);
            throw th;
        }
        remoteSettings$updateSettings$1 = new RemoteSettings$updateSettings$1(this, continuation);
        Object obj2 = remoteSettings$updateSettings$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = remoteSettings$updateSettings$1.label;
        if (i != 0) {
        }
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public boolean isSettingsStale() {
        return this.settingsCache.hasCacheExpired();
    }

    public final Object clearCachedSettings$com_google_firebase_firebase_sessions(Continuation<? super Unit> continuation) {
        Object updateConfigs = this.settingsCache.updateConfigs(SessionConfigsSerializer.INSTANCE.getDefaultValue(), continuation);
        return updateConfigs == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateConfigs : Unit.INSTANCE;
    }

    private final String sanitize(String str) {
        return sanitizeRegex.replace(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RemoteSettings.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettings$Companion;", "", "<init>", "()V", "defaultCacheDuration", "", "getDefaultCacheDuration", "()I", "sanitizeRegex", "Lkotlin/text/Regex;", "getSanitizeRegex", "()Lkotlin/text/Regex;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getDefaultCacheDuration() {
            return RemoteSettings.defaultCacheDuration;
        }

        public final Regex getSanitizeRegex() {
            return RemoteSettings.sanitizeRegex;
        }
    }

    static {
        Duration.Companion companion = Duration.Companion;
        defaultCacheDuration = (int) Duration.m11213getInWholeSecondsimpl(DurationKt.toDuration(24, DurationUnit.HOURS));
        sanitizeRegex = new Regex("com/google/firebase/sessions//");
    }
}
