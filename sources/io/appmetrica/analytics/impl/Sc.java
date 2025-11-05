package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionResolutionStrategy;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.cache.CachedDataProvider;
import io.appmetrica.analytics.coreutils.internal.permission.AlwaysAllowPermissionStrategy;
import io.appmetrica.analytics.coreutils.internal.permission.SinglePermissionStrategy;
import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class Sc implements InterfaceC0608tn {

    /* renamed from: a  reason: collision with root package name */
    public final Context f682a;
    public final PermissionResolutionStrategy b;
    public final CellularNetworkTypeExtractor c;
    public final CachedDataProvider.CachedData d;

    public Sc(Context context) {
        PermissionResolutionStrategy alwaysAllowPermissionStrategy;
        this.f682a = context;
        if (AndroidUtils.isApiAchieved(29)) {
            alwaysAllowPermissionStrategy = new SinglePermissionStrategy(C0620ua.k().j(), "android.permission.READ_PHONE_STATE");
        } else {
            alwaysAllowPermissionStrategy = new AlwaysAllowPermissionStrategy();
        }
        this.b = alwaysAllowPermissionStrategy;
        this.c = new CellularNetworkTypeExtractor(context);
        long millis = TimeUnit.SECONDS.toMillis(20L);
        this.d = new CachedDataProvider.CachedData(millis, millis * 2, "mobile-connection");
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0608tn
    /* renamed from: b */
    public final synchronized Rc a() {
        Rc rc;
        String str;
        rc = (Rc) this.d.getData();
        if (rc == null || this.d.shouldUpdateData()) {
            if (this.b.hasNecessaryPermissions(this.f682a)) {
                str = this.c.getNetworkType();
            } else {
                str = "unknown";
            }
            rc = new Rc(str);
            this.d.setData(rc);
        }
        return rc;
    }
}
