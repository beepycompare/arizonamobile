package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Pk extends AbstractC0371kd {

    /* renamed from: a  reason: collision with root package name */
    public final Zo f725a;

    public Pk() {
        this(Na.k().D().b());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0371kd
    public final void a(int i) {
        Zo zo = this.f725a;
        synchronized (zo) {
            JSONObject a2 = zo.f881a.a();
            if (a2.optInt("last_migration_api_level", -1) != i) {
                zo.f881a.a(a2.put("last_migration_api_level", i));
            }
            bp bpVar = zo.f881a;
            bp.a(bpVar.f919a);
            bp.a(bpVar.b);
        }
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0371kd
    public final int b() {
        int optInt;
        Zo zo = this.f725a;
        synchronized (zo) {
            optInt = zo.f881a.a().optInt("last_migration_api_level", -1);
        }
        return optInt;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0371kd
    public final SparseArray<InterfaceC0345jd> c() {
        SparseArray<InterfaceC0345jd> sparseArray = new SparseArray<>(1);
        sparseArray.put(112, new Qk(this.f725a));
        sparseArray.put(115, new Rk());
        sparseArray.put(116, new Uk());
        return sparseArray;
    }

    public Pk(Zo zo) {
        this.f725a = zo;
    }
}
