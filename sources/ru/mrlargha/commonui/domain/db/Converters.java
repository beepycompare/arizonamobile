package ru.mrlargha.commonui.domain.db;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Converters.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\u001a\u0010\n\u001a\u00020\b2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0007J2\u0010\f\u001a\u0004\u0018\u00010\r2&\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r\u0018\u0001`\u0010H\u0007J6\u0010\u0011\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u000fj\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u0001`\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/domain/db/Converters;", "", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "fromString", "", "", "value", "fromList", "list", "fromHashMap", "", "map", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "toHashMap", "byteArray", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Converters {
    public static final Converters INSTANCE = new Converters();
    private static final Gson gson = new Gson();

    private Converters() {
    }

    public final List<String> fromString(String str) {
        Type type = new TypeToken<List<? extends String>>() { // from class: ru.mrlargha.commonui.domain.db.Converters$fromString$listType$1
        }.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        Object fromJson = new Gson().fromJson(str, type);
        Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
        return (List) fromJson;
    }

    public final String fromList(List<String> list) {
        String json = new Gson().toJson(list);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    public final byte[] fromHashMap(HashMap<String, byte[]> hashMap) {
        if (hashMap == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(hashMap);
            objectOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final HashMap<String, byte[]> toHashMap(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            Object readObject = new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject();
            Intrinsics.checkNotNull(readObject, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.ByteArray?>");
            return (HashMap) readObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
