package io.appmetrica.analytics.impl;

import android.app.ActivityManager;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import androidx.media3.exoplayer.upstream.CmcdData;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\n"}, d2 = {"Lio/appmetrica/analytics/impl/C2;", "", "Landroid/content/Context;", "context", "Lio/appmetrica/analytics/impl/l2;", "converter", "Lio/appmetrica/analytics/impl/F2;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "analytics_binaryProdRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class C2 {

    /* renamed from: a  reason: collision with root package name */
    public static final C2 f419a = new C2();

    private C2() {
    }

    @JvmStatic
    public static final F2 a(Context context, final C0388l2 c0388l2) {
        return new F2((E2) SystemServiceUtils.accessSystemServiceByNameSafely(context, "usagestats", "getting app standby bucket", "usageStatsManager", new FunctionWithThrowable() { // from class: io.appmetrica.analytics.impl.C2$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
            public final Object apply(Object obj) {
                E2 a2;
                a2 = C2.a(C0388l2.this, (UsageStatsManager) obj);
                return a2;
            }
        }), (Boolean) SystemServiceUtils.accessSystemServiceByNameSafely(context, "activity", "getting is background restricted", "activityManager", new FunctionWithThrowable() { // from class: io.appmetrica.analytics.impl.C2$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
            public final Object apply(Object obj) {
                Boolean a2;
                a2 = C2.a((ActivityManager) obj);
                return a2;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final E2 a(C0388l2 c0388l2, UsageStatsManager usageStatsManager) {
        int appStandbyBucket = usageStatsManager.getAppStandbyBucket();
        c0388l2.getClass();
        if (AndroidUtils.isApiAchieved(28)) {
            if (AndroidUtils.isApiAchieved(30) && appStandbyBucket == 45) {
                return E2.RESTRICTED;
            }
            if (appStandbyBucket == 5) {
                return E2.EXEMPTED;
            }
            if (appStandbyBucket == 10) {
                return E2.ACTIVE;
            }
            if (appStandbyBucket == 30) {
                return E2.FREQUENT;
            }
            if (appStandbyBucket == 20) {
                return E2.WORKING_SET;
            }
            if (appStandbyBucket == 40) {
                return E2.RARE;
            }
            return E2.UNKNOWN;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean a(ActivityManager activityManager) {
        return Boolean.valueOf(activityManager.isBackgroundRestricted());
    }
}
