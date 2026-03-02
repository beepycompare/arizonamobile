package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
import io.appmetrica.analytics.idsync.internal.model.IdSyncConfig;
import io.appmetrica.analytics.idsync.internal.model.RequestConfig;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.idsync.impl.f  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0102f extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f467a;

    public C0102f(h hVar) {
        this.f467a = hVar;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        IdSyncConfig idSyncConfig;
        if (this.f467a.f && (idSyncConfig = this.f467a.e) != null) {
            this.f467a.getClass();
            if (h.a(idSyncConfig)) {
                List<RequestConfig> requests = idSyncConfig.getRequests();
                h hVar = this.f467a;
                for (RequestConfig requestConfig : requests) {
                    hVar.d.a(requestConfig);
                }
                h hVar2 = this.f467a;
                IHandlerExecutor iHandlerExecutor = hVar2.c;
                C0102f c0102f = hVar2.g;
                if (c0102f == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("syncRunnable");
                    c0102f = null;
                }
                iHandlerExecutor.executeDelayed(c0102f, this.f467a.b);
            }
        }
    }
}
