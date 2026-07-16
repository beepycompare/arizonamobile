package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class A7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Me f455a;

    public A7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final E7 fromModel(C0761z7 c0761z7) {
        E7 e7 = new E7();
        Boolean bool = c0761z7.f1311a;
        if (bool != null) {
            e7.f525a = this.f455a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        Double d = c0761z7.c;
        if (d != null) {
            e7.c = d.doubleValue();
        }
        Double d2 = c0761z7.b;
        if (d2 != null) {
            e7.b = d2.doubleValue();
        }
        Long l = c0761z7.h;
        if (l != null) {
            e7.h = l.longValue();
        }
        Integer num = c0761z7.f;
        if (num != null) {
            e7.f = num.intValue();
        }
        Integer num2 = c0761z7.e;
        if (num2 != null) {
            e7.e = num2.intValue();
        }
        Integer num3 = c0761z7.g;
        if (num3 != null) {
            e7.g = num3.intValue();
        }
        Integer num4 = c0761z7.d;
        if (num4 != null) {
            e7.d = num4.intValue();
        }
        String str = c0761z7.i;
        if (str != null) {
            e7.i = str;
        }
        String str2 = c0761z7.j;
        if (str2 != null) {
            e7.j = str2;
        }
        return e7;
    }

    public A7(Me me2) {
        this.f455a = me2;
    }

    public /* synthetic */ A7(Me me2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Me() : me2);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0761z7 toModel(E7 e7) {
        if (e7 == null) {
            return new C0761z7(null, null, null, null, null, null, null, null, null, null);
        }
        E7 e72 = new E7();
        Boolean a2 = this.f455a.a(e7.f525a);
        Double valueOf = Double.valueOf(e7.c);
        if (valueOf.doubleValue() == e72.c) {
            valueOf = null;
        }
        Double valueOf2 = Double.valueOf(e7.b);
        Double d = !(valueOf2.doubleValue() == e72.b) ? valueOf2 : null;
        Long valueOf3 = Long.valueOf(e7.h);
        Long l = valueOf3.longValue() != e72.h ? valueOf3 : null;
        Integer valueOf4 = Integer.valueOf(e7.f);
        Integer num = valueOf4.intValue() != e72.f ? valueOf4 : null;
        Integer valueOf5 = Integer.valueOf(e7.e);
        Integer num2 = valueOf5.intValue() != e72.e ? valueOf5 : null;
        Integer valueOf6 = Integer.valueOf(e7.g);
        Integer num3 = valueOf6.intValue() != e72.g ? valueOf6 : null;
        Integer valueOf7 = Integer.valueOf(e7.d);
        Integer num4 = valueOf7.intValue() != e72.d ? valueOf7 : null;
        String str = e7.i;
        String str2 = !Intrinsics.areEqual(str, e72.i) ? str : null;
        String str3 = e7.j;
        return new C0761z7(a2, d, valueOf, num4, num2, num, num3, l, str2, !Intrinsics.areEqual(str3, e72.j) ? str3 : null);
    }
}
