package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashSource;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* renamed from: io.appmetrica.analytics.impl.ee  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0224ee implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public static final C0199de f965a = new C0199de();
    public static final Map b = MapsKt.mapOf(TuplesKt.to(NativeCrashSource.UNKNOWN, 0), TuplesKt.to(NativeCrashSource.CRASHPAD, 3));

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0397l6 fromModel(C0379ke c0379ke) {
        C0397l6 c0397l6 = new C0397l6();
        c0397l6.f = 1;
        C0371k6 c0371k6 = new C0371k6();
        c0371k6.f1065a = c0379ke.f1066a;
        C0475o6 c0475o6 = new C0475o6();
        Integer num = (Integer) b.get(c0379ke.b.f1016a);
        if (num != null) {
            c0475o6.f1128a = num.intValue();
        }
        String str = c0379ke.b.b;
        if (str == null) {
            str = "";
        }
        c0475o6.b = str;
        c0371k6.b = c0475o6;
        c0397l6.g = c0371k6;
        return c0397l6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0397l6 c0397l6 = (C0397l6) obj;
        throw new UnsupportedOperationException();
    }

    public final C0379ke a(C0397l6 c0397l6) {
        throw new UnsupportedOperationException();
    }
}
