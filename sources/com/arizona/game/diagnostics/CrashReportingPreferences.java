package com.arizona.game.diagnostics;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CrashReportingPreferences.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/game/diagnostics/CrashReportingPreferences;", "", "<init>", "()V", "FILE", "", "COLLECTION", "isPersistedDisabled", "", "context", "Landroid/content/Context;", "flushDisabledOverride", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CrashReportingPreferences {
    public static final int $stable = 0;
    private static final String COLLECTION = "firebase_crashlytics_collection_enabled";
    private static final String FILE = "com.google.firebase.crashlytics";
    public static final CrashReportingPreferences INSTANCE = new CrashReportingPreferences();

    private CrashReportingPreferences() {
    }

    public final boolean isPersistedDisabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.crashlytics", 0);
        return sharedPreferences.contains(COLLECTION) && !sharedPreferences.getBoolean(COLLECTION, true);
    }

    public final boolean flushDisabledOverride(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (isPersistedDisabled(context)) {
            return context.getSharedPreferences("com.google.firebase.crashlytics", 0).edit().putBoolean(COLLECTION, false).commit();
        }
        return false;
    }
}
