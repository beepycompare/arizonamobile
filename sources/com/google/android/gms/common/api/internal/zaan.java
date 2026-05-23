package com.google.android.gms.common.api.internal;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
final class zaan extends zabb {
    final /* synthetic */ zaar zaa;
    final /* synthetic */ com.google.android.gms.signin.internal.zak zab;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zaan(zaao zaaoVar, zaba zabaVar, zaar zaarVar, com.google.android.gms.signin.internal.zak zakVar) {
        super(zabaVar);
        this.zaa = zaarVar;
        this.zab = zakVar;
        Objects.requireNonNull(zaaoVar);
    }

    @Override // com.google.android.gms.common.api.internal.zabb
    public final void zaa() {
        this.zaa.zaj(this.zab);
    }
}
