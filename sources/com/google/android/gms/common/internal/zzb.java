package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@18.9.0 */
/* loaded from: classes4.dex */
public final class zzb extends com.google.android.gms.internal.common.zzg {
    final /* synthetic */ BaseGmsClient zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzb(BaseGmsClient baseGmsClient, Looper looper) {
        super(looper);
        java.util.Objects.requireNonNull(baseGmsClient);
        this.zza = baseGmsClient;
    }

    private static final void zza(Message message) {
        zzc zzcVar = (zzc) message.obj;
        if (zzcVar != null) {
            zzcVar.zze();
        }
    }

    private static final boolean zzb(Message message) {
        return message.what == 2 || message.what == 1 || message.what == 7;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        BaseGmsClient baseGmsClient = this.zza;
        if (baseGmsClient.zzd.get() != message.arg1) {
            if (zzb(message)) {
                zza(message);
            }
        } else if ((message.what != 1 && message.what != 7 && ((message.what != 4 || baseGmsClient.enableLocalFallback()) && message.what != 5)) || baseGmsClient.isConnecting()) {
            if (message.what == 4) {
                baseGmsClient.zzn(new ConnectionResult(message.arg2));
                if (!baseGmsClient.zzg() || baseGmsClient.zzo()) {
                    ConnectionResult zzm = baseGmsClient.zzm() != null ? baseGmsClient.zzm() : new ConnectionResult(8);
                    baseGmsClient.zzc.onReportServiceBinding(zzm);
                    baseGmsClient.onConnectionFailed(zzm);
                    return;
                }
                baseGmsClient.zzd(3, null);
            } else if (message.what == 5) {
                ConnectionResult zzm2 = baseGmsClient.zzm() != null ? baseGmsClient.zzm() : new ConnectionResult(8);
                baseGmsClient.zzc.onReportServiceBinding(zzm2);
                baseGmsClient.onConnectionFailed(zzm2);
            } else if (message.what == 3) {
                ConnectionResult connectionResult = new ConnectionResult(message.arg2, message.obj instanceof PendingIntent ? (PendingIntent) message.obj : null);
                baseGmsClient.zzc.onReportServiceBinding(connectionResult);
                baseGmsClient.onConnectionFailed(connectionResult);
            } else if (message.what == 6) {
                baseGmsClient.zzd(5, null);
                if (baseGmsClient.zzk() != null) {
                    baseGmsClient.zzk().onConnectionSuspended(message.arg2);
                }
                baseGmsClient.onConnectionSuspended(message.arg2);
                baseGmsClient.zze(5, 1, null);
            } else if (message.what != 2 || baseGmsClient.isConnected()) {
                if (zzb(message)) {
                    ((zzc) message.obj).zzd();
                    return;
                }
                int i = message.what;
                StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 34);
                sb.append("Don't know how to handle message: ");
                sb.append(i);
                Log.wtf("GmsClient", sb.toString(), new Exception());
            } else {
                zza(message);
            }
        } else {
            zza(message);
        }
    }
}
