package ru.mrlargha.commonui.elements.quest;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RodinaSerializableData.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0003\u001a\u0002H\u0004\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0002*\u00020\u0001H\u0086\b¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"toStringJson", "", "Lru/mrlargha/commonui/elements/quest/RodinaSerializableData;", "fromStringJson", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;)Lru/mrlargha/commonui/elements/quest/RodinaSerializableData;", "CommonUI_release_web"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RodinaSerializableDataKt {
    public static final String toStringJson(RodinaSerializableData rodinaSerializableData) {
        Intrinsics.checkNotNullParameter(rodinaSerializableData, "<this>");
        String json = GsonStore.INSTANCE.getGson().toJson(rodinaSerializableData);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    public static final /* synthetic */ <T extends RodinaSerializableData> T fromStringJson(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Gson gson = GsonStore.INSTANCE.getGson();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Object fromJson = gson.fromJson(str, (Class<Object>) RodinaSerializableData.class);
        Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
        return (T) fromJson;
    }
}
