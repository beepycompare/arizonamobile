package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
/* loaded from: classes5.dex */
public final class Ig {

    /* renamed from: a  reason: collision with root package name */
    public final SafePackageManager f596a;

    public Ig(SafePackageManager safePackageManager) {
        this.f596a = safePackageManager;
    }

    public final T9 a(Context context) {
        Hg ee;
        Na na = Na.I;
        IHandlerExecutor g = na.d.g();
        Zo zo = na.D().c;
        String installerPackageName = this.f596a.getInstallerPackageName(context, context.getPackageName());
        if (installerPackageName != null) {
            int hashCode = installerPackageName.hashCode();
            if (hashCode != -1637701853) {
                if (hashCode != -1046965711) {
                    if (hashCode == -356280397 && installerPackageName.equals("ru.vk.store")) {
                        ee = new C0384kj(context);
                    }
                } else if (installerPackageName.equals("com.android.vending")) {
                    ee = new Qa(context, g);
                }
            } else if (installerPackageName.equals("com.huawei.appmarket")) {
                ee = new C0144bb(context);
            }
            return new T9(new C0540qj(new C0705x3(ee, new fp(zo))), g);
        }
        ee = new Ee(installerPackageName);
        return new T9(new C0540qj(new C0705x3(ee, new fp(zo))), g);
    }

    public /* synthetic */ Ig() {
        this(new SafePackageManager());
    }
}
