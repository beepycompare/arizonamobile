package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.im  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0329im implements InterfaceC0407lm {

    /* renamed from: a  reason: collision with root package name */
    public volatile C0278gm f1043a;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();

    @Override // io.appmetrica.analytics.impl.InterfaceC0407lm
    public final void a(C0278gm c0278gm) {
        this.f1043a = c0278gm;
        for (InterfaceC0407lm interfaceC0407lm : this.b) {
            interfaceC0407lm.a(c0278gm);
        }
    }

    public final C0278gm b() {
        C0278gm c0278gm = this.f1043a;
        if (c0278gm == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startupState");
            return null;
        }
        return c0278gm;
    }

    public final void b(InterfaceC0407lm interfaceC0407lm) {
        this.b.remove(interfaceC0407lm);
    }

    public final void a(InterfaceC0407lm interfaceC0407lm) {
        this.b.add(interfaceC0407lm);
        if (this.f1043a != null) {
            C0278gm c0278gm = this.f1043a;
            if (c0278gm == null) {
                Intrinsics.throwUninitializedPropertyAccessException("startupState");
                c0278gm = null;
            }
            interfaceC0407lm.a(c0278gm);
        }
    }

    public final void a(Context context) {
        String optStringOrNull;
        ProtobufStateStorage<Object> create = ((Sm) Qm.a(C0381km.class)).create(context);
        xo a2 = C0470oa.k().D().a();
        synchronized (a2) {
            optStringOrNull = JsonUtils.optStringOrNull(a2.f1304a.a(), "device_id");
        }
        a(new C0278gm(optStringOrNull, a2.a(), (C0381km) create.read()));
    }
}
