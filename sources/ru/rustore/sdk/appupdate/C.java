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
import ru.rustore.sdk.appupdate.model.AppUpdateInfo;
import ru.rustore.sdk.reactive.single.SingleEmitter;
/* loaded from: classes6.dex */
public final class C extends Lambda implements Function1<SingleEmitter<Integer>, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0801r f1480a;
    public final /* synthetic */ AppUpdateInfo b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(C0801r c0801r, AppUpdateInfo appUpdateInfo) {
        super(1);
        this.f1480a = c0801r;
        this.b = appUpdateInfo;
    }

    public final void a(final SingleEmitter<Integer> emitter) {
        Object m10199constructorimpl;
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        C0801r c0801r = this.f1480a;
        AppUpdateInfo appUpdateInfo = this.b;
        try {
            Result.Companion companion = Result.Companion;
            Context context = c0801r.f1538a;
            Intent intent = new Intent("ru.vk.store.FlexibleAppUpdate");
            c0801r.b.getClass();
            intent.putExtras(C0798o.a(appUpdateInfo));
            ContextExtensionKt.openActivityForResult(context, intent, new OnReceiveResultCallback() { // from class: ru.rustore.sdk.appupdate.C$$ExternalSyntheticLambda0
                @Override // ru.rustore.sdk.activitylauncher.OnReceiveResultCallback
                public final void onReceiveResult(ActivityLauncherResult activityLauncherResult, Bundle bundle) {
                    C.a(SingleEmitter.this, activityLauncherResult, bundle);
                }
            });
            appUpdateInfo.markIsUsed$sdk_public_appupdate_release();
            m10199constructorimpl = Result.m10199constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m10199constructorimpl = Result.m10199constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m10202exceptionOrNullimpl = Result.m10202exceptionOrNullimpl(m10199constructorimpl);
        if (m10202exceptionOrNullimpl != null) {
            emitter.error(m10202exceptionOrNullimpl);
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
