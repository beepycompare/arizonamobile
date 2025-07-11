package ru.mrlargha.commonui.domain.db;

import android.content.Context;
import androidx.room.Room;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Database.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/domain/db/Database;", "", "<init>", "()V", "build", "Lru/mrlargha/commonui/domain/db/AppDatabase;", "context", "Landroid/content/Context;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Database {
    public static final Database INSTANCE = new Database();

    private Database() {
    }

    public final AppDatabase build(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (AppDatabase) Room.databaseBuilder(context, AppDatabase.class, "app_database").fallbackToDestructiveMigration().build();
    }
}
