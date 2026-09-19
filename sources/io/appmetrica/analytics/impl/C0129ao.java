package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.ao  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0129ao implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0205dm f895a;

    public C0129ao() {
        this(new C0205dm());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0525q6 fromModel(Zn zn) {
        C0525q6 c0525q6 = new C0525q6();
        Integer num = zn.e;
        c0525q6.e = num == null ? -1 : num.intValue();
        c0525q6.d = zn.d;
        c0525q6.b = zn.b;
        c0525q6.f1163a = zn.f877a;
        c0525q6.c = zn.c;
        C0205dm c0205dm = this.f895a;
        List<StackTraceElement> list = zn.f;
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : list) {
            arrayList.add(new C0256fm(stackTraceElement));
        }
        c0525q6.f = c0205dm.fromModel(arrayList);
        return c0525q6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0525q6 c0525q6 = (C0525q6) obj;
        throw new UnsupportedOperationException();
    }

    public C0129ao(C0205dm c0205dm) {
        this.f895a = c0205dm;
    }

    public final Zn a(C0525q6 c0525q6) {
        throw new UnsupportedOperationException();
    }
}
