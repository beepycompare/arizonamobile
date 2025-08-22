package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* renamed from: io.appmetrica.analytics.impl.i6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0322i6 extends BaseRequestConfig.ComponentLoader {

    /* renamed from: a  reason: collision with root package name */
    public final SafePackageManager f901a;

    public AbstractC0322i6(Context context, String str) {
        this(context, str, new SafePackageManager());
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: a */
    public C0347j6 load(C0296h6 c0296h6) {
        C0347j6 c0347j6 = (C0347j6) super.load((AbstractC0322i6) c0296h6);
        String packageName = getContext().getPackageName();
        ApplicationInfo applicationInfo = this.f901a.getApplicationInfo(getContext(), getPackageName(), 0);
        if (applicationInfo != null) {
            int i = applicationInfo.flags;
            c0347j6.f919a = (i & 2) != 0 ? "1" : "0";
            c0347j6.b = (i & 1) == 0 ? "0" : "1";
        } else if (TextUtils.equals(packageName, getPackageName())) {
            c0347j6.f919a = (getContext().getApplicationInfo().flags & 2) != 0 ? "1" : "0";
            c0347j6.b = (getContext().getApplicationInfo().flags & 1) == 0 ? "0" : "1";
        } else {
            c0347j6.f919a = "0";
            c0347j6.b = "0";
        }
        C0389km c0389km = c0296h6.f882a;
        c0347j6.c = c0389km;
        c0347j6.setRetryPolicyConfig(c0389km.t);
        return c0347j6;
    }

    public AbstractC0322i6(Context context, String str, SafePackageManager safePackageManager) {
        super(context, str);
        this.f901a = safePackageManager;
    }
}
