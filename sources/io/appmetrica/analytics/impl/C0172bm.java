package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* renamed from: io.appmetrica.analytics.impl.bm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0172bm {

    /* renamed from: a  reason: collision with root package name */
    public final ProtobufStateStorage f772a;
    public final qo b;

    public C0172bm(ProtobufStateStorage protobufStateStorage, qo qoVar) {
        this.f772a = protobufStateStorage;
        this.b = qoVar;
    }

    public C0172bm(Context context) {
        this(Nm.a(C0299gm.class).a(context), Ga.j().B().a());
    }
}
