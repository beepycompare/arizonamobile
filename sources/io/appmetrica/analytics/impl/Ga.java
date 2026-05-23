package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class Ga implements InterfaceC0714xc {
    @Override // io.appmetrica.analytics.impl.InterfaceC0714xc
    public final C0607t9 a(C0761z7 c0761z7) {
        C0607t9 c0607t9 = null;
        if ((c0761z7 != null ? c0761z7.b : null) != null && c0761z7.c != null) {
            c0607t9 = new C0607t9();
            c0607t9.b = c0761z7.b.doubleValue();
            c0607t9.f1211a = c0761z7.c.doubleValue();
            Integer num = c0761z7.d;
            if (num != null) {
                c0607t9.g = num.intValue();
            }
            Integer num2 = c0761z7.e;
            if (num2 != null) {
                c0607t9.e = num2.intValue();
            }
            Integer num3 = c0761z7.f;
            if (num3 != null) {
                c0607t9.d = num3.intValue();
            }
            Integer num4 = c0761z7.g;
            if (num4 != null) {
                c0607t9.f = num4.intValue();
            }
            Long l = c0761z7.h;
            if (l != null) {
                c0607t9.c = TimeUnit.MILLISECONDS.toSeconds(l.longValue());
            }
            String str = c0761z7.i;
            if (str != null) {
                if (Intrinsics.areEqual(str, "gps")) {
                    c0607t9.h = 1;
                } else if (Intrinsics.areEqual(str, "network")) {
                    c0607t9.h = 2;
                }
            }
            String str2 = c0761z7.j;
            if (str2 != null) {
                c0607t9.i = str2;
            }
        }
        return c0607t9;
    }
}
