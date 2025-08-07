package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashSource;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* loaded from: classes4.dex */
public final class Td implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public static final Sd f652a = new Sd();
    public static final Map b = MapsKt.mapOf(TuplesKt.to(NativeCrashSource.UNKNOWN, 0), TuplesKt.to(NativeCrashSource.CRASHPAD, 3));

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0551r6 fromModel(Zd zd) {
        C0551r6 c0551r6 = new C0551r6();
        c0551r6.f = 1;
        C0527q6 c0527q6 = new C0527q6();
        c0527q6.f1014a = zd.f748a;
        C0626u6 c0626u6 = new C0626u6();
        Integer num = (Integer) b.get(zd.b.f702a);
        if (num != null) {
            c0626u6.f1078a = num.intValue();
        }
        String str = zd.b.b;
        if (str == null) {
            str = "";
        }
        c0626u6.b = str;
        c0527q6.b = c0626u6;
        c0551r6.g = c0527q6;
        return c0551r6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0551r6 c0551r6 = (C0551r6) obj;
        throw new UnsupportedOperationException();
    }

    public final Zd a(C0551r6 c0551r6) {
        throw new UnsupportedOperationException();
    }
}
