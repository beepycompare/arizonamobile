package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* renamed from: io.appmetrica.analytics.impl.nm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0468nm {

    /* renamed from: a  reason: collision with root package name */
    public final ProtobufStateStorage f1009a;
    public final Co b;

    public C0468nm(ProtobufStateStorage protobufStateStorage, Co co) {
        this.f1009a = protobufStateStorage;
        this.b = co;
    }

    public C0468nm(Context context) {
        this(Zm.a(C0594sm.class).a(context), Na.j().B().a());
    }
}
