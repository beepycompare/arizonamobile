package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Pk extends AbstractC0377kd {

    /* renamed from: a  reason: collision with root package name */
    public final Zo f722a;

    public Pk() {
        this(Na.k().D().b());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0377kd
    public final void a(int i) {
        Zo zo = this.f722a;
        synchronized (zo) {
            JSONObject a2 = zo.f878a.a();
            if (a2.optInt("last_migration_api_level", -1) != i) {
                zo.f878a.a(a2.put("last_migration_api_level", i));
            }
            bp bpVar = zo.f878a;
            bp.a(bpVar.f916a);
            bp.a(bpVar.b);
        }
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0377kd
    public final int b() {
        int optInt;
        Zo zo = this.f722a;
        synchronized (zo) {
            optInt = zo.f878a.a().optInt("last_migration_api_level", -1);
        }
        return optInt;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0377kd
    public final SparseArray<InterfaceC0351jd> c() {
        SparseArray<InterfaceC0351jd> sparseArray = new SparseArray<>(1);
        sparseArray.put(112, new Qk(this.f722a));
        sparseArray.put(115, new Rk());
        sparseArray.put(116, new Uk());
        return sparseArray;
    }

    public Pk(Zo zo) {
        this.f722a = zo;
    }
}
