package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class B7 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Ge f365a;
    public final J7 b;

    public B7() {
        this(null, null, 3, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final M7 fromModel(D7 d7) {
        M7 m7 = new M7();
        Integer num = d7.f405a;
        if (num != null) {
            m7.f574a = num.intValue();
        }
        String str = d7.b;
        if (str != null) {
            m7.b = StringUtils.correctIllFormedString(str);
        }
        String str2 = d7.c;
        if (str2 != null) {
            m7.c = StringUtils.correctIllFormedString(str2);
        }
        Long l = d7.d;
        if (l != null) {
            m7.d = l.longValue();
        }
        I7 i7 = d7.e;
        if (i7 != null) {
            m7.e = this.b.fromModel(i7);
        }
        String str3 = d7.f;
        if (str3 != null) {
            m7.f = str3;
        }
        String str4 = d7.g;
        if (str4 != null) {
            m7.g = str4;
        }
        Long l2 = d7.h;
        if (l2 != null) {
            m7.h = l2.longValue();
        }
        Integer num2 = d7.i;
        if (num2 != null) {
            m7.i = num2.intValue();
        }
        Integer num3 = d7.j;
        if (num3 != null) {
            m7.j = num3.intValue();
        }
        String str5 = d7.k;
        if (str5 != null) {
            m7.k = str5;
        }
        EnumC0273g9 enumC0273g9 = d7.l;
        if (enumC0273g9 != null) {
            m7.l = enumC0273g9.f893a;
        }
        String str6 = d7.m;
        if (str6 != null) {
            m7.m = str6;
        }
        Da da = d7.n;
        if (da != null) {
            m7.n = da.f408a;
        }
        M9 m9 = d7.o;
        if (m9 != null) {
            m7.o = m9.f576a;
        }
        Boolean bool = d7.p;
        if (bool != null) {
            m7.p = this.f365a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        Integer num4 = d7.q;
        if (num4 != null) {
            m7.q = num4.intValue();
        }
        byte[] bArr = d7.r;
        if (bArr != null) {
            m7.r = bArr;
        }
        return m7;
    }

    public B7(Ge ge, J7 j7) {
        this.f365a = ge;
        this.b = j7;
    }

    public /* synthetic */ B7(Ge ge, J7 j7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Ge() : ge, (i & 2) != 0 ? new J7(null, 1, null) : j7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final D7 toModel(M7 m7) {
        Long l;
        M9 m9;
        M7 m72 = new M7();
        Integer valueOf = Integer.valueOf(m7.f574a);
        Integer num = valueOf.intValue() != m72.f574a ? valueOf : null;
        String str = m7.b;
        String str2 = !Intrinsics.areEqual(str, m72.b) ? str : null;
        String str3 = m7.c;
        String str4 = !Intrinsics.areEqual(str3, m72.c) ? str3 : null;
        Long valueOf2 = Long.valueOf(m7.d);
        Long l2 = valueOf2.longValue() != m72.d ? valueOf2 : null;
        I7 model = this.b.toModel(m7.e);
        String str5 = m7.f;
        String str6 = !Intrinsics.areEqual(str5, m72.f) ? str5 : null;
        String str7 = m7.g;
        String str8 = !Intrinsics.areEqual(str7, m72.g) ? str7 : null;
        Long valueOf3 = Long.valueOf(m7.h);
        if (valueOf3.longValue() == m72.h) {
            valueOf3 = null;
        }
        Integer valueOf4 = Integer.valueOf(m7.i);
        Integer num2 = valueOf4.intValue() != m72.i ? valueOf4 : null;
        Integer valueOf5 = Integer.valueOf(m7.j);
        Integer num3 = valueOf5.intValue() != m72.j ? valueOf5 : null;
        String str9 = m7.k;
        String str10 = !Intrinsics.areEqual(str9, m72.k) ? str9 : null;
        Integer valueOf6 = Integer.valueOf(m7.l);
        if (valueOf6.intValue() == m72.l) {
            valueOf6 = null;
        }
        EnumC0273g9 a2 = valueOf6 != null ? EnumC0273g9.a(Integer.valueOf(valueOf6.intValue())) : null;
        String str11 = m7.m;
        String str12 = !Intrinsics.areEqual(str11, m72.m) ? str11 : null;
        Integer valueOf7 = Integer.valueOf(m7.n);
        if (valueOf7.intValue() == m72.n) {
            valueOf7 = null;
        }
        Da a3 = valueOf7 != null ? Da.a(Integer.valueOf(valueOf7.intValue())) : null;
        Integer valueOf8 = Integer.valueOf(m7.o);
        if (valueOf8.intValue() == m72.o) {
            valueOf8 = null;
        }
        if (valueOf8 != null) {
            int intValue = valueOf8.intValue();
            M9[] values = M9.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    m9 = values[i];
                    l = valueOf3;
                    if (m9.f576a == intValue) {
                        break;
                    }
                    i++;
                    valueOf3 = l;
                } else {
                    l = valueOf3;
                    m9 = M9.NATIVE;
                    break;
                }
            }
        } else {
            l = valueOf3;
            m9 = null;
        }
        Boolean a4 = this.f365a.a(m7.p);
        Integer valueOf9 = Integer.valueOf(m7.q);
        Integer num4 = valueOf9.intValue() != m72.q ? valueOf9 : null;
        byte[] bArr = m7.r;
        return new D7(num, str2, str4, l2, model, str6, str8, l, num2, num3, str10, a2, str12, a3, m9, a4, num4, !Arrays.equals(bArr, m72.r) ? bArr : null);
    }
}
