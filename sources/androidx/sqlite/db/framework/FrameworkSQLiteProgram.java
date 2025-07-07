package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FrameworkSQLiteProgram.android.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteProgram;", "Landroidx/sqlite/db/SupportSQLiteProgram;", "delegate", "Landroid/database/sqlite/SQLiteProgram;", "<init>", "(Landroid/database/sqlite/SQLiteProgram;)V", "bindNull", "", FirebaseAnalytics.Param.INDEX, "", "bindLong", "value", "", "bindDouble", "", "bindString", "", "bindBlob", "", "clearBindings", "close", "sqlite-framework_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public class FrameworkSQLiteProgram implements SupportSQLiteProgram {
    private final SQLiteProgram delegate;

    public FrameworkSQLiteProgram(SQLiteProgram delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i) {
        this.delegate.bindNull(i);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i, long j) {
        this.delegate.bindLong(i, j);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i, double d) {
        this.delegate.bindDouble(i, d);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.delegate.bindString(i, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i, byte[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.delegate.bindBlob(i, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.delegate.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }
}
