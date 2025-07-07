package ru.rustore.sdk.appupdate.manager;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import ru.rustore.sdk.appupdate.listener.InstallStateUpdateListener;
import ru.rustore.sdk.appupdate.model.AppUpdateInfo;
import ru.rustore.sdk.appupdate.model.AppUpdateOptions;
import ru.rustore.sdk.core.tasks.Task;
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH&J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u0010"}, d2 = {"Lru/rustore/sdk/appupdate/manager/RuStoreAppUpdateManager;", "", "completeUpdate", "Lru/rustore/sdk/core/tasks/Task;", "", "getAppUpdateInfo", "Lru/rustore/sdk/appupdate/model/AppUpdateInfo;", "registerListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lru/rustore/sdk/appupdate/listener/InstallStateUpdateListener;", "startUpdateFlow", "", "appUpdateInfo", "appUpdateOptions", "Lru/rustore/sdk/appupdate/model/AppUpdateOptions;", "unregisterListener", "sdk-public-appupdate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface RuStoreAppUpdateManager {
    Task<Unit> completeUpdate();

    Task<AppUpdateInfo> getAppUpdateInfo();

    void registerListener(InstallStateUpdateListener installStateUpdateListener);

    Task<Integer> startUpdateFlow(AppUpdateInfo appUpdateInfo, AppUpdateOptions appUpdateOptions);

    void unregisterListener(InstallStateUpdateListener installStateUpdateListener);
}
