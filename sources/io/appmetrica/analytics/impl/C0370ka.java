package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.ka  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0370ka implements Wb {
    @Override // io.appmetrica.analytics.impl.Wb
    public final C0111a9 a(C0341j7 c0341j7) {
        C0111a9 c0111a9 = null;
        if ((c0341j7 != null ? c0341j7.b : null) != null && c0341j7.c != null) {
            c0111a9 = new C0111a9();
            c0111a9.b = c0341j7.b.doubleValue();
            c0111a9.f794a = c0341j7.c.doubleValue();
            Integer num = c0341j7.d;
            if (num != null) {
                c0111a9.g = num.intValue();
            }
            Integer num2 = c0341j7.e;
            if (num2 != null) {
                c0111a9.e = num2.intValue();
            }
            Integer num3 = c0341j7.f;
            if (num3 != null) {
                c0111a9.d = num3.intValue();
            }
            Integer num4 = c0341j7.g;
            if (num4 != null) {
                c0111a9.f = num4.intValue();
            }
            Long l = c0341j7.h;
            if (l != null) {
                c0111a9.c = TimeUnit.MILLISECONDS.toSeconds(l.longValue());
            }
            String str = c0341j7.i;
            if (str != null) {
                if (Intrinsics.areEqual(str, "gps")) {
                    c0111a9.h = 1;
                } else if (Intrinsics.areEqual(str, "network")) {
                    c0111a9.h = 2;
                }
            }
            String str2 = c0341j7.j;
            if (str2 != null) {
                c0111a9.i = str2;
            }
        }
        return c0111a9;
    }
}
