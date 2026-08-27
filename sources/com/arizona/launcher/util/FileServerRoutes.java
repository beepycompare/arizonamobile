package com.arizona.launcher.util;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FileServerRouteResolver.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0004HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tÊ\u0001\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0014"}, d2 = {"Lcom/arizona/launcher/util/FileServerRoutes;", "", "channelRoots", "", "", "archiveCatalogs", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getChannelRoots", "()Ljava/util/List;", "getArchiveCatalogs", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FileServerRoutes {
    public static final int $stable = 0;
    private final List<String> archiveCatalogs;
    private final List<String> channelRoots;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FileServerRoutes copy$default(FileServerRoutes fileServerRoutes, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = fileServerRoutes.channelRoots;
        }
        if ((i & 2) != 0) {
            list2 = fileServerRoutes.archiveCatalogs;
        }
        return fileServerRoutes.copy(list, list2);
    }

    public final List<String> component1() {
        return this.channelRoots;
    }

    public final List<String> component2() {
        return this.archiveCatalogs;
    }

    public final FileServerRoutes copy(List<String> channelRoots, List<String> archiveCatalogs) {
        Intrinsics.checkNotNullParameter(channelRoots, "channelRoots");
        Intrinsics.checkNotNullParameter(archiveCatalogs, "archiveCatalogs");
        return new FileServerRoutes(channelRoots, archiveCatalogs);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FileServerRoutes) {
            FileServerRoutes fileServerRoutes = (FileServerRoutes) obj;
            return Intrinsics.areEqual(this.channelRoots, fileServerRoutes.channelRoots) && Intrinsics.areEqual(this.archiveCatalogs, fileServerRoutes.archiveCatalogs);
        }
        return false;
    }

    public int hashCode() {
        return (this.channelRoots.hashCode() * 31) + this.archiveCatalogs.hashCode();
    }

    public String toString() {
        List<String> list = this.channelRoots;
        return "FileServerRoutes(channelRoots=" + list + ", archiveCatalogs=" + this.archiveCatalogs + ")";
    }

    public FileServerRoutes(List<String> channelRoots, List<String> archiveCatalogs) {
        Intrinsics.checkNotNullParameter(channelRoots, "channelRoots");
        Intrinsics.checkNotNullParameter(archiveCatalogs, "archiveCatalogs");
        this.channelRoots = channelRoots;
        this.archiveCatalogs = archiveCatalogs;
    }

    public final List<String> getChannelRoots() {
        return this.channelRoots;
    }

    public final List<String> getArchiveCatalogs() {
        return this.archiveCatalogs;
    }
}
