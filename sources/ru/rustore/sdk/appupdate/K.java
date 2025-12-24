package ru.rustore.sdk.appupdate;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes6.dex */
public final class K {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1502a;
    public final Lazy b;

    /* loaded from: classes6.dex */
    public static final class a extends Lambda implements Function0<String> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Object m10216constructorimpl;
            K k = K.this;
            try {
                Result.Companion companion = Result.Companion;
                PackageManager packageManager = k.f1502a.getPackageManager();
                Intrinsics.checkNotNullExpressionValue(packageManager, "context.packageManager");
                String packageName = k.f1502a.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
                m10216constructorimpl = Result.m10216constructorimpl(K.a(k, packageManager, packageName).versionName);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m10216constructorimpl = Result.m10216constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m10222isFailureimpl(m10216constructorimpl)) {
                m10216constructorimpl = null;
            }
            return (String) m10216constructorimpl;
        }
    }

    public K(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f1502a = context;
        this.b = LazyKt.lazy(new a());
    }

    public static final PackageInfo a(K k, PackageManager packageManager, String str) {
        PackageInfo packageInfo;
        String str2;
        if (Build.VERSION.SDK_INT >= 33) {
            packageInfo = packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of(0L));
            str2 = "{\n            getPackage…nfoFlags.of(0))\n        }";
        } else {
            packageInfo = packageManager.getPackageInfo(str, 0);
            str2 = "{\n            getPackage…packageName, 0)\n        }";
        }
        Intrinsics.checkNotNullExpressionValue(packageInfo, str2);
        return packageInfo;
    }
}
