package androidx.room.util;

import androidx.room.util.TableInfo;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: TableInfo.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0002H\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u001a\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\bH\u0000\u001a\u0010\u0010\f\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\bH\u0002\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\tH\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\rH\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\rH\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u000eH\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u000eH\u0000\u001a\u0014\u0010\u000f\u001a\u00020\b2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0000\u001a\u0010\u0010\u0012\u001a\u00020\u0013*\u0006\u0012\u0002\b\u00030\u0011H\u0002\u001a\u0010\u0010\u0014\u001a\u00020\u0013*\u0006\u0012\u0002\b\u00030\u0011H\u0002¨\u0006\u0015"}, d2 = {"equalsCommon", "", "Landroidx/room/util/TableInfo;", "other", "", "hashCodeCommon", "", "toStringCommon", "", "Landroidx/room/util/TableInfo$Column;", "defaultValueEqualsCommon", "current", "containsSurroundingParenthesis", "Landroidx/room/util/TableInfo$ForeignKey;", "Landroidx/room/util/TableInfo$Index;", "formatString", "collection", "", "joinToStringMiddleWithIndent", "", "joinToStringEndWithIndent", "room-runtime_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TableInfoKt {
    public static final boolean equalsCommon(TableInfo tableInfo, Object obj) {
        Intrinsics.checkNotNullParameter(tableInfo, "<this>");
        if (tableInfo == obj) {
            return true;
        }
        if (obj instanceof TableInfo) {
            TableInfo tableInfo2 = (TableInfo) obj;
            if (Intrinsics.areEqual(tableInfo.name, tableInfo2.name) && Intrinsics.areEqual(tableInfo.columns, tableInfo2.columns) && Intrinsics.areEqual(tableInfo.foreignKeys, tableInfo2.foreignKeys)) {
                if (tableInfo.indices == null || tableInfo2.indices == null) {
                    return true;
                }
                return Intrinsics.areEqual(tableInfo.indices, tableInfo2.indices);
            }
            return false;
        }
        return false;
    }

    public static final int hashCodeCommon(TableInfo tableInfo) {
        Intrinsics.checkNotNullParameter(tableInfo, "<this>");
        return (((tableInfo.name.hashCode() * 31) + tableInfo.columns.hashCode()) * 31) + tableInfo.foreignKeys.hashCode();
    }

    public static final String toStringCommon(TableInfo tableInfo) {
        List emptyList;
        Intrinsics.checkNotNullParameter(tableInfo, "<this>");
        StringBuilder append = new StringBuilder("\n            |TableInfo {\n            |    name = '").append(tableInfo.name).append("',\n            |    columns = {").append(formatString(CollectionsKt.sortedWith(tableInfo.columns.values(), new Comparator() { // from class: androidx.room.util.TableInfoKt$toStringCommon$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((TableInfo.Column) t).name, ((TableInfo.Column) t2).name);
            }
        }))).append("\n            |    foreignKeys = {").append(formatString(tableInfo.foreignKeys)).append("\n            |    indices = {");
        Set<TableInfo.Index> set = tableInfo.indices;
        if (set == null || (emptyList = CollectionsKt.sortedWith(set, new Comparator() { // from class: androidx.room.util.TableInfoKt$toStringCommon$$inlined$sortedBy$2
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((TableInfo.Index) t).name, ((TableInfo.Index) t2).name);
            }
        })) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        return StringsKt.trimMargin$default(append.append(formatString(emptyList)).append("\n            |}\n        ").toString(), null, 1, null);
    }

    public static final boolean equalsCommon(TableInfo.Column column, Object obj) {
        Intrinsics.checkNotNullParameter(column, "<this>");
        if (column == obj) {
            return true;
        }
        if (obj instanceof TableInfo.Column) {
            TableInfo.Column column2 = (TableInfo.Column) obj;
            if (column.isPrimaryKey() == column2.isPrimaryKey() && Intrinsics.areEqual(column.name, column2.name) && column.notNull == column2.notNull) {
                String str = column.defaultValue;
                String str2 = column2.defaultValue;
                if (column.createdFrom != 1 || column2.createdFrom != 2 || str == null || defaultValueEqualsCommon(str, column2.defaultValue)) {
                    if (column.createdFrom != 2 || column2.createdFrom != 1 || str2 == null || defaultValueEqualsCommon(str2, str)) {
                        return (column.createdFrom == 0 || column.createdFrom != column2.createdFrom || (str == null ? str2 == null : defaultValueEqualsCommon(str, str2))) && column.affinity == column2.affinity;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static final boolean defaultValueEqualsCommon(String current, String str) {
        Intrinsics.checkNotNullParameter(current, "current");
        if (Intrinsics.areEqual(current, str)) {
            return true;
        }
        if (containsSurroundingParenthesis(current)) {
            String substring = current.substring(1, current.length() - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return Intrinsics.areEqual(StringsKt.trim((CharSequence) substring).toString(), str);
        }
        return false;
    }

    private static final boolean containsSurroundingParenthesis(String str) {
        String str2 = str;
        if (str2.length() == 0) {
            return false;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < str2.length()) {
            char charAt = str2.charAt(i);
            int i4 = i3 + 1;
            if (i3 == 0 && charAt != '(') {
                return false;
            }
            if (charAt == '(') {
                i2++;
            } else if (charAt == ')' && i2 - 1 == 0 && i3 != str.length() - 1) {
                return false;
            }
            i++;
            i3 = i4;
        }
        return i2 == 0;
    }

    public static final int hashCodeCommon(TableInfo.Column column) {
        Intrinsics.checkNotNullParameter(column, "<this>");
        return (((((column.name.hashCode() * 31) + column.affinity) * 31) + (column.notNull ? 1231 : 1237)) * 31) + column.primaryKeyPosition;
    }

    public static final String toStringCommon(TableInfo.Column column) {
        Intrinsics.checkNotNullParameter(column, "<this>");
        StringBuilder append = new StringBuilder("\n            |Column {\n            |   name = '").append(column.name).append("',\n            |   type = '").append(column.type).append("',\n            |   affinity = '").append(column.affinity).append("',\n            |   notNull = '").append(column.notNull).append("',\n            |   primaryKeyPosition = '").append(column.primaryKeyPosition).append("',\n            |   defaultValue = '");
        String str = column.defaultValue;
        if (str == null) {
            str = StringUtils.UNDEFINED;
        }
        return StringsKt.prependIndent$default(StringsKt.trimMargin$default(append.append(str).append("'\n            |}\n        ").toString(), null, 1, null), null, 1, null);
    }

    public static final boolean equalsCommon(TableInfo.ForeignKey foreignKey, Object obj) {
        Intrinsics.checkNotNullParameter(foreignKey, "<this>");
        if (foreignKey == obj) {
            return true;
        }
        if (obj instanceof TableInfo.ForeignKey) {
            TableInfo.ForeignKey foreignKey2 = (TableInfo.ForeignKey) obj;
            if (Intrinsics.areEqual(foreignKey.referenceTable, foreignKey2.referenceTable) && Intrinsics.areEqual(foreignKey.onDelete, foreignKey2.onDelete) && Intrinsics.areEqual(foreignKey.onUpdate, foreignKey2.onUpdate) && Intrinsics.areEqual(foreignKey.columnNames, foreignKey2.columnNames)) {
                return Intrinsics.areEqual(foreignKey.referenceColumnNames, foreignKey2.referenceColumnNames);
            }
            return false;
        }
        return false;
    }

    public static final int hashCodeCommon(TableInfo.ForeignKey foreignKey) {
        Intrinsics.checkNotNullParameter(foreignKey, "<this>");
        return (((((((foreignKey.referenceTable.hashCode() * 31) + foreignKey.onDelete.hashCode()) * 31) + foreignKey.onUpdate.hashCode()) * 31) + foreignKey.columnNames.hashCode()) * 31) + foreignKey.referenceColumnNames.hashCode();
    }

    public static final String toStringCommon(TableInfo.ForeignKey foreignKey) {
        Intrinsics.checkNotNullParameter(foreignKey, "<this>");
        StringBuilder append = new StringBuilder("\n            |ForeignKey {\n            |   referenceTable = '").append(foreignKey.referenceTable).append("',\n            |   onDelete = '").append(foreignKey.onDelete).append("',\n            |   onUpdate = '").append(foreignKey.onUpdate).append("',\n            |   columnNames = {");
        joinToStringMiddleWithIndent(CollectionsKt.sorted(foreignKey.columnNames));
        StringBuilder append2 = append.append(Unit.INSTANCE).append("\n            |   referenceColumnNames = {");
        joinToStringEndWithIndent(CollectionsKt.sorted(foreignKey.referenceColumnNames));
        return StringsKt.prependIndent$default(StringsKt.trimMargin$default(append2.append(Unit.INSTANCE).append("\n            |}\n        ").toString(), null, 1, null), null, 1, null);
    }

    public static final boolean equalsCommon(TableInfo.Index index, Object obj) {
        Intrinsics.checkNotNullParameter(index, "<this>");
        if (index == obj) {
            return true;
        }
        if (obj instanceof TableInfo.Index) {
            TableInfo.Index index2 = (TableInfo.Index) obj;
            if (index.unique == index2.unique && Intrinsics.areEqual(index.columns, index2.columns) && Intrinsics.areEqual(index.orders, index2.orders)) {
                if (StringsKt.startsWith$default(index.name, TableInfo.Index.DEFAULT_PREFIX, false, 2, (Object) null)) {
                    return StringsKt.startsWith$default(index2.name, TableInfo.Index.DEFAULT_PREFIX, false, 2, (Object) null);
                }
                return Intrinsics.areEqual(index.name, index2.name);
            }
            return false;
        }
        return false;
    }

    public static final int hashCodeCommon(TableInfo.Index index) {
        int hashCode;
        Intrinsics.checkNotNullParameter(index, "<this>");
        if (StringsKt.startsWith$default(index.name, TableInfo.Index.DEFAULT_PREFIX, false, 2, (Object) null)) {
            hashCode = TableInfo.Index.DEFAULT_PREFIX.hashCode();
        } else {
            hashCode = index.name.hashCode();
        }
        return (((((hashCode * 31) + (index.unique ? 1 : 0)) * 31) + index.columns.hashCode()) * 31) + index.orders.hashCode();
    }

    public static final String toStringCommon(TableInfo.Index index) {
        Intrinsics.checkNotNullParameter(index, "<this>");
        StringBuilder append = new StringBuilder("\n            |Index {\n            |   name = '").append(index.name).append("',\n            |   unique = '").append(index.unique).append("',\n            |   columns = {");
        joinToStringMiddleWithIndent(index.columns);
        StringBuilder append2 = append.append(Unit.INSTANCE).append("\n            |   orders = {");
        joinToStringEndWithIndent(index.orders);
        return StringsKt.prependIndent$default(StringsKt.trimMargin$default(append2.append(Unit.INSTANCE).append("\n            |}\n        ").toString(), null, 1, null), null, 1, null);
    }

    public static final String formatString(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        if (!collection.isEmpty()) {
            return StringsKt.prependIndent$default(CollectionsKt.joinToString$default(collection, ",\n", "\n", "\n", 0, null, null, 56, null), null, 1, null) + "},";
        }
        return " }";
    }

    private static final void joinToStringMiddleWithIndent(Collection<?> collection) {
        String str = StringsKt.prependIndent$default(CollectionsKt.joinToString$default(collection, StringUtils.COMMA, null, null, 0, null, null, 62, null), null, 1, null) + StringsKt.prependIndent$default("},", null, 1, null);
    }

    private static final void joinToStringEndWithIndent(Collection<?> collection) {
        String str = StringsKt.prependIndent$default(CollectionsKt.joinToString$default(collection, StringUtils.COMMA, null, null, 0, null, null, 62, null), null, 1, null) + StringsKt.prependIndent$default(" }", null, 1, null);
    }
}
