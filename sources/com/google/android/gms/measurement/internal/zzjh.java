package com.google.android.gms.measurement.internal;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public enum zzjh {
    UNINITIALIZED("uninitialized"),
    POLICY("eu_consent_policy"),
    DENIED("denied"),
    GRANTED("granted");
    
    private final String zze;

    zzjh(String str) {
        this.zze = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.zze;
    }
}
