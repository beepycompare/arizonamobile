package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.zn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0765zn implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Gl f1186a;

    public C0765zn() {
        this(new Gl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0673w6 fromModel(C0740yn c0740yn) {
        C0673w6 c0673w6 = new C0673w6();
        Integer num = c0740yn.e;
        c0673w6.e = num == null ? -1 : num.intValue();
        c0673w6.d = c0740yn.d;
        c0673w6.b = c0740yn.b;
        c0673w6.f1116a = c0740yn.f1166a;
        c0673w6.c = c0740yn.c;
        Gl gl = this.f1186a;
        List<StackTraceElement> list = c0740yn.f;
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : list) {
            arrayList.add(new Il(stackTraceElement));
        }
        c0673w6.f = gl.fromModel(arrayList);
        return c0673w6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0673w6 c0673w6 = (C0673w6) obj;
        throw new UnsupportedOperationException();
    }

    public C0765zn(Gl gl) {
        this.f1186a = gl;
    }

    public final C0740yn a(C0673w6 c0673w6) {
        throw new UnsupportedOperationException();
    }
}
