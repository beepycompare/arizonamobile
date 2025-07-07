package ru.mrlargha.commonui.elements.employmentNote.domain;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TasksResponse.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003JZ\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\b\u0010\u0014R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lru/mrlargha/commonui/elements/employmentNote/domain/TaskListResponse;", "", "member", "", "memberName", "", "rankName", "backgroundImage", "isUpgrade", "tasks", "", "Lru/mrlargha/commonui/elements/employmentNote/domain/TaskInfo;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V", "getMember", "()I", "getMemberName", "()Ljava/lang/String;", "getRankName", "getBackgroundImage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTasks", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)Lru/mrlargha/commonui/elements/employmentNote/domain/TaskListResponse;", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TaskListResponse {
    @SerializedName("background_image")
    private final String backgroundImage;
    @SerializedName("is_upgrade")
    private final Integer isUpgrade;
    private final int member;
    @SerializedName("member_name")
    private final String memberName;
    @SerializedName("rank_name")
    private final String rankName;
    private final List<TaskInfo> tasks;

    public static /* synthetic */ TaskListResponse copy$default(TaskListResponse taskListResponse, int i, String str, String str2, String str3, Integer num, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = taskListResponse.member;
        }
        if ((i2 & 2) != 0) {
            str = taskListResponse.memberName;
        }
        if ((i2 & 4) != 0) {
            str2 = taskListResponse.rankName;
        }
        if ((i2 & 8) != 0) {
            str3 = taskListResponse.backgroundImage;
        }
        if ((i2 & 16) != 0) {
            num = taskListResponse.isUpgrade;
        }
        List<TaskInfo> list2 = list;
        if ((i2 & 32) != 0) {
            list2 = taskListResponse.tasks;
        }
        Integer num2 = num;
        List list3 = list2;
        return taskListResponse.copy(i, str, str2, str3, num2, list3);
    }

    public final int component1() {
        return this.member;
    }

    public final String component2() {
        return this.memberName;
    }

    public final String component3() {
        return this.rankName;
    }

    public final String component4() {
        return this.backgroundImage;
    }

    public final Integer component5() {
        return this.isUpgrade;
    }

    public final List<TaskInfo> component6() {
        return this.tasks;
    }

    public final TaskListResponse copy(int i, String str, String str2, String str3, Integer num, List<TaskInfo> list) {
        return new TaskListResponse(i, str, str2, str3, num, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TaskListResponse) {
            TaskListResponse taskListResponse = (TaskListResponse) obj;
            return this.member == taskListResponse.member && Intrinsics.areEqual(this.memberName, taskListResponse.memberName) && Intrinsics.areEqual(this.rankName, taskListResponse.rankName) && Intrinsics.areEqual(this.backgroundImage, taskListResponse.backgroundImage) && Intrinsics.areEqual(this.isUpgrade, taskListResponse.isUpgrade) && Intrinsics.areEqual(this.tasks, taskListResponse.tasks);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.member) * 31;
        String str = this.memberName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.rankName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.backgroundImage;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.isUpgrade;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        List<TaskInfo> list = this.tasks;
        return hashCode5 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        int i = this.member;
        String str = this.memberName;
        String str2 = this.rankName;
        String str3 = this.backgroundImage;
        Integer num = this.isUpgrade;
        return "TaskListResponse(member=" + i + ", memberName=" + str + ", rankName=" + str2 + ", backgroundImage=" + str3 + ", isUpgrade=" + num + ", tasks=" + this.tasks + ")";
    }

    public TaskListResponse(int i, String str, String str2, String str3, Integer num, List<TaskInfo> list) {
        this.member = i;
        this.memberName = str;
        this.rankName = str2;
        this.backgroundImage = str3;
        this.isUpgrade = num;
        this.tasks = list;
    }

    public final int getMember() {
        return this.member;
    }

    public final String getMemberName() {
        return this.memberName;
    }

    public final String getRankName() {
        return this.rankName;
    }

    public final String getBackgroundImage() {
        return this.backgroundImage;
    }

    public final Integer isUpgrade() {
        return this.isUpgrade;
    }

    public final List<TaskInfo> getTasks() {
        return this.tasks;
    }
}
