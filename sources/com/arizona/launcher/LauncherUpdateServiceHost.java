package com.arizona.launcher;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import kotlin.Metadata;
/* compiled from: LauncherUpdateServiceFlow.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\b`\u0018\u00002\u00020\u0001J\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u000bH&J \u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H&J\b\u0010\u0010\u001a\u00020\u0007H&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\b\u0010\u0013\u001a\u00020\u000bH&J/\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007H&¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0003H&J2\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 H&J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#H&¨\u0006$À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/LauncherUpdateServiceHost;", "", "beginLauncherCheckOperation", "", "()Ljava/lang/Long;", "beginLauncherApkOperation", "isCurrentLauncherCheckOperation", "", "token", "isCurrentLauncherApkOperation", "setLauncherOperationHealthy", "", "completeLauncherCheck", "operationToken", "needsUpdate", FirebaseAnalytics.Param.SUCCESS, "promoteLauncherForeground", "externalFilesRoot", "Ljava/io/File;", "beginLauncherProgress", "updateLauncherProgress", "downloadedBytes", "totalBytes", "attempt", "", "resumed", "(JLjava/lang/Long;IZ)V", "completeLauncherProgress", "completeLauncherApk", "markServerUnreachable", "deferResult", "failedServer", "", "recordLauncherException", "error", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface LauncherUpdateServiceHost {
    Long beginLauncherApkOperation();

    Long beginLauncherCheckOperation();

    void beginLauncherProgress();

    void completeLauncherApk(long j, boolean z, boolean z2, boolean z3, String str);

    void completeLauncherCheck(long j, boolean z, boolean z2);

    void completeLauncherProgress(long j);

    File externalFilesRoot();

    boolean isCurrentLauncherApkOperation(long j);

    boolean isCurrentLauncherCheckOperation(long j);

    boolean promoteLauncherForeground();

    void recordLauncherException(Throwable th);

    void setLauncherOperationHealthy();

    void updateLauncherProgress(long j, Long l, int i, boolean z);
}
