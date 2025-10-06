package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashSource;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* loaded from: classes4.dex */
public final class Zd implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public static final Yd f774a = new Yd();
    public static final Map b = MapsKt.mapOf(TuplesKt.to(NativeCrashSource.UNKNOWN, 0), TuplesKt.to(NativeCrashSource.CRASHPAD, 3));

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0628u6 fromModel(C0253fe c0253fe) {
        C0628u6 c0628u6 = new C0628u6();
        c0628u6.f = 1;
        C0603t6 c0603t6 = new C0603t6();
        c0603t6.f1092a = c0253fe.f879a;
        C0703x6 c0703x6 = new C0703x6();
        Integer num = (Integer) b.get(c0253fe.b.f825a);
        if (num != null) {
            c0703x6.f1151a = num.intValue();
        }
        String str = c0253fe.b.b;
        if (str == null) {
            str = "";
        }
        c0703x6.b = str;
        c0603t6.b = c0703x6;
        c0628u6.g = c0603t6;
        return c0628u6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0628u6 c0628u6 = (C0628u6) obj;
        throw new UnsupportedOperationException();
    }

    public final C0253fe a(C0628u6 c0628u6) {
        throw new UnsupportedOperationException();
    }
}
