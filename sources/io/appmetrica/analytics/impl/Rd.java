package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashSource;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* loaded from: classes4.dex */
public final class Rd implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public static final Qd f609a = new Qd();
    public static final Map b = MapsKt.mapOf(TuplesKt.to(NativeCrashSource.UNKNOWN, 0), TuplesKt.to(NativeCrashSource.CRASHPAD, 3));

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0474o6 fromModel(Xd xd) {
        C0474o6 c0474o6 = new C0474o6();
        c0474o6.f = 1;
        C0449n6 c0449n6 = new C0449n6();
        c0449n6.f953a = xd.f706a;
        C0548r6 c0548r6 = new C0548r6();
        Integer num = (Integer) b.get(xd.b.f660a);
        if (num != null) {
            c0548r6.f1021a = num.intValue();
        }
        String str = xd.b.b;
        if (str == null) {
            str = "";
        }
        c0548r6.b = str;
        c0449n6.b = c0548r6;
        c0474o6.g = c0449n6;
        return c0474o6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0474o6 c0474o6 = (C0474o6) obj;
        throw new UnsupportedOperationException();
    }

    public final Xd a(C0474o6 c0474o6) {
        throw new UnsupportedOperationException();
    }
}
