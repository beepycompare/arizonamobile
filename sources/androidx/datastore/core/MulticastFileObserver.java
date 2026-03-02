package androidx.datastore.core;

import android.os.FileObserver;
import androidx.core.app.NotificationCompat;
import androidx.datastore.core.MulticastFileObserver;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
/* compiled from: MulticastFileObserver.android.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R&\u0010\b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/datastore/core/MulticastFileObserver;", "Landroid/os/FileObserver;", "path", "", "<init>", "(Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "delegates", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function1;", "", "Landroidx/datastore/core/FileMoveObserver;", "onEvent", NotificationCompat.CATEGORY_EVENT, "", "Companion", "datastore-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MulticastFileObserver extends FileObserver {
    public static final Companion Companion = new Companion(null);
    private static final Object LOCK = new Object();
    private static final Map<String, MulticastFileObserver> fileObservers = new LinkedHashMap();
    private final CopyOnWriteArrayList<Function1<String, Unit>> delegates;
    private final String path;

    public /* synthetic */ MulticastFileObserver(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private MulticastFileObserver(String str) {
        super(str, 128);
        this.path = str;
        this.delegates = new CopyOnWriteArrayList<>();
    }

    public final String getPath() {
        return this.path;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        Iterator<T> it = this.delegates.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(str);
        }
    }

    /* compiled from: MulticastFileObserver.android.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J*\u0010\f\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00102\u0018\u0010\u0013\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u000e0\u0014j\u0002`\u0015H\u0003J\r\u0010\u0016\u001a\u00020\u000eH\u0001¢\u0006\u0002\b\u0017R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Landroidx/datastore/core/MulticastFileObserver$Companion;", "", "<init>", "()V", "LOCK", "fileObservers", "", "", "Landroidx/datastore/core/MulticastFileObserver;", "getFileObservers$datastore_core$annotations", "getFileObservers$datastore_core", "()Ljava/util/Map;", "observe", "Lkotlinx/coroutines/flow/Flow;", "", "file", "Ljava/io/File;", "Lkotlinx/coroutines/DisposableHandle;", "parent", "observer", "Lkotlin/Function1;", "Landroidx/datastore/core/FileMoveObserver;", "removeAllObservers", "removeAllObservers$datastore_core", "datastore-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getFileObservers$datastore_core$annotations() {
        }

        private Companion() {
        }

        public final Map<String, MulticastFileObserver> getFileObservers$datastore_core() {
            return MulticastFileObserver.fileObservers;
        }

        public final Flow<Unit> observe(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            return FlowKt.channelFlow(new MulticastFileObserver$Companion$observe$1(file, null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DisposableHandle observe(File file, final Function1<? super String, Unit> function1) {
            final String path = file.getCanonicalFile().getPath();
            synchronized (MulticastFileObserver.LOCK) {
                Map<String, MulticastFileObserver> fileObservers$datastore_core = MulticastFileObserver.Companion.getFileObservers$datastore_core();
                MulticastFileObserver multicastFileObserver = fileObservers$datastore_core.get(path);
                if (multicastFileObserver == null) {
                    Intrinsics.checkNotNull(path);
                    multicastFileObserver = new MulticastFileObserver(path, null);
                    fileObservers$datastore_core.put(path, multicastFileObserver);
                }
                MulticastFileObserver multicastFileObserver2 = multicastFileObserver;
                multicastFileObserver2.delegates.add(function1);
                if (multicastFileObserver2.delegates.size() == 1) {
                    multicastFileObserver2.startWatching();
                }
                Unit unit = Unit.INSTANCE;
            }
            return new DisposableHandle() { // from class: androidx.datastore.core.MulticastFileObserver$Companion$$ExternalSyntheticLambda0
                @Override // kotlinx.coroutines.DisposableHandle
                public final void dispose() {
                    MulticastFileObserver.Companion.observe$lambda$1(path, function1);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void observe$lambda$1(String str, Function1 function1) {
            synchronized (MulticastFileObserver.LOCK) {
                MulticastFileObserver multicastFileObserver = MulticastFileObserver.Companion.getFileObservers$datastore_core().get(str);
                if (multicastFileObserver != null) {
                    multicastFileObserver.delegates.remove(function1);
                    if (multicastFileObserver.delegates.isEmpty()) {
                        MulticastFileObserver.Companion.getFileObservers$datastore_core().remove(str);
                        multicastFileObserver.stopWatching();
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        public final void removeAllObservers$datastore_core() {
            synchronized (MulticastFileObserver.LOCK) {
                for (MulticastFileObserver multicastFileObserver : MulticastFileObserver.Companion.getFileObservers$datastore_core().values()) {
                    multicastFileObserver.stopWatching();
                }
                MulticastFileObserver.Companion.getFileObservers$datastore_core().clear();
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
