package io.appmetrica.analytics.billinginterface.internal.library;

import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoManager;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoSender;
import io.appmetrica.analytics.billinginterface.internal.update.UpdatePolicy;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public interface UtilsProvider {
    BillingInfoManager getBillingInfoManager();

    BillingInfoSender getBillingInfoSender();

    Executor getUiExecutor();

    UpdatePolicy getUpdatePolicy();

    Executor getWorkerExecutor();
}
