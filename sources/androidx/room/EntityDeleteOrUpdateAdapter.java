package androidx.room;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.util.SQLiteConnectionUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EntityDeleteOrUpdateAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\u0010\u0011\n\u0002\b\u0002\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H$J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000H$¢\u0006\u0002\u0010\fJ\u001d\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0011J \u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0014J'\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0013\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/room/EntityDeleteOrUpdateAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "createQuery", "", "bind", "", "statement", "Landroidx/sqlite/SQLiteStatement;", "entity", "(Landroidx/sqlite/SQLiteStatement;Ljava/lang/Object;)V", "handle", "", "connection", "Landroidx/sqlite/SQLiteConnection;", "(Landroidx/sqlite/SQLiteConnection;Ljava/lang/Object;)I", "handleMultiple", "entities", "", "", "(Landroidx/sqlite/SQLiteConnection;[Ljava/lang/Object;)I", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class EntityDeleteOrUpdateAdapter<T> {
    protected abstract void bind(SQLiteStatement sQLiteStatement, T t);

    protected abstract String createQuery();

    public final int handle(SQLiteConnection connection, T t) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (t == null) {
            return 0;
        }
        SQLiteStatement prepare = connection.prepare(createQuery());
        try {
            SQLiteStatement sQLiteStatement = prepare;
            bind(sQLiteStatement, t);
            sQLiteStatement.step();
            AutoCloseableKt.closeFinally(prepare, null);
            return SQLiteConnectionUtil.getTotalChangedRows(connection);
        } finally {
        }
    }

    public final int handleMultiple(SQLiteConnection connection, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        int i = 0;
        if (iterable == null) {
            return 0;
        }
        SQLiteStatement prepare = connection.prepare(createQuery());
        try {
            SQLiteStatement sQLiteStatement = prepare;
            for (T t : iterable) {
                if (t != null) {
                    bind(sQLiteStatement, t);
                    sQLiteStatement.step();
                    sQLiteStatement.reset();
                    i += SQLiteConnectionUtil.getTotalChangedRows(connection);
                }
            }
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(prepare, null);
            return i;
        } finally {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int handleMultiple(SQLiteConnection connection, T[] tArr) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        int i = 0;
        if (tArr == null) {
            return 0;
        }
        SQLiteStatement prepare = connection.prepare(createQuery());
        try {
            SQLiteStatement sQLiteStatement = prepare;
            Iterator it = ArrayIteratorKt.iterator(tArr);
            while (it.hasNext()) {
                Object next = it.next();
                if (next != null) {
                    bind(sQLiteStatement, next);
                    sQLiteStatement.step();
                    sQLiteStatement.reset();
                    i += SQLiteConnectionUtil.getTotalChangedRows(connection);
                }
            }
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(prepare, null);
            return i;
        } finally {
        }
    }
}
