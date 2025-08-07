package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* renamed from: io.appmetrica.analytics.impl.em  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0242em {

    /* renamed from: a  reason: collision with root package name */
    public final ProtobufStateStorage f834a;
    public final to b;

    public C0242em(ProtobufStateStorage protobufStateStorage, to toVar) {
        this.f834a = protobufStateStorage;
        this.b = toVar;
    }

    public C0242em(Context context) {
        this(Qm.a(C0368jm.class).a(context), Ia.j().B().a());
    }
}
