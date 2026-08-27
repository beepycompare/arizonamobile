package com.miami.game.core.settings.game_test;

import android.content.Context;
import android.util.Log;
import com.miami.game.core.firebase.notification.NotificationStatsStore;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: BackendFixtureStorage.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007b\u0002\b\nJ\u0014\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\tH\u0007b\u0002\b\nJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0014\u0010\u0015\u001a\u00020\t*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\tH\u0002R\u000e\u0010\u0018\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/miami/game/core/settings/game_test/BackendFixtureStorage;", "", "<init>", "()V", "load", "Lcom/miami/game/core/settings/game_test/BackendFixture;", "context", "Landroid/content/Context;", "path", "", "Lkotlin/jvm/JvmStatic;", "parse", "rawFixture", "parseEvents", "", "Lcom/miami/game/core/settings/game_test/BackendFixtureEvent;", "array", "Lorg/json/JSONArray;", "resolveRawFixture", "resolveCandidateFiles", "Ljava/io/File;", "extractRawMessage", "Lorg/json/JSONObject;", "key", "TAG", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BackendFixtureStorage {
    public static final BackendFixtureStorage INSTANCE = new BackendFixtureStorage();
    private static final String TAG = "BackendFixtureStorage";

    private BackendFixtureStorage() {
    }

    @JvmStatic
    public static final BackendFixture load(Context context, String path) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        return parse(INSTANCE.resolveRawFixture(context, path));
    }

    @JvmStatic
    public static final BackendFixture parse(String rawFixture) {
        Intrinsics.checkNotNullParameter(rawFixture, "rawFixture");
        JSONObject jSONObject = new JSONObject(rawFixture);
        JSONArray optJSONArray = jSONObject.optJSONArray(NotificationStatsStore.KEY_EVENTS);
        if (optJSONArray == null) {
            throw new IllegalArgumentException("Backend fixture must contain an 'events' array");
        }
        String optString = jSONObject.optString("name");
        if (StringsKt.isBlank(optString)) {
            optString = "backend_fixture";
        }
        String str = optString;
        String optString2 = jSONObject.optString("provider");
        if (StringsKt.isBlank(optString2)) {
            optString2 = null;
        }
        String str2 = optString2;
        String optString3 = jSONObject.optString("previewScreen");
        if (StringsKt.isBlank(optString3)) {
            String optString4 = jSONObject.optString("screen");
            optString3 = StringsKt.isBlank(optString4) ? null : optString4;
        }
        String str3 = optString3;
        List<BackendFixtureEvent> parseEvents = INSTANCE.parseEvents(optJSONArray);
        if (parseEvents.isEmpty()) {
            throw new IllegalArgumentException("Backend fixture must contain at least one event");
        }
        Intrinsics.checkNotNull(str);
        return new BackendFixture(str, str2, str3, parseEvents);
    }

    private final List<BackendFixtureEvent> parseEvents(JSONArray jSONArray) {
        List createListBuilder = CollectionsKt.createListBuilder();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            Integer valueOf = jSONObject.has("backendId") ? Integer.valueOf(jSONObject.getInt("backendId")) : null;
            String optString = jSONObject.optString("backendName");
            if (StringsKt.isBlank(optString)) {
                optString = "";
            }
            String str = optString;
            Intrinsics.checkNotNull(str);
            if (StringsKt.isBlank(str)) {
                optString = null;
            }
            String str2 = optString;
            if (str2 == null) {
                String optString2 = jSONObject.optString("frontendName");
                if (StringsKt.isBlank(optString2)) {
                    optString2 = "";
                }
                String str3 = optString2;
                Intrinsics.checkNotNull(str3);
                if (StringsKt.isBlank(str3)) {
                    optString2 = null;
                }
                str2 = optString2;
                if (str2 == null) {
                    String optString3 = jSONObject.optString("backend");
                    String str4 = StringsKt.isBlank(optString3) ? "" : optString3;
                    String str5 = str4;
                    Intrinsics.checkNotNull(str5);
                    str2 = StringsKt.isBlank(str5) ? null : str4;
                }
            }
            String str6 = str2;
            if (valueOf == null && str6 == null) {
                throw new IllegalArgumentException("Fixture event #" + (i + 1) + " must contain 'backendId' or 'backendName'");
            } else if (!jSONObject.has("subId")) {
                throw new IllegalArgumentException("Fixture event #" + (i + 1) + " must contain 'subId'");
            } else {
                int i2 = jSONObject.getInt("subId");
                BackendFixtureStorage backendFixtureStorage = INSTANCE;
                Intrinsics.checkNotNull(jSONObject);
                createListBuilder.add(new BackendFixtureEvent(valueOf, str6, i2, backendFixtureStorage.extractRawMessage(jSONObject, "message"), RangesKt.coerceAtLeast(jSONObject.optLong("delayMs", 0L), 0L)));
            }
        }
        return CollectionsKt.build(createListBuilder);
    }

    private final String resolveRawFixture(Context context, String str) {
        Object obj;
        Object m9919constructorimpl;
        Iterator<T> it = resolveCandidateFiles(context, str).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((File) obj).exists()) {
                break;
            }
        }
        File file = (File) obj;
        if (file != null) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            return FilesKt.readText(file, UTF_8);
        }
        try {
            Result.Companion companion = Result.Companion;
            BackendFixtureStorage backendFixtureStorage = this;
            InputStream open = context.getAssets().open(str);
            Intrinsics.checkNotNullExpressionValue(open, "open(...)");
            Charset UTF_82 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_82, "UTF_8");
            InputStreamReader inputStreamReader = new InputStreamReader(open, UTF_82);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            String readText = TextStreamsKt.readText(bufferedReader);
            CloseableKt.closeFinally(bufferedReader, null);
            m9919constructorimpl = Result.m9919constructorimpl(readText);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9919constructorimpl = Result.m9919constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m9922exceptionOrNullimpl = Result.m9922exceptionOrNullimpl(m9919constructorimpl);
        if (m9922exceptionOrNullimpl != null) {
            Log.w(TAG, "Unable to load backend fixture asset '" + str + "'", m9922exceptionOrNullimpl);
        }
        String str2 = Result.m9925isFailureimpl(m9919constructorimpl) ? null : m9919constructorimpl;
        if (str2 != null) {
            return str2;
        }
        throw new IllegalArgumentException("Unable to load backend fixture '" + str + "'");
    }

    private final List<File> resolveCandidateFiles(Context context, String str) {
        File file = new File(str);
        File file2 = new File(context.getFilesDir(), GameTestScriptPreferences.IMPORTED_SCRIPT_DIR);
        List createListBuilder = CollectionsKt.createListBuilder();
        createListBuilder.add(file);
        createListBuilder.add(new File(file2, str));
        return CollectionsKt.build(createListBuilder);
    }

    private final String extractRawMessage(JSONObject jSONObject, String str) {
        if (!jSONObject.has(str)) {
            return "";
        }
        Object obj = jSONObject.get(str);
        return obj instanceof String ? (String) obj : obj.toString();
    }
}
