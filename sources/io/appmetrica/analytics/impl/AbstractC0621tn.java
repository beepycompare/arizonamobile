package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* renamed from: io.appmetrica.analytics.impl.tn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0621tn implements InterfaceC0595sn {
    public abstract IBinaryDataHelper a(Context context);

    public abstract ProtobufStateStorage<Object> a(Context context, IBinaryDataHelper iBinaryDataHelper);

    public abstract IBinaryDataHelper b(Context context);

    @Override // io.appmetrica.analytics.impl.InterfaceC0595sn, io.appmetrica.analytics.coreapi.internal.data.ProtobufBinaryStateStorageFactory
    public final ProtobufStateStorage<Object> create(Context context) {
        return a(context, a(context));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0595sn, io.appmetrica.analytics.coreapi.internal.data.ProtobufBinaryStateStorageFactory
    public final ProtobufStateStorage<Object> createForMigration(Context context) {
        return a(context, b(context));
    }
}
