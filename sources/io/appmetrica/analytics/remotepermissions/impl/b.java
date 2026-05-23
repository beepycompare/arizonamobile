package io.appmetrica.analytics.remotepermissions.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.remotepermissions.internal.config.FeatureConfig;
import java.util.ArrayList;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.text.Charsets;
/* loaded from: classes5.dex */
public final class b implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final e fromModel(FeatureConfig featureConfig) {
        e eVar = new e();
        Set<String> permittedPermissions = featureConfig.getPermittedPermissions();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(permittedPermissions, 10));
        for (String str : permittedPermissions) {
            arrayList.add(str.getBytes(Charsets.UTF_8));
        }
        eVar.f1424a = (byte[][]) arrayList.toArray(new byte[0]);
        return eVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
        if (r5 == null) goto L12;
     */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final FeatureConfig toModel(e eVar) {
        Set emptySet;
        byte[][] bArr = eVar.f1424a;
        if (bArr != null) {
            ArrayList arrayList = new ArrayList(bArr.length);
            for (byte[] bArr2 : bArr) {
                arrayList.add(new String(bArr2, Charsets.UTF_8));
            }
            emptySet = CollectionsKt.toSet(arrayList);
        }
        emptySet = SetsKt.emptySet();
        return new FeatureConfig(emptySet);
    }
}
