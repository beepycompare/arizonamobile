package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashSource;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* loaded from: classes5.dex */
public final class Fd implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public static final Ed f577a = new Ed();
    public static final Map b = MapsKt.mapOf(TuplesKt.to(NativeCrashSource.UNKNOWN, 0), TuplesKt.to(NativeCrashSource.CRASHPAD, 3));

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final W5 fromModel(Ld ld) {
        W5 w5 = new W5();
        w5.f = 1;
        V5 v5 = new V5();
        v5.f817a = ld.f667a;
        Z5 z5 = new Z5();
        Integer num = (Integer) b.get(ld.b.f621a);
        if (num != null) {
            z5.f871a = num.intValue();
        }
        String str = ld.b.b;
        if (str == null) {
            str = "";
        }
        z5.b = str;
        v5.b = z5;
        w5.g = v5;
        return w5;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        W5 w5 = (W5) obj;
        throw new UnsupportedOperationException();
    }

    public final Ld a(W5 w5) {
        throw new UnsupportedOperationException();
    }
}
