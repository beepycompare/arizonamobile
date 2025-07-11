package ru.mrlargha.commonui.elements.quest;

import com.google.gson.Gson;
import kotlin.Metadata;
/* compiled from: RodinaSerializableData.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/quest/GsonStore;", "", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GsonStore {
    public static final GsonStore INSTANCE = new GsonStore();
    private static final Gson gson = new Gson();

    private GsonStore() {
    }

    public final Gson getGson() {
        return gson;
    }
}
