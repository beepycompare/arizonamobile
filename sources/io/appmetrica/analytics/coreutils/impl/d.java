package io.appmetrica.analytics.coreutils.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManagerHelperForR;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes5.dex */
public final class d extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f337a;
    public final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, String str) {
        super(0);
        this.f337a = context;
        this.b = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        PackageManager packageManager = this.f337a.getPackageManager();
        boolean isApiAchieved = AndroidUtils.isApiAchieved(30);
        String str = this.b;
        if (isApiAchieved) {
            return SafePackageManagerHelperForR.extractPackageInstaller(packageManager, str);
        }
        return packageManager.getInstallerPackageName(str);
    }
}
