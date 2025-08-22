package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class Ga implements InterfaceC0579sc {
    @Override // io.appmetrica.analytics.impl.InterfaceC0579sc
    public final C0676w9 a(F7 f7) {
        C0676w9 c0676w9 = null;
        if ((f7 != null ? f7.b : null) != null && f7.c != null) {
            c0676w9 = new C0676w9();
            c0676w9.b = f7.b.doubleValue();
            c0676w9.f1118a = f7.c.doubleValue();
            Integer num = f7.d;
            if (num != null) {
                c0676w9.g = num.intValue();
            }
            Integer num2 = f7.e;
            if (num2 != null) {
                c0676w9.e = num2.intValue();
            }
            Integer num3 = f7.f;
            if (num3 != null) {
                c0676w9.d = num3.intValue();
            }
            Integer num4 = f7.g;
            if (num4 != null) {
                c0676w9.f = num4.intValue();
            }
            Long l = f7.h;
            if (l != null) {
                c0676w9.c = TimeUnit.MILLISECONDS.toSeconds(l.longValue());
            }
            String str = f7.i;
            if (str != null) {
                if (Intrinsics.areEqual(str, "gps")) {
                    c0676w9.h = 1;
                } else if (Intrinsics.areEqual(str, "network")) {
                    c0676w9.h = 2;
                }
            }
            String str2 = f7.j;
            if (str2 != null) {
                c0676w9.i = str2;
            }
        }
        return c0676w9;
    }
}
