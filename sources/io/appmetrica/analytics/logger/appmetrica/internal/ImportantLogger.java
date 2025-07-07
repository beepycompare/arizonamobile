package io.appmetrica.analytics.logger.appmetrica.internal;

import io.appmetrica.analytics.logger.common.BaseImportantLogger;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lio/appmetrica/analytics/logger/appmetrica/internal/ImportantLogger;", "Lio/appmetrica/analytics/logger/common/BaseImportantLogger;", "logger_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes4.dex */
public final class ImportantLogger extends BaseImportantLogger {
    public static final ImportantLogger INSTANCE = new ImportantLogger();

    private ImportantLogger() {
        super("AppMetrica");
    }
}
