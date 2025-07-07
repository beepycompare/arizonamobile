package ru.rustore.sdk.appupdate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.appupdate.model.InstallState;
/* loaded from: classes5.dex */
public final class a0 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final z f1327a;

    public a0(z installStateProvider) {
        Intrinsics.checkNotNullParameter(installStateProvider, "installStateProvider");
        this.f1327a = installStateProvider;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        InstallState state;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras == null || (state = InstallState.Companion.of$sdk_public_appupdate_release(extras)) == null) {
            return;
        }
        z zVar = this.f1327a;
        zVar.getClass();
        Intrinsics.checkNotNullParameter(state, "state");
        zVar.f1368a.setValue(state);
    }
}
