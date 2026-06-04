package ru.mrlargha.commonui.utils;

import com.arizona.game.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Constants.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/utils/ProjectType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "ARIZONA", "RODINA", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ProjectType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ProjectType[] $VALUES;
    public static final ProjectType ARIZONA = new ProjectType("ARIZONA", 0, BuildConfig.FLAVOR);
    public static final ProjectType RODINA = new ProjectType("RODINA", 1, "rodina");
    private final String type;

    private static final /* synthetic */ ProjectType[] $values() {
        return new ProjectType[]{ARIZONA, RODINA};
    }

    public static EnumEntries<ProjectType> getEntries() {
        return $ENTRIES;
    }

    public static ProjectType valueOf(String str) {
        return (ProjectType) Enum.valueOf(ProjectType.class, str);
    }

    public static ProjectType[] values() {
        return (ProjectType[]) $VALUES.clone();
    }

    private ProjectType(String str, int i, String str2) {
        this.type = str2;
    }

    public final String getType() {
        return this.type;
    }

    static {
        ProjectType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
