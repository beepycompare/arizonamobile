package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.y7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0724y7 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Ce f1153a;
    public final G7 b;

    public C0724y7() {
        this(null, null, 3, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final J7 fromModel(A7 a7) {
        J7 j7 = new J7();
        Integer num = a7.f341a;
        if (num != null) {
            j7.f511a = num.intValue();
        }
        String str = a7.b;
        if (str != null) {
            j7.b = StringUtils.correctIllFormedString(str);
        }
        String str2 = a7.c;
        if (str2 != null) {
            j7.c = StringUtils.correctIllFormedString(str2);
        }
        Long l = a7.d;
        if (l != null) {
            j7.d = l.longValue();
        }
        F7 f7 = a7.e;
        if (f7 != null) {
            j7.e = this.b.fromModel(f7);
        }
        String str3 = a7.f;
        if (str3 != null) {
            j7.f = str3;
        }
        String str4 = a7.g;
        if (str4 != null) {
            j7.g = str4;
        }
        Long l2 = a7.h;
        if (l2 != null) {
            j7.h = l2.longValue();
        }
        Integer num2 = a7.i;
        if (num2 != null) {
            j7.i = num2.intValue();
        }
        Integer num3 = a7.j;
        if (num3 != null) {
            j7.j = num3.intValue();
        }
        String str5 = a7.k;
        if (str5 != null) {
            j7.k = str5;
        }
        EnumC0196d9 enumC0196d9 = a7.l;
        if (enumC0196d9 != null) {
            j7.l = enumC0196d9.f827a;
        }
        String str6 = a7.m;
        if (str6 != null) {
            j7.m = str6;
        }
        Aa aa = a7.n;
        if (aa != null) {
            j7.n = aa.f344a;
        }
        J9 j9 = a7.o;
        if (j9 != null) {
            j7.o = j9.f513a;
        }
        Boolean bool = a7.p;
        if (bool != null) {
            j7.p = this.f1153a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        Integer num4 = a7.q;
        if (num4 != null) {
            j7.q = num4.intValue();
        }
        byte[] bArr = a7.r;
        if (bArr != null) {
            j7.r = bArr;
        }
        return j7;
    }

    public C0724y7(Ce ce, G7 g7) {
        this.f1153a = ce;
        this.b = g7;
    }

    public /* synthetic */ C0724y7(Ce ce, G7 g7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Ce() : ce, (i & 2) != 0 ? new G7(null, 1, null) : g7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final A7 toModel(J7 j7) {
        Long l;
        J9 j9;
        J7 j72 = new J7();
        Integer valueOf = Integer.valueOf(j7.f511a);
        Integer num = valueOf.intValue() != j72.f511a ? valueOf : null;
        String str = j7.b;
        String str2 = !Intrinsics.areEqual(str, j72.b) ? str : null;
        String str3 = j7.c;
        String str4 = !Intrinsics.areEqual(str3, j72.c) ? str3 : null;
        Long valueOf2 = Long.valueOf(j7.d);
        Long l2 = valueOf2.longValue() != j72.d ? valueOf2 : null;
        F7 model = this.b.toModel(j7.e);
        String str5 = j7.f;
        String str6 = !Intrinsics.areEqual(str5, j72.f) ? str5 : null;
        String str7 = j7.g;
        String str8 = !Intrinsics.areEqual(str7, j72.g) ? str7 : null;
        Long valueOf3 = Long.valueOf(j7.h);
        if (valueOf3.longValue() == j72.h) {
            valueOf3 = null;
        }
        Integer valueOf4 = Integer.valueOf(j7.i);
        Integer num2 = valueOf4.intValue() != j72.i ? valueOf4 : null;
        Integer valueOf5 = Integer.valueOf(j7.j);
        Integer num3 = valueOf5.intValue() != j72.j ? valueOf5 : null;
        String str9 = j7.k;
        String str10 = !Intrinsics.areEqual(str9, j72.k) ? str9 : null;
        Integer valueOf6 = Integer.valueOf(j7.l);
        if (valueOf6.intValue() == j72.l) {
            valueOf6 = null;
        }
        EnumC0196d9 a2 = valueOf6 != null ? EnumC0196d9.a(Integer.valueOf(valueOf6.intValue())) : null;
        String str11 = j7.m;
        String str12 = !Intrinsics.areEqual(str11, j72.m) ? str11 : null;
        Integer valueOf7 = Integer.valueOf(j7.n);
        if (valueOf7.intValue() == j72.n) {
            valueOf7 = null;
        }
        Aa a3 = valueOf7 != null ? Aa.a(Integer.valueOf(valueOf7.intValue())) : null;
        Integer valueOf8 = Integer.valueOf(j7.o);
        if (valueOf8.intValue() == j72.o) {
            valueOf8 = null;
        }
        if (valueOf8 != null) {
            int intValue = valueOf8.intValue();
            J9[] values = J9.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    j9 = values[i];
                    l = valueOf3;
                    if (j9.f513a == intValue) {
                        break;
                    }
                    i++;
                    valueOf3 = l;
                } else {
                    l = valueOf3;
                    j9 = J9.NATIVE;
                    break;
                }
            }
        } else {
            l = valueOf3;
            j9 = null;
        }
        Boolean a4 = this.f1153a.a(j7.p);
        Integer valueOf9 = Integer.valueOf(j7.q);
        Integer num4 = valueOf9.intValue() != j72.q ? valueOf9 : null;
        byte[] bArr = j7.r;
        return new A7(num, str2, str4, l2, model, str6, str8, l, num2, num3, str10, a2, str12, a3, j9, a4, num4, !Arrays.equals(bArr, j72.r) ? bArr : null);
    }
}
