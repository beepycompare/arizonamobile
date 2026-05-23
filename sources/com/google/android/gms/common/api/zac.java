package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BasePendingResult;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
final class zac<R extends Result> extends BasePendingResult<R> {
    private final Result zae;

    public zac(Result result) {
        super(Looper.getMainLooper());
        this.zae = result;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final R createFailedResult(Status status) {
        R r = (R) this.zae;
        if (status.getStatusCode() == r.getStatus().getStatusCode()) {
            return r;
        }
        throw new UnsupportedOperationException("Creating failed results is not supported");
    }
}
