package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.bh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0148bh extends Rg {
    public final C0676we b;
    public final ProtobufStateStorage c;
    public final C0714y2 d;
    public final C0159c2 e;
    public final C0539r2 f;

    public C0148bh(X4 x4, C0676we c0676we) {
        this(x4, c0676we, ((Rm) Pm.a(T1.class)).create(x4.getContext()), new C0714y2(x4.getContext()), new C0159c2(), new C0539r2(x4.getContext()));
    }

    @Override // io.appmetrica.analytics.impl.Rg
    public final boolean a(P5 p5) {
        X4 x4 = this.f772a;
        x4.b.toString();
        if (x4.t.c() && x4.x()) {
            T1 t1 = (T1) this.c.read();
            List list = t1.f795a;
            C0689x2 c0689x2 = t1.b;
            C0714y2 c0714y2 = this.d;
            c0714y2.getClass();
            T1 t12 = null;
            C0689x2 a2 = AndroidUtils.isApiAchieved(28) ? C0614u2.a(c0714y2.f1321a, c0714y2.b) : null;
            List list2 = t1.c;
            List list3 = (List) SystemServiceUtils.accessSystemServiceSafelyOrDefault(this.f.f1203a, "getting available providers", "location manager", Collections.emptyList(), new C0515q2());
            C0676we c0676we = this.b;
            Context context = this.f772a.f853a;
            c0676we.getClass();
            ArrayList a3 = new Pi(context, new SafePackageManager()).a();
            if (CollectionUtils.areCollectionsEqual(a3, list)) {
                a3 = null;
            }
            if (a3 != null || !lo.a(c0689x2, a2) || !CollectionUtils.areCollectionsEqual(list2, list3)) {
                if (a3 != null) {
                    list = a3;
                }
                t12 = new T1(list, a2, list3);
            }
            if (t12 == null) {
                if (x4.A()) {
                    C0372k9 c0372k9 = x4.n;
                    P5 a4 = P5.a(p5, t1.f795a, t1.b, this.e, t1.c);
                    c0372k9.a(a4, Rk.a(c0372k9.c.b(a4), a4.i));
                    long currentTimeSeconds = c0372k9.i.currentTimeSeconds();
                    c0372k9.k = currentTimeSeconds;
                    c0372k9.f1084a.a(currentTimeSeconds).b();
                    return false;
                }
                return false;
            }
            C0372k9 c0372k92 = x4.n;
            P5 a5 = P5.a(p5, t12.f795a, t12.b, this.e, t12.c);
            c0372k92.a(a5, Rk.a(c0372k92.c.b(a5), a5.i));
            long currentTimeSeconds2 = c0372k92.i.currentTimeSeconds();
            c0372k92.k = currentTimeSeconds2;
            c0372k92.f1084a.a(currentTimeSeconds2).b();
            this.c.save(t12);
            return false;
        }
        return false;
    }

    public C0148bh(X4 x4, C0676we c0676we, ProtobufStateStorage protobufStateStorage, C0714y2 c0714y2, C0159c2 c0159c2, C0539r2 c0539r2) {
        super(x4);
        this.b = c0676we;
        this.c = protobufStateStorage;
        this.d = c0714y2;
        this.e = c0159c2;
        this.f = c0539r2;
    }
}
