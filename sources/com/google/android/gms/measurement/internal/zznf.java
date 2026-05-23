package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import androidx.media3.extractor.ts.TsExtractor;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zznf implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zznl zza;
    private volatile boolean zzb;
    private volatile zzgo zzc;

    /* JADX INFO: Access modifiers changed from: protected */
    public zznf(zznl zznlVar) {
        Objects.requireNonNull(zznlVar);
        this.zza = zznlVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.zza.zzu.zzaX().zzd();
        synchronized (this) {
            try {
                Preconditions.checkNotNull(this.zzc);
                this.zza.zzu.zzaX().zzj(new zzna(this, (zzgb) this.zzc.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.zzc = null;
                this.zzb = false;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zznl zznlVar = this.zza;
        zznlVar.zzu.zzaX().zzd();
        zzgu zzf = zznlVar.zzu.zzf();
        if (zzf != null) {
            zzf.zzk().zzb("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.zzb = false;
            this.zzc = null;
        }
        this.zza.zzu.zzaX().zzj(new zzne(this, connectionResult));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        zzic zzicVar = this.zza.zzu;
        zzicVar.zzaX().zzd();
        zzicVar.zzaW().zzj().zza("Service connection suspended");
        zzicVar.zzaX().zzj(new zznb(this));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzgb zzfzVar;
        this.zza.zzu.zzaX().zzd();
        synchronized (this) {
            if (iBinder != null) {
                zzgb zzgbVar = null;
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                        if (queryLocalInterface instanceof zzgb) {
                            zzfzVar = (zzgb) queryLocalInterface;
                        } else {
                            zzfzVar = new zzfz(iBinder);
                        }
                        zzgbVar = zzfzVar;
                        this.zza.zzu.zzaW().zzk().zza("Bound to IMeasurementService interface");
                    } else {
                        this.zza.zzu.zzaW().zzb().zzb("Got binder with a wrong descriptor", interfaceDescriptor);
                    }
                } catch (RemoteException unused) {
                    this.zza.zzu.zzaW().zzb().zza("Service connect failed to get IMeasurementService");
                }
                if (zzgbVar == null) {
                    this.zzb = false;
                    try {
                        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
                        zznl zznlVar = this.zza;
                        connectionTracker.unbindService(zznlVar.zzu.zzaZ(), zznlVar.zzY());
                    } catch (IllegalArgumentException unused2) {
                    }
                } else {
                    this.zza.zzu.zzaX().zzj(new zzmy(this, zzgbVar));
                }
                return;
            }
            this.zzb = false;
            this.zza.zzu.zzaW().zzb().zza("Service connected with null binder");
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzic zzicVar = this.zza.zzu;
        zzicVar.zzaX().zzd();
        zzicVar.zzaW().zzj().zza("Service disconnected");
        zzicVar.zzaX().zzj(new zzmz(this, componentName));
    }

    public final void zza(Intent intent) {
        zznl zznlVar = this.zza;
        zznlVar.zzg();
        Context zzaZ = zznlVar.zzu.zzaZ();
        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
        synchronized (this) {
            boolean z = this.zzb;
            zznl zznlVar2 = this.zza;
            if (z) {
                zznlVar2.zzu.zzaW().zzk().zza("Connection attempt already in progress");
                return;
            }
            zznlVar2.zzu.zzaW().zzk().zza("Using local app measurement service");
            this.zzb = true;
            connectionTracker.bindService(zzaZ, intent, zznlVar2.zzY(), TsExtractor.TS_STREAM_TYPE_AC3);
        }
    }

    public final void zzb() {
        if (this.zzc != null && (this.zzc.isConnected() || this.zzc.isConnecting())) {
            this.zzc.disconnect();
        }
        this.zzc = null;
    }

    public final void zzc() {
        zznl zznlVar = this.zza;
        zznlVar.zzg();
        Context zzaZ = zznlVar.zzu.zzaZ();
        synchronized (this) {
            if (this.zzb) {
                this.zza.zzu.zzaW().zzk().zza("Connection attempt already in progress");
            } else if (this.zzc != null && (this.zzc.isConnecting() || this.zzc.isConnected())) {
                this.zza.zzu.zzaW().zzk().zza("Already awaiting connection attempt");
            } else {
                this.zzc = new zzgo(zzaZ, Looper.getMainLooper(), this, this);
                this.zza.zzu.zzaW().zzk().zza("Connecting to remote service");
                this.zzb = true;
                Preconditions.checkNotNull(this.zzc);
                this.zzc.checkAvailabilityAndConnect();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(boolean z) {
        this.zzb = false;
    }
}
