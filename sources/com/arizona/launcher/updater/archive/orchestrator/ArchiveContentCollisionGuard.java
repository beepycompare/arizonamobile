package com.arizona.launcher.updater.archive.orchestrator;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.launcher.updater.archive.transaction.ArchiveOwnedPath;
import com.arizona.launcher.updater.archive.transaction.ArchiveOwnershipDiffPlanner;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: ArchiveContentCollisionGuard.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0010\u001a\u00020\u000eH\u0002JN\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\r2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J&\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\r2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J&\u0010\u001d\u001a\u0004\u0018\u00010\b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\r2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002Ê\u0001\f\b \u0012\b\b!\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001f"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveContentCollisionGuard;", "", "<init>", "()V", "validate", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveContentCollisionResult;", "baseDesired", "", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;", "viceDesired", "baseCurrent", "viceCurrent", "ownershipIndex", "Ljava/util/TreeMap;", "", "ownership", Constants.ScionAnalytics.PARAM_LABEL, "appendCrossLaneCollisions", "", "collisions", "", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveContentCollision;", TtmlNode.RUBY_BASE, "vice", "baseSource", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveContentOwnershipSource;", "viceSource", "findAncestor", "path", "findDescendant", "CollisionKey", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveContentCollisionGuard {
    public static final int $stable = 0;
    public static final ArchiveContentCollisionGuard INSTANCE = new ArchiveContentCollisionGuard();

    private ArchiveContentCollisionGuard() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArchiveContentCollisionResult validate$default(ArchiveContentCollisionGuard archiveContentCollisionGuard, Iterable iterable, Iterable iterable2, Iterable iterable3, Iterable iterable4, int i, Object obj) {
        if ((i & 4) != 0) {
            iterable3 = CollectionsKt.emptyList();
        }
        if ((i & 8) != 0) {
            iterable4 = CollectionsKt.emptyList();
        }
        return archiveContentCollisionGuard.validate(iterable, iterable2, iterable3, iterable4);
    }

    public final ArchiveContentCollisionResult validate(Iterable<ArchiveOwnedPath> baseDesired, Iterable<ArchiveOwnedPath> viceDesired, Iterable<ArchiveOwnedPath> baseCurrent, Iterable<ArchiveOwnedPath> viceCurrent) {
        Intrinsics.checkNotNullParameter(baseDesired, "baseDesired");
        Intrinsics.checkNotNullParameter(viceDesired, "viceDesired");
        Intrinsics.checkNotNullParameter(baseCurrent, "baseCurrent");
        Intrinsics.checkNotNullParameter(viceCurrent, "viceCurrent");
        TreeMap<String, ArchiveOwnedPath> ownershipIndex = ownershipIndex(baseDesired, "BASE desired ownership");
        TreeMap<String, ArchiveOwnedPath> ownershipIndex2 = ownershipIndex(viceDesired, "VICE desired ownership");
        TreeMap<String, ArchiveOwnedPath> ownershipIndex3 = ownershipIndex(baseCurrent, "BASE current ownership");
        TreeMap<String, ArchiveOwnedPath> ownershipIndex4 = ownershipIndex(viceCurrent, "VICE current ownership");
        ArrayList arrayList = new ArrayList();
        appendCrossLaneCollisions(arrayList, ownershipIndex, ownershipIndex2, ArchiveContentOwnershipSource.DESIRED, ArchiveContentOwnershipSource.DESIRED);
        appendCrossLaneCollisions(arrayList, ownershipIndex3, ownershipIndex4, ArchiveContentOwnershipSource.CURRENT, ArchiveContentOwnershipSource.CURRENT);
        appendCrossLaneCollisions(arrayList, ownershipIndex3, ownershipIndex2, ArchiveContentOwnershipSource.CURRENT, ArchiveContentOwnershipSource.DESIRED);
        appendCrossLaneCollisions(arrayList, ownershipIndex, ownershipIndex4, ArchiveContentOwnershipSource.DESIRED, ArchiveContentOwnershipSource.CURRENT);
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            ArchiveContentCollision archiveContentCollision = (ArchiveContentCollision) obj;
            ArchiveContentCollisionKind kind = archiveContentCollision.getKind();
            String relativePath = archiveContentCollision.getBase().getRelativePath();
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = relativePath.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String relativePath2 = archiveContentCollision.getVice().getRelativePath();
            Locale ROOT2 = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT2, "ROOT");
            String lowerCase2 = relativePath2.toLowerCase(ROOT2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (hashSet.add(new CollisionKey(kind, lowerCase, lowerCase2, archiveContentCollision.getBaseSource(), archiveContentCollision.getViceSource()))) {
                arrayList2.add(obj);
            }
        }
        return new ArchiveContentCollisionResult(arrayList2);
    }

    private final TreeMap<String, ArchiveOwnedPath> ownershipIndex(Iterable<ArchiveOwnedPath> iterable, String str) {
        TreeMap<String, ArchiveOwnedPath> treeMap = new TreeMap<>();
        treeMap.putAll(ArchiveOwnershipDiffPlanner.INSTANCE.validatedOwnership(iterable, str));
        return treeMap;
    }

    private final void appendCrossLaneCollisions(List<ArchiveContentCollision> list, TreeMap<String, ArchiveOwnedPath> treeMap, TreeMap<String, ArchiveOwnedPath> treeMap2, ArchiveContentOwnershipSource archiveContentOwnershipSource, ArchiveContentOwnershipSource archiveContentOwnershipSource2) {
        ArchiveContentOwnershipSource archiveContentOwnershipSource3;
        ArchiveContentOwnershipSource archiveContentOwnershipSource4;
        for (Map.Entry<String, ArchiveOwnedPath> entry : treeMap.entrySet()) {
            String key = entry.getKey();
            ArchiveOwnedPath value = entry.getValue();
            ArchiveOwnedPath archiveOwnedPath = treeMap2.get(key);
            if (archiveOwnedPath != null) {
                archiveContentOwnershipSource3 = archiveContentOwnershipSource;
                archiveContentOwnershipSource4 = archiveContentOwnershipSource2;
                list.add(new ArchiveContentCollision(ArchiveContentCollisionKind.EXACT_PATH, value, archiveOwnedPath, archiveContentOwnershipSource3, archiveContentOwnershipSource4));
            } else {
                archiveContentOwnershipSource3 = archiveContentOwnershipSource;
                archiveContentOwnershipSource4 = archiveContentOwnershipSource2;
                ArchiveContentCollisionGuard archiveContentCollisionGuard = INSTANCE;
                ArchiveOwnedPath findAncestor = archiveContentCollisionGuard.findAncestor(treeMap2, key);
                if (findAncestor != null) {
                    list.add(new ArchiveContentCollision(ArchiveContentCollisionKind.FILE_DESCENDANT, value, findAncestor, archiveContentOwnershipSource3, archiveContentOwnershipSource4));
                } else {
                    ArchiveOwnedPath findDescendant = archiveContentCollisionGuard.findDescendant(treeMap2, key);
                    if (findDescendant != null) {
                        list.add(new ArchiveContentCollision(ArchiveContentCollisionKind.FILE_DESCENDANT, value, findDescendant, archiveContentOwnershipSource3, archiveContentOwnershipSource4));
                    }
                }
            }
            archiveContentOwnershipSource = archiveContentOwnershipSource3;
            archiveContentOwnershipSource2 = archiveContentOwnershipSource4;
        }
    }

    private final ArchiveOwnedPath findAncestor(TreeMap<String, ArchiveOwnedPath> treeMap, String str) {
        String str2 = str;
        for (int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str2, '/', 0, false, 6, (Object) null); lastIndexOf$default > 0; lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str2, '/', lastIndexOf$default - 1, false, 4, (Object) null)) {
            String substring = str.substring(0, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            ArchiveOwnedPath archiveOwnedPath = treeMap.get(substring);
            if (archiveOwnedPath != null) {
                return archiveOwnedPath;
            }
        }
        return null;
    }

    private final ArchiveOwnedPath findDescendant(TreeMap<String, ArchiveOwnedPath> treeMap, String str) {
        String str2 = str + "/";
        Set<Map.Entry<String, ArchiveOwnedPath>> entrySet = treeMap.tailMap(str2).entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "<get-entries>(...)");
        Map.Entry entry = (Map.Entry) CollectionsKt.firstOrNull(entrySet);
        if (entry == null) {
            return null;
        }
        Object value = entry.getValue();
        ArchiveOwnedPath archiveOwnedPath = (ArchiveOwnedPath) value;
        Object key = entry.getKey();
        Intrinsics.checkNotNullExpressionValue(key, "<get-key>(...)");
        return StringsKt.startsWith$default((String) key, str2, false, 2, (Object) null) ? value : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchiveContentCollisionGuard.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006 "}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveContentCollisionGuard$CollisionKey;", "", "kind", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveContentCollisionKind;", "basePath", "", "vicePath", "baseSource", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveContentOwnershipSource;", "viceSource", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveContentCollisionKind;Ljava/lang/String;Ljava/lang/String;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveContentOwnershipSource;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveContentOwnershipSource;)V", "getKind", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveContentCollisionKind;", "getBasePath", "()Ljava/lang/String;", "getVicePath", "getBaseSource", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveContentOwnershipSource;", "getViceSource", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class CollisionKey {
        private final String basePath;
        private final ArchiveContentOwnershipSource baseSource;
        private final ArchiveContentCollisionKind kind;
        private final String vicePath;
        private final ArchiveContentOwnershipSource viceSource;

        public static /* synthetic */ CollisionKey copy$default(CollisionKey collisionKey, ArchiveContentCollisionKind archiveContentCollisionKind, String str, String str2, ArchiveContentOwnershipSource archiveContentOwnershipSource, ArchiveContentOwnershipSource archiveContentOwnershipSource2, int i, Object obj) {
            if ((i & 1) != 0) {
                archiveContentCollisionKind = collisionKey.kind;
            }
            if ((i & 2) != 0) {
                str = collisionKey.basePath;
            }
            if ((i & 4) != 0) {
                str2 = collisionKey.vicePath;
            }
            if ((i & 8) != 0) {
                archiveContentOwnershipSource = collisionKey.baseSource;
            }
            if ((i & 16) != 0) {
                archiveContentOwnershipSource2 = collisionKey.viceSource;
            }
            ArchiveContentOwnershipSource archiveContentOwnershipSource3 = archiveContentOwnershipSource2;
            String str3 = str2;
            return collisionKey.copy(archiveContentCollisionKind, str, str3, archiveContentOwnershipSource, archiveContentOwnershipSource3);
        }

        public final ArchiveContentCollisionKind component1() {
            return this.kind;
        }

        public final String component2() {
            return this.basePath;
        }

        public final String component3() {
            return this.vicePath;
        }

        public final ArchiveContentOwnershipSource component4() {
            return this.baseSource;
        }

        public final ArchiveContentOwnershipSource component5() {
            return this.viceSource;
        }

        public final CollisionKey copy(ArchiveContentCollisionKind kind, String basePath, String vicePath, ArchiveContentOwnershipSource baseSource, ArchiveContentOwnershipSource viceSource) {
            Intrinsics.checkNotNullParameter(kind, "kind");
            Intrinsics.checkNotNullParameter(basePath, "basePath");
            Intrinsics.checkNotNullParameter(vicePath, "vicePath");
            Intrinsics.checkNotNullParameter(baseSource, "baseSource");
            Intrinsics.checkNotNullParameter(viceSource, "viceSource");
            return new CollisionKey(kind, basePath, vicePath, baseSource, viceSource);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CollisionKey) {
                CollisionKey collisionKey = (CollisionKey) obj;
                return this.kind == collisionKey.kind && Intrinsics.areEqual(this.basePath, collisionKey.basePath) && Intrinsics.areEqual(this.vicePath, collisionKey.vicePath) && this.baseSource == collisionKey.baseSource && this.viceSource == collisionKey.viceSource;
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.kind.hashCode() * 31) + this.basePath.hashCode()) * 31) + this.vicePath.hashCode()) * 31) + this.baseSource.hashCode()) * 31) + this.viceSource.hashCode();
        }

        public String toString() {
            ArchiveContentCollisionKind archiveContentCollisionKind = this.kind;
            String str = this.basePath;
            String str2 = this.vicePath;
            ArchiveContentOwnershipSource archiveContentOwnershipSource = this.baseSource;
            return "CollisionKey(kind=" + archiveContentCollisionKind + ", basePath=" + str + ", vicePath=" + str2 + ", baseSource=" + archiveContentOwnershipSource + ", viceSource=" + this.viceSource + ")";
        }

        public CollisionKey(ArchiveContentCollisionKind kind, String basePath, String vicePath, ArchiveContentOwnershipSource baseSource, ArchiveContentOwnershipSource viceSource) {
            Intrinsics.checkNotNullParameter(kind, "kind");
            Intrinsics.checkNotNullParameter(basePath, "basePath");
            Intrinsics.checkNotNullParameter(vicePath, "vicePath");
            Intrinsics.checkNotNullParameter(baseSource, "baseSource");
            Intrinsics.checkNotNullParameter(viceSource, "viceSource");
            this.kind = kind;
            this.basePath = basePath;
            this.vicePath = vicePath;
            this.baseSource = baseSource;
            this.viceSource = viceSource;
        }

        public final ArchiveContentCollisionKind getKind() {
            return this.kind;
        }

        public final String getBasePath() {
            return this.basePath;
        }

        public final String getVicePath() {
            return this.vicePath;
        }

        public final ArchiveContentOwnershipSource getBaseSource() {
            return this.baseSource;
        }

        public final ArchiveContentOwnershipSource getViceSource() {
            return this.viceSource;
        }
    }
}
