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
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\n"}, d2 = {"Lio/appmetrica/analytics/impl/v2;", "", "Landroid/content/Context;", "context", "Lio/appmetrica/analytics/impl/d2;", "converter", "Lio/appmetrica/analytics/impl/y2;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "analytics_binaryProdRelease"}, k = 1, mv = {1, 6, 0})
/* renamed from: io.appmetrica.analytics.impl.v2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0636v2 {

    /* renamed from: a  reason: collision with root package name */
    public static final C0636v2 f1256a = new C0636v2();

    private C0636v2() {
    }

    @JvmStatic
    public static final C0711y2 a(Context context, final C0181d2 c0181d2) {
        return new C0711y2((EnumC0686x2) SystemServiceUtils.accessSystemServiceByNameSafely(context, "usagestats", "getting app standby bucket", "usageStatsManager", new FunctionWithThrowable() { // from class: io.appmetrica.analytics.impl.v2$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
            public final Object apply(Object obj) {
                EnumC0686x2 a2;
                a2 = C0636v2.a(C0181d2.this, (UsageStatsManager) obj);
                return a2;
            }
        }), (Boolean) SystemServiceUtils.accessSystemServiceByNameSafely(context, "activity", "getting is background restricted", "activityManager", new FunctionWithThrowable() { // from class: io.appmetrica.analytics.impl.v2$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
            public final Object apply(Object obj) {
                Boolean a2;
                a2 = C0636v2.a((ActivityManager) obj);
                return a2;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnumC0686x2 a(C0181d2 c0181d2, UsageStatsManager usageStatsManager) {
        int appStandbyBucket = usageStatsManager.getAppStandbyBucket();
        c0181d2.getClass();
        if (AndroidUtils.isApiAchieved(28)) {
            if (AndroidUtils.isApiAchieved(30) && appStandbyBucket == 45) {
                return EnumC0686x2.RESTRICTED;
            }
            if (appStandbyBucket == 5) {
                return EnumC0686x2.EXEMPTED;
            }
            if (appStandbyBucket == 10) {
                return EnumC0686x2.ACTIVE;
            }
            if (appStandbyBucket == 30) {
                return EnumC0686x2.FREQUENT;
            }
            if (appStandbyBucket == 20) {
                return EnumC0686x2.WORKING_SET;
            }
            if (appStandbyBucket == 40) {
                return EnumC0686x2.RARE;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean a(ActivityManager activityManager) {
        return Boolean.valueOf(activityManager.isBackgroundRestricted());
    }
}
