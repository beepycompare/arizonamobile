package com.google.android.gms.location;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.tasks.TaskCompletionSource;
/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes4.dex */
final class zzbt implements BaseImplementation.ResultHolder<LocationSettingsResult> {
    private final TaskCompletionSource<LocationSettingsResponse> zza;

    public zzbt(TaskCompletionSource<LocationSettingsResponse> taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final void setFailedResult(Status status) {
        this.zza.setException(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final /* bridge */ /* synthetic */ void setResult(LocationSettingsResult locationSettingsResult) {
        LocationSettingsResult locationSettingsResult2 = locationSettingsResult;
        Status status = locationSettingsResult2.getStatus();
        if (status.isSuccess()) {
            this.zza.setResult(new LocationSettingsResponse(locationSettingsResult2));
            return;
        }
        boolean hasResolution = status.hasResolution();
        TaskCompletionSource<LocationSettingsResponse> taskCompletionSource = this.zza;
        if (hasResolution) {
            taskCompletionSource.setException(new ResolvableApiException(status));
        } else {
            taskCompletionSource.setException(new ApiException(status));
        }
    }
}
