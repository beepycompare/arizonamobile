package com.arizona.launcher;

import java.util.Set;
import kotlin.Metadata;
/* compiled from: UpdateAnalyticsReporter.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J\u0016\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J\b\u0010\u000b\u001a\u00020\tH&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/UpdateFirstLaunchStore;", "", "isFirstStart", "", "isErrorSessionActive", "reportedErrorCodes", "", "", "saveReportedErrorCodes", "", "codes", "finishErrorSession", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface UpdateFirstLaunchStore {
    void finishErrorSession();

    boolean isErrorSessionActive();

    boolean isFirstStart();

    Set<String> reportedErrorCodes();

    void saveReportedErrorCodes(Set<String> set);
}
