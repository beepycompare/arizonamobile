package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.b7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0139b7 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0403le f915a;
    public final C0345j7 b;

    public C0139b7() {
        this(null, null, 3, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0421m7 fromModel(C0191d7 c0191d7) {
        C0421m7 c0421m7 = new C0421m7();
        Integer num = c0191d7.f954a;
        if (num != null) {
            c0421m7.f1113a = num.intValue();
        }
        String str = c0191d7.b;
        if (str != null) {
            c0421m7.b = StringUtils.correctIllFormedString(str);
        }
        String str2 = c0191d7.c;
        if (str2 != null) {
            c0421m7.c = StringUtils.correctIllFormedString(str2);
        }
        Long l = c0191d7.d;
        if (l != null) {
            c0421m7.d = l.longValue();
        }
        C0320i7 c0320i7 = c0191d7.e;
        if (c0320i7 != null) {
            c0421m7.e = this.b.fromModel(c0320i7);
        }
        String str3 = c0191d7.f;
        if (str3 != null) {
            c0421m7.f = str3;
        }
        String str4 = c0191d7.g;
        if (str4 != null) {
            c0421m7.g = str4;
        }
        Long l2 = c0191d7.h;
        if (l2 != null) {
            c0421m7.h = l2.longValue();
        }
        Integer num2 = c0191d7.i;
        if (num2 != null) {
            c0421m7.i = num2.intValue();
        }
        Integer num3 = c0191d7.j;
        if (num3 != null) {
            c0421m7.j = num3.intValue();
        }
        String str5 = c0191d7.k;
        if (str5 != null) {
            c0421m7.k = str5;
        }
        I8 i8 = c0191d7.l;
        if (i8 != null) {
            c0421m7.l = i8.f626a;
        }
        String str6 = c0191d7.m;
        if (str6 != null) {
            c0421m7.m = str6;
        }
        EnumC0194da enumC0194da = c0191d7.n;
        if (enumC0194da != null) {
            c0421m7.n = enumC0194da.f957a;
        }
        EnumC0423m9 enumC0423m9 = c0191d7.o;
        if (enumC0423m9 != null) {
            c0421m7.o = enumC0423m9.f1115a;
        }
        Boolean bool = c0191d7.p;
        if (bool != null) {
            c0421m7.p = this.f915a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        Integer num4 = c0191d7.q;
        if (num4 != null) {
            c0421m7.q = num4.intValue();
        }
        byte[] bArr = c0191d7.r;
        if (bArr != null) {
            c0421m7.r = bArr;
        }
        return c0421m7;
    }

    public C0139b7(C0403le c0403le, C0345j7 c0345j7) {
        this.f915a = c0403le;
        this.b = c0345j7;
    }

    public /* synthetic */ C0139b7(C0403le c0403le, C0345j7 c0345j7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0403le() : c0403le, (i & 2) != 0 ? new C0345j7(null, 1, null) : c0345j7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0191d7 toModel(C0421m7 c0421m7) {
        Long l;
        EnumC0423m9 enumC0423m9;
        C0421m7 c0421m72 = new C0421m7();
        Integer valueOf = Integer.valueOf(c0421m7.f1113a);
        Integer num = valueOf.intValue() != c0421m72.f1113a ? valueOf : null;
        String str = c0421m7.b;
        String str2 = !Intrinsics.areEqual(str, c0421m72.b) ? str : null;
        String str3 = c0421m7.c;
        String str4 = !Intrinsics.areEqual(str3, c0421m72.c) ? str3 : null;
        Long valueOf2 = Long.valueOf(c0421m7.d);
        Long l2 = valueOf2.longValue() != c0421m72.d ? valueOf2 : null;
        C0320i7 model = this.b.toModel(c0421m7.e);
        String str5 = c0421m7.f;
        String str6 = !Intrinsics.areEqual(str5, c0421m72.f) ? str5 : null;
        String str7 = c0421m7.g;
        String str8 = !Intrinsics.areEqual(str7, c0421m72.g) ? str7 : null;
        Long valueOf3 = Long.valueOf(c0421m7.h);
        if (valueOf3.longValue() == c0421m72.h) {
            valueOf3 = null;
        }
        Integer valueOf4 = Integer.valueOf(c0421m7.i);
        Integer num2 = valueOf4.intValue() != c0421m72.i ? valueOf4 : null;
        Integer valueOf5 = Integer.valueOf(c0421m7.j);
        Integer num3 = valueOf5.intValue() != c0421m72.j ? valueOf5 : null;
        String str9 = c0421m7.k;
        String str10 = !Intrinsics.areEqual(str9, c0421m72.k) ? str9 : null;
        Integer valueOf6 = Integer.valueOf(c0421m7.l);
        if (valueOf6.intValue() == c0421m72.l) {
            valueOf6 = null;
        }
        I8 a2 = valueOf6 != null ? I8.a(Integer.valueOf(valueOf6.intValue())) : null;
        String str11 = c0421m7.m;
        String str12 = !Intrinsics.areEqual(str11, c0421m72.m) ? str11 : null;
        Integer valueOf7 = Integer.valueOf(c0421m7.n);
        if (valueOf7.intValue() == c0421m72.n) {
            valueOf7 = null;
        }
        EnumC0194da a3 = valueOf7 != null ? EnumC0194da.a(Integer.valueOf(valueOf7.intValue())) : null;
        Integer valueOf8 = Integer.valueOf(c0421m7.o);
        if (valueOf8.intValue() == c0421m72.o) {
            valueOf8 = null;
        }
        if (valueOf8 != null) {
            int intValue = valueOf8.intValue();
            EnumC0423m9[] values = EnumC0423m9.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    enumC0423m9 = values[i];
                    l = valueOf3;
                    if (enumC0423m9.f1115a == intValue) {
                        break;
                    }
                    i++;
                    valueOf3 = l;
                } else {
                    l = valueOf3;
                    enumC0423m9 = EnumC0423m9.NATIVE;
                    break;
                }
            }
        } else {
            l = valueOf3;
            enumC0423m9 = null;
        }
        Boolean a4 = this.f915a.a(c0421m7.p);
        Integer valueOf9 = Integer.valueOf(c0421m7.q);
        Integer num4 = valueOf9.intValue() != c0421m72.q ? valueOf9 : null;
        byte[] bArr = c0421m7.r;
        return new C0191d7(num, str2, str4, l2, model, str6, str8, l, num2, num3, str10, a2, str12, a3, enumC0423m9, a4, num4, !Arrays.equals(bArr, c0421m72.r) ? bArr : null);
    }
}
