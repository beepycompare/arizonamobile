package ru.mrlargha.commonui.elements.hud.mission_progress;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MissionProgressData.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/hud/mission_progress/MissionGroupData;", "", "id", "", "title", "", "quests", "", "Lru/mrlargha/commonui/elements/hud/mission_progress/MissionData;", "<init>", "(ILjava/lang/String;Ljava/util/List;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getQuests", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MissionGroupData {
    private final int id;
    private final List<MissionData> quests;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MissionGroupData copy$default(MissionGroupData missionGroupData, int i, String str, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = missionGroupData.id;
        }
        if ((i2 & 2) != 0) {
            str = missionGroupData.title;
        }
        if ((i2 & 4) != 0) {
            list = missionGroupData.quests;
        }
        return missionGroupData.copy(i, str, list);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final List<MissionData> component3() {
        return this.quests;
    }

    public final MissionGroupData copy(int i, String title, List<MissionData> quests) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(quests, "quests");
        return new MissionGroupData(i, title, quests);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MissionGroupData) {
            MissionGroupData missionGroupData = (MissionGroupData) obj;
            return this.id == missionGroupData.id && Intrinsics.areEqual(this.title, missionGroupData.title) && Intrinsics.areEqual(this.quests, missionGroupData.quests);
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.quests.hashCode();
    }

    public String toString() {
        int i = this.id;
        String str = this.title;
        return "MissionGroupData(id=" + i + ", title=" + str + ", quests=" + this.quests + ")";
    }

    public MissionGroupData(int i, String title, List<MissionData> quests) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(quests, "quests");
        this.id = i;
        this.title = title;
        this.quests = quests;
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<MissionData> getQuests() {
        return this.quests;
    }
}
