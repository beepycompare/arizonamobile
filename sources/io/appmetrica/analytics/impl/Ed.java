package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashSource;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* loaded from: classes5.dex */
public final class Ed implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public static final Dd f567a = new Dd();
    public static final Map b = MapsKt.mapOf(TuplesKt.to(NativeCrashSource.UNKNOWN, 0), TuplesKt.to(NativeCrashSource.CRASHPAD, 3));

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final V5 fromModel(Kd kd) {
        V5 v5 = new V5();
        v5.f = 1;
        U5 u5 = new U5();
        u5.f807a = kd.f657a;
        Y5 y5 = new Y5();
        Integer num = (Integer) b.get(kd.b.f612a);
        if (num != null) {
            y5.f861a = num.intValue();
        }
        String str = kd.b.b;
        if (str == null) {
            str = "";
        }
        y5.b = str;
        u5.b = y5;
        v5.g = u5;
        return v5;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        V5 v5 = (V5) obj;
        throw new UnsupportedOperationException();
    }

    public final Kd a(V5 v5) {
        throw new UnsupportedOperationException();
    }
}
