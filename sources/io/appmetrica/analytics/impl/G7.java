package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class G7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Ce f451a;

    public G7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final K7 fromModel(F7 f7) {
        K7 k7 = new K7();
        Boolean bool = f7.f429a;
        if (bool != null) {
            k7.f526a = this.f451a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        Double d = f7.c;
        if (d != null) {
            k7.c = d.doubleValue();
        }
        Double d2 = f7.b;
        if (d2 != null) {
            k7.b = d2.doubleValue();
        }
        Long l = f7.h;
        if (l != null) {
            k7.h = l.longValue();
        }
        Integer num = f7.f;
        if (num != null) {
            k7.f = num.intValue();
        }
        Integer num2 = f7.e;
        if (num2 != null) {
            k7.e = num2.intValue();
        }
        Integer num3 = f7.g;
        if (num3 != null) {
            k7.g = num3.intValue();
        }
        Integer num4 = f7.d;
        if (num4 != null) {
            k7.d = num4.intValue();
        }
        String str = f7.i;
        if (str != null) {
            k7.i = str;
        }
        String str2 = f7.j;
        if (str2 != null) {
            k7.j = str2;
        }
        return k7;
    }

    public G7(Ce ce) {
        this.f451a = ce;
    }

    public /* synthetic */ G7(Ce ce, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Ce() : ce);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final F7 toModel(K7 k7) {
        if (k7 == null) {
            return new F7(null, null, null, null, null, null, null, null, null, null);
        }
        K7 k72 = new K7();
        Boolean a2 = this.f451a.a(k7.f526a);
        Double valueOf = Double.valueOf(k7.c);
        if (valueOf.doubleValue() == k72.c) {
            valueOf = null;
        }
        Double valueOf2 = Double.valueOf(k7.b);
        Double d = !(valueOf2.doubleValue() == k72.b) ? valueOf2 : null;
        Long valueOf3 = Long.valueOf(k7.h);
        Long l = valueOf3.longValue() != k72.h ? valueOf3 : null;
        Integer valueOf4 = Integer.valueOf(k7.f);
        Integer num = valueOf4.intValue() != k72.f ? valueOf4 : null;
        Integer valueOf5 = Integer.valueOf(k7.e);
        Integer num2 = valueOf5.intValue() != k72.e ? valueOf5 : null;
        Integer valueOf6 = Integer.valueOf(k7.g);
        Integer num3 = valueOf6.intValue() != k72.g ? valueOf6 : null;
        Integer valueOf7 = Integer.valueOf(k7.d);
        Integer num4 = valueOf7.intValue() != k72.d ? valueOf7 : null;
        String str = k7.i;
        String str2 = !Intrinsics.areEqual(str, k72.i) ? str : null;
        String str3 = k7.j;
        return new F7(a2, d, valueOf, num4, num2, num, num3, l, str2, !Intrinsics.areEqual(str3, k72.j) ? str3 : null);
    }
}
