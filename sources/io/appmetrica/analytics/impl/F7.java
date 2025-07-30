package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class F7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Ae f433a;

    public F7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final J7 fromModel(E7 e7) {
        J7 j7 = new J7();
        Boolean bool = e7.f413a;
        if (bool != null) {
            j7.f501a = this.f433a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        Double d = e7.c;
        if (d != null) {
            j7.c = d.doubleValue();
        }
        Double d2 = e7.b;
        if (d2 != null) {
            j7.b = d2.doubleValue();
        }
        Long l = e7.h;
        if (l != null) {
            j7.h = l.longValue();
        }
        Integer num = e7.f;
        if (num != null) {
            j7.f = num.intValue();
        }
        Integer num2 = e7.e;
        if (num2 != null) {
            j7.e = num2.intValue();
        }
        Integer num3 = e7.g;
        if (num3 != null) {
            j7.g = num3.intValue();
        }
        Integer num4 = e7.d;
        if (num4 != null) {
            j7.d = num4.intValue();
        }
        String str = e7.i;
        if (str != null) {
            j7.i = str;
        }
        String str2 = e7.j;
        if (str2 != null) {
            j7.j = str2;
        }
        return j7;
    }

    public F7(Ae ae) {
        this.f433a = ae;
    }

    public /* synthetic */ F7(Ae ae, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Ae() : ae);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final E7 toModel(J7 j7) {
        if (j7 == null) {
            return new E7(null, null, null, null, null, null, null, null, null, null);
        }
        J7 j72 = new J7();
        Boolean a2 = this.f433a.a(j7.f501a);
        Double valueOf = Double.valueOf(j7.c);
        if (valueOf.doubleValue() == j72.c) {
            valueOf = null;
        }
        Double valueOf2 = Double.valueOf(j7.b);
        Double d = !(valueOf2.doubleValue() == j72.b) ? valueOf2 : null;
        Long valueOf3 = Long.valueOf(j7.h);
        Long l = valueOf3.longValue() != j72.h ? valueOf3 : null;
        Integer valueOf4 = Integer.valueOf(j7.f);
        Integer num = valueOf4.intValue() != j72.f ? valueOf4 : null;
        Integer valueOf5 = Integer.valueOf(j7.e);
        Integer num2 = valueOf5.intValue() != j72.e ? valueOf5 : null;
        Integer valueOf6 = Integer.valueOf(j7.g);
        Integer num3 = valueOf6.intValue() != j72.g ? valueOf6 : null;
        Integer valueOf7 = Integer.valueOf(j7.d);
        Integer num4 = valueOf7.intValue() != j72.d ? valueOf7 : null;
        String str = j7.i;
        String str2 = !Intrinsics.areEqual(str, j72.i) ? str : null;
        String str3 = j7.j;
        return new E7(a2, d, valueOf, num4, num2, num, num3, l, str2, !Intrinsics.areEqual(str3, j72.j) ? str3 : null);
    }
}
