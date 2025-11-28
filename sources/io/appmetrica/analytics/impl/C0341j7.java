package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.j7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0341j7 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0574se f947a;
    public final C0542r7 b;

    public C0341j7() {
        this(null, null, 3, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0617u7 fromModel(C0393l7 c0393l7) {
        C0617u7 c0617u7 = new C0617u7();
        Integer num = c0393l7.f986a;
        if (num != null) {
            c0617u7.f1146a = num.intValue();
        }
        String str = c0393l7.b;
        if (str != null) {
            c0617u7.b = StringUtils.correctIllFormedString(str);
        }
        String str2 = c0393l7.c;
        if (str2 != null) {
            c0617u7.c = StringUtils.correctIllFormedString(str2);
        }
        Long l = c0393l7.d;
        if (l != null) {
            c0617u7.d = l.longValue();
        }
        C0518q7 c0518q7 = c0393l7.e;
        if (c0518q7 != null) {
            c0617u7.e = this.b.fromModel(c0518q7);
        }
        String str3 = c0393l7.f;
        if (str3 != null) {
            c0617u7.f = str3;
        }
        String str4 = c0393l7.g;
        if (str4 != null) {
            c0617u7.g = str4;
        }
        Long l2 = c0393l7.h;
        if (l2 != null) {
            c0617u7.h = l2.longValue();
        }
        Integer num2 = c0393l7.i;
        if (num2 != null) {
            c0617u7.i = num2.intValue();
        }
        Integer num3 = c0393l7.j;
        if (num3 != null) {
            c0617u7.j = num3.intValue();
        }
        String str5 = c0393l7.k;
        if (str5 != null) {
            c0617u7.k = str5;
        }
        N8 n8 = c0393l7.l;
        if (n8 != null) {
            c0617u7.l = n8.f603a;
        }
        String str6 = c0393l7.m;
        if (str6 != null) {
            c0617u7.m = str6;
        }
        EnumC0370ka enumC0370ka = c0393l7.n;
        if (enumC0370ka != null) {
            c0617u7.n = enumC0370ka.f971a;
        }
        EnumC0594t9 enumC0594t9 = c0393l7.o;
        if (enumC0594t9 != null) {
            c0617u7.o = enumC0594t9.f1130a;
        }
        Boolean bool = c0393l7.p;
        if (bool != null) {
            c0617u7.p = this.f947a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        Integer num4 = c0393l7.q;
        if (num4 != null) {
            c0617u7.q = num4.intValue();
        }
        byte[] bArr = c0393l7.r;
        if (bArr != null) {
            c0617u7.r = bArr;
        }
        return c0617u7;
    }

    public C0341j7(C0574se c0574se, C0542r7 c0542r7) {
        this.f947a = c0574se;
        this.b = c0542r7;
    }

    public /* synthetic */ C0341j7(C0574se c0574se, C0542r7 c0542r7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0574se() : c0574se, (i & 2) != 0 ? new C0542r7(null, 1, null) : c0542r7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0393l7 toModel(C0617u7 c0617u7) {
        Long l;
        EnumC0594t9 enumC0594t9;
        C0617u7 c0617u72 = new C0617u7();
        Integer valueOf = Integer.valueOf(c0617u7.f1146a);
        Integer num = valueOf.intValue() != c0617u72.f1146a ? valueOf : null;
        String str = c0617u7.b;
        String str2 = !Intrinsics.areEqual(str, c0617u72.b) ? str : null;
        String str3 = c0617u7.c;
        String str4 = !Intrinsics.areEqual(str3, c0617u72.c) ? str3 : null;
        Long valueOf2 = Long.valueOf(c0617u7.d);
        Long l2 = valueOf2.longValue() != c0617u72.d ? valueOf2 : null;
        C0518q7 model = this.b.toModel(c0617u7.e);
        String str5 = c0617u7.f;
        String str6 = !Intrinsics.areEqual(str5, c0617u72.f) ? str5 : null;
        String str7 = c0617u7.g;
        String str8 = !Intrinsics.areEqual(str7, c0617u72.g) ? str7 : null;
        Long valueOf3 = Long.valueOf(c0617u7.h);
        if (valueOf3.longValue() == c0617u72.h) {
            valueOf3 = null;
        }
        Integer valueOf4 = Integer.valueOf(c0617u7.i);
        Integer num2 = valueOf4.intValue() != c0617u72.i ? valueOf4 : null;
        Integer valueOf5 = Integer.valueOf(c0617u7.j);
        Integer num3 = valueOf5.intValue() != c0617u72.j ? valueOf5 : null;
        String str9 = c0617u7.k;
        String str10 = !Intrinsics.areEqual(str9, c0617u72.k) ? str9 : null;
        Integer valueOf6 = Integer.valueOf(c0617u7.l);
        if (valueOf6.intValue() == c0617u72.l) {
            valueOf6 = null;
        }
        N8 a2 = valueOf6 != null ? N8.a(Integer.valueOf(valueOf6.intValue())) : null;
        String str11 = c0617u7.m;
        String str12 = !Intrinsics.areEqual(str11, c0617u72.m) ? str11 : null;
        Integer valueOf7 = Integer.valueOf(c0617u7.n);
        if (valueOf7.intValue() == c0617u72.n) {
            valueOf7 = null;
        }
        EnumC0370ka a3 = valueOf7 != null ? EnumC0370ka.a(Integer.valueOf(valueOf7.intValue())) : null;
        Integer valueOf8 = Integer.valueOf(c0617u7.o);
        if (valueOf8.intValue() == c0617u72.o) {
            valueOf8 = null;
        }
        if (valueOf8 != null) {
            int intValue = valueOf8.intValue();
            EnumC0594t9[] values = EnumC0594t9.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    enumC0594t9 = values[i];
                    l = valueOf3;
                    if (enumC0594t9.f1130a == intValue) {
                        break;
                    }
                    i++;
                    valueOf3 = l;
                } else {
                    l = valueOf3;
                    enumC0594t9 = EnumC0594t9.NATIVE;
                    break;
                }
            }
        } else {
            l = valueOf3;
            enumC0594t9 = null;
        }
        Boolean a4 = this.f947a.a(c0617u7.p);
        Integer valueOf9 = Integer.valueOf(c0617u7.q);
        Integer num4 = valueOf9.intValue() != c0617u72.q ? valueOf9 : null;
        byte[] bArr = c0617u7.r;
        return new C0393l7(num, str2, str4, l2, model, str6, str8, l, num2, num3, str10, a2, str12, a3, enumC0594t9, a4, num4, !Arrays.equals(bArr, c0617u72.r) ? bArr : null);
    }
}
