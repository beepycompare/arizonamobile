package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* renamed from: io.appmetrica.analytics.impl.fm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0253fm {

    /* renamed from: a  reason: collision with root package name */
    public final ProtobufStateStorage f896a;
    public final xo b;

    public C0253fm(ProtobufStateStorage protobufStateStorage, xo xoVar) {
        this.f896a = protobufStateStorage;
        this.b = xoVar;
    }

    public C0253fm(Context context) {
        this(((Sm) Qm.a(C0382km.class)).create(context), C0471oa.k().D().a());
    }
}
