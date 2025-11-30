package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.im  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0330im implements InterfaceC0408lm {

    /* renamed from: a  reason: collision with root package name */
    public volatile C0279gm f945a;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();

    @Override // io.appmetrica.analytics.impl.InterfaceC0408lm
    public final void a(C0279gm c0279gm) {
        this.f945a = c0279gm;
        for (InterfaceC0408lm interfaceC0408lm : this.b) {
            interfaceC0408lm.a(c0279gm);
        }
    }

    public final C0279gm b() {
        C0279gm c0279gm = this.f945a;
        if (c0279gm == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startupState");
            return null;
        }
        return c0279gm;
    }

    public final void b(InterfaceC0408lm interfaceC0408lm) {
        this.b.remove(interfaceC0408lm);
    }

    public final void a(InterfaceC0408lm interfaceC0408lm) {
        this.b.add(interfaceC0408lm);
        if (this.f945a != null) {
            C0279gm c0279gm = this.f945a;
            if (c0279gm == null) {
                Intrinsics.throwUninitializedPropertyAccessException("startupState");
                c0279gm = null;
            }
            interfaceC0408lm.a(c0279gm);
        }
    }

    public final void a(Context context) {
        String optStringOrNull;
        ProtobufStateStorage<Object> create = ((Sm) Qm.a(C0382km.class)).create(context);
        xo a2 = C0471oa.k().D().a();
        synchronized (a2) {
            optStringOrNull = JsonUtils.optStringOrNull(a2.f1206a.a(), "device_id");
        }
        a(new C0279gm(optStringOrNull, a2.a(), (C0382km) create.read()));
    }
}
