package ru.rustore.sdk.appupdate.listener;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import ru.rustore.sdk.appupdate.model.InstallState;
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lru/rustore/sdk/appupdate/listener/InstallStateUpdateListener;", "", "onStateUpdated", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Lru/rustore/sdk/appupdate/model/InstallState;", "sdk-public-appupdate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface InstallStateUpdateListener {
    void onStateUpdated(InstallState installState);
}
