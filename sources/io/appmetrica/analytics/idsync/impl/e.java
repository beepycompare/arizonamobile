package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.idsync.internal.model.IdSyncConfig;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class e implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final x f365a = new x();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final o fromModel(IdSyncConfig idSyncConfig) {
        o oVar = new o();
        oVar.f374a = idSyncConfig.getEnabled();
        n nVar = new n();
        nVar.f373a = idSyncConfig.getLaunchDelay();
        int size = idSyncConfig.getRequests().size();
        m[] mVarArr = new m[size];
        for (int i = 0; i < size; i++) {
            mVarArr[i] = this.f365a.fromModel(idSyncConfig.getRequests().get(i));
        }
        nVar.b = mVarArr;
        oVar.b = nVar;
        return oVar;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final IdSyncConfig toModel(o oVar) {
        n nVar = oVar.b;
        if (nVar == null) {
            nVar = new n();
        }
        boolean z = oVar.f374a;
        long j = nVar.f373a;
        m[] mVarArr = nVar.b;
        ArrayList arrayList = new ArrayList(mVarArr.length);
        for (m mVar : mVarArr) {
            arrayList.add(this.f365a.toModel(mVar));
        }
        return new IdSyncConfig(z, j, arrayList);
    }
}
