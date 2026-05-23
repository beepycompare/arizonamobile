package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
public final class zan implements Handler.Callback {
    private final zam zab;
    private final Handler zah;
    private final ArrayList zac = new ArrayList();
    final ArrayList zaa = new ArrayList();
    private final ArrayList zad = new ArrayList();
    private volatile boolean zae = false;
    private final AtomicInteger zaf = new AtomicInteger(0);
    private boolean zag = false;
    private final Object zai = new Object();

    public zan(Looper looper, zam zamVar) {
        this.zab = zamVar;
        this.zah = new com.google.android.gms.internal.base.zao(looper, this);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) message.obj;
            synchronized (this.zai) {
                if (this.zae && this.zab.isConnected() && this.zac.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(null);
                }
            }
            return true;
        }
        int i = message.what;
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 34);
        sb.append("Don't know how to handle message: ");
        sb.append(i);
        Log.wtf("GmsClientEvents", sb.toString(), new Exception());
        return false;
    }

    public final void zaa() {
        this.zae = false;
        this.zaf.incrementAndGet();
    }

    public final void zab() {
        this.zae = true;
    }

    public final void zac(Bundle bundle) {
        Handler handler = this.zah;
        Preconditions.checkHandlerThread(handler, "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.zai) {
            Preconditions.checkState(!this.zag);
            handler.removeMessages(1);
            this.zag = true;
            ArrayList arrayList = this.zaa;
            Preconditions.checkState(arrayList.isEmpty());
            ArrayList arrayList2 = new ArrayList(this.zac);
            AtomicInteger atomicInteger = this.zaf;
            int i = atomicInteger.get();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it.next();
                if (!this.zae || !this.zab.isConnected() || atomicInteger.get() != i) {
                    break;
                } else if (!arrayList.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(bundle);
                }
            }
            arrayList.clear();
            this.zag = false;
        }
    }

    public final void zad(int i) {
        Handler handler = this.zah;
        Preconditions.checkHandlerThread(handler, "onUnintentionalDisconnection must only be called on the Handler thread");
        handler.removeMessages(1);
        synchronized (this.zai) {
            this.zag = true;
            ArrayList arrayList = this.zac;
            ArrayList arrayList2 = new ArrayList(arrayList);
            AtomicInteger atomicInteger = this.zaf;
            int i2 = atomicInteger.get();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it.next();
                if (!this.zae || atomicInteger.get() != i2) {
                    break;
                } else if (arrayList.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            this.zaa.clear();
            this.zag = false;
        }
    }

    public final void zae(ConnectionResult connectionResult) {
        Handler handler = this.zah;
        Preconditions.checkHandlerThread(handler, "onConnectionFailure must only be called on the Handler thread");
        handler.removeMessages(1);
        synchronized (this.zai) {
            ArrayList arrayList = this.zad;
            ArrayList arrayList2 = new ArrayList(arrayList);
            AtomicInteger atomicInteger = this.zaf;
            int i = atomicInteger.get();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener) it.next();
                if (this.zae && atomicInteger.get() == i) {
                    if (arrayList.contains(onConnectionFailedListener)) {
                        onConnectionFailedListener.onConnectionFailed(connectionResult);
                    }
                }
                return;
            }
        }
    }

    public final void zaf(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        Preconditions.checkNotNull(connectionCallbacks);
        synchronized (this.zai) {
            ArrayList arrayList = this.zac;
            if (!arrayList.contains(connectionCallbacks)) {
                arrayList.add(connectionCallbacks);
            } else {
                String valueOf = String.valueOf(connectionCallbacks);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 62);
                sb.append("registerConnectionCallbacks(): listener ");
                sb.append(valueOf);
                sb.append(" is already registered");
                Log.w("GmsClientEvents", sb.toString());
            }
        }
        if (this.zab.isConnected()) {
            Handler handler = this.zah;
            handler.sendMessage(handler.obtainMessage(1, connectionCallbacks));
        }
    }

    public final boolean zag(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        boolean contains;
        Preconditions.checkNotNull(connectionCallbacks);
        synchronized (this.zai) {
            contains = this.zac.contains(connectionCallbacks);
        }
        return contains;
    }

    public final void zah(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        Preconditions.checkNotNull(connectionCallbacks);
        synchronized (this.zai) {
            if (!this.zac.remove(connectionCallbacks)) {
                String valueOf = String.valueOf(connectionCallbacks);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 52);
                sb.append("unregisterConnectionCallbacks(): listener ");
                sb.append(valueOf);
                sb.append(" not found");
                Log.w("GmsClientEvents", sb.toString());
            } else if (this.zag) {
                this.zaa.add(connectionCallbacks);
            }
        }
    }

    public final void zai(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.checkNotNull(onConnectionFailedListener);
        synchronized (this.zai) {
            ArrayList arrayList = this.zad;
            if (!arrayList.contains(onConnectionFailedListener)) {
                arrayList.add(onConnectionFailedListener);
            } else {
                String valueOf = String.valueOf(onConnectionFailedListener);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 67);
                sb.append("registerConnectionFailedListener(): listener ");
                sb.append(valueOf);
                sb.append(" is already registered");
                Log.w("GmsClientEvents", sb.toString());
            }
        }
    }

    public final boolean zaj(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        boolean contains;
        Preconditions.checkNotNull(onConnectionFailedListener);
        synchronized (this.zai) {
            contains = this.zad.contains(onConnectionFailedListener);
        }
        return contains;
    }

    public final void zak(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.checkNotNull(onConnectionFailedListener);
        synchronized (this.zai) {
            if (!this.zad.remove(onConnectionFailedListener)) {
                String valueOf = String.valueOf(onConnectionFailedListener);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 57);
                sb.append("unregisterConnectionFailedListener(): listener ");
                sb.append(valueOf);
                sb.append(" not found");
                Log.w("GmsClientEvents", sb.toString());
            }
        }
    }
}
