package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
import io.appmetrica.analytics.idsync.internal.model.IdSyncConfig;
import io.appmetrica.analytics.idsync.internal.model.RequestConfig;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.idsync.impl.f  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0104f extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f423a;

    public C0104f(h hVar) {
        this.f423a = hVar;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        IdSyncConfig idSyncConfig;
        if (this.f423a.f && (idSyncConfig = this.f423a.e) != null) {
            this.f423a.getClass();
            if (h.a(idSyncConfig)) {
                List<RequestConfig> requests = idSyncConfig.getRequests();
                h hVar = this.f423a;
                for (RequestConfig requestConfig : requests) {
                    hVar.d.a(requestConfig);
                }
                h hVar2 = this.f423a;
                IHandlerExecutor iHandlerExecutor = hVar2.c;
                C0104f c0104f = hVar2.g;
                if (c0104f == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("syncRunnable");
                    c0104f = null;
                }
                iHandlerExecutor.executeDelayed(c0104f, this.f423a.b);
            }
        }
    }
}
