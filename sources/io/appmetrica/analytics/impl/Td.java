package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashSource;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* loaded from: classes4.dex */
public final class Td implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public static final Sd f653a = new Sd();
    public static final Map b = MapsKt.mapOf(TuplesKt.to(NativeCrashSource.UNKNOWN, 0), TuplesKt.to(NativeCrashSource.CRASHPAD, 3));

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0550r6 fromModel(Zd zd) {
        C0550r6 c0550r6 = new C0550r6();
        c0550r6.f = 1;
        C0526q6 c0526q6 = new C0526q6();
        c0526q6.f1015a = zd.f749a;
        C0625u6 c0625u6 = new C0625u6();
        Integer num = (Integer) b.get(zd.b.f703a);
        if (num != null) {
            c0625u6.f1079a = num.intValue();
        }
        String str = zd.b.b;
        if (str == null) {
            str = "";
        }
        c0625u6.b = str;
        c0526q6.b = c0625u6;
        c0550r6.g = c0526q6;
        return c0550r6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0550r6 c0550r6 = (C0550r6) obj;
        throw new UnsupportedOperationException();
    }

    public final Zd a(C0550r6 c0550r6) {
        throw new UnsupportedOperationException();
    }
}
