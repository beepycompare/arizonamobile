package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import io.appmetrica.analytics.coreapi.internal.model.AppVersionInfo;
import io.appmetrica.analytics.coreapi.internal.model.ScreenInfo;
import io.appmetrica.analytics.coreapi.internal.model.SdkEnvironment;
import io.appmetrica.analytics.coreapi.internal.model.SdkInfo;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.SdkEnvironmentProvider;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* loaded from: classes5.dex */
public final class Fj implements SdkEnvironmentProvider {

    /* renamed from: a  reason: collision with root package name */
    public final Context f550a;
    public final C0377kc b = new C0377kc();
    public final CopyOnWriteArrayList c = new CopyOnWriteArrayList();
    public SdkEnvironment d;
    public String e;

    public Fj(Context context) {
        this.f550a = context;
        this.d = new SdkEnvironment(new AppVersionInfo(PackageManagerUtils.getAppVersionName(context), PackageManagerUtils.getAppVersionCodeString(context)), FrameworkDetector.framework(), new ScreenInfo(0, 0, 0, 0.0f), new SdkInfo("8.2.0", "50163623", Gj.a()), "phone", C0377kc.a(context.getResources().getConfiguration()));
    }

    public final synchronized void a(ScreenInfo screenInfo) {
        float f;
        if (screenInfo != null) {
            if (!Intrinsics.areEqual(screenInfo, getSdkEnvironment().getScreenInfo())) {
                String str = this.e;
                if (str == null) {
                    Context context = this.f550a;
                    Point point = new Point(screenInfo.getWidth(), screenInfo.getHeight());
                    SafePackageManager safePackageManager = AbstractC0244f8.f976a;
                    try {
                        f = context.getResources().getDisplayMetrics().density;
                    } catch (Throwable unused) {
                        f = 0.0f;
                    }
                    if (!Float.isNaN(f) && f != 0.0f) {
                        int i = point.x;
                        int i2 = point.y;
                        if (AbstractC0244f8.a(context)) {
                            str = "tv";
                        } else {
                            float f2 = 160.0f * f;
                            float f3 = i;
                            float f4 = f3 / f2;
                            float f5 = i2;
                            float f6 = f5 / f2;
                            double sqrt = Math.sqrt((f6 * f6) + (f4 * f4));
                            float coerceAtMost = RangesKt.coerceAtMost(f3 / f, f5 / f);
                            if (sqrt < 7.0d && coerceAtMost < 600.0f) {
                                str = "phone";
                            }
                            str = "tablet";
                        }
                    }
                    str = "phone";
                }
                this.d = SdkEnvironment.copy$default(getSdkEnvironment(), null, null, screenInfo, null, str, null, 43, null);
                Iterator it = this.c.iterator();
                while (it.hasNext()) {
                    ((E5) ((Ej) it.next())).d();
                }
            }
        }
    }

    public final void b(Ej ej) {
        this.c.remove(ej);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.SdkEnvironmentProvider
    public final SdkEnvironment getSdkEnvironment() {
        SdkEnvironment sdkEnvironment = this.d;
        if (sdkEnvironment != null) {
            return sdkEnvironment;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sdkEnvironment");
        return null;
    }

    public final synchronized void a(String str) {
        if (str != null) {
            if (!Intrinsics.areEqual(str, this.e)) {
                this.e = str;
                if (!Intrinsics.areEqual(str, getSdkEnvironment().getDeviceType())) {
                    this.d = SdkEnvironment.copy$default(getSdkEnvironment(), null, null, null, null, str, null, 47, null);
                    Iterator it = this.c.iterator();
                    while (it.hasNext()) {
                        ((E5) ((Ej) it.next())).d();
                    }
                }
            }
        }
    }

    public final synchronized void a(String str, String str2) {
        if (str == null) {
            try {
                str = getSdkEnvironment().getAppVersionInfo().getAppVersionName();
            } finally {
            }
        }
        if (str2 == null) {
            str2 = getSdkEnvironment().getAppVersionInfo().getAppBuildNumber();
        }
        AppVersionInfo appVersionInfo = getSdkEnvironment().getAppVersionInfo();
        if (!Intrinsics.areEqual(appVersionInfo.getAppVersionName(), str) || !Intrinsics.areEqual(appVersionInfo.getAppBuildNumber(), str2)) {
            this.d = SdkEnvironment.copy$default(getSdkEnvironment(), new AppVersionInfo(str, str2), null, null, null, null, null, 62, null);
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ((E5) ((Ej) it.next())).d();
            }
        }
    }

    public final synchronized void a(Configuration configuration) {
        this.b.getClass();
        List a2 = C0377kc.a(configuration);
        if (!Intrinsics.areEqual(getSdkEnvironment().getLocales(), a2)) {
            this.d = SdkEnvironment.copy$default(getSdkEnvironment(), null, null, null, null, null, a2, 31, null);
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ((E5) ((Ej) it.next())).d();
            }
        }
    }

    public final void a(Ej ej) {
        this.c.add(ej);
    }
}
