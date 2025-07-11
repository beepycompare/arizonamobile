package ru.mrlargha.arizonaui.mobile.domain.obj;

import android.graphics.Color;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.appmetrica.analytics.impl.L2;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: MobilePhoneObject.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lru/mrlargha/arizonaui/mobile/domain/obj/AvatarBackground;", "", L2.g, "", "<init>", "(Ljava/lang/String;II)V", "getBackground", "()I", "RED", "ORANGE", "YELLOW", "GREEN_LIGHT", "GREEN", "GREY_GREEN", "GREY_BLUE", "BLUE", "DARK_PURPLE", "PURPLE", "LIGHT_PURPLE", "PINK", "Companion", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AvatarBackground {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AvatarBackground[] $VALUES;
    public static final Companion Companion;
    private final int background;
    public static final AvatarBackground RED = new AvatarBackground("RED", 0, Color.parseColor("#F84444"));
    public static final AvatarBackground ORANGE = new AvatarBackground("ORANGE", 1, Color.parseColor("#F88944"));
    public static final AvatarBackground YELLOW = new AvatarBackground("YELLOW", 2, Color.parseColor("#F8B344"));
    public static final AvatarBackground GREEN_LIGHT = new AvatarBackground("GREEN_LIGHT", 3, Color.parseColor("#AFD34D"));
    public static final AvatarBackground GREEN = new AvatarBackground("GREEN", 4, Color.parseColor("#4AB257"));
    public static final AvatarBackground GREY_GREEN = new AvatarBackground("GREY_GREEN", 5, Color.parseColor("#6ACBAF"));
    public static final AvatarBackground GREY_BLUE = new AvatarBackground("GREY_BLUE", 6, Color.parseColor("#6AA6CB"));
    public static final AvatarBackground BLUE = new AvatarBackground("BLUE", 7, Color.parseColor("#4C5DCD"));
    public static final AvatarBackground DARK_PURPLE = new AvatarBackground("DARK_PURPLE", 8, Color.parseColor("#7F51CD"));
    public static final AvatarBackground PURPLE = new AvatarBackground("PURPLE", 9, Color.parseColor("#A452BF"));
    public static final AvatarBackground LIGHT_PURPLE = new AvatarBackground("LIGHT_PURPLE", 10, Color.parseColor("#D468B9"));
    public static final AvatarBackground PINK = new AvatarBackground("PINK", 11, Color.parseColor("#D23A77"));

    private static final /* synthetic */ AvatarBackground[] $values() {
        return new AvatarBackground[]{RED, ORANGE, YELLOW, GREEN_LIGHT, GREEN, GREY_GREEN, GREY_BLUE, BLUE, DARK_PURPLE, PURPLE, LIGHT_PURPLE, PINK};
    }

    public static EnumEntries<AvatarBackground> getEntries() {
        return $ENTRIES;
    }

    public static AvatarBackground valueOf(String str) {
        return (AvatarBackground) Enum.valueOf(AvatarBackground.class, str);
    }

    public static AvatarBackground[] values() {
        return (AvatarBackground[]) $VALUES.clone();
    }

    private AvatarBackground(String str, int i, int i2) {
        this.background = i2;
    }

    public final int getBackground() {
        return this.background;
    }

    static {
        AvatarBackground[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    /* compiled from: MobilePhoneObject.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lru/mrlargha/arizonaui/mobile/domain/obj/AvatarBackground$Companion;", "", "<init>", "()V", "fromIndex", "Lru/mrlargha/arizonaui/mobile/domain/obj/AvatarBackground;", FirebaseAnalytics.Param.INDEX, "", "(Ljava/lang/Integer;)Lru/mrlargha/arizonaui/mobile/domain/obj/AvatarBackground;", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AvatarBackground fromIndex(Integer num) {
            AvatarBackground avatarBackground = (AvatarBackground) ArraysKt.getOrNull(AvatarBackground.getEntries().toArray(new AvatarBackground[0]), num != null ? num.intValue() : 0);
            return avatarBackground == null ? AvatarBackground.RED : avatarBackground;
        }
    }
}
