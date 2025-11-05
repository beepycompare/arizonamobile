package io.appmetrica.analytics.impl;

import java.util.Arrays;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
/* loaded from: classes3.dex */
public final class O4 implements InterfaceC0212e7 {

    /* renamed from: a  reason: collision with root package name */
    public final String f616a;
    public final String b;

    public O4(X4 x4) {
        String b;
        if (x4.d()) {
            b = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
        } else {
            b = x4.b();
        }
        this.f616a = String.format("component_%s.db", Arrays.copyOf(new Object[]{b}, 1));
        this.b = "db_metrica_" + x4;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0212e7
    public final String a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0212e7
    public final String b() {
        return this.f616a;
    }
}
