package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class C7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0731ye f369a;

    public C7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final G7 fromModel(B7 b7) {
        G7 g7 = new G7();
        Boolean bool = b7.f350a;
        if (bool != null) {
            g7.f441a = this.f369a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        Double d = b7.c;
        if (d != null) {
            g7.c = d.doubleValue();
        }
        Double d2 = b7.b;
        if (d2 != null) {
            g7.b = d2.doubleValue();
        }
        Long l = b7.h;
        if (l != null) {
            g7.h = l.longValue();
        }
        Integer num = b7.f;
        if (num != null) {
            g7.f = num.intValue();
        }
        Integer num2 = b7.e;
        if (num2 != null) {
            g7.e = num2.intValue();
        }
        Integer num3 = b7.g;
        if (num3 != null) {
            g7.g = num3.intValue();
        }
        Integer num4 = b7.d;
        if (num4 != null) {
            g7.d = num4.intValue();
        }
        String str = b7.i;
        if (str != null) {
            g7.i = str;
        }
        String str2 = b7.j;
        if (str2 != null) {
            g7.j = str2;
        }
        return g7;
    }

    public C7(C0731ye c0731ye) {
        this.f369a = c0731ye;
    }

    public /* synthetic */ C7(C0731ye c0731ye, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0731ye() : c0731ye);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final B7 toModel(G7 g7) {
        if (g7 == null) {
            return new B7(null, null, null, null, null, null, null, null, null, null);
        }
        G7 g72 = new G7();
        Boolean a2 = this.f369a.a(g7.f441a);
        Double valueOf = Double.valueOf(g7.c);
        if (valueOf.doubleValue() == g72.c) {
            valueOf = null;
        }
        Double valueOf2 = Double.valueOf(g7.b);
        Double d = !(valueOf2.doubleValue() == g72.b) ? valueOf2 : null;
        Long valueOf3 = Long.valueOf(g7.h);
        Long l = valueOf3.longValue() != g72.h ? valueOf3 : null;
        Integer valueOf4 = Integer.valueOf(g7.f);
        Integer num = valueOf4.intValue() != g72.f ? valueOf4 : null;
        Integer valueOf5 = Integer.valueOf(g7.e);
        Integer num2 = valueOf5.intValue() != g72.e ? valueOf5 : null;
        Integer valueOf6 = Integer.valueOf(g7.g);
        Integer num3 = valueOf6.intValue() != g72.g ? valueOf6 : null;
        Integer valueOf7 = Integer.valueOf(g7.d);
        Integer num4 = valueOf7.intValue() != g72.d ? valueOf7 : null;
        String str = g7.i;
        String str2 = !Intrinsics.areEqual(str, g72.i) ? str : null;
        String str3 = g7.j;
        return new B7(a2, d, valueOf, num4, num2, num, num3, l, str2, !Intrinsics.areEqual(str3, g72.j) ? str3 : null);
    }
}
