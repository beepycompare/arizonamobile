package com.arizona.launcher;

import kotlin.Metadata;
/* compiled from: UpdateAnalyticsReporter.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/UpdateAnalyticsEnvironment;", "", "defaultServerUrl", "", "getDefaultServerUrl", "()Ljava/lang/String;", "internetCapable", "", "getInternetCapable", "()Z", "networkValidated", "getNetworkValidated", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface UpdateAnalyticsEnvironment {
    String getDefaultServerUrl();

    boolean getInternetCapable();

    boolean getNetworkValidated();
}
