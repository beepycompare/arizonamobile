package ru.mrlargha.commonui.elements.battlepassWinter2025.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ActualTask.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/data/ActualTask;", "", "id", "", "categoryId", "", "progress", "visible", "<init>", "(ILjava/lang/String;II)V", "getId", "()I", "getCategoryId", "()Ljava/lang/String;", "getProgress", "getVisible", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActualTask {
    private final String categoryId;
    private final int id;
    private final int progress;
    private final int visible;

    public static /* synthetic */ ActualTask copy$default(ActualTask actualTask, int i, String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = actualTask.id;
        }
        if ((i4 & 2) != 0) {
            str = actualTask.categoryId;
        }
        if ((i4 & 4) != 0) {
            i2 = actualTask.progress;
        }
        if ((i4 & 8) != 0) {
            i3 = actualTask.visible;
        }
        return actualTask.copy(i, str, i2, i3);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.categoryId;
    }

    public final int component3() {
        return this.progress;
    }

    public final int component4() {
        return this.visible;
    }

    public final ActualTask copy(int i, String categoryId, int i2, int i3) {
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        return new ActualTask(i, categoryId, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ActualTask) {
            ActualTask actualTask = (ActualTask) obj;
            return this.id == actualTask.id && Intrinsics.areEqual(this.categoryId, actualTask.categoryId) && this.progress == actualTask.progress && this.visible == actualTask.visible;
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.id) * 31) + this.categoryId.hashCode()) * 31) + Integer.hashCode(this.progress)) * 31) + Integer.hashCode(this.visible);
    }

    public String toString() {
        int i = this.id;
        String str = this.categoryId;
        int i2 = this.progress;
        return "ActualTask(id=" + i + ", categoryId=" + str + ", progress=" + i2 + ", visible=" + this.visible + ")";
    }

    public ActualTask(int i, String categoryId, int i2, int i3) {
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        this.id = i;
        this.categoryId = categoryId;
        this.progress = i2;
        this.visible = i3;
    }

    public final int getId() {
        return this.id;
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final int getVisible() {
        return this.visible;
    }
}
