package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class Ca implements InterfaceC0480oc {
    @Override // io.appmetrica.analytics.impl.InterfaceC0480oc
    public final C0551r9 a(B7 b7) {
        C0551r9 c0551r9 = null;
        if ((b7 != null ? b7.b : null) != null && b7.c != null) {
            c0551r9 = new C0551r9();
            c0551r9.b = b7.b.doubleValue();
            c0551r9.f1023a = b7.c.doubleValue();
            Integer num = b7.d;
            if (num != null) {
                c0551r9.g = num.intValue();
            }
            Integer num2 = b7.e;
            if (num2 != null) {
                c0551r9.e = num2.intValue();
            }
            Integer num3 = b7.f;
            if (num3 != null) {
                c0551r9.d = num3.intValue();
            }
            Integer num4 = b7.g;
            if (num4 != null) {
                c0551r9.f = num4.intValue();
            }
            Long l = b7.h;
            if (l != null) {
                c0551r9.c = TimeUnit.MILLISECONDS.toSeconds(l.longValue());
            }
            String str = b7.i;
            if (str != null) {
                if (Intrinsics.areEqual(str, "gps")) {
                    c0551r9.h = 1;
                } else if (Intrinsics.areEqual(str, "network")) {
                    c0551r9.h = 2;
                }
            }
            String str2 = b7.j;
            if (str2 != null) {
                c0551r9.i = str2;
            }
        }
        return c0551r9;
    }
}
