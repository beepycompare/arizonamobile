package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.r7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0542r7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0574se f1089a;

    public C0542r7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0642v7 fromModel(C0518q7 c0518q7) {
        C0642v7 c0642v7 = new C0642v7();
        Boolean bool = c0518q7.f1068a;
        if (bool != null) {
            c0642v7.f1164a = this.f1089a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        Double d = c0518q7.c;
        if (d != null) {
            c0642v7.c = d.doubleValue();
        }
        Double d2 = c0518q7.b;
        if (d2 != null) {
            c0642v7.b = d2.doubleValue();
        }
        Long l = c0518q7.h;
        if (l != null) {
            c0642v7.h = l.longValue();
        }
        Integer num = c0518q7.f;
        if (num != null) {
            c0642v7.f = num.intValue();
        }
        Integer num2 = c0518q7.e;
        if (num2 != null) {
            c0642v7.e = num2.intValue();
        }
        Integer num3 = c0518q7.g;
        if (num3 != null) {
            c0642v7.g = num3.intValue();
        }
        Integer num4 = c0518q7.d;
        if (num4 != null) {
            c0642v7.d = num4.intValue();
        }
        String str = c0518q7.i;
        if (str != null) {
            c0642v7.i = str;
        }
        String str2 = c0518q7.j;
        if (str2 != null) {
            c0642v7.j = str2;
        }
        return c0642v7;
    }

    public C0542r7(C0574se c0574se) {
        this.f1089a = c0574se;
    }

    public /* synthetic */ C0542r7(C0574se c0574se, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0574se() : c0574se);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0518q7 toModel(C0642v7 c0642v7) {
        if (c0642v7 == null) {
            return new C0518q7(null, null, null, null, null, null, null, null, null, null);
        }
        C0642v7 c0642v72 = new C0642v7();
        Boolean a2 = this.f1089a.a(c0642v7.f1164a);
        Double valueOf = Double.valueOf(c0642v7.c);
        if (valueOf.doubleValue() == c0642v72.c) {
            valueOf = null;
        }
        Double valueOf2 = Double.valueOf(c0642v7.b);
        Double d = !(valueOf2.doubleValue() == c0642v72.b) ? valueOf2 : null;
        Long valueOf3 = Long.valueOf(c0642v7.h);
        Long l = valueOf3.longValue() != c0642v72.h ? valueOf3 : null;
        Integer valueOf4 = Integer.valueOf(c0642v7.f);
        Integer num = valueOf4.intValue() != c0642v72.f ? valueOf4 : null;
        Integer valueOf5 = Integer.valueOf(c0642v7.e);
        Integer num2 = valueOf5.intValue() != c0642v72.e ? valueOf5 : null;
        Integer valueOf6 = Integer.valueOf(c0642v7.g);
        Integer num3 = valueOf6.intValue() != c0642v72.g ? valueOf6 : null;
        Integer valueOf7 = Integer.valueOf(c0642v7.d);
        Integer num4 = valueOf7.intValue() != c0642v72.d ? valueOf7 : null;
        String str = c0642v7.i;
        String str2 = !Intrinsics.areEqual(str, c0642v72.i) ? str : null;
        String str3 = c0642v7.j;
        return new C0518q7(a2, d, valueOf, num4, num2, num, num3, l, str2, !Intrinsics.areEqual(str3, c0642v72.j) ? str3 : null);
    }
}
