package io.appmetrica.analytics.reporterextension.internal;

import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import io.appmetrica.analytics.modulesapi.internal.client.ModuleClientEntryPoint;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u001a\u0010\f\u001a\u00020\u00078\u0016X\u0096D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lio/appmetrica/analytics/reporterextension/internal/ReporterExtensionClientModuleEntryPoint;", "Lio/appmetrica/analytics/modulesapi/internal/client/ModuleClientEntryPoint;", "", "Lio/appmetrica/analytics/modulesapi/internal/client/ClientContext;", "clientContext", "", "initClientSide", "", "b", "Ljava/lang/String;", "getIdentifier", "()Ljava/lang/String;", "identifier", "<init>", "()V", "reporter-extension_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes4.dex */
public final class ReporterExtensionClientModuleEntryPoint extends ModuleClientEntryPoint<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final long f1268a = 10;
    private final String b = "reporter_extension";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ClientContext clientContext) {
        clientContext.getClientActivator().activate(clientContext.getContext());
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ModuleClientEntryPoint
    public String getIdentifier() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ModuleClientEntryPoint
    public void initClientSide(final ClientContext clientContext) {
        super.initClientSide(clientContext);
        if (clientContext.getProcessDetector().isMainProcess()) {
            clientContext.getClientExecutorProvider().getDefaultExecutor().executeDelayed(new Runnable() { // from class: io.appmetrica.analytics.reporterextension.internal.ReporterExtensionClientModuleEntryPoint$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ReporterExtensionClientModuleEntryPoint.a(ClientContext.this);
                }
            }, this.f1268a, TimeUnit.SECONDS);
        }
    }
}
