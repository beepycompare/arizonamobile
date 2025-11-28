package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.qa  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0521qa implements InterfaceC0166cc {
    @Override // io.appmetrica.analytics.impl.InterfaceC0166cc
    public final C0266g9 a(C0518q7 c0518q7) {
        C0266g9 c0266g9 = null;
        if ((c0518q7 != null ? c0518q7.b : null) != null && c0518q7.c != null) {
            c0266g9 = new C0266g9();
            c0266g9.b = c0518q7.b.doubleValue();
            c0266g9.f890a = c0518q7.c.doubleValue();
            Integer num = c0518q7.d;
            if (num != null) {
                c0266g9.g = num.intValue();
            }
            Integer num2 = c0518q7.e;
            if (num2 != null) {
                c0266g9.e = num2.intValue();
            }
            Integer num3 = c0518q7.f;
            if (num3 != null) {
                c0266g9.d = num3.intValue();
            }
            Integer num4 = c0518q7.g;
            if (num4 != null) {
                c0266g9.f = num4.intValue();
            }
            Long l = c0518q7.h;
            if (l != null) {
                c0266g9.c = TimeUnit.MILLISECONDS.toSeconds(l.longValue());
            }
            String str = c0518q7.i;
            if (str != null) {
                if (Intrinsics.areEqual(str, "gps")) {
                    c0266g9.h = 1;
                } else if (Intrinsics.areEqual(str, "network")) {
                    c0266g9.h = 2;
                }
            }
            String str2 = c0518q7.j;
            if (str2 != null) {
                c0266g9.i = str2;
            }
        }
        return c0266g9;
    }
}
