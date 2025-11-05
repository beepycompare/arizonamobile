package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes3.dex */
public final class M implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Y f1342a;

    public M() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final S fromModel(J j) {
        S s = new S();
        s.f1347a = j.f1339a;
        W w = j.b;
        s.b = w != null ? this.f1342a.fromModel(w) : null;
        return s;
    }

    public M(Y y) {
        this.f1342a = y;
    }

    public /* synthetic */ M(Y y, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Y(null, null, null, 7, null) : y);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final J toModel(S s) {
        return new J(s.f1347a, this.f1342a.toModel(s.b));
    }
}
