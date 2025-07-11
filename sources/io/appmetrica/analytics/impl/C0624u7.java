package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.u7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0624u7 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0731ye f1070a;
    public final C7 b;

    public C0624u7() {
        this(null, null, 3, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final F7 fromModel(C0674w7 c0674w7) {
        F7 f7 = new F7();
        Integer num = c0674w7.f1101a;
        if (num != null) {
            f7.f426a = num.intValue();
        }
        String str = c0674w7.b;
        if (str != null) {
            f7.b = StringUtils.correctIllFormedString(str);
        }
        String str2 = c0674w7.c;
        if (str2 != null) {
            f7.c = StringUtils.correctIllFormedString(str2);
        }
        Long l = c0674w7.d;
        if (l != null) {
            f7.d = l.longValue();
        }
        B7 b7 = c0674w7.e;
        if (b7 != null) {
            f7.e = this.b.fromModel(b7);
        }
        String str3 = c0674w7.f;
        if (str3 != null) {
            f7.f = str3;
        }
        String str4 = c0674w7.g;
        if (str4 != null) {
            f7.g = str4;
        }
        Long l2 = c0674w7.h;
        if (l2 != null) {
            f7.h = l2.longValue();
        }
        Integer num2 = c0674w7.i;
        if (num2 != null) {
            f7.i = num2.intValue();
        }
        Integer num3 = c0674w7.j;
        if (num3 != null) {
            f7.j = num3.intValue();
        }
        String str5 = c0674w7.k;
        if (str5 != null) {
            f7.k = str5;
        }
        Y8 y8 = c0674w7.l;
        if (y8 != null) {
            f7.l = y8.f719a;
        }
        String str6 = c0674w7.m;
        if (str6 != null) {
            f7.m = str6;
        }
        EnumC0677wa enumC0677wa = c0674w7.n;
        if (enumC0677wa != null) {
            f7.n = enumC0677wa.f1104a;
        }
        E9 e9 = c0674w7.o;
        if (e9 != null) {
            f7.o = e9.f406a;
        }
        Boolean bool = c0674w7.p;
        if (bool != null) {
            f7.p = this.f1070a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        Integer num4 = c0674w7.q;
        if (num4 != null) {
            f7.q = num4.intValue();
        }
        byte[] bArr = c0674w7.r;
        if (bArr != null) {
            f7.r = bArr;
        }
        return f7;
    }

    public C0624u7(C0731ye c0731ye, C7 c7) {
        this.f1070a = c0731ye;
        this.b = c7;
    }

    public /* synthetic */ C0624u7(C0731ye c0731ye, C7 c7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0731ye() : c0731ye, (i & 2) != 0 ? new C7(null, 1, null) : c7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0674w7 toModel(F7 f7) {
        Long l;
        E9 e9;
        F7 f72 = new F7();
        Integer valueOf = Integer.valueOf(f7.f426a);
        Integer num = valueOf.intValue() != f72.f426a ? valueOf : null;
        String str = f7.b;
        String str2 = !Intrinsics.areEqual(str, f72.b) ? str : null;
        String str3 = f7.c;
        String str4 = !Intrinsics.areEqual(str3, f72.c) ? str3 : null;
        Long valueOf2 = Long.valueOf(f7.d);
        Long l2 = valueOf2.longValue() != f72.d ? valueOf2 : null;
        B7 model = this.b.toModel(f7.e);
        String str5 = f7.f;
        String str6 = !Intrinsics.areEqual(str5, f72.f) ? str5 : null;
        String str7 = f7.g;
        String str8 = !Intrinsics.areEqual(str7, f72.g) ? str7 : null;
        Long valueOf3 = Long.valueOf(f7.h);
        if (valueOf3.longValue() == f72.h) {
            valueOf3 = null;
        }
        Integer valueOf4 = Integer.valueOf(f7.i);
        Integer num2 = valueOf4.intValue() != f72.i ? valueOf4 : null;
        Integer valueOf5 = Integer.valueOf(f7.j);
        Integer num3 = valueOf5.intValue() != f72.j ? valueOf5 : null;
        String str9 = f7.k;
        String str10 = !Intrinsics.areEqual(str9, f72.k) ? str9 : null;
        Integer valueOf6 = Integer.valueOf(f7.l);
        if (valueOf6.intValue() == f72.l) {
            valueOf6 = null;
        }
        Y8 a2 = valueOf6 != null ? Y8.a(Integer.valueOf(valueOf6.intValue())) : null;
        String str11 = f7.m;
        String str12 = !Intrinsics.areEqual(str11, f72.m) ? str11 : null;
        Integer valueOf7 = Integer.valueOf(f7.n);
        if (valueOf7.intValue() == f72.n) {
            valueOf7 = null;
        }
        EnumC0677wa a3 = valueOf7 != null ? EnumC0677wa.a(Integer.valueOf(valueOf7.intValue())) : null;
        Integer valueOf8 = Integer.valueOf(f7.o);
        if (valueOf8.intValue() == f72.o) {
            valueOf8 = null;
        }
        if (valueOf8 != null) {
            int intValue = valueOf8.intValue();
            E9[] values = E9.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    e9 = values[i];
                    l = valueOf3;
                    if (e9.f406a == intValue) {
                        break;
                    }
                    i++;
                    valueOf3 = l;
                } else {
                    l = valueOf3;
                    e9 = E9.NATIVE;
                    break;
                }
            }
        } else {
            l = valueOf3;
            e9 = null;
        }
        Boolean a4 = this.f1070a.a(f7.p);
        Integer valueOf9 = Integer.valueOf(f7.q);
        Integer num4 = valueOf9.intValue() != f72.q ? valueOf9 : null;
        byte[] bArr = f7.r;
        return new C0674w7(num, str2, str4, l2, model, str6, str8, l, num2, num3, str10, a2, str12, a3, e9, a4, num4, !Arrays.equals(bArr, f72.r) ? bArr : null);
    }
}
