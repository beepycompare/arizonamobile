package com.arizona.launcher;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UpdateAnalyticsReporter.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0014"}, d2 = {"Lcom/arizona/launcher/AndroidUpdateFirstLaunchStore;", "Lcom/arizona/launcher/UpdateFirstLaunchStore;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "preferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "isFirstStart", "", "isErrorSessionActive", "reportedErrorCodes", "", "", "saveReportedErrorCodes", "", "codes", "finishErrorSession", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AndroidUpdateFirstLaunchStore implements UpdateFirstLaunchStore {
    @Deprecated
    public static final String FIRST_START_ERROR_SESSION_KEY = "firstStartErrorSession";
    @Deprecated
    public static final String FIRST_START_KEY = "firstStart";
    @Deprecated
    public static final String FIRST_START_REPORTED_ERROR_CODES_KEY = "firstStartReportedErrorCodes";
    @Deprecated
    public static final String PREFERENCES_NAME = "SP_NAME";
    private final SharedPreferences preferences;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public AndroidUpdateFirstLaunchStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.preferences = context.getSharedPreferences("SP_NAME", 0);
    }

    @Override // com.arizona.launcher.UpdateFirstLaunchStore
    public boolean isFirstStart() {
        return this.preferences.getBoolean("firstStart", true);
    }

    @Override // com.arizona.launcher.UpdateFirstLaunchStore
    public boolean isErrorSessionActive() {
        return this.preferences.getBoolean("firstStartErrorSession", false);
    }

    @Override // com.arizona.launcher.UpdateFirstLaunchStore
    public Set<String> reportedErrorCodes() {
        Set<String> stringSet = this.preferences.getStringSet(FIRST_START_REPORTED_ERROR_CODES_KEY, SetsKt.emptySet());
        if (stringSet == null) {
            stringSet = SetsKt.emptySet();
        }
        return CollectionsKt.toSet(stringSet);
    }

    @Override // com.arizona.launcher.UpdateFirstLaunchStore
    public void saveReportedErrorCodes(Set<String> codes) {
        Intrinsics.checkNotNullParameter(codes, "codes");
        this.preferences.edit().putStringSet(FIRST_START_REPORTED_ERROR_CODES_KEY, codes).apply();
    }

    @Override // com.arizona.launcher.UpdateFirstLaunchStore
    public void finishErrorSession() {
        this.preferences.edit().putBoolean("firstStart", false).putBoolean("firstStartErrorSession", false).remove(FIRST_START_REPORTED_ERROR_CODES_KEY).apply();
    }

    /* compiled from: UpdateAnalyticsReporter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/arizona/launcher/AndroidUpdateFirstLaunchStore$Companion;", "", "<init>", "()V", "PREFERENCES_NAME", "", "FIRST_START_KEY", "FIRST_START_ERROR_SESSION_KEY", "FIRST_START_REPORTED_ERROR_CODES_KEY", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
