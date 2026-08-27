package ru.rustore.sdk.appupdate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.activitylauncher.ActivityLauncherResult;
import ru.rustore.sdk.activitylauncher.ContextExtensionKt;
import ru.rustore.sdk.activitylauncher.OnReceiveResultCallback;
import ru.rustore.sdk.appupdate.errors.RuStoreInstallException;
import ru.rustore.sdk.core.exception.RuStoreNotInstalledException;
import ru.rustore.sdk.core.exception.RuStoreOutdatedException;
import ru.rustore.sdk.core.util.RuStoreUtils;
import ru.rustore.sdk.reactive.single.SingleEmitter;
/* loaded from: classes6.dex */
public final class D extends Lambda implements Function1<SingleEmitter<Unit>, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0796r f1439a;
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D(C0796r c0796r, int i) {
        super(1);
        this.f1439a = c0796r;
        this.b = i;
    }

    public final void a(final SingleEmitter<Unit> emitter) {
        Object m9919constructorimpl;
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        C0796r c0796r = this.f1439a;
        int i = this.b;
        try {
            Result.Companion companion = Result.Companion;
            if (!RuStoreUtils.INSTANCE.isRuStoreInstalled(c0796r.f1496a)) {
                emitter.error(new RuStoreNotInstalledException());
            }
            Context context = c0796r.f1496a;
            Intent intent = new Intent("ru.vk.store.FlexibleAppUpdate");
            intent.putExtra("RUN_INSTALL", true);
            intent.putExtra("PACKAGE_NAME", c0796r.f1496a.getPackageName());
            intent.putExtra("AppUpdateType", i);
            ContextExtensionKt.openActivityForResult(context, intent, new OnReceiveResultCallback() { // from class: ru.rustore.sdk.appupdate.D$$ExternalSyntheticLambda0
                @Override // ru.rustore.sdk.activitylauncher.OnReceiveResultCallback
                public final void onReceiveResult(ActivityLauncherResult activityLauncherResult, Bundle bundle) {
                    D.a(SingleEmitter.this, activityLauncherResult, bundle);
                }
            });
            m9919constructorimpl = Result.m9919constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9919constructorimpl = Result.m9919constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m9922exceptionOrNullimpl = Result.m9922exceptionOrNullimpl(m9919constructorimpl);
        if (m9922exceptionOrNullimpl != null) {
            emitter.error(m9922exceptionOrNullimpl);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(SingleEmitter<Unit> singleEmitter) {
        a(singleEmitter);
        return Unit.INSTANCE;
    }

    public static final void a(SingleEmitter emitter, ActivityLauncherResult launcherResult, Bundle bundle) {
        Intrinsics.checkNotNullParameter(emitter, "$emitter");
        Intrinsics.checkNotNullParameter(launcherResult, "launcherResult");
        if (Intrinsics.areEqual(launcherResult, ActivityLauncherResult.ActivityNotFound.INSTANCE)) {
            emitter.error(new RuStoreOutdatedException());
            return;
        }
        if (launcherResult instanceof ActivityLauncherResult.ActivityResultUnknown ? true : Intrinsics.areEqual(launcherResult, ActivityLauncherResult.ActivitySendIntentError.INSTANCE) ? true : Intrinsics.areEqual(launcherResult, ActivityLauncherResult.ActivityUnknownError.INSTANCE)) {
            emitter.error(new RuStoreInstallException(launcherResult.getCode()));
            return;
        }
        if (Intrinsics.areEqual(launcherResult, ActivityLauncherResult.ActivityResultOk.INSTANCE) ? true : Intrinsics.areEqual(launcherResult, ActivityLauncherResult.ActivityResultCanceled.INSTANCE)) {
            emitter.success(Unit.INSTANCE);
        }
    }
}
