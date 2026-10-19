package com.arizona.launcher.util;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FileServerRouteResolver.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J9\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0004HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nÊ\u0001\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0017"}, d2 = {"Lcom/arizona/launcher/util/FileServerRoutes;", "", "channelRoots", "", "", "launcherRoots", "archiveCatalogs", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getChannelRoots", "()Ljava/util/List;", "getLauncherRoots", "getArchiveCatalogs", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FileServerRoutes {
    public static final int $stable = 0;
    private final List<String> archiveCatalogs;
    private final List<String> channelRoots;
    private final List<String> launcherRoots;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FileServerRoutes copy$default(FileServerRoutes fileServerRoutes, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = fileServerRoutes.channelRoots;
        }
        if ((i & 2) != 0) {
            list2 = fileServerRoutes.launcherRoots;
        }
        if ((i & 4) != 0) {
            list3 = fileServerRoutes.archiveCatalogs;
        }
        return fileServerRoutes.copy(list, list2, list3);
    }

    public final List<String> component1() {
        return this.channelRoots;
    }

    public final List<String> component2() {
        return this.launcherRoots;
    }

    public final List<String> component3() {
        return this.archiveCatalogs;
    }

    public final FileServerRoutes copy(List<String> channelRoots, List<String> launcherRoots, List<String> archiveCatalogs) {
        Intrinsics.checkNotNullParameter(channelRoots, "channelRoots");
        Intrinsics.checkNotNullParameter(launcherRoots, "launcherRoots");
        Intrinsics.checkNotNullParameter(archiveCatalogs, "archiveCatalogs");
        return new FileServerRoutes(channelRoots, launcherRoots, archiveCatalogs);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FileServerRoutes) {
            FileServerRoutes fileServerRoutes = (FileServerRoutes) obj;
            return Intrinsics.areEqual(this.channelRoots, fileServerRoutes.channelRoots) && Intrinsics.areEqual(this.launcherRoots, fileServerRoutes.launcherRoots) && Intrinsics.areEqual(this.archiveCatalogs, fileServerRoutes.archiveCatalogs);
        }
        return false;
    }

    public int hashCode() {
        return (((this.channelRoots.hashCode() * 31) + this.launcherRoots.hashCode()) * 31) + this.archiveCatalogs.hashCode();
    }

    public String toString() {
        List<String> list = this.channelRoots;
        List<String> list2 = this.launcherRoots;
        return "FileServerRoutes(channelRoots=" + list + ", launcherRoots=" + list2 + ", archiveCatalogs=" + this.archiveCatalogs + ")";
    }

    public FileServerRoutes(List<String> channelRoots, List<String> launcherRoots, List<String> archiveCatalogs) {
        Intrinsics.checkNotNullParameter(channelRoots, "channelRoots");
        Intrinsics.checkNotNullParameter(launcherRoots, "launcherRoots");
        Intrinsics.checkNotNullParameter(archiveCatalogs, "archiveCatalogs");
        this.channelRoots = channelRoots;
        this.launcherRoots = launcherRoots;
        this.archiveCatalogs = archiveCatalogs;
    }

    public final List<String> getChannelRoots() {
        return this.channelRoots;
    }

    public final List<String> getLauncherRoots() {
        return this.launcherRoots;
    }

    public final List<String> getArchiveCatalogs() {
        return this.archiveCatalogs;
    }
}
