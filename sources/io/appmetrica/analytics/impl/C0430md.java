package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionResolutionStrategy;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.cache.CachedDataProvider;
import io.appmetrica.analytics.coreutils.internal.permission.AlwaysAllowPermissionStrategy;
import io.appmetrica.analytics.coreutils.internal.permission.SinglePermissionStrategy;
import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.md  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0430md implements Sn {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1094a;
    public final PermissionResolutionStrategy b;
    public final CellularNetworkTypeExtractor c;
    public final CachedDataProvider.CachedData d;

    public C0430md(Context context) {
        PermissionResolutionStrategy alwaysAllowPermissionStrategy;
        this.f1094a = context;
        if (AndroidUtils.isApiAchieved(29)) {
            alwaysAllowPermissionStrategy = new SinglePermissionStrategy(Na.k().j(), "android.permission.READ_PHONE_STATE");
        } else {
            alwaysAllowPermissionStrategy = new AlwaysAllowPermissionStrategy();
        }
        this.b = alwaysAllowPermissionStrategy;
        this.c = new CellularNetworkTypeExtractor(context);
        long millis = TimeUnit.SECONDS.toMillis(20L);
        this.d = new CachedDataProvider.CachedData(millis, millis * 2, "mobile-connection");
    }

    @Override // io.appmetrica.analytics.impl.Sn
    /* renamed from: b */
    public final synchronized C0404ld a() {
        C0404ld c0404ld;
        String str;
        c0404ld = (C0404ld) this.d.getData();
        if (c0404ld == null || this.d.shouldUpdateData()) {
            if (this.b.hasNecessaryPermissions(this.f1094a)) {
                str = this.c.getNetworkType();
            } else {
                str = "unknown";
            }
            c0404ld = new C0404ld(str);
            this.d.setData(c0404ld);
        }
        return c0404ld;
    }
}
