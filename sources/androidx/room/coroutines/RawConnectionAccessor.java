package androidx.room.coroutines;

import androidx.sqlite.SQLiteConnection;
import kotlin.Metadata;
/* compiled from: ConnectionPool.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/room/coroutines/RawConnectionAccessor;", "", "rawConnection", "Landroidx/sqlite/SQLiteConnection;", "getRawConnection", "()Landroidx/sqlite/SQLiteConnection;", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface RawConnectionAccessor {
    SQLiteConnection getRawConnection();
}
