package ru.mrlargha.commonui.core;

import com.google.android.gms.stats.CodePackage;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: UIElementID.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/core/ProjectType;", "", "<init>", "(Ljava/lang/String;I)V", "RODINA", "ARIZONA", CodePackage.COMMON, "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProjectType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ProjectType[] $VALUES;
    public static final ProjectType RODINA = new ProjectType("RODINA", 0);
    public static final ProjectType ARIZONA = new ProjectType("ARIZONA", 1);
    public static final ProjectType COMMON = new ProjectType(CodePackage.COMMON, 2);

    private static final /* synthetic */ ProjectType[] $values() {
        return new ProjectType[]{RODINA, ARIZONA, COMMON};
    }

    public static EnumEntries<ProjectType> getEntries() {
        return $ENTRIES;
    }

    private ProjectType(String str, int i) {
    }

    static {
        ProjectType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ProjectType valueOf(String str) {
        return (ProjectType) Enum.valueOf(ProjectType.class, str);
    }

    public static ProjectType[] values() {
        return (ProjectType[]) $VALUES.clone();
    }
}
