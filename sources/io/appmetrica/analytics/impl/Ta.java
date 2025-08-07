package io.appmetrica.analytics.impl;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.util.concurrent.Callable;
/* loaded from: classes4.dex */
public final class Ta implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ua f650a;

    public Ta(Ua ua) {
        this.f650a = ua;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Uri parse = Uri.parse("content://com.huawei.appmarket.commondata/item/5");
        ContentResolver contentResolver = this.f650a.f668a.getContentResolver();
        Ua ua = this.f650a;
        ua.b = contentResolver.query(parse, null, null, new String[]{ua.f668a.getPackageName()}, null);
        Cursor cursor = this.f650a.b;
        if (cursor == null || !cursor.moveToFirst()) {
            return null;
        }
        String string = this.f650a.b.getString(0);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new Ag(string, this.f650a.b.getLong(1), this.f650a.b.getLong(2), EnumC0761zg.d);
    }
}
