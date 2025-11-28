package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashSource;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* loaded from: classes5.dex */
public final class Ld implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public static final Kd f574a = new Kd();
    public static final Map b = MapsKt.mapOf(TuplesKt.to(NativeCrashSource.UNKNOWN, 0), TuplesKt.to(NativeCrashSource.CRASHPAD, 3));

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0160c6 fromModel(Rd rd) {
        C0160c6 c0160c6 = new C0160c6();
        c0160c6.f = 1;
        C0134b6 c0134b6 = new C0134b6();
        c0134b6.f813a = rd.f665a;
        C0237f6 c0237f6 = new C0237f6();
        Integer num = (Integer) b.get(rd.b.f619a);
        if (num != null) {
            c0237f6.f871a = num.intValue();
        }
        String str = rd.b.b;
        if (str == null) {
            str = "";
        }
        c0237f6.b = str;
        c0134b6.b = c0237f6;
        c0160c6.g = c0134b6;
        return c0160c6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0160c6 c0160c6 = (C0160c6) obj;
        throw new UnsupportedOperationException();
    }

    public final Rd a(C0160c6 c0160c6) {
        throw new UnsupportedOperationException();
    }
}
