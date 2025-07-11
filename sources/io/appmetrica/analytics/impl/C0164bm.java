package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* renamed from: io.appmetrica.analytics.impl.bm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0164bm {

    /* renamed from: a  reason: collision with root package name */
    public final ProtobufStateStorage f773a;
    public final qo b;

    public C0164bm(ProtobufStateStorage protobufStateStorage, qo qoVar) {
        this.f773a = protobufStateStorage;
        this.b = qoVar;
    }

    public C0164bm(Context context) {
        this(Nm.a(C0291gm.class).a(context), Ga.j().B().a());
    }
}
