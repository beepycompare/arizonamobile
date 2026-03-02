package com.google.android.gms.tasks;

import java.util.ArrayList;
import java.util.Collection;
/* compiled from: com.google.android.gms:play-services-tasks@@18.4.0 */
/* loaded from: classes4.dex */
final class zzy implements Continuation {
    final /* synthetic */ Collection zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzy(Collection collection) {
        this.zza = collection;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        ArrayList arrayList = new ArrayList();
        for (Task task2 : this.zza) {
            arrayList.add(task2.getResult());
        }
        return arrayList;
    }
}
