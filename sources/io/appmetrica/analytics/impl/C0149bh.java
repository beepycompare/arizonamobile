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
public final class C0149bh extends Rg {
    public final C0677we b;
    public final ProtobufStateStorage c;
    public final C0715y2 d;
    public final C0160c2 e;
    public final C0540r2 f;

    public C0149bh(X4 x4, C0677we c0677we) {
        this(x4, c0677we, ((Rm) Pm.a(T1.class)).create(x4.getContext()), new C0715y2(x4.getContext()), new C0160c2(), new C0540r2(x4.getContext()));
    }

    @Override // io.appmetrica.analytics.impl.Rg
    public final boolean a(P5 p5) {
        X4 x4 = this.f767a;
        x4.b.toString();
        if (x4.t.c() && x4.x()) {
            T1 t1 = (T1) this.c.read();
            List list = t1.f790a;
            C0690x2 c0690x2 = t1.b;
            C0715y2 c0715y2 = this.d;
            c0715y2.getClass();
            T1 t12 = null;
            C0690x2 a2 = AndroidUtils.isApiAchieved(28) ? C0615u2.a(c0715y2.f1316a, c0715y2.b) : null;
            List list2 = t1.c;
            List list3 = (List) SystemServiceUtils.accessSystemServiceSafelyOrDefault(this.f.f1198a, "getting available providers", "location manager", Collections.emptyList(), new C0516q2());
            C0677we c0677we = this.b;
            Context context = this.f767a.f848a;
            c0677we.getClass();
            ArrayList a3 = new Pi(context, new SafePackageManager()).a();
            if (CollectionUtils.areCollectionsEqual(a3, list)) {
                a3 = null;
            }
            if (a3 != null || !lo.a(c0690x2, a2) || !CollectionUtils.areCollectionsEqual(list2, list3)) {
                if (a3 != null) {
                    list = a3;
                }
                t12 = new T1(list, a2, list3);
            }
            if (t12 == null) {
                if (x4.A()) {
                    C0373k9 c0373k9 = x4.n;
                    P5 a4 = P5.a(p5, t1.f790a, t1.b, this.e, t1.c);
                    c0373k9.a(a4, Rk.a(c0373k9.c.b(a4), a4.i));
                    long currentTimeSeconds = c0373k9.i.currentTimeSeconds();
                    c0373k9.k = currentTimeSeconds;
                    c0373k9.f1079a.a(currentTimeSeconds).b();
                    return false;
                }
                return false;
            }
            C0373k9 c0373k92 = x4.n;
            P5 a5 = P5.a(p5, t12.f790a, t12.b, this.e, t12.c);
            c0373k92.a(a5, Rk.a(c0373k92.c.b(a5), a5.i));
            long currentTimeSeconds2 = c0373k92.i.currentTimeSeconds();
            c0373k92.k = currentTimeSeconds2;
            c0373k92.f1079a.a(currentTimeSeconds2).b();
            this.c.save(t12);
            return false;
        }
        return false;
    }

    public C0149bh(X4 x4, C0677we c0677we, ProtobufStateStorage protobufStateStorage, C0715y2 c0715y2, C0160c2 c0160c2, C0540r2 c0540r2) {
        super(x4);
        this.b = c0677we;
        this.c = protobufStateStorage;
        this.d = c0715y2;
        this.e = c0160c2;
        this.f = c0540r2;
    }
}
