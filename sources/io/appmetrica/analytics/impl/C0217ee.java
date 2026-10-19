package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashSource;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* renamed from: io.appmetrica.analytics.impl.ee  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0217ee implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public static final C0192de f968a = new C0192de();
    public static final Map b = MapsKt.mapOf(TuplesKt.to(NativeCrashSource.UNKNOWN, 0), TuplesKt.to(NativeCrashSource.CRASHPAD, 3));

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0390l6 fromModel(C0372ke c0372ke) {
        C0390l6 c0390l6 = new C0390l6();
        c0390l6.f = 1;
        C0364k6 c0364k6 = new C0364k6();
        c0364k6.f1068a = c0372ke.f1069a;
        C0468o6 c0468o6 = new C0468o6();
        Integer num = (Integer) b.get(c0372ke.b.f1019a);
        if (num != null) {
            c0468o6.f1131a = num.intValue();
        }
        String str = c0372ke.b.b;
        if (str == null) {
            str = "";
        }
        c0468o6.b = str;
        c0364k6.b = c0468o6;
        c0390l6.g = c0364k6;
        return c0390l6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0390l6 c0390l6 = (C0390l6) obj;
        throw new UnsupportedOperationException();
    }

    public final C0372ke a(C0390l6 c0390l6) {
        throw new UnsupportedOperationException();
    }
}
