package ru.rustore.sdk.appupdate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.appupdate.model.InstallState;
/* loaded from: classes6.dex */
public final class S extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final Q f1368a;

    public S(Q installStateProvider) {
        Intrinsics.checkNotNullParameter(installStateProvider, "installStateProvider");
        this.f1368a = installStateProvider;
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
        Q q = this.f1368a;
        q.getClass();
        Intrinsics.checkNotNullParameter(state, "state");
        q.f1367a.setValue(state);
    }
}
