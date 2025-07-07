package com.arkivanov.decompose.extensions.compose.stack.animation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Direction.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/stack/animation/Direction;", "", "<init>", "(Ljava/lang/String;I)V", "ENTER_FRONT", "EXIT_FRONT", "ENTER_BACK", "EXIT_BACK", "extensions-compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Direction {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Direction[] $VALUES;
    public static final Direction ENTER_FRONT = new Direction("ENTER_FRONT", 0);
    public static final Direction EXIT_FRONT = new Direction("EXIT_FRONT", 1);
    public static final Direction ENTER_BACK = new Direction("ENTER_BACK", 2);
    public static final Direction EXIT_BACK = new Direction("EXIT_BACK", 3);

    private static final /* synthetic */ Direction[] $values() {
        return new Direction[]{ENTER_FRONT, EXIT_FRONT, ENTER_BACK, EXIT_BACK};
    }

    public static EnumEntries<Direction> getEntries() {
        return $ENTRIES;
    }

    private Direction(String str, int i) {
    }

    static {
        Direction[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static Direction valueOf(String str) {
        return (Direction) Enum.valueOf(Direction.class, str);
    }

    public static Direction[] values() {
        return (Direction[]) $VALUES.clone();
    }
}
