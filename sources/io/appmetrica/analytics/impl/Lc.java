package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionResolutionStrategy;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.cache.CachedDataProvider;
import io.appmetrica.analytics.coreutils.internal.permission.AlwaysAllowPermissionStrategy;
import io.appmetrica.analytics.coreutils.internal.permission.SinglePermissionStrategy;
import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class Lc implements InterfaceC0560rn {

    /* renamed from: a  reason: collision with root package name */
    public final Context f676a;
    public final PermissionResolutionStrategy b;
    public final CellularNetworkTypeExtractor c;
    public final CachedDataProvider.CachedData d;

    public Lc(Context context) {
        PermissionResolutionStrategy alwaysAllowPermissionStrategy;
        this.f676a = context;
        if (AndroidUtils.isApiAchieved(29)) {
            alwaysAllowPermissionStrategy = new SinglePermissionStrategy(C0448na.k().j(), "android.permission.READ_PHONE_STATE");
        } else {
            alwaysAllowPermissionStrategy = new AlwaysAllowPermissionStrategy();
        }
        this.b = alwaysAllowPermissionStrategy;
        this.c = new CellularNetworkTypeExtractor(context);
        long millis = TimeUnit.SECONDS.toMillis(20L);
        this.d = new CachedDataProvider.CachedData(millis, millis * 2, "mobile-connection");
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0560rn
    /* renamed from: b */
    public final synchronized Kc a() {
        Kc kc;
        String str;
        kc = (Kc) this.d.getData();
        if (kc == null || this.d.shouldUpdateData()) {
            if (this.b.hasNecessaryPermissions(this.f676a)) {
                str = this.c.getNetworkType();
            } else {
                str = "unknown";
            }
            kc = new Kc(str);
            this.d.setData(kc);
        }
        return kc;
    }
}
