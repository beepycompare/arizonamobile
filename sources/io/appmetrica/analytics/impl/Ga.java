package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class Ga implements InterfaceC0712xc {
    @Override // io.appmetrica.analytics.impl.InterfaceC0712xc
    public final C0605t9 a(C0759z7 c0759z7) {
        C0605t9 c0605t9 = null;
        if ((c0759z7 != null ? c0759z7.b : null) != null && c0759z7.c != null) {
            c0605t9 = new C0605t9();
            c0605t9.b = c0759z7.b.doubleValue();
            c0605t9.f1214a = c0759z7.c.doubleValue();
            Integer num = c0759z7.d;
            if (num != null) {
                c0605t9.g = num.intValue();
            }
            Integer num2 = c0759z7.e;
            if (num2 != null) {
                c0605t9.e = num2.intValue();
            }
            Integer num3 = c0759z7.f;
            if (num3 != null) {
                c0605t9.d = num3.intValue();
            }
            Integer num4 = c0759z7.g;
            if (num4 != null) {
                c0605t9.f = num4.intValue();
            }
            Long l = c0759z7.h;
            if (l != null) {
                c0605t9.c = TimeUnit.MILLISECONDS.toSeconds(l.longValue());
            }
            String str = c0759z7.i;
            if (str != null) {
                if (Intrinsics.areEqual(str, "gps")) {
                    c0605t9.h = 1;
                } else if (Intrinsics.areEqual(str, "network")) {
                    c0605t9.h = 2;
                }
            }
            String str2 = c0759z7.j;
            if (str2 != null) {
                c0605t9.i = str2;
            }
        }
        return c0605t9;
    }
}
