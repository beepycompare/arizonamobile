package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashSource;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* loaded from: classes4.dex */
public final class Vd implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public static final Ud f694a = new Ud();
    public static final Map b = MapsKt.mapOf(TuplesKt.to(NativeCrashSource.UNKNOWN, 0), TuplesKt.to(NativeCrashSource.CRASHPAD, 3));

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0548r6 fromModel(C0149be c0149be) {
        C0548r6 c0548r6 = new C0548r6();
        c0548r6.f = 1;
        C0524q6 c0524q6 = new C0524q6();
        c0524q6.f1022a = c0149be.f794a;
        C0623u6 c0623u6 = new C0623u6();
        Integer num = (Integer) b.get(c0149be.b.f742a);
        if (num != null) {
            c0623u6.f1083a = num.intValue();
        }
        String str = c0149be.b.b;
        if (str == null) {
            str = "";
        }
        c0623u6.b = str;
        c0524q6.b = c0623u6;
        c0548r6.g = c0524q6;
        return c0548r6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0548r6 c0548r6 = (C0548r6) obj;
        throw new UnsupportedOperationException();
    }

    public final C0149be a(C0548r6 c0548r6) {
        throw new UnsupportedOperationException();
    }
}
