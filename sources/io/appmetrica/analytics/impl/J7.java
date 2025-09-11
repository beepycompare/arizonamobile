package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class J7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Ge f512a;

    public J7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final N7 fromModel(I7 i7) {
        N7 n7 = new N7();
        Boolean bool = i7.f491a;
        if (bool != null) {
            n7.f590a = this.f512a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        Double d = i7.c;
        if (d != null) {
            n7.c = d.doubleValue();
        }
        Double d2 = i7.b;
        if (d2 != null) {
            n7.b = d2.doubleValue();
        }
        Long l = i7.h;
        if (l != null) {
            n7.h = l.longValue();
        }
        Integer num = i7.f;
        if (num != null) {
            n7.f = num.intValue();
        }
        Integer num2 = i7.e;
        if (num2 != null) {
            n7.e = num2.intValue();
        }
        Integer num3 = i7.g;
        if (num3 != null) {
            n7.g = num3.intValue();
        }
        Integer num4 = i7.d;
        if (num4 != null) {
            n7.d = num4.intValue();
        }
        String str = i7.i;
        if (str != null) {
            n7.i = str;
        }
        String str2 = i7.j;
        if (str2 != null) {
            n7.j = str2;
        }
        return n7;
    }

    public J7(Ge ge) {
        this.f512a = ge;
    }

    public /* synthetic */ J7(Ge ge, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Ge() : ge);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final I7 toModel(N7 n7) {
        if (n7 == null) {
            return new I7(null, null, null, null, null, null, null, null, null, null);
        }
        N7 n72 = new N7();
        Boolean a2 = this.f512a.a(n7.f590a);
        Double valueOf = Double.valueOf(n7.c);
        if (valueOf.doubleValue() == n72.c) {
            valueOf = null;
        }
        Double valueOf2 = Double.valueOf(n7.b);
        Double d = !(valueOf2.doubleValue() == n72.b) ? valueOf2 : null;
        Long valueOf3 = Long.valueOf(n7.h);
        Long l = valueOf3.longValue() != n72.h ? valueOf3 : null;
        Integer valueOf4 = Integer.valueOf(n7.f);
        Integer num = valueOf4.intValue() != n72.f ? valueOf4 : null;
        Integer valueOf5 = Integer.valueOf(n7.e);
        Integer num2 = valueOf5.intValue() != n72.e ? valueOf5 : null;
        Integer valueOf6 = Integer.valueOf(n7.g);
        Integer num3 = valueOf6.intValue() != n72.g ? valueOf6 : null;
        Integer valueOf7 = Integer.valueOf(n7.d);
        Integer num4 = valueOf7.intValue() != n72.d ? valueOf7 : null;
        String str = n7.i;
        String str2 = !Intrinsics.areEqual(str, n72.i) ? str : null;
        String str3 = n7.j;
        return new I7(a2, d, valueOf, num4, num2, num, num3, l, str2, !Intrinsics.areEqual(str3, n72.j) ? str3 : null);
    }
}
