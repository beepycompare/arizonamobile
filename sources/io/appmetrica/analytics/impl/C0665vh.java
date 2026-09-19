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
/* renamed from: io.appmetrica.analytics.impl.vh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0665vh extends AbstractC0303hh {
    public final Xe b;
    public final ProtobufStateStorage c;
    public final L2 d;
    public final C0495p2 e;
    public final E2 f;

    public C0665vh(C0446n5 c0446n5, Xe xe) {
        this(c0446n5, xe, ((AbstractC0619tn) C0567rn.a(C0262g2.class)).create(c0446n5.getContext()), new L2(c0446n5.getContext()), new C0495p2(), new E2(c0446n5.getContext()));
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0303hh
    public final boolean a(C0240f6 c0240f6) {
        C0446n5 c0446n5 = this.f1019a;
        c0446n5.b.toString();
        if (c0446n5.t.c() && c0446n5.x()) {
            C0262g2 c0262g2 = (C0262g2) this.c.read();
            List list = c0262g2.f992a;
            K2 k2 = c0262g2.b;
            L2 l2 = this.d;
            l2.getClass();
            C0262g2 c0262g22 = null;
            K2 a2 = AndroidUtils.isApiAchieved(28) ? H2.a(l2.f640a, l2.b) : null;
            List list2 = c0262g2.c;
            List list3 = (List) SystemServiceUtils.accessSystemServiceSafelyOrDefault(this.f.f522a, "getting available providers", "location manager", Collections.emptyList(), new D2());
            Xe xe = this.b;
            Context context = this.f1019a.f1111a;
            xe.getClass();
            ArrayList a3 = new C0486oj(context, new SafePackageManager()).a();
            if (CollectionUtils.areCollectionsEqual(a3, list)) {
                a3 = null;
            }
            if (a3 != null || !Oo.a(k2, a2) || !CollectionUtils.areCollectionsEqual(list2, list3)) {
                if (a3 != null) {
                    list = a3;
                }
                c0262g22 = new C0262g2(list, a2, list3);
            }
            if (c0262g22 == null) {
                if (c0446n5.A()) {
                    E9 e9 = c0446n5.n;
                    C0240f6 a4 = C0240f6.a(c0240f6, c0262g2.f992a, c0262g2.b, this.e, c0262g2.c);
                    e9.a(a4, C0669vl.a(e9.c.b(a4), a4.i));
                    long currentTimeSeconds = e9.i.currentTimeSeconds();
                    e9.k = currentTimeSeconds;
                    e9.f527a.a(currentTimeSeconds);
                    return false;
                }
                return false;
            }
            E9 e92 = c0446n5.n;
            C0240f6 a5 = C0240f6.a(c0240f6, c0262g22.f992a, c0262g22.b, this.e, c0262g22.c);
            e92.a(a5, C0669vl.a(e92.c.b(a5), a5.i));
            long currentTimeSeconds2 = e92.i.currentTimeSeconds();
            e92.k = currentTimeSeconds2;
            e92.f527a.a(currentTimeSeconds2);
            this.c.save(c0262g22);
            return false;
        }
        return false;
    }

    public C0665vh(C0446n5 c0446n5, Xe xe, ProtobufStateStorage protobufStateStorage, L2 l2, C0495p2 c0495p2, E2 e2) {
        super(c0446n5);
        this.b = xe;
        this.c = protobufStateStorage;
        this.d = l2;
        this.e = c0495p2;
        this.f = e2;
    }
}
