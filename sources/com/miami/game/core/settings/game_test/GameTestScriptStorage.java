package com.miami.game.core.settings.game_test;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import androidx.preference.PreferenceManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: GameTestScriptStorage.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J&\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\"\u0010\u0015\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0002R\u000e\u0010\u001e\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/miami/game/core/settings/game_test/GameTestScriptStorage;", "", "<init>", "()V", "shouldAutoRun", "", "context", "Landroid/content/Context;", "loadActiveScript", "Lcom/miami/game/core/settings/game_test/LoadedGameTestScript;", "importScript", "Lcom/miami/game/core/settings/game_test/GameTestSavedScript;", "uri", "Landroid/net/Uri;", "listImportedScripts", "", "readBundledScript", "readImportedScript", "activeImportedScriptFileName", "", "importedScriptName", "readImportedScriptFile", "fileName", "displayName", "resolveImportedScriptFile", "Ljava/io/File;", "queryDisplayName", "createUniqueImportedScriptFile", "destinationDir", "sanitizeImportedScriptFileName", "TAG", "MAX_IMPORTED_SCRIPT_FILE_NAME_LENGTH", "", "settings"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GameTestScriptStorage {
    public static final GameTestScriptStorage INSTANCE = new GameTestScriptStorage();
    private static final int MAX_IMPORTED_SCRIPT_FILE_NAME_LENGTH = 96;
    private static final String TAG = "GameTestScriptStorage";

    private GameTestScriptStorage() {
    }

    @JvmStatic
    public static final boolean shouldAutoRun(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(GameTestScriptPreferences.AUTO_RUN_KEY, false);
    }

    @JvmStatic
    public static final LoadedGameTestScript loadActiveScript(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        boolean z = defaultSharedPreferences.getBoolean(GameTestScriptPreferences.USE_IMPORTED_KEY, false);
        String string = defaultSharedPreferences.getString(GameTestScriptPreferences.IMPORTED_SCRIPT_NAME_KEY, null);
        String string2 = defaultSharedPreferences.getString(GameTestScriptPreferences.ACTIVE_IMPORTED_SCRIPT_FILE_KEY, null);
        if (z) {
            LoadedGameTestScript readImportedScript = INSTANCE.readImportedScript(context, string2, string);
            if (readImportedScript != null) {
                return readImportedScript;
            }
            Log.w(TAG, "Imported test script is selected but missing, falling back to bundled asset");
        }
        return INSTANCE.readBundledScript(context);
    }

    @JvmStatic
    public static final GameTestSavedScript importScript(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        InputStream openInputStream = context.getContentResolver().openInputStream(uri);
        if (openInputStream != null) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            InputStreamReader inputStreamReader = new InputStreamReader(openInputStream, UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            try {
                String readText = TextStreamsKt.readText(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, null);
                if (readText != null) {
                    GameTestScript parse = GameTestScriptParser.parse(readText);
                    File file = new File(context.getFilesDir(), GameTestScriptPreferences.IMPORTED_SCRIPTS_DIR);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    GameTestScriptStorage gameTestScriptStorage = INSTANCE;
                    String queryDisplayName = gameTestScriptStorage.queryDisplayName(context, uri);
                    if (queryDisplayName == null) {
                        String lastPathSegment = uri.getLastPathSegment();
                        String substringAfterLast$default = lastPathSegment != null ? StringsKt.substringAfterLast$default(lastPathSegment, '/', (String) null, 2, (Object) null) : null;
                        queryDisplayName = substringAfterLast$default == null ? parse.getName() + ".json" : substringAfterLast$default;
                    }
                    File createUniqueImportedScriptFile = gameTestScriptStorage.createUniqueImportedScriptFile(file, queryDisplayName);
                    Charset UTF_82 = StandardCharsets.UTF_8;
                    Intrinsics.checkNotNullExpressionValue(UTF_82, "UTF_8");
                    FilesKt.writeText(createUniqueImportedScriptFile, readText, UTF_82);
                    createUniqueImportedScriptFile.setLastModified(System.currentTimeMillis());
                    String name = createUniqueImportedScriptFile.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    String name2 = createUniqueImportedScriptFile.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                    return new GameTestSavedScript(name, name2, createUniqueImportedScriptFile.lastModified());
                }
            } finally {
            }
        }
        throw new IllegalArgumentException("Unable to read selected test script");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e7, code lost:
        if (r6 == null) goto L54;
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final List<GameTestSavedScript> listImportedScripts(Context context) {
        Object m9202constructorimpl;
        String name;
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String string = defaultSharedPreferences.getString(GameTestScriptPreferences.ACTIVE_IMPORTED_SCRIPT_FILE_KEY, null);
        string = (string == null || StringsKt.isBlank(string)) ? null : null;
        String string2 = (string == null || Intrinsics.areEqual(string, GameTestScriptPreferences.IMPORTED_SCRIPT_FILE_NAME)) ? defaultSharedPreferences.getString(GameTestScriptPreferences.IMPORTED_SCRIPT_NAME_KEY, null) : null;
        File file = new File(context.getFilesDir(), GameTestScriptPreferences.IMPORTED_SCRIPTS_DIR);
        File file2 = new File(new File(context.getFilesDir(), GameTestScriptPreferences.IMPORTED_SCRIPT_DIR), GameTestScriptPreferences.IMPORTED_SCRIPT_FILE_NAME);
        List createListBuilder = CollectionsKt.createListBuilder();
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.miami.game.core.settings.game_test.GameTestScriptStorage$$ExternalSyntheticLambda0
            @Override // java.io.FileFilter
            public final boolean accept(File file3) {
                boolean listImportedScripts$lambda$1$0;
                listImportedScripts$lambda$1$0 = GameTestScriptStorage.listImportedScripts$lambda$1$0(file3);
                return listImportedScripts$lambda$1$0;
            }
        });
        if (listFiles != null) {
            CollectionsKt.addAll(createListBuilder, listFiles);
        }
        if (file2.isFile()) {
            createListBuilder.add(file2);
        }
        HashSet hashSet = new HashSet();
        ArrayList<File> arrayList = new ArrayList();
        for (Object obj : CollectionsKt.build(createListBuilder)) {
            if (hashSet.add(((File) obj).getAbsolutePath())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (File file3 : arrayList) {
            try {
                Result.Companion companion = Result.Companion;
                Intrinsics.checkNotNull(file3);
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                GameTestScriptParser.parse(FilesKt.readText(file3, UTF_8));
                String name2 = file3.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                if (Intrinsics.areEqual(file3.getName(), GameTestScriptPreferences.IMPORTED_SCRIPT_FILE_NAME)) {
                    if (string2 != null) {
                        name = !StringsKt.isBlank(string2) ? string2 : null;
                    }
                    name = file3.getName();
                } else {
                    name = file3.getName();
                }
                Intrinsics.checkNotNull(name);
                m9202constructorimpl = Result.m9202constructorimpl(new GameTestSavedScript(name2, name, file3.lastModified()));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m9202constructorimpl = Result.m9202constructorimpl(ResultKt.createFailure(th));
            }
            Throwable m9205exceptionOrNullimpl = Result.m9205exceptionOrNullimpl(m9202constructorimpl);
            if (m9205exceptionOrNullimpl != null) {
                Log.w(TAG, "Skipping invalid saved test script '" + file3.getName() + "'", m9205exceptionOrNullimpl);
            }
            if (Result.m9208isFailureimpl(m9202constructorimpl)) {
                m9202constructorimpl = null;
            }
            GameTestSavedScript gameTestSavedScript = (GameTestSavedScript) m9202constructorimpl;
            if (gameTestSavedScript != null) {
                arrayList2.add(gameTestSavedScript);
            }
        }
        HashSet hashSet2 = new HashSet();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            if (hashSet2.add(((GameTestSavedScript) obj2).getFileName())) {
                arrayList3.add(obj2);
            }
        }
        final Comparator comparator = new Comparator() { // from class: com.miami.game.core.settings.game_test.GameTestScriptStorage$listImportedScripts$$inlined$compareByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((GameTestSavedScript) t2).getUpdatedAtMs()), Long.valueOf(((GameTestSavedScript) t).getUpdatedAtMs()));
            }
        };
        return CollectionsKt.sortedWith(arrayList3, new Comparator() { // from class: com.miami.game.core.settings.game_test.GameTestScriptStorage$listImportedScripts$$inlined$thenBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int compare = comparator.compare(t, t2);
                if (compare != 0) {
                    return compare;
                }
                String lowerCase = ((GameTestSavedScript) t).getDisplayName().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String lowerCase2 = ((GameTestSavedScript) t2).getDisplayName().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                return ComparisonsKt.compareValues(lowerCase, lowerCase2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean listImportedScripts$lambda$1$0(File file) {
        if (file.isFile()) {
            Intrinsics.checkNotNull(file);
            return StringsKt.equals(FilesKt.getExtension(file), "json", true);
        }
        return false;
    }

    private final LoadedGameTestScript readBundledScript(Context context) {
        Object m9202constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            GameTestScriptStorage gameTestScriptStorage = this;
            InputStream open = context.getAssets().open(GameTestScriptPreferences.BUNDLED_SCRIPT_ASSET_PATH);
            Intrinsics.checkNotNullExpressionValue(open, "open(...)");
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            InputStreamReader inputStreamReader = new InputStreamReader(open, UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            String readText = TextStreamsKt.readText(bufferedReader);
            CloseableKt.closeFinally(bufferedReader, null);
            m9202constructorimpl = Result.m9202constructorimpl(new LoadedGameTestScript(GameTestScriptPreferences.BUNDLED_SCRIPT_FILE_NAME, "bundled", GameTestScriptParser.parse(readText)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9202constructorimpl = Result.m9202constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m9205exceptionOrNullimpl = Result.m9205exceptionOrNullimpl(m9202constructorimpl);
        if (m9205exceptionOrNullimpl != null) {
            Log.w(TAG, "Unable to load bundled test script", m9205exceptionOrNullimpl);
        }
        return Result.m9208isFailureimpl(m9202constructorimpl) ? null : m9202constructorimpl;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001f, code lost:
        if (r5 == null) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final LoadedGameTestScript readImportedScript(Context context, String str, String str2) {
        LoadedGameTestScript loadedGameTestScript;
        if (str != null) {
            if (StringsKt.isBlank(str)) {
                str = null;
            }
            if (str != null) {
                GameTestScriptStorage gameTestScriptStorage = INSTANCE;
                if (str2 != null) {
                    if (StringsKt.isBlank(str2)) {
                        str2 = null;
                    }
                }
                str2 = str;
                loadedGameTestScript = gameTestScriptStorage.readImportedScriptFile(context, str, str2);
                if (loadedGameTestScript == null) {
                    return loadedGameTestScript;
                }
                GameTestSavedScript gameTestSavedScript = (GameTestSavedScript) CollectionsKt.firstOrNull((List<? extends Object>) listImportedScripts(context));
                if (gameTestSavedScript != null) {
                    return INSTANCE.readImportedScriptFile(context, gameTestSavedScript.getFileName(), gameTestSavedScript.getDisplayName());
                }
                return null;
            }
        }
        loadedGameTestScript = null;
        if (loadedGameTestScript == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final LoadedGameTestScript readImportedScriptFile(Context context, String str, String str2) {
        Object m9202constructorimpl;
        Throwable m9205exceptionOrNullimpl;
        File resolveImportedScriptFile;
        LoadedGameTestScript loadedGameTestScript;
        try {
            Result.Companion companion = Result.Companion;
            GameTestScriptStorage gameTestScriptStorage = this;
            resolveImportedScriptFile = resolveImportedScriptFile(context, str);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9202constructorimpl = Result.m9202constructorimpl(ResultKt.createFailure(th));
        }
        if (resolveImportedScriptFile != null && resolveImportedScriptFile.exists()) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            loadedGameTestScript = new LoadedGameTestScript(str2, "imported", GameTestScriptParser.parse(FilesKt.readText(resolveImportedScriptFile, UTF_8)));
            m9202constructorimpl = Result.m9202constructorimpl(loadedGameTestScript);
            m9205exceptionOrNullimpl = Result.m9205exceptionOrNullimpl(m9202constructorimpl);
            if (m9205exceptionOrNullimpl != null) {
                Log.w(TAG, "Unable to load imported test script '" + str + "'", m9205exceptionOrNullimpl);
            }
            return Result.m9208isFailureimpl(m9202constructorimpl) ? null : m9202constructorimpl;
        }
        loadedGameTestScript = null;
        m9202constructorimpl = Result.m9202constructorimpl(loadedGameTestScript);
        m9205exceptionOrNullimpl = Result.m9205exceptionOrNullimpl(m9202constructorimpl);
        if (m9205exceptionOrNullimpl != null) {
        }
        return Result.m9208isFailureimpl(m9202constructorimpl) ? null : m9202constructorimpl;
    }

    private final File resolveImportedScriptFile(Context context, String str) {
        String obj = StringsKt.trim((CharSequence) str).toString();
        String str2 = obj;
        if (str2.length() == 0 || StringsKt.contains$default((CharSequence) str2, '/', false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, (char) AbstractJsonLexerKt.STRING_ESC, false, 2, (Object) null)) {
            return null;
        }
        if (Intrinsics.areEqual(obj, GameTestScriptPreferences.IMPORTED_SCRIPT_FILE_NAME)) {
            return new File(new File(context.getFilesDir(), GameTestScriptPreferences.IMPORTED_SCRIPT_DIR), GameTestScriptPreferences.IMPORTED_SCRIPT_FILE_NAME);
        }
        return new File(new File(context.getFilesDir(), GameTestScriptPreferences.IMPORTED_SCRIPTS_DIR), obj);
    }

    private final String queryDisplayName(Context context, Uri uri) {
        int columnIndex;
        String string;
        Cursor query = context.getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
        if (query == null) {
            return null;
        }
        Cursor cursor = query;
        try {
            Cursor cursor2 = cursor;
            if (cursor2.moveToFirst() && (columnIndex = cursor2.getColumnIndex("_display_name")) != -1) {
                string = cursor2.getString(columnIndex);
                CloseableKt.closeFinally(cursor, null);
                return string;
            }
            string = null;
            CloseableKt.closeFinally(cursor, null);
            return string;
        } finally {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x004a, code lost:
        if (r1 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005c, code lost:
        if (r8 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final File createUniqueImportedScriptFile(File file, String str) {
        String str2;
        String str3;
        String sanitizeImportedScriptFileName = sanitizeImportedScriptFileName(str);
        if (Intrinsics.areEqual(sanitizeImportedScriptFileName, GameTestScriptPreferences.IMPORTED_SCRIPT_FILE_NAME)) {
            sanitizeImportedScriptFileName = "saved_" + sanitizeImportedScriptFileName;
        }
        Integer valueOf = Integer.valueOf(StringsKt.lastIndexOf$default((CharSequence) sanitizeImportedScriptFileName, '.', 0, false, 6, (Object) null));
        if (valueOf.intValue() <= 0) {
            valueOf = null;
        }
        if (valueOf != null) {
            str2 = sanitizeImportedScriptFileName.substring(0, valueOf.intValue());
            Intrinsics.checkNotNullExpressionValue(str2, "substring(...)");
        }
        str2 = sanitizeImportedScriptFileName;
        if (valueOf != null) {
            str3 = sanitizeImportedScriptFileName.substring(valueOf.intValue());
            Intrinsics.checkNotNullExpressionValue(str3, "substring(...)");
        }
        str3 = ".json";
        File file2 = new File(file, sanitizeImportedScriptFileName);
        int i = 2;
        while (file2.exists()) {
            file2 = new File(file, str2 + "_" + i + str3);
            i++;
        }
        return file2;
    }

    private final String sanitizeImportedScriptFileName(String str) {
        String substringAfterLast$default = StringsKt.substringAfterLast$default(StringsKt.substringAfterLast$default(StringsKt.trim((CharSequence) str).toString(), '/', (String) null, 2, (Object) null), (char) AbstractJsonLexerKt.STRING_ESC, (String) null, 2, (Object) null);
        if (StringsKt.isBlank(substringAfterLast$default)) {
            substringAfterLast$default = "game_test_script.json";
        }
        String str2 = substringAfterLast$default;
        ArrayList arrayList = new ArrayList(str2.length());
        for (int i = 0; i < str2.length(); i++) {
            char charAt = str2.charAt(i);
            if (!Character.isLetterOrDigit(charAt) && charAt != '.' && charAt != '_' && charAt != '-' && charAt != ' ') {
                charAt = '_';
            }
            arrayList.add(Character.valueOf(charAt));
        }
        String trim = StringsKt.trim(new Regex("\\s+").replace(CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, null, 62, null), "_"), '_', '.');
        if (StringsKt.isBlank(trim)) {
            trim = "game_test_script";
        }
        String str3 = trim;
        if (!StringsKt.endsWith(str3, ".json", true)) {
            str3 = str3 + ".json";
        }
        if (str3.length() <= 96) {
            return str3;
        }
        return StringsKt.take(str3, 91) + ".json";
    }
}
