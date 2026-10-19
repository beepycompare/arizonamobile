package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class Ga implements InterfaceC0707xc {
    @Override // io.appmetrica.analytics.impl.InterfaceC0707xc
    public final C0600t9 a(C0754z7 c0754z7) {
        C0600t9 c0600t9 = null;
        if ((c0754z7 != null ? c0754z7.b : null) != null && c0754z7.c != null) {
            c0600t9 = new C0600t9();
            c0600t9.b = c0754z7.b.doubleValue();
            c0600t9.f1217a = c0754z7.c.doubleValue();
            Integer num = c0754z7.d;
            if (num != null) {
                c0600t9.g = num.intValue();
            }
            Integer num2 = c0754z7.e;
            if (num2 != null) {
                c0600t9.e = num2.intValue();
            }
            Integer num3 = c0754z7.f;
            if (num3 != null) {
                c0600t9.d = num3.intValue();
            }
            Integer num4 = c0754z7.g;
            if (num4 != null) {
                c0600t9.f = num4.intValue();
            }
            Long l = c0754z7.h;
            if (l != null) {
                c0600t9.c = TimeUnit.MILLISECONDS.toSeconds(l.longValue());
            }
            String str = c0754z7.i;
            if (str != null) {
                if (Intrinsics.areEqual(str, "gps")) {
                    c0600t9.h = 1;
                } else if (Intrinsics.areEqual(str, "network")) {
                    c0600t9.h = 2;
                }
            }
            String str2 = c0754z7.j;
            if (str2 != null) {
                c0600t9.i = str2;
            }
        }
        return c0600t9;
    }
}
