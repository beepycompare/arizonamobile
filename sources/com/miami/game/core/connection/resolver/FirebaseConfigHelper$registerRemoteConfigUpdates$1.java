package com.miami.game.core.connection.resolver;

import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.ConfigUpdate;
import com.google.firebase.remoteconfig.ConfigUpdateListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FirebaseServerHandler.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/miami/game/core/connection/resolver/FirebaseConfigHelper$registerRemoteConfigUpdates$1", "Lcom/google/firebase/remoteconfig/ConfigUpdateListener;", "onUpdate", "", "configUpdate", "Lcom/google/firebase/remoteconfig/ConfigUpdate;", "onError", "error", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfigException;", "connection-resolver"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FirebaseConfigHelper$registerRemoteConfigUpdates$1 implements ConfigUpdateListener {
    @Override // com.google.firebase.remoteconfig.ConfigUpdateListener
    public void onUpdate(final ConfigUpdate configUpdate) {
        FirebaseRemoteConfig remoteConfig;
        Intrinsics.checkNotNullParameter(configUpdate, "configUpdate");
        remoteConfig = FirebaseConfigHelper.INSTANCE.getRemoteConfig();
        remoteConfig.activate().addOnCompleteListener(new OnCompleteListener() { // from class: com.miami.game.core.connection.resolver.FirebaseConfigHelper$registerRemoteConfigUpdates$1$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FirebaseConfigHelper$registerRemoteConfigUpdates$1.onUpdate$lambda$0(ConfigUpdate.this, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onUpdate$lambda$0(ConfigUpdate configUpdate, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            FirebaseConfigHelper firebaseConfigHelper = FirebaseConfigHelper.INSTANCE;
            Set<String> updatedKeys = configUpdate.getUpdatedKeys();
            Intrinsics.checkNotNullExpressionValue(updatedKeys, "getUpdatedKeys(...)");
            firebaseConfigHelper.publishRemoteConfigUpdate(updatedKeys);
            return;
        }
        Exception exception = task.getException();
        Log.w("FirebaseSrvHandler", "remoteConfigUpdate: activate failed: " + (exception != null ? exception.getMessage() : null));
    }

    @Override // com.google.firebase.remoteconfig.ConfigUpdateListener
    public void onError(FirebaseRemoteConfigException error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Log.w("FirebaseSrvHandler", "remoteConfigUpdate: listener error: " + error.getMessage());
    }
}
