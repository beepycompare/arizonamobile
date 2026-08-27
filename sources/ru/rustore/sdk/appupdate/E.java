package ru.rustore.sdk.appupdate;

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
import ru.rustore.sdk.appupdate.model.AppUpdateInfo;
import ru.rustore.sdk.reactive.single.SingleEmitter;
/* loaded from: classes6.dex */
public final class E extends Lambda implements Function1<SingleEmitter<Integer>, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0796r f1440a;
    public final /* synthetic */ AppUpdateInfo b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E(C0796r c0796r, AppUpdateInfo appUpdateInfo) {
        super(1);
        this.f1440a = c0796r;
        this.b = appUpdateInfo;
    }

    public final void a(final SingleEmitter<Integer> emitter) {
        Object m9919constructorimpl;
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        C0796r c0796r = this.f1440a;
        AppUpdateInfo appUpdateInfo = this.b;
        try {
            Result.Companion companion = Result.Companion;
            ContextExtensionKt.openActivityForResult(c0796r.f1496a, new Intent("ru.vk.store.AnyAppForceUpdateActivity"), new OnReceiveResultCallback() { // from class: ru.rustore.sdk.appupdate.E$$ExternalSyntheticLambda0
                @Override // ru.rustore.sdk.activitylauncher.OnReceiveResultCallback
                public final void onReceiveResult(ActivityLauncherResult activityLauncherResult, Bundle bundle) {
                    E.a(SingleEmitter.this, activityLauncherResult, bundle);
                }
            });
            appUpdateInfo.markIsUsed$sdk_public_appupdate_release();
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
    public final /* bridge */ /* synthetic */ Unit invoke(SingleEmitter<Integer> singleEmitter) {
        a(singleEmitter);
        return Unit.INSTANCE;
    }

    public static final void a(SingleEmitter emitter, ActivityLauncherResult launcherResult, Bundle bundle) {
        Intrinsics.checkNotNullParameter(emitter, "$emitter");
        Intrinsics.checkNotNullParameter(launcherResult, "launcherResult");
        if (launcherResult instanceof ActivityLauncherResult.ActivityResultUnknown ? true : Intrinsics.areEqual(launcherResult, ActivityLauncherResult.ActivitySendIntentError.INSTANCE) ? true : Intrinsics.areEqual(launcherResult, ActivityLauncherResult.ActivityUnknownError.INSTANCE) ? true : Intrinsics.areEqual(launcherResult, ActivityLauncherResult.ActivityNotFound.INSTANCE)) {
            emitter.error(new RuStoreInstallException(launcherResult.getCode()));
            return;
        }
        if (Intrinsics.areEqual(launcherResult, ActivityLauncherResult.ActivityResultCanceled.INSTANCE) ? true : Intrinsics.areEqual(launcherResult, ActivityLauncherResult.ActivityResultOk.INSTANCE)) {
            emitter.success(Integer.valueOf(launcherResult.getCode()));
        }
    }
}
