package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.j7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0344j7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0402le f1058a;

    public C0344j7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0445n7 fromModel(C0319i7 c0319i7) {
        C0445n7 c0445n7 = new C0445n7();
        Boolean bool = c0319i7.f1039a;
        if (bool != null) {
            c0445n7.f1130a = this.f1058a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        Double d = c0319i7.c;
        if (d != null) {
            c0445n7.c = d.doubleValue();
        }
        Double d2 = c0319i7.b;
        if (d2 != null) {
            c0445n7.b = d2.doubleValue();
        }
        Long l = c0319i7.h;
        if (l != null) {
            c0445n7.h = l.longValue();
        }
        Integer num = c0319i7.f;
        if (num != null) {
            c0445n7.f = num.intValue();
        }
        Integer num2 = c0319i7.e;
        if (num2 != null) {
            c0445n7.e = num2.intValue();
        }
        Integer num3 = c0319i7.g;
        if (num3 != null) {
            c0445n7.g = num3.intValue();
        }
        Integer num4 = c0319i7.d;
        if (num4 != null) {
            c0445n7.d = num4.intValue();
        }
        String str = c0319i7.i;
        if (str != null) {
            c0445n7.i = str;
        }
        String str2 = c0319i7.j;
        if (str2 != null) {
            c0445n7.j = str2;
        }
        return c0445n7;
    }

    public C0344j7(C0402le c0402le) {
        this.f1058a = c0402le;
    }

    public /* synthetic */ C0344j7(C0402le c0402le, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0402le() : c0402le);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0319i7 toModel(C0445n7 c0445n7) {
        if (c0445n7 == null) {
            return new C0319i7(null, null, null, null, null, null, null, null, null, null);
        }
        C0445n7 c0445n72 = new C0445n7();
        Boolean a2 = this.f1058a.a(c0445n7.f1130a);
        Double valueOf = Double.valueOf(c0445n7.c);
        if (valueOf.doubleValue() == c0445n72.c) {
            valueOf = null;
        }
        Double valueOf2 = Double.valueOf(c0445n7.b);
        Double d = !(valueOf2.doubleValue() == c0445n72.b) ? valueOf2 : null;
        Long valueOf3 = Long.valueOf(c0445n7.h);
        Long l = valueOf3.longValue() != c0445n72.h ? valueOf3 : null;
        Integer valueOf4 = Integer.valueOf(c0445n7.f);
        Integer num = valueOf4.intValue() != c0445n72.f ? valueOf4 : null;
        Integer valueOf5 = Integer.valueOf(c0445n7.e);
        Integer num2 = valueOf5.intValue() != c0445n72.e ? valueOf5 : null;
        Integer valueOf6 = Integer.valueOf(c0445n7.g);
        Integer num3 = valueOf6.intValue() != c0445n72.g ? valueOf6 : null;
        Integer valueOf7 = Integer.valueOf(c0445n7.d);
        Integer num4 = valueOf7.intValue() != c0445n72.d ? valueOf7 : null;
        String str = c0445n7.i;
        String str2 = !Intrinsics.areEqual(str, c0445n72.i) ? str : null;
        String str3 = c0445n7.j;
        return new C0319i7(a2, d, valueOf, num4, num2, num, num3, l, str2, !Intrinsics.areEqual(str3, c0445n72.j) ? str3 : null);
    }
}
