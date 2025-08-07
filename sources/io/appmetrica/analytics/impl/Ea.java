package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class Ea implements InterfaceC0533qc {
    @Override // io.appmetrica.analytics.impl.InterfaceC0533qc
    public final C0629u9 a(E7 e7) {
        C0629u9 c0629u9 = null;
        if ((e7 != null ? e7.b : null) != null && e7.c != null) {
            c0629u9 = new C0629u9();
            c0629u9.b = e7.b.doubleValue();
            c0629u9.f1080a = e7.c.doubleValue();
            Integer num = e7.d;
            if (num != null) {
                c0629u9.g = num.intValue();
            }
            Integer num2 = e7.e;
            if (num2 != null) {
                c0629u9.e = num2.intValue();
            }
            Integer num3 = e7.f;
            if (num3 != null) {
                c0629u9.d = num3.intValue();
            }
            Integer num4 = e7.g;
            if (num4 != null) {
                c0629u9.f = num4.intValue();
            }
            Long l = e7.h;
            if (l != null) {
                c0629u9.c = TimeUnit.MILLISECONDS.toSeconds(l.longValue());
            }
            String str = e7.i;
            if (str != null) {
                if (Intrinsics.areEqual(str, "gps")) {
                    c0629u9.h = 1;
                } else if (Intrinsics.areEqual(str, "network")) {
                    c0629u9.h = 2;
                }
            }
            String str2 = e7.j;
            if (str2 != null) {
                c0629u9.i = str2;
            }
        }
        return c0629u9;
    }
}
