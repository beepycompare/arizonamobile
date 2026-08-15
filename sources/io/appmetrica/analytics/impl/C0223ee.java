package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashSource;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* renamed from: io.appmetrica.analytics.impl.ee  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0223ee implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public static final C0198de f965a = new C0198de();
    public static final Map b = MapsKt.mapOf(TuplesKt.to(NativeCrashSource.UNKNOWN, 0), TuplesKt.to(NativeCrashSource.CRASHPAD, 3));

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0396l6 fromModel(C0378ke c0378ke) {
        C0396l6 c0396l6 = new C0396l6();
        c0396l6.f = 1;
        C0370k6 c0370k6 = new C0370k6();
        c0370k6.f1065a = c0378ke.f1066a;
        C0474o6 c0474o6 = new C0474o6();
        Integer num = (Integer) b.get(c0378ke.b.f1016a);
        if (num != null) {
            c0474o6.f1128a = num.intValue();
        }
        String str = c0378ke.b.b;
        if (str == null) {
            str = "";
        }
        c0474o6.b = str;
        c0370k6.b = c0474o6;
        c0396l6.g = c0370k6;
        return c0396l6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0396l6 c0396l6 = (C0396l6) obj;
        throw new UnsupportedOperationException();
    }

    public final C0378ke a(C0396l6 c0396l6) {
        throw new UnsupportedOperationException();
    }
}
