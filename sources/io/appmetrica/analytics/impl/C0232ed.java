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
public final class C0232ed implements InterfaceC0416ln {

    /* renamed from: a  reason: collision with root package name */
    public final Context f821a;
    public final PermissionResolutionStrategy b;
    public final CellularNetworkTypeExtractor c;
    public final CachedDataProvider.CachedData d;

    public C0232ed(Context context) {
        PermissionResolutionStrategy alwaysAllowPermissionStrategy;
        this.f821a = context;
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

    @Override // io.appmetrica.analytics.impl.InterfaceC0416ln
    /* renamed from: b */
    public final synchronized C0207dd a() {
        C0207dd c0207dd;
        String str;
        c0207dd = (C0207dd) this.d.getData();
        if (c0207dd == null || this.d.shouldUpdateData()) {
            if (this.b.hasNecessaryPermissions(this.f821a)) {
                str = this.c.getNetworkType();
            } else {
                str = "unknown";
            }
            c0207dd = new C0207dd(str);
            this.d.setData(c0207dd);
        }
        return c0207dd;
    }
}
