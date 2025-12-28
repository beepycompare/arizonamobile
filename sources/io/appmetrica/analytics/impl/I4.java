package io.appmetrica.analytics.impl;

import java.util.Arrays;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
/* loaded from: classes5.dex */
public final class I4 implements Y6 {

    /* renamed from: a  reason: collision with root package name */
    public final String f617a;
    public final String b;

    public I4(R4 r4) {
        String b;
        if (r4.d()) {
            b = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
        } else {
            b = r4.b();
        }
        this.f617a = String.format("component_%s.db", Arrays.copyOf(new Object[]{b}, 1));
        this.b = "db_metrica_" + r4;
    }

    @Override // io.appmetrica.analytics.impl.Y6
    public final String a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.Y6
    public final String b() {
        return this.f617a;
    }
}
