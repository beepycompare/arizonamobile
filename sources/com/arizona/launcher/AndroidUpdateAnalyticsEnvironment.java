package com.arizona.launcher;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UpdateAnalyticsReporter.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011Ê\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/AndroidUpdateAnalyticsEnvironment;", "Lcom/arizona/launcher/UpdateAnalyticsEnvironment;", "context", "Landroid/content/Context;", "currentServerUrl", "Lkotlin/Function0;", "", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "applicationContext", "kotlin.jvm.PlatformType", "defaultServerUrl", "getDefaultServerUrl", "()Ljava/lang/String;", "internetCapable", "", "getInternetCapable", "()Z", "networkValidated", "getNetworkValidated", "activeNetworkCapabilities", "Landroid/net/NetworkCapabilities;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AndroidUpdateAnalyticsEnvironment implements UpdateAnalyticsEnvironment {
    public static final int $stable = 8;
    private final Context applicationContext;
    private final Function0<String> currentServerUrl;

    public AndroidUpdateAnalyticsEnvironment(Context context, Function0<String> currentServerUrl) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(currentServerUrl, "currentServerUrl");
        this.currentServerUrl = currentServerUrl;
        this.applicationContext = context.getApplicationContext();
    }

    @Override // com.arizona.launcher.UpdateAnalyticsEnvironment
    public String getDefaultServerUrl() {
        return this.currentServerUrl.invoke();
    }

    @Override // com.arizona.launcher.UpdateAnalyticsEnvironment
    public boolean getInternetCapable() {
        NetworkCapabilities activeNetworkCapabilities = activeNetworkCapabilities();
        return activeNetworkCapabilities != null && activeNetworkCapabilities.hasCapability(12);
    }

    @Override // com.arizona.launcher.UpdateAnalyticsEnvironment
    public boolean getNetworkValidated() {
        NetworkCapabilities activeNetworkCapabilities = activeNetworkCapabilities();
        return activeNetworkCapabilities != null && activeNetworkCapabilities.hasCapability(16);
    }

    private final NetworkCapabilities activeNetworkCapabilities() {
        Network activeNetwork;
        Object systemService = this.applicationContext.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null) {
            return null;
        }
        return connectivityManager.getNetworkCapabilities(activeNetwork);
    }
}
