package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.ka  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0369ka implements Wb {
    @Override // io.appmetrica.analytics.impl.Wb
    public final C0110a9 a(C0340j7 c0340j7) {
        C0110a9 c0110a9 = null;
        if ((c0340j7 != null ? c0340j7.b : null) != null && c0340j7.c != null) {
            c0110a9 = new C0110a9();
            c0110a9.b = c0340j7.b.doubleValue();
            c0110a9.f877a = c0340j7.c.doubleValue();
            Integer num = c0340j7.d;
            if (num != null) {
                c0110a9.g = num.intValue();
            }
            Integer num2 = c0340j7.e;
            if (num2 != null) {
                c0110a9.e = num2.intValue();
            }
            Integer num3 = c0340j7.f;
            if (num3 != null) {
                c0110a9.d = num3.intValue();
            }
            Integer num4 = c0340j7.g;
            if (num4 != null) {
                c0110a9.f = num4.intValue();
            }
            Long l = c0340j7.h;
            if (l != null) {
                c0110a9.c = TimeUnit.MILLISECONDS.toSeconds(l.longValue());
            }
            String str = c0340j7.i;
            if (str != null) {
                if (Intrinsics.areEqual(str, "gps")) {
                    c0110a9.h = 1;
                } else if (Intrinsics.areEqual(str, "network")) {
                    c0110a9.h = 2;
                }
            }
            String str2 = c0340j7.j;
            if (str2 != null) {
                c0110a9.i = str2;
            }
        }
        return c0110a9;
    }
}
