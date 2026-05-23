package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.s7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0579s7 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Me f1193a;
    public final A7 b;

    public C0579s7() {
        this(null, null, 3, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final D7 fromModel(C0631u7 c0631u7) {
        D7 d7 = new D7();
        Integer num = c0631u7.f1226a;
        if (num != null) {
            d7.f507a = num.intValue();
        }
        String str = c0631u7.b;
        if (str != null) {
            d7.b = StringUtils.correctIllFormedString(str);
        }
        String str2 = c0631u7.c;
        if (str2 != null) {
            d7.c = StringUtils.correctIllFormedString(str2);
        }
        Long l = c0631u7.d;
        if (l != null) {
            d7.d = l.longValue();
        }
        C0761z7 c0761z7 = c0631u7.e;
        if (c0761z7 != null) {
            d7.e = this.b.fromModel(c0761z7);
        }
        String str3 = c0631u7.f;
        if (str3 != null) {
            d7.f = str3;
        }
        String str4 = c0631u7.g;
        if (str4 != null) {
            d7.g = str4;
        }
        Long l2 = c0631u7.h;
        if (l2 != null) {
            d7.h = l2.longValue();
        }
        Integer num2 = c0631u7.i;
        if (num2 != null) {
            d7.i = num2.intValue();
        }
        Integer num3 = c0631u7.j;
        if (num3 != null) {
            d7.j = num3.intValue();
        }
        String str5 = c0631u7.k;
        if (str5 != null) {
            d7.k = str5;
        }
        EnumC0168c9 enumC0168c9 = c0631u7.l;
        if (enumC0168c9 != null) {
            d7.l = enumC0168c9.f922a;
        }
        String str6 = c0631u7.m;
        if (str6 != null) {
            d7.m = str6;
        }
        Aa aa = c0631u7.n;
        if (aa != null) {
            d7.n = aa.f455a;
        }
        G9 g9 = c0631u7.o;
        if (g9 != null) {
            d7.o = g9.f561a;
        }
        Boolean bool = c0631u7.p;
        if (bool != null) {
            d7.p = this.f1193a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        Integer num4 = c0631u7.q;
        if (num4 != null) {
            d7.q = num4.intValue();
        }
        byte[] bArr = c0631u7.r;
        if (bArr != null) {
            d7.r = bArr;
        }
        return d7;
    }

    public C0579s7(Me me2, A7 a7) {
        this.f1193a = me2;
        this.b = a7;
    }

    public /* synthetic */ C0579s7(Me me2, A7 a7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Me() : me2, (i & 2) != 0 ? new A7(null, 1, null) : a7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0631u7 toModel(D7 d7) {
        Long l;
        G9 g9;
        D7 d72 = new D7();
        Integer valueOf = Integer.valueOf(d7.f507a);
        Integer num = valueOf.intValue() != d72.f507a ? valueOf : null;
        String str = d7.b;
        String str2 = !Intrinsics.areEqual(str, d72.b) ? str : null;
        String str3 = d7.c;
        String str4 = !Intrinsics.areEqual(str3, d72.c) ? str3 : null;
        Long valueOf2 = Long.valueOf(d7.d);
        Long l2 = valueOf2.longValue() != d72.d ? valueOf2 : null;
        C0761z7 model = this.b.toModel(d7.e);
        String str5 = d7.f;
        String str6 = !Intrinsics.areEqual(str5, d72.f) ? str5 : null;
        String str7 = d7.g;
        String str8 = !Intrinsics.areEqual(str7, d72.g) ? str7 : null;
        Long valueOf3 = Long.valueOf(d7.h);
        if (valueOf3.longValue() == d72.h) {
            valueOf3 = null;
        }
        Integer valueOf4 = Integer.valueOf(d7.i);
        Integer num2 = valueOf4.intValue() != d72.i ? valueOf4 : null;
        Integer valueOf5 = Integer.valueOf(d7.j);
        Integer num3 = valueOf5.intValue() != d72.j ? valueOf5 : null;
        String str9 = d7.k;
        String str10 = !Intrinsics.areEqual(str9, d72.k) ? str9 : null;
        Integer valueOf6 = Integer.valueOf(d7.l);
        if (valueOf6.intValue() == d72.l) {
            valueOf6 = null;
        }
        EnumC0168c9 a2 = valueOf6 != null ? EnumC0168c9.a(Integer.valueOf(valueOf6.intValue())) : null;
        String str11 = d7.m;
        String str12 = !Intrinsics.areEqual(str11, d72.m) ? str11 : null;
        Integer valueOf7 = Integer.valueOf(d7.n);
        if (valueOf7.intValue() == d72.n) {
            valueOf7 = null;
        }
        Aa a3 = valueOf7 != null ? Aa.a(Integer.valueOf(valueOf7.intValue())) : null;
        Integer valueOf8 = Integer.valueOf(d7.o);
        if (valueOf8.intValue() == d72.o) {
            valueOf8 = null;
        }
        if (valueOf8 != null) {
            int intValue = valueOf8.intValue();
            G9[] values = G9.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    g9 = values[i];
                    l = valueOf3;
                    if (g9.f561a == intValue) {
                        break;
                    }
                    i++;
                    valueOf3 = l;
                } else {
                    l = valueOf3;
                    g9 = G9.NATIVE;
                    break;
                }
            }
        } else {
            l = valueOf3;
            g9 = null;
        }
        Boolean a4 = this.f1193a.a(d7.p);
        Integer valueOf9 = Integer.valueOf(d7.q);
        Integer num4 = valueOf9.intValue() != d72.q ? valueOf9 : null;
        byte[] bArr = d7.r;
        return new C0631u7(num, str2, str4, l2, model, str6, str8, l, num2, num3, str10, a2, str12, a3, g9, a4, num4, !Arrays.equals(bArr, d72.r) ? bArr : null);
    }
}
