package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.cache.CachedDataProvider;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.ol  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0481ol implements InterfaceC0582sn {
    public static final long d = TimeUnit.SECONDS.toMillis(20);

    /* renamed from: a  reason: collision with root package name */
    public final Context f1137a;
    public final PermissionExtractor b;
    public final CachedDataProvider.CachedData c;

    public C0481ol(Context context) {
        long j = d;
        this.c = new CachedDataProvider.CachedData(j, j, "sim-info");
        this.f1137a = context;
        this.b = C0470oa.k().j();
    }

    public final C0354jl b() {
        return new C0354jl((Integer) SystemServiceUtils.accessSystemServiceByNameSafely(this.f1137a, "phone", "getting SimMcc", "TelephonyManager", new C0380kl()), (Integer) SystemServiceUtils.accessSystemServiceByNameSafely(this.f1137a, "phone", "getting SimMnc", "TelephonyManager", new C0406ll()), ((Boolean) SystemServiceUtils.accessSystemServiceByNameSafelyOrDefault(this.f1137a, "phone", "getting NetworkRoaming", "TelephonyManager", Boolean.FALSE, new C0456nl(this))).booleanValue(), (String) SystemServiceUtils.accessSystemServiceByNameSafely(this.f1137a, "phone", "getting SimOperatorName", "TelephonyManager", new C0431ml()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
        if (r4.c.shouldUpdateData() != false) goto L12;
     */
    @Override // io.appmetrica.analytics.impl.InterfaceC0582sn
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized List<C0354jl> a() {
        ArrayList arrayList;
        List list = (List) this.c.getData();
        if (list != null) {
            boolean isEmpty = list.isEmpty();
            arrayList = list;
            if (isEmpty) {
                arrayList = list;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        if (C0470oa.I.u.b().n.d) {
            if (AndroidUtils.isApiAchieved(23)) {
                if (this.b.hasPermission(this.f1137a, "android.permission.READ_PHONE_STATE")) {
                    arrayList2.addAll(C0506pl.a(this.f1137a));
                }
                if (arrayList2.size() == 0) {
                    arrayList2.add(b());
                }
            } else {
                arrayList2.add(b());
            }
        }
        this.c.setData(arrayList2);
        arrayList = arrayList2;
        return arrayList;
    }
}
