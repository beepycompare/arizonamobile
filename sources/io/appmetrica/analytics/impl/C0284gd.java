package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionResolutionStrategy;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.cache.CachedDataProvider;
import io.appmetrica.analytics.coreutils.internal.permission.AlwaysAllowPermissionStrategy;
import io.appmetrica.analytics.coreutils.internal.permission.SinglePermissionStrategy;
import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.gd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0284gd implements InterfaceC0493on {

    /* renamed from: a  reason: collision with root package name */
    public final Context f866a;
    public final PermissionResolutionStrategy b;
    public final CellularNetworkTypeExtractor c;
    public final CachedDataProvider.CachedData d;

    public C0284gd(Context context) {
        PermissionResolutionStrategy alwaysAllowPermissionStrategy;
        this.f866a = context;
        if (AndroidUtils.isApiAchieved(29)) {
            alwaysAllowPermissionStrategy = new SinglePermissionStrategy(Ia.j().i(), "android.permission.READ_PHONE_STATE");
        } else {
            alwaysAllowPermissionStrategy = new AlwaysAllowPermissionStrategy();
        }
        this.b = alwaysAllowPermissionStrategy;
        this.c = new CellularNetworkTypeExtractor(context);
        long millis = TimeUnit.SECONDS.toMillis(20L);
        this.d = new CachedDataProvider.CachedData(millis, millis * 2, "mobile-connection");
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0493on
    /* renamed from: b */
    public final synchronized C0258fd a() {
        C0258fd c0258fd;
        String str;
        c0258fd = (C0258fd) this.d.getData();
        if (c0258fd == null || this.d.shouldUpdateData()) {
            if (this.b.hasNecessaryPermissions(this.f866a)) {
                str = this.c.getNetworkType();
            } else {
                str = "unknown";
            }
            c0258fd = new C0258fd(str);
            this.d.setData(c0258fd);
        }
        return c0258fd;
    }
}
