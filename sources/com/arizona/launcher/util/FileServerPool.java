package com.arizona.launcher.util;

import com.arizona.launcher.UpdateServiceContract;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: FileServerPool.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001:\u0003123Bò\u0001\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0018\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\u0004\u0012\u00020\n0\u0007\u00128\b\u0002\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\n0\f\u0012#\b\u0002\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\n0\u0007\u0012#\b\u0002\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\n0\u0007\u0012#\b\u0002\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010#\u001a\u00020\bJ\u0016\u0010$\u001a\u00020\n2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\u0006\u0010&\u001a\u00020\nJ\u0006\u0010'\u001a\u00020\u0005J\u0006\u0010(\u001a\u00020\u0005J\u000e\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005J\n\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u0010\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020,H\u0002J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\n0\fX\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b!\u0010\"Ê\u0001\f\b5\u0012\b\b6\u0012\u0004\b\u0003\u0010\u0000¨\u00064"}, d2 = {"Lcom/arizona/launcher/util/FileServerPool;", "", "buildServers", "Lkotlin/Function0;", "", "", "isServerAvailable", "Lkotlin/Function1;", "", "launchAsync", "", "onReachabilityResult", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "server", "reachable", "onSelected", "onNoReachableServer", "fallback", "onChanged", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "lock", "cachedServers", "cursor", "", "generation", "", "probeStarted", "probeCompleted", "selectionClaimed", "servers", "getServers", "()Ljava/util/List;", "refresh", "reset", "preloadedServers", "warmUpAsync", UpdateServiceContract.BundleKey.CURRENT, "restartFromFirst", "advance", "failedServer", "createProbeWorkLocked", "Lcom/arizona/launcher/util/FileServerPool$ProbeWork;", "runProbe", "work", "serversLocked", "validated", "ProbeWork", "Selection", "SelectionChange", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FileServerPool {
    public static final int $stable = 8;
    private final Function0<List<String>> buildServers;
    private List<String> cachedServers;
    private int cursor;
    private long generation;
    private final Function1<String, Boolean> isServerAvailable;
    private final Function1<Function0<Unit>, Unit> launchAsync;
    private final Object lock;
    private final Function1<String, Unit> onChanged;
    private final Function1<String, Unit> onNoReachableServer;
    private final Function2<String, Boolean, Unit> onReachabilityResult;
    private final Function1<String, Unit> onSelected;
    private boolean probeCompleted;
    private boolean probeStarted;
    private boolean selectionClaimed;

    /* JADX WARN: Multi-variable type inference failed */
    public FileServerPool(Function0<? extends List<String>> buildServers, Function1<? super String, Boolean> isServerAvailable, Function1<? super Function0<Unit>, Unit> launchAsync, Function2<? super String, ? super Boolean, Unit> onReachabilityResult, Function1<? super String, Unit> onSelected, Function1<? super String, Unit> onNoReachableServer, Function1<? super String, Unit> onChanged) {
        Intrinsics.checkNotNullParameter(buildServers, "buildServers");
        Intrinsics.checkNotNullParameter(isServerAvailable, "isServerAvailable");
        Intrinsics.checkNotNullParameter(launchAsync, "launchAsync");
        Intrinsics.checkNotNullParameter(onReachabilityResult, "onReachabilityResult");
        Intrinsics.checkNotNullParameter(onSelected, "onSelected");
        Intrinsics.checkNotNullParameter(onNoReachableServer, "onNoReachableServer");
        Intrinsics.checkNotNullParameter(onChanged, "onChanged");
        this.buildServers = buildServers;
        this.isServerAvailable = isServerAvailable;
        this.launchAsync = launchAsync;
        this.onReachabilityResult = onReachabilityResult;
        this.onSelected = onSelected;
        this.onNoReachableServer = onNoReachableServer;
        this.onChanged = onChanged;
        this.lock = new Object();
    }

    public /* synthetic */ FileServerPool(Function0 function0, Function1 function1, Function1 function12, Function2 function2, Function1 function13, Function1 function14, Function1 function15, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, function1, function12, (i & 8) != 0 ? new Function2() { // from class: com.arizona.launcher.util.FileServerPool$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return FileServerPool._init_$lambda$0((String) obj, ((Boolean) obj2).booleanValue());
            }
        } : function2, (i & 16) != 0 ? new Function1() { // from class: com.arizona.launcher.util.FileServerPool$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileServerPool._init_$lambda$1((String) obj);
            }
        } : function13, (i & 32) != 0 ? new Function1() { // from class: com.arizona.launcher.util.FileServerPool$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileServerPool._init_$lambda$2((String) obj);
            }
        } : function14, (i & 64) != 0 ? new Function1() { // from class: com.arizona.launcher.util.FileServerPool$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileServerPool._init_$lambda$3((String) obj);
            }
        } : function15);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$0(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$2(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$3(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final List<String> getServers() {
        List<String> list;
        synchronized (this.lock) {
            list = CollectionsKt.toList(serversLocked());
        }
        return list;
    }

    public final boolean refresh() {
        boolean z;
        List<String> validated = validated(this.buildServers.invoke());
        synchronized (this.lock) {
            z = false;
            if (!Intrinsics.areEqual(this.cachedServers, validated)) {
                this.cachedServers = validated;
                this.cursor = 0;
                this.generation++;
                this.probeStarted = false;
                this.probeCompleted = false;
                this.selectionClaimed = false;
                z = true;
            }
        }
        return z;
    }

    public final void reset(List<String> list) {
        List<String> validated;
        synchronized (this.lock) {
            if (list != null) {
                try {
                    validated = validated(list);
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                validated = null;
            }
            this.cachedServers = validated;
            this.cursor = 0;
            this.generation++;
            this.probeStarted = list != null;
            this.probeCompleted = list != null;
            this.selectionClaimed = list != null;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void warmUpAsync() {
        final ProbeWork createProbeWorkLocked;
        synchronized (this.lock) {
            createProbeWorkLocked = createProbeWorkLocked();
        }
        if (createProbeWorkLocked == null) {
            return;
        }
        this.launchAsync.invoke(new Function0() { // from class: com.arizona.launcher.util.FileServerPool$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FileServerPool.warmUpAsync$lambda$1(FileServerPool.this, createProbeWorkLocked);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit warmUpAsync$lambda$1(FileServerPool fileServerPool, ProbeWork probeWork) {
        fileServerPool.runProbe(probeWork);
        return Unit.INSTANCE;
    }

    public final String current() {
        Selection selection;
        synchronized (this.lock) {
            List<String> serversLocked = serversLocked();
            ProbeWork createProbeWorkLocked = createProbeWorkLocked();
            this.selectionClaimed = true;
            selection = new Selection(serversLocked.get(RangesKt.coerceIn(this.cursor, 0, CollectionsKt.getLastIndex(serversLocked))), createProbeWorkLocked);
        }
        final ProbeWork probeWork = selection.getProbeWork();
        if (probeWork != null) {
            this.launchAsync.invoke(new Function0() { // from class: com.arizona.launcher.util.FileServerPool$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit current$lambda$1$0;
                    current$lambda$1$0 = FileServerPool.current$lambda$1$0(FileServerPool.this, probeWork);
                    return current$lambda$1$0;
                }
            });
        }
        return selection.getServer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit current$lambda$1$0(FileServerPool fileServerPool, ProbeWork probeWork) {
        fileServerPool.runProbe(probeWork);
        return Unit.INSTANCE;
    }

    public final String restartFromFirst() {
        SelectionChange selectionChange;
        synchronized (this.lock) {
            List<String> serversLocked = serversLocked();
            boolean z = this.cursor != 0;
            this.cursor = 0;
            this.selectionClaimed = true;
            selectionChange = new SelectionChange((String) CollectionsKt.first((List<? extends Object>) serversLocked), z);
        }
        if (selectionChange.getChanged()) {
            this.onChanged.invoke(selectionChange.getServer());
        }
        return selectionChange.getServer();
    }

    public final String advance(String failedServer) {
        String str;
        Intrinsics.checkNotNullParameter(failedServer, "failedServer");
        synchronized (this.lock) {
            List<String> serversLocked = serversLocked();
            this.selectionClaimed = true;
            int indexOf = serversLocked.indexOf(failedServer);
            if (indexOf >= 0) {
                this.cursor = (indexOf + 1) % serversLocked.size();
            }
            str = serversLocked.get(this.cursor);
        }
        this.onChanged.invoke(str);
        return str;
    }

    private final ProbeWork createProbeWorkLocked() {
        if (this.probeStarted || this.probeCompleted) {
            return null;
        }
        this.probeStarted = true;
        return new ProbeWork(this.generation, CollectionsKt.toList(serversLocked()));
    }

    private final void runProbe(ProbeWork probeWork) {
        String str;
        Integer num;
        Iterator<T> it = probeWork.getServers().iterator();
        int i = 0;
        while (true) {
            str = null;
            if (!it.hasNext()) {
                num = null;
                break;
            }
            int i2 = i + 1;
            String str2 = (String) it.next();
            boolean booleanValue = this.isServerAvailable.invoke(str2).booleanValue();
            this.onReachabilityResult.invoke(str2, Boolean.valueOf(booleanValue));
            if (booleanValue) {
                num = Integer.valueOf(i);
                break;
            }
            i = i2;
        }
        synchronized (this.lock) {
            if (this.generation == probeWork.getGeneration()) {
                this.probeStarted = false;
                this.probeCompleted = true;
                if (!this.selectionClaimed) {
                    this.cursor = num != null ? num.intValue() : 0;
                }
                List<String> serversLocked = serversLocked();
                str = serversLocked.get(RangesKt.coerceIn(this.cursor, 0, CollectionsKt.getLastIndex(serversLocked)));
            }
        }
        if (str == null) {
            return;
        }
        if (num == null) {
            this.onNoReachableServer.invoke(str);
        } else {
            this.onSelected.invoke(str);
        }
    }

    private final List<String> serversLocked() {
        List<String> list = this.cachedServers;
        if (list == null) {
            List<String> validated = validated(this.buildServers.invoke());
            this.cachedServers = validated;
            return validated;
        }
        return list;
    }

    private final List<String> validated(List<String> list) {
        List<String> list2 = CollectionsKt.toList(list);
        if (list2.isEmpty()) {
            throw new IllegalArgumentException("File-server list must not be empty".toString());
        }
        return list2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileServerPool.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/util/FileServerPool$ProbeWork;", "", "generation", "", "servers", "", "", "<init>", "(JLjava/util/List;)V", "getGeneration", "()J", "getServers", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ProbeWork {
        private final long generation;
        private final List<String> servers;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ProbeWork copy$default(ProbeWork probeWork, long j, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                j = probeWork.generation;
            }
            if ((i & 2) != 0) {
                list = probeWork.servers;
            }
            return probeWork.copy(j, list);
        }

        public final long component1() {
            return this.generation;
        }

        public final List<String> component2() {
            return this.servers;
        }

        public final ProbeWork copy(long j, List<String> servers) {
            Intrinsics.checkNotNullParameter(servers, "servers");
            return new ProbeWork(j, servers);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ProbeWork) {
                ProbeWork probeWork = (ProbeWork) obj;
                return this.generation == probeWork.generation && Intrinsics.areEqual(this.servers, probeWork.servers);
            }
            return false;
        }

        public int hashCode() {
            return (Long.hashCode(this.generation) * 31) + this.servers.hashCode();
        }

        public String toString() {
            long j = this.generation;
            return "ProbeWork(generation=" + j + ", servers=" + this.servers + ")";
        }

        public ProbeWork(long j, List<String> servers) {
            Intrinsics.checkNotNullParameter(servers, "servers");
            this.generation = j;
            this.servers = servers;
        }

        public final long getGeneration() {
            return this.generation;
        }

        public final List<String> getServers() {
            return this.servers;
        }
    }

    /* compiled from: FileServerPool.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/arizona/launcher/util/FileServerPool$Selection;", "", "server", "", "probeWork", "Lcom/arizona/launcher/util/FileServerPool$ProbeWork;", "<init>", "(Ljava/lang/String;Lcom/arizona/launcher/util/FileServerPool$ProbeWork;)V", "getServer", "()Ljava/lang/String;", "getProbeWork", "()Lcom/arizona/launcher/util/FileServerPool$ProbeWork;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Selection {
        private final ProbeWork probeWork;
        private final String server;

        public static /* synthetic */ Selection copy$default(Selection selection, String str, ProbeWork probeWork, int i, Object obj) {
            if ((i & 1) != 0) {
                str = selection.server;
            }
            if ((i & 2) != 0) {
                probeWork = selection.probeWork;
            }
            return selection.copy(str, probeWork);
        }

        public final String component1() {
            return this.server;
        }

        public final ProbeWork component2() {
            return this.probeWork;
        }

        public final Selection copy(String server, ProbeWork probeWork) {
            Intrinsics.checkNotNullParameter(server, "server");
            return new Selection(server, probeWork);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Selection) {
                Selection selection = (Selection) obj;
                return Intrinsics.areEqual(this.server, selection.server) && Intrinsics.areEqual(this.probeWork, selection.probeWork);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.server.hashCode() * 31;
            ProbeWork probeWork = this.probeWork;
            return hashCode + (probeWork == null ? 0 : probeWork.hashCode());
        }

        public String toString() {
            String str = this.server;
            return "Selection(server=" + str + ", probeWork=" + this.probeWork + ")";
        }

        public Selection(String server, ProbeWork probeWork) {
            Intrinsics.checkNotNullParameter(server, "server");
            this.server = server;
            this.probeWork = probeWork;
        }

        public final String getServer() {
            return this.server;
        }

        public final ProbeWork getProbeWork() {
            return this.probeWork;
        }
    }

    /* compiled from: FileServerPool.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/arizona/launcher/util/FileServerPool$SelectionChange;", "", "server", "", "changed", "", "<init>", "(Ljava/lang/String;Z)V", "getServer", "()Ljava/lang/String;", "getChanged", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class SelectionChange {
        private final boolean changed;
        private final String server;

        public static /* synthetic */ SelectionChange copy$default(SelectionChange selectionChange, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = selectionChange.server;
            }
            if ((i & 2) != 0) {
                z = selectionChange.changed;
            }
            return selectionChange.copy(str, z);
        }

        public final String component1() {
            return this.server;
        }

        public final boolean component2() {
            return this.changed;
        }

        public final SelectionChange copy(String server, boolean z) {
            Intrinsics.checkNotNullParameter(server, "server");
            return new SelectionChange(server, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SelectionChange) {
                SelectionChange selectionChange = (SelectionChange) obj;
                return Intrinsics.areEqual(this.server, selectionChange.server) && this.changed == selectionChange.changed;
            }
            return false;
        }

        public int hashCode() {
            return (this.server.hashCode() * 31) + Boolean.hashCode(this.changed);
        }

        public String toString() {
            String str = this.server;
            return "SelectionChange(server=" + str + ", changed=" + this.changed + ")";
        }

        public SelectionChange(String server, boolean z) {
            Intrinsics.checkNotNullParameter(server, "server");
            this.server = server;
            this.changed = z;
        }

        public final String getServer() {
            return this.server;
        }

        public final boolean getChanged() {
            return this.changed;
        }
    }
}
