package ru.mrlargha.commonui.elements.authorization.domain.controller;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: RegistrationVideoModeType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/domain/controller/RegistrationVideoModeType;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "VIDEO_AUTHORIZATION", "VIDEO_REGISTRATION", "VIDEO_HIDE", "STOP_VIDEO", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RegistrationVideoModeType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RegistrationVideoModeType[] $VALUES;
    private final int id;
    public static final RegistrationVideoModeType VIDEO_AUTHORIZATION = new RegistrationVideoModeType("VIDEO_AUTHORIZATION", 0, 0);
    public static final RegistrationVideoModeType VIDEO_REGISTRATION = new RegistrationVideoModeType("VIDEO_REGISTRATION", 1, 1);
    public static final RegistrationVideoModeType VIDEO_HIDE = new RegistrationVideoModeType("VIDEO_HIDE", 2, 2);
    public static final RegistrationVideoModeType STOP_VIDEO = new RegistrationVideoModeType("STOP_VIDEO", 3, 3);

    private static final /* synthetic */ RegistrationVideoModeType[] $values() {
        return new RegistrationVideoModeType[]{VIDEO_AUTHORIZATION, VIDEO_REGISTRATION, VIDEO_HIDE, STOP_VIDEO};
    }

    public static EnumEntries<RegistrationVideoModeType> getEntries() {
        return $ENTRIES;
    }

    private RegistrationVideoModeType(String str, int i, int i2) {
        this.id = i2;
    }

    public final int getId() {
        return this.id;
    }

    static {
        RegistrationVideoModeType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static RegistrationVideoModeType valueOf(String str) {
        return (RegistrationVideoModeType) Enum.valueOf(RegistrationVideoModeType.class, str);
    }

    public static RegistrationVideoModeType[] values() {
        return (RegistrationVideoModeType[]) $VALUES.clone();
    }
}
