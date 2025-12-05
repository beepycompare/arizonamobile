package androidx.datastore.core;

import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FileStorage.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u000fB9\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/datastore/core/FileStorage;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/Storage;", "serializer", "Landroidx/datastore/core/Serializer;", "coordinatorProducer", "Lkotlin/Function1;", "Ljava/io/File;", "Landroidx/datastore/core/InterProcessCoordinator;", "produceFile", "Lkotlin/Function0;", "<init>", "(Landroidx/datastore/core/Serializer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "createConnection", "Landroidx/datastore/core/StorageConnection;", "Companion", "datastore-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FileStorage<T> implements Storage<T> {
    public static final Companion Companion = new Companion(null);
    private static final Set<String> activeFiles = new LinkedHashSet();
    private static final Object activeFilesLock = new Object();
    private final Function1<File, InterProcessCoordinator> coordinatorProducer;
    private final Function0<File> produceFile;
    private final Serializer<T> serializer;

    /* JADX WARN: Multi-variable type inference failed */
    public FileStorage(Serializer<T> serializer, Function1<? super File, ? extends InterProcessCoordinator> coordinatorProducer, Function0<? extends File> produceFile) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(coordinatorProducer, "coordinatorProducer");
        Intrinsics.checkNotNullParameter(produceFile, "produceFile");
        this.serializer = serializer;
        this.coordinatorProducer = coordinatorProducer;
        this.produceFile = produceFile;
    }

    public /* synthetic */ FileStorage(Serializer serializer, Function1 function1, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(serializer, (i & 2) != 0 ? new Function1() { // from class: androidx.datastore.core.FileStorage$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                InterProcessCoordinator _init_$lambda$0;
                _init_$lambda$0 = FileStorage._init_$lambda$0((File) obj);
                return _init_$lambda$0;
            }
        } : function1, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterProcessCoordinator _init_$lambda$0(File it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return InterProcessCoordinator_jvmKt.createSingleProcessCoordinator(it);
    }

    @Override // androidx.datastore.core.Storage
    public StorageConnection<T> createConnection() {
        final File canonicalFile = this.produceFile.invoke().getCanonicalFile();
        synchronized (activeFilesLock) {
            String absolutePath = canonicalFile.getAbsolutePath();
            Set<String> set = activeFiles;
            if (set.contains(absolutePath)) {
                throw new IllegalStateException(("There are multiple DataStores active for the same file: " + absolutePath + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
            }
            Intrinsics.checkNotNull(absolutePath);
            set.add(absolutePath);
        }
        Intrinsics.checkNotNull(canonicalFile);
        return new FileStorageConnection(canonicalFile, this.serializer, this.coordinatorProducer.invoke(canonicalFile), new Function0() { // from class: androidx.datastore.core.FileStorage$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit createConnection$lambda$1;
                createConnection$lambda$1 = FileStorage.createConnection$lambda$1(canonicalFile);
                return createConnection$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createConnection$lambda$1(File file) {
        synchronized (activeFilesLock) {
            activeFiles.remove(file.getAbsolutePath());
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* compiled from: FileStorage.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/datastore/core/FileStorage$Companion;", "", "<init>", "()V", "activeFiles", "", "", "getActiveFiles$datastore_core", "()Ljava/util/Set;", "activeFilesLock", "getActiveFilesLock$datastore_core", "()Ljava/lang/Object;", "datastore-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<String> getActiveFiles$datastore_core() {
            return FileStorage.activeFiles;
        }

        public final Object getActiveFilesLock$datastore_core() {
            return FileStorage.activeFilesLock;
        }
    }
}
