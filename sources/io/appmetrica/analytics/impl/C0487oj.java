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
/* renamed from: io.appmetrica.analytics.impl.oj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0487oj implements SdkEnvironmentProvider {

    /* renamed from: a  reason: collision with root package name */
    public final Context f977a;
    public final C0154bc b = new C0154bc();
    public final CopyOnWriteArrayList c = new CopyOnWriteArrayList();
    public SdkEnvironment d;
    public String e;

    public C0487oj(Context context) {
        this.f977a = context;
        this.d = new SdkEnvironment(new AppVersionInfo(PackageManagerUtils.getAppVersionName(context), PackageManagerUtils.getAppVersionCodeString(context)), FrameworkDetector.framework(), new ScreenInfo(0, 0, 0, 0.0f), new SdkInfo("7.9.0", "50132373", AbstractC0512pj.a()), "phone", C0154bc.a(context.getResources().getConfiguration()));
    }

    public final synchronized void a(ScreenInfo screenInfo) {
        float f;
        if (screenInfo != null) {
            if (!Intrinsics.areEqual(screenInfo, getSdkEnvironment().getScreenInfo())) {
                String str = this.e;
                if (str == null) {
                    Context context = this.f977a;
                    Point point = new Point(screenInfo.getWidth(), screenInfo.getHeight());
                    SafePackageManager safePackageManager = Se.f626a;
                    try {
                        f = context.getResources().getDisplayMetrics().density;
                    } catch (Throwable unused) {
                        f = 0.0f;
                    }
                    if (f == 0.0f) {
                        str = "phone";
                    } else {
                        float f2 = point.x;
                        float f3 = point.y;
                        float min = Math.min(f2 / f, f3 / f);
                        float f4 = f * 160.0f;
                        float f5 = f2 / f4;
                        float f6 = f3 / f4;
                        double sqrt = Math.sqrt((f6 * f6) + (f5 * f5));
                        if (sqrt >= 15.0d && !Se.f626a.hasSystemFeature(context, "android.hardware.touchscreen")) {
                            str = "tv";
                        } else {
                            if (sqrt < 7.0d && min < 600.0f) {
                                str = "phone";
                            }
                            str = "tablet";
                        }
                    }
                }
                this.d = SdkEnvironment.copy$default(getSdkEnvironment(), null, null, screenInfo, null, str, null, 43, null);
                Iterator it = this.c.iterator();
                while (it.hasNext()) {
                    ((H5) ((InterfaceC0462nj) it.next())).d();
                }
            }
        }
    }

    public final void b(InterfaceC0462nj interfaceC0462nj) {
        this.c.remove(interfaceC0462nj);
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
                        ((H5) ((InterfaceC0462nj) it.next())).d();
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
                ((H5) ((InterfaceC0462nj) it.next())).d();
            }
        }
    }

    public final synchronized void a(Configuration configuration) {
        this.b.getClass();
        List a2 = C0154bc.a(configuration);
        if (!Intrinsics.areEqual(getSdkEnvironment().getLocales(), a2)) {
            this.d = SdkEnvironment.copy$default(getSdkEnvironment(), null, null, null, null, null, a2, 31, null);
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ((H5) ((InterfaceC0462nj) it.next())).d();
            }
        }
    }

    public final void a(InterfaceC0462nj interfaceC0462nj) {
        this.c.add(interfaceC0462nj);
    }
}
