package io.appmetrica.analytics.remotepermissions.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.text.Charsets;
/* loaded from: classes4.dex */
public final class c implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final f fromModel(a aVar) {
        f fVar = new f();
        Set<String> set = aVar.f1262a;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        for (String str : set) {
            arrayList.add(str.getBytes(Charsets.UTF_8));
        }
        Object[] array = arrayList.toArray(new byte[0]);
        if (array != null) {
            fVar.f1266a = (byte[][]) array;
            return fVar;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
        if (r7 == null) goto L12;
     */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final a toModel(f fVar) {
        Set emptySet;
        byte[][] bArr = fVar.f1266a;
        if (bArr != null) {
            ArrayList arrayList = new ArrayList(bArr.length);
            for (byte[] bArr2 : bArr) {
                arrayList.add(new String(bArr2, Charsets.UTF_8));
            }
            emptySet = CollectionsKt.toSet(arrayList);
        }
        emptySet = SetsKt.emptySet();
        return new a(emptySet);
    }
}
