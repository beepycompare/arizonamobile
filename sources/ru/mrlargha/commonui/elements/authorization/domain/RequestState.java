package ru.mrlargha.commonui.elements.authorization.domain;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: RequestState.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/domain/RequestState;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "INIT", "SEND_TO_SERVER", "RECEIVED_BAD_ANSWER_FROM_SERVER", "DISABLE", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RequestState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RequestState[] $VALUES;
    private final int id;
    public static final RequestState INIT = new RequestState("INIT", 0, 1);
    public static final RequestState SEND_TO_SERVER = new RequestState("SEND_TO_SERVER", 1, 2);
    public static final RequestState RECEIVED_BAD_ANSWER_FROM_SERVER = new RequestState("RECEIVED_BAD_ANSWER_FROM_SERVER", 2, 3);
    public static final RequestState DISABLE = new RequestState("DISABLE", 3, 4);

    private static final /* synthetic */ RequestState[] $values() {
        return new RequestState[]{INIT, SEND_TO_SERVER, RECEIVED_BAD_ANSWER_FROM_SERVER, DISABLE};
    }

    public static EnumEntries<RequestState> getEntries() {
        return $ENTRIES;
    }

    private RequestState(String str, int i, int i2) {
        this.id = i2;
    }

    public final int getId() {
        return this.id;
    }

    static {
        RequestState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static RequestState valueOf(String str) {
        return (RequestState) Enum.valueOf(RequestState.class, str);
    }

    public static RequestState[] values() {
        return (RequestState[]) $VALUES.clone();
    }
}
