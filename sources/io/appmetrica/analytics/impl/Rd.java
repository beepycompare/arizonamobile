package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashSource;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* loaded from: classes4.dex */
public final class Rd implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public static final Qd f608a = new Qd();
    public static final Map b = MapsKt.mapOf(TuplesKt.to(NativeCrashSource.UNKNOWN, 0), TuplesKt.to(NativeCrashSource.CRASHPAD, 3));

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0482o6 fromModel(Xd xd) {
        C0482o6 c0482o6 = new C0482o6();
        c0482o6.f = 1;
        C0457n6 c0457n6 = new C0457n6();
        c0457n6.f952a = xd.f705a;
        C0556r6 c0556r6 = new C0556r6();
        Integer num = (Integer) b.get(xd.b.f659a);
        if (num != null) {
            c0556r6.f1020a = num.intValue();
        }
        String str = xd.b.b;
        if (str == null) {
            str = "";
        }
        c0556r6.b = str;
        c0457n6.b = c0556r6;
        c0482o6.g = c0457n6;
        return c0482o6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0482o6 c0482o6 = (C0482o6) obj;
        throw new UnsupportedOperationException();
    }

    public final Xd a(C0482o6 c0482o6) {
        throw new UnsupportedOperationException();
    }
}
