package com.liulishuo.okdownload.core.breakpoint;

import android.content.Context;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LauncherBreakpointStoreOnSQLite.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0012\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\b¨\u0006\t"}, d2 = {"Lcom/liulishuo/okdownload/core/breakpoint/LauncherBreakpointStoreOnSQLite;", "Lcom/liulishuo/okdownload/core/breakpoint/BreakpointStoreOnSQLite;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "helper", "Lcom/liulishuo/okdownload/core/breakpoint/BreakpointSQLiteHelper;", "(Lcom/liulishuo/okdownload/core/breakpoint/BreakpointSQLiteHelper;)V", "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LauncherBreakpointStoreOnSQLite extends BreakpointStoreOnSQLite {
    public static final int $stable = 8;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LauncherBreakpointStoreOnSQLite(Context context) {
        this(new BreakpointSQLiteHelper(context.getApplicationContext()));
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private LauncherBreakpointStoreOnSQLite(BreakpointSQLiteHelper breakpointSQLiteHelper) {
        super(breakpointSQLiteHelper, new BreakpointStoreOnCache(r1, r2, r3, r4, r0, new LauncherKeyToIdMap()));
        SparseArray<BreakpointInfo> loadToCache = breakpointSQLiteHelper.loadToCache();
        List<Integer> loadDirtyFileList = breakpointSQLiteHelper.loadDirtyFileList();
        HashMap<String, String> loadResponseFilenameToMap = breakpointSQLiteHelper.loadResponseFilenameToMap();
        SparseArray sparseArray = new SparseArray();
        ArrayList arrayList = new ArrayList(breakpointSQLiteHelper.loadToCache().size());
        int size = breakpointSQLiteHelper.loadToCache().size();
        for (int i = 0; i < size; i++) {
            arrayList.add(Integer.valueOf(breakpointSQLiteHelper.loadToCache().valueAt(i).id));
        }
        Unit unit = Unit.INSTANCE;
    }
}
