package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.k7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0367k7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0425me f971a;

    public C0367k7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0468o7 fromModel(C0341j7 c0341j7) {
        C0468o7 c0468o7 = new C0468o7();
        Boolean bool = c0341j7.f951a;
        if (bool != null) {
            c0468o7.f1043a = this.f971a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        Double d = c0341j7.c;
        if (d != null) {
            c0468o7.c = d.doubleValue();
        }
        Double d2 = c0341j7.b;
        if (d2 != null) {
            c0468o7.b = d2.doubleValue();
        }
        Long l = c0341j7.h;
        if (l != null) {
            c0468o7.h = l.longValue();
        }
        Integer num = c0341j7.f;
        if (num != null) {
            c0468o7.f = num.intValue();
        }
        Integer num2 = c0341j7.e;
        if (num2 != null) {
            c0468o7.e = num2.intValue();
        }
        Integer num3 = c0341j7.g;
        if (num3 != null) {
            c0468o7.g = num3.intValue();
        }
        Integer num4 = c0341j7.d;
        if (num4 != null) {
            c0468o7.d = num4.intValue();
        }
        String str = c0341j7.i;
        if (str != null) {
            c0468o7.i = str;
        }
        String str2 = c0341j7.j;
        if (str2 != null) {
            c0468o7.j = str2;
        }
        return c0468o7;
    }

    public C0367k7(C0425me c0425me) {
        this.f971a = c0425me;
    }

    public /* synthetic */ C0367k7(C0425me c0425me, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0425me() : c0425me);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0341j7 toModel(C0468o7 c0468o7) {
        if (c0468o7 == null) {
            return new C0341j7(null, null, null, null, null, null, null, null, null, null);
        }
        C0468o7 c0468o72 = new C0468o7();
        Boolean a2 = this.f971a.a(c0468o7.f1043a);
        Double valueOf = Double.valueOf(c0468o7.c);
        if (valueOf.doubleValue() == c0468o72.c) {
            valueOf = null;
        }
        Double valueOf2 = Double.valueOf(c0468o7.b);
        Double d = !(valueOf2.doubleValue() == c0468o72.b) ? valueOf2 : null;
        Long valueOf3 = Long.valueOf(c0468o7.h);
        Long l = valueOf3.longValue() != c0468o72.h ? valueOf3 : null;
        Integer valueOf4 = Integer.valueOf(c0468o7.f);
        Integer num = valueOf4.intValue() != c0468o72.f ? valueOf4 : null;
        Integer valueOf5 = Integer.valueOf(c0468o7.e);
        Integer num2 = valueOf5.intValue() != c0468o72.e ? valueOf5 : null;
        Integer valueOf6 = Integer.valueOf(c0468o7.g);
        Integer num3 = valueOf6.intValue() != c0468o72.g ? valueOf6 : null;
        Integer valueOf7 = Integer.valueOf(c0468o7.d);
        Integer num4 = valueOf7.intValue() != c0468o72.d ? valueOf7 : null;
        String str = c0468o7.i;
        String str2 = !Intrinsics.areEqual(str, c0468o72.i) ? str : null;
        String str3 = c0468o7.j;
        return new C0341j7(a2, d, valueOf, num4, num2, num, num3, l, str2, !Intrinsics.areEqual(str3, c0468o72.j) ? str3 : null);
    }
}
