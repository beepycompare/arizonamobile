package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.c7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0161c7 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0425me f826a;
    public final C0367k7 b;

    public C0161c7() {
        this(null, null, 3, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0443n7 fromModel(C0212e7 c0212e7) {
        C0443n7 c0443n7 = new C0443n7();
        Integer num = c0212e7.f866a;
        if (num != null) {
            c0443n7.f1025a = num.intValue();
        }
        String str = c0212e7.b;
        if (str != null) {
            c0443n7.b = StringUtils.correctIllFormedString(str);
        }
        String str2 = c0212e7.c;
        if (str2 != null) {
            c0443n7.c = StringUtils.correctIllFormedString(str2);
        }
        Long l = c0212e7.d;
        if (l != null) {
            c0443n7.d = l.longValue();
        }
        C0341j7 c0341j7 = c0212e7.e;
        if (c0341j7 != null) {
            c0443n7.e = this.b.fromModel(c0341j7);
        }
        String str3 = c0212e7.f;
        if (str3 != null) {
            c0443n7.f = str3;
        }
        String str4 = c0212e7.g;
        if (str4 != null) {
            c0443n7.g = str4;
        }
        Long l2 = c0212e7.h;
        if (l2 != null) {
            c0443n7.h = l2.longValue();
        }
        Integer num2 = c0212e7.i;
        if (num2 != null) {
            c0443n7.i = num2.intValue();
        }
        Integer num3 = c0212e7.j;
        if (num3 != null) {
            c0443n7.j = num3.intValue();
        }
        String str5 = c0212e7.k;
        if (str5 != null) {
            c0443n7.k = str5;
        }
        J8 j8 = c0212e7.l;
        if (j8 != null) {
            c0443n7.l = j8.f537a;
        }
        String str6 = c0212e7.m;
        if (str6 != null) {
            c0443n7.m = str6;
        }
        EnumC0215ea enumC0215ea = c0212e7.n;
        if (enumC0215ea != null) {
            c0443n7.n = enumC0215ea.f869a;
        }
        EnumC0445n9 enumC0445n9 = c0212e7.o;
        if (enumC0445n9 != null) {
            c0443n7.o = enumC0445n9.f1027a;
        }
        Boolean bool = c0212e7.p;
        if (bool != null) {
            c0443n7.p = this.f826a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        Integer num4 = c0212e7.q;
        if (num4 != null) {
            c0443n7.q = num4.intValue();
        }
        byte[] bArr = c0212e7.r;
        if (bArr != null) {
            c0443n7.r = bArr;
        }
        return c0443n7;
    }

    public C0161c7(C0425me c0425me, C0367k7 c0367k7) {
        this.f826a = c0425me;
        this.b = c0367k7;
    }

    public /* synthetic */ C0161c7(C0425me c0425me, C0367k7 c0367k7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0425me() : c0425me, (i & 2) != 0 ? new C0367k7(null, 1, null) : c0367k7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0212e7 toModel(C0443n7 c0443n7) {
        Long l;
        EnumC0445n9 enumC0445n9;
        C0443n7 c0443n72 = new C0443n7();
        Integer valueOf = Integer.valueOf(c0443n7.f1025a);
        Integer num = valueOf.intValue() != c0443n72.f1025a ? valueOf : null;
        String str = c0443n7.b;
        String str2 = !Intrinsics.areEqual(str, c0443n72.b) ? str : null;
        String str3 = c0443n7.c;
        String str4 = !Intrinsics.areEqual(str3, c0443n72.c) ? str3 : null;
        Long valueOf2 = Long.valueOf(c0443n7.d);
        Long l2 = valueOf2.longValue() != c0443n72.d ? valueOf2 : null;
        C0341j7 model = this.b.toModel(c0443n7.e);
        String str5 = c0443n7.f;
        String str6 = !Intrinsics.areEqual(str5, c0443n72.f) ? str5 : null;
        String str7 = c0443n7.g;
        String str8 = !Intrinsics.areEqual(str7, c0443n72.g) ? str7 : null;
        Long valueOf3 = Long.valueOf(c0443n7.h);
        if (valueOf3.longValue() == c0443n72.h) {
            valueOf3 = null;
        }
        Integer valueOf4 = Integer.valueOf(c0443n7.i);
        Integer num2 = valueOf4.intValue() != c0443n72.i ? valueOf4 : null;
        Integer valueOf5 = Integer.valueOf(c0443n7.j);
        Integer num3 = valueOf5.intValue() != c0443n72.j ? valueOf5 : null;
        String str9 = c0443n7.k;
        String str10 = !Intrinsics.areEqual(str9, c0443n72.k) ? str9 : null;
        Integer valueOf6 = Integer.valueOf(c0443n7.l);
        if (valueOf6.intValue() == c0443n72.l) {
            valueOf6 = null;
        }
        J8 a2 = valueOf6 != null ? J8.a(Integer.valueOf(valueOf6.intValue())) : null;
        String str11 = c0443n7.m;
        String str12 = !Intrinsics.areEqual(str11, c0443n72.m) ? str11 : null;
        Integer valueOf7 = Integer.valueOf(c0443n7.n);
        if (valueOf7.intValue() == c0443n72.n) {
            valueOf7 = null;
        }
        EnumC0215ea a3 = valueOf7 != null ? EnumC0215ea.a(Integer.valueOf(valueOf7.intValue())) : null;
        Integer valueOf8 = Integer.valueOf(c0443n7.o);
        if (valueOf8.intValue() == c0443n72.o) {
            valueOf8 = null;
        }
        if (valueOf8 != null) {
            int intValue = valueOf8.intValue();
            EnumC0445n9[] values = EnumC0445n9.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    enumC0445n9 = values[i];
                    l = valueOf3;
                    if (enumC0445n9.f1027a == intValue) {
                        break;
                    }
                    i++;
                    valueOf3 = l;
                } else {
                    l = valueOf3;
                    enumC0445n9 = EnumC0445n9.NATIVE;
                    break;
                }
            }
        } else {
            l = valueOf3;
            enumC0445n9 = null;
        }
        Boolean a4 = this.f826a.a(c0443n7.p);
        Integer valueOf9 = Integer.valueOf(c0443n7.q);
        Integer num4 = valueOf9.intValue() != c0443n72.q ? valueOf9 : null;
        byte[] bArr = c0443n7.r;
        return new C0212e7(num, str2, str4, l2, model, str6, str8, l, num2, num3, str10, a2, str12, a3, enumC0445n9, a4, num4, !Arrays.equals(bArr, c0443n72.r) ? bArr : null);
    }
}
