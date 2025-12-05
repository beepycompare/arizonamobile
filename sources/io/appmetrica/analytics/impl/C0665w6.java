package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.w6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0665w6 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Fg f1264a;

    public C0665w6() {
        this(new Fg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Y5 fromModel(C0640v6 c0640v6) {
        Y5 fromModel = this.f1264a.fromModel(c0640v6.f1246a);
        fromModel.g = 1;
        X5 x5 = new X5();
        fromModel.h = x5;
        x5.f830a = StringUtils.correctIllFormedString(c0640v6.b);
        return fromModel;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Y5 y5 = (Y5) obj;
        throw new UnsupportedOperationException();
    }

    public C0665w6(Fg fg) {
        this.f1264a = fg;
    }

    public final C0640v6 a(Y5 y5) {
        throw new UnsupportedOperationException();
    }
}
