package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
public final class zax implements zabv {
    private final Context zaa;
    private final zaaz zab;
    private final Looper zac;
    private final zabd zad;
    private final zabd zae;
    private final Map zaf;
    private final Api.Client zah;
    private Bundle zai;
    private final Lock zam;
    private final Set zag = Collections.newSetFromMap(new WeakHashMap());
    private ConnectionResult zaj = null;
    private ConnectionResult zak = null;
    private boolean zal = false;
    private int zan = 0;

    private zax(Context context, zaaz zaazVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map map, Map map2, ClientSettings clientSettings, Api.AbstractClientBuilder abstractClientBuilder, Api.Client client, ArrayList arrayList, ArrayList arrayList2, Map map3, Map map4) {
        this.zaa = context;
        this.zab = zaazVar;
        this.zam = lock;
        this.zac = looper;
        this.zah = client;
        this.zad = new zabd(context, zaazVar, lock, looper, googleApiAvailabilityLight, map2, null, map4, null, arrayList2, new zav(this, null));
        this.zae = new zabd(context, zaazVar, lock, looper, googleApiAvailabilityLight, map, clientSettings, map3, abstractClientBuilder, arrayList, new zaw(this, null));
        ArrayMap arrayMap = new ArrayMap();
        for (Api.AnyClientKey anyClientKey : map2.keySet()) {
            arrayMap.put(anyClientKey, this.zad);
        }
        for (Api.AnyClientKey anyClientKey2 : map.keySet()) {
            arrayMap.put(anyClientKey2, this.zae);
        }
        this.zaf = Collections.unmodifiableMap(arrayMap);
    }

    private final void zaA() {
        Set<SignInConnectionListener> set = this.zag;
        for (SignInConnectionListener signInConnectionListener : set) {
            signInConnectionListener.onComplete();
        }
        set.clear();
    }

    private final boolean zaB() {
        ConnectionResult connectionResult = this.zak;
        return connectionResult != null && connectionResult.getErrorCode() == 4;
    }

    private final boolean zaC(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        zabd zabdVar = (zabd) this.zaf.get(apiMethodImpl.getClientKey());
        Preconditions.checkNotNull(zabdVar, "GoogleApiClient is not configured to use the API required for this call.");
        return zabdVar.equals(this.zae);
    }

    private final PendingIntent zaD() {
        Api.Client client = this.zah;
        if (client == null) {
            return null;
        }
        return com.google.android.gms.internal.base.zak.zaa(this.zaa, System.identityHashCode(this.zab), client.getSignInIntent(), com.google.android.gms.internal.base.zak.zaa | 134217728);
    }

