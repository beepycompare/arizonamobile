package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionResolutionStrategy;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.cache.CachedDataProvider;
import io.appmetrica.analytics.coreutils.internal.permission.AlwaysAllowPermissionStrategy;
import io.appmetrica.analytics.coreutils.internal.permission.SinglePermissionStrategy;
import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.ed  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0240ed implements InterfaceC0424ln {

    /* renamed from: a  reason: collision with root package name */
    public final Context f820a;
    public final PermissionResolutionStrategy b;
    public final CellularNetworkTypeExtractor c;
    public final CachedDataProvider.CachedData d;

    public C0240ed(Context context) {
        PermissionResolutionStrategy alwaysAllowPermissionStrategy;
        this.f820a = context;
        if (AndroidUtils.isApiAchieved(29)) {
            alwaysAllowPermissionStrategy = new SinglePermissionStrategy(Ga.j().i(), "android.permission.READ_PHONE_STATE");
        } else {
            alwaysAllowPermissionStrategy = new AlwaysAllowPermissionStrategy();
        }
        this.b = alwaysAllowPermissionStrategy;
        this.c = new CellularNetworkTypeExtractor(context);
        long millis = TimeUnit.SECONDS.toMillis(20L);
        this.d = new CachedDataProvider.CachedData(millis, millis * 2, "mobile-connection");
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0424ln
    /* renamed from: b */
    public final synchronized C0215dd a() {
        C0215dd c0215dd;
        String str;
        c0215dd = (C0215dd) this.d.getData();
        if (c0215dd == null || this.d.shouldUpdateData()) {
            if (this.b.hasNecessaryPermissions(this.f820a)) {
                str = this.c.getNetworkType();
            } else {
                str = "unknown";
            }
            c0215dd = new C0215dd(str);
            this.d.setData(c0215dd);
        }
        return c0215dd;
    }
}
