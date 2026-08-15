package com.arizona.launcher.updater.apk;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;
/* compiled from: LauncherApkNetworkSecurity.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u000b\u0012\b\b\f\u0012\u0004\b\u0003\u0010\u0002¨\u0006\n"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkNetworkGuardInterceptor;", "Lokhttp3/Interceptor;", "policy", "Lcom/arizona/launcher/updater/apk/LauncherApkNetworkPolicy;", "<init>", "(Lcom/arizona/launcher/updater/apk/LauncherApkNetworkPolicy;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LauncherApkNetworkGuardInterceptor implements Interceptor {
    public static final int $stable = 0;
    private final LauncherApkNetworkPolicy policy;

    public LauncherApkNetworkGuardInterceptor(LauncherApkNetworkPolicy policy) {
        Intrinsics.checkNotNullParameter(policy, "policy");
        this.policy = policy;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        if (!this.policy.isAllowed(chain.request().url())) {
            throw new UnsafeLauncherApkUrlException(chain.request().url().toString());
        }
        return chain.proceed(chain.request());
    }
}
