package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashSource;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* loaded from: classes4.dex */
public final class Zd implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public static final Yd f769a = new Yd();
    public static final Map b = MapsKt.mapOf(TuplesKt.to(NativeCrashSource.UNKNOWN, 0), TuplesKt.to(NativeCrashSource.CRASHPAD, 3));

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0627u6 fromModel(C0252fe c0252fe) {
        C0627u6 c0627u6 = new C0627u6();
        c0627u6.f = 1;
        C0602t6 c0602t6 = new C0602t6();
        c0602t6.f1087a = c0252fe.f874a;
        C0702x6 c0702x6 = new C0702x6();
        Integer num = (Integer) b.get(c0252fe.b.f820a);
        if (num != null) {
            c0702x6.f1146a = num.intValue();
        }
        String str = c0252fe.b.b;
        if (str == null) {
            str = "";
        }
        c0702x6.b = str;
        c0602t6.b = c0702x6;
        c0627u6.g = c0602t6;
        return c0627u6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0627u6 c0627u6 = (C0627u6) obj;
        throw new UnsupportedOperationException();
    }

    public final C0252fe a(C0627u6 c0627u6) {
        throw new UnsupportedOperationException();
    }
}
