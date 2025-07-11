package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.cache.CachedDataProvider;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.kl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0389kl implements InterfaceC0416ln {
    public static final long d = TimeUnit.SECONDS.toMillis(20);

    /* renamed from: a  reason: collision with root package name */
    public final Context f911a;
    public final PermissionExtractor b;
    public final CachedDataProvider.CachedData c;

    public C0389kl(Context context) {
        long j = d;
        this.c = new CachedDataProvider.CachedData(j, j, "sim-info");
        this.f911a = context;
        this.b = Ga.j().i();
    }

    public final C0265fl b() {
        return new C0265fl((Integer) SystemServiceUtils.accessSystemServiceByNameSafely(this.f911a, "phone", "getting SimMcc", "TelephonyManager", new C0290gl()), (Integer) SystemServiceUtils.accessSystemServiceByNameSafely(this.f911a, "phone", "getting SimMnc", "TelephonyManager", new C0315hl()), ((Boolean) SystemServiceUtils.accessSystemServiceByNameSafelyOrDefault(this.f911a, "phone", "getting NetworkRoaming", "TelephonyManager", Boolean.FALSE, new C0364jl(this))).booleanValue(), (String) SystemServiceUtils.accessSystemServiceByNameSafely(this.f911a, "phone", "getting SimOperatorName", "TelephonyManager", new C0339il()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
        if (r4.c.shouldUpdateData() != false) goto L12;
     */
    @Override // io.appmetrica.analytics.impl.InterfaceC0416ln
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized List<C0265fl> a() {
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
        if (Ga.F.u.b().n.d) {
            if (AndroidUtils.isApiAchieved(23)) {
                if (this.b.hasPermission(this.f911a, "android.permission.READ_PHONE_STATE")) {
                    arrayList2.addAll(C0414ll.a(this.f911a));
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
