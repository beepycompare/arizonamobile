package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
/* renamed from: io.appmetrica.analytics.impl.i6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0328i6 extends BaseRequestConfig.ComponentLoader {

    /* renamed from: a  reason: collision with root package name */
    public final SafePackageManager f896a;

    public AbstractC0328i6(Context context, String str) {
        this(context, str, new SafePackageManager());
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: a */
    public C0352j6 load(C0303h6 c0303h6) {
        C0352j6 c0352j6 = (C0352j6) super.load((AbstractC0328i6) c0303h6);
        String packageName = getContext().getPackageName();
        ApplicationInfo applicationInfo = this.f896a.getApplicationInfo(getContext(), getPackageName(), 0);
        if (applicationInfo != null) {
            int i = applicationInfo.flags;
            c0352j6.f914a = (i & 2) != 0 ? "1" : "0";
            c0352j6.b = (i & 1) == 0 ? "0" : "1";
        } else if (TextUtils.equals(packageName, getPackageName())) {
            c0352j6.f914a = (getContext().getApplicationInfo().flags & 2) != 0 ? "1" : "0";
            c0352j6.b = (getContext().getApplicationInfo().flags & 1) == 0 ? "0" : "1";
        } else {
            c0352j6.f914a = "0";
            c0352j6.b = "0";
        }
        C0268fm c0268fm = c0303h6.f878a;
        c0352j6.c = c0268fm;
        c0352j6.setRetryPolicyConfig(c0268fm.t);
        return c0352j6;
    }

    public AbstractC0328i6(Context context, String str, SafePackageManager safePackageManager) {
        super(context, str);
        this.f896a = safePackageManager;
    }
}
