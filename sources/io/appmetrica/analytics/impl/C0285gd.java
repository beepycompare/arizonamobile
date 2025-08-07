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
public final class C0285gd implements InterfaceC0494on {

    /* renamed from: a  reason: collision with root package name */
    public final Context f865a;
    public final PermissionResolutionStrategy b;
    public final CellularNetworkTypeExtractor c;
    public final CachedDataProvider.CachedData d;

    public C0285gd(Context context) {
        PermissionResolutionStrategy alwaysAllowPermissionStrategy;
        this.f865a = context;
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

    @Override // io.appmetrica.analytics.impl.InterfaceC0494on
    /* renamed from: b */
    public final synchronized C0259fd a() {
        C0259fd c0259fd;
        String str;
        c0259fd = (C0259fd) this.d.getData();
        if (c0259fd == null || this.d.shouldUpdateData()) {
            if (this.b.hasNecessaryPermissions(this.f865a)) {
                str = this.c.getNetworkType();
            } else {
                str = "unknown";
            }
            c0259fd = new C0259fd(str);
            this.d.setData(c0259fd);
        }
        return c0259fd;
    }
}
