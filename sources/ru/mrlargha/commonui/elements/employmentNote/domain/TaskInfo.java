package ru.mrlargha.commonui.elements.employmentNote.domain;

import kotlin.Metadata;
/* compiled from: TasksResponse.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/employmentNote/domain/TaskInfo;", "", "id", "", "progress", "max", "completed", "<init>", "(IIII)V", "getId", "()I", "getProgress", "getMax", "getCompleted", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TaskInfo {
    private final int completed;
    private final int id;
    private final int max;
    private final int progress;

    public static /* synthetic */ TaskInfo copy$default(TaskInfo taskInfo, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = taskInfo.id;
        }
        if ((i5 & 2) != 0) {
            i2 = taskInfo.progress;
        }
        if ((i5 & 4) != 0) {
            i3 = taskInfo.max;
        }
        if ((i5 & 8) != 0) {
            i4 = taskInfo.completed;
        }
        return taskInfo.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.progress;
    }

    public final int component3() {
        return this.max;
    }

    public final int component4() {
        return this.completed;
    }

    public final TaskInfo copy(int i, int i2, int i3, int i4) {
        return new TaskInfo(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TaskInfo) {
            TaskInfo taskInfo = (TaskInfo) obj;
            return this.id == taskInfo.id && this.progress == taskInfo.progress && this.max == taskInfo.max && this.completed == taskInfo.completed;
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.progress)) * 31) + Integer.hashCode(this.max)) * 31) + Integer.hashCode(this.completed);
    }

    public String toString() {
        int i = this.id;
        int i2 = this.progress;
        int i3 = this.max;
        return "TaskInfo(id=" + i + ", progress=" + i2 + ", max=" + i3 + ", completed=" + this.completed + ")";
    }

    public TaskInfo(int i, int i2, int i3, int i4) {
        this.id = i;
        this.progress = i2;
        this.max = i3;
        this.completed = i4;
    }

    public final int getId() {
        return this.id;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final int getMax() {
        return this.max;
    }

    public final int getCompleted() {
        return this.completed;
    }
}
