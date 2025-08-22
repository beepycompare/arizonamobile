package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionResolutionStrategy;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.cache.CachedDataProvider;
import io.appmetrica.analytics.coreutils.internal.permission.AlwaysAllowPermissionStrategy;
import io.appmetrica.analytics.coreutils.internal.permission.SinglePermissionStrategy;
import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.id  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0329id implements InterfaceC0615tn {

    /* renamed from: a  reason: collision with root package name */
    public final Context f906a;
    public final PermissionResolutionStrategy b;
    public final CellularNetworkTypeExtractor c;
    public final CachedDataProvider.CachedData d;

    public C0329id(Context context) {
        PermissionResolutionStrategy alwaysAllowPermissionStrategy;
        this.f906a = context;
        if (AndroidUtils.isApiAchieved(29)) {
            alwaysAllowPermissionStrategy = new SinglePermissionStrategy(Ka.j().i(), "android.permission.READ_PHONE_STATE");
        } else {
            alwaysAllowPermissionStrategy = new AlwaysAllowPermissionStrategy();
        }
        this.b = alwaysAllowPermissionStrategy;
        this.c = new CellularNetworkTypeExtractor(context);
        long millis = TimeUnit.SECONDS.toMillis(20L);
        this.d = new CachedDataProvider.CachedData(millis, millis * 2, "mobile-connection");
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0615tn
    /* renamed from: b */
    public final synchronized C0303hd a() {
        C0303hd c0303hd;
        String str;
        c0303hd = (C0303hd) this.d.getData();
        if (c0303hd == null || this.d.shouldUpdateData()) {
            if (this.b.hasNecessaryPermissions(this.f906a)) {
                str = this.c.getNetworkType();
            } else {
                str = "unknown";
            }
            c0303hd = new C0303hd(str);
            this.d.setData(c0303hd);
        }
        return c0303hd;
    }
}
