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
public final class Mc implements InterfaceC0582sn {

    /* renamed from: a  reason: collision with root package name */
    public final Context f686a;
    public final PermissionResolutionStrategy b;
    public final CellularNetworkTypeExtractor c;
    public final CachedDataProvider.CachedData d;

    public Mc(Context context) {
        PermissionResolutionStrategy alwaysAllowPermissionStrategy;
        this.f686a = context;
        if (AndroidUtils.isApiAchieved(29)) {
            alwaysAllowPermissionStrategy = new SinglePermissionStrategy(C0470oa.k().j(), "android.permission.READ_PHONE_STATE");
        } else {
            alwaysAllowPermissionStrategy = new AlwaysAllowPermissionStrategy();
        }
        this.b = alwaysAllowPermissionStrategy;
        this.c = new CellularNetworkTypeExtractor(context);
        long millis = TimeUnit.SECONDS.toMillis(20L);
        this.d = new CachedDataProvider.CachedData(millis, millis * 2, "mobile-connection");
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0582sn
    /* renamed from: b */
    public final synchronized Lc a() {
        Lc lc;
        String str;
        lc = (Lc) this.d.getData();
        if (lc == null || this.d.shouldUpdateData()) {
            if (this.b.hasNecessaryPermissions(this.f686a)) {
                str = this.c.getNetworkType();
            } else {
                str = "unknown";
            }
            lc = new Lc(str);
            this.d.setData(lc);
        }
        return lc;
    }
}
