package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.x7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0702x7 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Ae f1132a;
    public final F7 b;

    public C0702x7() {
        this(null, null, 3, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final I7 fromModel(C0752z7 c0752z7) {
        I7 i7 = new I7();
        Integer num = c0752z7.f1165a;
        if (num != null) {
            i7.f486a = num.intValue();
        }
        String str = c0752z7.b;
        if (str != null) {
            i7.b = StringUtils.correctIllFormedString(str);
        }
        String str2 = c0752z7.c;
        if (str2 != null) {
            i7.c = StringUtils.correctIllFormedString(str2);
        }
        Long l = c0752z7.d;
        if (l != null) {
            i7.d = l.longValue();
        }
        E7 e7 = c0752z7.e;
        if (e7 != null) {
            i7.e = this.b.fromModel(e7);
        }
        String str3 = c0752z7.f;
        if (str3 != null) {
            i7.f = str3;
        }
        String str4 = c0752z7.g;
        if (str4 != null) {
            i7.g = str4;
        }
        Long l2 = c0752z7.h;
        if (l2 != null) {
            i7.h = l2.longValue();
        }
        Integer num2 = c0752z7.i;
        if (num2 != null) {
            i7.i = num2.intValue();
        }
        Integer num3 = c0752z7.j;
        if (num3 != null) {
            i7.j = num3.intValue();
        }
        String str5 = c0752z7.k;
        if (str5 != null) {
            i7.k = str5;
        }
        EnumC0152b9 enumC0152b9 = c0752z7.l;
        if (enumC0152b9 != null) {
            i7.l = enumC0152b9.f780a;
        }
        String str6 = c0752z7.m;
        if (str6 != null) {
            i7.m = str6;
        }
        EnumC0730ya enumC0730ya = c0752z7.n;
        if (enumC0730ya != null) {
            i7.n = enumC0730ya.f1152a;
        }
        H9 h9 = c0752z7.o;
        if (h9 != null) {
            i7.o = h9.f469a;
        }
        Boolean bool = c0752z7.p;
        if (bool != null) {
            i7.p = this.f1132a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        Integer num4 = c0752z7.q;
        if (num4 != null) {
            i7.q = num4.intValue();
        }
        byte[] bArr = c0752z7.r;
        if (bArr != null) {
            i7.r = bArr;
        }
        return i7;
    }

    public C0702x7(Ae ae, F7 f7) {
        this.f1132a = ae;
        this.b = f7;
    }

    public /* synthetic */ C0702x7(Ae ae, F7 f7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Ae() : ae, (i & 2) != 0 ? new F7(null, 1, null) : f7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0752z7 toModel(I7 i7) {
        Long l;
        H9 h9;
        I7 i72 = new I7();
        Integer valueOf = Integer.valueOf(i7.f486a);
        Integer num = valueOf.intValue() != i72.f486a ? valueOf : null;
        String str = i7.b;
        String str2 = !Intrinsics.areEqual(str, i72.b) ? str : null;
        String str3 = i7.c;
        String str4 = !Intrinsics.areEqual(str3, i72.c) ? str3 : null;
        Long valueOf2 = Long.valueOf(i7.d);
        Long l2 = valueOf2.longValue() != i72.d ? valueOf2 : null;
        E7 model = this.b.toModel(i7.e);
        String str5 = i7.f;
        String str6 = !Intrinsics.areEqual(str5, i72.f) ? str5 : null;
        String str7 = i7.g;
        String str8 = !Intrinsics.areEqual(str7, i72.g) ? str7 : null;
        Long valueOf3 = Long.valueOf(i7.h);
        if (valueOf3.longValue() == i72.h) {
            valueOf3 = null;
        }
        Integer valueOf4 = Integer.valueOf(i7.i);
        Integer num2 = valueOf4.intValue() != i72.i ? valueOf4 : null;
        Integer valueOf5 = Integer.valueOf(i7.j);
        Integer num3 = valueOf5.intValue() != i72.j ? valueOf5 : null;
        String str9 = i7.k;
        String str10 = !Intrinsics.areEqual(str9, i72.k) ? str9 : null;
        Integer valueOf6 = Integer.valueOf(i7.l);
        if (valueOf6.intValue() == i72.l) {
            valueOf6 = null;
        }
        EnumC0152b9 a2 = valueOf6 != null ? EnumC0152b9.a(Integer.valueOf(valueOf6.intValue())) : null;
        String str11 = i7.m;
        String str12 = !Intrinsics.areEqual(str11, i72.m) ? str11 : null;
        Integer valueOf7 = Integer.valueOf(i7.n);
        if (valueOf7.intValue() == i72.n) {
            valueOf7 = null;
        }
        EnumC0730ya a3 = valueOf7 != null ? EnumC0730ya.a(Integer.valueOf(valueOf7.intValue())) : null;
        Integer valueOf8 = Integer.valueOf(i7.o);
        if (valueOf8.intValue() == i72.o) {
            valueOf8 = null;
        }
        if (valueOf8 != null) {
            int intValue = valueOf8.intValue();
            H9[] values = H9.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    h9 = values[i];
                    l = valueOf3;
                    if (h9.f469a == intValue) {
                        break;
                    }
                    i++;
                    valueOf3 = l;
                } else {
                    l = valueOf3;
                    h9 = H9.NATIVE;
                    break;
                }
            }
        } else {
            l = valueOf3;
            h9 = null;
        }
        Boolean a4 = this.f1132a.a(i7.p);
        Integer valueOf9 = Integer.valueOf(i7.q);
        Integer num4 = valueOf9.intValue() != i72.q ? valueOf9 : null;
        byte[] bArr = i7.r;
        return new C0752z7(num, str2, str4, l2, model, str6, str8, l, num2, num3, str10, a2, str12, a3, h9, a4, num4, !Arrays.equals(bArr, i72.r) ? bArr : null);
    }
}
