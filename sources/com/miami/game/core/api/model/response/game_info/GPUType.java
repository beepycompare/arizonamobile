package com.miami.game.core.api.model.response.game_info;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: GameInfoApiModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/miami/game/core/api/model/response/game_info/GPUType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Astc", "Etc2", "Companion", "api-model_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GPUType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GPUType[] $VALUES;
    public static final Companion Companion;
    private final String value;
    public static final GPUType Astc = new GPUType("Astc", 0, "astc");
    public static final GPUType Etc2 = new GPUType("Etc2", 1, "etc2");

    private static final /* synthetic */ GPUType[] $values() {
        return new GPUType[]{Astc, Etc2};
    }

    public static EnumEntries<GPUType> getEntries() {
        return $ENTRIES;
    }

    public static GPUType valueOf(String str) {
        return (GPUType) Enum.valueOf(GPUType.class, str);
    }

    public static GPUType[] values() {
        return (GPUType[]) $VALUES.clone();
    }

    private GPUType(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        GPUType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    /* compiled from: GameInfoApiModel.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/core/api/model/response/game_info/GPUType$Companion;", "", "<init>", "()V", "fromValue", "Lcom/miami/game/core/api/model/response/game_info/GPUType;", "value", "", "api-model_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GPUType fromValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (Intrinsics.areEqual(value, "astc")) {
                return GPUType.Astc;
            }
            if (Intrinsics.areEqual(value, "etc2")) {
                return GPUType.Etc2;
            }
            return null;
        }
    }
}
