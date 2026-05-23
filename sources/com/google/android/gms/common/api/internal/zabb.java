package com.google.android.gms.common.api.internal;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
abstract class zabb {
    private final zaba zaa;

    /* JADX INFO: Access modifiers changed from: protected */
    public zabb(zaba zabaVar) {
        this.zaa = zabaVar;
    }

    protected abstract void zaa();

    public final void zab(zabd zabdVar) {
        zabdVar.zat().lock();
        try {
            if (zabdVar.zau() == this.zaa) {
                zaa();
            }
        } finally {
            zabdVar.zat().unlock();
        }
    }
}
