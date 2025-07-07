package io.appmetrica.analytics.ndkcrashesapi.internal;

import android.content.Context;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.List;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&¨\u0006\u0013"}, d2 = {"Lio/appmetrica/analytics/ndkcrashesapi/internal/NativeCrashServiceModule;", "", "()V", "deleteCompletedCrashes", "", "getAllCrashes", "", "Lio/appmetrica/analytics/ndkcrashesapi/internal/NativeCrash;", "init", "context", "Landroid/content/Context;", "config", "Lio/appmetrica/analytics/ndkcrashesapi/internal/NativeCrashServiceConfig;", "markCrashCompleted", CommonUrlParts.UUID, "", "setDefaultCrashHandler", "handler", "Lio/appmetrica/analytics/ndkcrashesapi/internal/NativeCrashHandler;", "ndkcrashes-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class NativeCrashServiceModule {
    public abstract void deleteCompletedCrashes();

    public abstract List<NativeCrash> getAllCrashes();

    public abstract void init(Context context, NativeCrashServiceConfig nativeCrashServiceConfig);

    public abstract void markCrashCompleted(String str);

    public abstract void setDefaultCrashHandler(NativeCrashHandler nativeCrashHandler);
}
