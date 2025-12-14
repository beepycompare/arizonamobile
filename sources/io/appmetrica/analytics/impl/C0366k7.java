package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.k7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0366k7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0424me f1068a;

    public C0366k7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0467o7 fromModel(C0340j7 c0340j7) {
        C0467o7 c0467o7 = new C0467o7();
        Boolean bool = c0340j7.f1048a;
        if (bool != null) {
            c0467o7.f1140a = this.f1068a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        Double d = c0340j7.c;
        if (d != null) {
            c0467o7.c = d.doubleValue();
        }
        Double d2 = c0340j7.b;
        if (d2 != null) {
            c0467o7.b = d2.doubleValue();
        }
        Long l = c0340j7.h;
        if (l != null) {
            c0467o7.h = l.longValue();
        }
        Integer num = c0340j7.f;
        if (num != null) {
            c0467o7.f = num.intValue();
        }
        Integer num2 = c0340j7.e;
        if (num2 != null) {
            c0467o7.e = num2.intValue();
        }
        Integer num3 = c0340j7.g;
        if (num3 != null) {
            c0467o7.g = num3.intValue();
        }
        Integer num4 = c0340j7.d;
        if (num4 != null) {
            c0467o7.d = num4.intValue();
        }
        String str = c0340j7.i;
        if (str != null) {
            c0467o7.i = str;
        }
        String str2 = c0340j7.j;
        if (str2 != null) {
            c0467o7.j = str2;
        }
        return c0467o7;
    }

    public C0366k7(C0424me c0424me) {
        this.f1068a = c0424me;
    }

    public /* synthetic */ C0366k7(C0424me c0424me, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0424me() : c0424me);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0340j7 toModel(C0467o7 c0467o7) {
        if (c0467o7 == null) {
            return new C0340j7(null, null, null, null, null, null, null, null, null, null);
        }
        C0467o7 c0467o72 = new C0467o7();
        Boolean a2 = this.f1068a.a(c0467o7.f1140a);
        Double valueOf = Double.valueOf(c0467o7.c);
        if (valueOf.doubleValue() == c0467o72.c) {
            valueOf = null;
        }
        Double valueOf2 = Double.valueOf(c0467o7.b);
        Double d = !(valueOf2.doubleValue() == c0467o72.b) ? valueOf2 : null;
        Long valueOf3 = Long.valueOf(c0467o7.h);
        Long l = valueOf3.longValue() != c0467o72.h ? valueOf3 : null;
        Integer valueOf4 = Integer.valueOf(c0467o7.f);
        Integer num = valueOf4.intValue() != c0467o72.f ? valueOf4 : null;
        Integer valueOf5 = Integer.valueOf(c0467o7.e);
        Integer num2 = valueOf5.intValue() != c0467o72.e ? valueOf5 : null;
        Integer valueOf6 = Integer.valueOf(c0467o7.g);
        Integer num3 = valueOf6.intValue() != c0467o72.g ? valueOf6 : null;
        Integer valueOf7 = Integer.valueOf(c0467o7.d);
        Integer num4 = valueOf7.intValue() != c0467o72.d ? valueOf7 : null;
        String str = c0467o7.i;
        String str2 = !Intrinsics.areEqual(str, c0467o72.i) ? str : null;
        String str3 = c0467o7.j;
        return new C0340j7(a2, d, valueOf, num4, num2, num, num3, l, str2, !Intrinsics.areEqual(str3, c0467o72.j) ? str3 : null);
    }
}
