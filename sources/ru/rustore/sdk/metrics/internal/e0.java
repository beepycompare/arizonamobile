package ru.rustore.sdk.metrics.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes6.dex */
public final class e0 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1583a;
    public final Lazy b;

    /* loaded from: classes6.dex */
    public static final class a extends Lambda implements Function0<d0> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final d0 invoke() {
            Object m9843constructorimpl;
            String value;
            e0 e0Var = e0.this;
            try {
                Result.Companion companion = Result.Companion;
                PackageManager packageManager = e0Var.f1583a.getPackageManager();
                Intrinsics.checkNotNullExpressionValue(packageManager, "context.packageManager");
                String packageName = e0Var.f1583a.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
                value = f0.a(packageManager, packageName).versionName;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m9843constructorimpl = Result.m9843constructorimpl(ResultKt.createFailure(th));
            }
            if (value != null) {
                Intrinsics.checkNotNullExpressionValue(value, "requireNotNull(context.p…packageName).versionName)");
                Intrinsics.checkNotNullParameter(value, "value");
                m9843constructorimpl = Result.m9843constructorimpl(new d0(value));
                if (Result.m9849isFailureimpl(m9843constructorimpl)) {
                    m9843constructorimpl = null;
                }
                d0 d0Var = (d0) m9843constructorimpl;
                String str = d0Var != null ? d0Var.f1582a : null;
                if (str != null) {
                    return new d0(str);
                }
                return null;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public e0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f1583a = context;
        this.b = LazyKt.lazy(new a());
    }
}
