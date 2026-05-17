package ru.mrlargha.commonui.utils;

import android.content.Context;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
/* compiled from: Mapper.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a(\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u000b\u001a'\u0010\f\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u000b¢\u0006\u0002\u0010\r\u001a\u001c\u0010\u000e\u001a\u0004\u0018\u0001H\u0007\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\tH\u0086\b¢\u0006\u0002\u0010\u000f\u001a\u001a\u0010\f\u001a\u0002H\u0007\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\tH\u0086\b¢\u0006\u0002\u0010\u000f\u001a\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\tH\u0086\b\u001aA\u0010\u0010\u001a\u0004\u0018\u0001H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017\u001aB\u0010\u0018\u001a\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016\u001a\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\t\u001a\u0010\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006*\u00020\u0012\"\u0019\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u001c"}, d2 = {"gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "getGson", "()Lcom/google/gson/Gson;", "toListModel", "", ExifInterface.GPS_DIRECTION_TRUE, "json", "", "clazz", "Ljava/lang/Class;", "toModel", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "toModelNullable", "(Ljava/lang/String;)Ljava/lang/Object;", "jsonToModel", "backendId", "", "context", "Landroid/content/Context;", "notifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "(Ljava/lang/String;Ljava/lang/Class;ILandroid/content/Context;Lru/mrlargha/commonui/core/IBackendNotifier;)Ljava/lang/Object;", "jsonToListModel", "isJsonValid", "", "toBites", "CommonUI"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MapperKt {
    private static final Gson gson = new GsonBuilder().setLenient().create();

    public static final Gson getGson() {
        return gson;
    }

    public static final <T> List<T> toListModel(String json, Class<T> clazz) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (isJsonValid(json)) {
            JsonArray asJsonArray = ((JsonElement) gson.fromJson(json, (Class<Object>) JsonElement.class)).getAsJsonArray();
            Intrinsics.checkNotNull(asJsonArray);
            JsonArray<JsonElement> jsonArray = asJsonArray;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonArray, 10));
            for (JsonElement jsonElement : jsonArray) {
                arrayList.add(gson.fromJson(jsonElement, (Class<Object>) clazz));
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }

    public static final <T> T toModel(String json, Class<T> clazz) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (!isJsonValid(json)) {
            throw new JsonParseException("Json is not valid");
        }
        return (T) gson.fromJson(json, (Class<Object>) clazz);
    }

    public static final /* synthetic */ <T> T toModelNullable(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (!isJsonValid(str) || Intrinsics.areEqual(str, AbstractJsonLexerKt.NULL) || Intrinsics.areEqual(str, "{}") || str.length() == 0) {
            return null;
        }
        Gson gson2 = getGson();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) gson2.fromJson(str, (Class<Object>) Object.class);
    }

    public static final /* synthetic */ <T> T toModel(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (!isJsonValid(str)) {
            throw new JsonParseException("Json is not valid");
        }
        Gson gson2 = getGson();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) gson2.fromJson(str, (Class<Object>) Object.class);
    }

    public static final /* synthetic */ <T> List<T> toListModel(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (isJsonValid(str)) {
            JsonArray asJsonArray = ((JsonElement) getGson().fromJson(str, (Class<Object>) JsonElement.class)).getAsJsonArray();
            Intrinsics.checkNotNull(asJsonArray);
            JsonArray<JsonElement> jsonArray = asJsonArray;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonArray, 10));
            for (JsonElement jsonElement : jsonArray) {
                Gson gson2 = getGson();
                Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
                arrayList.add(gson2.fromJson(jsonElement, (Class<Object>) Object.class));
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }

    public static final <T> T jsonToModel(String json, Class<T> clazz, int i, Context context, IBackendNotifier notifier) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notifier, "notifier");
        try {
            return (T) toModel(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, context.getString(R.string.common_interface_error, Integer.valueOf(i)), 1).show();
            notifier.setUIElementVisible(i, false);
            return null;
        }
    }

    public static final <T> List<T> jsonToListModel(String json, Class<T> clazz, int i, Context context, IBackendNotifier notifier) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notifier, "notifier");
        try {
            return toListModel(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, context.getString(R.string.common_interface_error, Integer.valueOf(i)), 1).show();
            notifier.setUIElementVisible(i, false);
            return null;
        }
    }

    public static final boolean isJsonValid(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        try {
            try {
                new JSONObject(json);
                return true;
            } catch (JSONException unused) {
                return false;
            }
        } catch (JsonSyntaxException unused2) {
            return false;
        } catch (JSONException unused3) {
            new JSONArray(json);
            return true;
        }
    }

    public static final List<Integer> toBites(int i) {
        ArrayList arrayList = new ArrayList(32);
        for (int i2 = 0; i2 < 32; i2++) {
            arrayList.add(Integer.valueOf((i >> i2) & 1));
        }
        return arrayList;
    }
}
