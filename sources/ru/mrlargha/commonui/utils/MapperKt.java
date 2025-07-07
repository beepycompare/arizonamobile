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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.mrlargha.commonui.core.IBackendNotifier;
/* compiled from: Mapper.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001a'\u0010\u0007\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006¢\u0006\u0002\u0010\b\u001aA\u0010\t\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010\u001aB\u0010\u0011\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0014"}, d2 = {"toListModel", "", ExifInterface.GPS_DIRECTION_TRUE, "json", "", "clazz", "Ljava/lang/Class;", "toModel", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "jsonToModel", "backendId", "", "context", "Landroid/content/Context;", "notifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "(Ljava/lang/String;Ljava/lang/Class;ILandroid/content/Context;Lru/mrlargha/commonui/core/IBackendNotifier;)Ljava/lang/Object;", "jsonToListModel", "isJsonValid", "", "CommonUI_release_web"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MapperKt {
    public static final <T> List<T> toListModel(String json, Class<T> clazz) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (isJsonValid(json)) {
            Gson create = new GsonBuilder().setLenient().create();
            JsonArray asJsonArray = ((JsonElement) create.fromJson(json, (Class<Object>) JsonElement.class)).getAsJsonArray();
            Intrinsics.checkNotNull(asJsonArray);
            JsonArray<JsonElement> jsonArray = asJsonArray;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonArray, 10));
            for (JsonElement jsonElement : jsonArray) {
                arrayList.add(create.fromJson(jsonElement, (Class<Object>) clazz));
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
        return (T) new GsonBuilder().setLenient().create().fromJson(json, (Class<Object>) clazz);
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
            Toast.makeText(context, "Ошибка в интерфейсе : " + i, 1).show();
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
            Toast.makeText(context, "Ошибка в интерфейсе : " + i, 1).show();
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
}
