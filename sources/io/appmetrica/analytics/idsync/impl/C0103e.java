package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.idsync.internal.model.IdSyncConfig;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.idsync.impl.e  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0103e implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C f424a = new C();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final m fromModel(IdSyncConfig idSyncConfig) {
        m mVar = new m();
        mVar.f432a = idSyncConfig.getEnabled();
        l lVar = new l();
        lVar.f431a = idSyncConfig.getLaunchDelay();
        int size = idSyncConfig.getRequests().size();
        k[] kVarArr = new k[size];
        for (int i = 0; i < size; i++) {
            kVarArr[i] = this.f424a.fromModel(idSyncConfig.getRequests().get(i));
        }
        lVar.b = kVarArr;
        mVar.b = lVar;
        return mVar;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final IdSyncConfig toModel(m mVar) {
        l lVar = mVar.b;
        if (lVar == null) {
            lVar = new l();
        }
        boolean z = mVar.f432a;
        long j = lVar.f431a;
        k[] kVarArr = lVar.b;
        ArrayList arrayList = new ArrayList(kVarArr.length);
        for (k kVar : kVarArr) {
            arrayList.add(this.f424a.toModel(kVar));
        }
        return new IdSyncConfig(z, j, arrayList);
    }
}
