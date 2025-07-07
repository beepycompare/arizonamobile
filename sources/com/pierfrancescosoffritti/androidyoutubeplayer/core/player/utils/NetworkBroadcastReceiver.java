package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NetworkObserver.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/utils/NetworkBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "onNetworkAvailable", "Lkotlin/Function0;", "", "onNetworkUnavailable", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "onReceive", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
final class NetworkBroadcastReceiver extends BroadcastReceiver {
    private final Function0<Unit> onNetworkAvailable;
    private final Function0<Unit> onNetworkUnavailable;

    public NetworkBroadcastReceiver(Function0<Unit> onNetworkAvailable, Function0<Unit> onNetworkUnavailable) {
        Intrinsics.checkNotNullParameter(onNetworkAvailable, "onNetworkAvailable");
        Intrinsics.checkNotNullParameter(onNetworkUnavailable, "onNetworkUnavailable");
        this.onNetworkAvailable = onNetworkAvailable;
        this.onNetworkUnavailable = onNetworkUnavailable;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean isConnectedToInternet;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        isConnectedToInternet = NetworkObserverKt.isConnectedToInternet(context);
        if (isConnectedToInternet) {
            this.onNetworkAvailable.invoke();
        } else {
            this.onNetworkUnavailable.invoke();
        }
    }
}
