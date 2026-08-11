package ru.mrlargha.feature.battlepassWinter2025.utils;

import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.feature.battlepassWinter2025.data.ActualTask;
import ru.mrlargha.feature.battlepassWinter2025.data.CommonTaskInfo;
/* compiled from: ArizonaMissionsState.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0005J\u000e\u0010 \u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0005J\u000e\u0010!\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005J\u001c\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010%\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0005J\u0006\u0010&\u001a\u00020'J\u0014\u0010(\u001a\u00020'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000f0\nJ\u0006\u0010*\u001a\u00020'J\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000b0\nR$\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR*\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u000b0\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR*\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u000f0\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u001e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0014¨\u0006,"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/utils/ArizonaMissionsState;", "", "<init>", "()V", "value", "", "cachedTier", "getCachedTier", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "", "Lru/mrlargha/feature/battlepassWinter2025/data/CommonTaskInfo;", "tableMissions", "getTableMissions", "()Ljava/util/List;", "Lru/mrlargha/feature/battlepassWinter2025/data/ActualTask;", "progress", "getProgress", "", "isAwaitingProgressSnapshot", "()Z", "isLoading", "loadCompletedForTier", "getLoadCompletedForTier", "loadGeneration", "Lru/mrlargha/feature/battlepassWinter2025/utils/AsyncLoadGeneration;", "getLoadGeneration", "()Lru/mrlargha/feature/battlepassWinter2025/utils/AsyncLoadGeneration;", "hasTable", "getHasTable", "needsLoad", "tier", "shouldClearVisibleForTier", "beginTierLoad", "acceptTable", "token", "missions", "failLoad", "beginProgressSnapshot", "", "replaceProgress", "snapshot", "clearVisibleTable", "applyProgressToMissions", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ArizonaMissionsState {
    private Integer cachedTier;
    private boolean isLoading;
    private boolean loadCompletedForTier;
    private List<CommonTaskInfo> tableMissions = CollectionsKt.emptyList();
    private List<ActualTask> progress = CollectionsKt.emptyList();
    private boolean isAwaitingProgressSnapshot = true;
    private final AsyncLoadGeneration loadGeneration = new AsyncLoadGeneration();

    public final Integer getCachedTier() {
        return this.cachedTier;
    }

    public final List<CommonTaskInfo> getTableMissions() {
        return this.tableMissions;
    }

    public final List<ActualTask> getProgress() {
        return this.progress;
    }

    public final boolean isAwaitingProgressSnapshot() {
        return this.isAwaitingProgressSnapshot;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final boolean getLoadCompletedForTier() {
        return this.loadCompletedForTier;
    }

    public final AsyncLoadGeneration getLoadGeneration() {
        return this.loadGeneration;
    }

    public final boolean getHasTable() {
        return !this.tableMissions.isEmpty();
    }

    public final boolean needsLoad(int i) {
        Integer num = this.cachedTier;
        if (num != null && num.intValue() == i) {
            if (this.isLoading) {
                return false;
            }
            return !this.loadCompletedForTier;
        }
        return true;
    }

    public final boolean shouldClearVisibleForTier(int i) {
        Integer num = this.cachedTier;
        if (num != null) {
            return num == null || num.intValue() != i;
        }
        return false;
    }

    public final int beginTierLoad(int i) {
        this.cachedTier = Integer.valueOf(i);
        this.tableMissions = CollectionsKt.emptyList();
        this.isLoading = true;
        this.loadCompletedForTier = false;
        return this.loadGeneration.next();
    }

    public final boolean acceptTable(int i, List<CommonTaskInfo> missions) {
        Intrinsics.checkNotNullParameter(missions, "missions");
        if (this.loadGeneration.isCurrent(i)) {
            if (missions.isEmpty()) {
                this.isLoading = false;
                this.loadCompletedForTier = false;
                return false;
            }
            this.tableMissions = missions;
            this.isLoading = false;
            this.loadCompletedForTier = true;
            return true;
        }
        return false;
    }

    public final boolean failLoad(int i) {
        if (this.loadGeneration.isCurrent(i)) {
            this.isLoading = false;
            this.loadCompletedForTier = false;
            return true;
        }
        return false;
    }

    public final void beginProgressSnapshot() {
        this.progress = CollectionsKt.emptyList();
        this.isAwaitingProgressSnapshot = true;
        for (CommonTaskInfo commonTaskInfo : this.tableMissions) {
            commonTaskInfo.setVisible(false);
            commonTaskInfo.setCurrentProgress(0);
        }
    }

    public final void replaceProgress(List<ActualTask> snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        this.progress = CollectionsKt.toList(snapshot);
        this.isAwaitingProgressSnapshot = false;
    }

    public final void clearVisibleTable() {
        this.tableMissions = CollectionsKt.emptyList();
    }

    public final List<CommonTaskInfo> applyProgressToMissions() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.progress.size());
        for (ActualTask actualTask : this.progress) {
            linkedHashMap.put(Integer.valueOf(actualTask.getId()), actualTask);
        }
        for (CommonTaskInfo commonTaskInfo : this.tableMissions) {
            ActualTask actualTask2 = (ActualTask) linkedHashMap.get(Integer.valueOf(commonTaskInfo.getId()));
            if (actualTask2 != null && actualTask2.getVisible() == 1) {
                commonTaskInfo.setVisible(true);
                commonTaskInfo.setCurrentProgress(actualTask2.getProgress());
            } else {
                commonTaskInfo.setVisible(false);
                commonTaskInfo.setCurrentProgress(0);
            }
        }
        return this.tableMissions;
    }
}
