package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashSource;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
/* renamed from: io.appmetrica.analytics.impl.ee  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0222ee implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public static final C0197de f965a = new C0197de();
    public static final Map b = MapsKt.mapOf(TuplesKt.to(NativeCrashSource.UNKNOWN, 0), TuplesKt.to(NativeCrashSource.CRASHPAD, 3));

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0395l6 fromModel(C0377ke c0377ke) {
        C0395l6 c0395l6 = new C0395l6();
        c0395l6.f = 1;
        C0369k6 c0369k6 = new C0369k6();
        c0369k6.f1065a = c0377ke.f1066a;
        C0473o6 c0473o6 = new C0473o6();
        Integer num = (Integer) b.get(c0377ke.b.f1016a);
        if (num != null) {
            c0473o6.f1128a = num.intValue();
        }
        String str = c0377ke.b.b;
        if (str == null) {
            str = "";
        }
        c0473o6.b = str;
        c0369k6.b = c0473o6;
        c0395l6.g = c0369k6;
        return c0395l6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0395l6 c0395l6 = (C0395l6) obj;
        throw new UnsupportedOperationException();
    }

    public final C0377ke a(C0395l6 c0395l6) {
        throw new UnsupportedOperationException();
    }
}
