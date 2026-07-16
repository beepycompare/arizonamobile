package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.cache.CachedDataProvider;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class Sl implements Sn {
    public static final long d = TimeUnit.SECONDS.toMillis(20);

    /* renamed from: a  reason: collision with root package name */
    public final Context f768a;
    public final PermissionExtractor b;
    public final CachedDataProvider.CachedData c;

    public Sl(Context context) {
        long j = d;
        this.c = new CachedDataProvider.CachedData(j, j, "sim-info");
        this.f768a = context;
        this.b = Na.k().j();
    }

    public final Nl b() {
        return new Nl((Integer) SystemServiceUtils.accessSystemServiceByNameSafely(this.f768a, "phone", "getting SimMcc", "TelephonyManager", new Ol()), (Integer) SystemServiceUtils.accessSystemServiceByNameSafely(this.f768a, "phone", "getting SimMnc", "TelephonyManager", new Pl()), ((Boolean) SystemServiceUtils.accessSystemServiceByNameSafelyOrDefault(this.f768a, "phone", "getting NetworkRoaming", "TelephonyManager", Boolean.FALSE, new Rl(this))).booleanValue(), (String) SystemServiceUtils.accessSystemServiceByNameSafely(this.f768a, "phone", "getting SimOperatorName", "TelephonyManager", new Ql()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
        if (r4.c.shouldUpdateData() != false) goto L12;
     */
    @Override // io.appmetrica.analytics.impl.Sn
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized List<Nl> a() {
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
        if (Na.I.u.a().n.d) {
            if (AndroidUtils.isApiAchieved(23)) {
                if (this.b.hasPermission(this.f768a, "android.permission.READ_PHONE_STATE")) {
                    arrayList2.addAll(Tl.a(this.f768a));
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
