package com.google.android.gms.common;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
final /* synthetic */ class zab implements SuccessContinuation {
    static final /* synthetic */ zab zaa = new zab();

    private /* synthetic */ zab() {
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public final /* synthetic */ Task then(Object obj) {
        Map map = (Map) obj;
        int i = GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        return Tasks.forResult(null);
    }
}
