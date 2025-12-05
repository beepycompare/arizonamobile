package androidx.datastore.core;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
/* compiled from: DataMigration.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H¦@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H¦@¢\u0006\u0002\u0010\u0006J\u000e\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/datastore/core/DataMigration;", ExifInterface.GPS_DIRECTION_TRUE, "", "shouldMigrate", "", "currentData", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "migrate", "cleanUp", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface DataMigration<T> {
    Object cleanUp(Continuation<? super Unit> continuation);

    Object migrate(T t, Continuation<? super T> continuation);

    Object shouldMigrate(T t, Continuation<? super Boolean> continuation);
}
