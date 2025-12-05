package androidx.datastore.core;

import android.content.Context;
import androidx.datastore.core.handlers.NoOpCorruptionHandler;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
/* compiled from: DataStoreFactory.android.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jb\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0007JT\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00142\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007Jd\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¨\u0006\u001a"}, d2 = {"Landroidx/datastore/core/DataStoreFactory;", "", "<init>", "()V", "create", "Landroidx/datastore/core/DataStore;", ExifInterface.GPS_DIRECTION_TRUE, "serializer", "Landroidx/datastore/core/Serializer;", "corruptionHandler", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "migrations", "", "Landroidx/datastore/core/DataMigration;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "produceFile", "Lkotlin/Function0;", "Ljava/io/File;", "storage", "Landroidx/datastore/core/Storage;", "createInDeviceProtectedStorage", "context", "Landroid/content/Context;", "fileName", "", "datastore-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DataStoreFactory {
    public static final DataStoreFactory INSTANCE = new DataStoreFactory();

    public final <T> DataStore<T> create(Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> migrations, Function0<? extends File> produceFile) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(migrations, "migrations");
        Intrinsics.checkNotNullParameter(produceFile, "produceFile");
        return create$default(this, serializer, replaceFileCorruptionHandler, migrations, null, produceFile, 8, null);
    }

    public final <T> DataStore<T> create(Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, Function0<? extends File> produceFile) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(produceFile, "produceFile");
        return create$default(this, serializer, replaceFileCorruptionHandler, null, null, produceFile, 12, null);
    }

    public final <T> DataStore<T> create(Serializer<T> serializer, Function0<? extends File> produceFile) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(produceFile, "produceFile");
        return create$default(this, serializer, null, null, null, produceFile, 14, null);
    }

    public final <T> DataStore<T> create(Storage<T> storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        return create$default(this, storage, null, null, null, 14, null);
    }

    public final <T> DataStore<T> create(Storage<T> storage, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        return create$default(this, storage, replaceFileCorruptionHandler, null, null, 12, null);
    }

    public final <T> DataStore<T> create(Storage<T> storage, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> migrations) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(migrations, "migrations");
        return create$default(this, storage, replaceFileCorruptionHandler, migrations, null, 8, null);
    }

    public final <T> DataStore<T> createInDeviceProtectedStorage(Context context, String fileName, Serializer<T> serializer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        return createInDeviceProtectedStorage$default(this, context, fileName, serializer, null, null, null, 56, null);
    }

    public final <T> DataStore<T> createInDeviceProtectedStorage(Context context, String fileName, Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        return createInDeviceProtectedStorage$default(this, context, fileName, serializer, replaceFileCorruptionHandler, null, null, 48, null);
    }

    public final <T> DataStore<T> createInDeviceProtectedStorage(Context context, String fileName, Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> migrations) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(migrations, "migrations");
        return createInDeviceProtectedStorage$default(this, context, fileName, serializer, replaceFileCorruptionHandler, migrations, null, 32, null);
    }

    public static /* synthetic */ DataStore create$default(DataStoreFactory dataStoreFactory, Storage storage, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, CoroutineScope coroutineScope, int i, Object obj) {
        if ((i & 2) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 8) != 0) {
            coroutineScope = CoroutineScopeKt.CoroutineScope(Actual_jvmKt.ioDispatcher().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        }
        return dataStoreFactory.create(storage, replaceFileCorruptionHandler, list, coroutineScope);
    }

    private DataStoreFactory() {
    }

    public static /* synthetic */ DataStore create$default(DataStoreFactory dataStoreFactory, Serializer serializer, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, CoroutineScope coroutineScope, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 8) != 0) {
            coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        }
        return dataStoreFactory.create(serializer, replaceFileCorruptionHandler, list, coroutineScope, function0);
    }

    public final <T> DataStore<T> create(Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> migrations, CoroutineScope scope, Function0<? extends File> produceFile) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(migrations, "migrations");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(produceFile, "produceFile");
        return create(new FileStorage(serializer, null, produceFile, 2, null), replaceFileCorruptionHandler, migrations, scope);
    }

    public final <T> DataStore<T> create(Storage<T> storage, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> migrations, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(migrations, "migrations");
        Intrinsics.checkNotNullParameter(scope, "scope");
        if (replaceFileCorruptionHandler == null) {
            replaceFileCorruptionHandler = (ReplaceFileCorruptionHandler<T>) new NoOpCorruptionHandler();
        }
        return new DataStoreImpl(storage, CollectionsKt.listOf(DataMigrationInitializer.Companion.getInitializer(migrations)), replaceFileCorruptionHandler, scope);
    }

    public static /* synthetic */ DataStore createInDeviceProtectedStorage$default(DataStoreFactory dataStoreFactory, Context context, String str, Serializer serializer, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, CoroutineScope coroutineScope, int i, Object obj) {
        if ((i & 8) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i & 16) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 32) != 0) {
            coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        }
        return dataStoreFactory.createInDeviceProtectedStorage(context, str, serializer, replaceFileCorruptionHandler, list, coroutineScope);
    }

    public final <T> DataStore<T> createInDeviceProtectedStorage(final Context context, final String fileName, Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> migrations, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(migrations, "migrations");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return new DataStoreImpl(new FileStorage(serializer, null, new Function0() { // from class: androidx.datastore.core.DataStoreFactory$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                File deviceProtectedDataStoreFile;
                deviceProtectedDataStoreFile = DeviceProtectedDataStoreFile.deviceProtectedDataStoreFile(context, fileName);
                return deviceProtectedDataStoreFile;
            }
        }, 2, null), CollectionsKt.listOf(DataMigrationInitializer.Companion.getInitializer(migrations)), replaceFileCorruptionHandler != null ? replaceFileCorruptionHandler : new NoOpCorruptionHandler(), scope);
    }
}
