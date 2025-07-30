package io.appmetrica.analytics.impl;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.util.concurrent.Callable;
/* loaded from: classes4.dex */
public final class Ta implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ua f651a;

    public Ta(Ua ua) {
        this.f651a = ua;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Uri parse = Uri.parse("content://com.huawei.appmarket.commondata/item/5");
        ContentResolver contentResolver = this.f651a.f669a.getContentResolver();
        Ua ua = this.f651a;
        ua.b = contentResolver.query(parse, null, null, new String[]{ua.f669a.getPackageName()}, null);
        Cursor cursor = this.f651a.b;
        if (cursor == null || !cursor.moveToFirst()) {
            return null;
        }
        String string = this.f651a.b.getString(0);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new Ag(string, this.f651a.b.getLong(1), this.f651a.b.getLong(2), EnumC0760zg.d);
    }
}
