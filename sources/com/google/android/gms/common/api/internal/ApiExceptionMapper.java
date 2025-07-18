package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes3.dex */
public class ApiExceptionMapper implements StatusExceptionMapper {
    @Override // com.google.android.gms.common.api.internal.StatusExceptionMapper
    public final Exception getException(Status status) {
        return ApiExceptionUtil.fromStatus(status);
    }
}
