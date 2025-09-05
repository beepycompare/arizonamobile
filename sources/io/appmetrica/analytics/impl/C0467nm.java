package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* renamed from: io.appmetrica.analytics.impl.nm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0467nm {

    /* renamed from: a  reason: collision with root package name */
    public final ProtobufStateStorage f1004a;
    public final Co b;

    public C0467nm(ProtobufStateStorage protobufStateStorage, Co co) {
        this.f1004a = protobufStateStorage;
        this.b = co;
    }

    public C0467nm(Context context) {
        this(Zm.a(C0593sm.class).a(context), Na.j().B().a());
    }
}
