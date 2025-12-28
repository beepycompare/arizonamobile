package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* renamed from: io.appmetrica.analytics.impl.fm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0252fm {

    /* renamed from: a  reason: collision with root package name */
    public final ProtobufStateStorage f994a;
    public final xo b;

    public C0252fm(ProtobufStateStorage protobufStateStorage, xo xoVar) {
        this.f994a = protobufStateStorage;
        this.b = xoVar;
    }

    public C0252fm(Context context) {
        this(((Sm) Qm.a(C0381km.class)).create(context), C0470oa.k().D().a());
    }
}
