package androidx.room.util;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: SchemaInfoUtil.kt */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0001\u001a\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0002\u001a\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a$\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0002\u001a \u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0002\u001a\"\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0002\u001a\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010 \u001a\u00020\u0003H\u0000\u001a\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0003H\u0000\"\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001e¨\u0006$"}, d2 = {"findAffinity", "", "type", "", "readTableInfo", "Landroidx/room/util/TableInfo;", "connection", "Landroidx/sqlite/SQLiteConnection;", "tableName", "readForeignKeys", "", "Landroidx/room/util/TableInfo$ForeignKey;", "readForeignKeyFieldMappings", "", "Landroidx/room/util/ForeignKeyWithSequence;", "stmt", "Landroidx/sqlite/SQLiteStatement;", "readColumns", "", "Landroidx/room/util/TableInfo$Column;", "readIndices", "Landroidx/room/util/TableInfo$Index;", "readIndex", "name", "unique", "", "readFtsColumns", "readFtsOptions", "FTS_OPTIONS", "", "[Ljava/lang/String;", "parseFtsOptions", "createStatement", "readViewInfo", "Landroidx/room/util/ViewInfo;", "viewName", "room-runtime_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SchemaInfoUtilKt {
    private static final String[] FTS_OPTIONS = {"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};

    public static final int findAffinity(String str) {
        if (str == null) {
            return 5;
        }
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        String str2 = upperCase;
        if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "INT", false, 2, (Object) null)) {
            return 3;
        }
        if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "CHAR", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, (CharSequence) "CLOB", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, (CharSequence) "TEXT", false, 2, (Object) null)) {
            return 2;
        }
        if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "BLOB", false, 2, (Object) null)) {
            return 5;
        }
        return (StringsKt.contains$default((CharSequence) str2, (CharSequence) "REAL", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, (CharSequence) "FLOA", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, (CharSequence) "DOUB", false, 2, (Object) null)) ? 4 : 1;
    }

    public static final TableInfo readTableInfo(SQLiteConnection connection, String tableName) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        return new TableInfo(tableName, readColumns(connection, tableName), readForeignKeys(connection, tableName), readIndices(connection, tableName));
    }

    private static final Set<TableInfo.ForeignKey> readForeignKeys(SQLiteConnection sQLiteConnection, String str) {
        SQLiteStatement prepare = sQLiteConnection.prepare("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            SQLiteStatement sQLiteStatement = prepare;
            int columnIndexOf = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "id");
            int columnIndexOf2 = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "seq");
            int columnIndexOf3 = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "table");
            int columnIndexOf4 = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "on_delete");
            int columnIndexOf5 = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "on_update");
            List<ForeignKeyWithSequence> readForeignKeyFieldMappings = readForeignKeyFieldMappings(sQLiteStatement);
            sQLiteStatement.reset();
            Set createSetBuilder = SetsKt.createSetBuilder();
            while (sQLiteStatement.step()) {
                if (sQLiteStatement.getLong(columnIndexOf2) == 0) {
                    int i = (int) sQLiteStatement.getLong(columnIndexOf);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList<ForeignKeyWithSequence> arrayList3 = new ArrayList();
                    for (Object obj : readForeignKeyFieldMappings) {
                        if (((ForeignKeyWithSequence) obj).getId() == i) {
                            arrayList3.add(obj);
                        }
                    }
                    for (ForeignKeyWithSequence foreignKeyWithSequence : arrayList3) {
                        arrayList.add(foreignKeyWithSequence.getFrom());
                        arrayList2.add(foreignKeyWithSequence.getTo());
                    }
                    createSetBuilder.add(new TableInfo.ForeignKey(sQLiteStatement.getText(columnIndexOf3), sQLiteStatement.getText(columnIndexOf4), sQLiteStatement.getText(columnIndexOf5), arrayList, arrayList2));
                }
            }
            Set<TableInfo.ForeignKey> build = SetsKt.build(createSetBuilder);
            AutoCloseableKt.closeFinally(prepare, null);
            return build;
        } finally {
        }
    }

    private static final List<ForeignKeyWithSequence> readForeignKeyFieldMappings(SQLiteStatement sQLiteStatement) {
        int columnIndexOf = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "id");
        int columnIndexOf2 = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "seq");
        int columnIndexOf3 = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "from");
        int columnIndexOf4 = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, TypedValues.TransitionType.S_TO);
        List createListBuilder = CollectionsKt.createListBuilder();
        while (sQLiteStatement.step()) {
            createListBuilder.add(new ForeignKeyWithSequence((int) sQLiteStatement.getLong(columnIndexOf), (int) sQLiteStatement.getLong(columnIndexOf2), sQLiteStatement.getText(columnIndexOf3), sQLiteStatement.getText(columnIndexOf4)));
        }
        return CollectionsKt.sorted(CollectionsKt.build(createListBuilder));
    }

    private static final Map<String, TableInfo.Column> readColumns(SQLiteConnection sQLiteConnection, String str) {
        SQLiteStatement prepare = sQLiteConnection.prepare("PRAGMA table_info(`" + str + "`)");
        try {
            SQLiteStatement sQLiteStatement = prepare;
            if (!sQLiteStatement.step()) {
                Map<String, TableInfo.Column> emptyMap = MapsKt.emptyMap();
                AutoCloseableKt.closeFinally(prepare, null);
                return emptyMap;
            }
            int columnIndexOf = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "name");
            int columnIndexOf2 = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "type");
            int columnIndexOf3 = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "notnull");
            int columnIndexOf4 = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "pk");
            int columnIndexOf5 = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "dflt_value");
            Map createMapBuilder = MapsKt.createMapBuilder();
            do {
                String text = sQLiteStatement.getText(columnIndexOf);
                createMapBuilder.put(text, new TableInfo.Column(text, sQLiteStatement.getText(columnIndexOf2), sQLiteStatement.getLong(columnIndexOf3) != 0, (int) sQLiteStatement.getLong(columnIndexOf4), sQLiteStatement.isNull(columnIndexOf5) ? null : sQLiteStatement.getText(columnIndexOf5), 2));
            } while (sQLiteStatement.step());
            Map<String, TableInfo.Column> build = MapsKt.build(createMapBuilder);
            AutoCloseableKt.closeFinally(prepare, null);
            return build;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(prepare, th);
                throw th2;
            }
        }
    }

    private static final Set<TableInfo.Index> readIndices(SQLiteConnection sQLiteConnection, String str) {
        SQLiteStatement prepare = sQLiteConnection.prepare("PRAGMA index_list(`" + str + "`)");
        try {
            SQLiteStatement sQLiteStatement = prepare;
            int columnIndexOf = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "name");
            int columnIndexOf2 = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "origin");
            int columnIndexOf3 = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "unique");
            if (columnIndexOf != -1 && columnIndexOf2 != -1 && columnIndexOf3 != -1) {
                Set createSetBuilder = SetsKt.createSetBuilder();
                while (sQLiteStatement.step()) {
                    if (Intrinsics.areEqual("c", sQLiteStatement.getText(columnIndexOf2))) {
                        TableInfo.Index readIndex = readIndex(sQLiteConnection, sQLiteStatement.getText(columnIndexOf), sQLiteStatement.getLong(columnIndexOf3) == 1);
                        if (readIndex == null) {
                            AutoCloseableKt.closeFinally(prepare, null);
                            return null;
                        }
                        createSetBuilder.add(readIndex);
                    }
                }
                Set<TableInfo.Index> build = SetsKt.build(createSetBuilder);
                AutoCloseableKt.closeFinally(prepare, null);
                return build;
            }
            AutoCloseableKt.closeFinally(prepare, null);
            return null;
        } finally {
        }
    }

    private static final TableInfo.Index readIndex(SQLiteConnection sQLiteConnection, String str, boolean z) {
        SQLiteStatement prepare = sQLiteConnection.prepare("PRAGMA index_xinfo(`" + str + "`)");
        try {
            SQLiteStatement sQLiteStatement = prepare;
            int columnIndexOf = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "seqno");
            int columnIndexOf2 = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, CmcdConfiguration.KEY_CONTENT_ID);
            int columnIndexOf3 = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "name");
            int columnIndexOf4 = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "desc");
            if (columnIndexOf != -1 && columnIndexOf2 != -1 && columnIndexOf3 != -1 && columnIndexOf4 != -1) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                while (sQLiteStatement.step()) {
                    if (((int) sQLiteStatement.getLong(columnIndexOf2)) >= 0) {
                        int i = (int) sQLiteStatement.getLong(columnIndexOf);
                        String text = sQLiteStatement.getText(columnIndexOf3);
                        String str2 = sQLiteStatement.getLong(columnIndexOf4) > 0 ? "DESC" : "ASC";
                        linkedHashMap.put(Integer.valueOf(i), text);
                        linkedHashMap2.put(Integer.valueOf(i), str2);
                    }
                }
                List<Map.Entry> sortedWith = CollectionsKt.sortedWith(linkedHashMap.entrySet(), new Comparator() { // from class: androidx.room.util.SchemaInfoUtilKt$readIndex$lambda$13$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues((Integer) ((Map.Entry) t).getKey(), (Integer) ((Map.Entry) t2).getKey());
                    }
                });
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(sortedWith, 10));
                for (Map.Entry entry : sortedWith) {
                    arrayList.add((String) entry.getValue());
                }
                List list = CollectionsKt.toList(arrayList);
                List<Map.Entry> sortedWith2 = CollectionsKt.sortedWith(linkedHashMap2.entrySet(), new Comparator() { // from class: androidx.room.util.SchemaInfoUtilKt$readIndex$lambda$13$$inlined$sortedBy$2
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues((Integer) ((Map.Entry) t).getKey(), (Integer) ((Map.Entry) t2).getKey());
                    }
                });
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(sortedWith2, 10));
                for (Map.Entry entry2 : sortedWith2) {
                    arrayList2.add((String) entry2.getValue());
                }
                TableInfo.Index index = new TableInfo.Index(str, z, list, CollectionsKt.toList(arrayList2));
                AutoCloseableKt.closeFinally(prepare, null);
                return index;
            }
            AutoCloseableKt.closeFinally(prepare, null);
            return null;
        } finally {
        }
    }

    public static final Set<String> readFtsColumns(SQLiteConnection connection, String tableName) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        Set createSetBuilder = SetsKt.createSetBuilder();
        SQLiteStatement prepare = connection.prepare("PRAGMA table_info(`" + tableName + "`)");
        try {
            SQLiteStatement sQLiteStatement = prepare;
            if (sQLiteStatement.step()) {
                int columnIndexOf = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "name");
                do {
                    createSetBuilder.add(sQLiteStatement.getText(columnIndexOf));
                } while (sQLiteStatement.step());
                Unit unit = Unit.INSTANCE;
                AutoCloseableKt.closeFinally(prepare, null);
                return SetsKt.build(createSetBuilder);
            }
            Unit unit2 = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(prepare, null);
            return SetsKt.build(createSetBuilder);
        } finally {
        }
    }

    public static final Set<String> readFtsOptions(SQLiteConnection connection, String tableName) {
        String str;
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        SQLiteStatement prepare = connection.prepare("SELECT * FROM sqlite_master WHERE `name` = '" + tableName + '\'');
        try {
            SQLiteStatement sQLiteStatement = prepare;
            if (sQLiteStatement.step()) {
                str = sQLiteStatement.getText(SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "sql"));
            } else {
                str = "";
            }
            AutoCloseableKt.closeFinally(prepare, null);
            return parseFtsOptions(str);
        } finally {
        }
    }

    public static final Set<String> parseFtsOptions(String createStatement) {
        Character ch;
        Intrinsics.checkNotNullParameter(createStatement, "createStatement");
        String str = createStatement;
        if (str.length() == 0) {
            return SetsKt.emptySet();
        }
        String substring = createStatement.substring(StringsKt.indexOf$default((CharSequence) str, '(', 0, false, 6, (Object) null) + 1, StringsKt.lastIndexOf$default((CharSequence) str, ')', 0, false, 6, (Object) null));
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        ArrayList arrayList = new ArrayList();
        ArrayDeque arrayDeque = new ArrayDeque();
        String str2 = substring;
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        while (i2 < str2.length()) {
            char charAt = str2.charAt(i2);
            int i4 = i3 + 1;
            if (charAt != '\"' && charAt != '\'') {
                if (charAt != ',') {
                    if (charAt != '[') {
                        if (charAt != ']') {
                            if (charAt != '`') {
                            }
                        } else if (!arrayDeque.isEmpty() && (ch = (Character) arrayDeque.firstOrNull()) != null && ch.charValue() == '[') {
                            CollectionsKt.removeLast(arrayDeque);
                        }
                    } else if (arrayDeque.isEmpty()) {
                        arrayDeque.addFirst(Character.valueOf(charAt));
                    }
                } else if (arrayDeque.isEmpty()) {
                    String substring2 = substring.substring(i + 1, i3);
                    Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                    String str3 = substring2;
                    int length = str3.length() - 1;
                    int i5 = 0;
                    boolean z = false;
                    while (i5 <= length) {
                        boolean z2 = Intrinsics.compare((int) str3.charAt(!z ? i5 : length), 32) <= 0;
                        if (z) {
                            if (!z2) {
                                break;
                            }
                            length--;
                        } else if (z2) {
                            i5++;
                        } else {
                            z = true;
                        }
                    }
                    arrayList.add(str3.subSequence(i5, length + 1).toString());
                    i = i3;
                }
                i2++;
                i3 = i4;
            }
            if (arrayDeque.isEmpty()) {
                arrayDeque.addFirst(Character.valueOf(charAt));
            } else {
                Character ch2 = (Character) arrayDeque.firstOrNull();
                if (ch2 != null && ch2.charValue() == charAt) {
                    CollectionsKt.removeLast(arrayDeque);
                }
            }
            i2++;
            i3 = i4;
        }
        String substring3 = substring.substring(i + 1);
        Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
        arrayList.add(StringsKt.trim((CharSequence) substring3).toString());
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            String str4 = (String) obj;
            String[] strArr = FTS_OPTIONS;
            int length2 = strArr.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length2) {
                    break;
                } else if (StringsKt.startsWith$default(str4, strArr[i6], false, 2, (Object) null)) {
                    arrayList2.add(obj);
                    break;
                } else {
                    i6++;
                }
            }
        }
        return CollectionsKt.toSet(arrayList2);
    }

    public static final ViewInfo readViewInfo(SQLiteConnection connection, String viewName) {
        ViewInfo viewInfo;
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(viewName, "viewName");
        SQLiteStatement prepare = connection.prepare("SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '" + viewName + '\'');
        try {
            SQLiteStatement sQLiteStatement = prepare;
            if (sQLiteStatement.step()) {
                viewInfo = new ViewInfo(sQLiteStatement.getText(0), sQLiteStatement.getText(1));
            } else {
                viewInfo = new ViewInfo(viewName, null);
            }
            AutoCloseableKt.closeFinally(prepare, null);
            return viewInfo;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(prepare, th);
                throw th2;
            }
        }
    }
}