    private static boolean zaE(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    public static zax zaa(Context context, zaaz zaazVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map map, ClientSettings clientSettings, Map map2, Api.AbstractClientBuilder abstractClientBuilder, ArrayList arrayList) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        Api.Client client = null;
        for (Map.Entry entry : map.entrySet()) {
            Api.Client client2 = (Api.Client) entry.getValue();
            if (true == client2.providesSignIn()) {
                client = client2;
            }
            if (client2.requiresSignIn()) {
                arrayMap.put((Api.AnyClientKey) entry.getKey(), client2);
            } else {
                arrayMap2.put((Api.AnyClientKey) entry.getKey(), client2);
            }
        }
        Preconditions.checkState(!arrayMap.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        for (Api api : map2.keySet()) {
            Api.AnyClientKey zac = api.zac();
            if (arrayMap.containsKey(zac)) {
                arrayMap3.put(api, (Boolean) map2.get(api));
            } else if (arrayMap2.containsKey(zac)) {
                arrayMap4.put(api, (Boolean) map2.get(api));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            zas zasVar = (zas) arrayList.get(i);
            Api api2 = zasVar.zaa;
            if (arrayMap3.containsKey(api2)) {
                arrayList2.add(zasVar);
            } else if (arrayMap4.containsKey(api2)) {
                arrayList3.add(zasVar);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        return new zax(context, zaazVar, lock, looper, googleApiAvailabilityLight, arrayMap, arrayMap2, clientSettings, abstractClientBuilder, client, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    @Override // com.google.android.gms.common.api.internal.zabv
    public final BaseImplementation.ApiMethodImpl zab(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        if (zaC(apiMethodImpl)) {
            if (zaB()) {
                apiMethodImpl.setFailedResult(new Status(4, (String) null, zaD()));
                return apiMethodImpl;
            }
            this.zae.zab(apiMethodImpl);
            return apiMethodImpl;
        }
        this.zad.zab(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zabv
    public final BaseImplementation.ApiMethodImpl zac(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        if (zaC(apiMethodImpl)) {
            if (zaB()) {
                apiMethodImpl.setFailedResult(new Status(4, (String) null, zaD()));
                return apiMethodImpl;
            }
            return this.zae.zac(apiMethodImpl);
        }
        return this.zad.zac(apiMethodImpl);
    }

    @Override // com.google.android.gms.common.api.internal.zabv
    public final ConnectionResult zad(Api api) {
        Object obj = this.zaf.get(api.zac());
        zabd zabdVar = this.zae;
        if (Objects.equal(obj, zabdVar)) {
            if (zaB()) {
                return new ConnectionResult(4, zaD());
            }
            return zabdVar.zad(api);
        }
        return this.zad.zad(api);
    }

    @Override // com.google.android.gms.common.api.internal.zabv
    public final void zae() {
        this.zan = 2;
        this.zal = false;
        this.zak = null;
        this.zaj = null;
        this.zad.zae();
        this.zae.zae();
    }

    @Override // com.google.android.gms.common.api.internal.zabv
    public final ConnectionResult zaf() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.zabv
    public final ConnectionResult zag(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.zabv
    public final void zah() {
        this.zak = null;
        this.zaj = null;
        this.zan = 0;
        this.zad.zah();
        this.zae.zah();
        zaA();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
        if (r3.zan == 1) goto L12;
     */
    @Override // com.google.android.gms.common.api.internal.zabv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zai() {
        this.zam.lock();
        try {
            boolean z = false;
            if (this.zad.zai()) {
                if (!this.zae.zai() && !zaB()) {
                }
                z = true;
            }
            return z;
        } finally {
            this.zam.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabv
    public final boolean zaj() {
        this.zam.lock();
        try {
            return this.zan == 2;
        } finally {
            this.zam.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabv
    public final boolean zak(SignInConnectionListener signInConnectionListener) {
        this.zam.lock();
        try {
            boolean z = false;
            if (zaj() || zai()) {
                zabd zabdVar = this.zae;
                if (!zabdVar.zai()) {
                    this.zag.add(signInConnectionListener);
                    z = true;
                    if (this.zan == 0) {
                        this.zan = 1;
                    }
                    this.zak = null;
                    zabdVar.zae();
                }
            }
            return z;
        } finally {
            this.zam.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabv
    public final void zal() {
        this.zad.zal();
        this.zae.zal();
    }

    @Override // com.google.android.gms.common.api.internal.zabv
    public final void zam() {
        this.zam.lock();
        try {
            boolean zaj = zaj();
            this.zae.zah();
            this.zak = new ConnectionResult(4);
            if (zaj) {
                new com.google.android.gms.internal.base.zao(this.zac).post(new zau(this));
            } else {
                zaA();
            }
        } finally {
            this.zam.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabv
    public final void zan(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(StringUtils.PROCESS_POSTFIX_DELIMITER);
        String.valueOf(str);
        this.zae.zan(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(StringUtils.PROCESS_POSTFIX_DELIMITER);
        String.valueOf(str);
        this.zad.zan(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zao() {
        ConnectionResult connectionResult;
        if (zaE(this.zaj)) {
            if (zaE(this.zak) || zaB()) {
                int i = this.zan;
                if (i != 1) {
                    if (i == 2) {
                        ((zaaz) Preconditions.checkNotNull(this.zab)).zaa(this.zai);
                    } else {
                        Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                        this.zan = 0;
                        return;
                    }
                }
                zaA();
                this.zan = 0;
                return;
            }
            ConnectionResult connectionResult2 = this.zak;
            if (connectionResult2 != null) {
                if (this.zan == 1) {
                    zaA();
                    return;
                }
                zaz(connectionResult2);
                this.zad.zah();
            }
        } else if (this.zaj == null || !zaE(this.zak)) {
            ConnectionResult connectionResult3 = this.zaj;
            if (connectionResult3 == null || (connectionResult = this.zak) == null) {
                return;
            }
            if (this.zae.zaf < this.zad.zaf) {
                connectionResult3 = connectionResult;
            }
            zaz(connectionResult3);
        } else {
            this.zae.zah();
            zaz((ConnectionResult) Preconditions.checkNotNull(this.zaj));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zap(int i, boolean z) {
        this.zab.zac(i, z);
        this.zak = null;
        this.zaj = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zaq(Bundle bundle) {
        Bundle bundle2 = this.zai;
        if (bundle2 == null) {
            this.zai = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zabd zar() {
        return this.zad;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zabd zas() {
        return this.zae;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zat(ConnectionResult connectionResult) {
        this.zaj = connectionResult;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ConnectionResult zau() {
        return this.zak;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zav(ConnectionResult connectionResult) {
        this.zak = connectionResult;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean zaw() {
        return this.zal;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zax(boolean z) {
        this.zal = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Lock zay() {
        return this.zam;
    }

    private final void zaz(ConnectionResult connectionResult) {
        int i = this.zan;
        if (i != 1) {
            if (i == 2) {
                this.zab.zab(connectionResult);
            } else {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.zan = 0;
            }
        }
        zaA();
        this.zan = 0;
    }
}
