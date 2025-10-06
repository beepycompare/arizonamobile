package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.cache.CachedDataProvider;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.wl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0693wl implements InterfaceC0720xn {
    public static final long d = TimeUnit.SECONDS.toMillis(20);

    /* renamed from: a  reason: collision with root package name */
    public final Context f1144a;
    public final PermissionExtractor b;
    public final CachedDataProvider.CachedData c;

    public C0693wl(Context context) {
        long j = d;
        this.c = new CachedDataProvider.CachedData(j, j, "sim-info");
        this.f1144a = context;
        this.b = Na.j().i();
    }

    public final C0568rl b() {
        return new C0568rl((Integer) SystemServiceUtils.accessSystemServiceByNameSafely(this.f1144a, "phone", "getting SimMcc", "TelephonyManager", new C0593sl()), (Integer) SystemServiceUtils.accessSystemServiceByNameSafely(this.f1144a, "phone", "getting SimMnc", "TelephonyManager", new C0618tl()), ((Boolean) SystemServiceUtils.accessSystemServiceByNameSafelyOrDefault(this.f1144a, "phone", "getting NetworkRoaming", "TelephonyManager", Boolean.FALSE, new C0668vl(this))).booleanValue(), (String) SystemServiceUtils.accessSystemServiceByNameSafely(this.f1144a, "phone", "getting SimOperatorName", "TelephonyManager", new C0643ul()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
        if (r4.c.shouldUpdateData() != false) goto L12;
     */
    @Override // io.appmetrica.analytics.impl.InterfaceC0720xn
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized List<C0568rl> a() {
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
        if (Na.F.u.b().n.d) {
            if (AndroidUtils.isApiAchieved(23)) {
                if (this.b.hasPermission(this.f1144a, "android.permission.READ_PHONE_STATE")) {
                    arrayList2.addAll(C0718xl.a(this.f1144a));
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
