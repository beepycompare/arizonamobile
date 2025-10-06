package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionResolutionStrategy;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.cache.CachedDataProvider;
import io.appmetrica.analytics.coreutils.internal.permission.AlwaysAllowPermissionStrategy;
import io.appmetrica.analytics.coreutils.internal.permission.SinglePermissionStrategy;
import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.ld  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0407ld implements InterfaceC0720xn {

    /* renamed from: a  reason: collision with root package name */
    public final Context f971a;
    public final PermissionResolutionStrategy b;
    public final CellularNetworkTypeExtractor c;
    public final CachedDataProvider.CachedData d;

    public C0407ld(Context context) {
        PermissionResolutionStrategy alwaysAllowPermissionStrategy;
        this.f971a = context;
        if (AndroidUtils.isApiAchieved(29)) {
            alwaysAllowPermissionStrategy = new SinglePermissionStrategy(Na.j().i(), "android.permission.READ_PHONE_STATE");
        } else {
            alwaysAllowPermissionStrategy = new AlwaysAllowPermissionStrategy();
        }
        this.b = alwaysAllowPermissionStrategy;
        this.c = new CellularNetworkTypeExtractor(context);
        long millis = TimeUnit.SECONDS.toMillis(20L);
        this.d = new CachedDataProvider.CachedData(millis, millis * 2, "mobile-connection");
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0720xn
    /* renamed from: b */
    public final synchronized C0381kd a() {
        C0381kd c0381kd;
        String str;
        c0381kd = (C0381kd) this.d.getData();
        if (c0381kd == null || this.d.shouldUpdateData()) {
            if (this.b.hasNecessaryPermissions(this.f971a)) {
                str = this.c.getNetworkType();
            } else {
                str = "unknown";
            }
            c0381kd = new C0381kd(str);
            this.d.setData(c0381kd);
        }
        return c0381kd;
    }
}
