package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.ja  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0348ja implements Vb {
    @Override // io.appmetrica.analytics.impl.Vb
    public final Z8 a(C0320i7 c0320i7) {
        Z8 z8 = null;
        if ((c0320i7 != null ? c0320i7.b : null) != null && c0320i7.c != null) {
            z8 = new Z8();
            z8.b = c0320i7.b.doubleValue();
            z8.f881a = c0320i7.c.doubleValue();
            Integer num = c0320i7.d;
            if (num != null) {
                z8.g = num.intValue();
            }
            Integer num2 = c0320i7.e;
            if (num2 != null) {
                z8.e = num2.intValue();
            }
            Integer num3 = c0320i7.f;
            if (num3 != null) {
                z8.d = num3.intValue();
            }
            Integer num4 = c0320i7.g;
            if (num4 != null) {
                z8.f = num4.intValue();
            }
            Long l = c0320i7.h;
            if (l != null) {
                z8.c = TimeUnit.MILLISECONDS.toSeconds(l.longValue());
            }
            String str = c0320i7.i;
            if (str != null) {
                if (Intrinsics.areEqual(str, "gps")) {
                    z8.h = 1;
                } else if (Intrinsics.areEqual(str, "network")) {
                    z8.h = 2;
                }
            }
            String str2 = c0320i7.j;
            if (str2 != null) {
                z8.i = str2;
            }
        }
        return z8;
    }
}
