package ru.mrlargha.commonui.elements.quest.domain;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: QuestResponses.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/quest/domain/ActivityQuestResponse;", "", "name", "", "list", "", "Lru/mrlargha/commonui/elements/quest/domain/ActivityDoneInfo;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActivityQuestResponse {
    private final List<ActivityDoneInfo> list;
    private final String name;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ActivityQuestResponse copy$default(ActivityQuestResponse activityQuestResponse, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = activityQuestResponse.name;
        }
        if ((i & 2) != 0) {
            list = activityQuestResponse.list;
        }
        return activityQuestResponse.copy(str, list);
    }

    public final String component1() {
        return this.name;
    }

    public final List<ActivityDoneInfo> component2() {
        return this.list;
    }

    public final ActivityQuestResponse copy(String name, List<ActivityDoneInfo> list) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(list, "list");
        return new ActivityQuestResponse(name, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ActivityQuestResponse) {
            ActivityQuestResponse activityQuestResponse = (ActivityQuestResponse) obj;
            return Intrinsics.areEqual(this.name, activityQuestResponse.name) && Intrinsics.areEqual(this.list, activityQuestResponse.list);
        }
        return false;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.list.hashCode();
    }

    public String toString() {
        String str = this.name;
        return "ActivityQuestResponse(name=" + str + ", list=" + this.list + ")";
    }

    public ActivityQuestResponse(String name, List<ActivityDoneInfo> list) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(list, "list");
        this.name = name;
        this.list = list;
    }

    public final String getName() {
        return this.name;
    }

    public final List<ActivityDoneInfo> getList() {
        return this.list;
    }
}
