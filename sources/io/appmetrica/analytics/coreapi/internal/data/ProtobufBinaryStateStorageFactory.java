package io.appmetrica.analytics.coreapi.internal.data;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lio/appmetrica/analytics/coreapi/internal/data/ProtobufBinaryStateStorageFactory;", ExifInterface.GPS_DIRECTION_TRUE, "", "create", "Lio/appmetrica/analytics/coreapi/internal/data/ProtobufStateStorage;", "context", "Landroid/content/Context;", "createForMigration", "core-api_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ProtobufBinaryStateStorageFactory<T> {
    ProtobufStateStorage<T> create(Context context);

    ProtobufStateStorage<T> createForMigration(Context context);
}
