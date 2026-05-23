package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
public abstract class zai {
    public final int zac;

    public zai(int i) {
        this.zac = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Status zai(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    public abstract void zad(Status status);

    public abstract void zae(Exception exc);

    public abstract void zaf(zaaa zaaaVar, boolean z);

    public abstract void zag(zabk zabkVar) throws DeadObjectException;
}
