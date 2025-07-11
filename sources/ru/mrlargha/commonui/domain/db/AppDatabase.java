package ru.mrlargha.commonui.domain.db;

import android.content.Context;
import androidx.room.RoomDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.domain.db.inventory.InventoryItemDao;
/* compiled from: AppDatabase.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/domain/db/AppDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "inventoryItemDao", "Lru/mrlargha/commonui/domain/db/inventory/InventoryItemDao;", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class AppDatabase extends RoomDatabase {
    public static final Companion Companion = new Companion(null);
    private static final Object LOCK = new Object();
    private static volatile AppDatabase instance;

    public abstract InventoryItemDao inventoryItemDao();

    /* compiled from: AppDatabase.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0086\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/domain/db/AppDatabase$Companion;", "", "<init>", "()V", "instance", "Lru/mrlargha/commonui/domain/db/AppDatabase;", "LOCK", "invoke", "context", "Landroid/content/Context;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AppDatabase invoke(Context context) {
            AppDatabase appDatabase;
            Intrinsics.checkNotNullParameter(context, "context");
            AppDatabase appDatabase2 = AppDatabase.instance;
            if (appDatabase2 == null) {
                synchronized (AppDatabase.LOCK) {
                    appDatabase = AppDatabase.instance;
                    if (appDatabase == null) {
                        appDatabase = Database.INSTANCE.build(context);
                        Companion companion = AppDatabase.Companion;
                        AppDatabase.instance = appDatabase;
                    }
                }
                return appDatabase;
            }
            return appDatabase2;
        }
    }
}
