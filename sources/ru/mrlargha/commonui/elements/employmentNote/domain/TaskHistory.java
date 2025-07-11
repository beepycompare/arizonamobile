package ru.mrlargha.commonui.elements.employmentNote.domain;

import com.arizona.launcher.model.settings.SettingsConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TasksResponse.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003JV\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011¨\u0006%"}, d2 = {"Lru/mrlargha/commonui/elements/employmentNote/domain/TaskHistory;", "", "id", "", "memberName", "", "rankName", "date", "action", "description", SettingsConstants.NICKNAME, "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMemberName", "()Ljava/lang/String;", "getRankName", "getDate", "getAction", "getDescription", "getNickname", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/mrlargha/commonui/elements/employmentNote/domain/TaskHistory;", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TaskHistory {
    private final String action;
    private final String date;
    private final String description;
    private final Integer id;
    @SerializedName("member_name")
    private final String memberName;
    private final String nickname;
    @SerializedName("rank_name")
    private final String rankName;

    public static /* synthetic */ TaskHistory copy$default(TaskHistory taskHistory, Integer num, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            num = taskHistory.id;
        }
        if ((i & 2) != 0) {
            str = taskHistory.memberName;
        }
        if ((i & 4) != 0) {
            str2 = taskHistory.rankName;
        }
        if ((i & 8) != 0) {
            str3 = taskHistory.date;
        }
        if ((i & 16) != 0) {
            str4 = taskHistory.action;
        }
        if ((i & 32) != 0) {
            str5 = taskHistory.description;
        }
        if ((i & 64) != 0) {
            str6 = taskHistory.nickname;
        }
        String str7 = str5;
        String str8 = str6;
        String str9 = str4;
        String str10 = str2;
        return taskHistory.copy(num, str, str10, str3, str9, str7, str8);
    }

    public final Integer component1() {
        return this.id;
    }

    public final String component2() {
        return this.memberName;
    }

    public final String component3() {
        return this.rankName;
    }

    public final String component4() {
        return this.date;
    }

    public final String component5() {
        return this.action;
    }

    public final String component6() {
        return this.description;
    }

    public final String component7() {
        return this.nickname;
    }

    public final TaskHistory copy(Integer num, String memberName, String rankName, String date, String action, String description, String nickname) {
        Intrinsics.checkNotNullParameter(memberName, "memberName");
        Intrinsics.checkNotNullParameter(rankName, "rankName");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        return new TaskHistory(num, memberName, rankName, date, action, description, nickname);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TaskHistory) {
            TaskHistory taskHistory = (TaskHistory) obj;
            return Intrinsics.areEqual(this.id, taskHistory.id) && Intrinsics.areEqual(this.memberName, taskHistory.memberName) && Intrinsics.areEqual(this.rankName, taskHistory.rankName) && Intrinsics.areEqual(this.date, taskHistory.date) && Intrinsics.areEqual(this.action, taskHistory.action) && Intrinsics.areEqual(this.description, taskHistory.description) && Intrinsics.areEqual(this.nickname, taskHistory.nickname);
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.id;
        return ((((((((((((num == null ? 0 : num.hashCode()) * 31) + this.memberName.hashCode()) * 31) + this.rankName.hashCode()) * 31) + this.date.hashCode()) * 31) + this.action.hashCode()) * 31) + this.description.hashCode()) * 31) + this.nickname.hashCode();
    }

    public String toString() {
        Integer num = this.id;
        String str = this.memberName;
        String str2 = this.rankName;
        String str3 = this.date;
        String str4 = this.action;
        String str5 = this.description;
        return "TaskHistory(id=" + num + ", memberName=" + str + ", rankName=" + str2 + ", date=" + str3 + ", action=" + str4 + ", description=" + str5 + ", nickname=" + this.nickname + ")";
    }

    public TaskHistory(Integer num, String memberName, String rankName, String date, String action, String description, String nickname) {
        Intrinsics.checkNotNullParameter(memberName, "memberName");
        Intrinsics.checkNotNullParameter(rankName, "rankName");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        this.id = num;
        this.memberName = memberName;
        this.rankName = rankName;
        this.date = date;
        this.action = action;
        this.description = description;
        this.nickname = nickname;
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getMemberName() {
        return this.memberName;
    }

    public final String getRankName() {
        return this.rankName;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getNickname() {
        return this.nickname;
    }
}
