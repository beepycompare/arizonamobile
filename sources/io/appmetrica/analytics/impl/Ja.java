package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class Ja implements InterfaceC0659vc {
    @Override // io.appmetrica.analytics.impl.InterfaceC0659vc
    public final C0756z9 a(I7 i7) {
        C0756z9 c0756z9 = null;
        if ((i7 != null ? i7.b : null) != null && i7.c != null) {
            c0756z9 = new C0756z9();
            c0756z9.b = i7.b.doubleValue();
            c0756z9.f1187a = i7.c.doubleValue();
            Integer num = i7.d;
            if (num != null) {
                c0756z9.g = num.intValue();
            }
            Integer num2 = i7.e;
            if (num2 != null) {
                c0756z9.e = num2.intValue();
            }
            Integer num3 = i7.f;
            if (num3 != null) {
                c0756z9.d = num3.intValue();
            }
            Integer num4 = i7.g;
            if (num4 != null) {
                c0756z9.f = num4.intValue();
            }
            Long l = i7.h;
            if (l != null) {
                c0756z9.c = TimeUnit.MILLISECONDS.toSeconds(l.longValue());
            }
            String str = i7.i;
            if (str != null) {
                if (Intrinsics.areEqual(str, "gps")) {
                    c0756z9.h = 1;
                } else if (Intrinsics.areEqual(str, "network")) {
                    c0756z9.h = 2;
                }
            }
            String str2 = i7.j;
            if (str2 != null) {
                c0756z9.i = str2;
            }
        }
        return c0756z9;
    }
}
