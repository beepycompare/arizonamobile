package io.appmetrica.analytics.impl;

import java.util.Arrays;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
/* loaded from: classes5.dex */
public final class H4 implements X6 {

    /* renamed from: a  reason: collision with root package name */
    public final String f608a;
    public final String b;

    public H4(Q4 q4) {
        String b;
        if (q4.d()) {
            b = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
        } else {
            b = q4.b();
        }
        this.f608a = String.format("component_%s.db", Arrays.copyOf(new Object[]{b}, 1));
        this.b = "db_metrica_" + q4;
    }

    @Override // io.appmetrica.analytics.impl.X6
    public final String a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.X6
    public final String b() {
        return this.f608a;
    }
}
