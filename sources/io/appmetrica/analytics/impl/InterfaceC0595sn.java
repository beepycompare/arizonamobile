package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufBinaryStateStorageFactory;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* renamed from: io.appmetrica.analytics.impl.sn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC0595sn extends ProtobufBinaryStateStorageFactory {
    @Override // io.appmetrica.analytics.coreapi.internal.data.ProtobufBinaryStateStorageFactory
    ProtobufStateStorage<Object> create(Context context);

    @Override // io.appmetrica.analytics.coreapi.internal.data.ProtobufBinaryStateStorageFactory
    ProtobufStateStorage<Object> createForMigration(Context context);
}
