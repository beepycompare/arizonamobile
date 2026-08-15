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
public final class C0666vh extends AbstractC0304hh {
    public final Xe b;
    public final ProtobufStateStorage c;
    public final L2 d;
    public final C0496p2 e;
    public final E2 f;

    public C0666vh(C0447n5 c0447n5, Xe xe) {
        this(c0447n5, xe, ((AbstractC0620tn) C0568rn.a(C0263g2.class)).create(c0447n5.getContext()), new L2(c0447n5.getContext()), new C0496p2(), new E2(c0447n5.getContext()));
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0304hh
    public final boolean a(C0241f6 c0241f6) {
        C0447n5 c0447n5 = this.f1019a;
        c0447n5.b.toString();
        if (c0447n5.t.c() && c0447n5.x()) {
            C0263g2 c0263g2 = (C0263g2) this.c.read();
            List list = c0263g2.f992a;
            K2 k2 = c0263g2.b;
            L2 l2 = this.d;
            l2.getClass();
            C0263g2 c0263g22 = null;
            K2 a2 = AndroidUtils.isApiAchieved(28) ? H2.a(l2.f640a, l2.b) : null;
            List list2 = c0263g2.c;
            List list3 = (List) SystemServiceUtils.accessSystemServiceSafelyOrDefault(this.f.f522a, "getting available providers", "location manager", Collections.emptyList(), new D2());
            Xe xe = this.b;
            Context context = this.f1019a.f1111a;
            xe.getClass();
            ArrayList a3 = new C0487oj(context, new SafePackageManager()).a();
            if (CollectionUtils.areCollectionsEqual(a3, list)) {
                a3 = null;
            }
            if (a3 != null || !Oo.a(k2, a2) || !CollectionUtils.areCollectionsEqual(list2, list3)) {
                if (a3 != null) {
                    list = a3;
                }
                c0263g22 = new C0263g2(list, a2, list3);
            }
            if (c0263g22 == null) {
                if (c0447n5.A()) {
                    E9 e9 = c0447n5.n;
                    C0241f6 a4 = C0241f6.a(c0241f6, c0263g2.f992a, c0263g2.b, this.e, c0263g2.c);
                    e9.a(a4, C0670vl.a(e9.c.b(a4), a4.i));
                    long currentTimeSeconds = e9.i.currentTimeSeconds();
                    e9.k = currentTimeSeconds;
                    e9.f527a.a(currentTimeSeconds);
                    return false;
                }
                return false;
            }
            E9 e92 = c0447n5.n;
            C0241f6 a5 = C0241f6.a(c0241f6, c0263g22.f992a, c0263g22.b, this.e, c0263g22.c);
            e92.a(a5, C0670vl.a(e92.c.b(a5), a5.i));
            long currentTimeSeconds2 = e92.i.currentTimeSeconds();
            e92.k = currentTimeSeconds2;
            e92.f527a.a(currentTimeSeconds2);
            this.c.save(c0263g22);
            return false;
        }
        return false;
    }

    public C0666vh(C0447n5 c0447n5, Xe xe, ProtobufStateStorage protobufStateStorage, L2 l2, C0496p2 c0496p2, E2 e2) {
        super(c0447n5);
        this.b = xe;
        this.c = protobufStateStorage;
        this.d = l2;
        this.e = c0496p2;
        this.f = e2;
    }
}
