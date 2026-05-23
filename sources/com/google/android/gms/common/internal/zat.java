package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
final class zat implements PendingResultUtil.ResultConverter {
    final /* synthetic */ Response zaa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zat(Response response) {
        this.zaa = response;
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* bridge */ /* synthetic */ Object convert(Result result) {
        Response response = this.zaa;
        response.setResult(result);
        return response;
    }
}
