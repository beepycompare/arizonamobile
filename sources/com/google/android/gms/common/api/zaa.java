package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
public final class zaa implements PendingResult.StatusListener {
    final /* synthetic */ Batch zaa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zaa(Batch batch) {
        Objects.requireNonNull(batch);
        this.zaa = batch;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        Status status2;
        Batch batch = this.zaa;
        synchronized (batch.zai()) {
            if (batch.isCanceled()) {
                return;
            }
            if (status.isCanceled()) {
                batch.zag(true);
            } else if (!status.isSuccess()) {
                batch.zae(true);
            }
            batch.zac(batch.zab() - 1);
            if (batch.zab() == 0) {
                if (batch.zaf()) {
                    super/*com.google.android.gms.common.api.internal.BasePendingResult*/.cancel();
                } else {
                    if (batch.zad()) {
                        status2 = new Status(13);
                    } else {
                        status2 = Status.RESULT_SUCCESS;
                    }
                    batch.setResult(new BatchResult(status2, batch.zah()));
                }
            }
        }
    }
}
